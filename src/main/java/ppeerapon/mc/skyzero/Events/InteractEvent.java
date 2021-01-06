package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    @EventHandler
    private void onRightClickAtEntity(PlayerInteractAtEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            e.getRightClicked().addPassenger(e.getPlayer());
        }
    }

    @EventHandler
    private void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        Location location = player.getLocation();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) { // FIRE BALL
            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HOE) {
                Fireball fireball = player.launchProjectile(Fireball.class, location.getDirection());
                for (int i = 0; i < 10; i++) {
                    fireball.addPassenger(player.getWorld().spawn(location, Zombie.class));
                }
            } else if (player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE) {
                Fireball fireball = player.launchProjectile(Fireball.class, location.getDirection());
                fireball.addPassenger(player.getWorld().spawn(location, IronGolem.class));
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().name().contains("SIGN")) {
            if (player.getUniqueId().toString().equals("ad895447-ea0f-4810-9c09-7d21a2dd1180")) {
                player.sendSignChange(e.getClickedBlock().getLocation(), new String[]{"SkyZeo", "This is a Test", "---------------", "By Ppeerapon"}, DyeColor.BLUE);
            }
        }

    }

}
