package tech.elitebyte.ftp;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tech.elitebyte.ftp.helpers.CommandHandler;
import tech.elitebyte.ftp.helpers.ConfigHandler;
import tech.elitebyte.ftp.helpers.EventHandler;
import tech.elitebyte.ftp.helpers.TimeHandler;


public final class FTP extends JavaPlugin {

    // Initialize Handlers
    private final ConfigHandler configHandler = new ConfigHandler(this);
    private final EventHandler eventHandler = new EventHandler(this);
    private final CommandHandler commandHandler = new CommandHandler(this);
    private final TimeHandler timeHandler = new TimeHandler();


    public final Logger logger = Logger.getLogger("Minecraft");
    public final PluginManager pm = getServer().getPluginManager();


    public static FTP plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // Initiate Config File
        configHandler.initiateConfig();

        ArrayList<LinkedHashMap<String, ArrayList>> arrayList = configHandler.fetchCfgTracks();


        logger.info("Value Thing: "+ arrayList.get(0).get("Citizenship").get(0));


        //logger.info(configHandler.fetchCfgTracks().toArray().toString());

        // Event Registration
        pm.registerEvents(eventHandler, this);

        logger.info("[FTP] Plugin successfully initialized.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TimeHandler getTimeHandler(){
        return timeHandler;
    }
    public ConfigHandler getConfigHandler() {
        return configHandler;
    }
    public PluginManager getPluginManager() {
        return pm;
    }
    public EventHandler getEventHandler() {
        return eventHandler;
    }


}
