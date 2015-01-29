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
package io.github.lexware.canarybukkit;

import java.io.IOException;

import io.github.lexware.canarybukkit.data.Constants;
import io.github.lexware.canarybukkit.event.CanaryBlockListener;
import io.github.lexware.canarybukkit.event.CanaryPlayerListener;
import io.github.lexware.canarybukkit.event.CanaryServerListener;
import io.github.lexware.canarybukkit.impl.CanaryServer;
import io.github.lexware.canarybukkit.event.CanaryWorldListener;
import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

import org.bukkit.Bukkit;
import org.mcstats.Metrics;
import org.mcstats.Metrics.Graph;

public final class CanaryBukkit extends Plugin {
    private CanaryServer server;

    @Override
    public void disable() {
        server.disablePlugins();
    }

    @Override
    public boolean enable() {
        if (Bukkit.getServer() == null) {
            server = new CanaryServer(Canary.getServer(), getLogman(), getVersion());
        }
        // Enable Listener
        Canary.hooks().registerListener(new CanaryPlayerListener(server), this);
        Canary.hooks().registerListener(new CanaryBlockListener(server), this);
        Canary.hooks().registerListener(new CanaryWorldListener(server), this);
        Canary.hooks().registerListener(new CanaryServerListener(server), this);

        // Create all the directories.
        Constants.createDirectories();

        // Start server
        server.start();

        // Metrics (statistics)
        try {
            Metrics metrics = new Metrics(this);

            Graph plugins = metrics.createGraph("Plugins");
            for (org.bukkit.plugin.Plugin plugin : server.getPluginManager().getPlugins()) {
                plugins.addPlotter(new Metrics.Plotter(plugin.getName()) {
                    @Override
                    public int getValue() {
                        return 1;
                    }
                });
            }

            metrics.start();
        } catch (IOException e) {
            getLogman().warn("Failed to send statistics to Metrics", e);
        }

        return true;
    }
}
