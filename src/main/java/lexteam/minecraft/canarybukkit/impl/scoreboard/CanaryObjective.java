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

import net.canarymod.api.scoreboard.ScoreObjective;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryObjective implements Objective {
    private ScoreObjective objective;

    public CanaryObjective(net.canarymod.api.scoreboard.ScoreObjective objective) {
        this.objective = objective;
    }
    
    public String getName() throws IllegalStateException {
        return objective.getProtocolName();
    }

    public String getDisplayName() throws IllegalStateException {
        return objective.getDisplayName();
    }

    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        objective.setDisplayName(displayName);
    }

    public String getCriteria() throws IllegalStateException {
        return objective.getScoreObjectiveCriteria().getProtocolName();
    }

    public boolean isModifiable() throws IllegalStateException {
        throw new NotImplementedException("isModifiable()");
    }

    public Scoreboard getScoreboard() {
        return new CanaryScoreboard(objective.getScoreboard());
    }

    public void unregister() throws IllegalStateException {
        throw new NotImplementedException("unregister()");
    }

    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        throw new NotImplementedException("getDisplaySlot()");
    }

    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
        throw new NotImplementedException("setDisplaySlot(DisplaySlot)");
    }

    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("getScore(OfflinePlayer)");
    }

    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("getScore(String)");
    }
}
