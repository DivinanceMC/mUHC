package DivinanceMC.Teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import DivinanceMC.Exceptions.TeamException;
import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class TeamManager {
	
	public static void joinTeam(Player player, TeamHandler team) throws TeamException {
		if (mUHC.getState()== GameState.LOBBY || mUHC.getState()== GameState.PREGAME) {
			for (TeamHandler t : mUHC.getTeams()) {
				if (t.getMembers().contains(player.getName())) {
					t.getMembers().remove(player.getName());
				}
				
			}
			
			team.getMembers().add(player.getName());
			player.sendMessage(mUHC.Prefix + "You have joined " + team.getColor() + team.getName() + ChatColor.GRAY + ".");
			
	} else {
		throw new TeamException(mUHC.Prefix + "Teams may not be changed unless the game is in lobby.");
		}
	
	}

}