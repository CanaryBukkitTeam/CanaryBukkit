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
package uk.jamierocks.canarybukkit.impl.help;

import io.github.lexware.unolib.Wrapper;
import net.canarymod.help.HelpManager;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

import java.util.Collection;
import java.util.List;

public class CanaryHelpMap extends Wrapper<HelpManager> implements HelpMap {

    public CanaryHelpMap(HelpManager helpManager) {
        super(helpManager);
    }

    @Override
    public HelpTopic getHelpTopic(String topicName) {
        throw new NotImplementedException("getHelpTopic(String)");
    }

    @Override
    public Collection<HelpTopic> getHelpTopics() {
        throw new NotImplementedException("getHelpTopics()");
    }

    @Override
    public void addTopic(HelpTopic topic) {
        throw new NotImplementedException("addTopic(HelpTopic)");
    }

    @Override
    public void clear() {
        throw new NotImplementedException("clear()");
    }

    @Override
    public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<?> factory) {
        throw new NotImplementedException("registerHelpTopicFactory(Class<?>, HelpTopicFactory<?>");
    }

    @Override
    public List<String> getIgnoredPlugins() {
        throw new NotImplementedException("getIgnoredPlugins()");
    }
}
