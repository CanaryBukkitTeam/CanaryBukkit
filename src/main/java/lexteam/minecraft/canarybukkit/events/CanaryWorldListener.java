/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014 Lexteam
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
package lexteam.minecraft.canarybukkit.events;

import lexteam.minecraft.canarybukkit.impl.CanaryChunk;
import lexteam.minecraft.canarybukkit.impl.CanaryServer;
import lexteam.minecraft.canarybukkit.impl.CanaryWorld;
import lexteam.minecraft.canarybukkit.impl.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.impl.entity.CanaryLightningStrike;
import lexteam.minecraft.canarybukkit.impl.entity.CanaryPlayer;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.hook.system.LoadWorldHook;
import net.canarymod.hook.system.UnloadWorldHook;
import net.canarymod.hook.world.BlockGrowHook;
import net.canarymod.hook.world.ChunkLoadedHook;
import net.canarymod.hook.world.ChunkUnloadHook;
import net.canarymod.hook.world.LightningStrikeHook;
import net.canarymod.hook.world.WeatherChangeHook;
import net.canarymod.plugin.PluginListener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class CanaryWorldListener implements PluginListener {
    private CanaryServer server;

    public CanaryWorldListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
    public void blockDestroy(BlockDestroyHook hook) {
        server.getPluginManager().callEvent(
                new BlockBreakEvent(new CanaryBlock(hook.getBlock()), new CanaryPlayer(hook.getPlayer())));
    }

    @HookHandler
    public void blockPlace(BlockPlaceHook hook) {
        server.getPluginManager().callEvent(
                new BlockPlaceEvent(new CanaryBlock(hook.getBlockPlaced()), null, new CanaryBlock(hook
                        .getBlockClicked()), null, new CanaryPlayer(hook.getPlayer()), hook.isCanceled()));
        // TODO: Fill in and check some of the arguments.
    }

    @HookHandler
    public void onBlockGrowth(BlockGrowHook hook) {
        server.getPluginManager().callEvent(new BlockGrowEvent(new CanaryBlock(hook.getOriginal()), null));
        // TODO: Fill in second argument
    }

    @HookHandler
    public void onChunkLoad(ChunkLoadedHook hook) {
        server.getPluginManager().callEvent(
                new ChunkLoadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(hook.getWorld())), hook
                        .isNew()));
    }

    @HookHandler
    public void onChunkUnload(ChunkUnloadHook hook) {
        server.getPluginManager().callEvent(
                new ChunkUnloadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(hook.getWorld()))));
    }

    @HookHandler
    public void onLightningStrike(LightningStrikeHook hook) {
        server.getPluginManager().callEvent(
                new LightningStrikeEvent(new CanaryWorld(hook.getLightningBolt().getWorld()),
                        new CanaryLightningStrike(hook.getLightningBolt())));
    }

    @HookHandler
    public void onWeatherChange(WeatherChangeHook hook) {
        server.getPluginManager().callEvent(
                new WeatherChangeEvent(new CanaryWorld(hook.getWorld()), hook.turningOn()));
    }

    @HookHandler
    public void onWorldLoad(LoadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldLoadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler
    public void onWorldUnload(UnloadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldUnloadEvent(new CanaryWorld(hook.getWorld())));
    }
}
