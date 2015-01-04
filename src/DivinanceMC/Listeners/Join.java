package DivinanceMC.Listeners;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.spigotmc.ProtocolInjector;

import DivinanceMC.Exceptions.TeamException;
import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.Teams.TeamManager;
import DivinanceMC.Utilities.GameState;
import DivinanceMC.mUHC.mUHC;

public class Join implements Listener {
	private mUHC plugin;
	 
	public Join(mUHC plugin){
	this.plugin=plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String player1 = event.getPlayer().getName();
		Damageable damageable = (Damageable) player;
		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		int players = Bukkit.getOnlinePlayers().length;
		for (TeamHandler t : mUHC.getTeams()) {
			if (t.getMembers().contains(player.getName())) {
				t.getMembers().add(player.getName());
				
				mUHC.getPlayerTeam(player.getName());
				if (mUHC.getListOfSpectators().contains(player.getName()));
					event.setJoinMessage(mUHC.getStars(player) + ChatColor.DARK_GRAY + player.getName() + ChatColor.GRAY + " joined the server. " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");
				
					player.setHealth(damageable.getMaxHealth());
					player.setFoodLevel(20);
					player.setSaturation(8F);
					player.setLevel(0);
					player.setExp(0F);
					player.getInventory().clear();
					player.getInventory().setArmorContents(null);
					player.setGameMode(GameMode.ADVENTURE);
					player.setAllowFlight(true);
					player.hidePlayer(player);
				if (mUHC.getListOfBlue().contains(player.getName()));
				event.setJoinMessage(mUHC.getStars(player) + ChatColor.BLUE + player.getName() + ChatColor.GRAY + " joined the server. " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");
				if (mUHC.getListOfRed().contains(player.getName()));
				event.setJoinMessage(mUHC.getStars(player) + ChatColor.DARK_RED + player.getName() + ChatColor.GRAY + " joined the server. " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");
				if (mUHC.getListOfGreen().contains(player.getName()));
				event.setJoinMessage(mUHC.getStars(player) + ChatColor.DARK_GREEN + player.getName() + ChatColor.GRAY + " joined the server. " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");
				if (mUHC.getListOfYellow().contains(player.getName()));
				event.setJoinMessage(mUHC.getStars(player) + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + " joined the server. " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + players + ChatColor.DARK_GRAY + "/" + ChatColor.GOLD + mUHC.MAX_PLAYERS + ChatColor.DARK_GRAY + "]");			
			}
			
			player.sendMessage(mUHC.Prefix + "Welcome to " + ChatColor.GOLD + "mUHC" + ChatColor.GRAY + ".");
				IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: 'UHC   ', color: 'red'}],'color': 'gray', 'text': '   m'}");
				IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{text: '5:00 PM (EST)   ', color: 'gray'}],'color': 'dark_gray', 'text': '   » '}");	
	        		connection.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
					} 

				}
						
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		GameState state = mUHC.getState();
		if (!mUHC.isAssigned(player.getName())) 
			if (state!=GameState.STARTING);
			try {
				TeamManager.joinTeam(player, mUHC.getTeam("Spectators"));
			} catch (TeamException e) {
			mUHC.addToSpectators(player.getName());
		}
		if (player.hasPlayedBefore());
		mUHC.getPlayerTeam(player.getName());
			if (mUHC.getListOfSpectators().contains(player.getName()));
				mUHC.addToSpectators(player.getName());
			if (mUHC.getListOfBlue().contains(player.getName()));
				mUHC.addToBlue(player.getName());
			if (mUHC.getListOfRed().contains(player.getName()));
				mUHC.addToRed(player.getName());
			if (mUHC.getListOfGreen().contains(player.getName()));
				mUHC.addToGreen(player.getName());
			if (mUHC.getListOfYellow().contains(player.getName()));
				mUHC.addToYellow(player.getName());
				
			
	}
	
}