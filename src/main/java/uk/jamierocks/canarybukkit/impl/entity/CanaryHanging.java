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
package uk.jamierocks.canarybukkit.impl.entity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public abstract class CanaryHanging extends CanaryEntity implements Hanging {
    public CanaryHanging(net.canarymod.api.entity.hanging.HangingEntity entity) {
        super(entity);
    }

    public BlockFace getAttachedFace() {
        throw new NotImplementedException("getAttachedFace()");
    }

    public void setFacingDirection(BlockFace face) {
        throw new NotImplementedException("setFacingDirection(BlockFace)");
    }

    public BlockFace getFacing() {
        throw new NotImplementedException("getFacing()");
    }

    public boolean setFacingDirection(BlockFace face, boolean force) {
        throw new NotImplementedException("setFacingDirection(BlockFace, boolean");
    }

    @Override
    protected net.canarymod.api.entity.hanging.HangingEntity getHandle() {
        return (net.canarymod.api.entity.hanging.HangingEntity) super.getHandle();
    }
}
