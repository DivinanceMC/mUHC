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
		String player1 = event.getPlayer().getName();
		int players = Bukkit.getOnlinePlayers().length;
		int players1 = Bukkit.getOnlinePlayers().length - 1;
		for (TeamHandler t : mUHC.getTeams()) {
			if (t.getMembers().contains(player.getName())) {
				t.getMembers().add(player.getName());
			Bukkit.broadcastMessage(mUHC.getStars(player) + t.getColor() + player1 + ChatColor.GRAY + " left the server." + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players1 + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");
			event.setQuitMessage(null);
			}
			
		}
		
	}
	
}
