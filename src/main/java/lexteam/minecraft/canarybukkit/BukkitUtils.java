/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
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
package lexteam.minecraft.canarybukkit;

import org.apache.commons.lang.Validate;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.WorldType;

/**
 * For turning Canary objects into Bukkit objects
 * 
 * @author Jamie
 */
public class BukkitUtils {
    public static GameMode toGameMode(net.canarymod.api.GameMode gm) {
        Validate.notNull(gm);
        switch (gm) {
            case ADVENTURE:
                return GameMode.ADVENTURE;
            case CREATIVE:
                return GameMode.CREATIVE;
            case SURVIVAL:
            default:
                return GameMode.SURVIVAL;
        }
    }

    public static Difficulty toDifficulty(net.canarymod.api.world.World.Difficulty difficulty) {
        Validate.notNull(difficulty);
        switch (difficulty) {
            case EASY:
                return Difficulty.EASY;
            case HARD:
                return Difficulty.HARD;
            case PEACEFUL:
                return Difficulty.PEACEFUL;
            case NORMAL:
            default:
                return Difficulty.NORMAL;
        }
    }

    public static WorldType toWorldType(net.canarymod.api.world.WorldType type) {
        Validate.notNull(type);
        if (type == net.canarymod.api.world.WorldType.AMPLIFIED) {
            return WorldType.AMPLIFIED;
        }
        if (type == net.canarymod.api.world.WorldType.SUPERFLAT) {
            return WorldType.FLAT;
        }
        if (type == net.canarymod.api.world.WorldType.LARGEBIOMES) {
            return WorldType.LARGE_BIOMES;
        }
        if (type == net.canarymod.api.world.WorldType.DEFAULT_1_1) {
            return WorldType.VERSION_1_1;
        }
        return WorldType.NORMAL;
    }
}
