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
package lexteam.minecraft.canarybukkit.impl.block;

import java.util.Collection;
import java.util.List;

import lexteam.minecraft.canarybukkit.CanaryUtils;
import lexteam.minecraft.canarybukkit.impl.CanaryChunk;
import lexteam.minecraft.canarybukkit.impl.CanaryWorld;
import net.canarymod.api.world.BiomeType;

import org.apache.commons.lang3.NotImplementedException;
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
        throw new NotImplementedException("breakNaturally()");
    }

    public boolean breakNaturally(ItemStack tool) {
        throw new NotImplementedException("breakNaturally(ItemStack)");
    }

    public Biome getBiome() {
        return Biome.valueOf(getCanaryWorld().getBiome(getCanaryBlock().getX(), getCanaryBlock().getZ()).getBiomeType()
                .name());
        // TODO: Check if that works
    }

    public int getBlockPower() {
        return getCanaryWorld().getBlockPower(getCanaryBlock());
    }

    public int getBlockPower(BlockFace face) {
        throw new NotImplementedException("getBlockPower(BlockFace)");
    }

    public Chunk getChunk() {
        return new CanaryChunk(getCanaryWorld().getChunk(getX(), getZ()), new CanaryWorld(getCanaryWorld()));
    }

    public byte getData() {
        return (byte) getCanaryBlock().getData();
    }

    public Collection<ItemStack> getDrops() {
        throw new NotImplementedException("getDrops()");
    }

    public Collection<ItemStack> getDrops(ItemStack tool) {
        throw new NotImplementedException("getDrops(ItemStack)");
    }

    public BlockFace getFace(Block block) {
        for (BlockFace blockFace : BlockFace.values()) {
            if (getRelative(blockFace).equals(block)) {
                return blockFace;
            }
        }
        return null;
    }

    public double getHumidity() {
        return getCanaryWorld().getBiome(getX(), getZ()).getRainfall();
    }

    public byte getLightFromBlocks() {
        throw new NotImplementedException("getLightFromBlocks()");
    }

    public byte getLightFromSky() {
        throw new NotImplementedException("getLightFromSky()");
    }

    public byte getLightLevel() {
        return (byte) getCanaryWorld().getLightLevelAt(getX(), getY(), getZ());
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
        throw new NotImplementedException("getMetadata(String)");
    }

    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException("getPistonMoveReaction()");
    }

    public Block getRelative(BlockFace face) {
        return getRelative(face, 1);
    }

    public Block getRelative(BlockFace face, int distance) {
        return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
    }

    public Block getRelative(int modX, int modY, int modZ) {
        return new CanaryBlock(getCanaryBlock().getRelative(modX, modY, modZ));
    }

    public BlockState getState() {
        throw new NotImplementedException("getState()");
    }

    public double getTemperature() {
        return getCanaryWorld().getBiome(getX(), getZ()).getTemperature();
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
        throw new NotImplementedException("hasMetadata(String)");
    }

    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new NotImplementedException("isBlockFaceIndirectlyPowered(BlockFace)");
    }

    public boolean isBlockFacePowered(BlockFace face) {
        throw new NotImplementedException("isBlockFacePowered(BlockFace)");
    }

    public boolean isBlockIndirectlyPowered() {
        return getCanaryWorld().isBlockIndirectlyPowered(getCanaryBlock());
    }

    public boolean isBlockPowered() {
        return getCanaryWorld().isBlockPowered(getCanaryBlock());
    }

    public boolean isEmpty() {
        return getCanaryBlock().isAir();
    }

    public boolean isLiquid() {
        return (getType() == Material.WATER) || (getType() == Material.STATIONARY_WATER)
                || (getType() == Material.LAVA) || (getType() == Material.STATIONARY_LAVA);
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException("removeMetadata(String, Plugin)");
    }

    public void setBiome(Biome bio) {
        block.getWorld().setBiome(block.getX(), block.getZ(), BiomeType.valueOf(bio.name()));
        // TODO: Check if that works
    }

    public void setData(byte data) {
        getCanaryBlock().setData(data);
    }

    public void setData(byte data, boolean applyPhysics) {
        setData(data);
        if (applyPhysics)
            getCanaryBlock().update();
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException("setMetadata(String, MetadataValue)");
    }

    public void setType(Material type) {
        getCanaryBlock().setType(CanaryUtils.getBlockType(type));
    }

    public boolean setTypeId(int type) {
        boolean ret = getCanaryBlock().getTypeId() != type;
        getCanaryBlock().setTypeId((short) type);
        return ret;
    }

    public boolean setTypeId(int type, boolean applyPhysics) {
        boolean ret = setTypeId(type);
        if (applyPhysics)
            getCanaryBlock().update();
        return ret;
    }

    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        setData(data);
        return setTypeId(type, applyPhysics);
    }

    protected net.canarymod.api.world.blocks.Block getCanaryBlock() {
        return block;
    }

    protected net.canarymod.api.world.World getCanaryWorld() {
        return block.getWorld();
    }

    public boolean equals(Object object) {
        return ((object instanceof CanaryBlock || object instanceof net.canarymod.api.world.blocks.Block) && object
                .equals(getCanaryBlock()));
    }
}
