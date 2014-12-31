package DivinanceMC.Teams;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public interface TeamHandler {
	
	public String getName();
	
	public ChatColor getColor();
	
	public List<String> getMembers();

}