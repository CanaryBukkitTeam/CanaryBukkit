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
import org.bukkit.entity.Explosive;

public abstract class CanaryExplosive extends CanaryEntity implements Explosive {
    public CanaryExplosive(net.canarymod.api.entity.Entity entity) {
        super(entity);
    }

    public float getYield() {
        return getExplosive().getPower();
    }

    public void setYield(float yield) {
        getExplosive().setPower(yield);
    }

    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException("setIsIncendiary(boolean)");
    }

    public boolean isIncendiary() {
        throw new NotImplementedException("isIncendiary()");
    }

    protected net.canarymod.api.entity.Explosive getExplosive() {
        if (getEntity() instanceof net.canarymod.api.entity.Explosive) {
            return (net.canarymod.api.entity.Explosive) getEntity();
        }
        return null;
    }

    @Override
    protected net.canarymod.api.entity.Entity getEntity() {
        return super.getEntity();
    }
}
