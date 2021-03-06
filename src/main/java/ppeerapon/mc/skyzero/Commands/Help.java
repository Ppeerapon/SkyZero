package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ppeerapon.mc.skyzero.SkyZero;

import java.util.ArrayList;


public class Help implements CommandExecutor {

    SkyZero skyZero;

    ArrayList<String> commands = new ArrayList<>();

    int perPage = 6;

    public Help(SkyZero skyZero) {
        this.skyZero = skyZero;
        getCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sendCommands(player, 1);
        } else if (args.length == 1) {
            int page;
            try {
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Page must be number !");
                return true;
            }
            if (page <= getTotalPages() && page >= 1) {
                sendCommands(player, page);
            } else {
                player.sendMessage(ChatColor.RED + "Page is out of bound");
                return true;
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /help <page>");
        }

        return true;
    }

    private void sendCommands(Player player, int page) {
        ArrayList<String> showCommands = new ArrayList<>();

        int displayPage = page;
        page = page - 1;
        int lowerBound = perPage * page;
        int upperBound = Math.min(lowerBound + perPage, commands.size());

        for (int i = lowerBound; i < upperBound; i++) {
            showCommands.add(commands.get(i));
        }

        player.sendMessage(ChatColor.DARK_AQUA + "Commands: [Page " + displayPage + "/" + getTotalPages() + "]") ;
        for (String cmd : showCommands) {
            player.sendMessage(ChatColor.AQUA + "- " + cmd);
        }

    }

    private int getTotalPages() {
        return (int) Math.ceil((double) commands.size() / perPage);
    }

    private void getCommand() {
        commands.add("Fly");
        commands.add("Hologram");
        commands.add("Kick");
        commands.add("Path");
        commands.add("Message");
        commands.add("Menu");
        commands.add("Skull");
        commands.add("Banner");
        commands.add("Map");
        commands.add("Book");
        commands.add("Help");
    }

}
