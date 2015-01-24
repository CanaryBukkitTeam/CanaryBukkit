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
package io.github.lexware.canarybukkit.impl.scoreboard;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class CanaryScoreboardManager implements ScoreboardManager {
    private net.canarymod.api.scoreboard.ScoreboardManager scoreboardManager;

    public CanaryScoreboardManager(net.canarymod.api.scoreboard.ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;
    }

    public Scoreboard getMainScoreboard() {
        return new CanaryScoreboard(scoreboardManager.getScoreboard());
    }

    public Scoreboard getNewScoreboard() {
        throw new NotImplementedException("getNewScoreboard()");
    }
}
