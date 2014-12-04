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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

public class CanaryPigZombie extends CanaryZombie implements PigZombie {
    private net.canarymod.api.entity.living.monster.PigZombie entity;

    public CanaryPigZombie(net.canarymod.api.entity.living.monster.PigZombie entity) {
        super(entity);
        this.entity = entity;
    }

    public int getAnger() {
        return entity.getAngerLevel();
    }

    @Override
    public EntityType getType() {
        return EntityType.PIG_ZOMBIE;
    }

    public boolean isAngry() {
        return entity.isAngry();
    }

    public void setAnger(int level) {
        entity.setAngerLevel(level);
    }

    public void setAngry(boolean angry) {
        setAnger(angry ? 400 : 0);
    }
}
