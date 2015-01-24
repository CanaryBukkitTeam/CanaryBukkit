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
import org.bukkit.entity.Ageable;

public abstract class CanaryAgeable extends CanaryCreature implements Ageable {
    public CanaryAgeable(net.canarymod.api.entity.living.LivingBase entity) {
        super(entity);
    }

    public boolean canBreed() {
        return getAge() >= 0;
    }

    public int getAge() {
        if (getEntity() instanceof net.canarymod.api.entity.living.Ageable) {
            return ((net.canarymod.api.entity.living.Ageable) getEntity()).getGrowingAge();
        } else {
            return 0;
        }
    }

    public boolean getAgeLock() {
        return false;
    }

    public boolean isAdult() {
        return getAge() >= 0;
    }

    public void setAdult() {
        if (!isAdult()) {
            setAge(0);
        }
    }

    public void setAge(int age) {
        if (getEntity() instanceof net.canarymod.api.entity.living.Ageable) {
            ((net.canarymod.api.entity.living.Ageable) getEntity()).setGrowingAge(age);
        }
    }

    public void setAgeLock(boolean lock) {
        throw new NotImplementedException("setAgeLock(boolean)");
    }

    public void setBaby() {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    public void setBreed(boolean breed) {
        throw new NotImplementedException("setBreed(boolean)");
    }

    @Override
    protected net.canarymod.api.entity.living.LivingBase getHandle() {
        return (net.canarymod.api.entity.living.LivingBase) super.getHandle();
    }
}
