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

import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;

public class CanaryEnderman extends CanaryMonster implements Enderman {
    public CanaryEnderman(net.canarymod.api.entity.living.monster.Enderman entity) {
        super(entity);
    }

    public MaterialData getCarriedMaterial() {
        return new MaterialData(getHandle().getCarriedBlockID());
    }

    public EntityType getType() {
        return EntityType.ENDERMAN;
    }

    public void setCarriedMaterial(MaterialData material) {
        getHandle().setCarriedBlockID((short) material.getItemTypeId());
        // TODO: Check
    }

    protected net.canarymod.api.entity.living.monster.Enderman getHandle() {
        return (net.canarymod.api.entity.living.monster.Enderman) super.getHandle();
    }
}
