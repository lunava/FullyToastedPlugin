package tech.elitebyte.ftp.helpers;

import org.bukkit.entity.Player;
import tech.elitebyte.ftp.FTP;

public abstract class RankPerk {

    private long coolDownTime;
    private String rank;
    private Player p;

    public RankPerk(String rank, Player p, long coolDownTime) {
        this.coolDownTime = coolDownTime;
        this.rank = rank;
        this.p = p;
    }

    public boolean tryUsingPerk() {
        if (isCooling()) {
            return false;
        }
        usePerk();
        return true;
    }

    public boolean isCooling() {
       return FTP.plugin.getTimeHandler().isPlayerCooling(p.getDisplayName(), rank);
    }

    public void storeCoolDown() {
        FTP.plugin.getTimeHandler().addPlayerCooldown(rank, p.getDisplayName(), coolDownTime);
    }

    public Player getPlayer() {
        return p;
    }

    public abstract void usePerk();
}
