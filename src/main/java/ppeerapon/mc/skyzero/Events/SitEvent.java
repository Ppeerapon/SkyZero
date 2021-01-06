package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.spigotmc.event.entity.EntityDismountEvent;
import ppeerapon.mc.skyzero.SkyZero;
import ppeerapon.mc.skyzero.Utils.Chairs;

public class SitEvent implements Listener {

    Plugin plugin = SkyZero.getPlugin(SkyZero.class);

    @EventHandler
    private void onPlayerRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().name().contains("STAIRS") && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            Block chair = e.getClickedBlock();
            if (!Chairs.isOccupied(chair)) {
                Chairs.sit(player, chair);
            }
        }
    }

    @EventHandler
    private void onEntityDismount(EntityDismountEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        Player player = (Player) e.getEntity();
        if (Chairs.isSitting(player)) {
            Chairs.unSit(player);
        }
    }

    @EventHandler
    private void onPlayerTeleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();
        if (Chairs.isSitting(player)) {
            Chairs.unSit(player);
        }
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {
        if (Chairs.isOccupied(e.getBlock())) {
            Chairs.unSit(e.getBlock());
        }
    }

}
