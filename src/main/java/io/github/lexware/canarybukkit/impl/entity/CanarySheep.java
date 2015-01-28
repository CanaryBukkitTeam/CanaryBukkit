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

import io.github.lexware.canarybukkit.util.converter.DyeColorConverter;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class CanarySheep extends CanaryAnimals implements Sheep {
    public CanarySheep(net.canarymod.api.entity.living.animal.Sheep entity) {
        super(entity);
    }

    public DyeColor getColor() {
        return DyeColorConverter.of(getHandle().getColor());
    }

    public EntityType getType() {
        return EntityType.SHEEP;
    }

    public boolean isSheared() {
        return getHandle().isSheared();
    }

    public void setColor(DyeColor color) {
        getHandle().setColor(DyeColorConverter.of(color));
    }

    public void setSheared(boolean flag) {
        getHandle().setSheared(flag);
    }

    @Override
    protected net.canarymod.api.entity.living.animal.Sheep getHandle() {
        return (net.canarymod.api.entity.living.animal.Sheep) super.getHandle();
    }
}
