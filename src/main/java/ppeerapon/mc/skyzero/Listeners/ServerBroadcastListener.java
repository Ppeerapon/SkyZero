package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ppeerapon.mc.skyzero.Events.ServerBroadcastEvent;

public class ServerBroadcastListener implements Listener {

    @EventHandler
    private void onBroadcast(ServerBroadcastEvent e) {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Event Activate");

        e.setCancelled(true);

    }

}
