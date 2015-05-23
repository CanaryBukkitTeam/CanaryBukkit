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
package uk.jamierocks.canarybukkit.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.canarymod.api.entity.hanging.Painting;
import org.bukkit.Art;

public class ArtConverter {
    private static BiMap<Art, Painting.ArtType> map =
            ImmutableBiMap.<Art, Painting.ArtType>builder()
                    .put(Art.KEBAB, Painting.ArtType.Kebab)
                    .put(Art.ALBAN, Painting.ArtType.Alban)
                    .put(Art.AZTEC, Painting.ArtType.Aztec)
                    .put(Art.AZTEC2, Painting.ArtType.Aztec2)
                    .put(Art.BOMB, Painting.ArtType.Bomb)
                    .put(Art.PLANT, Painting.ArtType.Plant)
                    .put(Art.WASTELAND, Painting.ArtType.Wasteland)
                    .put(Art.POOL, Painting.ArtType.Pool)
                    .put(Art.COURBET, Painting.ArtType.Courbet)
                    .put(Art.SEA, Painting.ArtType.Sea)
                    .put(Art.SUNSET, Painting.ArtType.Sunset)
                    .put(Art.CREEBET, Painting.ArtType.Creebet)
                    .put(Art.WANDERER, Painting.ArtType.Wanderer)
                    .put(Art.GRAHAM, Painting.ArtType.Graham)
                    .put(Art.MATCH, Painting.ArtType.Match)
                    .put(Art.BUST, Painting.ArtType.Bust)
                    .put(Art.STAGE, Painting.ArtType.Stage)
                    .put(Art.VOID, Painting.ArtType.Void)
                    .put(Art.SKULL_AND_ROSES, Painting.ArtType.SkullAndRoses)
                    .put(Art.WITHER, Painting.ArtType.Wither)
                    .put(Art.FIGHTERS, Painting.ArtType.Fighters)
                    .put(Art.POINTER, Painting.ArtType.Pointer)
                    .put(Art.PIGSCENE, Painting.ArtType.Pigscene)
                    .put(Art.BURNINGSKULL, Painting.ArtType.BurningSkull)
                    .put(Art.SKELETON, Painting.ArtType.Skeleton)
                    .put(Art.DONKEYKONG, Painting.ArtType.DonkeyKong)
                    .build();

    public static Painting.ArtType of(Art artType) {
        return map.get(artType);
    }

    public static Art of(Painting.ArtType art) {
        return map.inverse().get(art);
    }
}
