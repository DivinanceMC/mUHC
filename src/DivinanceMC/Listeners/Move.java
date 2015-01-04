package DivinanceMC.Listeners;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class Move implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location loc = event.getTo();
		Location spawn = player.getWorld().getSpawnLocation();
		
		if (mUHC.getState() == GameState.LOBBY || mUHC.getState() == GameState.STARTING) {
			if (spawn.distance(loc) > 20) {
				player.teleport(spawn);
				player.sendMessage(mUHC.Prefix + "You may not walk more than 20 blocks away from the spawn.");
			} else if (spawn.distance(loc) > 16) { 
				List<Block> blocks = mUHC.blocksBetweenPoints(player.getLocation().add(2, 2, 2),player.getLocation().subtract(2, 2, 2));
					for (Block block : blocks) {
						if (block.getType()!= Material.AIR)continue;
				}
					
			}
			
		}
		
	}
	
}