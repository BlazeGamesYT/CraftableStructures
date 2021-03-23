package com.bryceblazegames.craftablestructures.itemEvents;

import com.bryceblazegames.craftablestructures.craftableStructures;
import com.bryceblazegames.craftablestructures.items.itemManager;
import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.nio.file.Path;
import java.util.logging.Level;

public class structureBlocksEvents implements Listener {
    
    @EventHandler
    public static void onPlace(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack block = player.getInventory().getItemInMainHand();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            player.sendMessage("You right clicked a block");

            if (block.isSimilar(itemManager.desertTemple)) {

                Plugin plugin = craftableStructures.instance;

                player.sendMessage("You placed a desertTemple block");

                StructureBlockLibApi.INSTANCE
                        .loadStructure(plugin)
                        .at(player.getLocation())
                        .loadFromPath(craftableStructures.getDesertTemple())
                        .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure.", e))
                        .onResult(e -> player.sendMessage(ChatColor.GREEN + "Loaded structure 'desert_temple'."));

            }

        }

    }
    
}
