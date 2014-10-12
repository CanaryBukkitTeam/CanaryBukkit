/**
 * This file is part of CanaryBukkit, a CanaryMod plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit.implementation.command;

import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class CanaryCommandSender implements CommandSender {
    private MessageReceiver caller;

    public CanaryCommandSender(MessageReceiver caller) {
        this.caller = caller;
    }

    public boolean isPermissionSet(String name) {
        return true;
    }

    public boolean isPermissionSet(Permission perm) {
        return true;
    }

    public boolean hasPermission(String name) {
        return true;
    }

    public boolean hasPermission(Permission perm) {
        return true;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return null;
    }

    public void removeAttachment(PermissionAttachment attachment) {

    }

    public void recalculatePermissions() {

    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    public boolean isPlayer() {
        return caller.getReceiverType() == ReceiverType.PLAYER;
    }

    public boolean isOp() {
        return Canary.ops().isOpped(caller.getName());
    }

    public void setOp(boolean value) {
        Canary.ops().addPlayer(caller.getName());
    }

    public String getName() {
        return caller.getName();
    }

    public void sendMessage(String message) {
        caller.message(message);
    }

    public void sendMessage(String[] messages) {
        for (String msg : messages) {
            caller.message(msg);
        }
    }

    public Server getServer() {
        return Bukkit.getServer();
    }
}