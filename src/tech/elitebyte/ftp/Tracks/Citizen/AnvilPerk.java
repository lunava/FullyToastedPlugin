package tech.elitebyte.ftp.Tracks.Citizen;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.elitebyte.ftp.FTP;
import tech.elitebyte.ftp.helpers.RankPerk;

import java.util.ArrayList;
import java.util.List;


public class AnvilPerk extends RankPerk {

    public AnvilPerk(String rank, Player p) {
        super(rank, p);
    }

    @Override
    public void usePerk() {

        List<Entity> nearbyE = getPlayer().getNearbyEntities(20, 20, 20);
        ArrayList<LivingEntity> livingE = new ArrayList<LivingEntity>();

        for (Entity e : nearbyE) {
            if (e instanceof LivingEntity) {
                if (e.getType() != EntityType.PLAYER) {
                    livingE.add((LivingEntity) e);
                }
            }
        }

        for (final LivingEntity e : livingE) {
            e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 18));
            final int x = e.getLocation().getBlockX();
            int y = e.getLocation().getBlockY();
            final int z = e.getLocation().getBlockZ();
            final int finalY = y + 15;
            final int preAnvil = y;

            Block block = e.getWorld().getBlockAt(x, y, z);
            World w = e.getWorld();

            do {
                y++;
                block = e.getWorld().getBlockAt(x, y, z);
            } while (checkBlock(x, y, z, w) && y != finalY);

            block = e.getWorld().getBlockAt(x, y - 1, z);
            block.setType(Material.ANVIL);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(FTP.plugin, new Runnable() {
                @Override
                public void run() {
                    Block newBlock = e.getWorld().getBlockAt(x, preAnvil, z);
                    newBlock.setType(Material.AIR);
                    newBlock = e.getWorld().getBlockAt(x, preAnvil + 1, z);
                    newBlock.setType(Material.AIR);
                }
            }, 40);
        }
    }

    @SuppressWarnings("deprecation")
    private boolean checkBlock(int x , int y , int z, World world) {
        Block block = world.getBlockAt(x,y,z);

        return block.getTypeId() == 0;
    }
}

