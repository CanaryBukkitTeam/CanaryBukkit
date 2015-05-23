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

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.canarymod.api.world.DimensionType;
import org.bukkit.World;

public class EnvironmentConverter {
    private static BiMap<World.Environment, DimensionType> map =
            ImmutableBiMap.<World.Environment, DimensionType>builder()
                    .put(World.Environment.NORMAL, DimensionType.NORMAL)
                    .put(World.Environment.NETHER, DimensionType.NETHER)
                    .put(World.Environment.THE_END, DimensionType.END)
                    .build();

    public static DimensionType of(World.Environment difficulty) {
        return map.get(difficulty);
    }

    public static World.Environment of(DimensionType difficulty) {
        return map.inverse().get(difficulty);
    }
}
