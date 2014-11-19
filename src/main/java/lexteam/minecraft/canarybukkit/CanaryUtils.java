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

import net.canarymod.api.DyeColor;
import net.canarymod.api.GameMode;
import net.canarymod.api.entity.living.animal.Ocelot.SkinType;
import net.canarymod.api.entity.living.humanoid.Villager.Profession;
import net.canarymod.api.world.BiomeType;
import net.canarymod.api.world.DimensionType;
import net.canarymod.api.world.World.Difficulty;
import net.canarymod.api.world.WorldType;

import org.apache.commons.lang.Validate;

public class CanaryUtils {
    public static Difficulty getDifficulty(org.bukkit.Difficulty difficulty) {
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

    public static DyeColor getDyeColor(org.bukkit.DyeColor color) {
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

    public static GameMode getGameMode(org.bukkit.GameMode gm) {
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

    public static WorldType getWorldType(org.bukkit.WorldType type) {
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

    public static Profession getProfession(org.bukkit.entity.Villager.Profession profession) {
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
        Validate.notNull(type);
        switch (type) {
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

    public static DimensionType getEnviroment(org.bukkit.World.Environment type) {
        Validate.notNull(type);
        switch (type) {
            case NETHER:
                return DimensionType.NETHER;
            case NORMAL:
                return DimensionType.NORMAL;
            case THE_END:
                return DimensionType.END;
            default:
                return DimensionType.fromName(type.name());
        }
    }

    public static BiomeType getBiome(org.bukkit.block.Biome biome) {
        Validate.notNull(biome);
        switch (biome) {
            case BEACH:
                return BiomeType.BEACH;
            case BIRCH_FOREST:
                return BiomeType.FOREST_BIRCH;
            case BIRCH_FOREST_HILLS:
                return BiomeType.HILLS_FOREST_BIRCH;
            case BIRCH_FOREST_HILLS_MOUNTAINS:
                return BiomeType.HILLS_FOREST_BIRCH; // TODO: check.
            case BIRCH_FOREST_MOUNTAINS:
                return BiomeType.HILLS_FOREST_BIRCH; // TODO: check.
            case COLD_BEACH:
                return BiomeType.BEACH_COLD;
            case COLD_TAIGA:
                return BiomeType.TAIGA_COLD;
            case COLD_TAIGA_HILLS:
                return BiomeType.HILLS_TAIGA_COLD;
            case COLD_TAIGA_MOUNTAINS:
                return BiomeType.HILLS_TAIGA_COLD; // TODO: check.
            case DEEP_OCEAN:
                return BiomeType.OCEAN_DEEP;
            case DESERT:
                return BiomeType.DESERT;
            case DESERT_HILLS:
                return BiomeType.HILLS_DESERT;
            case DESERT_MOUNTAINS:
                return BiomeType.HILLS_DESERT; // TODO: check.
            case EXTREME_HILLS:
                return BiomeType.HILLS_EXTREME;
            case EXTREME_HILLS_MOUNTAINS:
                return BiomeType.HILLS_EXTREME; // TODO: check.
            case EXTREME_HILLS_PLUS:
                return BiomeType.HILLS_EXTREME_PLUS;
            case EXTREME_HILLS_PLUS_MOUNTAINS:
                return BiomeType.HILLS_EXTREME_PLUS; // TODO: check.
            case FLOWER_FOREST:
                return BiomeType.FOREST; // TODO: check.
            case FOREST:
                return BiomeType.FOREST;
            case FOREST_HILLS:
                return BiomeType.HILLS_FOREST;
            case FROZEN_OCEAN:
                return BiomeType.OCEAN_FROZEN;
            case FROZEN_RIVER:
                return BiomeType.RIVER_FROZEN;
            case HELL:
                return BiomeType.HELL;
            case ICE_MOUNTAINS:
                return BiomeType.MOUNTAINS_ICE;
            case ICE_PLAINS:
                return BiomeType.PLAINS_ICE;
            case ICE_PLAINS_SPIKES:
                return BiomeType.PLAINS_ICE; // TODO: check.
            case JUNGLE:
                return BiomeType.JUNGLE;
            case JUNGLE_EDGE:
                return BiomeType.JUNGLE;
            case JUNGLE_EDGE_MOUNTAINS:
                return BiomeType.JUNGLE_EDGE; // TODO: check.
            case JUNGLE_HILLS:
                return BiomeType.HILLS_JUNGLE;
            case JUNGLE_MOUNTAINS:
                return BiomeType.HILLS_JUNGLE; // TODO: check.
            case MEGA_SPRUCE_TAIGA:
                return BiomeType.TAIGA_MEGA; // TODO: check.
            case MEGA_SPRUCE_TAIGA_HILLS:
                return BiomeType.HILLS_TAIGA_MEGA; // TODO: check.
            case MEGA_TAIGA:
                return BiomeType.TAIGA_MEGA;
            case MEGA_TAIGA_HILLS:
                return BiomeType.HILLS_TAIGA_MEGA;
            case MESA:
                return BiomeType.MESA;
            case MESA_BRYCE:
                return BiomeType.MESA; // TODO check.
            case MESA_PLATEAU:
                return BiomeType.MESA; // TODO check.
            case MESA_PLATEAU_FOREST:
                return BiomeType.MESA; // TODO check.
            case MESA_PLATEAU_FOREST_MOUNTAINS:
                return BiomeType.MESA; // TODO check.
            case MESA_PLATEAU_MOUNTAINS:
                return BiomeType.MESA; // TODO check.
            case MUSHROOM_ISLAND:
                return BiomeType.MUSHROOM_ISLAND;
            case MUSHROOM_SHORE:
                return BiomeType.MUSHROOM_ISLAND_SHORE; // TODO: check.
            case OCEAN:
                return BiomeType.OCEAN;
            case PLAINS:
                return BiomeType.PLAINS;
            case RIVER:
                return BiomeType.RIVER;
            case ROOFED_FOREST:
                return BiomeType.FOREST_ROOFED;
            case ROOFED_FOREST_MOUNTAINS:
                return BiomeType.FOREST_ROOFED; // TODO: check.
            case SAVANNA:
                return BiomeType.SAVANNA;
            case SAVANNA_MOUNTAINS:
                return BiomeType.SAVANNA; // TODO: check.
            case SAVANNA_PLATEAU:
                return BiomeType.SAVANNA; // TODO: check.
            case SAVANNA_PLATEAU_MOUNTAINS:
                return BiomeType.SAVANNA; // TODO: check.
            case SKY:
                return BiomeType.SKY;
            case SMALL_MOUNTAINS:
                return BiomeType.HILLS_JUNGLE; // TODO: check.
            case STONE_BEACH:
                return BiomeType.BEACH_STONE;
            case SUNFLOWER_PLAINS:
                return BiomeType.PLAINS; // TODO: check.
            case SWAMPLAND:
                return BiomeType.SWAMPLAND;
            case SWAMPLAND_MOUNTAINS:
                return BiomeType.SWAMPLAND; // TODO: check.
            case TAIGA:
                return BiomeType.TAIGA;
            case TAIGA_HILLS:
                return BiomeType.TAIGA; // TODO: check.
            case TAIGA_MOUNTAINS:
                return BiomeType.TAIGA; // TODO: check.
            default:
                return BiomeType.PLAINS;
        }
    }
}
