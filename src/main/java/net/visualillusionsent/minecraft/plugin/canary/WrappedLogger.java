/*
 * This file is part of VIMCPlugin.
 *
 * Copyright � 2013-2014 Visual Illusions Entertainment
 *
 * VIMCPlugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * VIMCPlugin is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with VIMCPlugin.
 * If not, see http://www.gnu.org/licenses/lgpl.html.
 */
package net.visualillusionsent.minecraft.plugin.canary;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.canarymod.logger.Logman;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Cause Logman is a Log4J2 Logger....
 *
 * @author Jason (darkdiplomat)
 */
public class WrappedLogger extends Logger {
    private final Logman logman;

    public WrappedLogger(Logman logman) {
        super(null, null);
        this.logman = logman;
    }

    private org.apache.logging.log4j.Level convertLevel(Level level) {
        if (level == Level.INFO) {
            return org.apache.logging.log4j.Level.INFO;
        }
        if (level == Level.SEVERE) {
            return org.apache.logging.log4j.Level.ERROR;
        }
        if (level == Level.WARNING) {
            return org.apache.logging.log4j.Level.WARN;
        }
        if (level == Level.FINE || level == Level.FINER || level == Level.FINEST) {
            return org.apache.logging.log4j.Level.TRACE;
        }
        return null;
    }

    @Override
    public final void log(Level level, String msg) {
        org.apache.logging.log4j.Level conv = convertLevel(level);
        if (conv == null) {
            conv = org.apache.logging.log4j.Level.INFO;
            Marker mark = MarkerManager.getMarker(level.getName());
            logman.log(org.apache.logging.log4j.Level.INFO, mark, msg);
        } else {
            logman.log(conv, msg);
        }
    }

}