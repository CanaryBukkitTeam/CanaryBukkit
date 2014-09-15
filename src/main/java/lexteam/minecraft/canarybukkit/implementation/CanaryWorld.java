package lexteam.minecraft.canarybukkit.implementation;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CanaryWorld implements World {
	private net.canarymod.api.world.World world;

	public CanaryWorld(net.canarymod.api.world.World world) {
		this.world = world;
	}

	public Block getBlockAt(int x, int y, int z) {
		throw new NotImplementedException();
	}

	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	public int getBlockTypeIdAt(int x, int y, int z) {
		throw new NotImplementedException();
	}

	public int getBlockTypeIdAt(Location location) {
		throw new NotImplementedException();
	}

	public int getHighestBlockYAt(int x, int z) {
		throw new NotImplementedException();
	}

	public int getHighestBlockYAt(Location location) {
		throw new NotImplementedException();
	}

	public Block getHighestBlockAt(int x, int z) {
		throw new NotImplementedException();
	}

	public Block getHighestBlockAt(Location location) {
		throw new NotImplementedException();
	}

	public Chunk getChunkAt(int x, int z) {
		throw new NotImplementedException();
	}

	public Chunk getChunkAt(Location location) {
		return getChunkAt(location.getBlockX(), location.getBlockZ());
	}

	public Chunk getChunkAt(Block block) {
		return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
	}

	public boolean isChunkLoaded(Chunk chunk) {
		throw new NotImplementedException();
	}

	public Chunk[] getLoadedChunks() {
		throw new NotImplementedException();
	}

	public void loadChunk(Chunk chunk) {
		throw new NotImplementedException();
	}

	public boolean isChunkLoaded(int x, int z) {
		throw new NotImplementedException();
	}

	public boolean isChunkInUse(int x, int z) {
		throw new NotImplementedException();
	}

	public void loadChunk(int x, int z) {
		throw new NotImplementedException();
	}

	public boolean loadChunk(int x, int z, boolean generate) {
		throw new NotImplementedException();
	}

	public boolean unloadChunk(Chunk chunk) {
		throw new NotImplementedException();
	}

	public boolean unloadChunk(int x, int z) {
		throw new NotImplementedException();
	}

	public boolean unloadChunk(int x, int z, boolean save) {
		throw new NotImplementedException();
	}

	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		throw new NotImplementedException();
	}

	public boolean unloadChunkRequest(int x, int z) {
		throw new NotImplementedException();
	}

	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		throw new NotImplementedException();
	}

	public boolean regenerateChunk(int x, int z) {
		throw new NotImplementedException();
	}

	public boolean refreshChunk(int x, int z) {
		throw new NotImplementedException();
	}

	public Item dropItem(Location location, ItemStack item) {
		throw new NotImplementedException();
	}

	public Item dropItemNaturally(Location location, ItemStack item) {
		throw new NotImplementedException();
	}

	public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
		throw new NotImplementedException();
	}

	public boolean generateTree(Location location, TreeType type) {
		throw new NotImplementedException();
	}

	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		throw new NotImplementedException();
	}

	public Entity spawnEntity(Location loc, EntityType type) {
		throw new NotImplementedException();
	}

	public LivingEntity spawnCreature(Location loc, EntityType type) {
		throw new NotImplementedException();
	}

	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		throw new NotImplementedException();
	}

	public LightningStrike strikeLightning(Location loc) {
		throw new NotImplementedException();
	}

	public LightningStrike strikeLightningEffect(Location loc) {
		throw new NotImplementedException();
	}

	public List<Entity> getEntities() {
		throw new NotImplementedException();
	}

	public List<LivingEntity> getLivingEntities() {
		throw new NotImplementedException();
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		throw new NotImplementedException();
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		throw new NotImplementedException();
	}

	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		throw new NotImplementedException();
	}

	public List<Player> getPlayers() {
		throw new NotImplementedException();
	}

	public String getName() {
		return world.getName();
	}

	public UUID getUID() {
		throw new NotImplementedException();
	}

	public Location getSpawnLocation() {
		throw new NotImplementedException();
	}

	public boolean setSpawnLocation(int x, int y, int z) {
		throw new NotImplementedException();
	}

	public long getTime() {
		throw new NotImplementedException();
	}

	public void setTime(long time) {
		throw new NotImplementedException();
	}

	public long getFullTime() {
		throw new NotImplementedException();
	}

	public void setFullTime(long time) {
		throw new NotImplementedException();
	}

	public boolean hasStorm() {
		throw new NotImplementedException();
	}

	public void setStorm(boolean hasStorm) {
		throw new NotImplementedException();
	}

	public int getWeatherDuration() {
		throw new NotImplementedException();
	}

	public void setWeatherDuration(int duration) {
		throw new NotImplementedException();
	}

	public boolean isThundering() {
		throw new NotImplementedException();
	}

	public void setThundering(boolean thundering) {
		throw new NotImplementedException();
	}

	public int getThunderDuration() {
		throw new NotImplementedException();
	}

	public void setThunderDuration(int duration) {
		throw new NotImplementedException();
	}

	public boolean createExplosion(double x, double y, double z, float power) {
		throw new NotImplementedException();
	}

	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		throw new NotImplementedException();
	}

	public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
		throw new NotImplementedException();
	}

	public boolean createExplosion(Location loc, float power) {
		throw new NotImplementedException();
	}

	public boolean createExplosion(Location loc, float power, boolean setFire) {
		throw new NotImplementedException();
	}

	public Environment getEnvironment() {
		throw new NotImplementedException();
	}

	public long getSeed() {
		throw new NotImplementedException();
	}

	public boolean getPVP() {
		throw new NotImplementedException();
	}

	public void setPVP(boolean pvp) {
		throw new NotImplementedException();
	}

	public ChunkGenerator getGenerator() {
		throw new NotImplementedException();
	}

	public void save() {
		throw new NotImplementedException();
	}

	public List<BlockPopulator> getPopulators() {
		throw new NotImplementedException();
	}

	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	public void playEffect(Location location, Effect effect, int data) {
		throw new NotImplementedException();
	}

	public void playEffect(Location location, Effect effect, int data, int radius) {
		throw new NotImplementedException();
	}

	public <T> void playEffect(Location location, Effect effect, T data) {
		throw new NotImplementedException();
	}

	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		throw new NotImplementedException();
	}

	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		throw new NotImplementedException();
	}

	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		throw new NotImplementedException();
	}

	public boolean getAllowAnimals() {
		throw new NotImplementedException();
	}

	public boolean getAllowMonsters() {
		throw new NotImplementedException();
	}

	public Biome getBiome(int x, int z) {
		throw new NotImplementedException();
	}

	public void setBiome(int x, int z, Biome bio) {
		throw new NotImplementedException();
	}

	public double getTemperature(int x, int z) {
		throw new NotImplementedException();
	}

	public double getHumidity(int x, int z) {
		throw new NotImplementedException();
	}

	public int getMaxHeight() {
		throw new NotImplementedException();
	}

	public int getSeaLevel() {
		throw new NotImplementedException();
	}

	public boolean getKeepSpawnInMemory() {
		throw new NotImplementedException();
	}

	public void setKeepSpawnInMemory(boolean keepLoaded) {
		throw new NotImplementedException();
	}

	public boolean isAutoSave() {
		throw new NotImplementedException();
	}

	public void setAutoSave(boolean value) {
		throw new NotImplementedException();
	}

	public void setDifficulty(Difficulty difficulty) {
		throw new NotImplementedException();
	}

	public Difficulty getDifficulty() {
		throw new NotImplementedException();
	}

	public File getWorldFolder() {
		throw new NotImplementedException();
	}

	public WorldType getWorldType() {
		throw new NotImplementedException();
	}

	public boolean canGenerateStructures() {
		throw new NotImplementedException();
	}

	public long getTicksPerAnimalSpawns() {
		throw new NotImplementedException();
	}

	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		throw new NotImplementedException();
	}

	public long getTicksPerMonsterSpawns() {
		throw new NotImplementedException();
	}

	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		throw new NotImplementedException();
	}

	public int getMonsterSpawnLimit() {
		throw new NotImplementedException();
	}

	public void setMonsterSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	public int getAnimalSpawnLimit() {
		throw new NotImplementedException();
	}

	public void setAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	public int getWaterAnimalSpawnLimit() {
		throw new NotImplementedException();
	}

	public void setWaterAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	public int getAmbientSpawnLimit() {
		throw new NotImplementedException();
	}

	public void setAmbientSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	public void playSound(Location location, Sound sound, float volume, float pitch) {
		throw new NotImplementedException();
	}

	public String[] getGameRules() {
		return new String[0];
	}

	public String getGameRuleValue(String rule) {
		throw new NotImplementedException();
	}

	public boolean setGameRuleValue(String rule, String value) {
		throw new NotImplementedException();
	}

	public boolean isGameRule(String rule) {
		throw new NotImplementedException();
	}

	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new NotImplementedException();
	}

	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	public boolean hasMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new NotImplementedException();
	}

	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		throw new NotImplementedException();
	}

	public Set<String> getListeningPluginChannels() {
		throw new NotImplementedException();
	}
}