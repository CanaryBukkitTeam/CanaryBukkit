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
package lexteam.minecraft.canarybukkit.implementation.entity;

import net.canarymod.api.entity.living.humanoid.Human;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class CanaryHumanEntity extends CanaryLivingEntity implements HumanEntity {
	private Human entity;

	public CanaryHumanEntity(net.canarymod.api.entity.living.humanoid.Human entity) {
		super(entity);
		this.entity = entity;
	}

	public String getName() {
		return entity.getName();
	}

	public PlayerInventory getInventory() {
		throw new NotImplementedException();
	}

	public Inventory getEnderChest() {
		throw new NotImplementedException();
	}

	public boolean setWindowProperty(InventoryView.Property prop, int value) {
		return false;
	}

	public InventoryView getOpenInventory() {
		throw new NotImplementedException();
	}

	public InventoryView openInventory(Inventory inventory) {
		throw new NotImplementedException();
	}

	public InventoryView openWorkbench(Location location, boolean force) {
		throw new NotImplementedException();
	}

	public InventoryView openEnchanting(Location location, boolean force) {
		throw new NotImplementedException();
	}

	public void openInventory(InventoryView inventory) {
		throw new NotImplementedException();
	}

	public void closeInventory() {
		throw new NotImplementedException();
	}

	public ItemStack getItemInHand() {
		throw new NotImplementedException();
	}

	public void setItemInHand(ItemStack item) {
		throw new NotImplementedException();
	}

	public ItemStack getItemOnCursor() {
		throw new NotImplementedException();
	}

	public void setItemOnCursor(ItemStack item) {
		throw new NotImplementedException();
	}

	public boolean isSleeping() {
		return false;
	}

	public int getSleepTicks() {
		return 0;
	}

	public GameMode getGameMode() {
		throw new NotImplementedException();
	}

	public void setGameMode(GameMode mode) {
		throw new NotImplementedException();
	}

	public boolean isBlocking() {
		return false;
	}

	public int getExpToLevel() {
		return 0;
	}

	public boolean isPermissionSet(String name) {
		return false;
	}

	public boolean isPermissionSet(Permission perm) {
		return false;
	}

	public boolean hasPermission(String name) {
		return false;
	}

	public boolean hasPermission(Permission perm) {
		return false;
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		throw new NotImplementedException();
	}

	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new NotImplementedException();
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		throw new NotImplementedException();
	}

	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		throw new NotImplementedException();
	}

	public void removeAttachment(PermissionAttachment attachment) {
		throw new NotImplementedException();
	}

	public void recalculatePermissions() {
		throw new NotImplementedException();
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new NotImplementedException();
	}

	public boolean isOp() {
		return false;
	}

	public void setOp(boolean value) {
		throw new NotImplementedException();
	}
}