package tech.elitebyte.ftp.Tracks.Magic;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import tech.elitebyte.ftp.helpers.RankPerk;


public class MagePerk extends RankPerk{
    public MagePerk(String rank, Player p){
        super(rank, p);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean usePerk() {

//Working on projecting the particles
        Player p = getPlayer();
        Location playerLocation = p.getLocation();
        Vector vector = playerLocation.getDirection().normalize();
        double t = 0;
        t += 0.5;

        double x = vector.getX() * t ;
        double y = vector.getY() * t;
        double z = vector.getBlockZ() * t ;

        p.playEffect(playerLocation,Effect.FLAME, 200);
        p.getServer().broadcastMessage(ChatColor.GREEN + "You issue command: Fire!" );






        return true;
    }
}
