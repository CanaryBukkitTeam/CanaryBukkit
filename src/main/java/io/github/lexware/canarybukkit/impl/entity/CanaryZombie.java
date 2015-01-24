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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class CanaryZombie extends CanaryAgeable implements Zombie {
    public CanaryZombie(net.canarymod.api.entity.living.monster.Zombie entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.ZOMBIE;
    }

    public boolean isBaby() {
        return getHandle().isChild();
    }

    public boolean isVillager() {
        return getHandle().isVillager();
    }

    public void setBaby(boolean flag) {
        getHandle().setChild(flag);
    }

    public void setVillager(boolean flag) {
        getHandle().setVillager(flag);
    }

    @Override
    protected net.canarymod.api.entity.living.monster.Zombie getHandle() {
        return (net.canarymod.api.entity.living.monster.Zombie) super.getHandle();
    }
}
