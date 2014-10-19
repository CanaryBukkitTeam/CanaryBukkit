/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
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

    public int getSize() {
        return inv.getSize();
    }

    public int getMaxStackSize() {
        return inv.getInventoryStackLimit();
    }

    public void setMaxStackSize(int size) {
        throw new NotImplementedException();
    }

    public String getName() {
        return inv.getInventoryName();
    }

    public ItemStack getItem(int index) {
        throw new NotImplementedException();
    }

    public void setItem(int index, ItemStack item) {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public ItemStack[] getContents() {
        return new ItemStack[0];
    }

    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public boolean contains(int materialId) {
        return inv.hasItem(materialId);
    }

    public boolean contains(Material material) throws IllegalArgumentException {
        return inv.hasItem(material.getId());
    }

    public boolean contains(ItemStack item) {
        return inv.hasItem(item.getTypeId());
    }

    public boolean contains(int materialId, int amount) {
        return inv.hasItemStack(materialId, amount);
    }

    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        return inv.hasItemStack(material.getId(), amount);
    }

    public boolean contains(ItemStack item, int amount) {
        return inv.hasItemStack(item.getTypeId(), amount);
    }

    public boolean containsAtLeast(ItemStack item, int amount) {
        return false;
    }

    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new NotImplementedException();
    }

    public int first(int materialId) {
        return 0;
    }

    public int first(Material material) throws IllegalArgumentException {
        return 0;
    }

    public int first(ItemStack item) {
        return 0;
    }

    public int firstEmpty() {
        return 0;
    }

    public void remove(int materialId) {
        inv.removeItem(materialId);
    }

    public void remove(Material material) throws IllegalArgumentException {
        inv.removeItem(material.getId());
    }

    public void remove(ItemStack item) {
        inv.removeItem(item.getTypeId());
    }

    public void clear(int index) {
        throw new NotImplementedException();
    }

    public void clear() {
        inv.clearInventory();
    }

    public List<HumanEntity> getViewers() {
        throw new NotImplementedException();
    }

    public String getTitle() {
        return inv.getInventoryName();
    }

    public InventoryType getType() {
        return InventoryType.valueOf(inv.getInventoryType().name());
    }

    public InventoryHolder getHolder() {
        throw new NotImplementedException();
    }

    public ListIterator<ItemStack> iterator() {
        throw new NotImplementedException();
    }

    public ListIterator<ItemStack> iterator(int index) {
        throw new NotImplementedException();
    }
}