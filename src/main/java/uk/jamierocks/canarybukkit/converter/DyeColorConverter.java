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
package uk.jamierocks.canarybukkit.converter;

import org.bukkit.DyeColor;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class DyeColorConverter {
    private static BiMap<DyeColor, net.canarymod.api.DyeColor> map =
            ImmutableBiMap.<DyeColor, net.canarymod.api.DyeColor>builder()
                    .put(DyeColor.BLACK, net.canarymod.api.DyeColor.BLACK)
                    .put(DyeColor.BLUE, net.canarymod.api.DyeColor.BLUE)
                    .put(DyeColor.BROWN, net.canarymod.api.DyeColor.BROWN)
                    .put(DyeColor.CYAN, net.canarymod.api.DyeColor.CYAN)
                    .put(DyeColor.GREEN, net.canarymod.api.DyeColor.GREEN)
                    .put(DyeColor.GRAY, net.canarymod.api.DyeColor.GRAY)
                    .put(DyeColor.LIME, net.canarymod.api.DyeColor.LIME)
                    .put(DyeColor.MAGENTA, net.canarymod.api.DyeColor.MAGENTA)
                    .put(DyeColor.ORANGE, net.canarymod.api.DyeColor.ORANGE)
                    .put(DyeColor.PINK, net.canarymod.api.DyeColor.ORANGE)
                    .put(DyeColor.PURPLE, net.canarymod.api.DyeColor.ORANGE)
                    .put(DyeColor.RED, net.canarymod.api.DyeColor.ORANGE)
                    .put(DyeColor.YELLOW, net.canarymod.api.DyeColor.YELLOW)
                    .put(DyeColor.WHITE, net.canarymod.api.DyeColor.WHITE)
                    .build();

    public static net.canarymod.api.DyeColor of(DyeColor dyeColor) {
        return map.get(dyeColor);
    }

    public static DyeColor of(net.canarymod.api.DyeColor dyeColor) {
        return map.inverse().get(dyeColor);
    }
}
