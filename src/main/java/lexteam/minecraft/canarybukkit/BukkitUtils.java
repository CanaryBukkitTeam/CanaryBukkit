/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
import org.bukkit.Difficulty;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.entity.Villager.Profession;

public class BukkitUtils
{
    public static Difficulty getDifficulty(net.canarymod.api.world.World.Difficulty difficulty)
    {
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

    public static DyeColor getDyeColor(net.canarymod.api.DyeColor color)
    {
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

    public static GameMode getGameMode(net.canarymod.api.GameMode gm)
    {
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

    public static WorldType getWorldType(net.canarymod.api.world.WorldType type)
    {
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
            net.canarymod.api.entity.living.humanoid.Villager.Profession profession)
    {
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

    public static Type getCatType(net.canarymod.api.entity.living.animal.Ocelot.SkinType type)
    {
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

    public static Environment getEnviroment(net.canarymod.api.world.DimensionType type)
    {
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

    public static Entity getEntity(net.canarymod.api.entity.Entity cEntity)
    {
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
