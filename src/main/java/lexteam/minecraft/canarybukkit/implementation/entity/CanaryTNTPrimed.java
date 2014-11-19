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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

public class CanaryTNTPrimed extends CanaryEntity implements TNTPrimed {
    private net.canarymod.api.entity.TNTPrimed entity;

    public CanaryTNTPrimed(net.canarymod.api.entity.TNTPrimed entity) {
        super(entity);
        this.entity = entity;
    }

    public void setYield(float yield) {
        throw new NotImplementedException();
    }

    public float getYield() {
        throw new NotImplementedException();
    }

    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException();
    }

    public boolean isIncendiary() {
        throw new NotImplementedException();
    }

    public EntityType getType() {
        return EntityType.PRIMED_TNT;
    }

    public void setFuseTicks(int fuseTicks) {
        entity.setFuse(fuseTicks);
    }

    public int getFuseTicks() {
        return entity.getFuse();
    }

    public org.bukkit.entity.Entity getSource() {
        return BukkitUtils.getEntity(entity.getActivatedBy());
    }
}
