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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;
import lexteam.minecraft.canarybukkit.implementation.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import net.canarymod.config.Configuration;
import net.canarymod.config.WorldConfiguration;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class CanaryWorld implements World {

    private net.canarymod.api.world.World world;
    private Server server;

    public CanaryWorld(net.canarymod.api.world.World world) {
        this.world = world;
        this.server = Bukkit.getServer();
    }

    public boolean canGenerateStructures() {
        return getWorldConfiguration().generatesStructures();
    }

    public boolean createExplosion(double x, double y, double z, float power) {
        getWorld().makeExplosion(null, x, y, z, power, true);
        return true;
    }

    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        throw new NotImplementedException("createExplosion(double, double, double, float, boolean)");
    }

    public boolean createExplosion(double x, double y, double z, float power, boolean setFire,
            boolean breakBlocks) {
        throw new NotImplementedException("createExplosion(double, double, double, float, boolean, boolean)");
    }

    public boolean createExplosion(Location loc, float power) {
        return createExplosion(loc.getX(), loc.getY(), loc.getZ(), power);
    }

    public boolean createExplosion(Location loc, float power, boolean setFire) {
        return createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, setFire);
    }

    public Item dropItem(Location location, ItemStack item) {
        throw new NotImplementedException("dropItem(Location, ItemStack)");
    }

    public Item dropItemNaturally(Location location, ItemStack item) {
        throw new NotImplementedException("dropItemNaturally(Location, ItemStack)");
    }

    public boolean generateTree(Location location, TreeType type) {
        throw new NotImplementedException("generateTree(Location, TreeType)");
    }

    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
        throw new NotImplementedException(" generateTree(Location, TreeType, BlockChangeDelegate)");
    }

    public boolean getAllowAnimals() {
        return getWorldConfiguration().canSpawnAnimals();
    }

    public boolean getAllowMonsters() {
        return getWorldConfiguration().canSpawnMonsters();
    }

    public int getAmbientSpawnLimit() {
        throw new NotImplementedException("getAmbientSpawnLimit()");
    }

    public int getAnimalSpawnLimit() {
        throw new NotImplementedException("getAnimalSpawnLimit()");
    }

    public Biome getBiome(int x, int z) {
        return Biome.valueOf(getWorld().getBiome(x, z).getBiomeType().name());
        // TODO: Check if that works
    }

    public Block getBlockAt(int x, int y, int z) {
        return new CanaryBlock(getWorld().getBlockAt(x, y, z));
    }

    public Block getBlockAt(Location location) {
        return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public int getBlockTypeIdAt(int x, int y, int z) {
        return getWorld().getBlockAt(x, y, z).getTypeId();
    }

    public int getBlockTypeIdAt(Location location) {
        return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public Chunk getChunkAt(Block block) {
        return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
    }

    public Chunk getChunkAt(int x, int z) {
        return new CanaryChunk(getWorld().getChunk(x, z), this);
    }

    public Chunk getChunkAt(Location location) {
        return getChunkAt(location.getBlockX(), location.getBlockZ());
    }

    public Difficulty getDifficulty() {
        return BukkitUtils.getDifficulty(getWorldConfiguration().getDifficulty());
    }

    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome,
            boolean includeBiomeTempRain) {
        throw new NotImplementedException("getEmptyChunkSnapshot(int, int, boolean, boolean)");
    }

    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        for (net.canarymod.api.entity.Entity e : getWorld().getEntityLivingList()) {
            entities.add(BukkitUtils.getEntity(e));
        }
        return entities;
    }

    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
        throw new NotImplementedException("getEntitiesByClass(Class<T>...)");
    }

    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
        throw new NotImplementedException("getEntitiesByClass(Class<T>)");
    }

    public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
        throw new NotImplementedException("getEntitiesByClasses(Class<?>...)");
    }

    public Environment getEnvironment() {
        return BukkitUtils.getEnvironment(getWorld().getType());
    }

    public long getFullTime() {
        return getWorld().getTotalTime();
    }

    public String[] getGameRules() {
        throw new NotImplementedException("getGameRules()");
    }

    public String getGameRuleValue(String rule) {
        throw new NotImplementedException("getGameRuleValue(String)");
    }

    public ChunkGenerator getGenerator() {
        throw new NotImplementedException("getGenerator()");
    }

    public Block getHighestBlockAt(int x, int z) {
        return new CanaryBlock(getWorld().getBlockAt(x, getWorld().getHighestBlockAt(x, z), z));
    }

    public Block getHighestBlockAt(Location location) {
        return getHighestBlockAt(location.getBlockX(), location.getBlockZ());
    }

    public int getHighestBlockYAt(int x, int z) {
        return getWorld().getHighestBlockAt(x, z);
    }

    public int getHighestBlockYAt(Location location) {
        return getHighestBlockYAt(location.getBlockX(), location.getBlockZ());
    }

    public double getHumidity(int x, int z) {
        return getWorld().getBiome(x, z).getRainfall();
    }

    public boolean getKeepSpawnInMemory() {
        throw new NotImplementedException("getKeepSpawnInMemory()");
    }

    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException("getListeningPluginChannels()");
    }

    public List<LivingEntity> getLivingEntities() {
        List<LivingEntity> entities = new ArrayList<LivingEntity>();
        for (net.canarymod.api.entity.living.EntityLiving entity : getWorld().getEntityLivingList()) {
            entities.add((LivingEntity) BukkitUtils.getEntity(entity));
        }
        return entities;
    }

    public Chunk[] getLoadedChunks() {
        List<Chunk> chunks = new ArrayList<Chunk>();
        for (net.canarymod.api.world.Chunk chunk : getWorld().getLoadedChunks()) {
            chunks.add(new CanaryChunk(chunk, this));
        }
        return chunks.toArray(new Chunk[chunks.size()]);
    }

    public int getMaxHeight() {
        return getWorld().getHeight();
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException("getMetadata(String)");
    }

    public int getMonsterSpawnLimit() {
        throw new NotImplementedException("getMonsterSpawnLimit()");
    }

    public String getName() {
        return getWorld().getName();
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();
        for (net.canarymod.api.entity.living.humanoid.Player p : getWorld().getPlayerList()) {
            players.add(new CanaryPlayer(p));
        }
        return players;
    }

    public List<BlockPopulator> getPopulators() {
        throw new NotImplementedException("getPopulators()");
    }

    public boolean getPVP() {
        return getWorldConfiguration().isPvpEnabled();
    }

    public int getSeaLevel() {
        throw new NotImplementedException("getSeaLevel()");
    }

    public long getSeed() {
        return getWorld().getWorldSeed();
    }

    public Location getSpawnLocation() {
        return new CanaryLocation(getWorld().getSpawnLocation(), this);
    }

    public double getTemperature(int x, int z) {
        return getWorld().getBiome(x, z).getTemperature();
    }

    public int getThunderDuration() {
        return getWorld().getThunderTicks();
    }

    public long getTicksPerAnimalSpawns() {
        throw new NotImplementedException("getTicksPerAnimalSpawns()");
    }

    public long getTicksPerMonsterSpawns() {
        throw new NotImplementedException("getTicksPerMonsterSpawns()");
    }

    public long getTime() {
        return getWorld().getRelativeTime();
    }

    public UUID getUID() {
        throw new NotImplementedException("getUID()");
    }

    public int getWaterAnimalSpawnLimit() {
        throw new NotImplementedException("getWaterAnimalSpawnLimit()");
    }

    public int getWeatherDuration() {
        return getWorld().getRainTicks();
    }

    public File getWorldFolder() {
        throw new NotImplementedException("getWorldFolder()");
    }

    public WorldType getWorldType() {
        return BukkitUtils.getWorldType(getWorldConfiguration().getWorldType());
    }

    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException("hasMetadata(String)");
    }

    public boolean hasStorm() {
        throw new NotImplementedException("hasStorm()");
    }

    public boolean isAutoSave() {
        throw new NotImplementedException("isAutoSave()");
    }

    public boolean isChunkInUse(int x, int z) {
        return getWorld().getChunk(x, z).hasEntities();
    }

    public boolean isChunkLoaded(Chunk chunk) {
        return chunk.isLoaded();
    }

    public boolean isChunkLoaded(int x, int z) {
        return getChunkAt(x, z).isLoaded();
    }

    public boolean isGameRule(String rule) {
        throw new NotImplementedException("isGameRule(String)");
    }

    public boolean isThundering() {
        throw new NotImplementedException("isThundering()");
    }

    public void loadChunk(Chunk chunk) {
        chunk.load();
    }

    public void loadChunk(int x, int z) {
        getChunkAt(x, z).load();
    }

    public boolean loadChunk(int x, int z, boolean generate) {
        return getChunkAt(x, z).load(generate);
    }

    public void playEffect(Location location, Effect effect, int data) {
        throw new NotImplementedException("playEffect(Location, Effect, int)");
    }

    public void playEffect(Location location, Effect effect, int data, int radius) {
        throw new NotImplementedException("playEffect(Location, Effect, int, int)");
    }

    public <T> void playEffect(Location location, Effect effect, T data) {
        throw new NotImplementedException("playEffect(Location, Effect, T)");
    }

    public <T> void playEffect(Location location, Effect effect, T data, int radius) {
        throw new NotImplementedException("playEffect(Location, Effect, T, int)");
    }

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new NotImplementedException("playSound(Location, Sound, float, float)");
    }

    public boolean refreshChunk(int x, int z) {
        getChunkAt(x, z).unload(true);
        return getChunkAt(x, z).load(true);
    }

    public boolean regenerateChunk(int x, int z) {
        throw new NotImplementedException("regenerateChunk(int, int)");
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException("removeMetadata(String, Plugin)");
    }

    public void save() {
        getWorld().save();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        getServer().sendPluginMessage(source, channel, message);
    }

    public void setAmbientSpawnLimit(int limit) {
        throw new NotImplementedException("setAmbientSpawnLimit(int)");
    }

    public void setAnimalSpawnLimit(int limit) {
        throw new NotImplementedException("setAnimalSpawnLimit(int)");
    }

    public void setAutoSave(boolean value) {
        throw new NotImplementedException("setAutoSave(boolean)");
    }

    public void setBiome(int x, int z, Biome bio) {
        getWorld().setBiome(x, z, CanaryUtils.getBiome(bio));
    }

    public void setDifficulty(Difficulty difficulty) {
        throw new NotImplementedException("setDifficulty(Difficulty)");
    }

    public void setFullTime(long time) {
        throw new NotImplementedException("setFullTime(long)");
    }

    public boolean setGameRuleValue(String rule, String value) {
        throw new NotImplementedException("setGameRuleValue(String, String)");
    }

    public void setKeepSpawnInMemory(boolean keepLoaded) {
        throw new NotImplementedException("setKeepSpawnInMemory(boolean)");
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException("setMetadata(String, MetadataValue)");
    }

    public void setMonsterSpawnLimit(int limit) {
        throw new NotImplementedException("setMonsterSpawnLimit(int)");
    }

    public void setPVP(boolean pvp) {
        getWorldConfiguration().getFile().setBoolean("pvp", pvp);
    }

    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        throw new NotImplementedException("setSpawnFlags(boolean, boolean)");
    }

    public boolean setSpawnLocation(int x, int y, int z) {
        getWorld().setSpawnLocation(new net.canarymod.api.world.position.Location(x, y, z));
        return (getWorld().getSpawnLocation() == new net.canarymod.api.world.position.Location(x, y, z));
    }

    public void setStorm(boolean hasStorm) {
        getWorld().setRaining(hasStorm);
    }

    public void setThunderDuration(int duration) {
        getWorld().setThunderTime(duration);
    }

    public void setThundering(boolean thundering) {
        getWorld().setThundering(thundering);
    }

    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
        throw new NotImplementedException("setTicksPerAnimalSpawns(int)");
    }

    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
        throw new NotImplementedException("setTicksPerMonsterSpawns(int)");
    }

    public void setTime(long time) {
        getWorld().setTime(time);
    }

    public void setWaterAnimalSpawnLimit(int limit) {
        throw new NotImplementedException("setWaterAnimalSpawnLimit(int)");
    }

    public void setWeatherDuration(int duration) {
        getWorld().setRainTime(duration);
    }

    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        throw new NotImplementedException("spawn(Location, Class<T>)");
    }

    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
        throw new NotImplementedException("spawnArrow(Location, Vector, float, float)");
    }

    @SuppressWarnings("deprecation")
    public LivingEntity spawnCreature(Location loc, CreatureType type) {
        throw new NotImplementedException("spawnCreature(Location, CreatureType)");
    }

    public LivingEntity spawnCreature(Location loc, EntityType type) {
        throw new NotImplementedException("spawnCreature(Location, EntityType)");
    }

    public Entity spawnEntity(Location loc, EntityType type) {
        throw new NotImplementedException("spawnEntity(Location, EntityType)");
    }

    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData)
            throws IllegalArgumentException {
        throw new NotImplementedException("spawnFallingBlock(Location, int, byte)");
    }

    public FallingBlock spawnFallingBlock(Location location, Material material, byte data)
            throws IllegalArgumentException {
        throw new NotImplementedException("spawnFallingBlock(Location, Material, byte)");
    }

    public LightningStrike strikeLightning(Location loc) {
        throw new NotImplementedException("strikeLightning(Location)");
    }

    public LightningStrike strikeLightningEffect(Location loc) {
        throw new NotImplementedException("strikeLightningEffect(Location)");
    }

    public boolean unloadChunk(Chunk chunk) {
        return chunk.unload();
    }

    public boolean unloadChunk(int x, int z) {
        return getChunkAt(x, z).unload();
    }

    public boolean unloadChunk(int x, int z, boolean save) {
        return getChunkAt(x, z).unload(save);
    }

    public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
        return getChunkAt(x, z).unload(save, safe);
    }

    public boolean unloadChunkRequest(int x, int z) {
        return unloadChunk(x, z);
    }

    public boolean unloadChunkRequest(int x, int z, boolean safe) {
        return unloadChunk(x, z, safe);
    }

    protected WorldConfiguration getWorldConfiguration() {
        return Configuration.getWorldConfig(getWorld().getFqName());
    }

    protected net.canarymod.api.world.World getWorld() {
        return world;
    }

    protected Server getServer() {
        return server;
    }
}
