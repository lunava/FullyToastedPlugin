package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import tech.elitebyte.ftp.helpers.RankPerk;


public class FakeExplodePerk extends RankPerk implements Listener {


    public FakeExplodePerk(String rank, Player p) {
        super(rank, p);
    }

    @Override
    public void usePerk() {
        super.usePerk();

        final Player p = getPlayer();
        p.getWorld().createExplosion(p.getTargetBlock(null, 250).getX(), p.getTargetBlock(null, 250).getY() + 1, p.getTargetBlock(null, 250).getZ(), 2, false, true);

    }
}
