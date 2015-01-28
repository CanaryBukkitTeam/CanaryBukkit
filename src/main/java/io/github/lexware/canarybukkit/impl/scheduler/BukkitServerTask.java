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
package io.github.lexware.canarybukkit.impl.scheduler;

import net.canarymod.tasks.ServerTask;

public class BukkitServerTask extends ServerTask {
    private final CanaryTask task;

    public BukkitServerTask(CanaryTask task) {
        super(new BukkitTaskOwner(task.getOwner()), task.getDelay(), task.getPeriod(), task.getRepeat());
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }
}
