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
package uk.jamierocks.canarybukkit.event;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.command.PlayerCommandHook;
import net.canarymod.hook.player.BedEnterHook;
import net.canarymod.hook.player.BedExitHook;
import net.canarymod.hook.player.ChatHook;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.hook.player.EnchantHook;
import net.canarymod.hook.player.PlayerDeathHook;
import net.canarymod.hook.player.TeleportHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;
import org.bukkit.Location;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import uk.jamierocks.canarybukkit.BukkitUtils;
import uk.jamierocks.canarybukkit.impl.CanaryLocation;
import uk.jamierocks.canarybukkit.impl.CanaryServer;
import uk.jamierocks.canarybukkit.impl.CanaryWorld;
import uk.jamierocks.canarybukkit.impl.block.CanaryBlock;
import uk.jamierocks.canarybukkit.impl.command.CanaryCommandSender;
import uk.jamierocks.canarybukkit.impl.entity.CanaryPlayer;
import uk.jamierocks.canarybukkit.util.converter.TeleportCauseConverter;

import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Set;

public class CanaryPlayerListener implements PluginListener {

    private CanaryServer server;

    public CanaryPlayerListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onCommand(final PlayerCommandHook hook) {
        String command = "";
        for (String s : hook.getCommand()) {
            command += s + " ";
        }
        PlayerCommandPreprocessEvent event =
                new PlayerCommandPreprocessEvent(new CanaryPlayer(hook.getPlayer()), command) {
                    @Override
                    public void setMessage(String msg) {
                        super.setMessage(msg);
                        // Set command
                    }
                };
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
        if (server.dispatchCommand(new CanaryCommandSender(hook.getPlayer()), command)) {
            hook.setCanceled(); //TODO: is this the best possible way?
        }
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onEnchant(final EnchantHook hook) {
        EnchantItemEvent event = new EnchantItemEvent(new CanaryPlayer(hook.getPlayer()), null, new CanaryBlock(hook
                .getEnchantmentTable().getBlock()), null, 0, null, 0) {
            @Override
            public void setExpLevelCost(int level) {
                super.setExpLevelCost(level);
                // How can you do this in Canary?
            }
        };
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
        // TODO: Fill in.
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onEnteringBed(final BedEnterHook hook) {
        PlayerBedEnterEvent event =
                new PlayerBedEnterEvent(new CanaryPlayer(hook.getPlayer()), new CanaryBlock(hook.getBed()));
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onExitingBed(final BedExitHook hook) {
        server.getPluginManager().callEvent(
                new PlayerBedLeaveEvent(new CanaryPlayer(hook.getPlayer()), new CanaryBlock(hook.getBed())));
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onPlayerChat(final ChatHook hook) {
        Set<org.bukkit.entity.Player> recievers = new HashSet<org.bukkit.entity.Player>();
        for (Player p : hook.getReceiverList()) {
            recievers.add(new CanaryPlayer(p));
        }
        AsyncPlayerChatEvent event =
                new AsyncPlayerChatEvent(false, new CanaryPlayer(hook.getPlayer()), hook.getMessage(), recievers) {
                    @Override
                    public void setMessage(String message) {
                        super.setMessage(message);
                        hook.setMessage(message);
                    }

                    @Override
                    public void setFormat(final String format) throws IllegalFormatException, NullPointerException {
                        super.setFormat(format);
                        hook.setFormat(format);
                    }
                };
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
        // TODO: Fill in
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onPlayerDeath(final PlayerDeathHook hook) {
        server.getPluginManager().callEvent(
                new PlayerDeathEvent(new CanaryPlayer(hook.getPlayer()), null, hook.getPlayer().getExperience(), hook
                        .getDeathMessage1().getFullText()) {
                    @Override
                    public void setDeathMessage(String deathMessage) {
                        super.setDeathMessage(deathMessage);
                        hook.setDeathMessage1(
                                Canary.factory().getChatComponentFactory().newChatComponent(deathMessage));
                    }

                    @Override
                    public void setNewExp(int exp) {
                        super.setNewExp(exp);
                        // How can you do this in Canary?
                    }

                    @Override
                    public void setNewLevel(int level) {
                        super.setNewLevel(level);
                        // How can you do this in Canary?
                    }

                    @Override
                    public void setNewTotalExp(int totalExp) {
                        super.setNewTotalExp(totalExp);
                        // How can you do this in Canary?
                    }

                    @Override
                    public void setKeepLevel(boolean keepLevel) {
                        super.setKeepLevel(keepLevel);
                        // How can you do this in Canary?
                    }

                    @Override
                    public void setKeepInventory(boolean keepInventory) {
                        super.setKeepInventory(keepInventory);
                        // How can you do this in Canary?
                    }
                });
        // TODO: Fill in and check.
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onPlayerJoin(final ConnectionHook hook) {
        server.getPluginManager().callEvent(new PlayerJoinEvent(new CanaryPlayer(hook.getPlayer()), hook.getMessage()) {
            @Override
            public void setJoinMessage(String joinMessage) {
                super.setJoinMessage(joinMessage);
                hook.setMessage(joinMessage);
            }
        });
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onPlayerQuit(final DisconnectionHook hook) {
        server.getPluginManager().callEvent(
                new PlayerQuitEvent(new CanaryPlayer(hook.getPlayer()), hook.getLeaveMessage()) {
                    @Override
                    public void setQuitMessage(String quitMessage) {
                        super.setQuitMessage(quitMessage);
                        hook.setLeaveMessage(quitMessage);
                    }
                });
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onTeleportation(final TeleportHook hook) {
        PlayerTeleportEvent event =
                new PlayerTeleportEvent(new CanaryPlayer(hook.getPlayer()), new CanaryLocation(hook.getPlayer()
                        .getLocation(), new CanaryWorld(hook.getDestination().getWorld())), new CanaryLocation(hook
                        .getDestination(), new CanaryWorld(hook.getDestination().getWorld())),
                        TeleportCauseConverter.of(hook.getTeleportReason())) {
                    @Override
                    public void setFrom(Location from) {
                        super.setFrom(from);
                        // How can you do this in Canary?
                    }

                    @Override
                    public void setTo(Location to) {
                        super.setTo(to);
                        // How can you do this in Canary?
                    }
                };
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }
}
