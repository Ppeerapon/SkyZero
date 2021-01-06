package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class PingEvent implements Listener {

    @EventHandler
    private void onServerPing(ServerListPingEvent e) {
        e.setMaxPlayers(2021);
        e.setMotd(ChatColor.AQUA  + "SkyZero NetWork" + ChatColor.WHITE + " [ 1.16.4 ]\n" + ChatColor.GREEN + "JOIN NOW !");
        try {
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
