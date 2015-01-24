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
package io.github.lexware.canarybukkit.event;

import io.github.lexware.canarybukkit.impl.entity.CanaryPlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import io.github.lexware.canarybukkit.BukkitUtils;
import io.github.lexware.canarybukkit.impl.CanaryServer;
import io.github.lexware.canarybukkit.impl.block.CanaryBlock;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.hook.world.BlockGrowHook;
import net.canarymod.hook.world.IgnitionHook;
import net.canarymod.hook.world.IgnitionHook.IgnitionCause;
import net.canarymod.hook.world.LeafDecayHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;

public class CanaryBlockListener implements PluginListener {
    private CanaryServer server;

    public CanaryBlockListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onBlockDestroy(final BlockDestroyHook hook) {
        server.getPluginManager().callEvent(
                new BlockBreakEvent(new CanaryBlock(hook.getBlock()), new CanaryPlayer(hook.getPlayer())) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }
                });
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onBlockPlace(final BlockPlaceHook hook) {
        server.getPluginManager().callEvent(
                new BlockPlaceEvent(new CanaryBlock(hook.getBlockPlaced()), null, new CanaryBlock(hook
                        .getBlockClicked()), null, new CanaryPlayer(hook.getPlayer()), true) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        if (cancelled) {
                            hook.setCanceled();
                        }
                    }

                    @Override
                    public void setBuild(boolean canBuild) {
                        super.setBuild(canBuild);
                        // How can you do this in Canary?
                    }
                });
        // TODO: Fill in and check some of the arguments.
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onBlockGrowth(final BlockGrowHook hook) {
        server.getPluginManager().callEvent(new BlockGrowEvent(new CanaryBlock(hook.getOriginal()), null) {
            @Override
            public void setCancelled(boolean cancelled) {
                super.setCancelled(cancelled);
                if (cancelled) {
                    hook.setCanceled();
                }
            }
        });
        // TODO: Fill in second argument
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onIgnition(final IgnitionHook hook) {
        if (hook.getCause() == IgnitionCause.BURNT) {
            server.getPluginManager().callEvent(new BlockBurnEvent(new CanaryBlock(hook.getBlock())) {
                @Override
                public void setCancelled(boolean cancelled) {
                    super.setCancelled(cancelled);
                    if (cancelled) {
                        hook.setCanceled();
                    }
                }
            });
        } else {
            Entity ignitingEntity = null;
            Block ignitingBlock = null;
            if (hook.getPlayer() != null) {
                ignitingEntity = BukkitUtils.getEntity(hook.getPlayer());
            }
            if (hook.getClickedBlock() != null) {
                ignitingBlock = new CanaryBlock(hook.getClickedBlock());
            }
            server.getPluginManager().callEvent(
                    new BlockIgniteEvent(new CanaryBlock(hook.getBlock()), BukkitUtils.getIgniteCause(hook.getCause()),
                            ignitingEntity, ignitingBlock) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            if (cancelled) {
                                hook.setCanceled();
                            }
                        }
                    });
        }
    }

    @HookHandler(priority = Priority.CRITICAL)
    public void onLeafDecay(final LeafDecayHook hook) {
        server.getPluginManager().callEvent(new LeavesDecayEvent(new CanaryBlock(hook.getBlock())) {
            @Override
            public void setCancelled(boolean cancelled) {
                super.setCancelled(cancelled);
                if (cancelled) {
                    hook.setCanceled();
                }
            }
        });
    }
}
