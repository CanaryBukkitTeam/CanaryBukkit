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
package uk.jamierocks.canarybukkit.util.converter;

import org.bukkit.WorldType;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class WorldTypeConverter {
    private static BiMap<WorldType, net.canarymod.api.world.WorldType> map =
            ImmutableBiMap.<WorldType, net.canarymod.api.world.WorldType>builder()
                    .put(WorldType.NORMAL, net.canarymod.api.world.WorldType.DEFAULT)
                    .put(WorldType.AMPLIFIED, net.canarymod.api.world.WorldType.AMPLIFIED)
                    .put(WorldType.FLAT, net.canarymod.api.world.WorldType.SUPERFLAT)
                    .put(WorldType.LARGE_BIOMES, net.canarymod.api.world.WorldType.LARGEBIOMES)
                    .put(WorldType.VERSION_1_1, net.canarymod.api.world.WorldType.DEFAULT_1_1)
                    .build();

    public static net.canarymod.api.world.WorldType of(WorldType worldType) {
        return map.get(worldType);
    }

    public static WorldType of(net.canarymod.api.world.WorldType worldType) {
        return map.inverse().get(worldType);
    }
}
