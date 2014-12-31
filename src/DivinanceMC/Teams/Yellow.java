package DivinanceMC.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Yellow implements TeamHandler {
	
	public List<String> members = new ArrayList<String>();
	
	public String getName() {
		return "Yellow";
	}
	
	public ChatColor getColor() {
		return ChatColor.YELLOW;
	}
	
	public List<String> getMembers() {
		return members;
	}

}
