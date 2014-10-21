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
package lexteam.minecraft.canarybukkit.implementation.entity;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;
import lexteam.minecraft.canarybukkit.implementation.inventory.CanaryInventory;
import lexteam.minecraft.canarybukkit.implementation.inventory.CanaryPlayerInventory;
import net.canarymod.Canary;

import org.apache.commons.lang.NotImplementedException;
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
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

public class CanaryPlayer extends CanaryHumanEntity implements Player
{
    private net.canarymod.api.entity.living.humanoid.Player entity;

    public CanaryPlayer(net.canarymod.api.entity.living.humanoid.Player entity) {
        super(entity);
        this.entity = entity;
    }

    public void abandonConversation(Conversation conversation)
    {
        throw new NotImplementedException();
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details)
    {
        throw new NotImplementedException();
    }

    public void acceptConversationInput(String input)
    {
        throw new NotImplementedException();
    }

    public void awardAchievement(Achievement achievement)
    {
        throw new NotImplementedException();
    }

    public boolean beginConversation(Conversation conversation)
    {
        return false;
    }

    public boolean canSee(Player player)
    {
        return false;
    }

    public void chat(String msg)
    {
        entity.chat(msg);
    }

    public void closeInventory()
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount)
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public InetSocketAddress getAddress()
    {
        throw new NotImplementedException();
    }

    public boolean getAllowFlight()
    {
        return false;
    }

    public Location getBedSpawnLocation()
    {
        throw new NotImplementedException();
    }

    public Location getCompassTarget()
    {
        throw new NotImplementedException();
    }

    public String getDisplayName()
    {
        return entity.getDisplayName();
    }

    public Inventory getEnderChest()
    {
        return new CanaryInventory(entity.getEnderChestInventory());
    }

    public float getExhaustion()
    {
        return 0;
    }

    public float getExp()
    {
        return entity.getExperience();
    }

    public long getFirstPlayed()
    {
        return 0;
    }

    public float getFlySpeed()
    {
        return 0;
    }

    public int getFoodLevel()
    {
        return 0;
    }

    public GameMode getGameMode()
    {
        return BukkitUtils.toGameMode(entity.getMode());
    }

    public double getHealthScale()
    {
        return 0;
    }

    public PlayerInventory getInventory()
    {
        return new CanaryPlayerInventory(entity.getInventory(), this);
    }

    public ItemStack getItemInHand()
    {
        throw new NotImplementedException();
    }

    public ItemStack getItemOnCursor()
    {
        throw new NotImplementedException();
    }

    public long getLastPlayed()
    {
        return 0;
    }

    public int getLevel()
    {
        return entity.getLevel();
    }

    public Set<String> getListeningPluginChannels()
    {
        throw new NotImplementedException();
    }

    public InventoryView getOpenInventory()
    {
        throw new NotImplementedException();
    }

    public Player getPlayer()
    {
        return this;
    }

    public String getPlayerListName()
    {
        throw new NotImplementedException();
    }

    public long getPlayerTime()
    {
        return 0;
    }

    public long getPlayerTimeOffset()
    {
        return 0;
    }

    public WeatherType getPlayerWeather()
    {
        throw new NotImplementedException();
    }

    public float getSaturation()
    {
        return 0;
    }

    public Scoreboard getScoreboard()
    {
        throw new NotImplementedException();
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException
    {
        return 0;
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException
    {
        return 0;
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException
    {
        return 0;
    }

    public int getTotalExperience()
    {
        return 0;
    }

    @Override
    public EntityType getType()
    {
        return EntityType.PLAYER;
    }

    @Override
    public UUID getUniqueId()
    {
        return entity.getUUID();
    }

    public float getWalkSpeed()
    {
        return 0;
    }

    public void giveExp(int amount)
    {
        entity.addExperience(amount);
    }

    public void giveExpLevels(int amount)
    {
        entity.addLevel(amount);
    }

    public boolean hasAchievement(Achievement achievement)
    {
        return false;
    }

    public boolean hasPlayedBefore()
    {
        return false;
    }

    public void hidePlayer(Player player)
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public boolean isBanned()
    {
        return false;
    }

    public boolean isConversing()
    {
        return false;
    }

    public boolean isFlying()
    {
        return false;
    }

    public boolean isHealthScaled()
    {
        return false;
    }

    public boolean isOnline()
    {
        return entity.isOnline();
    }

    public boolean isPlayerTimeRelative()
    {
        return false;
    }

    public boolean isSleepingIgnored()
    {
        return false;
    }

    public boolean isSneaking()
    {
        return entity.isSneaking();
    }

    public boolean isSprinting()
    {
        return entity.isSprinting();
    }

    public boolean isWhitelisted()
    {
        return Canary.whitelist().isWhitelisted(getName());
    }

    public void kickPlayer(String message)
    {
        entity.kick(message);
    }

    public void loadData()
    {
        throw new NotImplementedException();
    }

    public InventoryView openEnchanting(Location location, boolean force)
    {
        throw new NotImplementedException();
    }

    public InventoryView openInventory(Inventory inventory)
    {
        throw new NotImplementedException();
    }

    public void openInventory(InventoryView inventory)
    {
        throw new NotImplementedException();
    }

    public InventoryView openWorkbench(Location location, boolean force)
    {
        throw new NotImplementedException();
    }

    public boolean performCommand(String command)
    {
        return Bukkit.getServer().dispatchCommand(this, command);
    }

    public void playEffect(Location loc, Effect effect, int data)
    {
        throw new NotImplementedException();
    }

    public <T> void playEffect(Location loc, Effect effect, T data)
    {
        throw new NotImplementedException();
    }

    public void playNote(Location loc, byte instrument, byte note)
    {
        throw new NotImplementedException();
    }

    public void playNote(Location loc, Instrument instrument, Note note)
    {
        throw new NotImplementedException();
    }

    public void playSound(Location location, Sound sound, float volume, float pitch)
    {
        throw new NotImplementedException();
    }

    public void playSound(Location location, String sound, float volume, float pitch)
    {
        throw new NotImplementedException();
    }

    public void removeAchievement(Achievement achievement)
    {
        throw new NotImplementedException();
    }

    public void resetPlayerTime()
    {
        throw new NotImplementedException();
    }

    public void resetPlayerWeather()
    {
        throw new NotImplementedException();
    }

    public void saveData()
    {
        throw new NotImplementedException();
    }

    public void sendBlockChange(Location loc, int material, byte data)
    {
        throw new NotImplementedException();
    }

    public void sendBlockChange(Location loc, Material material, byte data)
    {
        throw new NotImplementedException();
    }

    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data)
    {
        return false;
    }

    public void sendMap(MapView map)
    {
        throw new NotImplementedException();
    }

    public void sendMessage(String message)
    {
        entity.message(message);
    }

    public void sendMessage(String[] messages)
    {
        for (String msg : messages) {
            entity.message(msg);
        }
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message)
    {
        Bukkit.getServer().sendPluginMessage(source, channel, message);
    }

    public void sendRawMessage(String message)
    {
        throw new NotImplementedException();
    }

    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public Map<String, Object> serialize()
    {
        throw new NotImplementedException();
    }

    public void setAllowFlight(boolean flight)
    {
        throw new NotImplementedException();
    }

    public void setBanned(boolean banned)
    {
        throw new NotImplementedException();
    }

    public void setBedSpawnLocation(Location location)
    {
        throw new NotImplementedException();
    }

    public void setBedSpawnLocation(Location location, boolean force)
    {
        throw new NotImplementedException();
    }

    public void setCompassTarget(Location loc)
    {
        throw new NotImplementedException();
    }

    public void setDisplayName(String name)
    {
        entity.setDisplayName(name);
    }

    public void setExhaustion(float value)
    {
        throw new NotImplementedException();
    }

    public void setExp(float exp)
    {
        throw new NotImplementedException();
    }

    public void setFlying(boolean value)
    {
        throw new NotImplementedException();
    }

    public void setFlySpeed(float value) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void setFoodLevel(int value)
    {
        throw new NotImplementedException();
    }

    public void setGameMode(GameMode mode)
    {
        entity.setMode(CanaryUtils.toGameMode(mode));
    }

    public void setHealthScale(double scale) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void setHealthScaled(boolean scale)
    {
        throw new NotImplementedException();
    }

    public void setItemInHand(ItemStack item)
    {
        throw new NotImplementedException();
    }

    public void setItemOnCursor(ItemStack item)
    {
        throw new NotImplementedException();
    }

    public void setLevel(int level)
    {
        entity.setLevel(level);
    }

    public void setPlayerListName(String name)
    {
        throw new NotImplementedException();
    }

    public void setPlayerTime(long time, boolean relative)
    {
        throw new NotImplementedException();
    }

    public void setPlayerWeather(WeatherType type)
    {
        throw new NotImplementedException();
    }

    public void setResourcePack(String url)
    {
        throw new NotImplementedException();
    }

    public void setSaturation(float value)
    {
        throw new NotImplementedException();
    }

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException
    {
        throw new NotImplementedException();
    }

    public void setSleepingIgnored(boolean isSleeping)
    {
        throw new NotImplementedException();
    }

    public void setSneaking(boolean sneak)
    {
        entity.setSneaking(sneak);
    }

    public void setSprinting(boolean sprinting)
    {
        entity.setSprinting(sprinting);
    }

    public void setStatistic(Statistic statistic, EntityType entityType, int newValue)
    {
        throw new NotImplementedException();
    }

    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void setStatistic(Statistic statistic, Material material, int newValue)
            throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void setTexturePack(String url)
    {
        throw new NotImplementedException();
    }

    public void setTotalExperience(int exp)
    {
        throw new NotImplementedException();
    }

    public void setWalkSpeed(float value) throws IllegalArgumentException
    {
        throw new NotImplementedException();
    }

    public void setWhitelisted(boolean value)
    {
        Canary.whitelist().addPlayer(getName());
    }

    public void showPlayer(Player player)
    {
        throw new NotImplementedException();
    }

    public void updateInventory()
    {
        entity.getInventory().update();
    }
}