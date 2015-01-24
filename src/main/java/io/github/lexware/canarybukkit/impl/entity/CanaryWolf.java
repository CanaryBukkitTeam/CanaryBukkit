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
package io.github.lexware.canarybukkit.impl.entity;

import io.github.lexware.canarybukkit.CanaryUtils;
import io.github.lexware.canarybukkit.BukkitUtils;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class CanaryWolf extends CanaryTameable implements Wolf {
    public CanaryWolf(net.canarymod.api.entity.living.animal.Wolf entity) {
        super(entity);
    }

    public DyeColor getCollarColor() {
        return BukkitUtils.getDyeColor(getEntity().getCollarColor());
    }

    public EntityType getType() {
        return EntityType.WOLF;
    }

    public boolean isAngry() {
        return getEntity().isAngry();
    }

    public boolean isSitting() {
        return getEntity().isSitting();
    }

    public void setAngry(boolean angry) {
        getEntity().setAngry(angry);
    }

    public void setCollarColor(DyeColor color) {
        getEntity().setCollarColor(CanaryUtils.getDyeColor(color));
    }

    public void setSitting(boolean sitting) {
        getEntity().setSitting(sitting);
    }

    @Override
    protected net.canarymod.api.entity.living.animal.Wolf getEntity() {
        return (net.canarymod.api.entity.living.animal.Wolf) super.getEntity();
    }
}
