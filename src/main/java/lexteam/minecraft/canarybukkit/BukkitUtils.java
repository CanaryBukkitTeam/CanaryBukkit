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
package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.implementation.entity.CanaryArrow;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryChicken;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryCow;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryEgg;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryHorse;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPig;
import lexteam.minecraft.canarybukkit.implementation.entity.CanarySheep;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryWolf;

import org.apache.commons.lang.Validate;
import org.bukkit.Art;
import org.bukkit.Difficulty;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.entity.Villager.Profession;

public class BukkitUtils {
    public static Difficulty getDifficulty(net.canarymod.api.world.World.Difficulty difficulty) {
        Validate.notNull(difficulty);
        switch (difficulty) {
            case EASY:
                return Difficulty.EASY;
            case HARD:
                return Difficulty.HARD;
            case PEACEFUL:
                return Difficulty.PEACEFUL;
            case NORMAL:
            default:
                return Difficulty.NORMAL;
        }
    }

    public static DyeColor getDyeColor(net.canarymod.api.DyeColor color) {
        Validate.notNull(color);
        switch (color) {
            case BLACK:
                return DyeColor.BLACK;
            case BLUE:
                return DyeColor.BLUE;
            case BROWN:
                return DyeColor.BROWN;
            case CUSTOM:
                return null; // TODO: Does Bukkit have custom DyeColor's?
            case CYAN:
                return DyeColor.CYAN;
            case GREEN:
                return DyeColor.GREEN;
            case LIGHT_BLUE:
                return DyeColor.LIGHT_BLUE;
            case LIGHT_GRAY:
            case GRAY:
                return DyeColor.GRAY;
            case LIME:
                return DyeColor.LIME;
            case MAGENTA:
                return DyeColor.MAGENTA;
            case ORANGE:
                return DyeColor.ORANGE;
            case PINK:
                return DyeColor.PINK;
            case PURPLE:
                return DyeColor.PURPLE;
            case RED:
                return DyeColor.RED;
            case YELLOW:
                return DyeColor.YELLOW;
            case WHITE:
            default:
                return DyeColor.WHITE;
        }
    }

    public static GameMode getGameMode(net.canarymod.api.GameMode gm) {
        Validate.notNull(gm);
        switch (gm) {
            case ADVENTURE:
                return GameMode.ADVENTURE;
            case CREATIVE:
                return GameMode.CREATIVE;
            case SURVIVAL:
            default:
                return GameMode.SURVIVAL;
        }
    }

    public static WorldType getWorldType(net.canarymod.api.world.WorldType type) {
        Validate.notNull(type);
        if (type == net.canarymod.api.world.WorldType.AMPLIFIED) {
            return WorldType.AMPLIFIED;
        }
        if (type == net.canarymod.api.world.WorldType.SUPERFLAT) {
            return WorldType.FLAT;
        }
        if (type == net.canarymod.api.world.WorldType.LARGEBIOMES) {
            return WorldType.LARGE_BIOMES;
        }
        if (type == net.canarymod.api.world.WorldType.DEFAULT_1_1) {
            return WorldType.VERSION_1_1;
        }
        return WorldType.NORMAL;
    }

    public static Profession getProfession(
            net.canarymod.api.entity.living.humanoid.Villager.Profession profession) {
        Validate.notNull(profession);
        switch (profession) {
            case BLACKSMITH:
                return Profession.BLACKSMITH;
            case BUTCHER:
                return Profession.BUTCHER;
            case FARMER:
                return Profession.FARMER;
            case LIBRARIAN:
                return Profession.LIBRARIAN;
            case PRIEST:
                return Profession.PRIEST;
            case VILLAGER:
            default:
                return Profession.FARMER;
        }
    }

    public static Type getCatType(net.canarymod.api.entity.living.animal.Ocelot.SkinType type) {
        Validate.notNull(type);
        switch (type) {
            case GINGER:
                return Type.RED_CAT;
            case SIAMESE:
                return Type.SIAMESE_CAT;
            case TUXEDO:
                return Type.BLACK_CAT;
            case UNTAME:
            default:
                return Type.WILD_OCELOT;
        }
    }

    public static Environment getEnviroment(net.canarymod.api.world.DimensionType type) {
        Validate.notNull(type);
        if (type == net.canarymod.api.world.DimensionType.NORMAL) {
            return Environment.NORMAL;
        } else if (type == net.canarymod.api.world.DimensionType.NETHER) {
            return Environment.NETHER;
        } else if (type == net.canarymod.api.world.DimensionType.NETHER) {
            return Environment.NETHER;
        } else {
            return Environment.valueOf(type.getName());
        }
    }

    public static Art getArt(net.canarymod.api.entity.hanging.Painting.ArtType art) {
        switch (art) {
            case Alban:
                return Art.ALBAN;
            case Aztec:
                return Art.AZTEC;
            case Aztec2:
                return Art.AZTEC2;
            case Bomb:
                return Art.BOMB;
            case BurningSkull:
                return Art.BURNINGSKULL;
            case Bust:
                return Art.BUST;
            case Courbet:
                return Art.COURBET;
            case Creebet:
                return Art.CREEBET;
            case DonkeyKong:
                return Art.DONKEYKONG;
            case Fighters:
                return Art.FIGHTERS;
            case Graham:
                return Art.GRAHAM;
            case Kebab:
                return Art.KEBAB;
            case Match:
                return Art.MATCH;
            case Pigscene:
                return Art.PIGSCENE;
            case Plant:
                return Art.PLANT;
            case Pointer:
                return Art.POINTER;
            case Pool:
                return Art.POOL;
            case Sea:
                return Art.SEA;
            case Skeleton:
                return Art.SKELETON;
            case SkullAndRoses:
                return Art.SKULL_AND_ROSES;
            case Stage:
                return Art.STAGE;
            case Sunset:
                return Art.SUNSET;
            case Void:
                return Art.VOID;
            case Wanderer:
                return Art.WANDERER;
            case Wasteland:
                return Art.WASTELAND;
            case Wither:
                return Art.WITHER;
            default:
                return Art.valueOf(art.name());
        }
    }

    public static Entity getEntity(net.canarymod.api.entity.Entity cEntity) {
        Validate.notNull(cEntity);
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
}
