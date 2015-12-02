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
package uk.jamierocks.canarybukkit.impl.scoreboard;

import io.github.lexware.unolib.Wrapper;
import net.canarymod.api.scoreboard.ScoreObjective;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryObjective extends Wrapper<ScoreObjective> implements Objective {

    public CanaryObjective(net.canarymod.api.scoreboard.ScoreObjective objective) {
        super(objective);
    }

    @Override
    public String getName() throws IllegalStateException {
        return this.getHandle().getProtocolName();
    }

    @Override
    public String getDisplayName() throws IllegalStateException {
        return this.getHandle().getDisplayName();
    }

    @Override
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        this.getHandle().setDisplayName(displayName);
    }

    @Override
    public String getCriteria() throws IllegalStateException {
        return this.getHandle().getScoreObjectiveCriteria().getProtocolName();
    }

    @Override
    public boolean isModifiable() throws IllegalStateException {
        throw new NotImplementedException("isModifiable()");
    }

    @Override
    public Scoreboard getScoreboard() {
        return new CanaryScoreboard(this.getHandle().getScoreboard());
    }

    @Override
    public void unregister() throws IllegalStateException {
        throw new NotImplementedException("unregister()");
    }

    @Override
    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        throw new NotImplementedException("getDisplaySlot()");
    }

    @Override
    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
        throw new NotImplementedException("setDisplaySlot(DisplaySlot)");
    }

    @Override
    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("getScore(OfflinePlayer)");
    }

    @Override
    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("getScore(String)");
    }
}
