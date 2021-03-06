package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import ppeerapon.mc.skyzero.Utils.GUI;

public class GUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        Inventory inv = e.getInventory();
        InventoryView view = e.getView();
        if (view.getTitle().contains("GUI Page - ")) {
            int page = Integer.parseInt(inv.getItem(0).getItemMeta().getLocalizedName());
            if (e.getRawSlot() == 0  && item.getType().equals(Material.GREEN_STAINED_GLASS_PANE)) {
                new GUI(player, page - 1);
            } else if (e.getRawSlot() == 8 && item.getType().equals(Material.GREEN_STAINED_GLASS_PANE)) {
                new GUI(player, page + 1);
            }

            e.setCancelled(true);
        }

    }

}
