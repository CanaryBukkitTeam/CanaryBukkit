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
package lexteam.minecraft.canarybukkit.implementation.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public abstract class CanaryHanging extends CanaryEntity implements Hanging {
    public CanaryHanging(net.canarymod.api.entity.hanging.HangingEntity entity) {
        super(entity);
    }

    public BlockFace getAttachedFace() {
        return null;
    }

    public void setFacingDirection(BlockFace face) {

    }

    public BlockFace getFacing() {
        return null;
    }

    public boolean setFacingDirection(BlockFace face, boolean force) {
        return false;
    }
}
