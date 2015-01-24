/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014-2015 CanaryBukkitTeam
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
package io.github.lexware.canarybukkit.impl.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.NotImplementedException;
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
        throw new NotImplementedException("addItem(ItemStack...)");
    }

    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new NotImplementedException("all(int)");
    }

    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new NotImplementedException("all(ItemStack)");
    }

    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        throw new NotImplementedException("all(Material)");
    }

    public void clear() {
        getInventory().clearInventory();
    }

    public void clear(int index) {
        throw new NotImplementedException("clear(int)");
    }

    public boolean contains(int materialId) {
        return getInventory().hasItem(materialId);
    }

    public boolean contains(int materialId, int amount) {
        return getInventory().hasItemStack(materialId, amount);
    }

    public boolean contains(ItemStack item) {
        return getInventory().hasItem(item.getTypeId());
    }

    public boolean contains(ItemStack item, int amount) {
        return getInventory().hasItemStack(item.getTypeId(), amount);
    }

    public boolean contains(Material material) throws IllegalArgumentException {
        return getInventory().hasItem(material.getId());
    }

    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        return getInventory().hasItemStack(material.getId(), amount);
    }

    public boolean containsAtLeast(ItemStack item, int amount) {
        throw new NotImplementedException("containsAtLeast(ItemStack, int)");
    }

    public int first(int materialId) {
        throw new NotImplementedException("first(int)");
    }

    public int first(ItemStack item) {
        throw new NotImplementedException("first(ItemStack)");
    }

    public int first(Material material) throws IllegalArgumentException {
        throw new NotImplementedException("first(Material)");
    }

    public int firstEmpty() {
        throw new NotImplementedException("firstEmpty()");
    }

    public ItemStack[] getContents() {
        return new ItemStack[0];
    }

    public InventoryHolder getHolder() {
        throw new NotImplementedException("getHolder()");
    }

    public ItemStack getItem(int index) {
        throw new NotImplementedException("getItem(int)");
    }

    public int getMaxStackSize() {
        return getInventory().getInventoryStackLimit();
    }

    public String getName() {
        return getInventory().getInventoryName();
    }

    public int getSize() {
        return getInventory().getSize();
    }

    public String getTitle() {
        return getInventory().getInventoryName();
    }

    public InventoryType getType() {
        return InventoryType.valueOf(inv.getInventoryType().name());
    }

    public List<HumanEntity> getViewers() {
        throw new NotImplementedException("getViewers()");
    }

    public ListIterator<ItemStack> iterator() {
        throw new NotImplementedException("iterator()");
    }

    public ListIterator<ItemStack> iterator(int index) {
        throw new NotImplementedException("iterator(int)");
    }

    public void remove(int materialId) {
        getInventory().removeItem(materialId);
    }

    public void remove(ItemStack item) {
        getInventory().removeItem(item.getTypeId());
    }

    public void remove(Material material) throws IllegalArgumentException {
        getInventory().removeItem(material.getId());
    }

    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException("removeItem(ItemStack...)");
    }

    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        throw new NotImplementedException("ItemStack[]");
    }

    public void setItem(int index, ItemStack item) {
        throw new NotImplementedException("setItem(int, ItemStack)");
    }

    public void setMaxStackSize(int size) {
        throw new NotImplementedException("setMaxStackSize(int)");
    }

    protected net.canarymod.api.inventory.Inventory getInventory() {
        return inv;
    }
}
