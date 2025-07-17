package me.itsResourcePack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ResourcePackCreationGui {

    Inventory createGUI(String title, int size, Player player){

        Inventory gui = Bukkit.createInventory(player,size,title);

        return gui;
    }


}
