package tech.elitebyte.ftp.helpers;

import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigHandler {

    Plugin plugin;

    public ConfigHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    public void initiateConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!(configFile.exists())) {
            plugin.getLogger().info("[FTP] Loading config.yml file.");
            plugin.getConfig().options().copyDefaults(true);
            plugin.saveDefaultConfig();
        } else {
            plugin.getLogger().info("[FTP] A config was already made.");
        }
    }

    public Object fetchCfgValue(String path) {
        Object value = plugin.getConfig().get(path);

        return value;
    }

}
