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
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashSet;
import java.util.Set;

public class CanaryScoreboard extends Wrapper<net.canarymod.api.scoreboard.Scoreboard> implements Scoreboard {

    public CanaryScoreboard(net.canarymod.api.scoreboard.Scoreboard scoreboard) {
        super(scoreboard);
    }

    public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
        throw new NotImplementedException("registerNewObjective(String, String)");
    }

    public Objective getObjective(String name) throws IllegalArgumentException {
        return new CanaryObjective(getHandle().getScoreObjective(name));
    }

    public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
        throw new NotImplementedException("getObjectivesByCriteria(String)");
    }

    public Set<Objective> getObjectives() {
        Set<Objective> objectives = new HashSet<Objective>();
        for (net.canarymod.api.scoreboard.ScoreObjective objective : getHandle().getScoreObjectives()) {
            objectives.add(new CanaryObjective(objective));
        }
        return objectives;
    }

    public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
        throw new NotImplementedException("getObjective(DisplaySlot)");
    }

    public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException("getScores(OfflinePlayer)");
    }

    public Set<Score> getScores(String entry) throws IllegalArgumentException {
        throw new NotImplementedException("getScores(String)");
    }

    public void resetScores(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException("resetScores(OfflinePlayer)");
    }

    public void resetScores(String entry) throws IllegalArgumentException {
        throw new NotImplementedException("resetScores(String)");
    }

    public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException("getPlayerTeam(OfflinePlayer)");
    }

    public Team getTeam(String teamName) throws IllegalArgumentException {
        return new CanaryTeam(getHandle().getTeam(teamName));
    }

    public Set<Team> getTeams() {
        Set<Team> teams = new HashSet<Team>();
        for (net.canarymod.api.scoreboard.Team team : getHandle().getTeams()) {
            teams.add(new CanaryTeam(team));
        }
        return teams;
    }

    public Team registerNewTeam(String name) throws IllegalArgumentException {
        return new CanaryTeam(getHandle().addTeam(name));
    }

    public Set<OfflinePlayer> getPlayers() {
        throw new NotImplementedException("getPlayers()");
    }

    public Set<String> getEntries() {
        throw new NotImplementedException("getEntries()");
    }

    public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
        throw new NotImplementedException("clearSlot(DisplaySlot)");
    }
}
