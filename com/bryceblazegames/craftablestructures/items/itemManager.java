package com.bryceblazegames.craftablestructures.items;

import com.bryceblazegames.craftablestructures.enchants.Glow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {

    //RecipeBook
    public static ItemStack recipeBook;

    //Structures
    public static ItemStack desertTemple;

    public static void init() {

        createRecipeBook();
        createDesertTemple();

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

    //Book
    public static void createRecipeBook() {

        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eRecipe Book §7(Right-Click)");

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //meta.setCustomModelData(1);

        item.setItemMeta(meta);

        recipeBook = item;

        ItemStack result = new ItemStack(item.clone());
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("recipebook"), result);
        recipe.addIngredient(Material.BOOK);
        recipe.addIngredient(Material.NETHER_STAR);
        Bukkit.getServer().addRecipe(recipe);

    }

    //Structure Items
    public static void createDesertTemple() {

        ItemStack item = new ItemStack(Material.CHISELED_SANDSTONE, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§dDesert Temple");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //meta.setCustomModelData(1);

        Glow glow = new Glow(NamespacedKey.minecraft("70"));
        meta.addEnchant(glow, 1, true);

        item.setItemMeta(meta);

        desertTemple = item;

        ItemStack result = new ItemStack(item.clone());

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("deserttemple"), result);
        recipe.shape(" C ",
                     " S ",
                     "TTT");
        recipe.setIngredient('C', Material.CACTUS);
        recipe.setIngredient('S' , Material.SAND);
        recipe.setIngredient('T', Material.SANDSTONE);
        Bukkit.getServer().addRecipe(recipe);


    }

}
