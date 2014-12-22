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

import org.bukkit.BanEntry;

public class CanaryBanEntry implements BanEntry {
    private Ban ban;
    private String target, source, reason;
    private Date created, expires;

    public CanaryBanEntry(Ban ban) {
        this.ban = ban;
        this.target = ban.getSubject();
        this.created = new Date(ban.getIssuedDate());
        this.source = ban.getBanningPlayer();
        this.expires = new Date(ban.getExpiration());
        this.reason = ban.getReason();
    }

    public String getTarget() {
        return target;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getExpiration() {
        return expires;
    }

    public void setExpiration(Date expiration) {
        this.expires = expiration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = ban.getReason();
    }

    public void save() {
        ban.setIssuedDate(created.getTime());
        ban.setBanningPlayer(source);
        ban.setExpiration(expires.getTime());
        ban.setReason(reason);
    }
}
