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
package uk.jamierocks.canarybukkit.impl.block;

import io.github.lexware.unolib.Wrapper;
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
import uk.jamierocks.canarybukkit.CanaryUtils;
import uk.jamierocks.canarybukkit.impl.CanaryChunk;
import uk.jamierocks.canarybukkit.impl.CanaryWorld;

import java.util.Collection;
import java.util.List;

public class CanaryBlock extends Wrapper<net.canarymod.api.world.blocks.Block> implements Block {

    public CanaryBlock(net.canarymod.api.world.blocks.Block block) {
        super(block);
    }

    @Override
    public boolean breakNaturally() {
        throw new NotImplementedException("breakNaturally()");
    }

    @Override
    public boolean breakNaturally(ItemStack tool) {
        throw new NotImplementedException("breakNaturally(ItemStack)");
    }

    @Override
    public Biome getBiome() {
        return Biome.valueOf(getCanaryWorld().getBiome(this.getHandle().getX(), this.getHandle().getZ()).getBiomeType()
                .name());
        // TODO: Check if that works
    }

    @Override
    public void setBiome(Biome bio) {
        getHandle().getWorld().setBiome(this.getHandle().getX(),
                this.getHandle().getZ(), BiomeType.valueOf(bio.name()));
        // TODO: Check if that works
    }

    @Override
    public int getBlockPower() {
        return this.getCanaryWorld().getBlockPower(getHandle());
    }

    @Override
    public int getBlockPower(BlockFace face) {
        throw new NotImplementedException("getBlockPower(BlockFace)");
    }

    @Override
    public Chunk getChunk() {
        return new CanaryChunk(this.getCanaryWorld().getChunk(this.getX(), this.getZ()),
                new CanaryWorld(this.getCanaryWorld()));
    }

    @Override
    public byte getData() {
        return (byte) this.getHandle().getData();
    }

    @Override
    public void setData(byte data) {
        this.getHandle().setData(data);
    }

    @Override
    public Collection<ItemStack> getDrops() {
        throw new NotImplementedException("getDrops()");
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack tool) {
        throw new NotImplementedException("getDrops(ItemStack)");
    }

    @Override
    public BlockFace getFace(Block block) {
        for (BlockFace blockFace : BlockFace.values()) {
            if (this.getRelative(blockFace).equals(block)) {
                return blockFace;
            }
        }
        return null;
    }

    @Override
    public double getHumidity() {
        return this.getCanaryWorld().getBiome(this.getX(), this.getZ()).getRainfall();
    }

    @Override
    public byte getLightFromBlocks() {
        throw new NotImplementedException("getLightFromBlocks()");
    }

    @Override
    public byte getLightFromSky() {
        throw new NotImplementedException("getLightFromSky()");
    }

    @Override
    public byte getLightLevel() {
        return (byte) this.getCanaryWorld().getLightLevelAt(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public Location getLocation() {
        return new Location(new CanaryWorld(this.getHandle().getWorld()), this.getHandle().getX(),
                this.getHandle().getY(), this.getHandle().getZ());
    }

    @Override
    public Location getLocation(Location loc) {
        if (loc != null) {
            loc.setWorld(this.getWorld());
            loc.setX(this.getX());
            loc.setY(this.getY());
            loc.setZ(this.getX());
        }
        return loc;
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException("getMetadata(String)");
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException("getPistonMoveReaction()");
    }

    @Override
    public Block getRelative(BlockFace face) {
        return this.getRelative(face, 1);
    }

    @Override
    public Block getRelative(BlockFace face, int distance) {
        return this.getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
    }

    @Override
    public Block getRelative(int modX, int modY, int modZ) {
        return new CanaryBlock(this.getHandle().getRelative(modX, modY, modZ));
    }

    @Override
    public BlockState getState() {
        throw new NotImplementedException("getState()");
    }

    @Override
    public double getTemperature() {
        return this.getCanaryWorld().getBiome(this.getX(), this.getZ()).getTemperature();
    }

    @Override
    public Material getType() {
        return Material.getMaterial(this.getTypeId());
    }

    @Override
    public void setType(Material type) {
        this.getHandle().setType(CanaryUtils.getBlockType(type));
    }

    @Override
    public int getTypeId() {
        return this.getHandle().getTypeId();
    }

    @Override
    public World getWorld() {
        return new CanaryWorld(this.getHandle().getWorld());
    }

    @Override
    public int getX() {
        return this.getHandle().getX();
    }

    @Override
    public int getY() {
        return this.getHandle().getY();
    }

    @Override
    public int getZ() {
        return this.getHandle().getZ();
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException("hasMetadata(String)");
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new NotImplementedException("isBlockFaceIndirectlyPowered(BlockFace)");
    }

    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        throw new NotImplementedException("isBlockFacePowered(BlockFace)");
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return this.getCanaryWorld().isBlockIndirectlyPowered(this.getHandle());
    }

    @Override
    public boolean isBlockPowered() {
        return this.getCanaryWorld().isBlockPowered(this.getHandle());
    }

    @Override
    public boolean isEmpty() {
        return this.getHandle().isAir();
    }

    @Override
    public boolean isLiquid() {
        return (this.getType() == Material.WATER) || (this.getType() == Material.STATIONARY_WATER)
                || (this.getType() == Material.LAVA) || (this.getType() == Material.STATIONARY_LAVA);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException("removeMetadata(String, Plugin)");
    }

    @Override
    public void setData(byte data, boolean applyPhysics) {
        this.setData(data);
        if (applyPhysics) {
            this.getHandle().update();
        }
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException("setMetadata(String, MetadataValue)");
    }

    @Override
    public void setType(Material type, boolean applyPhysics) {
        this.setType(type);
        if (applyPhysics) {
            this.getHandle().update();
        }
    }

    @Override
    public boolean setTypeId(int type) {
        boolean ret = this.getHandle().getTypeId() != type;
        this.getHandle().setTypeId((short) type);
        return ret;
    }

    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        boolean ret = this.setTypeId(type);
        if (applyPhysics) {
            this.getHandle().update();
        }
        return ret;
    }

    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        this.setData(data);
        return this.setTypeId(type, applyPhysics);
    }

    protected net.canarymod.api.world.World getCanaryWorld() {
        return this.getHandle().getWorld();
    }

    @Override
    public boolean equals(Object object) {
        return ((object instanceof CanaryBlock || object instanceof net.canarymod.api.world.blocks.Block)
                && object.equals(this.getHandle()));
    }
}
