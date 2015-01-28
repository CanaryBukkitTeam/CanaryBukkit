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
package io.github.lexware.canarybukkit.util.converter;

import net.canarymod.api.entity.living.humanoid.Villager;

import org.bukkit.entity.Villager.Profession;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class ProfessionConverter {
    private static BiMap<Profession, Villager.Profession> map =
            ImmutableBiMap.<Profession, Villager.Profession>builder()
                    .put(Profession.BLACKSMITH, Villager.Profession.BLACKSMITH)
                    .put(Profession.BUTCHER, Villager.Profession.BUTCHER)
                    .put(Profession.FARMER, Villager.Profession.FARMER)
                    .put(Profession.LIBRARIAN, Villager.Profession.LIBRARIAN)
                    .build();

    public static Villager.Profession of(Profession profession) {
        return map.get(profession);
    }

    public static Profession of(Villager.Profession profession) {
        return map.inverse().get(profession);
    }
}
