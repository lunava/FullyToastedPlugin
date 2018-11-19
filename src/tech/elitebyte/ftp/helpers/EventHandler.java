package tech.elitebyte.ftp.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import tech.elitebyte.ftp.FTP;

import java.util.ArrayList;

public class EventHandler implements Listener {

    private Plugin plugin;

    public EventHandler(Plugin plugin) {
        this.plugin = plugin;
    }

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
        Bukkit.getScheduler().runTaskLater(FTP.plugin, explosionHandler, 150);
    }

}
