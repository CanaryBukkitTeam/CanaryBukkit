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
package lexteam.minecraft.canarybukkit.implementation.command;

import java.util.Set;

import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class CanaryCommandSender implements CommandSender {
    private MessageReceiver caller;

    public CanaryCommandSender(MessageReceiver caller) {
        this.caller = caller;
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return null;
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    public String getName() {
        return caller.getName();
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public boolean hasPermission(Permission perm) {
        return caller.hasPermission(perm.getName());
    }

    public boolean hasPermission(String name) {
        return caller.hasPermission(name);
    }

    public boolean isOp() {
        return Canary.ops().isOpped(caller.getName());
    }

    public boolean isPermissionSet(Permission perm) {
        return true;
    }

    public boolean isPermissionSet(String name) {
        return caller.hasPermission(name);
    }

    public boolean isPlayer() {
        return caller.getReceiverType() == ReceiverType.PLAYER;
    }

    public void recalculatePermissions() {

    }

    public void removeAttachment(PermissionAttachment attachment) {

    }

    public void sendMessage(String message) {
        caller.message(message);
    }

    public void sendMessage(String[] messages) {
        for (String msg : messages) {
            caller.message(msg);
        }
    }

    public void setOp(boolean value) {
        Canary.ops().addPlayer(caller.getName());
    }
}