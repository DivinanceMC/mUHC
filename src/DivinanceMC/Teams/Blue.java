package DivinanceMC.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Blue implements TeamHandler {
	
	public List<String> members = new ArrayList<String>();
	
	public String getName() {
		return "Blue";
	}
	
	public ChatColor getColor() {
		return ChatColor.BLUE;
	}
	
	public List<String> getMembers() {
		return members;
	}

}
