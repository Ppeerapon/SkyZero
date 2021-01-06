package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class Hologram implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            return false;
        }

        Player player = (Player) sender;

        if (args.length >= 1) {

            String text = "";

            for (int i = 0; i < args.length; i++) {
                text += args[i] + " ";
            }

            Location location = player.getLocation();
            location.setY(location.getY() - 1);

            ArmorStand armorStand = player.getWorld().spawn(location, ArmorStand.class);
            armorStand.setSmall(true);
            armorStand.setGravity(false);
            armorStand.setCustomName(text);
            armorStand.setVisible(false);
            armorStand.setCustomNameVisible(true);
            player.sendMessage(text);

        } else player.sendMessage(ChatColor.RED + "NO ARGS !");

        return true;
    }
}
