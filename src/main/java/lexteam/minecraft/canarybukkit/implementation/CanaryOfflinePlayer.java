package lexteam.minecraft.canarybukkit.implementation;

import java.util.Map;

import net.canarymod.Canary;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CanaryOfflinePlayer implements OfflinePlayer {

	private net.canarymod.api.OfflinePlayer offlinePlayer;
	
	public CanaryOfflinePlayer(net.canarymod.api.OfflinePlayer offlinePlayer) {
		this.offlinePlayer = offlinePlayer;
	}

	public boolean isOp() {
		return false; //offlinePlayer.isAdmin()
	}

	public void setOp(boolean op) {
		
	}

	public Map<String, Object> serialize() {
		return null;
	}

	public Location getBedSpawnLocation() {
		return null;
	}

	public long getFirstPlayed() {
		return 0;
	}

	public long getLastPlayed() {
		return 0;
	}

	public String getName() {
		return offlinePlayer.getName();
	}

	public Player getPlayer() {
		return null;
	}

	public boolean hasPlayedBefore() {
		return false;
	}

	public boolean isBanned() {
		return Canary.bans().isBanned(getName());
	}

	public boolean isOnline() {
		return offlinePlayer.isOnline();
	}

	public boolean isWhitelisted() {
		return false;
	}

	public void setBanned(boolean banned) {
		
	}

	public void setWhitelisted(boolean whitelisted) {
		if(whitelisted)
			Canary.whitelist().addPlayer(getName());
		else
			Canary.whitelist().removePlayer(getName());
	}

}
