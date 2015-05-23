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
package uk.jamierocks.canarybukkit.impl.entity;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import uk.jamierocks.canarybukkit.impl.inventory.CanaryInventory;
import uk.jamierocks.canarybukkit.util.converter.GameModeConverter;
import net.canarymod.Canary;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryPlayer extends CanaryHumanEntity implements Player {
    public CanaryPlayer(net.canarymod.api.entity.living.humanoid.Player entity) {
        super(entity);
    }

    public void abandonConversation(Conversation conversation) {
        throw new NotImplementedException("abandonConversation(Conversation)");
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new NotImplementedException("abandonConversation(Conversation, ConversationAbandonedEvent)");
    }

    public void acceptConversationInput(String input) {
        throw new NotImplementedException("acceptConversationInput(String)");
    }

    public void awardAchievement(Achievement achievement) {
        throw new NotImplementedException("awardAchievement(Achievement)");
    }

    public boolean beginConversation(Conversation conversation) {
        throw new NotImplementedException("beginConversation(Conversation)");
    }

    public boolean canSee(Player player) {
        return getHandle().canSee(Canary.getServer().getPlayerFromUUID(player.getUniqueId()));
    }

    public void chat(String msg) {
        getHandle().chat(msg);
    }

    public void closeInventory() {
        getHandle().closeWindow();
        // TODO: Review
    }

    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException("decrementStatistic(Statistic)");
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException("decrementStatistic(Statistic, EntityType)");
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        throw new NotImplementedException("decrementStatistic(Statistic, EntityType, int)");
    }

    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException("decrementStatistic(Statistic, int)");
    }

    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException("decrementStatistic(Statistic, Material)");
    }

    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new NotImplementedException("decrementStatistic(Statistic, Material, int)");
    }

    public InetSocketAddress getAddress() {
        return new InetSocketAddress(getHandle().getIP(), 0);
    }

    public boolean getAllowFlight() {
        return getHandle().getCapabilities().mayFly();
    }

    public Location getBedSpawnLocation() {
        throw new NotImplementedException("getBedSpawnLocation()");
    }

    public Location getCompassTarget() {
        throw new NotImplementedException("getCompassTarget()");
    }

    public String getDisplayName() {
        return getHandle().getDisplayName();
    }

    public Inventory getEnderChest() {
        return new CanaryInventory(getHandle().getEnderChestInventory());
    }

    public float getExhaustion() {
        return getHandle().getExhaustionLevel();
    }

    public float getExp() {
        return getHandle().getExperience();
    }

    public long getFirstPlayed() {
        throw new NotImplementedException("getFirstPlayed()");
    }

    public float getFlySpeed() {
        return getHandle().getCapabilities().getFlySpeed();
    }

    public int getFoodLevel() {
        throw new NotImplementedException("getFoodLevel()");
    }

    public GameMode getGameMode() {
        return GameModeConverter.of(getHandle().getMode());
    }

    public double getHealthScale() {
        throw new NotImplementedException("getHealthScale()");
    }

    public ItemStack getItemInHand() {
        throw new NotImplementedException("getItemInHand()");
    }

    public ItemStack getItemOnCursor() {
        throw new NotImplementedException("getItemOnCursor()");
    }

    public long getLastPlayed() {
        throw new NotImplementedException("getLastPlayed()");
    }

    public int getLevel() {
        return getHandle().getLevel();
    }

    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException("getListeningPluginChannels()");
    }

    public InventoryView getOpenInventory() {
        throw new NotImplementedException("getOpenInventory()");
    }

    public Player getPlayer() {
        return this;
    }

    public String getPlayerListName() {
        throw new NotImplementedException("getPlayerListName()");
    }

    public long getPlayerTime() {
        throw new NotImplementedException("getPlayerTime()");
    }

    public long getPlayerTimeOffset() {
        throw new NotImplementedException("getPlayerTimeOffset()");
    }

    public WeatherType getPlayerWeather() {
        throw new NotImplementedException("getPlayerWeather()");
    }

    public float getSaturation() {
        throw new NotImplementedException("getSaturation()");
    }

    public Scoreboard getScoreboard() {
        throw new NotImplementedException("getScoreboard()");
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException("getStatistic(Statistic)");
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException("getStatistic(Statistic, EntityType)");
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException("getStatistic(Statistic, Material)");
    }

    public int getTotalExperience() {
        return getHandle().getExperience();
    }

    public EntityType getType() {
        return EntityType.PLAYER;
    }

    public float getWalkSpeed() {
        return getHandle().getCapabilities().getWalkSpeed();
    }

    public void giveExp(int amount) {
        getHandle().addExperience(amount);
    }

    public void giveExpLevels(int amount) {
        getHandle().addLevel(amount);
    }

    public boolean hasAchievement(Achievement achievement) {
        throw new NotImplementedException("hasAchievement(Achievement achievement)");
    }

    public boolean hasPlayedBefore() {
        throw new NotImplementedException("hasPlayedBefore()");
    }

    public void hidePlayer(Player player) {
        throw new NotImplementedException("hidePlayer(Player)");
    }

    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic)");
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic, EntityType)");
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic, EntityType, int)");
    }

    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic, int)");
    }

    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic, Material)");
    }

    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new NotImplementedException("incrementStatistic(Statistic, Material, int)");
    }

    public boolean isBanned() {
        return Canary.bans().isBanned(getHandle().getUUID().toString());
    }

    public boolean isConversing() {
        throw new NotImplementedException("isConversing()");
    }

    public boolean isFlying() {
        return getHandle().getCapabilities().isFlying();
    }

    public boolean isHealthScaled() {
        throw new NotImplementedException("isHealthScaled()");
    }

    public boolean isOnline() {
        return getHandle().isOnline();
    }

    public boolean isPlayerTimeRelative() {
        throw new NotImplementedException("isPlayerTimeRelative()");
    }

    public boolean isSleepingIgnored() {
        throw new NotImplementedException("isSleepingIgnored()");
    }

    public boolean isSneaking() {
        return getHandle().isSneaking();
    }

    public boolean isSprinting() {
        return getHandle().isSprinting();
    }

    public boolean isWhitelisted() {
        return Canary.whitelist().isWhitelisted(getHandle().getUUID().toString());
    }

    public void kickPlayer(String message) {
        getHandle().kick(message);
    }

    public void loadData() {
        throw new NotImplementedException("loadData()");
    }

    public InventoryView openEnchanting(Location location, boolean force) {
        throw new NotImplementedException("openEnchanting(Location, boolean)");
    }

    public InventoryView openInventory(Inventory inventory) {
        throw new NotImplementedException("openInventory(Inventory)");
    }

    public void openInventory(InventoryView inventory) {
        throw new NotImplementedException("openInventory(InventoryView)");
    }

    public InventoryView openWorkbench(Location location, boolean force) {
        throw new NotImplementedException("openWorkbench(Location, boolean)");
    }

    public boolean performCommand(String command) {
        return Bukkit.getServer().dispatchCommand(this, command);
    }

    public void playEffect(Location loc, Effect effect, int data) {
        throw new NotImplementedException("playEffect(Location, Effect, int)");
    }

    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new NotImplementedException("playEffect(Location, Effect, T)");
    }

    public void playNote(Location loc, byte instrument, byte note) {
        throw new NotImplementedException("playNote(Location, byte, byte)");
    }

    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new NotImplementedException("playNote(Location, Instrument, Note)");
    }

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new NotImplementedException("playSound(Location, Sound, float, float)");
    }

    public void playSound(Location location, String sound, float volume, float pitch) {
        throw new NotImplementedException("playSound(Location, String, float, float)");
    }

    public void removeAchievement(Achievement achievement) {
        throw new NotImplementedException("removeAchievement(Achievement)");
    }

    public void resetPlayerTime() {
        throw new NotImplementedException("resetPlayerTime()");
    }

    public void resetPlayerWeather() {
        throw new NotImplementedException("resetPlayerWeather()");
    }

    public void saveData() {
        throw new NotImplementedException("saveData()");
    }

    public void sendBlockChange(Location loc, int material, byte data) {
        throw new NotImplementedException("sendBlockChange(Location, int, byte)");
    }

    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new NotImplementedException("sendBlockChange(Location, Material, byte)");
    }

    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        throw new NotImplementedException("sendChunkChange(Location, int, int, int, byte[])");
    }

    public void sendMap(MapView map) {
        throw new NotImplementedException("sendMap(MapView)");
    }

    public void sendMessage(String message) {
        getHandle().message(message);
    }

    public void sendMessage(String[] messages) {
        for (String msg : messages) {
            getHandle().message(msg);
        }
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        Bukkit.getServer().sendPluginMessage(source, channel, message);
    }

    public void sendRawMessage(String message) {
        throw new NotImplementedException("sendRawMessage(String)");
    }

    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new NotImplementedException("sendSignChange(Location, String[])");
    }

    public Map<String, Object> serialize() {
        throw new NotImplementedException("serialize()");
    }

    public void setAllowFlight(boolean flight) {
        getHandle().getCapabilities().setMayFly(flight);
    }

    public void setBanned(boolean banned) {
        Canary.bans().issueBan(getHandle(), "The Ban Hammer Has Spoken!");
    }

    public void setBedSpawnLocation(Location location) {
        throw new NotImplementedException("setBedSpawnLocation(Location)");
    }

    public void setBedSpawnLocation(Location location, boolean force) {
        throw new NotImplementedException("setBedSpawnLocation(Location, boolean)");
    }

    public void setCompassTarget(Location loc) {
        throw new NotImplementedException("setCompassTarget(Location)");
    }

    public void setDisplayName(String name) {
        getHandle().setDisplayName(name);
    }

    public void setExhaustion(float value) {
        throw new NotImplementedException("setExhaustion(float)");
    }

    public void setExp(float exp) {
        throw new NotImplementedException("setExp(float)");
    }

    public void setFlying(boolean value) {
        getHandle().getCapabilities().setFlying(value);
    }

    public void setFlySpeed(float value) throws IllegalArgumentException {
        getHandle().getCapabilities().setFlySpeed(value);
    }

    public void setFoodLevel(int value) {
        throw new NotImplementedException("setFoodLevel(int)");
    }

    public void setGameMode(GameMode mode) {
        getHandle().setMode(GameModeConverter.of(mode));
    }

    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new NotImplementedException("setHealthScale(double)");
    }

    public void setHealthScaled(boolean scale) {
        throw new NotImplementedException("setHealthScaled(boolean)");
    }

    public void setItemInHand(ItemStack item) {
        throw new NotImplementedException("setItemInHand(ItemStack)");
    }

    public void setItemOnCursor(ItemStack item) {
        throw new NotImplementedException("setItemOnCursor(ItemStack)");
    }

    public void setLevel(int level) {
        getHandle().setLevel(level);
    }

    public void setPlayerListName(String name) {
        throw new NotImplementedException("setPlayerListName(String)");
    }

    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException("setPlayerTime(long, boolean)");
    }

    public void setPlayerWeather(WeatherType type) {
        throw new NotImplementedException("setPlayerWeather(WeatherType)");
    }

    public void setResourcePack(String url) {
        throw new NotImplementedException("setResourcePack(String)");
    }

    public void setSaturation(float value) {
        throw new NotImplementedException("setSaturation(float)");
    }

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("setScoreboard(Scoreboard)");
    }

    public void setSleepingIgnored(boolean isSleeping) {
        throw new NotImplementedException("setSleepingIgnored(boolean)");
    }

    public void setSneaking(boolean sneak) {
        getHandle().setSneaking(sneak);
    }

    public void setSprinting(boolean sprinting) {
        getHandle().setSprinting(sprinting);
    }

    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        throw new NotImplementedException("setStatistic(Statistic, EntityType, int)");
    }

    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException("setStatistic(Statistic, int)");
    }

    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException("setStatistic(Statistic, Material, int)");
    }

    public void setTexturePack(String url) {
        throw new NotImplementedException("setTexturePack(String)");
    }

    public void setTotalExperience(int exp) {
        getHandle().setExperience(exp);
    }

    public void setWalkSpeed(float value) throws IllegalArgumentException {
        getHandle().getCapabilities().setWalkSpeed(value);
    }

    public void setWhitelisted(boolean value) {
        Canary.whitelist().addPlayer(getName());
    }

    public void showPlayer(Player player) {
        throw new NotImplementedException("showPlayer(Player)");
    }

    public void updateInventory() {
        getHandle().getInventory().update();
    }

    public boolean isOp() {
        return Canary.ops().isOpped(getHandle().getUUIDString());
    }

    public void setOp(boolean value) {
        Canary.ops().addPlayer(getHandle().getUUIDString());
    }

    public boolean isSleeping() {
        return getHandle().isSleeping();
    }

    @Override
    protected net.canarymod.api.entity.living.humanoid.Player getHandle() {
        return (net.canarymod.api.entity.living.humanoid.Player) super.getHandle();
    }
}
