package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ppeerapon.mc.skyzero.Utils.MapRender;

public class Map  implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            MapRender.url = args[0];
            player.sendMessage(ChatColor.GREEN + "Map image set !");
        }

        return true;

    }
}
