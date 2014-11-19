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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Tameable;

public abstract class CanaryTameable extends CanaryAnimals implements Tameable, Creature {
    private net.canarymod.api.entity.living.animal.Tameable entity;

    public CanaryTameable(net.canarymod.api.entity.living.animal.Tameable entity) {
        super(entity);
        this.entity = entity;
    }

    public AnimalTamer getOwner() {
        throw new NotImplementedException();
    }

    public boolean isTamed() {
        return entity.isTamed();
    }

    public void setOwner(AnimalTamer tamer) {
        throw new NotImplementedException();
    }

    public void setTamed(boolean tame) {
        entity.setTamed(tame);
    }
}
