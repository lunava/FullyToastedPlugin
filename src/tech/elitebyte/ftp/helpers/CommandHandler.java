package tech.elitebyte.ftp.helpers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tech.elitebyte.ftp.Tracks.Citizen.FakeExplodePerk;
import tech.elitebyte.ftp.Tracks.Citizen.WandererPerk;

public class CommandHandler implements CommandExecutor {

    private Plugin plugin;

    public CommandHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String commandSent = cmd.getName().toLowerCase();

        if (sender instanceof Player) {
            Player p = (Player) sender;

            switch (commandSent) {
                case "anvil":
                    WandererPerk perk = new WandererPerk("Wanderer", p);
                    perk.tryUsingPerk();
                    break;

                case "fireball":
                    WandererPerk perk2 = new WandererPerk("Dicks", p);
                    perk2.usePerk();
                    break;

                case "explode":
                    FakeExplodePerk perk3 = new FakeExplodePerk("Dicks", p);
                    perk3.usePerk();
                    break;

            }
            return true;
        } else {
            sender.sendMessage("[FTP] Command '" + commandSent + "' is a player-only command.");
        }

        return false;
    }
}
