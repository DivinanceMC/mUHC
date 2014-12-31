package DivinanceMC.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import DivinanceMC.Exceptions.TeamException;
import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.Teams.TeamManager;
import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class Join implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		for (TeamHandler t : mUHC.getTeams()) {
			if (t.getMembers().contains(player.getName())) {
				t.getMembers().add(player.getName());
			event.setJoinMessage(mUHC.getStars(player) + t.getColor() + player.getName() + ChatColor.GRAY + " joined the server.");
			player.sendMessage(mUHC.Prefix + "Welcome to " + ChatColor.GREEN + "mUHC" + ChatColor.GRAY + ".");
			try {
				TeamManager.joinTeam(player, mUHC.getTeam("Green"));
			} catch (TeamException e) {
					}
				}
			
			}
			
		}
				
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		GameState state = mUHC.getState();
			if (state!=GameState.LOBBY);
			try {
				TeamManager.joinTeam(player, mUHC.getTeam("Green"));
			} catch (TeamException e) {
		}
	}

}
