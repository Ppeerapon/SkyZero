package ppeerapon.mc.skyzero.Listeners;

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
import ppeerapon.mc.skyzero.SkyZero;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JoinListener implements Listener {


    SkyZero skyZero;
    public JoinListener(SkyZero skyZero) {
        this.skyZero = skyZero;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        BossBar bossBar = Bukkit.createBossBar(ChatColor.AQUA + "" + ChatColor.BOLD + "Welcome To SkyZero", BarColor.BLUE, BarStyle.SOLID);
        bossBar.addPlayer(player);

        player.setResourcePack("https://www.planetminecraft.com/texture-pack/bare-bones/download/file/12142012/");

        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1);


        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
        skyZero.getConfig().set(player.getName() +  ".LastedJoin", time.format(dtf));
        skyZero.saveFile();

        player.playSound(player.getLocation(), "custom.welcome", 1, 1);
    }

}
