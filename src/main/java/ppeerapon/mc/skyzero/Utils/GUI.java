package ppeerapon.mc.skyzero.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    public GUI(Player player, int page) {
        Inventory gui = Bukkit.createInventory(null, 54, "GUI Page - " + page);

        List<ItemStack> allItems= new ArrayList<>();
        for (int i = 0; i < 135; i++) {
            allItems.add(new ItemStack(Material.ENDER_PEARL));
        }

        ItemStack left;
        ItemMeta leftMeta;
        if (Page.isPageValid(allItems, page - 1, 52)) {
            left = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.GREEN + "GO PAGE LEFT !");
        } else {
            left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.RED + "NO PAGE AVAILABLE");
        }
        leftMeta.setLocalizedName("" + page);
        left.setItemMeta(leftMeta);

        gui.setItem(0, left);

        ItemStack right;
        ItemMeta rightMeta;
        if (Page.isPageValid(allItems, page + 1, 52)) {
            right = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.GREEN + "GO PAGE RIGHT !");
        } else {
            right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.RED + "NO PAGE AVAILABLE");
        }
        right.setItemMeta(rightMeta);

        gui.setItem(8, right);

        for (ItemStack items : Page.getPageItems(allItems, page, 52)) {
            gui.setItem(gui.firstEmpty(), items);
        }
        
        player.openInventory(gui);
    }

}
