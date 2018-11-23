package tech.elitebyte.ftp.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;


/**
 * This is the event handler which implements the Bukkit Listener Interface
 * Use this class to listen to any events which might action might be needed to take,
 * but note that every listener tacks on more checks that the server needs to run so keep
 * the method implementation as optimized as possible.
 *
 * @see Listener
 * @author EliteByte
 */
public class EventHandler implements Listener {

    private Plugin plugin;

    public EventHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * This is method will be used to handle a specific implementation of the FakeExplode Perk,
     * which is still in the works. But essentially makes it so that ever block that blows up
     * regenerates back to it's original state as well as whitelist only certain blocks of blowing up.
     *
     * The ExplosionHandler Class handles the regeneration process.
     *
     * @param e EntityExplodeEvent is the object passed through which contains information
     *          on the event such as blocks or entities affected.
     * @see ExplosionHandler
     */

    @SuppressWarnings("deprecation")
    @org.bukkit.event.EventHandler
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
        } e.setYield(0);
        ExplosionHandler explosionHandler = new ExplosionHandler(blocks);
        Bukkit.getScheduler().runTaskLater(plugin, explosionHandler, 150);
    }

}
