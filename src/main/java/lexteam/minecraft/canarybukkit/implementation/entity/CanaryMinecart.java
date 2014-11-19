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
import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;

public abstract class CanaryMinecart extends CanaryVehicle implements Minecart {
    public CanaryMinecart(net.canarymod.api.entity.vehicle.Minecart entity) {
        super(entity);
    }

    public void _INVALID_setDamage(int damage) {
        throw new NotImplementedException();
    }

    public void setDamage(double damage) {
        throw new NotImplementedException();
    }

    public int _INVALID_getDamage() {
        throw new NotImplementedException();
    }

    public double getDamage() {
        throw new NotImplementedException();
    }

    public double getMaxSpeed() {
        throw new NotImplementedException();
    }

    public void setMaxSpeed(double speed) {
        throw new NotImplementedException();
    }

    public boolean isSlowWhenEmpty() {
        throw new NotImplementedException();
    }

    public void setSlowWhenEmpty(boolean slow) {
        throw new NotImplementedException();
    }

    public Vector getFlyingVelocityMod() {
        throw new NotImplementedException();
    }

    public void setFlyingVelocityMod(Vector flying) {
        throw new NotImplementedException();
    }

    public Vector getDerailedVelocityMod() {
        throw new NotImplementedException();
    }

    public void setDerailedVelocityMod(Vector derailed) {
        throw new NotImplementedException();
    }
}
