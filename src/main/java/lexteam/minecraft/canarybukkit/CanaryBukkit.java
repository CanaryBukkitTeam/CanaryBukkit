package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.implementation.CanaryServer;
import lexteam.minecraft.canarybukkit.implementation.plugin.CanaryPluginLoader;
import lexteam.minecraft.canarybukkit.testplugin.TestPlugin;

import org.bukkit.Bukkit;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class CanaryBukkit extends Plugin {

	@Override
	public boolean enable() {
		Bukkit.setServer(new CanaryServer(Canary.getServer(), getLogman()));
		CanaryPluginLoader pluginLoader = new CanaryPluginLoader();
		try {
			pluginLoader.enablePlugin(new TestPlugin());
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void disable() { }

}
