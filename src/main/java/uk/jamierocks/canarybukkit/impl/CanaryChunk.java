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

import com.google.common.collect.Lists;
import io.github.lexware.unolib.Wrapper;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import uk.jamierocks.canarybukkit.BukkitUtils;

import java.util.List;

public class CanaryChunk extends Wrapper<net.canarymod.api.world.Chunk> implements Chunk {

    private CanaryWorld world;

    public CanaryChunk(net.canarymod.api.world.Chunk chunk, CanaryWorld world) {
        // Why is that a CanaryWorld and not a canary api World?
        super(chunk);
        this.world = world;
    }

    @Override
    public Block getBlock(int x, int y, int z) {
        return this.world.getBlockAt(x, y, z);
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        return new CanaryChunkSnapshot(this.getHandle(), this.world);
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome,
            boolean includeBiomeTempRain) {
        throw new NotImplementedException("getChunkSnapshot(boolean, boolean, boolean)");
    }

    @Override
    public Entity[] getEntities() {
        List<Entity> entities = Lists.newArrayList();
        for (List<net.canarymod.api.entity.Entity> e : this.getHandle().getEntityLists()) {
            for (net.canarymod.api.entity.Entity en : e) {
                entities.add(BukkitUtils.getEntity(en));
            }
        }
        return entities.toArray(new Entity[entities.size()]);
    }

    @Override
    public BlockState[] getTileEntities() {
        return new BlockState[0];
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public int getX() {
        return this.getHandle().getX();
    }

    @Override
    public int getZ() {
        return this.getHandle().getZ();
    }

    @Override
    public boolean isLoaded() {
        return this.getHandle().isLoaded();
    }

    @Override
    public boolean load() {
        this.world.loadChunk(new CanaryChunk(this.getHandle(), this.world));
        return this.getHandle().isLoaded();
    }

    @Override
    public boolean load(boolean generate) {
        return false;
    }

    @Override
    public boolean unload() {
        this.world.unloadChunk(new CanaryChunk(this.getHandle(), this.world));
        return !this.getHandle().isLoaded();
    }

    @Override
    public boolean unload(boolean save) {
        return false;
    }

    @Override
    public boolean unload(boolean save, boolean safe) {
        return false;
    }
}
