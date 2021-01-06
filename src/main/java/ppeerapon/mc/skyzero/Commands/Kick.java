package ppeerapon.mc.skyzero.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (args.length == 1) {

           Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatColor.RED + "Can't get player");
                return true;
            }

            target.kickPlayer(ChatColor.RED + " You have been kicked");

        } else return false;

        return true;
    }
}
