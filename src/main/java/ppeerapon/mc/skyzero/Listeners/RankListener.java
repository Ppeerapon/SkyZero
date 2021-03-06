package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import ppeerapon.mc.skyzero.FileManager;
import ppeerapon.mc.skyzero.Rank;
import ppeerapon.mc.skyzero.SkyZero;

public class RankListener implements Listener {

    FileManager fileManager = SkyZero.getInstance().getFileManager();

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (fileManager.getRank(player) != null) player.sendMessage("You rank is : " + fileManager.getRank(player).toString());
        else {
            fileManager.setRank(player, Rank.GUEST);
            player.sendMessage("Welcome new player, You have get Guest Rank.");
        }

    }

    @EventHandler
    private void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        Rank rank = fileManager.getRank(player);

        e.setCancelled(true);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendMessage(rank.getChatColor() + rank.getName() + " " + player.getName() + " : " + ChatColor.WHITE + e.getMessage());
        }
    }

}
