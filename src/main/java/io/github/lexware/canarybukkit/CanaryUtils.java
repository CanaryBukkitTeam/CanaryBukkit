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
import net.canarymod.Canary;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionEffectType;
import net.canarymod.api.world.BiomeType;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.position.Location;

import org.bukkit.Material;

public class CanaryUtils {
    public static BiomeType getBiome(org.bukkit.block.Biome biome) {
        Preconditions.checkNotNull(biome);
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

    public static BlockType getBlockType(Material material) {
        Preconditions.checkNotNull(material);
        return BlockType.fromId(material.getId());
    }

    public static PotionEffectType getPotionEffectType(int id) {
        Preconditions.checkNotNull(id);
        return PotionEffectType.fromId(id);
    }

    public static PotionEffectType getPotionEffectType(org.bukkit.potion.PotionEffectType potionEffectType) {
        Preconditions.checkNotNull(potionEffectType);
        return PotionEffectType.fromName(potionEffectType.getName());
    }

    public static PotionEffect getPotionEffect(org.bukkit.potion.PotionEffect potionEffect) {
        Preconditions.checkNotNull(potionEffect);
        return Canary
                .factory()
                .getPotionFactory()
                .newPotionEffect(getPotionEffectType(potionEffect.getType()), potionEffect.getDuration(),
                        potionEffect.getAmplifier(), potionEffect.isAmbient());
    }

    public static World getWorld(org.bukkit.World world) {
        Preconditions.checkNotNull(world);
        return Canary.getServer().getWorld(world.getName());
    }

    public static Location getLocation(org.bukkit.Location location) {
        Preconditions.checkNotNull(location);
        return new Location(getWorld(location.getWorld()), location.getX(), location.getY(), location.getZ(),
                location.getPitch(), location.getYaw());
    }
}
