package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.util.Vector;
import ppeerapon.mc.skyzero.Commands.Menu;
import ppeerapon.mc.skyzero.Commands.Path;

import java.util.Objects;

public class MenuListener implements Listener {

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (Objects.equals(e.getClickedInventory(), Menu.gui)) {

            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);

                switch (e.getCurrentItem().getType()) {
                    case GOLD_BLOCK:
                        Path.pathList.add(player.getUniqueId());
                        break;
                    case GRASS_BLOCK:
                        Path.pathList.remove(player.getUniqueId());
                        break;
                    case NETHER_STAR:
                        player.setVelocity(new Vector(0, 200, 0));
                        break;
                    default:
                }
                player.closeInventory();
            }
        }
    }

}
