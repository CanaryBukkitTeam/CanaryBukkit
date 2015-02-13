/**
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
package io.github.lexware.canarybukkit.impl;

import java.util.Map;
import java.util.UUID;

import io.github.lexware.canarybukkit.impl.entity.CanaryPlayer;
import io.github.lexware.unolib.Wrapper;
import net.canarymod.Canary;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CanaryOfflinePlayer extends Wrapper<net.canarymod.api.OfflinePlayer> implements OfflinePlayer {
    public CanaryOfflinePlayer(net.canarymod.api.OfflinePlayer offlinePlayer) {
        super(offlinePlayer);
    }

    public Location getBedSpawnLocation() {
        return new CanaryLocation(getHandle().getHome(), getHandle().getWorld());
        // TODO: Is home the same as the bed?
    }

    public long getFirstPlayed() {
        throw new NotImplementedException("getFirstPlayed()");
    }

    public long getLastPlayed() {
        throw new NotImplementedException("getLastPlayed()");
    }

    public String getName() {
        return getHandle().getName();
    }

    public Player getPlayer() {
        return new CanaryPlayer(Canary.getServer().getPlayer(getHandle().getName()));
    }

    public UUID getUniqueId() {
        return getHandle().getUUID();
    }

    public boolean hasPlayedBefore() {
        throw new NotImplementedException("hasPlayedBefore()");
    }

    public boolean isBanned() {
        return Canary.bans().isBanned(getName());
    }

    public boolean isOnline() {
        return getHandle().isOnline();
    }

    public boolean isOp() {
        return Canary.ops().isOpped(getHandle().getName());
    }

    public boolean isWhitelisted() {
        return Canary.whitelist().isWhitelisted(getHandle().getName());
    }

    public Map<String, Object> serialize() {
        throw new NotImplementedException("serialize()");
    }

    public void setBanned(boolean banned) {
        throw new NotImplementedException("setBanned(boolean)");
    }

    public void setOp(boolean op) {
        Canary.ops().addPlayer(getHandle().getName());
    }

    public void setWhitelisted(boolean whitelisted) {
        if (whitelisted)
            Canary.whitelist().addPlayer(getName());
        else
            Canary.whitelist().removePlayer(getName());
    }
}
