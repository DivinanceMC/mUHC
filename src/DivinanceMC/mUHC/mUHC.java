package DivinanceMC.mUHC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import DivinanceMC.Listeners.Chat;
import DivinanceMC.Listeners.Join;
import DivinanceMC.Listeners.Leave;
import DivinanceMC.Teams.Blue;
import DivinanceMC.Teams.Green;
import DivinanceMC.Teams.Red;
import DivinanceMC.Teams.Spectators;
import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.Teams.Yellow;
import DivinanceMC.Utilities.GameState;

public class mUHC extends JavaPlugin implements Listener, CommandExecutor {
	
	public static String Prefix = ChatColor.GRAY + " | " + ChatColor.GREEN + "mUHC" + ChatColor.GRAY + " | " + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "";
	
	private static List<TeamHandler> teams = new ArrayList<TeamHandler>();
	private static int ticks = 0;
	private static GameState state;
	
	public static List<TeamHandler> getTeams() {
		return teams;
	}
	
	public static int getTicks() {
		return ticks;	
	}
	
	public static GameState getState() {
		return state;
	}
	
	public static void setState(GameState state) {
		mUHC.state = state;
	}
	
	public static TeamHandler getTeam(String name) {
		for (TeamHandler team : getTeams()) {
			if (team.getName().equalsIgnoreCase(name)) {
				return team;
			}
			
		}
		
		return null;
	}
	
	public static TeamHandler getTeams(Player player) {
		for (TeamHandler team : getTeams()) {
			if(team.getMembers().contains(player.getName())) {
				return team;
			}
			
		}
		
		return null;
	}
	
	public static String getStars(Player player) {
        String stars = "";
        Ranks member = Ranks.getMember(player);
        if (Arrays.asList("XVenom17").contains(member.getName())) {
            stars += ChatColor.DARK_PURPLE + "✽";
        }
        if (member.isStaff()) {
            stars += ChatColor.GOLD + "✽";
        }
        return stars;
    }
	
	public void onEnable() {	
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Leave(), this);
		
		this.getCommand("kick").setExecutor(new DivinanceMC.Commands.Kick());
			
		state=GameState.LOBBY;
		
		teams.add(new Blue());
		teams.add(new Red());
		teams.add(new Green());
		teams.add(new Yellow());
		
		teams.add(new Spectators());
	}
	
	public void onDisable() {
		/** 
		* Not Completed
		*/
	}
	
}