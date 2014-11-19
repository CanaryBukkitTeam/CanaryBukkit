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

import org.apache.commons.lang.NotImplementedException;
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
        throw new NotImplementedException();
    }

    public boolean createExplosion(double x, double y, double z, float power) {
        throw new NotImplementedException();
    }

    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        throw new NotImplementedException();
    }

    public boolean createExplosion(double x, double y, double z, float power, boolean setFire,
            boolean breakBlocks) {
        throw new NotImplementedException();
    }

    public boolean createExplosion(Location loc, float power) {
        throw new NotImplementedException();
    }

    public boolean createExplosion(Location loc, float power, boolean setFire) {
        throw new NotImplementedException();
    }

    public Item dropItem(Location location, ItemStack item) {
        throw new NotImplementedException();
    }

    public Item dropItemNaturally(Location location, ItemStack item) {
        throw new NotImplementedException();
    }

    public boolean generateTree(Location location, TreeType type) {
        throw new NotImplementedException();
    }

    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
        throw new NotImplementedException();
    }

    public boolean getAllowAnimals() {
        return getWorldConfig().canSpawnAnimals();
    }

    public boolean getAllowMonsters() {
        return getWorldConfig().canSpawnMonsters();
    }

    public int getAmbientSpawnLimit() {
        throw new NotImplementedException();
    }

    public int getAnimalSpawnLimit() {
        throw new NotImplementedException();
    }

    public Biome getBiome(int x, int z) {
        throw new NotImplementedException();
    }

    public Block getBlockAt(int x, int y, int z) {
        return new CanaryBlock(world.getBlockAt(x, y, z));
    }

    public Block getBlockAt(Location location) {
        return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public int getBlockTypeIdAt(int x, int y, int z) {
        return world.getBlockAt(x, y, z).getTypeId();
    }

    public int getBlockTypeIdAt(Location location) {
        return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public Chunk getChunkAt(Block block) {
        return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
    }

    public Chunk getChunkAt(int x, int z) {
        return new CanaryChunk(world.getChunk(x, z), this);
    }

    public Chunk getChunkAt(Location location) {
        return getChunkAt(location.getBlockX(), location.getBlockZ());
    }

    public Difficulty getDifficulty() {
        return BukkitUtils.getDifficulty(getWorldConfig().getDifficulty());
    }

    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome,
            boolean includeBiomeTempRain) {
        throw new NotImplementedException();
    }

    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        for (net.canarymod.api.entity.Entity e : world.getEntityLivingList()) {
            entities.add(BukkitUtils.getEntity(e));
        }
        return entities;
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

    public Environment getEnvironment() {
        return BukkitUtils.getEnviroment(world.getType());
    }

    public long getFullTime() {
        throw new NotImplementedException();
    }

    public String[] getGameRules() {
        return new String[0];
    }

    public String getGameRuleValue(String rule) {
        throw new NotImplementedException();
    }

    public ChunkGenerator getGenerator() {
        throw new NotImplementedException();
    }

    public Block getHighestBlockAt(int x, int z) {
        throw new NotImplementedException();
        // world.getHighestBlockAt(x, z)
    }

    public Block getHighestBlockAt(Location location) {
        throw new NotImplementedException();
        // world.getHighestBlockAt(location.getBlockX(),location.getBlockZ())
    }

    public int getHighestBlockYAt(int x, int z) {
        throw new NotImplementedException();
    }

    public int getHighestBlockYAt(Location location) {
        throw new NotImplementedException();
    }

    public double getHumidity(int x, int z) {
        throw new NotImplementedException();
    }

    public boolean getKeepSpawnInMemory() {
        throw new NotImplementedException();
    }

    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException();
    }

    public List<LivingEntity> getLivingEntities() {
        List<LivingEntity> entities = new ArrayList<LivingEntity>();
        for (net.canarymod.api.entity.living.EntityLiving entity : world.getEntityLivingList()) {
            entities.add((LivingEntity) BukkitUtils.getEntity(entity));
        }
        return entities;
    }

    public Chunk[] getLoadedChunks() {
        List<Chunk> chunks = new ArrayList<Chunk>();
        for (net.canarymod.api.world.Chunk chunk : world.getLoadedChunks()) {
            chunks.add(new CanaryChunk(chunk, this));
        }
        return chunks.toArray(new Chunk[chunks.size()]);
    }

    public int getMaxHeight() {
        return world.getHeight();
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public int getMonsterSpawnLimit() {
        throw new NotImplementedException();
    }

    public String getName() {
        return world.getName();
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();
        for (net.canarymod.api.entity.living.humanoid.Player p : world.getPlayerList()) {
            players.add(new CanaryPlayer(p));
        }
        return players;
    }

    public List<BlockPopulator> getPopulators() {
        throw new NotImplementedException();
    }

    public boolean getPVP() {
        return getWorldConfig().isPvpEnabled();
    }

    public int getSeaLevel() {
        throw new NotImplementedException();
    }

    public long getSeed() {
        return Long.parseLong(Configuration.getWorldConfig(getName()).getWorldSeed());
    }

    public Location getSpawnLocation() {
        return new CanaryLocation(world.getSpawnLocation(), this);
    }

    public double getTemperature(int x, int z) {
        throw new NotImplementedException();
    }

    public int getThunderDuration() {
        throw new NotImplementedException();
    }

    public long getTicksPerAnimalSpawns() {
        throw new NotImplementedException();
    }

    public long getTicksPerMonsterSpawns() {
        throw new NotImplementedException();
    }

    public long getTime() {
        return world.getTotalTime();
    }

    public UUID getUID() {
        throw new NotImplementedException();
    }

    public int getWaterAnimalSpawnLimit() {
        throw new NotImplementedException();
    }

    public int getWeatherDuration() {
        throw new NotImplementedException();
    }

    private WorldConfiguration getWorldConfig() {
        return Configuration.getWorldConfig(this.getName());
    }

    public File getWorldFolder() {
        throw new NotImplementedException();
    }

    public WorldType getWorldType() {
        return BukkitUtils.getWorldType(getWorldConfig().getWorldType());
    }

    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public boolean hasStorm() {
        throw new NotImplementedException();
    }

    public boolean isAutoSave() {
        throw new NotImplementedException();
    }

    public boolean isChunkInUse(int x, int z) {
        return world.getChunk(x, z).hasEntities();
    }

    public boolean isChunkLoaded(Chunk chunk) {
        return chunk.isLoaded();
    }

    public boolean isChunkLoaded(int x, int z) {
        return getChunkAt(x, z).isLoaded();
    }

    public boolean isGameRule(String rule) {
        throw new NotImplementedException();
    }

    public boolean isThundering() {
        throw new NotImplementedException();
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

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new NotImplementedException();
    }

    public boolean refreshChunk(int x, int z) {
        getChunkAt(x, z).unload(true);
        return getChunkAt(x, z).load(true);
    }

    public boolean regenerateChunk(int x, int z) {
        throw new NotImplementedException();
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException();
    }

    public void save() {
        world.save();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        server.sendPluginMessage(source, channel, message);
    }

    public void setAmbientSpawnLimit(int limit) {
        throw new NotImplementedException();
    }

    public void setAnimalSpawnLimit(int limit) {
        throw new NotImplementedException();
    }

    public void setAutoSave(boolean value) {
        throw new NotImplementedException();
    }

    public void setBiome(int x, int z, Biome bio) {
        world.setBiome(x, z, CanaryUtils.getBiome(bio));
    }

    public void setDifficulty(Difficulty difficulty) {
        throw new NotImplementedException();
    }

    public void setFullTime(long time) {
        throw new NotImplementedException();
    }

    public boolean setGameRuleValue(String rule, String value) {
        throw new NotImplementedException();
    }

    public void setKeepSpawnInMemory(boolean keepLoaded) {
        throw new NotImplementedException();
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException();
    }

    public void setMonsterSpawnLimit(int limit) {
        throw new NotImplementedException();
    }

    public void setPVP(boolean pvp) {
        throw new NotImplementedException();
    }

    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        throw new NotImplementedException();
    }

    public boolean setSpawnLocation(int x, int y, int z) {
        world.setSpawnLocation(new net.canarymod.api.world.position.Location(x, y, z));
        return (world.getSpawnLocation() == new net.canarymod.api.world.position.Location(x, y, z));
    }

    public void setStorm(boolean hasStorm) {
        throw new NotImplementedException();
    }

    public void setThunderDuration(int duration) {
        throw new NotImplementedException();
    }

    public void setThundering(boolean thundering) {
        throw new NotImplementedException();
    }

    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
        throw new NotImplementedException();
    }

    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
        throw new NotImplementedException();
    }

    public void setTime(long time) {
        world.setTime(time);
    }

    public void setWaterAnimalSpawnLimit(int limit) {
        throw new NotImplementedException();
    }

    public void setWeatherDuration(int duration) {
        throw new NotImplementedException();
    }

    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
        throw new NotImplementedException();
    }

    @SuppressWarnings("deprecation")
    public LivingEntity spawnCreature(Location loc, CreatureType type) {
        throw new NotImplementedException();
    }

    public LivingEntity spawnCreature(Location loc, EntityType type) {
        throw new NotImplementedException();
    }

    public Entity spawnEntity(Location loc, EntityType type) {
        throw new NotImplementedException();
    }

    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public FallingBlock spawnFallingBlock(Location location, Material material, byte data)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public LightningStrike strikeLightning(Location loc) {
        throw new NotImplementedException();
    }

    public LightningStrike strikeLightningEffect(Location loc) {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }
}