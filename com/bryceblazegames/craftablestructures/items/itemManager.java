package com.bryceblazegames.craftablestructures.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {

    public static ItemStack recipeBook;

    public static void init() {

        createRecipeBook();

    }

    public static ItemStack createItem(String  name, Material mat, List<String> lore, int custommodeldata) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setCustomModelData(custommodeldata);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static List<String> createLore(String line1, String line2, String line3) {
        List<String> lore = new ArrayList<>();
        lore.add(line1);
        lore.add(line2);
        lore.add(line3);
        return lore;
    }

    public static void createRecipeBook() {

        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eRecipe Book §7(Right-Click)");

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //meta.setCustomModelData(1);

        item.setItemMeta(meta);

        recipeBook = item;

    }

}
