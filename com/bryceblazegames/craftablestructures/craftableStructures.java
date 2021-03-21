package com.bryceblazegames.craftablestructures;

import com.bryceblazegames.craftablestructures.commands.givebook;
import com.bryceblazegames.craftablestructures.enchants.Glow;
import com.bryceblazegames.craftablestructures.guiEvents.guiEvents;
import com.bryceblazegames.craftablestructures.itemEvents.recipeBookEvents;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import com.bryceblazegames.craftablestructures.items.itemManager;

import java.lang.reflect.Field;

public class craftableStructures extends JavaPlugin {

    ConsoleCommandSender console = getServer().getConsoleSender();
    Server server = getServer();

    @Override
    public void onEnable() {

        //Load Effects
        registerGlow();

        //Load Items
        console.sendMessage(ChatColor.YELLOW + "[CraftStruct]: Items loading...");
        itemManager.init();

        //Load Commands
        console.sendMessage(ChatColor.YELLOW + "[CraftStruct]: Commands loading...");
        getCommand("givebook").setExecutor(new givebook());

        //Load Events
        console.sendMessage(ChatColor.YELLOW + "[CraftStruct]: Events loading...");
        server.getPluginManager().registerEvents(new guiEvents(), this);
        server.getPluginManager().registerEvents(new recipeBookEvents(), this);

        //FINISHED
        console.sendMessage(ChatColor.GREEN + "[CraftStruct]: Loaded!");
    }

    @Override
    public void onDisable() {



    }

    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glow glow = new Glow(NamespacedKey.minecraft("70"));
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}