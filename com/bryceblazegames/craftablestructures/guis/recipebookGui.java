package com.bryceblazegames.craftablestructures.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import com.bryceblazegames.craftablestructures.items.itemManager;

import java.util.Collections;

public class recipebookGui implements InventoryHolder {
    private Inventory inv;

    public recipebookGui() {

        inv = Bukkit.createInventory(this, 54, "Recipe Book");
        init();

    }

    private void init() {

        ItemStack item;

        //Glass Panes
        item = itemManager.createItem(" ", Material.BLACK_STAINED_GLASS_PANE, Collections.singletonList(" "), 0);

        //Border
        for (int i = 0; i < 9; i++) {

            inv.setItem(inv.firstEmpty(), item);

        }
        for (int i = 9; i < 37; i += 9) {

            inv.setItem(i, item);

        }
        for (int i = 17; i < 53; i += 9) {

            inv.setItem(i, item);

        }
        for (int i = 0; i < 9; i++) {

            inv.setItem(i + 45, item);

        }

        //Items
        inv.setItem(inv.firstEmpty(), itemManager.desertTemple);

    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
