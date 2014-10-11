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
package lexteam.minecraft.canarybukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;

public class CanaryCommands implements CommandListener {
    @Command(aliases = { "bdisable" },
             description = "disable Bukkit plugin",
             permissions = { "bukkit.disableplugin" },
             toolTip = "/bdisable <plugin>",
             version = 2)
    public void bdisableCommand(MessageReceiver caller, String[] parameters) {
        Bukkit.getServer().getPluginManager()
                .disablePlugin(Bukkit.getServer().getPluginManager().getPlugin(parameters[0]));
        caller.message("Disabled plugin.");
    }

    @Command(aliases = { "benable" },
             description = "enable Bukkit plugin",
             permissions = { "bukkit.enableplugin" },
             toolTip = "/benable <plugin>",
             version = 2)
    public void benableCommand(MessageReceiver caller, String[] parameters) {
        Bukkit.getServer().getPluginManager()
                .enablePlugin(Bukkit.getServer().getPluginManager().getPlugin(parameters[0]));
        // TODO: Check if works
        caller.message("Enabled plugin.");
    }

    @Command(aliases = { "bplugins" },
             description = "list Bukkit plugins",
             permissions = { "bukkit.listplugins" },
             toolTip = "/bplugins",
             version = 2)
    public void bpluginsCommand(MessageReceiver caller, String[] parameters) {
        caller.message("Bukkit plugins:");
        for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
            caller.message(plugin.getName());
        }
    }
}