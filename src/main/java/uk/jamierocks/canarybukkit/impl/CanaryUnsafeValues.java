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
package uk.jamierocks.canarybukkit.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public class CanaryUnsafeValues implements UnsafeValues {
    public Achievement getAchievementFromInternalName(String name) {
        throw new NotImplementedException("getAchievementFromInternalName(String)");
    }

    public Material getMaterialFromInternalName(String name) {
        throw new NotImplementedException("getMaterialFromInternalName(String)");
    }

    public Statistic getStatisticFromInternalName(String name) {
        throw new NotImplementedException("getStatisticFromInternalName(String)");
    }

    public ItemStack modifyItemStack(ItemStack stack, String arguments) {
        throw new NotImplementedException("modifyItemStack(ItemStack, String)");
    }

    public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
        throw new NotImplementedException("tabCompleteInternalMaterialName(String, List<String>)");
    }

    public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
        throw new NotImplementedException("tabCompleteInternalStatisticOrAchievementName(String, List<String>)");
    }
}
