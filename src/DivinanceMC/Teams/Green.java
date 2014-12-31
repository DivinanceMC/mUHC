package DivinanceMC.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Green implements TeamHandler {
	
	public List<String> members = new ArrayList<String>();
	
	public String getName() {
		return "Green";
	}
	
	public ChatColor getColor() {
		return ChatColor.DARK_GREEN;
	}
	
	public List<String> getMembers() {
		return members;
	}

}
