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
package lexteam.minecraft.canarybukkit.data;

import java.io.File;

import net.canarymod.Canary;

public class Constants {
    // Canary
    public static final File canaryDir = Canary.getWorkingDirectory();
    public static final File worldsDir = new File(canaryDir, "worlds");
    // Bukkit
    public static final String bukkitVersion = "1.7.9-R0.2";
    // CanaryBukkit
    public static final File bukkitDir = new File(canaryDir, "bukkit");
    public static final File pluginsDir = new File(bukkitDir, "plugins");
    public static final File configDir = new File(bukkitDir, "config");
    public static final File configFile = new File(configDir, "config.yml");

    public static void checkFolders() {
        File[] folders = new File[] { pluginsDir, configDir };
        for (File f : folders) {
            f.mkdirs();
        }
    }
}
