/**
 * This file is part of CanaryMod-BukkitAPI, a CanaryMod plugin, licensed under the MIT License (MIT).
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
package lexteam.minecraft.canarybukkit.api.hooks;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.canarymod.hook.Hook;

public class BukkitPluginEnabledHook extends Hook {
	private Plugin plugin;

	/**
	 * Create a new BukkitPluginEnabledHook
	 * @param plugin the plugin that was enabled
	 */
	public BukkitPluginEnabledHook(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Gets the {@link Plugin} that was enabled
	 * @return plugin
	 */
	public Plugin getPlugin() {
		return plugin;
	}
	
	/**
	 * Gets the {@link Server} that the plugin is running on
	 * @return server
	 */
	public Server getServer() {
		return plugin.getServer();
	}
	
	@Override
	public String toString() {
		return String.format("%s[Plugin=%s]", getHookName(), plugin);
	}
}
