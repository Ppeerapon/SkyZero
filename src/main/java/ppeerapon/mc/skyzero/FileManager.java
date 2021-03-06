package ppeerapon.mc.skyzero;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    File file;
    YamlConfiguration config;

    public FileManager() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "This is a Test !!!");
        file = new File(SkyZero.getInstance().getDataFolder(), "data.yml");

        if (!file.exists()) {

            try {
                if (file.createNewFile()) Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Data.yml file has been created.");
                else Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Can't create Data.yml file !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);

    }

    public void setRank(Player player, Rank rank) {
        config.set(player.getUniqueId().toString(), rank.getName());
        saveConfig();
    }

    public void setRank(UUID uuid, Rank rank) {
        config.set(uuid.toString(), rank.getName());
        saveConfig();
    }

    public Rank getRank(Player player) {
        if (config.get(player.getUniqueId().toString()) == null) return null;
        return Rank.valueOf(config.getString(player.getUniqueId().toString()).toUpperCase());
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(file);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "data.yml has been saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
