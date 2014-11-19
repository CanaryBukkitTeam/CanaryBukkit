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
package lexteam.minecraft.canarybukkit.implementation;

import java.util.Map;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.implementation.entity.CanaryPlayer;
import net.canarymod.Canary;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CanaryOfflinePlayer implements OfflinePlayer {
    private net.canarymod.api.OfflinePlayer offlinePlayer;

    public CanaryOfflinePlayer(net.canarymod.api.OfflinePlayer offlinePlayer) {
        this.offlinePlayer = offlinePlayer;
    }

    public Location getBedSpawnLocation() {
        return new CanaryLocation(offlinePlayer.getHome(), offlinePlayer.getWorld());
        // TODO: Is home the same as the bed?
    }

    public long getFirstPlayed() {
        return 0;
    }

    public long getLastPlayed() {
        return 0;
    }

    public String getName() {
        return offlinePlayer.getName();
    }

    public Player getPlayer() {
        return new CanaryPlayer(Canary.getServer().getPlayer(offlinePlayer.getName()));
    }

    public UUID getUniqueId() {
        return offlinePlayer.getUUID();
    }

    public boolean hasPlayedBefore() {
        return false;
    }

    public boolean isBanned() {
        return Canary.bans().isBanned(getName());
    }

    public boolean isOnline() {
        return offlinePlayer.isOnline();
    }

    public boolean isOp() {
        return Canary.ops().isOpped(offlinePlayer.getName());
    }

    public boolean isWhitelisted() {
        return Canary.whitelist().isWhitelisted(offlinePlayer.getName());
    }

    public Map<String, Object> serialize() {
        throw new NotImplementedException();
    }

    public void setBanned(boolean banned) {

    }

    public void setOp(boolean op) {
        Canary.ops().addPlayer(offlinePlayer.getName());
    }

    public void setWhitelisted(boolean whitelisted) {
        if (whitelisted)
            Canary.whitelist().addPlayer(getName());
        else
            Canary.whitelist().removePlayer(getName());
    }
}
