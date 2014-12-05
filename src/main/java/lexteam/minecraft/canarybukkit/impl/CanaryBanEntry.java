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

import net.canarymod.bansystem.Ban;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.BanEntry;

public class CanaryBanEntry implements BanEntry {
    private Ban ban;

    public CanaryBanEntry(Ban ban) {
        this.ban = ban;
    }

    public String getTarget() {
        return ban.getSubject();
    }

    public Date getCreated() {
        throw new NotImplementedException("getCreated()");
    }

    public void setCreated(Date created) {
        throw new NotImplementedException("setCreated(Date)");
    }

    public String getSource() {
        return ban.getBanningPlayer();
    }

    public void setSource(String source) {
        ban.setBanningPlayer(source);
    }

    public Date getExpiration() {
        return new Date(ban.getTimestamp());
    }

    public void setExpiration(Date expiration) {
        ban.setTimestamp(expiration.getTime());
    }

    public String getReason() {
        return ban.getReason();
    }

    public void setReason(String reason) {
        ban.setReason(reason);
    }

    public void save() {
        throw new NotImplementedException("save()");
    }
}
