package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Skull implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
            return true;
        }

        Player player = (Player) sender;
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        if (args.length >= 1 ) {
            if (args[0].equalsIgnoreCase("")) {

            }
        } else {
            meta.setOwningPlayer(player.getPlayer());
            skull.setItemMeta(meta);

            player.getInventory().addItem(skull);
        }

        return true;
    }
}
