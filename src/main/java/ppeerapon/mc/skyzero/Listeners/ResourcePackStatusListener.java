package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePackStatusListener implements Listener {

    @EventHandler
    private void packStatus (PlayerResourcePackStatusEvent e) {
        Player player = e.getPlayer();
        if (e.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
            player.sendMessage(ChatColor.AQUA + "We recommend you to use resource pack for the best experience");
        } else if (e.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
            player.sendMessage(ChatColor.RED + "Oop ! Fail to download");
            player.setResourcePack("https://www.planetminecraft.com/texture-pack/bare-bones/download/file/12142012/");
        } else if (e.getStatus() == PlayerResourcePackStatusEvent.Status.ACCEPTED) {
            player.sendMessage(ChatColor.AQUA + "Nice !");
        } else if (e.getStatus() == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {
            player.sendMessage(ChatColor.GREEN + "Successfully downloaded !");
        }
    }

}
