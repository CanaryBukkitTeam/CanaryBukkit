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
package io.github.lexware.canarybukkit.impl;

import net.canarymod.api.world.World;

import org.bukkit.Location;

public class CanaryLocation extends Location {
    public CanaryLocation(net.canarymod.api.world.position.Location loc, CanaryWorld world) {
        super(world, loc.getX(), loc.getY(), loc.getZ());
        setPitch(loc.getPitch());
    }

    public CanaryLocation(net.canarymod.api.world.position.Location loc, World world) {
        super(new CanaryWorld(world), loc.getX(), loc.getY(), loc.getZ());
        setPitch(loc.getPitch());
    }

    public CanaryLocation(net.canarymod.api.world.position.Position position, CanaryWorld world) {
        super(world, position.getX(), position.getY(), position.getZ());
    }

    public CanaryLocation(net.canarymod.api.world.position.Position position, World world) {
        super(new CanaryWorld(world), position.getX(), position.getY(), position.getZ());
    }
}
