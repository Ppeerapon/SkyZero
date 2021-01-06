package ppeerapon.mc.skyzero.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Menu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ONLY PLAYER CAN USE THIS COMMAND !");
             return true;
        }

        Player player = (Player) sender;
        if (coolDown(player)) testGUI(player);


        return true;
    }

    public static Inventory gui;

    private void testGUI(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);

        gui = Bukkit.createInventory(null, 27, ChatColor.AQUA + "SkyZero GUI");

        ItemStack path;
        ItemStack overJump = new ItemStack(Material.NETHER_STAR);
        ItemMeta overJumpMeta = overJump.getItemMeta();
        ItemMeta pathMeta;

        List<String> overJumpLore = new ArrayList<>();
        overJumpLore.add("To Infinity...and Beyond !!!");
        overJumpLore.add(" สู่ความเวิ้งว้าง...อันไกลโพ้นนนนนนนน !!! ");

        List<String> pathEnableLore = new ArrayList<>();
        pathEnableLore.add("Click to make path of you walk");
        pathEnableLore.add("To Be A GOLD BLOCK !");
        List<String> pathDisableLore = new ArrayList<>();
        pathDisableLore.add("Click to back to default");
        pathDisableLore.add("Sometime Gold Block is not good !");

        if (!Path.pathList.contains(player.getUniqueId())) {
            path = new ItemStack(Material.GOLD_BLOCK);
            pathMeta = path.getItemMeta();
            pathMeta.setDisplayName(ChatColor.GOLD + "Enable Gold Path !");
            pathMeta.setLore(pathEnableLore);
        } else {
            path = new ItemStack(Material.GRASS_BLOCK);
            pathMeta = path.getItemMeta();
            pathMeta.setDisplayName(ChatColor.GREEN  + "Disable Gold Path !");
            pathMeta.setLore(pathDisableLore);
        }

        overJumpMeta.setDisplayName(ChatColor.AQUA + "IN TO THE SKY !");
        overJumpMeta.setLore(overJumpLore);
        overJump.setItemMeta(overJumpMeta);

        overJump.setItemMeta(overJumpMeta);
        path.setItemMeta(pathMeta);

        gui.setItem(13, path);
        gui.setItem(11 , overJump);

        player.openInventory(gui);


    }

    HashMap<UUID, Long> cooldown = new HashMap<>();

    private boolean coolDown(Player player) {
        UUID uuid = player.getUniqueId();
        if (cooldown.containsKey(uuid) && cooldown.get(uuid) > System.currentTimeMillis()) {
            long longRemaining = cooldown.get(uuid) - System.currentTimeMillis();
            int remainingTime = (int) longRemaining / 1000;
            player.sendMessage(ChatColor.RED + "You mute wait " + remainingTime + " seconds");
            return false;
        } else  {
            cooldown.put(uuid, System.currentTimeMillis() + (3 * 1000));
            return true;
        }
    }

}
