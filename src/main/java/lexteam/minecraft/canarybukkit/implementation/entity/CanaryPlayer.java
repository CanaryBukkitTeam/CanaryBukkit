/**
 * This file is part of CanaryBukkit, a CanaryMod plugin, licensed under the MIT License (MIT).
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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CanaryPlayer extends CanaryHumanEntity implements Player {
    private net.canarymod.api.entity.living.humanoid.Player entity;

    public CanaryPlayer(net.canarymod.api.entity.living.humanoid.Player entity) {
        super(entity);
        this.entity = entity;
    }

    public String getDisplayName() {
        return entity.getDisplayName();
    }

    public void setDisplayName(String name) {
        entity.setDisplayName(name);
    }

    public String getPlayerListName() {
        throw new NotImplementedException();
    }

    public void setPlayerListName(String name) {
        throw new NotImplementedException();
    }

    public void setCompassTarget(Location loc) {
        throw new NotImplementedException();
    }

    public Location getCompassTarget() {
        throw new NotImplementedException();
    }

    public InetSocketAddress getAddress() {
        throw new NotImplementedException();
    }

    public boolean isConversing() {
        return false;
    }

    public void acceptConversationInput(String input) {
        throw new NotImplementedException();
    }

    public boolean beginConversation(Conversation conversation) {
        return false;
    }

    public void abandonConversation(Conversation conversation) {
        throw new NotImplementedException();
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new NotImplementedException();
    }

    public void sendRawMessage(String message) {
        throw new NotImplementedException();
    }

    public void kickPlayer(String message) {
        entity.kick(message);
    }

    public void chat(String msg) {
        entity.chat(msg);
    }

    public boolean performCommand(String command) {
        return false;
    }

    public boolean isSneaking() {
        return entity.isSneaking();
    }

    public void setSneaking(boolean sneak) {
        entity.setSneaking(sneak);
    }

    public boolean isSprinting() {
        return entity.isSprinting();
    }

    public void setSprinting(boolean sprinting) {
        entity.setSprinting(sprinting);
    }

    public void saveData() {
        throw new NotImplementedException();
    }

    public void loadData() {
        throw new NotImplementedException();
    }

    public void setSleepingIgnored(boolean isSleeping) {
        throw new NotImplementedException();
    }

    public boolean isSleepingIgnored() {
        return false;
    }

    public void playNote(Location loc, byte instrument, byte note) {
        throw new NotImplementedException();
    }

    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new NotImplementedException();
    }

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new NotImplementedException();
    }

    public void playSound(Location location, String sound, float volume, float pitch) {
        throw new NotImplementedException();
    }

    public void playEffect(Location loc, Effect effect, int data) {
        throw new NotImplementedException();
    }

    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new NotImplementedException();
    }

    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new NotImplementedException();
    }

    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        return false;
    }

    public void sendBlockChange(Location loc, int material, byte data) {
        throw new NotImplementedException();
    }

    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void sendMap(MapView map) {
        throw new NotImplementedException();
    }

    public void updateInventory() {
        entity.getInventory().update();
    }

    public void awardAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    public void removeAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    public boolean hasAchievement(Achievement achievement) {
        return false;
    }

    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return 0;
    }

    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return 0;
    }

    public void incrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void setStatistic(Statistic statistic, Material material, int newValue)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return 0;
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        throw new NotImplementedException();
    }

    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        throw new NotImplementedException();
    }

    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException();
    }

    public long getPlayerTime() {
        return 0;
    }

    public long getPlayerTimeOffset() {
        return 0;
    }

    public boolean isPlayerTimeRelative() {
        return false;
    }

    public void resetPlayerTime() {
        throw new NotImplementedException();
    }

    public void setPlayerWeather(WeatherType type) {
        throw new NotImplementedException();
    }

    public WeatherType getPlayerWeather() {
        throw new NotImplementedException();
    }

    public void resetPlayerWeather() {
        throw new NotImplementedException();
    }

    public void giveExp(int amount) {
        throw new NotImplementedException();
    }

    public void giveExpLevels(int amount) {
        throw new NotImplementedException();
    }

    public float getExp() {
        return entity.getExperience();
    }

    public void setExp(float exp) {
        throw new NotImplementedException();
    }

    public int getLevel() {
        return 0;
    }

    public void setLevel(int level) {
        throw new NotImplementedException();
    }

    public int getTotalExperience() {
        return 0;
    }

    public void setTotalExperience(int exp) {
        throw new NotImplementedException();
    }

    public float getExhaustion() {
        return 0;
    }

    public void setExhaustion(float value) {
        throw new NotImplementedException();
    }

    public float getSaturation() {
        return 0;
    }

    public void setSaturation(float value) {
        throw new NotImplementedException();
    }

    public int getFoodLevel() {
        return 0;
    }

    public void setFoodLevel(int value) {
        throw new NotImplementedException();
    }

    public boolean isOnline() {
        return entity.isOnline();
    }

    public boolean isBanned() {
        return false;
    }

    public void setBanned(boolean banned) {
        throw new NotImplementedException();
    }

    public boolean isWhitelisted() {
        return false;
    }

    public void setWhitelisted(boolean value) {
        throw new NotImplementedException();
    }

    public Player getPlayer() {
        return this;
    }

    public long getFirstPlayed() {
        return 0;
    }

    public long getLastPlayed() {
        return 0;
    }

    public boolean hasPlayedBefore() {
        return false;
    }

    public Location getBedSpawnLocation() {
        throw new NotImplementedException();
    }

    public void setBedSpawnLocation(Location location) {
        throw new NotImplementedException();
    }

    public void setBedSpawnLocation(Location location, boolean force) {
        throw new NotImplementedException();
    }

    public boolean getAllowFlight() {
        return false;
    }

    public void setAllowFlight(boolean flight) {
        throw new NotImplementedException();
    }

    public void hidePlayer(Player player) {
        throw new NotImplementedException();
    }

    public void showPlayer(Player player) {
        throw new NotImplementedException();
    }

    public boolean canSee(Player player) {
        return false;
    }

    public boolean isFlying() {
        return false;
    }

    public void setFlying(boolean value) {
        throw new NotImplementedException();
    }

    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public void setWalkSpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public float getFlySpeed() {
        return 0;
    }

    public float getWalkSpeed() {
        return 0;
    }

    public void setTexturePack(String url) {
        throw new NotImplementedException();
    }

    public void setResourcePack(String url) {
        throw new NotImplementedException();
    }

    public Scoreboard getScoreboard() {
        throw new NotImplementedException();
    }

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

    public boolean isHealthScaled() {
        return false;
    }

    public void setHealthScaled(boolean scale) {
        throw new NotImplementedException();
    }

    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    public double getHealthScale() {
        return 0;
    }

    public void sendMessage(String message) {
        entity.message(message);
    }

    public void sendMessage(String[] messages) {
        for (String msg : messages) {
            entity.message(msg);
        }
    }

    public Map<String, Object> serialize() {
        throw new NotImplementedException();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new NotImplementedException();
    }

    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException();
    }

    @Override
    public UUID getUniqueId() {
        return entity.getUUID();
    }
}