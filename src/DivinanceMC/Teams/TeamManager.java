package DivinanceMC.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import DivinanceMC.Exceptions.TeamException;
import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class TeamManager {
	
	public static void joinTeam(Player player, TeamHandler team) throws TeamException {
		if (mUHC.getState()== GameState.LOBBY || mUHC.getState()== GameState.STARTING) {
			for (TeamHandler t : mUHC.getTeams()) {
				if (t.getMembers().contains(player.getName())) {
					t.getMembers().remove(player.getName());
				}
				
			}	
			team.getMembers().add(player.getName());
			player.sendMessage(mUHC.Prefix + "You have joined " + team.getColor() + team.getName() + ChatColor.GRAY + ".");	
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join " + team.getName() + " " + player.getName());
	} else {
		throw new TeamException(mUHC.Prefix + "Teams may not be changed unless the game is in lobby.");
		}
	
	}

}