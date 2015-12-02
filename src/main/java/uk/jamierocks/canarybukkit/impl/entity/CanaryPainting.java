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
package uk.jamierocks.canarybukkit.impl.entity;

import uk.jamierocks.canarybukkit.util.converter.ArtConverter;
import org.bukkit.Art;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;

public class CanaryPainting extends CanaryHanging implements Painting {
    public CanaryPainting(net.canarymod.api.entity.hanging.Painting entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.PAINTING;
    }

    public Art getArt() {
        return ArtConverter.of(getHandle().getArtType());
    }

    public boolean setArt(Art art) {
        getHandle().setArtType(ArtConverter.of(art));
        return getHandle().getArtType() == ArtConverter.of(art);
    }

    public boolean setArt(Art art, boolean force) {
        return setArt(art);
    }

    @Override
    protected net.canarymod.api.entity.hanging.Painting getHandle() {
        return (net.canarymod.api.entity.hanging.Painting) super.getHandle();
    }
}
