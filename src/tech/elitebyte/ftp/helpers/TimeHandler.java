package tech.elitebyte.ftp.helpers;

import java.util.*;

public class TimeHandler {

    private Map<String, Set<Cooldown>> playerCoolDowns = new HashMap<>();

    public Map<String, Set<Cooldown>> getPlayerCoolDowns() {
        return playerCoolDowns;
    }

    public void addPlayerCooldown(String playerName, String rankPerk, long cooldownTime) {

        long currentTime = System.currentTimeMillis();
        Cooldown cooldown = new Cooldown(rankPerk, currentTime+cooldownTime);
        Set<Cooldown> playerCoolDowns = getPlayerCoolDowns().get(playerName);

        if (playerCoolDowns != null) {
            playerCoolDowns.add(cooldown);
            this.playerCoolDowns.put(playerName, playerCoolDowns);
        } else {
            Set<Cooldown> cooldowns = new LinkedHashSet<>();
            this.playerCoolDowns.put(playerName, cooldowns);
        }
    }

    public boolean isPlayerCooling(String playerName, String rankPerk) {
        Set<Cooldown> cooldowns = playerCoolDowns.get(playerName);
        for (Cooldown cooldown : cooldowns) {
            if (cooldown.getRankPerk().equals(rankPerk)) {
                if (cooldown.hasCooled()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
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

    public boolean hasCooled() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - endTime > 0) {
            return true;
        }
        return false;
    }

}

