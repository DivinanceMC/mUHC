package DivinanceMC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import DivinanceMC.Exceptions.TeamException;
import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.Teams.TeamManager;
import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class Team implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		mUHC.setState(GameState.STARTING);
		
		if (!(sender instanceof Player)) {
        	sender.sendMessage(mUHC.Prefix + "This command is disabled for " + ChatColor.DARK_PURPLE + "✽" + ChatColor.GOLD + "✽" + ChatColor.DARK_GRAY + "Console" + ChatColor.GRAY + ".");
            return true;
        	}
       
        Player player = (Player) sender;
		
        if (cmd.getName().equalsIgnoreCase("team")) {
			if (!sender.hasPermission("mCore.Team")) {
				sender.sendMessage(mUHC.Prefix + "You don't have permission to use this command.");
				return true;
				}
			
		if (args.length != 2) {
			player.sendMessage(mUHC.Prefix + "You've provided incorrect arguments. Use " + ChatColor.GREEN + "/team [player] [team]" + ChatColor.GRAY + ".");
			return true;
		}
		
		Player target = Bukkit.getServer().getPlayer(args[0]);
		
		if (args.length == 2) {
			for (TeamHandler t : mUHC.getTeams()) {
				if (t.getMembers().contains(player.getName())) {
					t.getMembers().add(player.getName());
                if (args[1].equalsIgnoreCase("Spectators")) {
                	target.kickPlayer(mUHC.Prefix + "You have joined " + t.getColor() + t.getName() + ChatColor.GRAY + ".");
                	Bukkit.broadcastMessage(mUHC.Prefix + mUHC.getStars(player) + t.getColor() + player.getName() + ChatColor.GRAY + " has joined " + t.getName() + ChatColor.GRAY + ".");
                	try {
        				TeamManager.joinTeam(player, mUHC.getTeam("Spectators"));
        			} catch (TeamException e) { 	
        				} 
                	
                	} else if (args[1].equalsIgnoreCase("Blue")) {
                	target.kickPlayer(mUHC.Prefix + "You have joined " + t.getColor() + t.getName() + ChatColor.GRAY + ".");
                	Bukkit.broadcastMessage(mUHC.Prefix + mUHC.getStars(player) + t.getColor() + player.getName() + ChatColor.GRAY + " has joined " + t.getName() + ChatColor.GRAY + ".");
                    try {
                    	TeamManager.joinTeam(player, mUHC.getTeam("Blue"));
                	} catch (TeamException e1) {
                		mUHC.addToBlue(player.getName());
                		return true;
                			}
                    
                		}
                
					}
				
				}
			
			}
		
        }
		return false;
	
	}
	
}