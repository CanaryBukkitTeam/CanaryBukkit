/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit.implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import lexteam.minecraft.canarybukkit.data.Constants;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import lexteam.minecraft.canarybukkit.implementation.help.CanaryHelpMap;
import lexteam.minecraft.canarybukkit.implementation.util.CanaryCachedServerIcon;
import net.canarymod.Canary;
import net.canarymod.config.Configuration;
import net.canarymod.logger.Logman;
import net.visualillusionsent.minecraft.plugin.canary.WrappedLogger;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.Validate;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.bukkit.util.permissions.DefaultPermissions;

import com.avaje.ebean.config.ServerConfig;

public class CanaryServer implements Server {
    private net.canarymod.api.Server server;
    private String canaryBukkitVersion;
    private final SimpleCommandMap commandMap = new SimpleCommandMap(this);
    private PluginManager pluginManager = new SimplePluginManager(this, commandMap);
    private final CanaryHelpMap helpMap = new CanaryHelpMap(this);
    private final StandardMessenger messenger = new StandardMessenger();
    private final ServicesManager servicesManager = new SimpleServicesManager();
    private Logman logman;
    private YamlConfiguration config;

    public CanaryServer(net.canarymod.api.Server server, Logman logman, String canaryBukkitVersion) {
        this.server = server;
        this.logman = logman;
        this.canaryBukkitVersion = canaryBukkitVersion;

        Bukkit.setServer(this);

        config = YamlConfiguration.loadConfiguration(Constants.configFile);
        config.options().copyDefaults(true);
        config.setDefaults(YamlConfiguration.loadConfiguration(getClass().getClassLoader()
                .getResourceAsStream("config/config.yml")));
        saveConfigFile(config, Constants.configFile);
    }

    public void start() {
        // Start loading plugins
        loadPlugins();
        enablePlugins(PluginLoadOrder.STARTUP);

        // Finish loading plugins
        enablePlugins(PluginLoadOrder.POSTWORLD);
        commandMap.registerServerAliases();
    }

    private void saveConfigFile(YamlConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException ex) {
            logman.warn("Could not save " + config, ex);
        }
    }

    public void loadPlugins() {
        pluginManager.registerInterface(JavaPluginLoader.class);

        Plugin[] plugins = pluginManager.loadPlugins(Constants.pluginsDir);
        for (Plugin plugin : plugins) {
            try {
                String message = String.format("Loading %s", plugin.getDescription().getFullName());
                logman.info(message);
                plugin.onLoad();
            } catch (Throwable ex) {
                logman.warn(ex.getMessage() + " initializing " + plugin.getDescription().getFullName()
                        + " (Is it up to date?)", ex);
            }
        }
    }

    private void loadPlugin(Plugin plugin) {
        try {
            pluginManager.enablePlugin(plugin);

            List<Permission> perms = plugin.getDescription().getPermissions();
            for (Permission perm : perms) {
                try {
                    pluginManager.addPermission(perm);
                } catch (IllegalArgumentException ex) {
                    logman.warn("Plugin " + plugin.getDescription().getFullName()
                            + " tried to register permission '" + perm.getName()
                            + "' but it's already registered", ex);
                }
            }
        } catch (Throwable ex) {
            logman.warn(ex.getMessage() + " loading " + plugin.getDescription().getFullName()
                    + " (Is it up to date?)", ex);
        }
    }

    public void enablePlugins(PluginLoadOrder type) {
        if (type == PluginLoadOrder.STARTUP) {
            helpMap.clear();
        }

        for (Plugin plugin : pluginManager.getPlugins()) {
            if ((!plugin.isEnabled()) && (plugin.getDescription().getLoad() == type)) {
                loadPlugin(plugin);
            }
        }

        if (type == PluginLoadOrder.POSTWORLD) {
            commandMap.setFallbackCommands();
            commandMap.registerServerAliases();
            DefaultPermissions.registerCorePermissions();
        }
    }

    public void disablePlugins() {
        pluginManager.disablePlugins();
    }

    public String getName() {
        return Canary.getImplementationTitle();
    }

    public String getImplementationName() {
        return "CanaryBukkit";
    }

    public String getVersion() {
        return Canary.getImplementationVersion();
    }

    public String getImplementationVersion() {
        return canaryBukkitVersion;
    }

    public String getBukkitVersion() {
        return Constants.bukkitVersion;
    }

    public Player[] getOnlinePlayers() {
        CanaryPlayer[] players = new CanaryPlayer[server.getPlayerList().size()];
        int i = 0;
        for (net.canarymod.api.entity.living.humanoid.Player player : server.getPlayerList()) {
            players[i] = new CanaryPlayer(player);
            i++;
        }
        return players;
    }

    public OfflinePlayer[] getOfflinePlayers() {
        throw new NotImplementedException();
    }

    public int getMaxPlayers() {
        return Configuration.getServerConfig().getMaxPlayers();
    }

    public int getPort() {
        return Configuration.getServerConfig().getPort();
    }

    public int getViewDistance() {
        return Configuration.getServerConfig().getViewDistance();
    }

    public String getIp() {
        return Configuration.getServerConfig().getBindIp();
    }

    public String getServerName() {
        return server.getName();
    }

    public String getServerId() {
        throw new NotImplementedException();
    }

    public String getWorldType() {
        return server.getDefaultWorld().getType().getName();
    }

    public boolean getGenerateStructures() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).generatesStructures();
    }

    public boolean getAllowEnd() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isEndAllowed();
    }

    public boolean getAllowNether() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isNetherAllowed();
    }

    public boolean hasWhitelist() {
        return Configuration.getServerConfig().isWhitelistEnabled();
    }

    public void setWhitelist(boolean value) {
        Configuration.getServerConfig().getFile().setBoolean("whitelist-enabled", value);
    }

    public Set<OfflinePlayer> getWhitelistedPlayers() {
        Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
        for (String name : Canary.whitelist().getWhitelisted()) {
            players.add(new CanaryOfflinePlayer(Canary.getServer().getOfflinePlayer(name)));
        }
        return players;
    }

    public void reloadWhitelist() {
        Canary.whitelist().reload();
    }

    public int broadcastMessage(String message) {
        return broadcast(message, BROADCAST_CHANNEL_USERS);
    }

    public String getUpdateFolder() {
        return this.config.getString("settings.update-folder", "update");
    }

    public File getUpdateFolderFile() {
        return new File(Constants.pluginsDir, this.config.getString("settings.update-folder", "update"));
    }

    public long getConnectionThrottle() {
        return 0;
    }

    public int getTicksPerAnimalSpawns() {
        return 0;
    }

    public int getTicksPerMonsterSpawns() {
        return 0;
    }

    public Player getPlayer(String name) {
        // TODO: Look at difference between getPlayerExact and getPlayer.
        Validate.notNull(name, "Name cannot be null");

        String lname = name.toLowerCase();
        for (Player player : getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(lname)) {
                return player;
            }
        }
        return null;
    }

    public Player getPlayerExact(String name) {
        Validate.notNull(name, "Name cannot be null");

        String lname = name.toLowerCase();
        for (Player player : getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(lname)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> matchPlayer(String partialName) {
        Validate.notNull(partialName, "PartialName cannot be null");

        List<Player> matchedPlayers = new ArrayList<Player>();
        for (Player player : this.getOnlinePlayers()) {
            String playerName = player.getName();

            if (partialName.equalsIgnoreCase(playerName)) {
                // Exact match
                matchedPlayers.clear();
                matchedPlayers.add(player);
            } else if (playerName.toLowerCase().contains(partialName.toLowerCase())) {
                // Partial match
                matchedPlayers.add(player);
            }
        }
        return matchedPlayers;
    }

    public Player getPlayer(UUID id) {
        for (Player player : getOnlinePlayers()) {
            if (player.getUniqueId().equals(id)) {
                return player;
            }
        }
        return null;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public BukkitScheduler getScheduler() {
        throw new NotImplementedException();
    }

    public ServicesManager getServicesManager() {
        return servicesManager;
    }

    public List<World> getWorlds() {
        List<World> worlds = new ArrayList<World>();
        for (net.canarymod.api.world.World world : Canary.getServer().getWorldManager().getAllWorlds()) {
            World bWorld = new CanaryWorld(world);
            worlds.add(bWorld);
        }
        return worlds;
    }

    public World createWorld(WorldCreator creator) {
        throw new NotImplementedException();
    }

    public boolean unloadWorld(String name, boolean save) {
        return false;
    }

    public boolean unloadWorld(World world, boolean save) {
        return false;
    }

    public World getWorld(String name) {
        return new CanaryWorld(server.getWorld(name));
    }

    public World getWorld(UUID uid) {
        throw new NotImplementedException();
    }

    public MapView getMap(short id) {
        throw new NotImplementedException();
    }

    public MapView createMap(World world) {
        throw new NotImplementedException();
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(Constants.configFile);
        // TODO: More reload stuff.

        server.restart(true);
    }

    public Logger getLogger() {
        return new WrappedLogger(logman);
    }

    public PluginCommand getPluginCommand(String name) {
        Command command = commandMap.getCommand(name);

        if (command instanceof PluginCommand) {
            return (PluginCommand) command;
        } else {
            return null;
        }
    }

    public void savePlayers() {
        throw new NotImplementedException();
    }

    public boolean dispatchCommand(CommandSender sender, String commandLine) {
        Validate.notNull(sender, "Sender cannot be null");
        Validate.notNull(commandLine, "CommandLine cannot be null");

        if (commandLine.startsWith("/")) {
            commandLine = commandLine.substring(1);
        }
        if (commandMap.dispatch(sender, commandLine)) {
            return true;
        }
        return false;
    }

    public void configureDbConfig(ServerConfig config) {
        throw new NotImplementedException();
    }

    public boolean addRecipe(Recipe recipe) {
        return false;
    }

    public List<Recipe> getRecipesFor(ItemStack result) {
        throw new NotImplementedException();
    }

    public Iterator<Recipe> recipeIterator() {
        throw new NotImplementedException();
    }

    public void clearRecipes() {
        throw new NotImplementedException();
    }

    public void resetRecipes() {
        throw new NotImplementedException();
    }

    public Map<String, String[]> getCommandAliases() {
        Map<String, String[]> result = new LinkedHashMap<String, String[]>();
        return result;
    }

    public int getSpawnRadius() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).getSpawnProtectionSize();
    }

    public void setSpawnRadius(int value) {
        throw new NotImplementedException();
    }

    public boolean getOnlineMode() {
        return Configuration.getServerConfig().isOnlineMode();
    }

    public boolean getAllowFlight() {
        return false;
    }

    public boolean isHardcore() {
        return false;
    }

    public boolean useExactLoginLocation() {
        return false;
    }

    public void shutdown() {
        server.initiateShutdown(config.getString("shutdown-message"));
    }

    public int broadcast(String message, String permission) {
        int count = 0;
        Set<Permissible> permissibles = getPluginManager().getPermissionSubscriptions(permission);

        for (Permissible permissible : permissibles) {
            if (permissible instanceof CommandSender && permissible.hasPermission(permission)) {
                CommandSender user = (CommandSender) permissible;
                user.sendMessage(message);
                count++;
            }
        }
        return count;
    }

    public OfflinePlayer getOfflinePlayer(String name) {
        throw new NotImplementedException();
    }

    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new NotImplementedException();
    }

    public Set<String> getIPBans() {
        throw new NotImplementedException();
    }

    public void banIP(String address) {
        throw new NotImplementedException();
    }

    public void unbanIP(String address) {
        throw new NotImplementedException();
    }

    public Set<OfflinePlayer> getBannedPlayers() {
        throw new NotImplementedException();
    }

    public BanList getBanList(BanList.Type type) {
        throw new NotImplementedException();
    }

    public Set<OfflinePlayer> getOperators() {
        Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
        for (String name : Canary.ops().getOps()) {
            players.add(new CanaryOfflinePlayer(Canary.getServer().getOfflinePlayer(name)));
        }
        return players;
    }

    public GameMode getDefaultGameMode() {
        throw new NotImplementedException();
    }

    public void setDefaultGameMode(GameMode mode) {
        throw new NotImplementedException();
    }

    public ConsoleCommandSender getConsoleSender() {
        throw new NotImplementedException();
    }

    public File getWorldContainer() {
        return Constants.worldsDir;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public HelpMap getHelpMap() {
        return helpMap;
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, int size, String title)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public int getMonsterSpawnLimit() {
        return 0;
    }

    public int getAnimalSpawnLimit() {
        return 0;
    }

    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    public int getAmbientSpawnLimit() {
        return 0;
    }

    public boolean isPrimaryThread() {
        return false;
    }

    public String getMotd() {
        return Configuration.getServerConfig().getMotd();
    }

    public String getShutdownMessage() {
        return config.getString("shutdown-message");
    }

    public WarningState getWarningState() {
        throw new NotImplementedException();
    }

    public ItemFactory getItemFactory() {
        throw new NotImplementedException();
    }

    public ScoreboardManager getScoreboardManager() {
        throw new NotImplementedException();
    }

    public CachedServerIcon getServerIcon() {
        return new CanaryCachedServerIcon();
    }

    public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
    }

    public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
    }

    public void setIdleTimeout(int threshold) {
        throw new NotImplementedException();
    }

    public int getIdleTimeout() {
        return 0;
    }

    @Deprecated
    public CanaryUnsafeValues getUnsafe() {
        return new CanaryUnsafeValues();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        StandardMessenger.validatePluginMessage(getMessenger(), source, channel, message);

        for (Player player : getOnlinePlayers()) {
            player.sendPluginMessage(source, channel, message);
        }
    }

    public Set<String> getListeningPluginChannels() {
        Set<String> result = new HashSet<String>();

        for (Player player : getOnlinePlayers()) {
            result.addAll(player.getListeningPluginChannels());
        }
        return result;
    }
}