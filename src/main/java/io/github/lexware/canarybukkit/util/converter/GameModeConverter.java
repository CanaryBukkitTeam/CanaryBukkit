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
package io.github.lexware.canarybukkit.util.converter;

import org.bukkit.GameMode;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class GameModeConverter {
    private static BiMap<GameMode, net.canarymod.api.GameMode> map =
            ImmutableBiMap.<GameMode, net.canarymod.api.GameMode>builder()
                    .put(GameMode.SURVIVAL, net.canarymod.api.GameMode.SURVIVAL)
                    .put(GameMode.CREATIVE, net.canarymod.api.GameMode.CREATIVE)
                    .put(GameMode.ADVENTURE, net.canarymod.api.GameMode.ADVENTURE)
                    .build();

    public static net.canarymod.api.GameMode of(GameMode gameMode) {
        return map.get(gameMode);
    }

    public static GameMode of(net.canarymod.api.GameMode gameMode) {
        return map.inverse().get(gameMode);
    }
}
