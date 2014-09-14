package lexteam.minecraft.canarybukkit.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
	
	@Override
    public void onDisable() {
        getLogger().info("Test Plugin loaded!");
    }

}
