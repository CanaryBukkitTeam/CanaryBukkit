/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014 Lexteam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lexteam.minecraft.canarybukkit.implementation.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import net.canarymod.api.entity.living.LivingBase;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public abstract class CanaryLivingEntity extends CanaryEntity implements LivingEntity {
    private LivingBase entity;

    public CanaryLivingEntity(net.canarymod.api.entity.living.LivingBase entity) {
        super(entity);
        this.entity = entity;
    }

    public void _INVALID_damage(int amount) {
        throw new NotImplementedException();
    }

    public void _INVALID_damage(int amount, Entity source) {
        throw new NotImplementedException();
    }

    public int _INVALID_getHealth() {
        return Float.floatToIntBits(entity.getHealth());
    }

    public int _INVALID_getLastDamage() {
        return 0;
    }

    public int _INVALID_getMaxHealth() {
        return (int) Math.round(entity.getMaxHealth());
    }

    public void _INVALID_setHealth(int health) {
        throw new NotImplementedException();
    }

    public void _INVALID_setLastDamage(int damage) {
        throw new NotImplementedException();
    }

    public void _INVALID_setMaxHealth(int health) {
        entity.setMaxHealth(health);
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

    public void damage(double amount) {
        throw new NotImplementedException();
    }

    public void damage(double amount, Entity source) {
        throw new NotImplementedException();
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        throw new NotImplementedException();
    }

    public boolean getCanPickupItems() {
        return false;
    }

    public String getCustomName() {
        throw new NotImplementedException();
    }

    public EntityEquipment getEquipment() {
        throw new NotImplementedException();
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

    public double getHealth() {
        return entity.getHealth();
    }

    public Player getKiller() {
        throw new NotImplementedException();
    }

    public double getLastDamage() {
        return 0;
    }

    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    public Entity getLeashHolder() throws IllegalStateException {
        throw new NotImplementedException();
    }

    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    public double getMaxHealth() {
        return entity.getMaxHealth();
    }

    public int getMaximumAir() {
        return 0;
    }

    public int getMaximumNoDamageTicks() {
        return 0;
    }

    public int getNoDamageTicks() {
        return 0;
    }

    public int getRemainingAir() {
        return 0;
    }

    public boolean getRemoveWhenFarAway() {
        return false;
    }

    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    public boolean hasLineOfSight(Entity other) {
        return false;
    }

    public boolean hasPotionEffect(PotionEffectType type) {
        return false;
    }

    public boolean isCustomNameVisible() {
        return false;
    }

    public boolean isLeashed() {
        return false;
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        throw new NotImplementedException();
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        throw new NotImplementedException();
    }

    public void removePotionEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    public void resetMaxHealth() {
        throw new NotImplementedException();
    }

    public void setCanPickupItems(boolean pickup) {
        throw new NotImplementedException();
    }

    public void setCustomName(String name) {
        throw new NotImplementedException();
    }

    public void setCustomNameVisible(boolean flag) {
        throw new NotImplementedException();
    }

    public void setHealth(double health) {
        throw new NotImplementedException();
    }

    public void setLastDamage(double damage) {
        throw new NotImplementedException();
    }

    public boolean setLeashHolder(Entity holder) {
        return false;
    }

    public void setMaxHealth(double health) {
        entity.setMaxHealth(health);
    }

    public void setMaximumAir(int ticks) {
        throw new NotImplementedException();
    }

    public void setMaximumNoDamageTicks(int ticks) {
        throw new NotImplementedException();
    }

    public void setNoDamageTicks(int ticks) {
        throw new NotImplementedException();
    }

    public void setRemainingAir(int ticks) {
        throw new NotImplementedException();
    }

    public void setRemoveWhenFarAway(boolean remove) {
        throw new NotImplementedException();
    }

    public Arrow shootArrow() {
        throw new NotImplementedException();
    }

    public Egg throwEgg() {
        throw new NotImplementedException();
    }

    public Snowball throwSnowball() {
        throw new NotImplementedException();
    }
}