/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit.events;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

import lexteam.minecraft.canarybukkit.implementation.CanaryChunk;
import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;
import lexteam.minecraft.canarybukkit.implementation.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryLightningStrike;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.hook.system.LoadWorldHook;
import net.canarymod.hook.system.UnloadWorldHook;
import net.canarymod.hook.world.ChunkLoadedHook;
import net.canarymod.hook.world.ChunkUnloadHook;
import net.canarymod.hook.world.LightningStrikeHook;
import net.canarymod.plugin.PluginListener;

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
    public void onWorldLoad(LoadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldLoadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler
    public void onWorldUnload(UnloadWorldHook hook) {
        server.getPluginManager().callEvent(new WorldUnloadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler
    public void onLightningStrike(LightningStrikeHook hook) {
        server.getPluginManager().callEvent(
                new LightningStrikeEvent(new CanaryWorld(hook.getLightningBolt().getWorld()),
                        new CanaryLightningStrike(hook.getLightningBolt())));
    }
}
