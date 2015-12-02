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
package uk.jamierocks.canarybukkit.impl.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import uk.jamierocks.canarybukkit.util.converter.CatTypeConverter;

public class CanaryOcelot extends CanaryTameable implements Ocelot {

    public CanaryOcelot(net.canarymod.api.entity.living.animal.Ocelot entity) {
        super(entity);
    }

    public Type getCatType() {
        return CatTypeConverter.of(getHandle().getSkinType());
    }

    public void setCatType(Type type) {
        getHandle().setSkinType(CatTypeConverter.of(type));
    }

    public EntityType getType() {
        return EntityType.OCELOT;
    }

    public boolean isSitting() {
        return getHandle().isSitting();
    }

    public void setSitting(boolean sitting) {
        getHandle().setSitting(sitting);
    }

    @Override
    protected net.canarymod.api.entity.living.animal.Ocelot getHandle() {
        return (net.canarymod.api.entity.living.animal.Ocelot) super.getHandle();
    }
}
