package uk.jamierocks.canarybukkit.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.canarymod.hook.player.TeleportHook;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportCauseConverter {

    private static BiMap<PlayerTeleportEvent.TeleportCause, TeleportHook.TeleportCause> map =
            ImmutableBiMap.<PlayerTeleportEvent.TeleportCause, TeleportHook.TeleportCause>builder()
                    .put(PlayerTeleportEvent.TeleportCause.COMMAND, TeleportHook.TeleportCause.COMMAND)
                    .put(PlayerTeleportEvent.TeleportCause.END_PORTAL, TeleportHook.TeleportCause.PORTAL)
                    .put(PlayerTeleportEvent.TeleportCause.ENDER_PEARL, TeleportHook.TeleportCause.UNDEFINED) // ?
                    .put(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL, TeleportHook.TeleportCause.PORTAL)
                    .put(PlayerTeleportEvent.TeleportCause.PLUGIN, TeleportHook.TeleportCause.PLUGIN)
                    .put(PlayerTeleportEvent.TeleportCause.SPECTATE, TeleportHook.TeleportCause.UNDEFINED) // ?
                    .put(PlayerTeleportEvent.TeleportCause.UNKNOWN, TeleportHook.TeleportCause.UNDEFINED)
                    .build();

    public static TeleportHook.TeleportCause of(PlayerTeleportEvent.TeleportCause teleportCause) {
        return TeleportCauseConverter.map.get(teleportCause);
    }

    public static PlayerTeleportEvent.TeleportCause of(TeleportHook.TeleportCause teleportCause) {
        return TeleportCauseConverter.map.inverse().get(teleportCause);
    }
}
