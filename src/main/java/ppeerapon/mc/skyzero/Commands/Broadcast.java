package ppeerapon.mc.skyzero.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ppeerapon.mc.skyzero.Events.ServerBroadcastEvent;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }

        String message = stringBuilder.toString();

        ServerBroadcastEvent event = new ServerBroadcastEvent(player, message);
        Bukkit.getPluginManager().callEvent(event);

        if (!event.isCancelled()) Bukkit.broadcastMessage(message);


        return true;
    }
}
