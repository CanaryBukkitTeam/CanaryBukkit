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

import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

public class CanaryItemFrame extends CanaryHanging implements ItemFrame {
    private net.canarymod.api.entity.hanging.ItemFrame entity;

    public CanaryItemFrame(net.canarymod.api.entity.hanging.ItemFrame entity) {
        super(entity);
        this.entity = entity;
    }

    public EntityType getType() {
        return EntityType.ITEM_FRAME;
    }

    public ItemStack getItem() {
        return null;
    }

    public void setItem(ItemStack item) {

    }

    public Rotation getRotation() {
        if (entity.getItemRotation() == 0) {
            return Rotation.NONE;
        } else if (entity.getItemRotation() == 1) {
            return Rotation.CLOCKWISE;
        } else if (entity.getItemRotation() == 2) {
            return Rotation.FLIPPED;
        } else {
            return Rotation.COUNTER_CLOCKWISE;
        }
    }

    public void setRotation(Rotation rotation) throws IllegalArgumentException {
        switch (rotation) {
            case CLOCKWISE:
                entity.setItemRotation(0);
                break;
            case COUNTER_CLOCKWISE:
                entity.setItemRotation(1);
                break;
            case FLIPPED:
                entity.setItemRotation(2);
                break;
            case NONE:
                entity.setItemRotation(3);
                break;
        }
    }
}
