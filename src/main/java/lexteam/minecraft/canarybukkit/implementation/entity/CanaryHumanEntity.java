/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
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

import java.util.Set;

import net.canarymod.api.entity.living.humanoid.Human;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public abstract class CanaryHumanEntity extends CanaryLivingEntity implements HumanEntity
{
    private Human entity;

    public CanaryHumanEntity(net.canarymod.api.entity.living.humanoid.Human entity) {
        super(entity);
        this.entity = entity;
    }

    public PermissionAttachment addAttachment(Plugin plugin)
    {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks)
    {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value)
    {
        throw new NotImplementedException();
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks)
    {
        throw new NotImplementedException();
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions()
    {
        throw new NotImplementedException();
    }

    public int getExpToLevel()
    {
        return 0;
    }

    public String getName()
    {
        return entity.getName();
    }

    public int getSleepTicks()
    {
        return 0;
    }

    public boolean hasPermission(Permission perm)
    {
        return false;
    }

    public boolean hasPermission(String name)
    {
        return false;
    }

    public boolean isBlocking()
    {
        return false;
    }

    public boolean isOp()
    {
        return false;
    }

    public boolean isPermissionSet(Permission perm)
    {
        return false;
    }

    public boolean isPermissionSet(String name)
    {
        return false;
    }

    public boolean isSleeping()
    {
        return false;
    }

    public void recalculatePermissions()
    {
        throw new NotImplementedException();
    }

    public void removeAttachment(PermissionAttachment attachment)
    {
        throw new NotImplementedException();
    }

    public void setOp(boolean value)
    {
        throw new NotImplementedException();
    }

    public boolean setWindowProperty(InventoryView.Property prop, int value)
    {
        return false;
    }
}