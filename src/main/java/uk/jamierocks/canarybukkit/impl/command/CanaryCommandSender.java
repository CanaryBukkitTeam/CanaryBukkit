/*
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
package uk.jamierocks.canarybukkit.impl.command;

import io.github.lexware.unolib.Wrapper;
import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class CanaryCommandSender extends Wrapper<MessageReceiver> implements CommandSender {

    public CanaryCommandSender(MessageReceiver caller) {
        super(caller);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException("addAttachment(Plugin)");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException("addAttachment(Plugin, int)");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException("addAttachment(Plugin, String, boolean)");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException("addAttachment(Plugin, String, boolean, int)");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException("getEffectivePermissions()");
    }

    @Override
    public String getName() {
        return this.getHandle().getName();
    }

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return this.getHandle().hasPermission(perm.getName());
    }

    @Override
    public boolean hasPermission(String name) {
        return this.getHandle().hasPermission(name);
    }

    @Override
    public boolean isOp() {
        return Canary.ops().isOpped(this.getHandle().getName());
    }

    @Override
    public void setOp(boolean value) {
        Canary.ops().addPlayer(this.getHandle().getName());
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return this.isPermissionSet(perm.getName());
    }

    @Override
    public boolean isPermissionSet(String name) {
        return this.getHandle().hasPermission(name);
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException("recalculatePermissions()");
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException("removeAttachment(PermissionAttachment)");
    }

    @Override
    public void sendMessage(String message) {
        this.getHandle().message(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        for (String msg : messages) {
            this.getHandle().message(msg);
        }
    }
}
