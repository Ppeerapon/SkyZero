package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class JoinEvent implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        BossBar bossBar = Bukkit.createBossBar(ChatColor.AQUA + "" + ChatColor.BOLD + "Welcome To SkyZero", BarColor.BLUE, BarStyle.SOLID);
        bossBar.addPlayer(player);

        player.setResourcePack("https://www.planetminecraft.com/texture-pack/bare-bones/download/file/12142012/");

        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1);

    }

}
