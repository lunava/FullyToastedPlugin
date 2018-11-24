package tech.elitebyte.ftp;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tech.elitebyte.ftp.helpers.*;

import java.util.logging.Logger;

/**
 * The Fully Toasted Plugin (FTP) is custom built CraftBukkit-1.7.10
 * plugin that implements rank perks to a server customized using the
 * Jobs and PEX plugins.
 *
 * @author  EliteByte, ...
 * @version 1.0-ALPHA
 * @since   2018-11-11
 */
public final class FTP extends JavaPlugin {



    // Initialize FTP Handlers
    private final ConfigHandler configHandler = new ConfigHandler(this);
    private final EventHandler eventHandler = new EventHandler(this);
    private final CommandHandler commandHandler = new CommandHandler(this);
    private final TimeHandler timeHandler = new TimeHandler();

    // Initialize Bukkit Plugin Variables
    public final Logger logger = Logger.getLogger("Minecraft");
    public final PluginManager pm = getServer().getPluginManager();
    public static FTP plugin;


    /**
     * This is the main method which is initialized post forge-mod(s) load-in
     *
     * - Commands: Here you need to register commands by setting it's Executor Class to the
     * command Handler
     * - Events: Register any event listening class's (Classes that implement the Listener Interface)
     *
     * @author EliteByte
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // Initiate Config File
        configHandler.initiateConfig();

        // Event Registration
        pm.registerEvents(eventHandler, this);

        // Command Registration
        getCommand("wanderer").setExecutor(commandHandler);
        getCommand("bloodletter").setExecutor(commandHandler);
        getCommand("mage").setExecutor(commandHandler);
        getCommand("magus").setExecutor(commandHandler);
        getCommand("apprentice").setExecutor(commandHandler);
        getCommand("acolyte").setExecutor(commandHandler);
        getCommand("explode").setExecutor(commandHandler);

        logger.info("[FTP] The plugin has successfully initialized.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * This just returns the main plugin's instance of the TimeHandler,
     * to be created only once and referenced from the RankPerk 'interface'.
     * @return TimeHandler Private object created in the FTP variable header.
     * @see TimeHandler
     */
    public TimeHandler getTimeHandler(){
        return timeHandler;
    }

    /**
     * This just returns the main plugin's instance of the ConfigHandler,
     * to be created only once and referenced from FTP.
     * @return ConfigHandler Private object created in the FTP variable header.
     * @see ConfigHandler
     */
    public ConfigHandler getConfigHandler() {
        return configHandler;
    }

    /**
     * This just returns the main plugin's instance of the PluginManager,
     * which is a Bukkit interface that handles various plugin variables like event listeners.
     * @return PluginManager Object taken from the Server using getServer() method
     * @see PluginManager
     */
    public PluginManager getPluginManager() {
        return pm;
    }

    /**
     * This just returns the main plugin's instance of the EventHandler,
     * to be created only once and referenced from this.
     * @return EventHandler Private object created in the FTP variable header.
     * @see EventHandler
     */
    public EventHandler getEventHandler() {
        return eventHandler;
    }


}
