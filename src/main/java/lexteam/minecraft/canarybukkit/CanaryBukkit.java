package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.implementation.CanaryServer;

import org.bukkit.Bukkit;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class CanaryBukkit extends Plugin {

	@Override
	public boolean enable() {
		Bukkit.setServer(new CanaryServer(Canary.getServer(), getLogman()));
		return true;
	}

	@Override
	public void disable() { }

}
