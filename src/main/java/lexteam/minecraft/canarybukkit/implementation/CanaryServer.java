package lexteam.minecraft.canarybukkit.implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

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
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;

public class CanaryServer implements Server {

	private net.canarymod.api.Server server;
	private PluginManager pluginManager;
	private Logman logman;

	public CanaryServer(net.canarymod.api.Server server, Logman logman) {
		this.server = server;
		this.logman = logman;
		this.pluginManager = new SimplePluginManager(this, new SimpleCommandMap(this));
	}

	public String getName() {
		return "CanaryMod";
	}

	public String getVersion() {
		return "1.0.0.1 (Bukkit: " + Bukkit.getBukkitVersion() + ")";
	}

	public String getBukkitVersion() {
		return "CanaryBukkit-" + getVersion();
	}

	public Player[] getOnlinePlayers() {
		return server.getPlayerList().toArray(new Player[]{});
	}

	public int getMaxPlayers() {
		return Configuration.getServerConfig().getMaxPlayers();
	}

	public int getPort() {
		return Configuration.getServerConfig().getPort();
	}

	public int getViewDistance() {
		return 0;
	}

	public String getIp() {
		return Configuration.getServerConfig().getBindIp();
	}

	public String getServerName() {
		return "Just a CanaryMod Server";
	}

	public String getServerId() {
		throw new NotImplementedException();
	}

	public String getWorldType() {
		throw new NotImplementedException();
	}

	public boolean getGenerateStructures() {
		return false;
	}

	public boolean getAllowEnd() {
		return false;
	}

	public boolean getAllowNether() {
		return false;
	}

	public boolean hasWhitelist() {
		return Configuration.getServerConfig().isWhitelistEnabled();
	}

	public void setWhitelist(boolean value) {
		throw new NotImplementedException();
	}

	public Set<OfflinePlayer> getWhitelistedPlayers() {
		/*Set<OfflinePlayer> players = null;
		for(String name : Canary.whitelist().getWhitelisted()) {
			OfflinePlayer player = new CanaryOfflinePlayer(Canary.getServer().getOfflinePlayer(name));
			players.add(player);
		}
		return players;*/
		throw new NotImplementedException();
	}

	public void reloadWhitelist() {
		Canary.whitelist().reload();
	}

	public int broadcastMessage(String message) {
		return broadcast(message, BROADCAST_CHANNEL_USERS);
	}

	public String getUpdateFolder() {
		return new File(".", "bukkit" + File.separator + "plugins").toString();
	}

	public File getUpdateFolderFile() {
		return new File(".", "bukkit" + File.separator + "plugins");
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
		throw new NotImplementedException();
	}

	public Player getPlayerExact(String name) {
		Validate.notNull(name, "Name cannot be null");

		String lname = name.toLowerCase();

		for (Player player : getOnlinePlayers()) {
			if (player.getName().equalsIgnoreCase(lname)) {
				return player;
			}
		}

		throw new NotImplementedException();
	}

	public List<Player> matchPlayer(String name) {
		throw new NotImplementedException();
	}

	public Player getPlayer(UUID id) {
		throw new NotImplementedException();
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public BukkitScheduler getScheduler() {
		throw new NotImplementedException();
	}

	public ServicesManager getServicesManager() {
		throw new NotImplementedException();
	}

	public List<World> getWorlds() {
		throw new NotImplementedException();
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

	public CanaryWorld getWorld(String name) {
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
		throw new NotImplementedException();
	}

	public Logger getLogger() {
		return new WrappedLogger(logman);
	}

	public PluginCommand getPluginCommand(String name) {
		throw new NotImplementedException();
	}

	public void savePlayers() {
		throw new NotImplementedException();
	}

	public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
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
		throw new NotImplementedException();
	}

	public int getSpawnRadius() {
		return 0;
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
		server.consoleCommand("stop");
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	public Messenger getMessenger() {
		throw new NotImplementedException();
	}

	public HelpMap getHelpMap() {
		throw new NotImplementedException();
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

	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
	public UnsafeValues getUnsafe() {
		throw new NotImplementedException();
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

	public OfflinePlayer[] getOfflinePlayers() {
		return null;
	}
}