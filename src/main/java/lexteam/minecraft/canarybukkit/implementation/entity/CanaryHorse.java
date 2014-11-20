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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class CanaryHorse extends CanaryAnimals implements Horse {

    public CanaryHorse(net.canarymod.api.entity.living.animal.Horse entity) {
        super(entity);
    }

    public Color getColor() {
        throw new NotImplementedException("getColor()");
    }

    public int getDomestication() {
        return getEntity().getTemper(); // I think that is right
    }

    public HorseInventory getInventory() {
        throw new NotImplementedException("getInventory()");
    }

    public double getJumpStrength() {
        throw new NotImplementedException("getJumpStrength()");
    }

    public int getMaxDomestication() {
        throw new NotImplementedException("getMaxDomestication()");
    }

    public AnimalTamer getOwner() {
        throw new NotImplementedException("getOwner()");
    }

    public Style getStyle() {
        throw new NotImplementedException("getStyle()");
    }

    public EntityType getType() {
        return EntityType.HORSE;
    }

    public Variant getVariant() {
        throw new NotImplementedException("getVariant()");
    }

    public boolean isCarryingChest() {
        return getEntity().isChested();
    }

    public boolean isTamed() {
        return getEntity().isTamed();
    }

    public void setCarryingChest(boolean chest) {
        throw new NotImplementedException("setCarryingChest(boolean)");
    }

    public void setColor(Color color) {
        throw new NotImplementedException("setColor(Color)");
    }

    public void setDomestication(int level) {
        getEntity().setTemper(level);
    }

    public void setJumpStrength(double strength) {
        throw new NotImplementedException("setJumpStrength(double)");
    }

    public void setMaxDomestication(int level) {
        throw new NotImplementedException("setMaxDomestication(int)");
    }

    public void setOwner(AnimalTamer tamer) {
        throw new NotImplementedException("setOwner(AnimalTamer)");
    }

    public void setStyle(Style style) {
        throw new NotImplementedException("setStyle(Style)");
    }

    public void setTamed(boolean tame) {
        getEntity().setTamed(tame);
    }

    public void setVariant(Variant variant) {
        throw new NotImplementedException("setVariant(Variant)");
    }

    protected net.canarymod.api.entity.living.animal.Horse getEntity() {
        return (net.canarymod.api.entity.living.animal.Horse) super.getEntity();
    }

}