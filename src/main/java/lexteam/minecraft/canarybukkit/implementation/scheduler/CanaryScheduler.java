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

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import net.canarymod.tasks.ServerTask;
import net.canarymod.tasks.ServerTaskManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

public class CanaryScheduler implements BukkitScheduler {
    private final AtomicInteger ids = new AtomicInteger(1);
    private final ConcurrentHashMap<Integer, CanaryTask> tasks = new ConcurrentHashMap<Integer, CanaryTask>();

    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return 0;
    }

    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return 0;
    }

    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return this.scheduleSyncDelayedTask(plugin, task, 0l);
    }

    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return 0;
    }

    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return scheduleTask(plugin, task, delay, period, false);
    }

    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return 0;
    }

    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return this.scheduleAsyncRepeatingTask(plugin, task, delay, -1l);
    }

    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return 0;
    }

    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return scheduleTask(plugin, task, delay, period, true);
    }

    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        return null;
    }

    public void cancelTask(int taskId) {
        ServerTaskManager.removeTask(tasks.get(taskId).getServerTask());
        tasks.remove(taskId);
    }

    public void cancelTasks(Plugin plugin) {
        ServerTaskManager.removeTasks(new BukkitTaskOwner(plugin));
    }

    public void cancelAllTasks() {
        Iterator<CanaryTask> it = tasks.values().iterator();
        while (it.hasNext()) {
            CanaryTask task = it.next();
            task.cancel();
            if (task.isSync()) {
                it.remove();
            }
        }
    }

    public boolean isCurrentlyRunning(int taskId) {
        return false;
    }

    public boolean isQueued(int taskId) {
        return false;
    }

    public List<BukkitWorker> getActiveWorkers() {
        return null;
    }

    public List<BukkitTask> getPendingTasks() {
        return null;
    }

    public BukkitTask runTask(Plugin plugin, Runnable task) {
        return null;
    }

    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) {
        return null;
    }

    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) {
        return null;
    }

    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) {
        return null;
    }

    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) {
        return null;
    }

    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) {
        return null;
    }

    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) {
        return null;
    }

    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) {
        return null;
    }

    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) {
        return makeTask(plugin, task, delay, period, false);
    }

    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return null;
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) {
        return makeTask(plugin, task, delay, period, true);
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return null;
    }

    public int scheduleTask(Plugin plugin, Runnable task, long delay, long period, boolean isAsync) {
        return makeTask(plugin, task, delay, period, isAsync).getTaskId();
    }

    public BukkitTask makeTask(Plugin plugin, Runnable task, long delay, long period, boolean isAsync) {
        if (delay < 0l) {
            delay = 0;
        }
        if (period == 0l) {
            period = 1l;
        } else if (period < -1l) {
            period = -1l;
        }
        CanaryTask btask = new CanaryTask(plugin, task, nextId(), delay, period, isAsync);
        ServerTask ctask = btask.getServerTask();
        tasks.put(btask.getTaskId(), btask);
        ServerTaskManager.addTask(ctask);
        return btask;
    }

    private int nextId() {
        return ids.incrementAndGet();
    }
}
