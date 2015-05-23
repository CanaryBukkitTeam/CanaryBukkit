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
package uk.jamierocks.canarybukkit.impl.scoreboard;

import java.util.Set;

import io.github.lexware.unolib.Wrapper;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CanaryTeam extends Wrapper<net.canarymod.api.scoreboard.Team> implements Team {
    private CanaryScoreboard scoreboard;

    public CanaryTeam(net.canarymod.api.scoreboard.Team team) {
        super(team);
        this.scoreboard = new CanaryScoreboard(team.getScoreboard());
    }

    public String getName() throws IllegalStateException {
        return getHandle().getProtocolName();
    }

    public String getDisplayName() throws IllegalStateException {
        return getHandle().getDisplayName();
    }

    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        getHandle().setDisplayName(displayName);
    }

    public String getPrefix() throws IllegalStateException {
        return getHandle().getPrefix();
    }

    public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
        getHandle().setPrefix(prefix);
    }

    public String getSuffix() throws IllegalStateException {
        return getHandle().getSuffix();
    }

    public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
        getHandle().setSuffix(suffix);
    }

    public boolean allowFriendlyFire() throws IllegalStateException {
        return getHandle().getAllowFriendlyFire();
    }

    public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
        getHandle().setAllowFriendlyFire(enabled);
    }

    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        return getHandle().getSeeFriendlyInvisibles();
    }

    public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
        getHandle().setSeeFriendlyInvisibles(enabled);
    }

    public NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
        throw new NotImplementedException("getNameTagVisibility()");
    }

    public void setNameTagVisibility(NameTagVisibility nameTagVisibility) throws IllegalArgumentException {
        throw new NotImplementedException("setNameTagVisibility(NameTagVisibility)");
    }

    public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        throw new NotImplementedException("getPlayers()");
    }

    public int getSize() throws IllegalStateException {
        return getHandle().getPlayers().size();
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException("addPlayer(OfflinePlayer)");
    }

    public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException("removePlayer(OfflinePlayer)");
    }

    public void unregister() throws IllegalStateException {
        throw new NotImplementedException("unregister()");
    }

    public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("hasPlayer(OfflinePlayer)");
    }
}
