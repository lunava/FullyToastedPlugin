package tech.elitebyte.ftp.helpers;

public class Cooldown {

    private final double initTime, endTime;
    private final String rankPerk;

    public Cooldown(String rankPerk, double initTime, double endTime) {
        this.initTime = initTime;
        this.endTime = endTime;
        this.rankPerk = rankPerk;
    }

}
