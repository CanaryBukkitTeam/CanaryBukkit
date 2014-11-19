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
package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.data.Constants;
import lexteam.minecraft.canarybukkit.events.CanaryPlayerListener;
import lexteam.minecraft.canarybukkit.events.CanaryServerListener;
import lexteam.minecraft.canarybukkit.events.CanaryWorldListener;
import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

import org.bukkit.Bukkit;

public final class CanaryBukkit extends Plugin {
    private CanaryServer server;

    @Override
    public void disable() {
        server.disablePlugins();
    }

    @Override
    public boolean enable() {
        if (Bukkit.getServer() == null) {
            server = new CanaryServer(Canary.getServer(), getLogman(), getDescriptor().getVersion());
        }
        // Enable Listener
        Canary.hooks().registerListener(new CanaryPlayerListener(server), this);
        Canary.hooks().registerListener(new CanaryWorldListener(server), this);
        Canary.hooks().registerListener(new CanaryServerListener(server), this);

        // Create all the directories.
        Constants.checkFolders();

        // Start server
        server.start();
        return true;
    }
}
