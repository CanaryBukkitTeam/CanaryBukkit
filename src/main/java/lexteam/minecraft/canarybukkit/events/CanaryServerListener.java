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
package lexteam.minecraft.canarybukkit.events;

import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import lexteam.minecraft.canarybukkit.implementation.command.CanaryCommandSender;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.command.ConsoleCommandHook;
import net.canarymod.hook.system.ServerListPingHook;
import net.canarymod.plugin.PluginListener;

import org.bukkit.event.server.ServerListPingEvent;

public class CanaryServerListener implements PluginListener
{
    private CanaryServer server;

    public CanaryServerListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
    public void onCommand(ConsoleCommandHook hook)
    {
        String commandLine = "";
        for (String s : hook.getCommand()) {
            commandLine += s + " ";
        }
        if (server.dispatchCommand(new CanaryCommandSender(hook.getCaller()), commandLine)) {
            hook.setCanceled();
        }
    }

    @HookHandler
    public void onServerListPing(ServerListPingHook hook)
    {
        server.getPluginManager().callEvent(
                new ServerListPingEvent(hook.getRequesterAddress(), hook.getMotd(), hook.getCurrentPlayers(),
                        hook.getMaxPlayers()));
    }
}
