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

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class CanaryChunkSnapshot implements ChunkSnapshot {
    private net.canarymod.api.world.Chunk chunk;
    private CanaryWorld world;

    public CanaryChunkSnapshot(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        this.chunk = chunk;
        this.world = world;
    }

    public int getX() {
        return chunk.getX();
    }

    public int getZ() {
        return chunk.getZ();
    }

    public String getWorldName() {
        return world.getName();
    }

    public int getBlockTypeId(int x, int y, int z) {
        return world.getBlockTypeIdAt(x, y, z);
    }

    public int getBlockData(int x, int y, int z) {
        return 0;
    }

    public int getBlockSkyLight(int x, int y, int z) {
        return 0;
    }

    public int getBlockEmittedLight(int x, int y, int z) {
        return 0;
    }

    public int getHighestBlockYAt(int x, int z) {
        return world.getHighestBlockYAt(x, z);
    }

    public Biome getBiome(int x, int z) {
        return null;
    }

    public double getRawBiomeTemperature(int x, int z) {
        return 0;
    }

    public double getRawBiomeRainfall(int x, int z) {
        return 0;
    }

    public long getCaptureFullTime() {
        return 0;
    }

    public boolean isSectionEmpty(int sy) {
        return false;
    }
}
