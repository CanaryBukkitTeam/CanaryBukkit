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
package lexteam.minecraft.canarybukkit.impl.entity;

import java.util.List;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;
import lexteam.minecraft.canarybukkit.impl.CanaryLocation;
import lexteam.minecraft.canarybukkit.impl.CanaryWorld;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public abstract class CanaryEntity implements Entity {
    private net.canarymod.api.entity.Entity entity;

    public CanaryEntity(net.canarymod.api.entity.Entity entity) {
        this.entity = entity;
    }

    public boolean eject() {
        if (getEntity().isRidden()) {
            getEntity().getRider().dismount();
            return true;
        }
        return false;
    }

    public int getEntityId() {
        return entity.getID();
    }

    public float getFallDistance() {
        throw new NotImplementedException("getFallDistance()");
    }

    public int getFireTicks() {
        return entity.getFireTicks();
    }

    public EntityDamageEvent getLastDamageCause() {
        throw new NotImplementedException("getLastDamageCause()");
    }

    public Location getLocation() {
        return new CanaryLocation(entity.getLocation(), entity.getWorld());
    }

    public Location getLocation(Location loc) {
        if (loc != null) {
            loc.setWorld(getWorld());
            loc.setX(getEntity().getX());
            loc.setY(getEntity().getY());
            loc.setZ(getEntity().getZ());
            loc.setPitch(getEntity().getPitch());
            loc.setYaw(getEntity().getRotation());
        }
        return loc;
    }

    public int getMaxFireTicks() {
        throw new NotImplementedException("getMaxFireTicks()");
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException("getMetadata(String)");
    }

    public List<Entity> getNearbyEntities(double x, double y, double z) {
        throw new NotImplementedException("getNearbyEntities(double, double, double)");
    }

    public Entity getPassenger() {
        return BukkitUtils.getEntity(entity.getRider());
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public int getTicksLived() {
        throw new NotImplementedException("getTicksLived()");
    }

    public UUID getUniqueId() {
        return entity.getUUID();
    }

    public Entity getVehicle() {
        return BukkitUtils.getEntity(entity.getRiding());
    }

    public Vector getVelocity() {
        return new Vector(entity.getMotionX(), entity.getMotionY(), entity.getMotionZ());
    }

    public World getWorld() {
        return new CanaryWorld(entity.getWorld());
    }

    public boolean hasMetadata(String metadataKey) {
        return entity.getMetaData().containsKey(metadataKey);
    }

    public boolean isDead() {
        return entity.isDead();
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isInsideVehicle() {
        return entity.isRiding();
    }

    public boolean isOnGround() {
        return entity.isOnGround();
    }

    public boolean isValid() {
        return !entity.isDead();
    }

    public boolean leaveVehicle() {
        if (getEntity().isRiding()) {
            getEntity().dismount();
            return true;
        }
        return false;
    }

    public void playEffect(EntityEffect type) {
        throw new NotImplementedException("playEffect(EntityEffect)");
    }

    public void remove() {
        getEntity().destroy();
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException("removeMetadata(String, Plugin)");
    }

    public void setFallDistance(float distance) {
        throw new NotImplementedException("setFallDistance(float)");
    }

    public void setFireTicks(int ticks) {
        getEntity().setFireTicks(ticks);
    }

    public void setLastDamageCause(EntityDamageEvent event) {
        throw new NotImplementedException("setLastDamageCause(EntityDamageEvent)");
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException("setMetadata(String, MetadataValue)");
    }

    public boolean setPassenger(Entity passenger) {
        return false;
    }

    public void setTicksLived(int value) {
        throw new NotImplementedException("setTicksLived(int)");
    }

    public void setVelocity(Vector velocity) {
        entity.setMotionX(velocity.getX());
        entity.setMotionY(velocity.getY());
        entity.setMotionZ(velocity.getZ());
    }

    public boolean teleport(Entity destination) {
        return teleport(destination.getLocation());
    }

    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        // TODO: Investigate TeleportCause
        return teleport(destination.getLocation());
    }

    public boolean teleport(Location location) {
        getEntity().teleportTo(CanaryUtils.getLocation(location));
        return entity.getX() == location.getX() && entity.getY() == location.getY()
                && entity.getZ() == location.getZ();
    }

    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        getEntity().teleportTo(CanaryUtils.getLocation(location));
        // TODO: Investigate TeleportCause
        // In canary it seems that only Player gets a TeleportCause part
        return teleport(location);
    }

    protected net.canarymod.api.entity.Entity getEntity() {
        return entity;
    }
}
