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
package lexteam.minecraft.canarybukkit.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;

public class CanaryBlock implements Block {
	private net.canarymod.api.world.blocks.Block block;

	public CanaryBlock(net.canarymod.api.world.blocks.Block block) {
		this.block = block;
	}

	public byte getData() {
		throw new NotImplementedException();
	}

	public Block getRelative(int modX, int modY, int modZ) {
		throw new NotImplementedException();
	}

	public Block getRelative(BlockFace face) {
		throw new NotImplementedException();
	}

	public Block getRelative(BlockFace face, int distance) {
		throw new NotImplementedException();
	}

	public Material getType() {
		throw new NotImplementedException();
	}

	public int getTypeId() {
		return block.getTypeId();
	}

	public byte getLightLevel() {
		throw new NotImplementedException();
	}

	public byte getLightFromSky() {
		throw new NotImplementedException();
	}

	public byte getLightFromBlocks() {
		throw new NotImplementedException();
	}

	public World getWorld() {
		return new CanaryWorld(block.getWorld());
	}

	public int getX() {
		return block.getX();
	}

	public int getY() {
		return block.getY();
	}

	public int getZ() {
		return block.getZ();
	}

	public Location getLocation() {
		throw new NotImplementedException();
	}

	public Location getLocation(Location loc) {
		return new Location(new CanaryWorld(block.getWorld()), block.getX(), block.getY(), block.getZ());
	}

	public Chunk getChunk() {
		throw new NotImplementedException();
	}

	public void setData(byte data) {
		throw new NotImplementedException();
	}

	public void setData(byte data, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	public void setType(Material type) {
		throw new NotImplementedException();
	}

	public boolean setTypeId(int type) {
		throw new NotImplementedException();
	}

	public boolean setTypeId(int type, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	public BlockFace getFace(Block block) {
		throw new NotImplementedException();
	}

	public BlockState getState() {
		throw new NotImplementedException();
	}

	public Biome getBiome() {
		throw new NotImplementedException();
	}

	public void setBiome(Biome bio) {
		throw new NotImplementedException();
	}

	public boolean isBlockPowered() {
		throw new NotImplementedException();
	}

	public boolean isBlockIndirectlyPowered() {
		throw new NotImplementedException();
	}

	public boolean isBlockFacePowered(BlockFace face) {
		throw new NotImplementedException();
	}

	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		throw new NotImplementedException();
	}

	public int getBlockPower(BlockFace face) {
		throw new NotImplementedException();
	}

	public int getBlockPower() {
		throw new NotImplementedException();
	}

	public boolean isEmpty() {
		throw new NotImplementedException();
	}

	public boolean isLiquid() {
		throw new NotImplementedException();
	}

	public double getTemperature() {
		throw new NotImplementedException();
	}

	public double getHumidity() {
		throw new NotImplementedException();
	}

	public PistonMoveReaction getPistonMoveReaction() {
		throw new NotImplementedException();
	}

	public boolean breakNaturally() {
		throw new NotImplementedException();
	}

	public boolean breakNaturally(ItemStack tool) {
		throw new NotImplementedException();
	}

	public Collection<ItemStack> getDrops() {
		throw new NotImplementedException();
	}

	public Collection<ItemStack> getDrops(ItemStack tool) {
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
}