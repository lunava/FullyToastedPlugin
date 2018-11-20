package tech.elitebyte.ftp.helpers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class TimeHandler {

    private Map<String, Set<Cooldown>> playerCoolDowns = new HashMap<>();

    public Map<String, Set<Cooldown>> getPlayerCoolDowns() {
        return playerCoolDowns;
    }

    public void addPlayerCooldown(String rankPerk, String playerName, long cooldownTime) {

        long currentTime = System.currentTimeMillis();
        Cooldown cooldown = new Cooldown(rankPerk, currentTime+cooldownTime);
        Set<Cooldown> playerCoolDowns = getPlayerCoolDowns().get(playerName);

        if (playerCoolDowns != null) {
            playerCoolDowns.add(cooldown);
            this.playerCoolDowns.put(playerName, playerCoolDowns);
        } else {
            Set<Cooldown> cooldowns = new LinkedHashSet<>();
            cooldowns.add(cooldown);
            this.playerCoolDowns.put(playerName, cooldowns);
        }
    }

    public long timeTilCool(String playerName, String rankPerk) {
        Set<Cooldown> cooldowns = playerCoolDowns.get(playerName);

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

