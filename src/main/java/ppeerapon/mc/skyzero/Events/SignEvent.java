package ppeerapon.mc.skyzero.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignEvent implements Listener {

    @EventHandler
    private void onEditSign(SignChangeEvent e) {
        Player player = e.getPlayer();

        for (int i = 0; i < 4; i++) {
            String line = e.getLine(i);
            assert line != null;
            e.setLine(i , ChatColor.translateAlternateColorCodes('&', line));
        }
        
        if (e.getLine(0).equalsIgnoreCase("SkyZero")) {
            e.setLine(0, ChatColor.AQUA + "SkyZero");
        }
        

    }

}
