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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryScore implements Score {
    private net.canarymod.api.scoreboard.Score score;

    public CanaryScore(net.canarymod.api.scoreboard.Score score) {
        this.score = score;
    }
    
    public OfflinePlayer getPlayer() {
        throw new NotImplementedException("getPlayer()");
    }

    public String getEntry() {
        return score.getName();
    }

    public Objective getObjective() {
        return new CanaryObjective(score.getScoreObjective());
    }

    public int getScore() throws IllegalStateException {
        return score.getScore();
    }

    public void setScore(int score) throws IllegalStateException {
        this.score.setScore(score);
    }

    public Scoreboard getScoreboard() {
        return new CanaryScoreboard(score.getScoreboard());
    }
}
