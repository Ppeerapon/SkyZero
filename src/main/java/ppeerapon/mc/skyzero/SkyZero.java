package ppeerapon.mc.skyzero;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import ppeerapon.mc.skyzero.Commands.*;
import ppeerapon.mc.skyzero.Events.*;

public final class SkyZero extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +"SkyZero have been enabled");
        commands();
        events();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "SkyZero have been disabled");
    }

    private void commands() {
        this.getCommand("Fly").setExecutor(new Fly());
        this.getCommand("Hologram").setExecutor(new Hologram());
        this.getCommand("Kick").setExecutor(new Kick());
        this.getCommand("Path").setExecutor(new Path());
        this.getCommand("Message").setExecutor(new Message());
        this.getCommand("Menu").setExecutor(new Menu());
        this.getCommand("Skull").setExecutor(new Skull());
        this.getCommand("Banner").setExecutor(new Banner());
        this.getCommand("Map").setExecutor(new Map());
    }

    private void events() {
        this.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        this.getServer().getPluginManager().registerEvents(new DropEvent(), this);
        this.getServer().getPluginManager().registerEvents(new PingEvent(), this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ResourcePackStatusEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SitEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MenuEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SignEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SneakingEvent(), this);
        this.getServer().getPluginManager().registerEvents(new RandomEvent(), this);
        //this.getServer().getPluginManager().registerEvents(new MapEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SideBarEvent(), this);
    }

}
