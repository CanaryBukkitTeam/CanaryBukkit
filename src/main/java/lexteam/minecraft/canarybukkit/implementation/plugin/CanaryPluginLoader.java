package lexteam.minecraft.canarybukkit.implementation.plugin;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.*;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CanaryPluginLoader implements PluginLoader {

	public Plugin loadPlugin(File file) throws InvalidPluginException, UnknownDependencyException {
		throw new NotImplementedException();
	}

	public PluginDescriptionFile getPluginDescription(File file) throws InvalidDescriptionException {
		throw new NotImplementedException();
	}

	public Pattern[] getPluginFileFilters() {
		throw new NotImplementedException();
	}

	public Map<Class<? extends Event>, Set<RegisteredListener>> createRegisteredListeners(Listener listener, Plugin plugin) {
		throw new NotImplementedException();
	}

	public void enablePlugin(Plugin plugin) {
		plugin.onEnable();
		throw new NotImplementedException();
	}

	public void disablePlugin(Plugin plugin) {
		plugin.onDisable();
		throw new NotImplementedException();
	}

}