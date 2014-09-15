package lexteam.minecraft.canarybukkit;

import java.io.File;

import lexteam.minecraft.canarybukkit.implementation.CanaryServer;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginLoader;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class CanaryBukkit extends Plugin {
	
	private Server server;
	private PluginLoader loader;

	@Override
	public boolean enable() {
		server = new CanaryServer(Canary.getServer(), getLogman());
		Bukkit.setServer(server);
		
		File bukkitDir = new File(".", "bukkit" + File.separator + "plugins");
		if(!bukkitDir.exists()) {
			bukkitDir.mkdirs();
		}
		
		server.getPluginManager().loadPlugins(bukkitDir);
		for(org.bukkit.plugin.Plugin p : server.getPluginManager().getPlugins()) {
			loader.enablePlugin(p);
			getLogman().info("[" + p.getName() + "] has been loaded.");
		}
		return true;
	}

	@Override
	public void disable() {
		for(org.bukkit.plugin.Plugin p : server.getPluginManager().getPlugins()) {
			loader.disablePlugin(p);
		}
	}

}
