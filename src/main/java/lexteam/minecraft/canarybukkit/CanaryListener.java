/**
 * This file is part of CanaryBukkit, a CanaryMod plugin, licensed under the MIT License (MIT).
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
package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.implementation.CanaryChunk;
import lexteam.minecraft.canarybukkit.implementation.CanaryLocation;
import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;
import lexteam.minecraft.canarybukkit.implementation.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryLightningStrike;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.hook.player.ChatHook;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.hook.player.EnchantHook;
import net.canarymod.hook.player.PlayerDeathHook;
import net.canarymod.hook.player.TeleportHook;
import net.canarymod.hook.system.LoadWorldHook;
import net.canarymod.hook.system.ServerListPingHook;
import net.canarymod.hook.system.UnloadWorldHook;
import net.canarymod.hook.world.ChunkLoadedHook;
import net.canarymod.hook.world.ChunkUnloadHook;
import net.canarymod.hook.world.LightningStrikeHook;
import net.canarymod.plugin.PluginListener;

public class CanaryListener implements PluginListener {
    private CanaryServer server;

    public CanaryListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
    public void onPlayerJoin(ConnectionHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerJoinEvent(new CanaryPlayer(hook.getPlayer()), hook
                        .getMessage()));
    }

    @HookHandler
    public void onPlayerQuit(DisconnectionHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerQuitEvent(new CanaryPlayer(hook.getPlayer()), hook
                        .getLeaveMessage()));
    }

    @HookHandler
    public void onPlayerDeath(PlayerDeathHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.entity.PlayerDeathEvent(new CanaryPlayer(hook.getPlayer()), null, hook
                        .getPlayer().getExperience(), hook.getDeathMessage1().getFullText()));
        // TODO: Fill in and check.
    }

    @HookHandler
    public void blockDestroy(BlockDestroyHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockBreakEvent(new CanaryBlock(hook.getBlock()),
                        new CanaryPlayer(hook.getPlayer())));
    }

    @HookHandler
    public void blockPlace(BlockPlaceHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockPlaceEvent(new CanaryBlock(hook.getBlockPlaced()), null,
                        new CanaryBlock(hook.getBlockClicked()), null, new CanaryPlayer(hook.getPlayer()),
                        hook.isCanceled()));
        // TODO: Fill in and check some of the arguments.
    }

    @HookHandler
    public void onChunkLoad(ChunkLoadedHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.world.ChunkLoadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(
                        hook.getWorld())), hook.isNew()));
    }

    @HookHandler
    public void onChunkUnload(ChunkUnloadHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.world.ChunkUnloadEvent(new CanaryChunk(hook.getChunk(), new CanaryWorld(
                        hook.getWorld()))));
    }

    @HookHandler
    public void onWorldLoad(LoadWorldHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.world.WorldLoadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler
    public void onWorldUnload(UnloadWorldHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.world.WorldUnloadEvent(new CanaryWorld(hook.getWorld())));
    }

    @HookHandler
    public void onTeleportation(TeleportHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerTeleportEvent(new CanaryPlayer(hook.getPlayer()),
                        new CanaryLocation(hook.getPlayer().getLocation(), new CanaryWorld(hook
                                .getDestination().getWorld())), new CanaryLocation(hook.getDestination(),
                                new CanaryWorld(hook.getDestination().getWorld()))));
    }

    @HookHandler
    public void onLightningStrike(LightningStrikeHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.weather.LightningStrikeEvent(new CanaryWorld(hook.getLightningBolt()
                        .getWorld()), new CanaryLightningStrike(hook.getLightningBolt())));
    }

    @HookHandler
    public void onServerListPing(ServerListPingHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.server.ServerListPingEvent(hook.getRequesterAddress(), hook.getMotd(),
                        hook.getCurrentPlayers(), hook.getMaxPlayers()));
    }

    @SuppressWarnings("deprecation")
    @HookHandler
    public void onPlayerChat(ChatHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerChatEvent(new CanaryPlayer(hook.getPlayer()), hook
                        .getMessage()));
        // TODO: Update to newer version
    }

    @HookHandler
    public void onEnchant(EnchantHook hook) {
        server.getPluginManager().callEvent(
                new org.bukkit.event.enchantment.EnchantItemEvent(new CanaryPlayer(hook.getPlayer()), null,
                        new CanaryBlock(hook.getEnchantmentTable().getBlock()), null, 0, null, 0));
        // TODO: Fill in.
    }
}
