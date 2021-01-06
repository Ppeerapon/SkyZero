package ppeerapon.mc.skyzero.Utils;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ppeerapon.mc.skyzero.SkyZero;

import java.lang.reflect.InvocationTargetException;

public class SitData {

    Plugin plugin = SkyZero.getPlugin(SkyZero.class);

    protected Player player;
    protected Block chair;

    private final ArmorStand stand;
    private final int task;

    public SitData(Player player, Block chair) {
        this.player = player;
        this.chair = chair;

        stand = chair.getWorld().spawn(chair.getLocation().add(0.5D, 0.3D, 0.5D), ArmorStand.class, (armorStand) -> {
            armorStand.setGravity(false);
            armorStand.setInvulnerable(true);
            armorStand.setVisible(false);
            armorStand.setMarker(true);
            armorStand.setCollidable(false);
            armorStand.setSmall(true);
            armorStand.addPassenger(player);
        });

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    Object obj = stand.getClass().getMethod("getHandle").invoke(stand);
                    obj.getClass().getField("yaw").set(obj, player.getLocation().getYaw());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }, 4, 4);

    }

    public void unSit() {
        Bukkit.getScheduler().cancelTask(task);
        player.leaveVehicle();
        stand.remove();
    }

}
