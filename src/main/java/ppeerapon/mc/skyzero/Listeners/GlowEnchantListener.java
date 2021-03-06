package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ppeerapon.mc.skyzero.SkyZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlowEnchantListener implements Listener {

    @EventHandler
    public void  onEntityDamage(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player)) return;

        Player player = (Player) e.getDamager();

        if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(SkyZero.glowEnchantment.getKey()))) {
            e.getEntity().setGlowing(true);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        ItemStack bow = new ItemStack(Material.IRON_SWORD);
        bow.addUnsafeEnchantment(SkyZero.glowEnchantment, 1);
        ItemMeta meta = bow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Glowing Sword");

        List<String> lore = new ArrayList<>();
        lore.add("- This is a free item");
        lore.add("- This bow can make target glowing");

        meta.setLore(Arrays.asList(ChatColor.GRAY + "Glow I"));

        bow.setItemMeta(meta);

        player.getInventory().addItem(bow);
    }

}
