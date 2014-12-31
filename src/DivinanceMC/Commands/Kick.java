package DivinanceMC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import DivinanceMC.mUHC.mUHC;

public class Kick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
        	sender.sendMessage(mUHC.Prefix + "This command is disabled for " + ChatColor.DARK_PURPLE + "Console" + ChatColor.GRAY + ".");
            return true;
        	}
       
        Player player = (Player) sender;
		
        if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!sender.hasPermission("mUHC.Kick")) {
				sender.sendMessage(mUHC.Prefix + "You don't have permission to use this command.");
				return true;
				}
			
		if (args.length == 0) {
			player.sendMessage(mUHC.Prefix + "You've provided incorrect arguments. Use " + ChatColor.WHITE + "/kick [player] [reason]" + ChatColor.GRAY + ".");
			return true;
        	}
			
		Player target = Bukkit.getServer().getPlayer(args[0]);
		
        if (target == null) {
        	player.sendMessage(mUHC.Prefix + ChatColor.GREEN + args[0] + ChatColor.GRAY + " is not online.");
            return true;
            }
			
        if(args.length == 1){ 
        	target.kickPlayer(mUHC.Prefix + "You have been kicked by " + ChatColor.GREEN + sender.getName() + ChatColor.GRAY + "." + ChatColor.GRAY + "\n\nReason: " + ChatColor.RED + "-");
        	Bukkit.broadcastMessage(mUHC.Prefix + ChatColor.GREEN + sender.getName() + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " Kick" + ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + target.getName() + ChatColor.DARK_GRAY + " » " + ChatColor.RED + "-");
            return true;
            }
      
        String msg = "";
        	for (int i = 1; i < args.length; i++) {
        		msg = msg + args[i] + " ";
        		}
        		
        if (args.length > 1){
        	target.kickPlayer(mUHC.Prefix + "You have been kicked by " + ChatColor.GREEN + sender.getName() + ChatColor.GRAY + "." + ChatColor.GRAY + "\n\nReason: " + ChatColor.RED + msg);
        	Bukkit.broadcastMessage(mUHC.Prefix + ChatColor.GREEN + sender.getName() + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " Kick" + ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + target.getName() + ChatColor.DARK_GRAY + " » " + ChatColor.RED + msg);
            return true;
        		}
        
        	}
        
		return false;
		}
	
}