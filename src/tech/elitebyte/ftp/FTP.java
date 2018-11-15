package tech.elitebyte.ftp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tech.elitebyte.ftp.Tracks.Citizen.AnvilPerk;
import tech.elitebyte.ftp.Tracks.Citizen.FakeExplodePerk;
import tech.elitebyte.ftp.Tracks.Citizen.WandererPerk;
import tech.elitebyte.ftp.helpers.ExplosionHandler;
import tech.elitebyte.ftp.helpers.TimeHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

public final class FTP extends JavaPlugin implements Listener {

    public final Logger logger = Logger.getLogger("Minecraft");
    private final TimeHandler timeHandler = new TimeHandler();
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
            this.logger.info("[FTP] A config was already made :D");
        }

        plugin = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TimeHandler getTimeHandler(){
        return timeHandler;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String commandSent = cmd.getName().toLowerCase();

        if (sender instanceof Player) {
            Player p = (Player) sender;

            switch (commandSent) {
                case "anvil":
                    AnvilPerk perk = new AnvilPerk("Dicks", p);
                    perk.usePerk();
                    break;

                case "fireball":
                    WandererPerk perk2 = new WandererPerk("Dicks", p, 1000);
                    perk2.usePerk();
                    break;

                case "explode":
                    FakeExplodePerk perk3 = new FakeExplodePerk("Dicks", p);
                    perk3.usePerk();
                    break;

            }
            return true;
        }

        return false;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        ArrayList<Block> blocks = new ArrayList<>();
        ArrayList<Block> dontexplode = new ArrayList<>();
        for (Block b : e.blockList()) {
            if (b.getType() == Material.WOOL || b.getType() == Material.TORCH ||  b.getType() == Material.GRASS ||  b.getType() == Material.DIRT) {
                blocks.add(b);
            } else {
                dontexplode.add(b);
            }
        }
        for(Block b : dontexplode){
            e.blockList().remove(b);
            b.getState().update(true);
        }e.setYield(0);
        ExplosionHandler ge = new ExplosionHandler(blocks);
        Bukkit.getScheduler().runTaskLater(FTP.plugin, ge, 150);
    }

}
