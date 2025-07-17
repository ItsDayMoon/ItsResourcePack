package me.itsResourcePack;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.Set;

public final class ItsResourcePack extends JavaPlugin {

    private static ItsResourcePack plugin;
    public static ArrayList<String> resourcepacks = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        if(!getConfig().contains(path())){
            getPlugin().getConfig().createSection("ResourcePacks");
        }
        getCommand("rs").setExecutor(new ResourcePackCommand());
        getServer().getPluginManager().registerEvents(new ResourcePackListener(), this);
        getConfig().options().copyDefaults(false);
        saveConfig();
        ConfigurationSection section = getConfig().getConfigurationSection("ResourcePacks");
        Set<String> paths = section.getKeys(false);
        for (String path : paths){
            resourcepacks.add(path);
        }
        saveConfig();
    }

    public static ItsResourcePack getPlugin() {
        return plugin;
    }

    public static String path(){
        return "ResourcePacks.";
    }
}
