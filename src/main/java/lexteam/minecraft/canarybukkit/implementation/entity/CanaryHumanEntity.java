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
package lexteam.minecraft.canarybukkit.implementation.entity;

import java.util.Set;

import net.canarymod.api.entity.living.humanoid.Human;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public abstract class CanaryHumanEntity extends CanaryLivingEntity implements HumanEntity {
    private Human entity;

    public CanaryHumanEntity(net.canarymod.api.entity.living.humanoid.Human entity) {
        super(entity);
        this.entity = entity;
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException();
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException();
    }

    public int getExpToLevel() {
        return 0;
    }

    public String getName() {
        return entity.getName();
    }

    public int getSleepTicks() {
        return 0;
    }

    public boolean hasPermission(Permission perm) {
        return false;
    }

    public boolean hasPermission(String name) {
        return false;
    }

    public boolean isBlocking() {
        return false;
    }

    public boolean isPermissionSet(Permission perm) {
        return false;
    }

    public boolean isPermissionSet(String name) {
        return false;
    }

    public void recalculatePermissions() {
        throw new NotImplementedException();
    }

    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException();
    }

    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        return false;
    }
}