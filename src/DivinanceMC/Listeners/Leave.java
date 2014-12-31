package DivinanceMC.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.mUHC.mUHC;

public class Leave implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		for (TeamHandler t : mUHC.getTeams()) {
			if (t.getMembers().contains(player.getName())) {
				t.getMembers().add(player.getName());
			event.setQuitMessage(null);
			Bukkit.broadcastMessage(mUHC.getStars(player) + t.getColor() + player.getName() + ChatColor.GRAY + " left the server.");
			}
			
		}
		
	}
	
}
