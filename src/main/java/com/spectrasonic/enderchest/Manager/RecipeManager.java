package com.spectrasonic.enderchest.Manager;

import com.spectrasonic.enderchest.Main;
import com.spectrasonic.enderchest.Services.EnderBagService;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {
    private final Main plugin;

    public RecipeManager(Main plugin) {
        this.plugin = plugin;
    }

    public void registerCustomRecipes() {
        createEnderBagRecipe();
    }

    private void createEnderBagRecipe() {
        ItemStack enderBag = EnderBagService.createEnderBag();

        NamespacedKey recipeKey = new NamespacedKey(plugin, "enderbag_recipe");

        ShapedRecipe enderBagRecipe = new ShapedRecipe(recipeKey, enderBag);

        enderBagRecipe.shape(
                "sls",
                "lel",
                "sls"
        );

        enderBagRecipe.setIngredient('s', Material.STRING);
        enderBagRecipe.setIngredient('l', Material.LEATHER);
        enderBagRecipe.setIngredient('e', Material.ENDER_EYE);

        Bukkit.addRecipe(enderBagRecipe);
    }

    public void unregisterCustomRecipes() {
        Bukkit.removeRecipe(new NamespacedKey(plugin, "enderbag_recipe"));
    }
}