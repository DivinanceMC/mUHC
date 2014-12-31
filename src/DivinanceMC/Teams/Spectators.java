package DivinanceMC.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Spectators implements TeamHandler {
	
	public List<String> members = new ArrayList<String>();
	
	public String getName() {
		return "Spectators";
	}
	
	public ChatColor getColor() {
		return ChatColor.DARK_GRAY;
	}
	
	public List<String> getMembers() {
		return members;
	}

}
