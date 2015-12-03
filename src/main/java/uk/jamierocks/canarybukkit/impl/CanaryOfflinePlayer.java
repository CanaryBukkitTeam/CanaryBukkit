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
package uk.jamierocks.canarybukkit.impl;

import io.github.lexware.unolib.Wrapper;
import net.canarymod.Canary;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import uk.jamierocks.canarybukkit.impl.entity.CanaryPlayer;

import java.util.Map;
import java.util.UUID;

public class CanaryOfflinePlayer extends Wrapper<net.canarymod.api.OfflinePlayer> implements OfflinePlayer {

    public CanaryOfflinePlayer(net.canarymod.api.OfflinePlayer offlinePlayer) {
        super(offlinePlayer);
    }

    @Override
    public Location getBedSpawnLocation() {
        return new CanaryLocation(this.getHandle().getHome(), this.getHandle().getWorld());
        // TODO: Is home the same as the bed?
    }

    @Override
    public long getFirstPlayed() {
        throw new NotImplementedException("getFirstPlayed()");
    }

    @Override
    public long getLastPlayed() {
        throw new NotImplementedException("getLastPlayed()");
    }

    @Override
    public String getName() {
        return this.getHandle().getName();
    }

    @Override
    public Player getPlayer() {
        return new CanaryPlayer(Canary.getServer().getPlayer(this.getHandle().getName()));
    }

    @Override
    public UUID getUniqueId() {
        return this.getHandle().getUUID();
    }

    @Override
    public boolean hasPlayedBefore() {
        throw new NotImplementedException("hasPlayedBefore()");
    }

    @Override
    public boolean isBanned() {
        return Canary.bans().isBanned(this.getName());
    }

    @Override
    public void setBanned(boolean banned) {
        throw new NotImplementedException("setBanned(boolean)");
    }

    @Override
    public boolean isOnline() {
        return this.getHandle().isOnline();
    }

    @Override
    public boolean isOp() {
        return Canary.ops().isOpped(this.getHandle().getName());
    }

    @Override
    public void setOp(boolean op) {
        Canary.ops().addPlayer(this.getHandle().getName());
    }

    @Override
    public boolean isWhitelisted() {
        return Canary.whitelist().isWhitelisted(this.getHandle().getName());
    }

    @Override
    public void setWhitelisted(boolean whitelisted) {
        if (whitelisted) {
            Canary.whitelist().addPlayer(this.getName());
        } else {
            Canary.whitelist().removePlayer(this.getName());
        }
    }

    @Override
    public Map<String, Object> serialize() {
        throw new NotImplementedException("serialize()");
    }
}
