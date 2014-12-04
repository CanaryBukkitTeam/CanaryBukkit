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
package lexteam.minecraft.canarybukkit.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.canarymod.Canary;
import net.canarymod.bansystem.Ban;
import net.canarymod.bansystem.BanManager;

import org.bukkit.BanEntry;
import org.bukkit.BanList;

public class CanaryBanList implements BanList {
    private BanManager banManager;
    private boolean isIpBan;

    public CanaryBanList(BanManager banManager, Type type) {
        this.banManager = banManager;
        this.isIpBan = type == Type.IP;
    }

    public BanEntry getBanEntry(String target) {
        BanEntry entry = null;
        for (Ban ban : banManager.getAllBans()) {
            if (ban.getSubject().equalsIgnoreCase(target) && (ban.isIpBan() == isIpBan)) {
                entry = new CanaryBanEntry(ban);
            }
        }
        return entry;
    }

    public BanEntry addBan(String target, String reason, Date expires, String source) {
        Ban ban = new Ban(Canary.getServer().getPlayer(target), reason, isIpBan);
        ban.setBanningPlayer(source);
        banManager.issueBan(ban);
        return getBanEntry(target);
    }

    public Set<BanEntry> getBanEntries() {
        Set<BanEntry> bans = new HashSet<BanEntry>();
        for (Ban ban : banManager.getAllBans()) {
            if (ban.isIpBan() == isIpBan) {
                bans.add(new CanaryBanEntry(ban));
            }
        }
        return bans;
    }

    public boolean isBanned(String target) {
        return banManager.isBanned(target);
    }

    public void pardon(String target) {
        banManager.unban(target);
    }
}
