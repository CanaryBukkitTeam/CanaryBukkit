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

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.canarymod.api.world.World;
import org.bukkit.Difficulty;

public class DifficultyConverter {
    private static BiMap<Difficulty, World.Difficulty> map =
            ImmutableBiMap.<Difficulty, World.Difficulty>builder()
                    .put(Difficulty.EASY, World.Difficulty.EASY)
                    .put(Difficulty.HARD, World.Difficulty.HARD)
                    .put(Difficulty.PEACEFUL, World.Difficulty.PEACEFUL)
                    .put(Difficulty.NORMAL, World.Difficulty.NORMAL)
                    .build();

    public static net.canarymod.api.world.World.Difficulty of(Difficulty difficulty) {
        return map.get(difficulty);
    }

    public static Difficulty of(net.canarymod.api.world.World.Difficulty difficulty) {
        return map.inverse().get(difficulty);
    }
}
