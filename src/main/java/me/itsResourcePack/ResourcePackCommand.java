package me.itsResourcePack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

import static me.itsResourcePack.ItsResourcePack.*;

public class ResourcePackCommand implements CommandExecutor {

    public static Boolean canAcessEvent;
    public static Boolean canAcessEventGui;
    ResourcePackCreationGui resourcePackCreationGui = new ResourcePackCreationGui();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = ((Player) commandSender).getPlayer();
        if (s.equalsIgnoreCase("rs")) {
            switch (strings[0]) {
                case "create":
                    if (strings.length > 0) {
                        ResourcePackCreationGui creationGui = new ResourcePackCreationGui();
                        getPlugin().getConfig().createSection(path() + strings[1]);
                        getPlugin().getConfig().createSection(path() + strings[1] + ".resourcepack");
                        getPlugin().getConfig().createSection(path() + strings[1] + ".name");
                        getPlugin().saveConfig();
                        canAcessEvent = true;
                        player.sendMessage("Dê um nome para seu resource pack:");
                        getPlugin().getServer().getPluginManager().registerEvents(new ResourcePackGetNameListener(strings[1]), getPlugin());

                    } else {
                        player.sendMessage("Tu ta loko né meu? Tem que dar um nome!");
                    }
                    break;
                case "set":
                    if (strings.length > 1) {
                        String path = strings[1];
                        if (getPlugin().getConfig().contains(path() + path) && strings.length < 4) {
                            getPlugin().getConfig().set(path() + path + ".resourcepack", strings[2]);
                            getPlugin().saveConfig();
                            player.sendMessage("Sucesso");
                        } else {
                            player.sendMessage("§cComando: /rs set <path_do_resourcepack_na_config> <link_do_resourcepack>");
                        }
                    }
                    break;
                case "creategui":
                    canAcessEventGui = true;
                    player.sendMessage("De um nome para a GUI:");
                    getPlugin().getServer().getPluginManager().registerEvents(new ResourcePackGetNameGuiListener(), getPlugin());
                    break;
                case "open":
                    if(strings.length > 1){

                        Inventory rsgui = resourcePackCreationGui.createGUI(getPlugin().getConfig().getString("GUIs." + strings[1] + ".name"),9, player);

                        player.openInventory(rsgui);

                    }
            }

        }
        return true;
    }
}
