package tech.elitebyte.ftp.Tracks.Magic;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
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
        Location playerEyeLocation = p.getEyeLocation();
        p.playEffect(playerEyeLocation,Effect.ENDER_SIGNAL, 200);

        p.getServer().broadcastMessage(ChatColor.GREEN + "You issue command: Fire!" );





        return true;
    }
}
