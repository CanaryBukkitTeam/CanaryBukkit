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
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class CanaryBoat extends CanaryVehicle implements Boat {
    public CanaryBoat(net.canarymod.api.entity.vehicle.Boat entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.BOAT;
    }

    public double getMaxSpeed() {
        throw new NotImplementedException("getMaxSpeed()");
    }

    public void setMaxSpeed(double speed) {
        throw new NotImplementedException("setMaxSpeed(double)");
    }

    public double getOccupiedDeceleration() {
        throw new NotImplementedException("getOccupiedDeceleration()");
    }

    public void setOccupiedDeceleration(double rate) {
        throw new NotImplementedException("setOccupiedDeceleration(double)");
    }

    public double getUnoccupiedDeceleration() {
        throw new NotImplementedException("getUnoccupiedDeceleration()");
    }

    public void setUnoccupiedDeceleration(double rate) {
        throw new NotImplementedException("setUnoccupiedDeceleration(double)");
    }

    public boolean getWorkOnLand() {
        throw new NotImplementedException("getWorkOnLand()");
    }

    public void setWorkOnLand(boolean workOnLand) {
        throw new NotImplementedException("setWorkOnLand(boolean)");
    }

    protected net.canarymod.api.entity.vehicle.Boat getEntity() {
        return (net.canarymod.api.entity.vehicle.Boat) super.getEntity();
    }
}
