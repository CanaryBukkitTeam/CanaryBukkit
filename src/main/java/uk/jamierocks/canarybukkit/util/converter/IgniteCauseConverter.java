/*
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
import net.canarymod.hook.world.IgnitionHook;
import org.bukkit.event.block.BlockIgniteEvent;

public class IgniteCauseConverter {
    private static BiMap<IgnitionHook.IgnitionCause, BlockIgniteEvent.IgniteCause> map =
            ImmutableBiMap.<IgnitionHook.IgnitionCause, BlockIgniteEvent.IgniteCause>builder()
                    .put(IgnitionHook.IgnitionCause.FIREBALL_CLICK, BlockIgniteEvent.IgniteCause.FIREBALL)
                    .put(IgnitionHook.IgnitionCause.FIREBALL_HIT, BlockIgniteEvent.IgniteCause.FIREBALL)
                    .put(IgnitionHook.IgnitionCause.FLINT_AND_STEEL, BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL)
                    .put(IgnitionHook.IgnitionCause.LAVA, BlockIgniteEvent.IgniteCause.LAVA)
                    .put(IgnitionHook.IgnitionCause.BURNT, BlockIgniteEvent.IgniteCause.LAVA)
                    .put(IgnitionHook.IgnitionCause.LIGHTNING_STRIKE, BlockIgniteEvent.IgniteCause.LIGHTNING)
                    .build();

    public static IgnitionHook.IgnitionCause of(BlockIgniteEvent.IgniteCause gameMode) {
        return map.inverse().get(gameMode);
    }

    public static BlockIgniteEvent.IgniteCause of(IgnitionHook.IgnitionCause gameMode) {
        return map.get(gameMode);
    }
}
