package lexteam.minecraft.canarybukkit.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

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
		return false;
	}

	public boolean contains(Material material) throws IllegalArgumentException {
		return false;
	}

	public boolean contains(ItemStack item) {
		return false;
	}

	public boolean contains(int materialId, int amount) {
		return false;
	}

	public boolean contains(Material material, int amount) throws IllegalArgumentException {
		return false;
	}

	public boolean contains(ItemStack item, int amount) {
		return false;
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
		throw new NotImplementedException();
	}

	public void remove(Material material) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	public void remove(ItemStack item) {
		throw new NotImplementedException();
	}

	public void clear(int index) {
		throw new NotImplementedException();
	}

	public void clear() {
		throw new NotImplementedException();
	}

	public List<HumanEntity> getViewers() {
		throw new NotImplementedException();
	}

	public String getTitle() {
		throw new NotImplementedException();
	}

	public InventoryType getType() {
		throw new NotImplementedException();
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