package tech.elitebyte.ftp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tech.elitebyte.ftp.Tracks.Citizen.WandererPerk;

import java.io.File;
import java.util.logging.Logger;

public final class FTP extends JavaPlugin {

    public final Logger logger = Logger.getLogger("Minecraft");
    public static FTP plugin;



    @Override
    public void onEnable() {
        // Plugin startup logic

        // Create Config File
        File configFile = new File(this.getDataFolder(), "config.yml");
        if (!(configFile.exists())) {
            this.logger.info("[FTP] Config Created");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        } else {
            this.logger.info("[FTP] A config was already made :)");
        }

        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String commandSent = cmd.getName().toLowerCase();

        if (sender instanceof Player) {
            Player p = (Player) sender;

            switch (commandSent) {
                case "dick":


                    WandererPerk perk = new WandererPerk("Dicks", p);
                    perk.usePerk();

                    break;

            }
            return true;
        }

        return false;
    }

}
