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
package lexteam.minecraft.canarybukkit.implementation.scheduler;

import net.canarymod.tasks.ServerTask;
import net.canarymod.tasks.TaskOwner;

public class BukkitServerTask extends ServerTask {
    private CanaryTask task;

    public BukkitServerTask(CanaryTask task) {
        super((TaskOwner)task.getOwner(), task.getPeriod(), true);
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }
}
