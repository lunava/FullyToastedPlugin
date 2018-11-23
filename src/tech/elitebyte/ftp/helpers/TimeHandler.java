package tech.elitebyte.ftp.helpers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is the time handler which is meant to be used as a global object to
 * handle all cooldown related tasks for the RankPerks.
 *
 * @author EliteByte
 */
public class TimeHandler {

    // This variable stores all the player's current cooldowns in Cooldown objects.
    private Map<String, Set<Cooldown>> playerCooldowns = new HashMap<>();

    public Map<String, Set<Cooldown>> getPlayerCooldowns() {
        return playerCooldowns;
    }

    /**
     * Adds a RankPerk to a player's Set<Cooldown> which may or may not be created yet
     * So if it is add the Cooldown to the player's Set, if not add the Player and a new
     * Set to the playerCooldowns Map
     *
     * @param rankPerk The RankPerk in case-senitive string that matches the config.yml
     * @param playerName The player's name who used the RankPerk
     * @param cooldownTime The cool down time that the RankPerk has in milliseconds
     * @exception NullPointerException If the RankPerk doesn't exist in config.yml file
     * @see RankPerk
     * @see Cooldown
     */
    public void addPlayerCooldown(String rankPerk, String playerName, long cooldownTime) {

        long currentTime = System.currentTimeMillis();
        Cooldown cooldown = new Cooldown(rankPerk, currentTime+cooldownTime);
        Set<Cooldown> playerCooldowns = getPlayerCooldowns().get(playerName);

        if (playerCooldowns != null) {
            playerCooldowns.add(cooldown);
            this.playerCooldowns.put(playerName, playerCooldowns);
        } else {
            Set<Cooldown> cooldowns = new LinkedHashSet<>();
            cooldowns.add(cooldown);
            this.playerCooldowns.put(playerName, cooldowns);
        }
    }

    /**
     * Calculates the time that is left remaining until the player's RankPerk has
     * cooled.
     *
     * @param rankPerk The RankPerk in case-senitive string that matches the config.yml
     * @param playerName The player's name who used the RankPerk
     * @exception NullPointerException If the RankPerk doesn't exist in config.yml file
     * @see Cooldown
     */
    public long timeTilCool(String playerName, String rankPerk) {
        Set<Cooldown> cooldowns = playerCooldowns.get(playerName);

        if (cooldowns != null) {
            if (!cooldowns.isEmpty()) {
                for (Cooldown cooldown : cooldowns) {
                    if (cooldown.getRankPerk() == rankPerk) {
                        return cooldown.timeTilCool();
                    }
                }
            }
        }
        return 0;
        }

    // End of Class
}


class Cooldown {

    private final long endTime;
    private final String rankPerk;

    public Cooldown(String rankPerk, long endTime) {
        this.endTime = endTime;
        this.rankPerk = rankPerk;
    }

    public String getRankPerk() {
        return rankPerk;
    }

    public long timeTilCool() {
        return endTime - System.currentTimeMillis();
    }

}

