/**
 * This file is part of CanaryBukkit, a CanaryMod plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit.implementation;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public class CanaryUnsafeValues implements UnsafeValues {
    public Achievement getAchievementFromInternalName(String name) {
        throw new NotImplementedException();
    }

    public Material getMaterialFromInternalName(String name) {
        throw new NotImplementedException();
    }

    public Statistic getStatisticFromInternalName(String name) {
        throw new NotImplementedException();
    }

    public ItemStack modifyItemStack(ItemStack stack, String arguments) {
        throw new NotImplementedException();
    }

    public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
        throw new NotImplementedException();
    }

    public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
        throw new NotImplementedException();
    }
}