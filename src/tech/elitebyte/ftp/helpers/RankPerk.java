package tech.elitebyte.ftp.helpers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tech.elitebyte.ftp.FTP;

public abstract class RankPerk {

    private long coolDownTime;
    private String rank;
    private Player p;

    public RankPerk(String rank, Player p) {
        this.coolDownTime = (long) (60000 * (int) FTP.plugin.getConfigHandler().fetchCfgValue(rank));
        this.rank = rank;
        this.p = p;
    }

    public abstract boolean usePerk();

    public boolean tryUsingPerk() {
        long timeTilCool = timeTilCool();

        if (timeTilCool <= 0) {
            if (usePerk()) {
                storeCoolDown();
                return true;
            }
        }
        FTP.plugin.getServer().broadcastMessage(ChatColor.WHITE + "" + ChatColor.BOLD
                 + "[FTP]" + ChatColor.RED + " Perk is still cooling... will be cooled in " + timeTilCool/60000 + " minutes.");
        return false;
    }

    public long timeTilCool() {
       return FTP.plugin.getTimeHandler().timeTilCool(p.getDisplayName(), rank);
    }

    public void storeCoolDown() {
        FTP.plugin.getTimeHandler().addPlayerCooldown(rank, p.getDisplayName(), coolDownTime);
    }

    public Player getPlayer() {
        return p;
    }


}
