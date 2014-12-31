package DivinanceMC.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Red implements TeamHandler {
	
	public List<String> members = new ArrayList<String>();
	
	public String getName() {
		return "Red";
	}
	
	public ChatColor getColor() {
		return ChatColor.DARK_RED;
	}
	
	public List<String> getMembers() {
		return members;
	}

}
