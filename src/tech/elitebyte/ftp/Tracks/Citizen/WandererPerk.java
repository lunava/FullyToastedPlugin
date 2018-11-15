package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import tech.elitebyte.ftp.helpers.RankPerk;

public class WandererPerk extends RankPerk {



    public WandererPerk(String rank, Player p) {
        super(rank, p);
    }

    @Override
    public void usePerk() {
        super.usePerk();

        final Vector direction = p.getEyeLocation().getDirection().multiply(3);
        p.getWorld().spawn(p.getEyeLocation().add(direction.getX(),direction.getY(),direction.getZ()), Fireball.class);
    }
}
