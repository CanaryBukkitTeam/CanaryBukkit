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

import net.canarymod.api.entity.living.LivingBase;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CanaryLivingEntity extends CanaryEntity implements LivingEntity {

	private LivingBase entity;

	public CanaryLivingEntity(net.canarymod.api.entity.living.LivingBase entity) {
		super(entity);
		this.entity = entity;
	}

	public double getEyeHeight() {
		return entity.getEyeHeight();
	}

	public double getEyeHeight(boolean ignoreSneaking) {
		return 0;
	}

	public Location getEyeLocation() {
		throw new NotImplementedException();
	}

	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	public Egg throwEgg() {
		throw new NotImplementedException();
	}

	public Snowball throwSnowball() {
		throw new NotImplementedException();
	}

	public Arrow shootArrow() {
		throw new NotImplementedException();
	}

	public int getRemainingAir() {
		return 0;
	}

	public void setRemainingAir(int ticks) {
		throw new NotImplementedException();
	}

	public int getMaximumAir() {
		return 0;
	}

	public void setMaximumAir(int ticks) {
		throw new NotImplementedException();
	}

	public int getMaximumNoDamageTicks() {
		return 0;
	}

	public void setMaximumNoDamageTicks(int ticks) {
		throw new NotImplementedException();
	}

	public double getLastDamage() {
		return 0;
	}

	public int _INVALID_getLastDamage() {
		return 0;
	}

	public void setLastDamage(double damage) {
		throw new NotImplementedException();
	}

	public void _INVALID_setLastDamage(int damage) {
		throw new NotImplementedException();
	}

	public int getNoDamageTicks() {
		return 0;
	}

	public void setNoDamageTicks(int ticks) {
		throw new NotImplementedException();
	}

	public Player getKiller() {
		throw new NotImplementedException();
	}

	public boolean addPotionEffect(PotionEffect effect) {
		return false;
	}

	public boolean addPotionEffect(PotionEffect effect, boolean force) {
		return false;
	}

	public boolean addPotionEffects(Collection<PotionEffect> effects) {
		return false;
	}

	public boolean hasPotionEffect(PotionEffectType type) {
		return false;
	}

	public void removePotionEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	public Collection<PotionEffect> getActivePotionEffects() {
		throw new NotImplementedException();
	}

	public boolean hasLineOfSight(Entity other) {
		return false;
	}

	public boolean getRemoveWhenFarAway() {
		return false;
	}

	public void setRemoveWhenFarAway(boolean remove) {
		throw new NotImplementedException();
	}

	public EntityEquipment getEquipment() {
		throw new NotImplementedException();
	}

	public void setCanPickupItems(boolean pickup) {
		throw new NotImplementedException();
	}

	public boolean getCanPickupItems() {
		return false;
	}

	public void setCustomName(String name) {
		throw new NotImplementedException();
	}

	public String getCustomName() {
		throw new NotImplementedException();
	}

	public void setCustomNameVisible(boolean flag) {
		throw new NotImplementedException();
	}

	public boolean isCustomNameVisible() {
		return false;
	}

	public boolean isLeashed() {
		return false;
	}

	public Entity getLeashHolder() throws IllegalStateException {
		throw new NotImplementedException();
	}

	public boolean setLeashHolder(Entity holder) {
		return false;
	}

	public void damage(double amount) {
		throw new NotImplementedException();
	}

	public void _INVALID_damage(int amount) {
		throw new NotImplementedException();
	}

	public void damage(double amount, Entity source) {
		throw new NotImplementedException();
	}

	public void _INVALID_damage(int amount, Entity source) {
		throw new NotImplementedException();
	}

	public double getHealth() {
		return entity.getHealth();
	}

	public int _INVALID_getHealth() {
		return Float.floatToIntBits(entity.getHealth());
	}

	public void setHealth(double health) {
		throw new NotImplementedException();
	}

	public void _INVALID_setHealth(int health) {
		throw new NotImplementedException();
	}

	public double getMaxHealth() {
		return entity.getMaxHealth();
	}

	public int _INVALID_getMaxHealth() {
		return (int)Math.round(entity.getMaxHealth());
	}

	public void setMaxHealth(double health) {
		entity.setMaxHealth(health);
	}

	public void _INVALID_setMaxHealth(int health) {
		entity.setMaxHealth(health);
	}

	public void resetMaxHealth() {
		throw new NotImplementedException();
	}

	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		throw new NotImplementedException();
	}

	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		throw new NotImplementedException();
	}
}