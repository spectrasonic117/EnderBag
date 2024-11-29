package com.spectrasonic.enderchest.Manager;

import com.spectrasonic.enderchest.Main;
import com.spectrasonic.enderchest.Services.EnderBagService;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {
    private final Main plugin;

    public RecipeManager(Main plugin) {
        this.plugin = plugin;
    }

    public void registerCustomRecipes() {
        // Crear la receta del EnderBag
        createEnderBagRecipe();
    }

    private void createEnderBagRecipe() {
        // Crear el item del EnderBag
        ItemStack enderBag = EnderBagService.createEnderBag();

        // Crear una clave única para la receta
        NamespacedKey recipeKey = new NamespacedKey(plugin, "enderbag_recipe");

        // Crear una receta de crafteo personalizada
        ShapedRecipe enderBagRecipe = new ShapedRecipe(recipeKey, enderBag);

        // Definir el patrón de la receta
        enderBagRecipe.shape(
                "sls",
                "lel",
                "sls"
        );

        // Definir los ingredientes
        enderBagRecipe.setIngredient('s', Material.STRING);
        enderBagRecipe.setIngredient('l', Material.LEATHER);
        enderBagRecipe.setIngredient('e', Material.ENDER_PEARL);

        // Registrar la receta
        Bukkit.addRecipe(enderBagRecipe);
    }

    public void unregisterCustomRecipes() {
        // Método para desregistrar recetas si es necesario
        Bukkit.removeRecipe(new NamespacedKey(plugin, "enderbag_recipe"));
    }
}