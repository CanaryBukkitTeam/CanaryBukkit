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
package lexteam.minecraft.canarybukkit.impl.entity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

public abstract class CanaryProjectile extends CanaryEntity implements Projectile {
    private boolean doesBounce;

    public CanaryProjectile(net.canarymod.api.entity.Projectile entity) {
        super(entity);
        doesBounce = false;
    }

    public boolean doesBounce() {
        return doesBounce;
    }

    public void setBounce(boolean doesBounce) {
        this.doesBounce = doesBounce;
    }

    public LivingEntity _INVALID_getShooter() {
        throw new NotImplementedException("_INVALID_getShooter()");
    }

    public void _INVALID_setShooter(LivingEntity shooter) {
        throw new NotImplementedException("_INVALID_setShooter(LivingEntity)");
    }

    public ProjectileSource getShooter() {
        throw new NotImplementedException("getShooter()");
    }

    public void setShooter(ProjectileSource source) {
        throw new NotImplementedException("setShooter(ProjectileSource)");
    }

    protected net.canarymod.api.entity.Projectile getEntity() {
        return (net.canarymod.api.entity.Projectile) super.getEntity();
    }
}
