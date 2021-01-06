package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import ppeerapon.mc.skyzero.SkyZero;

public class DamageEvent implements Listener {

    Plugin pLugin = SkyZero.getPlugin(SkyZero.class);

    @EventHandler
    private void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;

        Player player = (Player) e.getDamager();
        Entity entity = e.getEntity();
        Double damage = e.getDamage();

        if (entity.getType() == EntityType.ARMOR_STAND) return;

        Location location = entity.getLocation();

        ArmorStand armorStand = entity.getWorld().spawn(location, ArmorStand.class);
        armorStand.setSmall(true);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setCustomName(ChatColor.RED + "- " + damage);
        armorStand.setCustomNameVisible(true);
        armorStand.setBasePlate(false);

        Bukkit.getScheduler().scheduleSyncDelayedTask(pLugin, new Runnable() {
            @Override
            public void run() {
                armorStand.remove();
            }
        },20);
    }

}
