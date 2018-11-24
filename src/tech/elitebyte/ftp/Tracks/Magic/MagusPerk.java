package tech.elitebyte.ftp.Tracks.Magic;
import org.bukkit.ChatColor;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import tech.elitebyte.ftp.helpers.RankPerk;


public class MagusPerk extends RankPerk{
    public MagusPerk(String rank, Player p){
        super(rank, p);
    }


    //Need to make sure that command happens multiple times
    @Override
    public boolean usePerk() {
        Player p = getPlayer();
        int uses;
        for(uses = 0; uses <= 15; uses++ ){
            p.launchProjectile(Fireball.class);
        }
        p.getServer().broadcastMessage(ChatColor.GREEN + "You issue command: Fire Charge!" );

        return true;
    }
}
