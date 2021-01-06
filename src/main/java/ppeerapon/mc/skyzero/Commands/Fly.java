package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            System.out.println("Test");
            return true;
        }

        Player player = (Player) sender;
        boolean allowFlight = player.getAllowFlight();
        if (player.hasPermission("SkyZero.Fly")) {
            if (allowFlight) player.sendMessage(ChatColor.RED + "FlyMode is disable !");
            else player.sendMessage(ChatColor.GREEN + "FlyMode is enable !");
            player.setAllowFlight(!allowFlight);
            player.setFlying(!allowFlight);
        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission !");
        }

        return true;
    }
}
