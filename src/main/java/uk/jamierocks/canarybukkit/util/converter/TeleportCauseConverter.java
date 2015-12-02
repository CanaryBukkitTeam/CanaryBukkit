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

import com.google.common.collect.Maps;
import net.canarymod.hook.player.TeleportHook;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Map;

public class TeleportCauseConverter {

    private static Map<PlayerTeleportEvent.TeleportCause, TeleportHook.TeleportCause> toCanary = Maps.newHashMap();
    private static Map<TeleportHook.TeleportCause, PlayerTeleportEvent.TeleportCause> toBukkit = Maps.newHashMap();

    static {
        toCanary.put(PlayerTeleportEvent.TeleportCause.COMMAND, TeleportHook.TeleportCause.COMMAND);
        toCanary.put(PlayerTeleportEvent.TeleportCause.COMMAND, TeleportHook.TeleportCause.COMMAND);
        toCanary.put(PlayerTeleportEvent.TeleportCause.END_PORTAL, TeleportHook.TeleportCause.PORTAL);
        toCanary.put(PlayerTeleportEvent.TeleportCause.ENDER_PEARL, TeleportHook.TeleportCause.UNDEFINED);
        toCanary.put(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL, TeleportHook.TeleportCause.PORTAL);
        toCanary.put(PlayerTeleportEvent.TeleportCause.PLUGIN, TeleportHook.TeleportCause.PLUGIN);
        toCanary.put(PlayerTeleportEvent.TeleportCause.SPECTATE, TeleportHook.TeleportCause.UNDEFINED);
        toCanary.put(PlayerTeleportEvent.TeleportCause.UNKNOWN, TeleportHook.TeleportCause.UNDEFINED);

        toBukkit.put(TeleportHook.TeleportCause.BED, PlayerTeleportEvent.TeleportCause.UNKNOWN);
        toBukkit.put(TeleportHook.TeleportCause.COMMAND, PlayerTeleportEvent.TeleportCause.COMMAND);
        toBukkit.put(TeleportHook.TeleportCause.MOUNT_CHANGE, PlayerTeleportEvent.TeleportCause.UNKNOWN);
        toBukkit.put(TeleportHook.TeleportCause.MOVEMENT, PlayerTeleportEvent.TeleportCause.UNKNOWN);
        toBukkit.put(TeleportHook.TeleportCause.PLUGIN, PlayerTeleportEvent.TeleportCause.PLUGIN);
        toBukkit.put(TeleportHook.TeleportCause.PORTAL, PlayerTeleportEvent.TeleportCause.NETHER_PORTAL);
        toBukkit.put(TeleportHook.TeleportCause.RESPAWN, PlayerTeleportEvent.TeleportCause.UNKNOWN);
        toBukkit.put(TeleportHook.TeleportCause.UNDEFINED, PlayerTeleportEvent.TeleportCause.UNKNOWN);
        toBukkit.put(TeleportHook.TeleportCause.WARP, PlayerTeleportEvent.TeleportCause.UNKNOWN);
    }

    public static TeleportHook.TeleportCause of(PlayerTeleportEvent.TeleportCause teleportCause) {
        return TeleportCauseConverter.toCanary.get(teleportCause);
    }

    public static PlayerTeleportEvent.TeleportCause of(TeleportHook.TeleportCause teleportCause) {
        return TeleportCauseConverter.toBukkit.get(teleportCause);
    }
}
