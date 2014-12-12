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
package lexteam.minecraft.canarybukkit.impl.scheduler;

import net.canarymod.tasks.ServerTask;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class CanaryTask implements BukkitTask {
    private Plugin plugin;
    private Runnable task;
    private int id;
    private long delay;
    private long period;
    private boolean isAsync;
    private boolean repeat;
    private ServerTask serverTask;

    public CanaryTask(final Plugin plugin, final Runnable task, final int id, final long delay, final long period,
            final boolean isAsync) {
        this.plugin = plugin;
        this.task = task;
        this.id = id;
        this.delay = delay;
        this.period = period;
        this.isAsync = isAsync;
        this.repeat = false;
        this.serverTask = new BukkitServerTask(this);
    }

    public void run() {
        task.run();
    }

    long getPeriod() {
        return period;
    }

    long getDelay() {
        return delay;
    }

    public int getTaskId() {
        return id;
    }

    public Plugin getOwner() {
        return plugin;
    }

    public boolean isSync() {
        return !isAsync;
    }

    public boolean getRepeat() {
        return repeat;
    }

    public void cancel() {
        Bukkit.getScheduler().cancelTask(id);
    }

    public ServerTask getServerTask() {
        return serverTask;
    }
}
