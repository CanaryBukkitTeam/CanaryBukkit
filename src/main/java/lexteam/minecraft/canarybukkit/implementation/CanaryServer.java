/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014 Lexteam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
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
import lexteam.minecraft.canarybukkit.implementation.util.CanaryCachedServerIcon;
import net.canarymod.Canary;
import net.canarymod.config.Configuration;
import net.canarymod.logger.Logman;

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

    public boolean addRecipe(Recipe recipe) {
        return false;
    }

    public void banIP(String address) {
        throw new NotImplementedException();
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

    public int broadcastMessage(String message) {
        return broadcast(message, BROADCAST_CHANNEL_USERS);
    }

    public void clearRecipes() {
        throw new NotImplementedException();
    }

    public void configureDbConfig(ServerConfig config) {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, int size, String title)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new NotImplementedException();
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new NotImplementedException();
    }

    public MapView createMap(World world) {
        throw new NotImplementedException();
    }

    public World createWorld(WorldCreator creator) {
        throw new NotImplementedException();
    }

    public void disablePlugins() {
        pluginManager.disablePlugins();
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

    public void enablePlugins(PluginLoadOrder type) {
        if (type == PluginLoadOrder.STARTUP) {
            // helpMap.clear();
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

    public boolean getAllowEnd() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isEndAllowed();
    }

    public boolean getAllowFlight() {
        return false;
    }

    public boolean getAllowNether() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isNetherAllowed();
    }

    public int getAmbientSpawnLimit() {
        return 0;
    }

    public int getAnimalSpawnLimit() {
        return 0;
    }

    public BanList getBanList(BanList.Type type) {
        throw new NotImplementedException();
    }

    public Set<OfflinePlayer> getBannedPlayers() {
        throw new NotImplementedException();
    }

    public String getBukkitVersion() {
        return Constants.bukkitVersion;
    }

    public Map<String, String[]> getCommandAliases() {
        Map<String, String[]> result = new LinkedHashMap<String, String[]>();
        return result;
    }

    public long getConnectionThrottle() {
        return 0;
    }

    public ConsoleCommandSender getConsoleSender() {
        throw new NotImplementedException();
    }

    public GameMode getDefaultGameMode() {
        throw new NotImplementedException();
    }

    public boolean getGenerateStructures() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).generatesStructures();
    }

    public HelpMap getHelpMap() {
        throw new NotImplementedException();
    }

    public int getIdleTimeout() {
        return 0;
    }

    public String getImplementationName() {
        return "CanaryBukkit";
    }

    public String getImplementationVersion() {
        return canaryBukkitVersion;
    }

    public String getIp() {
        return Configuration.getServerConfig().getBindIp();
    }

    public Set<String> getIPBans() {
        throw new NotImplementedException();
    }

    public ItemFactory getItemFactory() {
        throw new NotImplementedException();
    }

    public Set<String> getListeningPluginChannels() {
        Set<String> result = new HashSet<String>();

        for (Player player : getOnlinePlayers()) {
            result.addAll(player.getListeningPluginChannels());
        }
        return result;
    }

    public Logger getLogger() {
        return Logger.getLogger("CanaryBukkit");
    }

    public MapView getMap(short id) {
        throw new NotImplementedException();
    }

    public int getMaxPlayers() {
        return Configuration.getServerConfig().getMaxPlayers();
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public int getMonsterSpawnLimit() {
        return 0;
    }

    public String getMotd() {
        return Configuration.getServerConfig().getMotd();
    }

    public String getName() {
        return Canary.getImplementationTitle();
    }

    public OfflinePlayer getOfflinePlayer(String name) {
        throw new NotImplementedException();
    }

    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new NotImplementedException();
    }

    public OfflinePlayer[] getOfflinePlayers() {
        throw new NotImplementedException();
    }

    public boolean getOnlineMode() {
        return Configuration.getServerConfig().isOnlineMode();
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

    public Set<OfflinePlayer> getOperators() {
        Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
        for (String name : Canary.ops().getOps()) {
            players.add(new CanaryOfflinePlayer(Canary.getServer().getOfflinePlayer(name)));
        }
        return players;
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

    public Player getPlayer(UUID id) {
        for (Player player : getOnlinePlayers()) {
            if (player.getUniqueId().equals(id)) {
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

    public PluginCommand getPluginCommand(String name) {
        Command command = commandMap.getCommand(name);

        if (command instanceof PluginCommand) {
            return (PluginCommand) command;
        } else {
            return null;
        }
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public int getPort() {
        return Configuration.getServerConfig().getPort();
    }

    public List<Recipe> getRecipesFor(ItemStack result) {
        throw new NotImplementedException();
    }

    public BukkitScheduler getScheduler() {
        throw new NotImplementedException();
    }

    public ScoreboardManager getScoreboardManager() {
        throw new NotImplementedException();
    }

    public CachedServerIcon getServerIcon() {
        return new CanaryCachedServerIcon();
    }

    public String getServerId() {
        throw new NotImplementedException();
    }

    public String getServerName() {
        return server.getName();
    }

    public ServicesManager getServicesManager() {
        return servicesManager;
    }

    public String getShutdownMessage() {
        return config.getString("shutdown-message");
    }

    public int getSpawnRadius() {
        return Configuration.getWorldConfig(server.getDefaultWorldName()).getSpawnProtectionSize();
    }

    public int getTicksPerAnimalSpawns() {
        return 0;
    }

    public int getTicksPerMonsterSpawns() {
        return 0;
    }

    @Deprecated
    public CanaryUnsafeValues getUnsafe() {
        return new CanaryUnsafeValues();
    }

    public String getUpdateFolder() {
        return this.config.getString("settings.update-folder", "update");
    }

    public File getUpdateFolderFile() {
        return new File(Constants.pluginsDir, this.config.getString("settings.update-folder", "update"));
    }

    public String getVersion() {
        return Canary.getImplementationVersion();
    }

    public int getViewDistance() {
        return Configuration.getServerConfig().getViewDistance();
    }

    public WarningState getWarningState() {
        throw new NotImplementedException();
    }

    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    public Set<OfflinePlayer> getWhitelistedPlayers() {
        Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
        for (String name : Canary.whitelist().getWhitelisted()) {
            players.add(new CanaryOfflinePlayer(Canary.getServer().getOfflinePlayer(name)));
        }
        return players;
    }

    public World getWorld(String name) {
        return new CanaryWorld(server.getWorld(name));
    }

    public World getWorld(UUID uid) {
        throw new NotImplementedException();
    }

    public File getWorldContainer() {
        return Constants.worldsDir;
    }

    public List<World> getWorlds() {
        List<World> worlds = new ArrayList<World>();
        for (net.canarymod.api.world.World world : Canary.getServer().getWorldManager().getAllWorlds()) {
            World bWorld = new CanaryWorld(world);
            worlds.add(bWorld);
        }
        return worlds;
    }

    public String getWorldType() {
        return server.getDefaultWorld().getType().getName();
    }

    public boolean hasWhitelist() {
        return Configuration.getServerConfig().isWhitelistEnabled();
    }

    public boolean isHardcore() {
        return false;
    }

    public boolean isPrimaryThread() {
        return false;
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

    public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
    }

    public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
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

    public Iterator<Recipe> recipeIterator() {
        throw new NotImplementedException();
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(Constants.configFile);
        // TODO: More reload stuff.

        server.restart(true);
    }

    public void reloadWhitelist() {
        Canary.whitelist().reload();
    }

    public void resetRecipes() {
        throw new NotImplementedException();
    }

    private void saveConfigFile(YamlConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException ex) {
            logman.warn("Could not save " + config, ex);
        }
    }

    public void savePlayers() {
        throw new NotImplementedException();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        StandardMessenger.validatePluginMessage(getMessenger(), source, channel, message);

        for (Player player : getOnlinePlayers()) {
            player.sendPluginMessage(source, channel, message);
        }
    }

    public void setDefaultGameMode(GameMode mode) {
        throw new NotImplementedException();
    }

    public void setIdleTimeout(int threshold) {
        throw new NotImplementedException();
    }

    public void setSpawnRadius(int value) {
        throw new NotImplementedException();
    }

    public void setWhitelist(boolean value) {
        Configuration.getServerConfig().getFile().setBoolean("whitelist-enabled", value);
    }

    public void shutdown() {
        server.initiateShutdown(config.getString("shutdown-message"));
    }

    public void start() {
        // Start loading plugins
        loadPlugins();
        enablePlugins(PluginLoadOrder.STARTUP);

        // Finish loading plugins
        enablePlugins(PluginLoadOrder.POSTWORLD);
        commandMap.registerServerAliases();
    }

    public void unbanIP(String address) {
        Canary.bans().unban(address);
    }

    public boolean unloadWorld(String name, boolean save) {
        return false;
    }

    public boolean unloadWorld(World world, boolean save) {
        return false;
    }

    public boolean useExactLoginLocation() {
        return false;
    }
}