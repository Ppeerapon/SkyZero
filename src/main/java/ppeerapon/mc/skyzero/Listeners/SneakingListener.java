package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakingListener implements Listener {

    @EventHandler
    private void onPlayerSneak(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if (player.getTargetBlockExact(5) != null) {
            //player.sendBlockChange(player.getTargetBlockExact(5).getLocation(), Material.LAVA.createBlockData());
            player.sendMessage("TEst");
        }

    }

}
