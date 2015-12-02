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
package uk.jamierocks.canarybukkit.impl;

import com.google.common.collect.Sets;
import net.canarymod.Canary;
import net.canarymod.bansystem.Ban;
import net.canarymod.bansystem.BanManager;
import org.bukkit.BanEntry;
import org.bukkit.BanList;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CanaryBanList implements BanList {

    private BanManager banManager;
    private boolean isIpBan;

    public CanaryBanList(BanManager banManager, Type type) {
        this.banManager = banManager;
        this.isIpBan = type == Type.IP;
    }

    @Override
    public BanEntry getBanEntry(String target) {
        BanEntry entry = null;
        for (Ban ban : this.banManager.getAllBans()) {
            if (ban.getSubject().equalsIgnoreCase(target) && (ban.isIpBan() == isIpBan)) {
                entry = new CanaryBanEntry(ban);
            }
        }
        return entry;
    }

    @Override
    public BanEntry addBan(String target, String reason, Date expires, String source) {
        Ban ban = new Ban(Canary.getServer().getPlayer(target), reason, this.isIpBan);
        ban.setBanningPlayer(source);
        this.banManager.issueBan(ban);
        return this.getBanEntry(target);
    }

    @Override
    public Set<BanEntry> getBanEntries() {
        Set<BanEntry> bans = Sets.newHashSet();
        for (Ban ban : this.banManager.getAllBans()) {
            if (ban.isIpBan() == this.isIpBan) {
                bans.add(new CanaryBanEntry(ban));
            }
        }
        return bans;
    }

    @Override
    public boolean isBanned(String target) {
        return this.banManager.isBanned(target);
    }

    @Override
    public void pardon(String target) {
        this.banManager.unban(target);
    }
}
