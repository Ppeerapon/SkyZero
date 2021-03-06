package ppeerapon.mc.skyzero.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle("Welcome " + player.getName());
        meta.setAuthor("SkyZero");
        meta.addPage(ChatColor.BLUE + "Hello " + player.getName() + ",\n\nYou are in SkyZero Network.\n\nThis is high quality server.\n\nHave Fun !") ;
        book.setItemMeta(meta);

        player.getInventory().addItem(book);

        return true;
    }
}
