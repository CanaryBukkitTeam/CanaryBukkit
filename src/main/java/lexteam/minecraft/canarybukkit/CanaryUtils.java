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

import net.canarymod.api.DyeColor;
import net.canarymod.api.GameMode;
import net.canarymod.api.entity.living.animal.Ocelot.SkinType;
import net.canarymod.api.entity.living.humanoid.Villager.Profession;
import net.canarymod.api.world.World.Difficulty;
import net.canarymod.api.world.WorldType;

import org.apache.commons.lang.Validate;

public class CanaryUtils
{
    public static Difficulty getDifficulty(org.bukkit.Difficulty difficulty)
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

    public static DyeColor getDyeColor(org.bukkit.DyeColor color)
    {
        Validate.notNull(color);
        switch (color) {
            case BLACK:
                return DyeColor.BLACK;
            case BLUE:
                return DyeColor.BLUE;
            case BROWN:
                return DyeColor.BROWN;
            case CYAN:
                return DyeColor.CYAN;
            case GREEN:
                return DyeColor.GREEN;
            case LIGHT_BLUE:
                return DyeColor.LIGHT_BLUE;
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

    public static GameMode getGameMode(org.bukkit.GameMode gm)
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

    public static WorldType getWorldType(org.bukkit.WorldType type)
    {
        Validate.notNull(type);
        switch (type) {
            case AMPLIFIED:
                return WorldType.AMPLIFIED;
            case FLAT:
                return WorldType.SUPERFLAT;
            case LARGE_BIOMES:
                return WorldType.LARGEBIOMES;
            case VERSION_1_1:
                return WorldType.DEFAULT_1_1;
            case NORMAL:
            default:
                return WorldType.DEFAULT;
        }
    }

    public static Profession getProfession(org.bukkit.entity.Villager.Profession profession)
    {
        Validate.notNull(profession);
        switch (profession) {
            case BLACKSMITH:
                return Profession.BLACKSMITH;
            case BUTCHER:
                return Profession.BUTCHER;
            case LIBRARIAN:
                return Profession.LIBRARIAN;
            case PRIEST:
                return Profession.PRIEST;
            case FARMER:
            default:
                return Profession.FARMER;
        }
    }
    
    public static SkinType getCatType(org.bukkit.entity.Ocelot.Type type) {
        switch(type) {
            case BLACK_CAT:
                return SkinType.TUXEDO;
            case RED_CAT:
                return SkinType.GINGER;
            case SIAMESE_CAT:
                return SkinType.SIAMESE;
            case WILD_OCELOT:
            default:
                return SkinType.UNTAME;
        }
    }
}
