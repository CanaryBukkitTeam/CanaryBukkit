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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public abstract class CanaryCreature extends CanaryLivingEntity implements Creature {
    public CanaryCreature(net.canarymod.api.entity.living.LivingBase entity) {
        super(entity);
    }

    public LivingEntity getTarget() {
        return (LivingEntity) BukkitUtils.getEntity(getEntity().getRevengeTarget());
    }

    public void setTarget(LivingEntity target) {
        throw new NotImplementedException("setTarget(LivingEntity)");
    }
}