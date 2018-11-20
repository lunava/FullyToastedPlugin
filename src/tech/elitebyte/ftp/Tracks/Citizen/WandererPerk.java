package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tech.elitebyte.ftp.helpers.RankPerk;

public class WandererPerk extends RankPerk {

    public WandererPerk(String rank, Player p) {
        super(rank, p);
    }


    public boolean usePerk() {
        Player p = getPlayer();

        ItemStack itemStack = new ItemStack(Material.FIREWORK);
        itemStack.setAmount(16);
        p.getInventory().addItem(itemStack);
        return true;
    }

}
