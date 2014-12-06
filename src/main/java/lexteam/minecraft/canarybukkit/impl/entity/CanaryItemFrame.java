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
import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

public class CanaryItemFrame extends CanaryHanging implements ItemFrame {
    public CanaryItemFrame(net.canarymod.api.entity.hanging.ItemFrame entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.ITEM_FRAME;
    }

    public ItemStack getItem() {
        throw new NotImplementedException("getItem()");
    }

    public void setItem(ItemStack item) {
        throw new NotImplementedException("setItem(ItemStack)");
    }

    public Rotation getRotation() {
        if (getEntity().getItemRotation() == 0) {
            return Rotation.NONE;
        } else if (getEntity().getItemRotation() == 1) {
            return Rotation.CLOCKWISE;
        } else if (getEntity().getItemRotation() == 2) {
            return Rotation.FLIPPED;
        } else {
            return Rotation.COUNTER_CLOCKWISE;
        }
    }

    public void setRotation(Rotation rotation) throws IllegalArgumentException {
        switch (rotation) {
            case CLOCKWISE:
                getEntity().setItemRotation(0);
                break;
            case COUNTER_CLOCKWISE:
                getEntity().setItemRotation(1);
                break;
            case FLIPPED:
                getEntity().setItemRotation(2);
                break;
            case NONE:
                getEntity().setItemRotation(3);
                break;
        }
    }

    @Override
    protected net.canarymod.api.entity.hanging.ItemFrame getEntity() {
        return (net.canarymod.api.entity.hanging.ItemFrame) super.getEntity();
    }
}
