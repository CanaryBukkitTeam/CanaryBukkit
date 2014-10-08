/**
 * This file is part of CanaryBukkit, a CanaryMod plugin, licensed under the MIT License (MIT).
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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;

import java.util.Collection;
import java.util.List;

public class CanaryServicesManager implements ServicesManager {
	public <T> void register(Class<T> service, T provider, Plugin plugin, ServicePriority priority) {
		throw new NotImplementedException();
	}

	public void unregisterAll(Plugin plugin) {
		throw new NotImplementedException();
	}

	public void unregister(Class<?> service, Object provider) {
		throw new NotImplementedException();
	}

	public void unregister(Object provider) {
		throw new NotImplementedException();
	}

	public <T> T load(Class<T> service) {
		throw new NotImplementedException();
	}

	public <T> RegisteredServiceProvider<T> getRegistration(Class<T> service) {
		throw new NotImplementedException();
	}

	public List<RegisteredServiceProvider<?>> getRegistrations(Plugin plugin) {
		throw new NotImplementedException();
	}

	public <T> Collection<RegisteredServiceProvider<T>> getRegistrations(Class<T> service) {
		throw new NotImplementedException();
	}

	public Collection<Class<?>> getKnownServices() {
		throw new NotImplementedException();
	}

	public <T> boolean isProvidedFor(Class<T> service) {
		return false;
	}
}