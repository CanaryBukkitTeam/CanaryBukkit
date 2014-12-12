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

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import lexteam.minecraft.canarybukkit.impl.CanaryServer;
import lexteam.minecraft.canarybukkit.impl.block.CanaryBlock;
import lexteam.minecraft.canarybukkit.impl.entity.CanaryPlayer;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.hook.world.BlockGrowHook;
import net.canarymod.hook.world.LeafDecayHook;
import net.canarymod.plugin.PluginListener;

public class CanaryBlockListener implements PluginListener {
    private CanaryServer server;

    public CanaryBlockListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
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

    @HookHandler
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

    @HookHandler
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

    @HookHandler
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
