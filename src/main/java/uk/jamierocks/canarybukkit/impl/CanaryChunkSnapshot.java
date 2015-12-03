/*
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014-2015 CanaryBukkitTeam
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
package uk.jamierocks.canarybukkit.impl;

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class CanaryChunkSnapshot implements ChunkSnapshot {

    private final long snapshotTime;
    private net.canarymod.api.world.Chunk chunk;
    private CanaryWorld world;

    public CanaryChunkSnapshot(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        this.chunk = chunk;
        this.world = world;
        this.snapshotTime = world.getFullTime();
    }

    @Override
    public int getX() {
        return this.getChunk().getX();
    }

    @Override
    public int getZ() {
        return this.getChunk().getZ();
    }

    @Override
    public String getWorldName() {
        return this.getWorld().getName();
    }

    @Override
    public int getBlockTypeId(int x, int y, int z) {
        return this.getWorld().getBlockTypeIdAt(x, y, z);
    }

    @Override
    public int getBlockData(int x, int y, int z) {
        return this.getWorld().getBlockAt(x, y, z).getData();
    }

    @Override
    public int getBlockSkyLight(int x, int y, int z) {
        throw new org.apache.commons.lang3.NotImplementedException("getBlockSkyLight(int, int, int)");
    }

    @Override
    public int getBlockEmittedLight(int x, int y, int z) {
        throw new org.apache.commons.lang3.NotImplementedException("getBlockEmittedLight(int, int, int)");
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        return this.getWorld().getHighestBlockYAt(x, z);
    }

    @Override
    public Biome getBiome(int x, int z) {
        return Biome.valueOf(this.getChunk().getBiome(x, z).getBiomeType().name());
        // TODO: Check if that works
    }

    @Override
    public double getRawBiomeTemperature(int x, int z) {
        return this.getChunk().getBiome(x, z).getTemperature();
    }

    @Override
    public double getRawBiomeRainfall(int x, int z) {
        return this.getChunk().getBiome(x, z).getRainfall();
    }

    @Override
    public long getCaptureFullTime() {
        return this.getSnapshotTime();
    }

    @Override
    public boolean isSectionEmpty(int sy) {
        return !this.getChunk().hasEntities();
        // TODO likely not fully right
    }

    protected net.canarymod.api.world.Chunk getChunk() {
        return this.chunk;
    }

    protected CanaryWorld getWorld() {
        return this.world;
    }

    protected long getSnapshotTime() {
        return this.snapshotTime;
    }
}
