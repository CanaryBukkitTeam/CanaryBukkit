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
package lexteam.minecraft.canarybukkit.event;

import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Set;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.impl.CanaryLocation;
import lexteam.minecraft.canarybukkit.impl.CanaryServer;
import lexteam.minecraft.canarybukkit.impl.CanaryWorld;
import lexteam.minecraft.canarybukkit.impl.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.impl.command.CanaryCommandSender;
import lexteam.minecraft.canarybukkit.impl.entity.CanaryPlayer;
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

import org.bukkit.Location;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class CanaryPlayerListener implements PluginListener {
    private CanaryServer server;

    public CanaryPlayerListener(CanaryServer server) {
        this.server = server;
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

    @HookHandler
    public void onEnchant(final EnchantHook hook) {
        server.getPluginManager().callEvent(
                new EnchantItemEvent(new CanaryPlayer(hook.getPlayer()), null, new CanaryBlock(hook
                        .getEnchantmentTable().getBlock()), null, 0, null, 0) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }

                    @Override
                    public void setExpLevelCost(int level) {
                        super.setExpLevelCost(level);
                        // How can you do this in Canary?
                    }
                });
        // TODO: Fill in.
    }

    @HookHandler
    public void onEnteringBed(final BedEnterHook hook) {
        server.getPluginManager().callEvent(
                new PlayerBedEnterEvent(new CanaryPlayer(hook.getPlayer()), new CanaryBlock(hook.getBed())) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }
                });
    }

    @HookHandler
    public void onExitingBed(final BedExitHook hook) {
        server.getPluginManager().callEvent(
                new PlayerBedLeaveEvent(new CanaryPlayer(hook.getPlayer()), new CanaryBlock(hook.getBed())));
    }

    @HookHandler
    public void onPlayerChat(final ChatHook hook) {
        Set<org.bukkit.entity.Player> recievers = new HashSet<org.bukkit.entity.Player>();
        for (Player p : hook.getReceiverList()) {
            recievers.add(new CanaryPlayer(p));
        }
        server.getPluginManager().callEvent(
                new AsyncPlayerChatEvent(false, new CanaryPlayer(hook.getPlayer()), hook.getMessage(), recievers) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }

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
                });
        // TODO: Fill in
    }

    @HookHandler
    public void onPlayerDeath(final PlayerDeathHook hook) {
        server.getPluginManager().callEvent(
                new PlayerDeathEvent(new CanaryPlayer(hook.getPlayer()), null, hook.getPlayer().getExperience(), hook
                        .getDeathMessage1().getFullText()) {
                    @Override
                    public void setDeathMessage(String deathMessage) {
                        super.setDeathMessage(deathMessage);
                        hook.setDeathMessage1(Canary.factory().getChatComponentFactory().newChatComponent(deathMessage));
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

    @HookHandler
    public void onPlayerJoin(final ConnectionHook hook) {
        server.getPluginManager().callEvent(new PlayerJoinEvent(new CanaryPlayer(hook.getPlayer()), hook.getMessage()) {
            @Override
            public void setJoinMessage(String joinMessage) {
                super.setJoinMessage(joinMessage);
                hook.setMessage(joinMessage);
            }
        });
    }

    @HookHandler
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

    @HookHandler
    public void onTeleportation(final TeleportHook hook) {
        server.getPluginManager().callEvent(
                new PlayerTeleportEvent(new CanaryPlayer(hook.getPlayer()), new CanaryLocation(hook.getPlayer()
                        .getLocation(), new CanaryWorld(hook.getDestination().getWorld())), new CanaryLocation(hook
                        .getDestination(), new CanaryWorld(hook.getDestination().getWorld())), BukkitUtils
                        .getTeleportCause(hook.getTeleportReason())) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }

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
                });
    }
}
