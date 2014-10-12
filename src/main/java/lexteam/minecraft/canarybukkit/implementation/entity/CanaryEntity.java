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
package lexteam.minecraft.canarybukkit.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.implementation.CanaryLocation;
import lexteam.minecraft.canarybukkit.implementation.CanaryWorld;

public class CanaryEntity implements Entity {
    private net.canarymod.api.entity.Entity entity;

    public CanaryEntity(net.canarymod.api.entity.Entity entity) {
        this.entity = entity;
    }

    public Location getLocation() {
        Location loc = new Location(new CanaryWorld(entity.getWorld()), entity.getX(), entity.getY(),
                entity.getZ());
        loc.setPitch(entity.getPitch());
        return loc;
    }

    public Location getLocation(Location loc) {
        if (loc != null) {
            loc = new CanaryLocation(entity.getLocation(), new CanaryWorld(entity.getWorld()));
        }
        return loc;
    }

    public void setVelocity(Vector velocity) {
        entity.setMotionX(velocity.getX());
        entity.setMotionY(velocity.getY());
        entity.setMotionZ(velocity.getZ());
    }

    public Vector getVelocity() {
        return new Vector(entity.getMotionX(), entity.getMotionY(), entity.getMotionZ());
    }

    public boolean isOnGround() {
        return entity.isOnGround();
    }

    public World getWorld() {
        return new CanaryWorld(entity.getWorld());
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

    public boolean teleport(Entity destination) {
        return teleport(destination.getLocation());
    }

    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        // TODO: Investigate TeleportCause
        return teleport(destination.getLocation());
    }

    public List<Entity> getNearbyEntities(double x, double y, double z) {
        throw new NotImplementedException();
    }

    public int getEntityId() {
        return entity.getID();
    }

    public int getFireTicks() {
        return entity.getFireTicks();
    }

    public int getMaxFireTicks() {
        return 0;
    }

    public void setFireTicks(int ticks) {
        entity.setFireTicks(ticks);
    }

    public void remove() {
        entity.destroy();
    }

    public boolean isDead() {
        return entity.isDead();
    }

    public boolean isValid() {
        return !entity.isDead();
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public Entity getPassenger() {
        return new CanaryEntity(entity.getRider());
    }

    public boolean setPassenger(Entity passenger) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean eject() {
        return false;
    }

    public float getFallDistance() {
        return 0;
    }

    public void setFallDistance(float distance) {
        throw new NotImplementedException();
    }

    public void setLastDamageCause(EntityDamageEvent event) {
        throw new NotImplementedException();
    }

    public EntityDamageEvent getLastDamageCause() {
        throw new NotImplementedException();
    }

    public UUID getUniqueId() {
        return entity.getUUID();
    }

    public int getTicksLived() {
        return 0;
    }

    public void setTicksLived(int value) {
        throw new NotImplementedException();
    }

    public void playEffect(EntityEffect type) {
        throw new NotImplementedException();
    }

    public EntityType getType() {
        throw new NotImplementedException();
    }

    public boolean isInsideVehicle() {
        return entity.isRiding();
    }

    public boolean leaveVehicle() {
        return false;
    }

    public Entity getVehicle() {
        return new CanaryEntity(entity.getRiding());
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException();
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    public boolean hasMetadata(String metadataKey) {
        return false;
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException();
    }
}