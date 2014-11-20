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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

public class CanarySlime extends CanaryLivingEntity implements Slime {
    public CanarySlime(net.canarymod.api.entity.living.monster.Slime entity) {
        super(entity);
    }

    public int getSize() {
        return getEntity().getSize().getByte();
    }

    public EntityType getType() {
        return EntityType.SLIME;
    }

    public void setSize(int size) {
        getEntity().setSize(net.canarymod.api.entity.living.monster.Slime.Size.fromByte((byte) size));
    }

    protected net.canarymod.api.entity.living.monster.Slime getEntity() {
        return (net.canarymod.api.entity.living.monster.Slime) super.getEntity();
    }

}
