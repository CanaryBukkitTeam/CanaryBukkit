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
package lexteam.minecraft.canarybukkit.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import lexteam.minecraft.canarybukkit.data.Constants;
import lexteam.minecraft.canarybukkit.impl.entity.CanaryPlayer;
import lexteam.minecraft.canarybukkit.impl.help.CanaryHelpMap;
import lexteam.minecraft.canarybukkit.impl.scheduler.CanaryScheduler;
import lexteam.minecraft.canarybukkit.impl.util.CanaryCachedServerIcon;
import net.canarymod.Canary;
import net.canarymod.config.Configuration;
import net.canarymod.logger.Logman;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.Validate;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
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
    private final BukkitScheduler scheduler = new CanaryScheduler();
    private final CanaryHelpMap helpMap = new CanaryHelpMap(Canary.help());
    private Logman logman;
    private YamlConfiguration config;
    /**
     * An empty player array used for deprecated getOnlinePlayers.
     */
    private final Player[] EMPTY_PLAYER_ARRAY = new Player[0];

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
        throw new NotImplementedException("addRecipe(Recipe)");
    }

    public void banIP(String address) {
        Validate.notNull(address, "Address cannot be null.");

        this.getBanList(Type.IP).addBan(address, null, null, null);
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
        throw new NotImplementedException("clearRecipes()");
    }

    public void configureDbConfig(ServerConfig config) {
        throw new NotImplementedException("configureDbConfig(ServerConfig)");
    }

    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new NotImplementedException("createInventory(InventoryHolder, int)");
    }

    public Inventory createInventory(InventoryHolder owner, int size, String title)
            throws IllegalArgumentException {
        throw new NotImplementedException("createInventory(InventoryHolder, int, String)");
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new NotImplementedException("createInventory(InventoryHolder, InventoryType)");
    }

    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new NotImplementedException("createInventory(InventoryHolder, InventoryType, String)");
    }

    public MapView createMap(World world) {
        throw new NotImplementedException("createMap(World)");
    }

    public World createWorld(WorldCreator creator) {
        throw new NotImplementedException("createWorld(WorldCreator)");
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
        return commandMap.dispatch(sender, commandLine);
    }

    public void enablePlugins(PluginLoadOrder type) {
        if (type == PluginLoadOrder.STARTUP) {
            //helpMap.clear();
        }

        for (Plugin plugin : pluginManager.getPlugins()) {
            if (!plugin.isEnabled() && plugin.getDescription().getLoad() == type) {
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
        // TODO MW support -.-
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isEndAllowed();
    }

    public boolean getAllowFlight() {
        throw new NotImplementedException("getAllowFlight()");
    }

    public boolean getAllowNether() {
        // TODO MW support -.-
        return Configuration.getWorldConfig(server.getDefaultWorldName()).isNetherAllowed();
    }

    public int getAmbientSpawnLimit() {
        throw new NotImplementedException("getAmbientSpawnLimit()");
    }

    public int getAnimalSpawnLimit() {
        throw new NotImplementedException("getAnimalSpawnLimit()");
    }

    public BanList getBanList(BanList.Type type) {
        Validate.notNull(type, "Type cannot be null");
        
        return new CanaryBanList(Canary.bans(), type);
    }

    public Set<OfflinePlayer> getBannedPlayers() {
        throw new NotImplementedException("getBannedPlayers()");
    }

    public String getBukkitVersion() {
        return Constants.bukkitVersion;
    }

    public Player[] _INVALID_getOnlinePlayers() {
        return getOnlinePlayers().toArray(EMPTY_PLAYER_ARRAY);
    }

    public Map<String, String[]> getCommandAliases() {
        Map<String, String[]> result = new LinkedHashMap<String, String[]>();
        return result;
    }

    public long getConnectionThrottle() {
        throw new NotImplementedException("getConnectionThrottle()");
    }

    public ConsoleCommandSender getConsoleSender() {
        throw new NotImplementedException("getConsoleSender()");
    }

    public GameMode getDefaultGameMode() {
        throw new NotImplementedException("getDefaultGameMode()");
    }

    public boolean getGenerateStructures() {
        // TODO MW support -.-
        return Configuration.getWorldConfig(server.getDefaultWorldName()).generatesStructures();
    }

    public HelpMap getHelpMap() {
        throw new NotImplementedException("getHelpMap()");
    }

    public int getIdleTimeout() {
        return Configuration.getServerConfig().getPlayerIdleTimeout();
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
        Set<String> ipBans = new HashSet<String>();
        
        for(BanEntry entry : this.getBanList(Type.IP).getBanEntries()) {
            ipBans.add(entry.getTarget());
        }
        
        return ipBans;
    }

    public ItemFactory getItemFactory() {
        throw new NotImplementedException("getItemFactory()");
    }

    public Set<String> getListeningPluginChannels() {
        Set<String> result = new HashSet<String>();

        for (Player player : getOnlinePlayers()) {
            result.addAll(player.getListeningPluginChannels());
        }
        return result;
    }

    public Logger getLogger() {
        // TODO
        return Logger.getLogger("CanaryBukkit");
    }

    public MapView getMap(short id) {
        throw new NotImplementedException("getMap(short id)");
    }

    public int getMaxPlayers() {
        return Configuration.getServerConfig().getMaxPlayers();
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public int getMonsterSpawnLimit() {
        throw new NotImplementedException("getMonsterSpawnLimit()");
    }

    public String getMotd() {
        return Configuration.getServerConfig().getMotd();
    }

    public String getName() {
        return getImplementationName() + "_" + Canary.getSpecificationTitle() + "_"
                + Canary.getImplementationTitle();
    }

    public OfflinePlayer getOfflinePlayer(String name) {
        throw new NotImplementedException("getOfflinePlayer(String)");
    }

    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new NotImplementedException("getOfflinePlayer(UUID)");
    }

    public OfflinePlayer[] getOfflinePlayers() {
        throw new NotImplementedException("getOfflinePlayers()");
    }

    public boolean getOnlineMode() {
        return Configuration.getServerConfig().isOnlineMode();
    }

    public Collection<? extends Player> getOnlinePlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        for (net.canarymod.api.entity.living.humanoid.Player player : server.getPlayerList()) {
            players.add(new CanaryPlayer(player));
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
        Validate.notNull(id, "UUID cannot be null");

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
        throw new NotImplementedException("getRecipesFor(ItemStack result)");
    }

    public BukkitScheduler getScheduler() {
        return scheduler;
    }

    public ScoreboardManager getScoreboardManager() {
        throw new NotImplementedException("getScoreboardManager()");
    }

    public CachedServerIcon getServerIcon() {
        return new CanaryCachedServerIcon();
    }

    public String getServerId() {
        throw new NotImplementedException("getServerId()");
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
        throw new NotImplementedException("getTicksPerAnimalSpawns()");
    }

    public int getTicksPerMonsterSpawns() {
        throw new NotImplementedException("getTicksPerMonsterSpawns()");
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
        return "canarybukkit_" + Canary.getImplementationVersion() + " (MC: " + server.getServerVersion()
                + ")";
    }

    public int getViewDistance() {
        return Configuration.getServerConfig().getViewDistance();
    }

    public WarningState getWarningState() {
        throw new NotImplementedException("getWarningState()");
    }

    public int getWaterAnimalSpawnLimit() {
        throw new NotImplementedException("getWaterAnimalSpawnLimit()");
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
        throw new NotImplementedException("getWorld(UUID)");
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
        throw new NotImplementedException("isHardcore()");
    }

    public boolean isPrimaryThread() {
        throw new NotImplementedException("isPrimaryThread()");
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
        throw new NotImplementedException("loadServerIcon(BufferedImage)");
    }

    public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        throw new NotImplementedException("loadServerIcon(File)");
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
        throw new NotImplementedException("recipeIterator()");
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
        throw new NotImplementedException("resetRecipes()");
    }

    private void saveConfigFile(YamlConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException ex) {
            logman.warn("Could not save " + config, ex);
        }
    }

    public void savePlayers() {
        throw new NotImplementedException("savePlayers()");
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        StandardMessenger.validatePluginMessage(getMessenger(), source, channel, message);

        for (Player player : getOnlinePlayers()) {
            player.sendPluginMessage(source, channel, message);
        }
    }

    public void setDefaultGameMode(GameMode mode) {
        throw new NotImplementedException("setDefaultGameMode(GameMode)");
    }

    public void setIdleTimeout(int threshold) {
        Configuration.getServerConfig().setPlayerIdleTimeout(threshold);
    }

    public void setSpawnRadius(int value) {
        throw new NotImplementedException("setSpawnRadius(int)");
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
