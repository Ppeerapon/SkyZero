package ppeerapon.mc.skyzero.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoard {

    public static void buildSideBar(Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("SkyZero", "dummy");
        obj.setDisplayName(ChatColor.AQUA + "SkyZero");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team mobCount = scoreboard.registerNewTeam("mob_count");
        mobCount.addEntry(ChatColor.GREEN.toString());
        mobCount.setPrefix("Mob: ");
        mobCount.setSuffix("");
        obj.getScore(ChatColor.GREEN.toString()).setScore(5);

        Score blank2 = obj.getScore(" ");
        blank2.setScore(4);

        Score rank = obj.getScore("Rank: " + ChatColor.GRAY + "Default");
        rank.setScore(3);

        Score blank = obj.getScore("");
        blank.setScore(2);

        Score webiste = obj.getScore(ChatColor.AQUA + "www.ppeerapon.web.app");
        webiste.setScore(1);

        player.setScoreboard(scoreboard);

    }

}
