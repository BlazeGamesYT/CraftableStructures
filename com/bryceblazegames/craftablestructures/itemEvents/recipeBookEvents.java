package com.bryceblazegames.craftablestructures.itemEvents;

import com.bryceblazegames.craftablestructures.guis.recipebookGui;
import com.bryceblazegames.craftablestructures.items.itemManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class recipeBookEvents implements Listener {

    @EventHandler
    public static void onClick(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) { return; }
        if (event.getClickedInventory().getHolder() instanceof recipebookGui) {

            event.setCancelled(true);

        }

    }

    @EventHandler
    public static void onClick(InventoryDragEvent event) {

        if (event.getInventory() == null) { return; }
        if (event.getInventory().getHolder() instanceof recipebookGui) {

            event.setCancelled(true);

        }

    }

    @EventHandler
    public static void onBookOpen(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack helditem = event.getItem();

        if (helditem.isSimilar(itemManager.recipeBook)) {

            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {

                recipebookGui gui = new recipebookGui();
                player.openInventory(gui.getInventory());

            }

        }

    }

}