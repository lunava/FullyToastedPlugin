package tech.elitebyte.ftp.helpers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tech.elitebyte.ftp.FTP;

/**
 * This is the RankPerk 'interface' which is technically not a interface but
 * an abstract class which allows for must-implement methods but also some of
 * the versatility of a regular class.
 *
 * Perk Creation:
 * - Extend this class
 * - Create a constructor and run super()
 * - Implement usePerk() function which is
 * where the logic goes to your perk's func.
 *
 * @author EliteByte
 */
public abstract class RankPerk {

    // Local Variables
    private long coolDownTime;
    private String rank;
    private Player p;

    public RankPerk(String rank, Player p) {
        this.coolDownTime = (long) (60000 * (int) FTP.plugin.getConfigHandler().fetchCfgValue(rank));
        this.rank = rank;
        this.p = p;
    }


    /**
     * Forced to implement this method which is triggered after a successful
     * tryUsingPerk checking.
     *
     * @return boolean True if the perk succeed's and False if it fails.
     */
    public abstract boolean usePerk();


    /**
     * This method 'tries' to use a triggered perk by first checking it's cooldown
     * and then next checking if usePerk() returns true which is true store's the rank's
     * cool down in the TimeHandler object in the FTP Instance.
     *
     * @return boolean True if the perk succeed's and False if it fails.
     */
    public boolean tryUsingPerk() {
        long timeTilCool = timeTilCool();

        if (timeTilCool <= 0) {
            if (usePerk()) {
                storeCoolDown();
                return true;
            }
            else {

            }
        }
        p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD
                 + "[FTP]" + ChatColor.RED + " Perk is still cooling... will be cooled in " + timeTilCool/60000 + " minutes.");
        return false;
    }


    public long timeTilCool() {
       return FTP.plugin.getTimeHandler().timeTilCool(p.getDisplayName(), rank);
    }

    private void storeCoolDown() {
        FTP.plugin.getTimeHandler().addPlayerCooldown(rank, p.getDisplayName(), coolDownTime);
    }

    public Player getPlayer() {
        return p;
    }


}
