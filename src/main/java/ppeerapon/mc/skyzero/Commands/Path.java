package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Path implements CommandExecutor {

    public static ArrayList<UUID> pathList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();

        if (!player.hasPermission("SkyZero.Path")) {
            player.sendMessage(ChatColor.RED + "You don't have permission !");
            return true;
        }

        if (!pathList.contains(uuid)) {
            pathList.add(uuid);
            player.sendMessage(ChatColor.GREEN + "Path have been enable");
        } else {
            pathList.remove(uuid);
            player.sendMessage(ChatColor.RED + "Path have been disable");
        }

        return true;
    }
}
