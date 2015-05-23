/**
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

import java.util.ArrayList;
import java.util.List;

import uk.jamierocks.canarybukkit.BukkitUtils;

import io.github.lexware.unolib.Wrapper;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class CanaryChunk extends Wrapper<net.canarymod.api.world.Chunk> implements Chunk {
    private CanaryWorld world;

    public CanaryChunk(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        // Why is that a CanaryWorld and not a canary api World?
        super(chunk);
        this.world = world;
    }

    public Block getBlock(int x, int y, int z) {
        return world.getBlockAt(x, y, z);
    }

    public ChunkSnapshot getChunkSnapshot() {
        return new CanaryChunkSnapshot(getHandle(), world);
    }

    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
        throw new NotImplementedException("getChunkSnapshot(boolean, boolean, boolean)");
    }

    public Entity[] getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        for (List<net.canarymod.api.entity.Entity> e : getHandle().getEntityLists()) {
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
        return getHandle().getX();
    }

    public int getZ() {
        return getHandle().getZ();
    }

    public boolean isLoaded() {
        return getHandle().isLoaded();
    }

    public boolean load() {
        world.loadChunk(new CanaryChunk(getHandle(), world));
        return getHandle().isLoaded();
    }

    public boolean load(boolean generate) {
        return false;
    }

    public boolean unload() {
        world.unloadChunk(new CanaryChunk(getHandle(), world));
        return !getHandle().isLoaded();
    }

    public boolean unload(boolean save) {
        return false;
    }

    public boolean unload(boolean save, boolean safe) {
        return false;
    }
}
