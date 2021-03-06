package ppeerapon.mc.skyzero.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class TargetListener implements Listener {

    EntityType[] badMob = {EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CREEPER, EntityType.PILLAGER, EntityType.EVOKER, EntityType.VINDICATOR, EntityType.RAVAGER,
                                EntityType.PHANTOM, EntityType.BLAZE, EntityType.GHAST};

    @EventHandler
    private void onTarget(EntityTargetEvent e) {
        Entity entity = e.getEntity();
        Entity target = e.getTarget();

        for (EntityType mobs : badMob) {
            if (entity.getType() == mobs) {
                Entity newTarget = null;
                for (Entity nearEntity : entity.getNearbyEntities(15, 15, 15)) {
                    for (EntityType mobs1 : badMob) {
                        if (nearEntity.getType() == mobs1 && nearEntity.getType() != entity.getType()) {
                            newTarget = nearEntity;
                            break;
                        }
                    }
                }
                if (newTarget == null) {
                    e.setCancelled(true);
                    return;
                }
                e.setTarget(newTarget);
            }
        }

    }

}
