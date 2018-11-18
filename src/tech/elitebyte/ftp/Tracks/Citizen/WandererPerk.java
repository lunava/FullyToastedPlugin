package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import tech.elitebyte.ftp.helpers.RankPerk;

public class WandererPerk extends RankPerk {

    public WandererPerk(String rank, Player p, long coolDownTime) {
        super(rank, p, coolDownTime);
    }


    public void usePerk() {
        Player p = getPlayer();

        final Vector direction = p.getEyeLocation().getDirection();
        p.getWorld().spawn(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Fireball.class);
    }

}
