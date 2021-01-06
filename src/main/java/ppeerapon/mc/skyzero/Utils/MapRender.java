package ppeerapon.mc.skyzero.Utils;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MapRender extends MapRenderer {

    public static String url;

    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {
        if (url == null || url.equals("")) return;

        try {
            BufferedImage image = ImageIO.read(new URL(url));
            canvas.drawImage(0, 0, image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
