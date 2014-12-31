package DivinanceMC.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.mUHC.mUHC;

public class Chat implements Listener {
	
	@EventHandler
	public boolean onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String msg = event.getMessage();
		for (TeamHandler t : mUHC.getTeams()) {
			if (t.getMembers().contains(player.getName())) {
				t.getMembers().add(player.getName());
			event.setFormat(mUHC.getStars(player) + t.getColor() + player.getName() + ChatColor.GRAY + ": " + ChatColor.WHITE + msg);
			return true;
			}
			
		}
		return false;
	
	}
	
}