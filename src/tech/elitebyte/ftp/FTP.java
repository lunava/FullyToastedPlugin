package tech.elitebyte.ftp;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tech.elitebyte.ftp.helpers.ConfigHandler;
import tech.elitebyte.ftp.helpers.TimeHandler;


public class FTP extends JavaPlugin implements Listener {

    // Initialize Handlers
    private final ConfigHandler configHandler = new ConfigHandler(this);
    private final TimeHandler timeHandler = new TimeHandler();

    public final Logger logger = Logger.getLogger("");
    public final PluginManager pm = getServer().getPluginManager();


    public static FTP plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // Initiate Config File
        configHandler.initiateConfig();

        // Event Registration
        pm.registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TimeHandler getTimeHandler(){
        return timeHandler;
    }
    public ConfigHandler getConfigHandler() { return configHandler; }
    public PluginManager getPluginManager() { return pm; }


}
