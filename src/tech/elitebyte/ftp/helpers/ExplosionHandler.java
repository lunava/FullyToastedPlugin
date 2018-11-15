package tech.elitebyte.ftp.helpers;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import tech.elitebyte.ftp.FTP;


public class ExplosionHandler extends BukkitRunnable implements Listener{

 
    List<BlockState> states;
 
    public ExplosionHandler(ArrayList<BlockState> blocks){
        states = blocks;
    }
 
    public ExplosionHandler(List<Block> blocks){
        states = new ArrayList<>();
        for(Block b : blocks){
            states.add(b.getState());
        }
    }
 
    @Override
    public void run() {
        regen();
    }
 
    public void regen(){
        for(final BlockState state : states){
            Bukkit.getScheduler().runTaskLater(FTP.plugin, new Runnable() {
 
                @Override
                public void run() {
                    state.update(true);
                }
            }, new Random().nextInt(10*20) + 20);
        }
    }



}