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
package lexteam.minecraft.canarybukkit.data;

import java.io.File;

import net.canarymod.Canary;

public class Constants {
    // Canary
    public static final File canaryDir = Canary.getWorkingDirectory();
    public static final File worldsDir = new File(canaryDir, "worlds");
    // Bukkit
    public static final String bukkitVersion = "1.7.10-C0.1-SNAPSHOT";
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
