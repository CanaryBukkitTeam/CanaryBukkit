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

import uk.jamierocks.canarybukkit.impl.entity.CanaryPlayer;
import uk.jamierocks.canarybukkit.util.converter.IgniteCauseConverter;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import uk.jamierocks.canarybukkit.BukkitUtils;
import uk.jamierocks.canarybukkit.impl.CanaryServer;
import uk.jamierocks.canarybukkit.impl.block.CanaryBlock;
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

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onBlockDestroy(final BlockDestroyHook hook) {
        BlockBreakEvent event = new BlockBreakEvent(new CanaryBlock(hook.getBlock()), new CanaryPlayer(hook.getPlayer()));
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onBlockPlace(final BlockPlaceHook hook) {
        BlockPlaceEvent event = new BlockPlaceEvent(new CanaryBlock(hook.getBlockPlaced()), null, new CanaryBlock(hook
                .getBlockClicked()), null, new CanaryPlayer(hook.getPlayer()), true) {
            @Override
            public void setBuild(boolean canBuild) {
                super.setBuild(canBuild);
                // How can you do this in Canary?
            }
        };
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
        // TODO: Fill in and check some of the arguments.
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onBlockGrowth(final BlockGrowHook hook) {
        BlockGrowEvent event = new BlockGrowEvent(new CanaryBlock(hook.getOriginal()), null);
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
        // TODO: Fill in second argument
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onIgnition(final IgnitionHook hook) {
        if (hook.getCause() == IgnitionCause.BURNT) {
            BlockBurnEvent event = new BlockBurnEvent(new CanaryBlock(hook.getBlock()));
            event.setCancelled(hook.isCanceled());
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                hook.setCanceled();
            }
        } else {
            Entity ignitingEntity = null;
            Block ignitingBlock = null;
            if (hook.getPlayer() != null) {
                ignitingEntity = BukkitUtils.getEntity(hook.getPlayer());
            }
            if (hook.getClickedBlock() != null) {
                ignitingBlock = new CanaryBlock(hook.getClickedBlock());
            }
            BlockIgniteEvent event = new BlockIgniteEvent(new CanaryBlock(hook.getBlock()), IgniteCauseConverter
                    .of(hook.getCause()),
                    ignitingEntity, ignitingBlock);
            event.setCancelled(hook.isCanceled());
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                hook.setCanceled();
            }
        }
    }

    @HookHandler(priority = Priority.CRITICAL, ignoreCanceled = true)
    public void onLeafDecay(final LeafDecayHook hook) {
        LeavesDecayEvent event = new LeavesDecayEvent(new CanaryBlock(hook.getBlock()));
        event.setCancelled(hook.isCanceled());
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            hook.setCanceled();
        }
    }
}
