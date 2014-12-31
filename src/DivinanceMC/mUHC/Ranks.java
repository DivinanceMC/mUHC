package DivinanceMC.mUHC;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Ranks {
	
    private Player player;
    
    public static List<Ranks> members = new ArrayList<Ranks>();

    public Ranks(Player player) {
        this.player = player;
        	if (!members.contains(this)) {
        		members.add(this);
        }
        	
    }

    public void remove() {
        while (members.contains(this)) {
            members.remove(this);
        }
        this.player = null;
    }

    public boolean isStaff() {
        return player.hasPermission("mUHC.Staff");
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return getPlayer().getName();
    }

    public static Ranks getMember(Player player) {
        Ranks toReturn = null;
        for (Ranks each : members) {
            if (each.getPlayer().equals(player)) {
                toReturn = each;
            }
            
        }
        if (toReturn == null) {
            toReturn = new Ranks(player);
        }
        return toReturn;
    }
    
}