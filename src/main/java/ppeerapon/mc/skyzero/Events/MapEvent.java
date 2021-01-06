package ppeerapon.mc.skyzero.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import ppeerapon.mc.skyzero.Utils.MapRender;

public class MapEvent implements Listener {

    @EventHandler
    private void onMap(MapInitializeEvent e) {

        MapView mapView = e.getMap();

        mapView.setUnlimitedTracking(true);
        mapView.getRenderers().clear();
        mapView.addRenderer(new MapRender());

    }

}
