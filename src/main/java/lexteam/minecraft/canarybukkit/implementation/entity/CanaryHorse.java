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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class CanaryHorse extends CanaryAnimals implements Horse {
    private net.canarymod.api.entity.living.animal.Horse horse;

    public CanaryHorse(net.canarymod.api.entity.living.animal.Horse entity) {
        super(entity);
        this.horse = entity;
    }

    public Color getColor() {
        throw new NotImplementedException();
    }

    public int getDomestication() {
        return 0;
    }

    public HorseInventory getInventory() {
        throw new NotImplementedException();
    }

    public double getJumpStrength() {
        return 0;
    }

    public int getMaxDomestication() {
        return 0;
    }

    public AnimalTamer getOwner() {
        throw new NotImplementedException();
    }

    public Style getStyle() {
        throw new NotImplementedException();
    }

    public EntityType getType() {
        return EntityType.HORSE;
    }

    public Variant getVariant() {
        throw new NotImplementedException();
    }

    public boolean isCarryingChest() {
        return horse.isChested();
    }

    public boolean isTamed() {
        return horse.isTamed();
    }

    public void setCarryingChest(boolean chest) {
        throw new NotImplementedException();
    }

    public void setColor(Color color) {
        throw new NotImplementedException();
    }

    public void setDomestication(int level) {
        throw new NotImplementedException();
    }

    public void setJumpStrength(double strength) {
        throw new NotImplementedException();
    }

    public void setMaxDomestication(int level) {
        throw new NotImplementedException();
    }

    public void setOwner(AnimalTamer tamer) {
        throw new NotImplementedException();
    }

    public void setStyle(Style style) {
        throw new NotImplementedException();
    }

    public void setTamed(boolean tame) {
        horse.setTamed(tame);
    }

    public void setVariant(Variant variant) {
        throw new NotImplementedException();
    }
}