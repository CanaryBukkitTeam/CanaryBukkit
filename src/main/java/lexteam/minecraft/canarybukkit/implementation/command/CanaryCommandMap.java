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
package lexteam.minecraft.canarybukkit.implementation.command;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.PluginsCommand;
import org.bukkit.command.defaults.VersionCommand;

public class CanaryCommandMap implements CommandMap
{
    public CanaryCommandMap() {
        setDefaultCommands();
    }

    public void clearCommands()
    {
        throw new NotImplementedException();
    }

    public boolean dispatch(CommandSender sender, String cmdLine) throws CommandException
    {
        throw new NotImplementedException();
    }

    public Command getCommand(String name)
    {
        throw new NotImplementedException();
    }

    public boolean register(String fallbackPrefix, Command command)
    {
        throw new NotImplementedException();
    }

    public boolean register(String label, String fallbackPrefix, Command command)
    {
        throw new NotImplementedException();
    }

    public void registerAll(String fallbackPrefix, List<Command> commands)
    {
        throw new NotImplementedException();
    }

    private void setDefaultCommands()
    {
        register("bukkit", new VersionCommand("bversion"));
        register("bukkit", new PluginsCommand("bplugins"));
    }

    public List<String> tabComplete(CommandSender sender, String cmdLine) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }
}
