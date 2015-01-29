/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014-2015 CanaryBukkitTeam
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
package io.github.lexware.canarybukkit;

import com.google.common.base.Preconditions;
import io.github.lexware.canarybukkit.impl.entity.CanaryArrow;
import io.github.lexware.canarybukkit.impl.entity.CanaryChicken;
import io.github.lexware.canarybukkit.impl.entity.CanaryCow;
import io.github.lexware.canarybukkit.impl.entity.CanaryEgg;
import io.github.lexware.canarybukkit.impl.entity.CanaryHorse;
import io.github.lexware.canarybukkit.impl.entity.CanaryPig;
import io.github.lexware.canarybukkit.impl.entity.CanarySheep;
import io.github.lexware.canarybukkit.impl.entity.CanaryWolf;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BukkitUtils {
    public static Entity getEntity(net.canarymod.api.entity.Entity cEntity) {
        Preconditions.checkNotNull(cEntity);
        if (cEntity instanceof net.canarymod.api.entity.Projectile) {
            if (cEntity instanceof net.canarymod.api.entity.Arrow) {
                return new CanaryArrow((net.canarymod.api.entity.Arrow) cEntity);
            } else if (cEntity instanceof net.canarymod.api.entity.throwable.ChickenEgg) {
                return new CanaryEgg((net.canarymod.api.entity.throwable.ChickenEgg) cEntity);
            }
        } else if (cEntity instanceof net.canarymod.api.entity.living.LivingBase) {
            if (cEntity instanceof net.canarymod.api.entity.living.animal.Tameable) {
                if (cEntity instanceof net.canarymod.api.entity.living.animal.Wolf) {
                    return new CanaryWolf((net.canarymod.api.entity.living.animal.Wolf) cEntity);
                }
            } else if (cEntity instanceof net.canarymod.api.entity.living.animal.EntityAnimal) {
                if (cEntity instanceof net.canarymod.api.entity.living.animal.Chicken) {
                    return new CanaryChicken((net.canarymod.api.entity.living.animal.Chicken) cEntity);
                } else if (cEntity instanceof net.canarymod.api.entity.living.animal.Cow) {
                    return new CanaryCow((net.canarymod.api.entity.living.animal.Cow) cEntity);
                } else if (cEntity instanceof net.canarymod.api.entity.living.animal.Horse) {
                    return new CanaryHorse((net.canarymod.api.entity.living.animal.Horse) cEntity);
                } else if (cEntity instanceof net.canarymod.api.entity.living.animal.Pig) {
                    return new CanaryPig((net.canarymod.api.entity.living.animal.Pig) cEntity);
                } else if (cEntity instanceof net.canarymod.api.entity.living.animal.Sheep) {
                    return new CanarySheep((net.canarymod.api.entity.living.animal.Sheep) cEntity);
                }
            }
        }
        return null;
    }

    public static PotionEffectType getPotionEffectType(net.canarymod.api.potion.PotionEffectType potionEffectType) {
        Preconditions.checkNotNull(potionEffectType);
        return PotionEffectType.getByName(potionEffectType.name());
    }

    public static PotionEffect getPotionEffect(net.canarymod.api.potion.PotionEffect potionEffect) {
        Preconditions.checkNotNull(potionEffect);
        return new PotionEffect(getPotionEffectType(CanaryUtils.getPotionEffectType(potionEffect.getPotionID())),
                potionEffect.getDuration(), potionEffect.getAmplifier(), potionEffect.isAmbient());
    }

    public static TeleportCause getTeleportCause(net.canarymod.hook.player.TeleportHook.TeleportCause cause) {
        Preconditions.checkNotNull(cause);
        switch (cause) {
            case BED:
                return TeleportCause.UNKNOWN;
            case COMMAND:
                return TeleportCause.COMMAND;
            case MOUNT_CHANGE:
                return TeleportCause.UNKNOWN;
            case MOVEMENT:
                return TeleportCause.UNKNOWN;
            case PLUGIN:
                return TeleportCause.PLUGIN;
            case PORTAL:
                return TeleportCause.NETHER_PORTAL;
            case RESPAWN:
                return TeleportCause.UNKNOWN;
            case UNDEFINED:
                return TeleportCause.UNKNOWN;
            case WARP:
                return TeleportCause.UNKNOWN;
            default:
                return TeleportCause.UNKNOWN;
        }
    }

    public static IgniteCause getIgniteCause(net.canarymod.hook.world.IgnitionHook.IgnitionCause cause) {
        Preconditions.checkNotNull(cause);
        switch (cause) {
            case FIREBALL_CLICK:
                return IgniteCause.FIREBALL;
            case FIREBALL_HIT:
                return IgniteCause.FIREBALL;
            case FIRE_SPREAD:
                return IgniteCause.SPREAD;
            case FLINT_AND_STEEL:
                return IgniteCause.FLINT_AND_STEEL;
            case LAVA:
                return IgniteCause.LAVA;
            case LIGHTNING_STRIKE:
                return IgniteCause.LIGHTNING;
            case UNDEFINED:
            default:
                return IgniteCause.EXPLOSION;
        }
    }
}
