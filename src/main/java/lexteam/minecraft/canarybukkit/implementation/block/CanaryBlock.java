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
package lexteam.minecraft.canarybukkit.implementation.block;

import java.util.Collection;
import java.util.List;

import lexteam.minecraft.canarybukkit.implementation.CanaryChunk;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;
import net.canarymod.api.world.BiomeType;

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

public class CanaryBlock implements Block {
    private net.canarymod.api.world.blocks.Block block;

    public CanaryBlock(net.canarymod.api.world.blocks.Block block) {
        this.block = block;
    }

    public boolean breakNaturally() {
        throw new NotImplementedException();
    }

    public boolean breakNaturally(ItemStack tool) {
        throw new NotImplementedException();
    }

    public Biome getBiome() {
        return Biome.valueOf(block.getWorld().getBiome(block.getX(), block.getZ()).getBiomeType().name());
        // TODO: Check if that works
    }

    public int getBlockPower() {
        throw new NotImplementedException();
    }

    public int getBlockPower(BlockFace face) {
        throw new NotImplementedException();
    }

    public Chunk getChunk() {
        return new CanaryChunk(block.getWorld().getChunk(getX(), getZ()), new CanaryWorld(block.getWorld()));
    }

    public byte getData() {
        throw new NotImplementedException();
    }

    public Collection<ItemStack> getDrops() {
        throw new NotImplementedException();
    }

    public Collection<ItemStack> getDrops(ItemStack tool) {
        throw new NotImplementedException();
    }

    public BlockFace getFace(Block block) {
        throw new NotImplementedException();
    }

    public double getHumidity() {
        throw new NotImplementedException();
    }

    public byte getLightFromBlocks() {
        throw new NotImplementedException();
    }

    public byte getLightFromSky() {
        throw new NotImplementedException();
    }

    public byte getLightLevel() {
        throw new NotImplementedException();
    }

    public Location getLocation() {
        return new Location(new CanaryWorld(block.getWorld()), block.getX(), block.getY(), block.getZ());
    }

    public Location getLocation(Location loc) {
        if (loc != null) {
            loc.setWorld(getWorld());
            loc.setX(getX());
            loc.setY(getY());
            loc.setZ(getX());
        }
        return loc;
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException();
    }

    public Block getRelative(BlockFace face) {
        throw new NotImplementedException();
    }

    public Block getRelative(BlockFace face, int distance) {
        throw new NotImplementedException();
    }

    public Block getRelative(int modX, int modY, int modZ) {
        throw new NotImplementedException();
    }

    public BlockState getState() {
        throw new NotImplementedException();
    }

    public double getTemperature() {
        throw new NotImplementedException();
    }

    public Material getType() {
        return Material.getMaterial(getTypeId());
    }

    public int getTypeId() {
        return block.getTypeId();
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

    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new NotImplementedException();
    }

    public boolean isBlockFacePowered(BlockFace face) {
        throw new NotImplementedException();
    }

    public boolean isBlockIndirectlyPowered() {
        throw new NotImplementedException();
    }

    public boolean isBlockPowered() {
        throw new NotImplementedException();
    }

    public boolean isEmpty() {
        return block.isAir();
    }

    public boolean isLiquid() {
        return (getType() == Material.WATER) || (getType() == Material.STATIONARY_WATER)
                || (getType() == Material.LAVA) || (getType() == Material.STATIONARY_LAVA);
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException();
    }

    public void setBiome(Biome bio) {
        block.getWorld().setBiome(block.getX(), block.getZ(), BiomeType.valueOf(bio.name()));
        // TODO: Check if that works
    }

    public void setData(byte data) {
        throw new NotImplementedException();
    }

    public void setData(byte data, boolean applyPhysics) {
        throw new NotImplementedException();
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
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
}