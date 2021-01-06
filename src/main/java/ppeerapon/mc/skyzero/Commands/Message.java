package ppeerapon.mc.skyzero.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Message implements CommandExecutor {

    HashMap<UUID, UUID> recentlyMessaged = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            return true;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("Message") || label.equalsIgnoreCase("MSG")) {
            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);
                StringBuilder message = new StringBuilder();
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Can't get player !");
                    return true;
                }

                for (int i = 1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }

                sendMessage(player, target, message);
                recentlyMessaged.put(target.getUniqueId(), player.getUniqueId());

            } else player.sendMessage(ChatColor.RED + "Usage: /message <player> <message>");
        } else if (label.equalsIgnoreCase("reply")) {
            if (recentlyMessaged.get(player.getUniqueId()) != null) {
                if (args.length >= 1) {
                    Player target = Bukkit.getPlayer(recentlyMessaged.get(player.getUniqueId()));
                    if (target == null) {
                        player.sendMessage(ChatColor.RED + "Player offline !");
                        return true;
                    }

                    StringBuilder message = new StringBuilder();

                    for (String arg : args) {
                        message.append(arg).append(" ");
                    }
                    sendMessage(player, target, message);
                } else player.sendMessage("Usage: /reply <message>");

            } else player.sendMessage(ChatColor.RED + "You don't have recently message.");
        }

        return true;
    }

    private void sendMessage(Player player, Player target, StringBuilder message) {
        player.sendMessage(ChatColor.GREEN + "--> " + target.getName() + " : " + ChatColor.WHITE + message);
        target.sendMessage(ChatColor.AQUA + "<-- " + player.getName() + " : " + ChatColor.WHITE + message);
    }
}
