package ppeerapon.mc.skyzero.Utils;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Chairs {

    private static final HashMap<UUID, SitData> sitting = new HashMap<>();

    public static void sit(Player player, Block block) {
        if (sitting.containsKey(player.getUniqueId())) {
            if (sitting.get(player.getUniqueId()).chair.equals(block)) {
                return;
            }
            unSit(player);
        }
        sitting.put(player.getUniqueId(), new SitData(player, block));
    }

    public static boolean isSitting(Player player) {
        return sitting.containsKey(player.getUniqueId());
    }

    public static void unSit(Player player) {
        sitting.get(player.getUniqueId()).unSit();
        sitting.remove(player.getUniqueId());
    }

    public static void unSit(Block block) {
        for (UUID uuid : sitting.keySet()) {
            SitData sitData = sitting.get(uuid);
            if (block.equals(sitData.chair)) {
                sitData.unSit();
                sitting.remove(uuid);
            }
        }
    }

    public static boolean isOccupied(Block block) {
        for (SitData data : sitting.values()) {
            if (data.chair.equals(block)) {
                return true;
            }
        }
        return false;
    }

}
