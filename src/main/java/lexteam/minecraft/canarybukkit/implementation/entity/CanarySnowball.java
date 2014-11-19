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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.projectiles.ProjectileSource;

public class CanarySnowball extends CanaryAbstractProjectile implements Snowball {
    public CanarySnowball(net.canarymod.api.entity.throwable.Snowball entity) {
        super(entity);
    }

    public LivingEntity _INVALID_getShooter() {
        throw new NotImplementedException();
    }

    public void _INVALID_setShooter(LivingEntity shooter) {
        throw new NotImplementedException();
    }

    public ProjectileSource getShooter() {
        throw new NotImplementedException();
    }

    public EntityType getType() {
        return EntityType.SNOWBALL;
    }

    public void setShooter(ProjectileSource source) {
        throw new NotImplementedException();
    }
}
