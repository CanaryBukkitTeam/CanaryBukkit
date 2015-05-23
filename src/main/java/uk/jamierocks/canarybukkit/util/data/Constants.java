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
package uk.jamierocks.canarybukkit.util.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.canarymod.Canary;
import net.canarymod.logger.Logman;

public class Constants {
    // Canary
    public static final File canaryDir = Canary.getWorkingDirectory();
    public static final File worldsDir = new File(canaryDir, "worlds");
    // Bukkit
    private static String bukkitVersion = "UNKNOWN";
    // CanaryBukkit
    public static final File bukkitDir = new File(canaryDir, "bukkit");
    public static final File pluginsDir = new File(bukkitDir, "plugins");
    public static final File configDir = new File(bukkitDir, "config");
    public static final File configFile = new File(configDir, "config.yml");
    
    static {
        Properties versionProp = new Properties();
        InputStream versionIn = ClassLoader.getSystemResourceAsStream("version.properties");
        if (versionIn != null) {
            try {
                versionProp.load(versionIn);
                
                bukkitVersion = versionProp.getProperty("bukkitVersion", "UNKNOWN");
                if(bukkitVersion.equalsIgnoreCase("${bukkit.version}")) 
                    bukkitVersion = "UNKNOWN";
            } catch (IOException e) {
                Logman.getLogman("CanaryBukkit").warn("Could not fetch the Bukkit version.", e);
            } finally {
                try {
                    versionIn.close();
                } catch (IOException ignore) {
                }
            }
        }
    }
    
    public static String getBukkitVersion() {
        return bukkitVersion;
    }

    public static void createDirectories() {
        File[] dirs = new File[] { 
                bukkitDir, 
                    pluginsDir, configDir }; // This must be in order
        for (File dir : dirs) {
            if (!dir.isDirectory() && !dir.mkdir()) {
                Logman.getLogman("CanaryBukkit").warn("Could not create directory: " + dir);
            }
        }
    }
}
