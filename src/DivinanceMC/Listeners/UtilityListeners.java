package DivinanceMC.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;

import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class UtilityListeners implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}	
		
	}
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			event.setCancelled(true);
		}
		
	}
                    
	@EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        if (mUHC.getState() == GameState.LOBBY) {
        	event.setMotd(ChatColor.RED + "mUHC " + ChatColor.GRAY + "#1 " + ChatColor.BOLD + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + "Lobby" + ChatColor.DARK_GRAY + "\n» "+ ChatColor.YELLOW + "5:00 " + ChatColor.GRAY + "PM (EST) " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Hosted by " + ChatColor.DARK_PURPLE + "✽" + ChatColor.GOLD + "✽" + ChatColor.DARK_GRAY + "XVenom17");		
        }
        if (mUHC.getState() == GameState.STARTING) {
        	event.setMotd(ChatColor.RED + "mUHC " + ChatColor.GRAY + "#1 " + ChatColor.BOLD + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + "Starting" + ChatColor.DARK_GRAY + "\n» "+ ChatColor.YELLOW + "5:00 " + ChatColor.GRAY + "PM (EST) " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Hosted by " + ChatColor.DARK_PURPLE + "✽" + ChatColor.GOLD + "✽" + ChatColor.DARK_GRAY + "XVenom17");		
        }
        if (mUHC.getState() == GameState.NOPVP) {
        	event.setMotd(ChatColor.RED + "mUHC " + ChatColor.GRAY + "#1 " + ChatColor.BOLD + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + "In Progress" + ChatColor.DARK_GRAY + "\n» "+ ChatColor.YELLOW + "5:00 " + ChatColor.GRAY + "PM (EST) " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Hosted by " + ChatColor.DARK_PURPLE + "✽" + ChatColor.GOLD + "✽" + ChatColor.DARK_GRAY + "XVenom17");		
        }
        if (mUHC.getState() == GameState.INGAME) {
        	event.setMotd(ChatColor.RED + "mUHC " + ChatColor.GRAY + "#1 " + ChatColor.BOLD + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + "In Progress" + ChatColor.DARK_GRAY + "\n» "+ ChatColor.GOLD + "5:00 " + ChatColor.GRAY + "PM (EST) " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Hosted by " + ChatColor.DARK_PURPLE + "✽" + ChatColor.GOLD + "✽" + ChatColor.DARK_GRAY + "XVenom17");		
        }

    }
	
}