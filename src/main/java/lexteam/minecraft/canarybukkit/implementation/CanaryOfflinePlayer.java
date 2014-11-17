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
