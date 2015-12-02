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
import org.bukkit.entity.IronGolem;

public class CanaryIronGolem extends CanaryGolem implements IronGolem {

    public CanaryIronGolem(net.canarymod.api.entity.living.IronGolem entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.IRON_GOLEM;
    }

    public boolean isPlayerCreated() {
        return getHandle().isPlayerCreated();
    }

    public void setPlayerCreated(boolean playerCreated) {
        getHandle().setPlayerCreated(playerCreated);
    }

    @Override
    protected net.canarymod.api.entity.living.IronGolem getHandle() {
        return (net.canarymod.api.entity.living.IronGolem) super.getHandle();
    }
}
