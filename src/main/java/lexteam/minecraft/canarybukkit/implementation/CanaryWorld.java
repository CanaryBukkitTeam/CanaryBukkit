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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.implementation.block.CanaryBlock;
import net.canarymod.config.Configuration;

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

    public int getHighestBlockYAt(int x, int z) {
        throw new NotImplementedException();
    }

    public int getHighestBlockYAt(Location location) {
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

    public Chunk getChunkAt(int x, int z) {
        return new CanaryChunk(world.getChunk(x, z), this);
    }

    public Chunk getChunkAt(Location location) {
        return getChunkAt(location.getBlockX(), location.getBlockZ());
    }

    public Chunk getChunkAt(Block block) {
        return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
    }

    public boolean isChunkLoaded(Chunk chunk) {
        return chunk.isLoaded();
    }

    public Chunk[] getLoadedChunks() {
        List<Chunk> chunks = new ArrayList<Chunk>();
        for (net.canarymod.api.world.Chunk chunk : world.getLoadedChunks()) {
            chunks.add(new CanaryChunk(chunk, this));
        }
        return chunks.toArray(new Chunk[chunks.size()]);
    }

    public void loadChunk(Chunk chunk) {
        chunk.load();
    }

    public boolean isChunkLoaded(int x, int z) {
        return getChunkAt(x, z).isLoaded();
    }

    public boolean isChunkInUse(int x, int z) {
        throw new NotImplementedException();
    }

    public void loadChunk(int x, int z) {
        getChunkAt(x, z).load();
    }

    public boolean loadChunk(int x, int z, boolean generate) {
        return getChunkAt(x, z).load(generate);
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

    public boolean regenerateChunk(int x, int z) {
        throw new NotImplementedException();
    }

    public boolean refreshChunk(int x, int z) {
        getChunkAt(x, z).unload(true);
        return getChunkAt(x, z).load(true);
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

    @SuppressWarnings("deprecation")
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
        return new CanaryLocation(world.getSpawnLocation(), this);
    }

    public boolean setSpawnLocation(int x, int y, int z) {
        world.setSpawnLocation(new net.canarymod.api.world.position.Location(x, y, z));
        return (world.getSpawnLocation() == new net.canarymod.api.world.position.Location(x, y, z));
    }

    public long getTime() {
        return world.getTotalTime();
    }

    public void setTime(long time) {
        world.setTime(time);
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

    public Environment getEnvironment() {
        throw new NotImplementedException();
    }

    public long getSeed() {
        return Long.parseLong(Configuration.getWorldConfig(getName()).getWorldSeed());
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
        world.save();
    }

    public List<BlockPopulator> getPopulators() {
        throw new NotImplementedException();
    }

    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public FallingBlock spawnFallingBlock(Location location, Material material, byte data)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData)
            throws IllegalArgumentException {
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

    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome,
            boolean includeBiomeTempRain) {
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
        return world.getHeight();
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
        server.sendPluginMessage(source, channel, message);
    }

    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException();
    }
}