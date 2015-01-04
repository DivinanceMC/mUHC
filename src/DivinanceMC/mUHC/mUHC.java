package DivinanceMC.mUHC;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import DivinanceMC.Configuration.FileManager;
import DivinanceMC.Listeners.Chat;
import DivinanceMC.Listeners.Join;
import DivinanceMC.Listeners.Leave;
import DivinanceMC.Listeners.Move;
import DivinanceMC.Listeners.UtilityListeners;
import DivinanceMC.Teams.Blue;
import DivinanceMC.Teams.Green;
import DivinanceMC.Teams.Red;
import DivinanceMC.Teams.Spectators;
import DivinanceMC.Teams.TeamHandler;
import DivinanceMC.Teams.Yellow;
import DivinanceMC.Utilities.GameState;

public class mUHC extends JavaPlugin implements Listener, CommandExecutor {
	
	public static String Prefix = ChatColor.GRAY + " | " + ChatColor.GOLD + "mUHC" + ChatColor.GRAY + " | " + ChatColor.DARK_GRAY + "» " + ChatColor.GRAY + "";
	
	private static List<TeamHandler> teams = new ArrayList<TeamHandler>();
	private static int ticks = 0;
	private static GameState state;
	
	public static File dataFolder = null;
	
    public static FileConfiguration config;
	
	public static int MAX_PLAYERS = 32;
	
	public static List<TeamHandler> getTeams() {
		return teams;
	}
	
	public static int getTicks() {
		return ticks;	
	}
	
	public static GameState getState() {
		return state;
	}
	
	public static void setState(GameState state) {
		mUHC.state = state;
	}
	
	public static TeamHandler getTeam(String name) {
		for (TeamHandler team : getTeams()) {
			if (team.getName().equalsIgnoreCase(name)) {
				return team;
			}
			
		}
		
		return null;
	}
	
	public static String getPlayerTeam(String name) {
        if (getListOfSpectators().contains(name)) {
            return "red";
        } else if (getListOfBlue().contains(name)) {
            return "blue";
        } else if (getListOfRed().contains(name)) {
            return "red";
        } else if (getListOfGreen().contains(name)) {
            return "green";
        } else if (getListOfYellow().contains(name)) {
            return "yellow";
        } else {
            return "none";
        }
        
    }



	
	public static TeamHandler getTeams(Player player) {
		for (TeamHandler team : getTeams()) {
			if(team.getMembers().contains(player.getName())) {
				return team;
			}
			
		}
		
		return null;
	}
	
	public static String getStars(Player player) {
        String stars = "";
        Ranks member = Ranks.getMember(player);
        if (Arrays.asList("XVenom17").contains(member.getName())) {
            stars += ChatColor.DARK_PURPLE + "✽";
        }
        if (member.isStaff()) {
            stars += ChatColor.GOLD + "✽";
        }
        return stars;
    }
	
	public static List<String> getListOfSpectators() {
        if (FileManager.readFile(new File(dataFolder, "Spectators.txt")).contains(":")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Spectators.txt")).split(":"));
        } else if (!FileManager.readFile(new File(dataFolder, "Spectators.txt")).equals("")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Spectators.txt")));
        } else {
            return Arrays.asList();
        }
    }

    public static void addToSpectators(String playerName) {
        File Spectators = new File(dataFolder, "Spectators.txt");
        if (!getListOfSpectators().contains(playerName)) {
            if (!FileManager.readFile(Spectators).equals("")) {
                FileManager.writeToFile(FileManager.readFile(Spectators) + ":" + playerName, Spectators);
            } else {
                FileManager.writeToFile(playerName, Spectators);
            }
            
        }
        
    }
    
    public static List<String> getListOfBlue() {
        if (FileManager.readFile(new File(dataFolder, "Blue.txt")).contains(":")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Blue.txt")).split(":"));
        } else if (!FileManager.readFile(new File(dataFolder, "Blue.txt")).equals("")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Blue.txt")));
        } else {
            return Arrays.asList();
        }
        
    }

    public static void addToBlue(String playerName) {
        File Blue = new File(dataFolder, "Blue.txt");
        if (!getListOfBlue().contains(playerName)) {
            if (!FileManager.readFile(Blue).equals("")) {
                FileManager.writeToFile(FileManager.readFile(Blue) + ":" + playerName, Blue);
            } else {
                FileManager.writeToFile(playerName, Blue);
            }
            
        }
        
    }
    
    public static List<String> getListOfRed() {
        if (FileManager.readFile(new File(dataFolder, "Red.txt")).contains(":")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Red.txt")).split(":"));
        } else if (!FileManager.readFile(new File(dataFolder, "Red.txt")).equals("")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Red.txt")));
        } else {
            return Arrays.asList();
        }
        
    }

    public static void addToRed(String playerName) {
        File Red = new File(dataFolder, "Red.txt");
        if (!getListOfRed().contains(playerName)) {
            if (!FileManager.readFile(Red).equals("")) {
                FileManager.writeToFile(FileManager.readFile(Red) + ":" + playerName, Red);
            } else {
                FileManager.writeToFile(playerName, Red);
            }
            
        }
        
    }
    
    public static List<String> getListOfGreen() {
        if (FileManager.readFile(new File(dataFolder, "Green.txt")).contains(":")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Green.txt")).split(":"));
        } else if (!FileManager.readFile(new File(dataFolder, "Green.txt")).equals("")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Green.txt")));
        } else {
            return Arrays.asList();
        }
        
    }

    public static void addToGreen(String playerName) {
        File Green = new File(dataFolder, "Green.txt");
        if (!getListOfGreen().contains(playerName)) {
            if (!FileManager.readFile(Green).equals("")) {
                FileManager.writeToFile(FileManager.readFile(Green) + ":" + playerName, Green);
            } else {
                FileManager.writeToFile(playerName, Green);
            }
            
        }
        
    }
    
    public static List<String> getListOfYellow() {
        if (FileManager.readFile(new File(dataFolder, "Yellow.txt")).contains(":")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Yellow.txt")).split(":"));
        } else if (!FileManager.readFile(new File(dataFolder, "Yellow.txt")).equals("")) {
            return Arrays.asList(FileManager.readFile(new File(dataFolder, "Yellow.txt")));
        } else {
            return Arrays.asList();
        }
        
    }

    public static void addToYellow(String playerName) {
        File Yellow = new File(dataFolder, "Yellow.txt");
        if (!getListOfYellow().contains(playerName)) {
            if (!FileManager.readFile(Yellow).equals("")) {
                FileManager.writeToFile(FileManager.readFile(Yellow) + ":" + playerName, Yellow);
            } else {
                FileManager.writeToFile(playerName, Yellow);
            }
            
        }
        
    }
    
    public static boolean isAssigned(String name) {
        File Spectators = new File(dataFolder, "Spectators.txt");
        File Blue = new File(dataFolder, "Blue.txt");
        File Red = new File(dataFolder, "Red.txt");
        File Green = new File(dataFolder, "Green.txt");
        File Yellow = new File(dataFolder, "Yellow.txt");
        if (getListOfSpectators().contains(name) || getListOfBlue().contains(name) || getListOfGreen().contains(name) || getListOfYellow().contains(name)) {
            return true;
        } else {
            return false;
        }
        
    }

    public static int getSpectators() {
        if (FileManager.readFile(new File(dataFolder, "Spectators.txt")).contains(":")) {
            return FileManager.readFile(new File(dataFolder, "Spectators.txt")).split(":").length;
        } else if (!FileManager.readFile(new File(dataFolder, "Spectators.txt")).equals("")) {
            return 1;
        } else {
            return 0;
        }
        
    }

    public static int getBlue() {
        if (FileManager.readFile(new File(dataFolder, "Blue.txt")).contains(":")) {
            return FileManager.readFile(new File(dataFolder, "Blue.txt")).split(":").length;
        } else if (!FileManager.readFile(new File(dataFolder, "Blue.txt")).equals("")) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
    public static int getRed() {
        if (FileManager.readFile(new File(dataFolder, "Red.txt")).contains(":")) {
            return FileManager.readFile(new File(dataFolder, "Red.txt")).split(":").length;
        } else if (!FileManager.readFile(new File(dataFolder, "Red.txt")).equals("")) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
    public static int getGreen() {
        if (FileManager.readFile(new File(dataFolder, "Green.txt")).contains(":")) {
            return FileManager.readFile(new File(dataFolder, "Green.txt")).split(":").length;
        } else if (!FileManager.readFile(new File(dataFolder, "Green.txt")).equals("")) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
    public static int getYellow() {
        if (FileManager.readFile(new File(dataFolder, "Yellow.txt")).contains(":")) {
            return FileManager.readFile(new File(dataFolder, "Yellow.txt")).split(":").length;
        } else if (!FileManager.readFile(new File(dataFolder, "Yellow.txt")).equals("")) {
            return 1;
        } else {
            return 0;
        }
        
    }
	
	public void onEnable() {	
        dataFolder = getDataFolder();
        config = getConfig();
        
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(new Join(null), this);
		getServer().getPluginManager().registerEvents(new Leave(), this);
		getServer().getPluginManager().registerEvents(new Move(), this);
		getServer().getPluginManager().registerEvents(new UtilityListeners(), this);
		
		this.getCommand("team").setExecutor(new DivinanceMC.Commands.Team());
		
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
			
		state=GameState.LOBBY;
		
		teams.add(new Blue());
		teams.add(new Red());
		teams.add(new Green());
		teams.add(new Yellow());
		
		teams.add(new Spectators());
	}
	
	public void onDisable() {
		/** 
		* Not Completed
		*/
	}
	
	public static List<Block> blocksBetweenPoints(Location l1, Location l2) {
		List<Block> blocks = new ArrayList<Block>();
		
		int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
		int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
		
		int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
		int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
		
		int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
		int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
		
		for (int x = bottomBlockX; x <= topBlockX; x++) {
			for (int y = bottomBlockY; y <= topBlockY; y++) {
				for (int z = bottomBlockZ; z <= topBlockZ; z++) {
					
					Block block = l1.getWorld().getBlockAt(x, y, z);
					blocks.add(block);
				}
			
			}
		
		}
		return blocks;
	
	}
	
}