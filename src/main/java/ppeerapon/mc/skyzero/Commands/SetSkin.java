package ppeerapon.mc.skyzero.Commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SetSkin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        EntityPlayer ep = ((CraftPlayer) player).getHandle();
        GameProfile gp = ep.getProfile();
        PropertyMap pm = gp.getProperties();
        Property property= pm.get("textures").iterator().next();
        pm.remove("textures", property);
        pm.put("textures", new Property("textures",
                "ewogICJ0aW1lc3RhbXAiIDogMTYxMDgwOTk2MTU2NSwKICAicHJvZmlsZUlkIiA6ICI4ZTE3NmM1YWMyNmQ0YzE0OGVmZTc3YjU5OGI4YjNlYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJTa2VwcHkiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWI0OWVhYmQ2YWJlMmMxYzNkOTE5YzI1NTMxNDExMmJiNGZjY2VkZWFmNTEzMTNjZmFmNmQxZWQyYTk4MDE2NSIKICAgIH0KICB9Cn0=",
                "t1VSceN478zG3uo2PLndcDVG5om7HKu2RqhmVbr8nDtjmkDYEPTl0H2fTcZgG/5YDywQiiJ4/3V/BSVn1bBYX59YOeH7CkjbDyC7wxoiW6fjyYwDWIuJBaW8HD0STIZLjKCe0M4LQDE2aYx2ZAUtTba2IxpHARV080SwL+B6DEHg7DxDPCUa/KcuUquSU42qLp6AJsLXoNNWfp/zLipHMByRMNfyGszQ79DWc0E7gKFtrqKs3aekVdF1OIUa+fwdTN3j793Y2KDZ6traDZDi1iFqkVWT+uo/f3FsoFcmGrSYIlKkyegY2mc4oQdJ+SOUAKdLfBEtkoDetZIaDJRIpBnq1I4GVLfDy442M5STajHCtWtdfBy6LPW2kI3hNtrtpwrEZJ1Kr4wEQzaGgnWnCUxXqCDjRwwz6VKLUbxkTCYOTAGb/XB/G7uxb/d+0X3zfw5YdcQ9L3mC5L03mqk038XhCrqPxhbQ/mrCwX34AkkbAlZ140TQRTXC27T+4pK8/+BJAte+N7lvWB4JuqPyMh5pgbH+Z/WVQg1kAIkci89iagVO0Xc06aTfHA0ZDcEls0t/O74M2UBiRoKuMeHNQAkM+oM623qpUbFKDPzlc7u9meZwuFopZExc/t2aR5iNUJCyKPDeEw/XBwtQ9GDdPmGOjZtW5Qw7jHtnqAypNMo="));
        player.sendMessage("Skin set");


        return true;
    }

    // Skin #1194822153 generated on Jan 16, 2021 10:12:42 PM via MineSkin.org - https://minesk.in/1194822153
}
