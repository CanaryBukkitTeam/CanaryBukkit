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

import net.canarymod.tasks.ServerTaskManager;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CanaryScheduler implements BukkitScheduler {
    private final AtomicInteger ids = new AtomicInteger(1);
    private final ConcurrentHashMap<Integer, CanaryTask> tasks = new ConcurrentHashMap<Integer, CanaryTask>();

    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return runTaskLater(plugin, task, delay).getTaskId();
    }

    @Deprecated
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task, delay);
    }

    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return runTask(plugin, task).getTaskId();
    }

    @Deprecated
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task);
    }

    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimer(plugin, task, delay, period).getTaskId();
    }

    @Deprecated
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return scheduleSyncRepeatingTask(plugin, (Runnable) task, delay, period);
    }

    @Deprecated
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return runTaskAsynchronously(plugin, task).getTaskId();
    }

    @Deprecated
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return runTaskLaterAsynchronously(plugin, task, 0).getTaskId();
    }

    @Deprecated
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimerAsynchronously(plugin, task, delay, period).getTaskId();
    }

    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        // TODO wat does this do?
        return null;
    }

    public void cancelTask(int taskId) {
        ServerTaskManager.removeTask(tasks.get(taskId).getServerTask());
        tasks.remove(taskId);
    }

    public void cancelTasks(Plugin plugin) {
        ServerTaskManager.removeTasks(new BukkitTaskOwner(plugin));
        for (Map.Entry<Integer, CanaryTask> integerCanaryTaskEntry : tasks.entrySet()) {
            if (integerCanaryTaskEntry.getValue().getOwner().equals(plugin)) {
                tasks.remove(integerCanaryTaskEntry.getKey());
            }
        }
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
        CanaryTask task = tasks.get(taskId);
        return task != null && task.isRunning();
    }

    public boolean isQueued(int taskId) {
        CanaryTask task = tasks.get(taskId);
        return task != null && ServerTaskManager.isQueued(task.getServerTask());
    }

    public List<BukkitWorker> getActiveWorkers() {
        // TODO talk to dark about maybe adding Async task handling to ServerTaskManager
        return null;
    }

    public List<BukkitTask> getPendingTasks() {
        // This should be safe
        List<BukkitTask> ret = new ArrayList<BukkitTask>();
        for (CanaryTask canaryTask : tasks.values()) {
            ret.add(canaryTask);
        }
        return ret;
    }

    public BukkitTask runTask(Plugin plugin, Runnable task) {
        return makeTask(plugin, task, 0, 0, false, false);
    }

    @Deprecated
    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) {
        return runTask(plugin, (Runnable) task);
    }

    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) {
        // TODO Canary's Task handler only does main thread tasks
        return makeTask(plugin, task, 0, 0, true, false);
    }

    @Deprecated
    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) {
        // TODO Canary's Task handler only does main thread tasks
        return runTaskAsynchronously(plugin, (Runnable) task);
    }

    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) {
        return makeTask(plugin, task, delay, 0, false, false);
    }

    @Deprecated
    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) {
        return runTaskLater(plugin, (Runnable) task, delay);
    }

    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) {
        // TODO Canary's Task handler only does main thread tasks
        return makeTask(plugin, task, delay, 0, true, false);
    }

    @Deprecated
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) {
        // TODO Canary's Task handler only does main thread tasks
        return runTaskLaterAsynchronously(plugin, (Runnable) task, delay);
    }

    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) {
        return makeTask(plugin, task, delay, period, false, true);
    }

    @Deprecated
    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return runTaskTimer(plugin, (Runnable) task, delay, period);
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) {
        // TODO Canary's Task handler only does main thread tasks
        return makeTask(plugin, task, delay, period, true, true);
    }

    @Deprecated
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) {
        // TODO Canary's Task handler only does main thread tasks
        return runTaskTimerAsynchronously(plugin, (Runnable) task, delay, period);
    }

    public BukkitTask makeTask(Plugin plugin, Runnable task, long delay, long period, boolean isAsync, boolean repeat) {
        if (delay < 0l) {
            delay = 0;
        }
        if (period == 0l) {
            period = 1l;
        } else if (period < -1l) {
            period = -1l;
        }
        // TODO Need to handle Asynchronous task maybe?
        CanaryTask btask = new CanaryTask(plugin, task, nextId(), delay, period, isAsync, repeat);
        tasks.put(btask.getTaskId(), btask);
        ServerTaskManager.addTask(btask.getServerTask());
        return btask;
    }

    private int nextId() {
        return ids.incrementAndGet();
    }
}
