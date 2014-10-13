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
package lexteam.minecraft.canarybukkit.events;

import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import lexteam.minecraft.canarybukkit.implementation.CanaryLocation;
import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;
import lexteam.minecraft.canarybukkit.implementation.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.implementation.command.CanaryCommandSender;
import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.command.PlayerCommandHook;
import net.canarymod.hook.player.ChatHook;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.hook.player.EnchantHook;
import net.canarymod.hook.player.PlayerDeathHook;
import net.canarymod.hook.player.TeleportHook;
import net.canarymod.plugin.PluginListener;

public class CanaryPlayerListener implements PluginListener {
    private CanaryServer server;

    public CanaryPlayerListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
    public void onPlayerJoin(ConnectionHook hook) {
        server.getPluginManager().callEvent(
                new PlayerJoinEvent(new CanaryPlayer(hook.getPlayer()), hook.getMessage()));
    }

    @HookHandler
    public void onPlayerQuit(DisconnectionHook hook) {
        server.getPluginManager().callEvent(
                new PlayerQuitEvent(new CanaryPlayer(hook.getPlayer()), hook.getLeaveMessage()));
    }

    @HookHandler
    public void onPlayerDeath(PlayerDeathHook hook) {
        server.getPluginManager().callEvent(
                new PlayerDeathEvent(new CanaryPlayer(hook.getPlayer()), null, hook.getPlayer()
                        .getExperience(), hook.getDeathMessage1().getFullText()));
        // TODO: Fill in and check.
    }

    @SuppressWarnings("deprecation")
    @HookHandler
    public void onPlayerChat(ChatHook hook) {
        server.getPluginManager().callEvent(
                new PlayerChatEvent(new CanaryPlayer(hook.getPlayer()), hook.getMessage()));
        // TODO: Update to newer version
    }

    @HookHandler
    public void onTeleportation(TeleportHook hook) {
        server.getPluginManager().callEvent(
                new PlayerTeleportEvent(new CanaryPlayer(hook.getPlayer()), new CanaryLocation(hook
                        .getPlayer().getLocation(), new CanaryWorld(hook.getDestination().getWorld())),
                        new CanaryLocation(hook.getDestination(), new CanaryWorld(hook.getDestination()
                                .getWorld()))));
    }

    @HookHandler
    public void onEnchant(EnchantHook hook) {
        server.getPluginManager().callEvent(
                new EnchantItemEvent(new CanaryPlayer(hook.getPlayer()), null, new CanaryBlock(hook
                        .getEnchantmentTable().getBlock()), null, 0, null, 0));
        // TODO: Fill in.
    }

    @HookHandler
    public void onCommand(PlayerCommandHook hook) {
        String commandLine = "";
        for (String s : hook.getCommand()) {
            commandLine += s + " ";
        }
        if (server.dispatchCommand(new CanaryCommandSender(hook.getPlayer()), commandLine)) {
            hook.setCanceled();
        }
    }
}
