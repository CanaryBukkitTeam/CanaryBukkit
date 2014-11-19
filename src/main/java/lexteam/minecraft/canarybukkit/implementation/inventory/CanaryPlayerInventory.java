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
package lexteam.minecraft.canarybukkit.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CanaryPlayerInventory extends CanaryInventory implements PlayerInventory {
    private net.canarymod.api.inventory.PlayerInventory inv;
    private Player owner;

    public CanaryPlayerInventory(net.canarymod.api.inventory.PlayerInventory inv, Player owner) {
        super(inv);
        this.inv = inv;
        this.owner = owner;
    }

    public int clear(int id, int data) {
        throw new NotImplementedException();
    }

    public ItemStack[] getArmorContents() {
        throw new NotImplementedException();
    }

    public ItemStack getBoots() {
        throw new NotImplementedException();
    }

    public ItemStack getChestplate() {
        throw new NotImplementedException();
    }

    public int getHeldItemSlot() {
        return inv.getSelectedHotbarSlotId();
    }

    public ItemStack getHelmet() {
        throw new NotImplementedException();
    }

    @Override
    public HumanEntity getHolder() {
        return owner;
    }

    public ItemStack getItemInHand() {
        throw new NotImplementedException();
    }

    public ItemStack getLeggings() {
        throw new NotImplementedException();
    }

    public void setArmorContents(ItemStack[] items) {
        throw new NotImplementedException();
    }

    public void setBoots(ItemStack boots) {
        throw new NotImplementedException();
    }

    public void setChestplate(ItemStack chestplate) {
        throw new NotImplementedException();
    }

    public void setHeldItemSlot(int slot) {
        throw new NotImplementedException();
    }

    public void setHelmet(ItemStack helmet) {
        throw new NotImplementedException();
    }

    public void setItemInHand(ItemStack stack) {
        throw new NotImplementedException();
    }

    public void setLeggings(ItemStack leggings) {
        throw new NotImplementedException();
    }
}
