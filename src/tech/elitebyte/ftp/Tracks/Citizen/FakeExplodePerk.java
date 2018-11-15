package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import tech.elitebyte.ftp.FTP;
import tech.elitebyte.ftp.helpers.ExplosionHandler;
import tech.elitebyte.ftp.helpers.RankPerk;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;


public class FakeExplodePerk extends RankPerk implements Listener {


    public FakeExplodePerk(String rank, Player p) {
        super(rank, p);
    }

    @Override
    public void usePerk() {
        super.usePerk();

        p.getWorld().createExplosion(p.getTargetBlock(null, 250).getX(), p.getTargetBlock(null, 250).getY() + 1, p.getTargetBlock(null, 250).getZ(), 2, false, true);

    }
}
