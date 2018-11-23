package tech.elitebyte.ftp.helpers;

import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * This is the config handler which handles all config.yml affiliated
 * functions in addition the the initializer which creates the config.
 *
 * TODO: Add a method of changing config from in-game as well as reload the config using cmds.
 *
 * @author EliteByte
 */
public class ConfigHandler {

    Plugin plugin;

    public ConfigHandler(Plugin plugin) {
        this.plugin = plugin;
    }


    /**
     * This is initializer for the config which essentially copy's the defaults which
     * is in the config.yml file within this plugin or it logs that a config file
     * was already created which in that case doesn't do anything.
     *
     */
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

    /**
     * Useful function used to fetch a value from the configuration file which is loaded by
     * the plugin, and settings changed by the server administrator.
     *
     * @param path The path which the config exists, example "Wanderer" path returns -> Integer
     * @return Object A generic object which can then be casted upon once retrieved
     * @exception NullPointerException If path to config object doesn't exist
     */
    public Object fetchCfgValue(String path) throws NullPointerException {
        Object value = plugin.getConfig().get(path);

        return value;
    }

}
