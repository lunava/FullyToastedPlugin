package tech.elitebyte.ftp.helpers;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

public class ConfigHandler {

    Plugin plugin;

    public ConfigHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    public void initiateConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!(configFile.exists())) {
            plugin.getLogger().info("[FTP] Config Created");
            plugin.getConfig().options().copyDefaults(true);
            plugin.saveDefaultConfig();
        } else {
            plugin.getLogger().info("[FTP] A config was already made.");
        }
    }

    public HashMap fetchCfgTracks() {
        HashMap arr = (HashMap) plugin.getConfig().get("Tracks", new HashMap<>());

        return arr;
    }

}
