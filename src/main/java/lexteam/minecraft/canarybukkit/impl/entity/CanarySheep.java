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
package lexteam.minecraft.canarybukkit.impl.entity;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class CanarySheep extends CanaryAnimals implements Sheep {
    public CanarySheep(net.canarymod.api.entity.living.animal.Sheep entity) {
        super(entity);
    }

    public DyeColor getColor() {
        return BukkitUtils.getDyeColor(getEntity().getColor());
    }

    public EntityType getType() {
        return EntityType.SHEEP;
    }

    public boolean isSheared() {
        return getEntity().isSheared();
    }

    public void setColor(DyeColor color) {
        getEntity().setColor(CanaryUtils.getDyeColor(color));
    }

    public void setSheared(boolean flag) {
        getEntity().setSheared(flag);
    }

    @Override
    protected net.canarymod.api.entity.living.animal.Sheep getEntity() {
        return (net.canarymod.api.entity.living.animal.Sheep) super.getEntity();
    }
}
