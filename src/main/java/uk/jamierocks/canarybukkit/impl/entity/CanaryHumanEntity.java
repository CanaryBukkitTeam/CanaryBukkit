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
package uk.jamierocks.canarybukkit.impl.entity;

import java.util.Set;

import uk.jamierocks.canarybukkit.impl.inventory.CanaryPlayerInventory;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public abstract class CanaryHumanEntity extends CanaryLivingEntity implements HumanEntity {
    public CanaryHumanEntity(net.canarymod.api.entity.living.humanoid.Human entity) {
        super(entity);
    }

    public PlayerInventory getInventory() {
        return new CanaryPlayerInventory(getHandle().getInventory(), this);
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException("addAttachment(Plugin)");
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException("addAttachment(Plugin, int)");
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException("addAttachment(Plugin, String, boolean)");
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException("addAttachment(Plugin, String, boolean, int)");
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException("getEffectivePermissions()");
    }

    public int getExpToLevel() {
        throw new NotImplementedException("getExpToLevel()");
    }

    public String getName() {
        return getHandle().getName();
    }

    public int getSleepTicks() {
        throw new NotImplementedException("getSleepTicks()");
    }

    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException("hasPermission(Permission)");
    }

    public boolean hasPermission(String name) {
        throw new NotImplementedException("hasPermission(String)");
    }

    public boolean isBlocking() {
        return getHandle().isBlocking();
    }

    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException("isPermissionSet(Permission)");
    }

    public boolean isPermissionSet(String name) {
        throw new NotImplementedException("isPermissionSet(String)");
    }

    public void recalculatePermissions() {
        throw new NotImplementedException("recalculatePermissions()");
    }

    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException("removeAttachment(PermissionAttachment)");
    }

    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        throw new NotImplementedException("setWindowProperty(InventoryView.Property, int)");
    }

    @Override
    protected net.canarymod.api.entity.living.humanoid.Human getHandle() {
        return (net.canarymod.api.entity.living.humanoid.Human) super.getHandle();
    }
}