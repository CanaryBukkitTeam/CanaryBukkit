package lexteam.minecraft.canarybukkit;

import org.bukkit.Bukkit;

import net.canarymod.plugin.Plugin;

public class CanaryBukkit extends Plugin {

	@Override
	public boolean enable() {
		getLogman().info("This server is running " + Bukkit.getName() + " version " + Bukkit.getVersion() + " (Implementing API version " + Bukkit.getBukkitVersion() + ")");
		return false;
	}

	@Override
	public void disable() {
		
	}

}
