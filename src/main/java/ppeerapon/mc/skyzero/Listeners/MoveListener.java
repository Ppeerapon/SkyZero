package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import ppeerapon.mc.skyzero.Commands.Path;
import ppeerapon.mc.skyzero.SkyZero;
import ppeerapon.mc.skyzero.Utils.Cuboid;

import java.util.ArrayList;
import java.util.UUID;

public class MoveListener implements Listener {

    Plugin plugin = SkyZero.getPlugin(SkyZero.class);

    ArrayList<Block> blocks = new ArrayList<>();

    @EventHandler
    private void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Location location = e.getFrom();
        Block block = location.add(0, -1, 0).getBlock();
        Material material = block.getType();

        if (Path.pathList.contains(uuid)) {

            if (material.isAir()) return;

            if (!blocks.contains(block)) {

                blocks.add(block);
                block.setType(Material.GOLD_BLOCK);

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(material);
                        blocks.remove(block);
                    }
                }, 20);
            }
        }
    }

    Cuboid cuboid = new Cuboid(new Location(Bukkit.getWorld("world"), -236, 62, 27), new Location(Bukkit.getWorld("world"), -228, 66, 19));
    @EventHandler
    private void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        player.setGlowing(cuboid.containsLocation(player.getLocation()));

    }

}
