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

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class CanaryWolf extends CanaryTameable implements Wolf {
    private net.canarymod.api.entity.living.animal.Wolf entity;

    public CanaryWolf(net.canarymod.api.entity.living.animal.Wolf entity) {
        super(entity);
        this.entity = entity;
    }

    public DyeColor getCollarColor() {
        return BukkitUtils.getDyeColor(entity.getCollarColor());
    }

    public EntityType getType() {
        return EntityType.WOLF;
    }

    public boolean isAngry() {
        return entity.isAngry();
    }

    public boolean isSitting() {
        return entity.isSitting();
    }

    public void setAngry(boolean angry) {
        entity.setAngry(angry);
    }

    public void setCollarColor(DyeColor color) {
        entity.setCollarColor(CanaryUtils.getDyeColor(color));
    }

    public void setSitting(boolean sitting) {
        entity.setSitting(sitting);
    }
}
