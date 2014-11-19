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

import java.util.List;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.implementation.CanaryLocation;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;

import org.apache.commons.lang.NotImplementedException;
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
        return false;
    }

    public int getEntityId() {
        return entity.getID();
    }

    public float getFallDistance() {
        return 0;
    }

    public int getFireTicks() {
        return entity.getFireTicks();
    }

    public EntityDamageEvent getLastDamageCause() {
        throw new NotImplementedException();
    }

    public Location getLocation() {
        return new CanaryLocation(entity.getLocation(), entity.getWorld());
    }

    public Location getLocation(Location loc) {
        if (loc != null) {
            loc = new CanaryLocation(entity.getLocation(), entity.getWorld());
        }
        return loc;
    }

    public int getMaxFireTicks() {
        return 0;
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public List<Entity> getNearbyEntities(double x, double y, double z) {
        throw new NotImplementedException();
    }

    public Entity getPassenger() {
        return BukkitUtils.getEntity(entity.getRider());
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public int getTicksLived() {
        return 0;
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
        return false;
    }

    public void playEffect(EntityEffect type) {
        throw new NotImplementedException();
    }

    public void remove() {
        entity.destroy();
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException();
    }

    public void setFallDistance(float distance) {
        throw new NotImplementedException();
    }

    public void setFireTicks(int ticks) {
        entity.setFireTicks(ticks);
    }

    public void setLastDamageCause(EntityDamageEvent event) {
        throw new NotImplementedException();
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException();
    }

    public boolean setPassenger(Entity passenger) {
        return false;
    }

    public void setTicksLived(int value) {
        throw new NotImplementedException();
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
        entity.teleportTo(location.getX(), location.getY(), location.getZ());
        if (entity.getX() == location.getX() && entity.getY() == location.getY()
                && entity.getZ() == location.getZ()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        // TODO: Investigate TeleportCause
        return teleport(location);
    }

    public net.canarymod.api.entity.Entity getCanaryEntity() {
        return entity;
    }
}