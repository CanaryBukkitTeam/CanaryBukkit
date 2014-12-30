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
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class CanaryTask implements BukkitTask {

    private final Plugin plugin;
    private final Runnable task;
    private final int id;
    private final long delay;
    private final long period;
    private final boolean isAsync;
    private final boolean repeat;
    private final ServerTask serverTask;
    private boolean running = false;

    public CanaryTask(final Plugin plugin, final Runnable task, final int id, final long delay,
            final long period, final boolean isAsync, final boolean repeat) {
        this.plugin = plugin;
        this.task = task;
        this.id = id;
        this.delay = delay;
        this.period = period;
        this.isAsync = isAsync;
        this.repeat = repeat;
        this.serverTask = new BukkitServerTask(this);
    }

    public void run() {
        running = true;
        try {
            task.run();
        }
        finally {
            running = false;
        }
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
        // Truly all task are ran in the main thread by the Canary task system
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

    public boolean isRunning() {
        return running;
    }

}
