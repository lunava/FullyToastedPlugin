package tech.elitebyte.ftp.helpers;

import org.bukkit.entity.Player;
import tech.elitebyte.ftp.FTP;

public class RankPerk {

    private String rank;
    private double coolDownTime;
    public Player p;

    public RankPerk(String rank, Player p) {

        this.p = p;
    }

    public void usePerk() {
        FTP.plugin.getServer().broadcastMessage(p.getDisplayName());
    }

    public void storeCoolDown() {

    }

}
