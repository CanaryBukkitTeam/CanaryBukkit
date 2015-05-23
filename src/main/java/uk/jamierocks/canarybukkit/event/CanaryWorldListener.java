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
package uk.jamierocks.canarybukkit.event;

import uk.jamierocks.canarybukkit.impl.CanaryChunk;
import uk.jamierocks.canarybukkit.impl.CanaryServer;
import uk.jamierocks.canarybukkit.impl.entity.CanaryLightningStrike;
import uk.jamierocks.canarybukkit.impl.CanaryWorld;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.system.LoadWorldHook;
import net.canarymod.hook.system.UnloadWorldHook;
import net.canarymod.hook.world.ChunkLoadedHook;
import net.canarymod.hook.world.ChunkUnloadHook;
import net.canarymod.hook.world.LightningStrikeHook;
import net.canarymod.hook.world.PortalCreateHook;
import net.canarymod.hook.world.WeatherChangeHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;

import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class CanaryWorldListener implements PluginListener {
    private CanaryServer server;

    public CanaryWorldListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onChunkLoad(final ChunkLoadedHook hook) {
        server.getPluginManager().callEvent(
                new ChunkLoadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(hook.getWorld())), hook.isNew()));
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onChunkUnload(final ChunkUnloadHook hook) {
        ChunkUnloadEvent event = new ChunkUnloadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(hook.getWorld())));
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onLightningStrike(final LightningStrikeHook hook) {
        server.getPluginManager().callEvent(
                new LightningStrikeEvent(new CanaryWorld(hook.getLightningBolt().getWorld()),
                        new CanaryLightningStrike(hook.getLightningBolt())) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //LightningStrikeHook isn't a CancelableHook :(
                    }
                });
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onWeatherChange(final WeatherChangeHook hook) {
        WeatherChangeEvent event = new WeatherChangeEvent(new CanaryWorld(hook.getWorld()), hook.turningOn());
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onWorldLoad(final LoadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldLoadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onWorldUnload(final UnloadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldUnloadEvent(new CanaryWorld(hook.getWorld())) {
            @Override
            public void setCancelled(boolean cancelled) {
                super.setCancelled(cancelled);
                //UnloadWorldHook isn't a CancelableHook :(
            }
        });
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onPortalCreation(final PortalCreateHook hook) {
        PortalCreateEvent event = new PortalCreateEvent(null, new CanaryWorld(hook.getWorld()), null);
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }
}
