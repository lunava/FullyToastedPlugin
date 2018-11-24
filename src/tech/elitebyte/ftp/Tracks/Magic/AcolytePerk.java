package tech.elitebyte.ftp.Tracks.Magic;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.elitebyte.ftp.helpers.RankPerk;


public class AcolytePerk extends RankPerk {
    public AcolytePerk (String rank, Player p){
        super (rank,p);

    }
    public boolean usePerk() {

        //Duration is in ticks, 200 ticks = 10 seconds

        Player p = getPlayer();
        p.addPotionEffect( new PotionEffect(PotionEffectType.CONFUSION, 200 ,1), true);
        p.addPotionEffect( new PotionEffect(PotionEffectType.REGENERATION, 200, 1) ,true);
        p.getServer().broadcastMessage(ChatColor.GREEN + "You issue command: Heal!" );



        return true;
    }
}
