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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CanaryPlayerInventory extends CanaryInventory implements PlayerInventory
{
    private net.canarymod.api.inventory.PlayerInventory inv;
    private Player owner;

    public CanaryPlayerInventory(net.canarymod.api.inventory.PlayerInventory inv, Player owner) {
        super(inv);
        this.inv = inv;
        this.owner = owner;
    }

    public int clear(int id, int data)
    {
        throw new NotImplementedException();
    }

    public ItemStack[] getArmorContents()
    {
        throw new NotImplementedException();
    }

    public ItemStack getBoots()
    {
        throw new NotImplementedException();
    }

    public ItemStack getChestplate()
    {
        throw new NotImplementedException();
    }

    public int getHeldItemSlot()
    {
        throw new NotImplementedException();
    }

    public ItemStack getHelmet()
    {
        throw new NotImplementedException();
    }

    @Override
    public HumanEntity getHolder()
    {
        return owner;
    }

    public ItemStack getItemInHand()
    {
        throw new NotImplementedException();
    }

    public ItemStack getLeggings()
    {
        throw new NotImplementedException();
    }

    public void setArmorContents(ItemStack[] items)
    {
        throw new NotImplementedException();
    }

    public void setBoots(ItemStack boots)
    {
        throw new NotImplementedException();
    }

    public void setChestplate(ItemStack chestplate)
    {
        throw new NotImplementedException();
    }

    public void setHeldItemSlot(int slot)
    {
        throw new NotImplementedException();
    }

    public void setHelmet(ItemStack helmet)
    {
        throw new NotImplementedException();
    }

    public void setItemInHand(ItemStack stack)
    {
        throw new NotImplementedException();
    }

    public void setLeggings(ItemStack leggings)
    {
        throw new NotImplementedException();
    }
}
