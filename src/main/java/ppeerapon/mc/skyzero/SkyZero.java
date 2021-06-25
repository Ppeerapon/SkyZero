package ppeerapon.mc.skyzero;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import ppeerapon.mc.skyzero.Commands.*;
import ppeerapon.mc.skyzero.Enchantments.GlowEnchantment;
import ppeerapon.mc.skyzero.Listeners.*;
import ppeerapon.mc.skyzero.Utils.Recipe;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class SkyZero extends JavaPlugin {

    private static SkyZero skyZero;

    public static SkyZero getInstance() {
        return skyZero;
    }

    Recipe recipe = new Recipe(this);

    public static GlowEnchantment glowEnchantment;

    private FileManager fileManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +"SkyZero have been enabled");
        skyZero = this;
        fileManager = new FileManager();
        initiateFile();
        commands();
        events();
        recipe.loadRecipe();
        //apiLoad();
        //registerEnchantment( glowEnchantment = new GlowEnchantment());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "SkyZero have been disabled");

//        try {
//            Field keyField = Enchantment.class.getDeclaredField("byKey");
//            keyField.setAccessible(true);
//
//            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);
//            if (byKey.containsKey(glowEnchantment.getKey())) {
//                byKey.remove(glowEnchantment.getKey());
//            }
//
//            Field nameField = Enchantment.class.getDeclaredField("byName");
//            keyField.setAccessible(true);
//
//            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);
//            if (byName.containsKey(glowEnchantment.getName())) {
//                byName.remove(glowEnchantment.getName());
//            }
//
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

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
        this.getCommand("Book").setExecutor(new Book());
        this.getCommand("Help").setExecutor(new Help(this));
        this.getCommand("Text").setExecutor(new Text());
        this.getCommand("Broadcast").setExecutor(new Broadcast());
        this.getCommand("SetSkin").setExecutor(new SetSkin());
        this.getCommand("GUI").setExecutor(new DynamicMenu());
        this.getCommand("Rank").setExecutor(new RankCommand());
    }

    private void events() {
        this.getServer().getPluginManager().registerEvents(new PlaceBlockListener(), this);
        this.getServer().getPluginManager().registerEvents(new DamageListener(), this);
        this.getServer().getPluginManager().registerEvents(new DropListener(), this);
        this.getServer().getPluginManager().registerEvents(new PingListener(), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new InteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new MoveListener(), this);
        this.getServer().getPluginManager().registerEvents(new ResourcePackStatusListener(), this);
        this.getServer().getPluginManager().registerEvents(new SitListener(), this);
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new SignListener(), this);
        this.getServer().getPluginManager().registerEvents(new SneakingListener(), this);
        this.getServer().getPluginManager().registerEvents(new RandomListener(), this);
        //this.getServer().getPluginManager().registerEvents(new MapEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SideBarListener(), this);
        this.getServer().getPluginManager().registerEvents(new TargetListener(), this);
        this.getServer().getPluginManager().registerEvents(new ServerBroadcastListener(), this);
        //this.getServer().getPluginManager().registerEvents(new GlowEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new GUIListener(), this);
        this.getServer().getPluginManager().registerEvents(new RankListener(), this);
        this.getServer().getPluginManager().registerEvents(new SneakListener(), this);
    }

    private void registerEnchantment(Enchantment enchantment) {

        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

//    private void apiLoad() {
//        if (getWorldEditAPI() != null) System.out.println("----> WorldEdit was found");
//        else {
//            System.out.println("----> WorldEdit was not found");
//            Bukkit.getPluginManager().disablePlugin(this);
//        }
//    }

    private File file;
    private YamlConfiguration config;

    private void initiateFile() {
        try {
            file = new File(getDataFolder(), "test.yml");
            if (!getDataFolder().exists()) {
                if (getDataFolder().mkdir()) Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Data Folder has been created.");
            }

            if (file.createNewFile()) Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + file.getName() + " has been create.");
            else Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA  + file.getName() + " already created.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public YamlConfiguration getConfig() { return config; }
    public File getFile() { return file; }
    public void saveFile() {
        try {
            config.save(file);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + file.getName() + " has been saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileManager getFileManager() { return fileManager;}

//    public WorldEditPlugin getWorldEditAPI() {
//        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
//        if (plugin instanceof WorldEditPlugin) return (WorldEditPlugin) plugin;
//        else return null;
//    }

}
