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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class CanaryFirework extends CanaryEntity implements Firework {
    public CanaryFirework(net.canarymod.api.entity.FireworkRocket entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.FIREWORK;
    }

    public FireworkMeta getFireworkMeta() {
        throw new NotImplementedException("getFireworkMeta()");
    }

    public void setFireworkMeta(FireworkMeta meta) {
        throw new NotImplementedException("setFireworkMeta(FireworkMeta)");
    }

    public void detonate() {
        throw new NotImplementedException("detonate()");
    }

    @Override
    protected net.canarymod.api.entity.FireworkRocket getHandle() {
        return (net.canarymod.api.entity.FireworkRocket) super.getHandle();
    }
}
