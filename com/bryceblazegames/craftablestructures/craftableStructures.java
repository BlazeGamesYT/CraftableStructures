package com.bryceblazegames.craftablestructures;

import com.bryceblazegames.craftablestructures.commands.givebook;
import com.bryceblazegames.craftablestructures.enchants.Glow;
import com.bryceblazegames.craftablestructures.guiEvents.guiEvents;
import com.bryceblazegames.craftablestructures.itemEvents.recipeBookEvents;
import com.bryceblazegames.craftablestructures.itemEvents.structureBlocksEvents;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.bryceblazegames.craftablestructures.items.itemManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Objects;

public class craftableStructures extends JavaPlugin {

    ConsoleCommandSender console = getServer().getConsoleSender();
    Server server = getServer();
    public static craftableStructures instance;

    @Override
    public void onEnable() {

        instance = this;

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
        server.getPluginManager().registerEvents(new structureBlocksEvents(), this);

        //FINISHED
        console.sendMessage(ChatColor.GREEN + "[CraftStruct]: Loaded!");

        console.sendMessage(getResourceAsFile("desert_temple.nbt").toString());
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

    public static File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                //copy stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Path getDesertTemple() {

        final Path desertTemplePath = Objects.requireNonNull(getResourceAsFile("desert_temple.nbt")).toPath();

        return desertTemplePath;

    }

}