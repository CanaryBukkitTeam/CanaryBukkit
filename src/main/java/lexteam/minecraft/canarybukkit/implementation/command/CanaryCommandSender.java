/**
 * This file is part of CanaryMod-BukkitAPI, a CanaryMod plugin, licensed under the MIT License (MIT).
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

import java.util.Set;

import net.canarymod.chat.MessageReceiver;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class CanaryCommandSender implements CommandSender {
	private Player player;

	public CanaryCommandSender(MessageReceiver player) {
		this.player = Bukkit.getServer().getPlayer(player.getName());
	}
	
	public boolean isPermissionSet(String name) {
		return player.isPermissionSet(name);
	}

	public boolean isPermissionSet(Permission perm) {
		return player.isPermissionSet(perm);
	}

	public boolean hasPermission(String name) {
		return player.hasPermission(name);
	}

	public boolean hasPermission(Permission perm) {
		return player.hasPermission(perm);
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		return player.addAttachment(plugin, name, value);
	}

	public PermissionAttachment addAttachment(Plugin plugin) {
		return player.addAttachment(plugin);
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		return player.addAttachment(plugin, name, value, ticks);
	}

	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return player.addAttachment(plugin, ticks);
	}

	public void removeAttachment(PermissionAttachment attachment) {
		player.removeAttachment(attachment);
	}

	public void recalculatePermissions() {
		player.recalculatePermissions();
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return player.getEffectivePermissions();
	}

	public boolean isOp() {
		return player.isOp();
	}

	public void setOp(boolean value) {
		player.setOp(value);
	}

	public void sendMessage(String message) {
		player.sendMessage(message);
	}

	public void sendMessage(String[] messages) {
		player.sendMessage(messages);
	}

	public Server getServer() {
		return Bukkit.getServer();
	}

	public String getName() {
		return player.getName();
	}
}
