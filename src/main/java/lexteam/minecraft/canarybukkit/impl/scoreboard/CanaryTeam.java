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
package lexteam.minecraft.canarybukkit.impl.scoreboard;

import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CanaryTeam implements Team {
    private net.canarymod.api.scoreboard.Team team;
    private CanaryScoreboard scoreboard;

    public CanaryTeam(net.canarymod.api.scoreboard.Team team) {
        this.team = team;
        this.scoreboard = new CanaryScoreboard(team.getScoreboard());
    }
    
    public String getName() throws IllegalStateException {
        return team.getProtocolName();
    }

    public String getDisplayName() throws IllegalStateException {
        return team.getDisplayName();
    }

    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        team.setDisplayName(displayName);
    }

    public String getPrefix() throws IllegalStateException {
        return team.getPrefix();
    }

    public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
        team.setPrefix(prefix);
    }

    public String getSuffix() throws IllegalStateException {
        return team.getSuffix();
    }

    public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
        team.setSuffix(suffix);
    }

    public boolean allowFriendlyFire() throws IllegalStateException {
        return team.getAllowFriendlyFire();
    }

    public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
        team.setAllowFriendlyFire(enabled);
    }

    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        return team.getSeeFriendlyInvisibles();
    }

    public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
        team.setSeeFriendlyInvisibles(enabled);
    }

    public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        throw new NotImplementedException("getPlayers()");
    }

    public int getSize() throws IllegalStateException {
        return team.getPlayers().size();
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
