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

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class CanaryChunkSnapshot implements ChunkSnapshot {
    private net.canarymod.api.world.Chunk chunk;
    private CanaryWorld world;
    private final long snapshotTime;

    public CanaryChunkSnapshot(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        this.chunk = chunk;
        this.world = world;
        snapshotTime = world.getFullTime();
    }

    public int getX() {
        return getChunk().getX();
    }

    public int getZ() {
        return getChunk().getZ();
    }

    public String getWorldName() {
        return getWorld().getName();
    }

    public int getBlockTypeId(int x, int y, int z) {
        return getWorld().getBlockTypeIdAt(x, y, z);
    }

    public int getBlockData(int x, int y, int z) {
        return getWorld().getBlockAt(x, y, z).getData();
    }

    public int getBlockSkyLight(int x, int y, int z) {
        throw new org.apache.commons.lang3.NotImplementedException("getBlockSkyLight(int, int, int)");
    }

    public int getBlockEmittedLight(int x, int y, int z) {
        throw new org.apache.commons.lang3.NotImplementedException("getBlockEmittedLight(int, int, int)");
    }

    public int getHighestBlockYAt(int x, int z) {
        return getWorld().getHighestBlockYAt(x, z);
    }

    public Biome getBiome(int x, int z) {
        return Biome.valueOf(getChunk().getBiome(x, z).getBiomeType().name());
        // TODO: Check if that works
    }

    public double getRawBiomeTemperature(int x, int z) {
        return getChunk().getBiome(x, z).getTemperature();
    }

    public double getRawBiomeRainfall(int x, int z) {
        return getChunk().getBiome(x, z).getRainfall();
    }

    public long getCaptureFullTime() {
        return getSnapshotTime();
    }

    public boolean isSectionEmpty(int sy) {
        return !getChunk().hasEntities();
        // TODO likely not fully right
    }

    protected net.canarymod.api.world.Chunk getChunk() {
        return chunk;
    }

    protected CanaryWorld getWorld() {
        return world;
    }

    protected long getSnapshotTime() {
        return snapshotTime;
    }
}
