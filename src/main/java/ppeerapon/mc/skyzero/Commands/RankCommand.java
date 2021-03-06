package ppeerapon.mc.skyzero.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.EnumUtils;
import org.bukkit.entity.Player;
import ppeerapon.mc.skyzero.FileManager;
import ppeerapon.mc.skyzero.Rank;
import ppeerapon.mc.skyzero.SkyZero;

public class RankCommand implements CommandExecutor {

    FileManager fileManager = SkyZero.getInstance().getFileManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (player.isOp()) {
            if (args.length == 2) {
                if (Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {
                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + target.getUniqueId().toString());
                    if (EnumUtils.isValidEnum(Rank.class, args[1].toUpperCase())) {
                        fileManager.setRank(target.getUniqueId(), Rank.valueOf(args[1].toUpperCase()));

                        player.sendMessage(ChatColor.AQUA + target.getName() + "'s rank has changed");

                        if (target.isOnline()) {
                            target.getPlayer().sendMessage(ChatColor.AQUA + player.getName() + " just changed you rank to " + args[1].toUpperCase());
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "The rank isn't exist !");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "No player data in this server");
                }
            } else {
                player.sendMessage(ChatColor.AQUA + "Usage: /rank <player> <rank>");
            }
        } else {
            player.sendMessage(ChatColor.RED + "You can't do that !");
        }

        return true;
    }

}
