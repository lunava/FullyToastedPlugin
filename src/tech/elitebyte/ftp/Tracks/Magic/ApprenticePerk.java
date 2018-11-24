package tech.elitebyte.ftp.Tracks.Magic;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import tech.elitebyte.ftp.helpers.RankPerk;

public class ApprenticePerk extends RankPerk {
    public ApprenticePerk(String rank, Player p){
        super (rank,p );

    }


    public boolean usePerk() {
       Player p = getPlayer();

      Location playerLocation = p.getLocation();
      p.getWorld().createExplosion(playerLocation, 25);
      p.getServer().broadcastMessage(ChatColor.GREEN + "You issue command Mana Explosion!" );

        return true;
    }
}
