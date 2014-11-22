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

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import net.canarymod.tasks.ServerTaskManager;
import net.canarymod.tasks.TaskOwner;

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
        return 0;
    }

    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return 0;
    }

    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return 0;
    }

    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return 0;
    }

    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return 0;
    }

    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return 0;
    }

    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return 0;
    }

    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        return null;
    }

    public void cancelTask(int taskId) {
        ServerTaskManager.removeTask(tasks.get(taskId).getServerTask());
        tasks.remove(taskId);
    }

    public void cancelTasks(Plugin plugin) {
        ServerTaskManager.removeTasks((TaskOwner) plugin);
    }

    public void cancelAllTasks() {
        
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

    public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period)
            throws IllegalArgumentException {
        return null;
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period)
            throws IllegalArgumentException {
        return null;
    }
    
    private int nextId() {
        return ids.incrementAndGet();
    }
}
