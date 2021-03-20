package com.bryceblazegames.craftablestructures;

import com.bryceblazegames.craftablestructures.commands.givebook;
import org.bukkit.plugin.java.JavaPlugin;
import com.bryceblazegames.craftablestructures.items.itemManager;

public class craftableStructures extends JavaPlugin {

    @Override
    public void onEnable() {

        itemManager.init();
        getCommand("givebook").setExecutor(new givebook());

    }

    @Override
    public void onDisable() {



    }

}