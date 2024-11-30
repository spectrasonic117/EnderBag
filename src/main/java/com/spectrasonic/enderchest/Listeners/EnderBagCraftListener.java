package com.spectrasonic.enderchest.Listeners;

import com.spectrasonic.enderchest.Services.EnderBagService;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class EnderBagCraftListener implements Listener {
    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        CraftingInventory inv = event.getInventory();
        if (isValidCustomRecipe(inv.getMatrix())) {
            inv.setResult(EnderBagService.createEnderBag());
        }
    }

    private boolean isValidCustomRecipe(ItemStack[] matrix) {


        return matrix.length == 9 &&
                isString(matrix[0]) &&
                isString(matrix[1]) &&
                isString(matrix[2]) &&
                isString(matrix[3]) &&
                isEnderEye(matrix[4]) &&
                isString(matrix[5]) &&
                isString(matrix[6]) &&
                isString(matrix[7]) &&
                isString(matrix[8]);
    }

    private boolean isEnderEye(ItemStack item) {
        return item != null && item.getType() == Material.ENDER_EYE;
    }

    private boolean isString(ItemStack item) {
        return item != null && item.getType() == Material.STRING;
    }
}