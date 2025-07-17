package me.itsResourcePack;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import static me.itsResourcePack.ItsResourcePack.getPlugin;
import static me.itsResourcePack.ItsResourcePack.path;

public class ResourcePackListener implements Listener {

    @EventHandler
    void OnClickItem(InventoryClickEvent inventoryClickEvent) {

        Player player = (Player) inventoryClickEvent.getWhoClicked();
        if (inventoryClickEvent.getView().getTitle().equals("&lItsArmorStand")) {
            ItemStack curentItem = inventoryClickEvent.getCurrentItem();
            if(curentItem != null && curentItem.getType() != Material.AIR ){
                switch (curentItem.getType()){
                    case EMERALD :
                        player.setResourcePack("https://www.dropbox.com/scl/fi/kxcdns9guxqxgmr8tba9v/Novo-a-Arquivo-ZIP-do-WinRAR-1.zip?rlkey=ygdfx718pu3mlsqfv2z4id298&st=1ugi6h9s&dl=1");
                        break;
                }

            }
        }

    }




}
