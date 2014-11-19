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

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class CanaryInventory implements Inventory {
    private net.canarymod.api.inventory.Inventory inv;

    public CanaryInventory(net.canarymod.api.inventory.Inventory inv) {
        this.inv = inv;
    }

    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void clear() {
        inv.clearInventory();
    }

    public void clear(int index) {
        throw new NotImplementedException();
    }

    public boolean contains(int materialId) {
        return inv.hasItem(materialId);
    }

    public boolean contains(int materialId, int amount) {
        return inv.hasItemStack(materialId, amount);
    }

    public boolean contains(ItemStack item) {
        return inv.hasItem(item.getTypeId());
    }

    public boolean contains(ItemStack item, int amount) {
        return inv.hasItemStack(item.getTypeId(), amount);
    }

    public boolean contains(Material material) throws IllegalArgumentException {
        return inv.hasItem(material.getId());
    }

    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        return inv.hasItemStack(material.getId(), amount);
    }

    public boolean containsAtLeast(ItemStack item, int amount) {
        return false;
    }

    public int first(int materialId) {
        return 0;
    }

    public int first(ItemStack item) {
        return 0;
    }

    public int first(Material material) throws IllegalArgumentException {
        return 0;
    }

    public int firstEmpty() {
        return 0;
    }

    public ItemStack[] getContents() {
        return new ItemStack[0];
    }

    public InventoryHolder getHolder() {
        throw new NotImplementedException();
    }

    public ItemStack getItem(int index) {
        throw new NotImplementedException();
    }

    public int getMaxStackSize() {
        return inv.getInventoryStackLimit();
    }

    public String getName() {
        return inv.getInventoryName();
    }

    public int getSize() {
        return inv.getSize();
    }

    public String getTitle() {
        return inv.getInventoryName();
    }

    public InventoryType getType() {
        return InventoryType.valueOf(inv.getInventoryType().name());
    }

    public List<HumanEntity> getViewers() {
        throw new NotImplementedException();
    }

    public ListIterator<ItemStack> iterator() {
        throw new NotImplementedException();
    }

    public ListIterator<ItemStack> iterator(int index) {
        throw new NotImplementedException();
    }

    public void remove(int materialId) {
        inv.removeItem(materialId);
    }

    public void remove(ItemStack item) {
        inv.removeItem(item.getTypeId());
    }

    public void remove(Material material) throws IllegalArgumentException {
        inv.removeItem(material.getId());
    }

    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void setItem(int index, ItemStack item) {
        throw new NotImplementedException();
    }

    public void setMaxStackSize(int size) {
        throw new NotImplementedException();
    }
}