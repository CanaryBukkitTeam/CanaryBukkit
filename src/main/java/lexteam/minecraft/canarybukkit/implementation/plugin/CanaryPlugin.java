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
package lexteam.minecraft.canarybukkit.implementation.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;

public class CanaryPlugin extends PluginBase {
	private Plugin plugin;

	public CanaryPlugin(Plugin p) {
		this.plugin = p;
	}
	
	public File getDataFolder() {
		return plugin.getDataFolder();
	}

	public PluginDescriptionFile getDescription() {
		return plugin.getDescription();
	}

	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}

	public InputStream getResource(String filename) {
		return plugin.getResource(filename);
	}

	public void saveConfig() {
		plugin.saveConfig();
	}

	public void saveDefaultConfig() {
		plugin.saveDefaultConfig();
	}

	public void saveResource(String resourcePath, boolean replace) {
		plugin.saveResource(resourcePath, replace);
	}

	public void reloadConfig() {
		plugin.reloadConfig();
	}

	public PluginLoader getPluginLoader() {
		return plugin.getPluginLoader();
	}

	public Server getServer() {
		return plugin.getServer();
	}

	public boolean isEnabled() {
		return plugin.isEnabled();
	}

	public void onDisable() {
		plugin.onDisable();
	}

	public void onLoad() {
		plugin.onLoad();
	}

	public void onEnable() {
		plugin.onEnable();
	}

	public boolean isNaggable() {
		return plugin.isNaggable();
	}

	public void setNaggable(boolean canNag) {
		plugin.setNaggable(canNag);
	}

	public EbeanServer getDatabase() {
		return plugin.getDatabase();
	}

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return plugin.getDefaultWorldGenerator(worldName, id);
	}

	public Logger getLogger() {
		return plugin.getServer().getLogger();
	}

	public List<String> onTabComplete(CommandSender sender, Command command,
			String alias, String[] args) {
		return plugin.onTabComplete(sender, command, alias, args);
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return plugin.onCommand(sender, command, label, args);
	}
}
