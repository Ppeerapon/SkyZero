package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class PlaceBlockListener implements Listener {

//    @EventHandler
//    public void onPlaceBlock(BlockPlaceEvent e) {
//        Player player = e.getPlayer();
//        Material material = e.getBlock().getType();
//        player.sendMessage("You have place : " + e.getBlock().getType().toString());
//        if (material.equals(Material.ARMOR_STAND)) {
//            ArmorStand armorStand = (ArmorStand) e.getBlock();
//            armorStand.setGravity(false);
//            player.sendMessage(ChatColor.AQUA + "GRAVITY OFF");
//        } else {
//            player.sendMessage(ChatColor.DARK_AQUA + "ELSE " + material.toString());
//        }
//    }

    @EventHandler
    private void onArmorStandPlace(EntitySpawnEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType().equals(EntityType.ARMOR_STAND)) {
            ArmorStand armorStand = (ArmorStand) e.getEntity();
            armorStand.setGravity(false);
        }
    }
}
