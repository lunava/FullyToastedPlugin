package tech.elitebyte.ftp.helpers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tech.elitebyte.ftp.Tracks.Citizen.WandererPerk;
import tech.elitebyte.ftp.Tracks.Magic.AcolytePerk;
import tech.elitebyte.ftp.Tracks.Magic.ApprenticePerk;
import tech.elitebyte.ftp.Tracks.Magic.MagePerk;
import tech.elitebyte.ftp.Tracks.Magic.MagusPerk;
//import tech.elitebyte.ftp.Tracks.Magic.BloodLetter;


/**
 * This is the command handler which implements the Bukkit Command Executor Interface
 * @see CommandExecutor
 * @author EliteByte
 */
public class CommandHandler implements CommandExecutor {

    private Plugin plugin;

    public CommandHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * The onCommand Method is the main method to a command executor so anything which is registered
     * inside the FTP onEnable method under the command registration section.
     *
     * To add a new command:
     * - Add it to the plugin.yml file
     * - Add a case statement for it
     * - Register it in the FTP onEnable method
     *
     * @param sender CommandSender Obj of the person/command block/console that sent the cmd.
     * @param args String[] of arguments made in the command.
     * @param cmd Command obj that contains various attributes
     * @param label Label of the command sent
     * @return boolean True if command sent succeeds, false if it fails.
     * @see Command
     * @see CommandSender
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Get the commandSent as lowercase
        String commandSent = cmd.getName().toLowerCase();

        if (sender instanceof Player) {
            Player p = (Player) sender;

            switch (commandSent) {
                case "wanderer":
                    WandererPerk perk = new WandererPerk("Wanderer", p);
                    perk.tryUsingPerk();
                    break;

//                case "bloodletter":
//                    BloodLetter bloodLetterPerk = new BloodLetter("BloodLetter", p, 1, 100);
//                    bloodLetterPerk.tryUsingPerk();
//                    break;

                case "acolyte":
                    AcolytePerk acolytePerk = new AcolytePerk("Acolyte", p);
                    acolytePerk.tryUsingPerk();
                    break;
                case "apprentice":
                    ApprenticePerk apprenticePerk = new ApprenticePerk("Apprentice", p);
                    apprenticePerk.tryUsingPerk();
                    break;
                case "mage":
                    MagePerk magePerk = new MagePerk("Mage", p);
                    magePerk.tryUsingPerk();
                    break;
                case "magus":
                    MagusPerk magusPerk = new MagusPerk("Magus", p);
                    magusPerk.tryUsingPerk();
                    break;

            }
            return true;
        } else {
            sender.sendMessage("[FTP] Command '" + commandSent + "' is a player-only command.");
        }

        return false;
    }
}
