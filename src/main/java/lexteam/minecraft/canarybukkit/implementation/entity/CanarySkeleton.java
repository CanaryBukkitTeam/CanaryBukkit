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
import org.bukkit.entity.Skeleton;

public class CanarySkeleton extends CanaryMonster implements Skeleton {
    private net.canarymod.api.entity.living.monster.Skeleton entity;

    public CanarySkeleton(net.canarymod.api.entity.living.monster.Skeleton entity) {
        super(entity);
        this.entity = entity;
    }

    public EntityType getType() {
        return EntityType.SKELETON;
    }

    public SkeletonType getSkeletonType() {
        if (entity.isWitherSkeleton()) {
            return SkeletonType.WITHER;
        } else {
            return SkeletonType.NORMAL;
        }
    }

    public void setSkeletonType(SkeletonType type) {
        switch (type) {
            case WITHER:
                entity.setIsWitherSkeleton(true);
            case NORMAL:
            default:
                entity.setIsWitherSkeleton(false);
        }
    }
}
