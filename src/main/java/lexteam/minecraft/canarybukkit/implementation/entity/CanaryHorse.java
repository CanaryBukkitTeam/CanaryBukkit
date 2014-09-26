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
package lexteam.minecraft.canarybukkit.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Horse;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.HorseInventory;

public class CanaryHorse extends CanaryAnimals implements Horse {
	private net.canarymod.api.entity.living.animal.Horse horse;

	public CanaryHorse(net.canarymod.api.entity.living.animal.Horse entity) {
		super(entity);
		this.horse = entity;
	}

	public boolean isTamed() {
		return horse.isTamed();
	}

	public void setTamed(boolean tame) {
		horse.setTamed(tame);
	}

	public AnimalTamer getOwner() {
		throw new NotImplementedException();
	}

	public void setOwner(AnimalTamer tamer) {
		throw new NotImplementedException();
	}

	public Variant getVariant() {
		throw new NotImplementedException();
	}

	public void setVariant(Variant variant) {
		throw new NotImplementedException();
	}

	public Color getColor() {
		throw new NotImplementedException();
	}

	public void setColor(Color color) {
		throw new NotImplementedException();
	}

	public Style getStyle() {
		throw new NotImplementedException();
	}

	public void setStyle(Style style) {
		throw new NotImplementedException();
	}

	public boolean isCarryingChest() {
		return horse.isChested();
	}

	public void setCarryingChest(boolean chest) {
		throw new NotImplementedException();
	}

	public int getDomestication() {
		return 0;
	}

	public void setDomestication(int level) {
		throw new NotImplementedException();
	}

	public int getMaxDomestication() {
		return 0;
	}

	public void setMaxDomestication(int level) {
		throw new NotImplementedException();
	}

	public double getJumpStrength() {
		return 0;
	}

	public void setJumpStrength(double strength) {
		throw new NotImplementedException();
	}

	public HorseInventory getInventory() {
		throw new NotImplementedException();
	}
	
	public EntityType getType() {
		return EntityType.COW;
	}
}