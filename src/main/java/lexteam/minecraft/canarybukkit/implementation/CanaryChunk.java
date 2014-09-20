/**
 * This file is part of CanaryMod-BukkitAPI, a CanaryMod plugin, licensed under the MIT License (MIT).
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

	public int getX() {
		return chunk.getX();
	}

	public int getZ() {
		return chunk.getZ();
	}

	public World getWorld() {
		return world;
	}

	public Block getBlock(int x, int y, int z) {
		return world.getBlockAt(x, y, z);
	}

	public ChunkSnapshot getChunkSnapshot() {
		throw new NotImplementedException();
	}

	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		throw new NotImplementedException();
	}

	public Entity[] getEntities() {
		return new Entity[0];
	}

	public BlockState[] getTileEntities() {
		return new BlockState[0];
	}

	public boolean isLoaded() {
		return chunk.isLoaded();
	}

	public boolean load(boolean generate) {
		return false;
	}

	public boolean load() {
		return false;
	}

	public boolean unload(boolean save, boolean safe) {
		return false;
	}

	public boolean unload(boolean save) {
		return false;
	}

	public boolean unload() {
		return false;
	}
}