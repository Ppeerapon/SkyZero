package ppeerapon.mc.skyzero.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Text implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        TextComponent text = new TextComponent(" - This is a ");
        text.setColor(ChatColor.WHITE);

        TextComponent website = new TextComponent("Website");
        website.setColor(ChatColor.AQUA);
        website.setBold(true);
        website.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click This !").create()));
        website.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://ppeerapon.web.app/"));

        text.addExtra(website);

        player.spigot().sendMessage(text);

        return true;

    }
}
