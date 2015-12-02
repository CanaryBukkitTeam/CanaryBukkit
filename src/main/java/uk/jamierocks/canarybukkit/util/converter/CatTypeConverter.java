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
package uk.jamierocks.canarybukkit.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Ocelot;

public class CatTypeConverter {

    private static BiMap<Ocelot.Type, net.canarymod.api.entity.living.animal.Ocelot.SkinType> map =
            ImmutableBiMap.<Ocelot.Type, net.canarymod.api.entity.living.animal.Ocelot.SkinType>builder()
                    .put(Ocelot.Type.RED_CAT, net.canarymod.api.entity.living.animal.Ocelot.SkinType.GINGER)
                    .put(Ocelot.Type.SIAMESE_CAT, net.canarymod.api.entity.living.animal.Ocelot.SkinType.SIAMESE)
                    .put(Ocelot.Type.BLACK_CAT, net.canarymod.api.entity.living.animal.Ocelot.SkinType.TUXEDO)
                    .put(Ocelot.Type.WILD_OCELOT, net.canarymod.api.entity.living.animal.Ocelot.SkinType.UNTAME)
                    .build();

    public static net.canarymod.api.entity.living.animal.Ocelot.SkinType of(Ocelot.Type type) {
        return CatTypeConverter.map.get(type);
    }

    public static Ocelot.Type of(net.canarymod.api.entity.living.animal.Ocelot.SkinType skinType) {
        return CatTypeConverter.map.inverse().get(skinType);
    }
}
