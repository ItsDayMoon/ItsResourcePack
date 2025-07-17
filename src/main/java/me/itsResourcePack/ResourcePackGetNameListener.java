package me.itsResourcePack;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static me.itsResourcePack.ItsResourcePack.getPlugin;
import static me.itsResourcePack.ItsResourcePack.path;

public class ResourcePackGetNameListener implements Listener {

    String path;

    public ResourcePackGetNameListener(String path){
        super();
        this.path = path;
    }


    @EventHandler
    void getNameGui(AsyncPlayerChatEvent playerChatEvent){
        if(ResourcePackCommand.canAcessEvent == true){
            String name = playerChatEvent.getMessage();
            getPlugin().getConfig().set(path() + path + ".name", name);
            getPlugin().saveConfig();
            ResourcePackCommand.canAcessEvent = false;
            new BukkitRunnable(){
                @Override
                public void run() {
                    playerChatEvent.getPlayer().sendMessage("Sucesso meu brother!");
                }
            }.runTaskLater(getPlugin(),20L);
        }

    }


}
