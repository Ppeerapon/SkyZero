package ppeerapon.mc.skyzero.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;
import java.util.UUID;

public class RandomEvent implements Listener {

    HashMap<UUID, Integer> cutTreeWarn = new HashMap<>();

    @EventHandler
    private void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (e.getBlock().getType().toString().contains("LOG")) {

            Block log = e.getBlock();
            addCutTreeWarn(player);
            checkBlock(log);

        }
    }

    private void checkBlock(Block block) {
        BlockFace[] blockFaces = BlockFace.values();
        for (BlockFace blockFace : blockFaces) {
            Block checkBlock = block.getRelative(blockFace);
            if (checkBlock.getType().equals(block.getType())) {
                block.breakNaturally();
                checkBlock(checkBlock);
                Bukkit.getPlayer("Ppeerapon").sendMessage("test3");
            }
        }

    }

    private void addCutTreeWarn(Player player) {
        UUID uuid = player.getUniqueId();
        if (cutTreeWarn.containsKey(uuid)) {
            if (cutTreeWarn.get(uuid) < 3 ) {
                cutTreeWarn.replace(uuid, cutTreeWarn.get(uuid) + 1);
                player.sendMessage("" + cutTreeWarn.get(uuid));
            } else {
                player.getWorld().createExplosion(player.getLocation(), 10);
                cutTreeWarn.remove(uuid);
                player.sendMessage(ChatColor.RED + "ต้นไม้ ไม่ถูกใจสิ่งนี้ !");
            }
        } else {
            cutTreeWarn.put(uuid, 1);
        }
    }

}
