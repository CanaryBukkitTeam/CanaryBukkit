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

import java.util.ArrayList;
import java.util.List;

import lexteam.minecraft.canarybukkit.BukkitUtils;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class CanaryChunk implements Chunk {
    private net.canarymod.api.world.Chunk chunk;
    private CanaryWorld world;

    public CanaryChunk(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        this.chunk = chunk;
        this.world = world;
    }

    public Block getBlock(int x, int y, int z) {
        return world.getBlockAt(x, y, z);
    }

    public ChunkSnapshot getChunkSnapshot() {
        throw new NotImplementedException();
    }

    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome,
            boolean includeBiomeTempRain) {
        throw new NotImplementedException();
    }

    public Entity[] getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        for (List<net.canarymod.api.entity.Entity> e : chunk.getEntityLists()) {
            for (net.canarymod.api.entity.Entity en : e) {
                entities.add(BukkitUtils.getEntity(en));
            }
        }
        return entities.toArray(new Entity[entities.size()]);
    }

    public BlockState[] getTileEntities() {
        return new BlockState[0];
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return chunk.getX();
    }

    public int getZ() {
        return chunk.getZ();
    }

    public boolean isLoaded() {
        return chunk.isLoaded();
    }

    public boolean load() {
        world.loadChunk(new CanaryChunk(chunk, world));
        return chunk.isLoaded();
    }

    public boolean load(boolean generate) {
        return false;
    }

    public boolean unload() {
        world.unloadChunk(new CanaryChunk(chunk, world));
        return !chunk.isLoaded();
    }

    public boolean unload(boolean save) {
        return false;
    }

    public boolean unload(boolean save, boolean safe) {
        return false;
    }
}