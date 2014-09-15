package lexteam.minecraft.canarybukkit;

import org.bukkit.Bukkit;

import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.plugin.PluginListener;

public class CanaryListener implements PluginListener {
	
	@HookHandler
    public void blockDestroy(BlockDestroyHook hook) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.block.BlockBreakEvent(null, null)); //TODO: Fill in
	}

}
