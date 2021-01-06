package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import ppeerapon.mc.skyzero.SkyZero;
import ppeerapon.mc.skyzero.Utils.ScoreBoard;

public class SideBarEvent implements Listener {

    Plugin plugin = SkyZero.getPlugin(SkyZero.class);

    int loop;

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        ScoreBoard.buildSideBar(player);

        updateScore(player);

    }

    @EventHandler
    private void onLeft (PlayerQuitEvent e) {
        Bukkit.getScheduler().cancelTask(loop);
    }

    private void updateScore(Player player) {
        loop = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                player.getScoreboard().getTeam("mob_count").setSuffix("" + getMobCount(player.getWorld()));
            }
        }, 0, 20);
    }

    private int getMobCount(World world) {
        return world.getEntities().size();
    }

}
