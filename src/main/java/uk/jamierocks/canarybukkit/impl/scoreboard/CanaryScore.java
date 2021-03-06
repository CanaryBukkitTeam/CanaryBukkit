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
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryScore extends Wrapper<net.canarymod.api.scoreboard.Score> implements Score {

    public CanaryScore(net.canarymod.api.scoreboard.Score score) {
        super(score);
    }

    @Override
    public OfflinePlayer getPlayer() {
        throw new NotImplementedException("getPlayer()");
    }

    @Override
    public String getEntry() {
        return this.getHandle().getName();
    }

    @Override
    public Objective getObjective() {
        return new CanaryObjective(this.getHandle().getScoreObjective());
    }

    @Override
    public int getScore() throws IllegalStateException {
        return this.getHandle().getScore();
    }

    @Override
    public void setScore(int score) throws IllegalStateException {
        this.getHandle().setScore(score);
    }

    @Override
    public Scoreboard getScoreboard() {
        return new CanaryScoreboard(this.getHandle().getScoreboard());
    }
}
