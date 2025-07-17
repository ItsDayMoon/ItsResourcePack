package me.itsResourcePack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static me.itsResourcePack.ItsResourcePack.getPlugin;

public class ResourcePackGetNameGuiListener implements Listener {



    @EventHandler
    void getGuiName(AsyncPlayerChatEvent e){
        if(ResourcePackCommand.canAcessEventGui == true){

            getPlugin().getConfig().createSection("GUIs");
            getPlugin().getConfig().createSection("GUIs." + e.getMessage());
            getPlugin().getConfig().createSection("GUIs." + e.getMessage() + ".name");
            getPlugin().getConfig().createSection("GUIs." + e.getMessage() + ".resourcepacks");
            getPlugin().getConfig().set("GUIs." + e.getMessage() + ".resourcepacks", ItsResourcePack.resourcepacks);
            getPlugin().saveConfig();
            new BukkitRunnable(){
                @Override
                public void run() {
                    e.getPlayer().sendMessage("Sucesso!");
                }
            }.runTaskLater(getPlugin(), 20L);

            ResourcePackCommand.canAcessEventGui = false;
        }
    }



}
