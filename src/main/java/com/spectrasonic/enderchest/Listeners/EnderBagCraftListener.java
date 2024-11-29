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

        // Verificación adicional de la receta (opcional)
        if (isValidCustomRecipe(inv.getMatrix())) {
            // Puedes añadir lógica adicional aquí si es necesario
            // Por ejemplo, verificar permisos, añadir condiciones especiales, etc.
            inv.setResult(EnderBagService.createEnderBag());
        }
    }

    private boolean isValidCustomRecipe(ItemStack[] matrix) {
        // Patrón de receta esperado
        // s s s
        // s e s
        // s s s

        // Verificación de materiales en posiciones específicas
        return matrix.length == 9 &&
                isString(matrix[0]) &&
                isString(matrix[1]) &&
                isString(matrix[2]) &&
                isString(matrix[3]) &&
                isEnderPearl(matrix[4]) &&
                isString(matrix[5]) &&
                isString(matrix[6]) &&
                isString(matrix[7]) &&
                isString(matrix[8]);
    }

    private boolean isEnderPearl(ItemStack item) {
        return item != null && item.getType() == Material.ENDER_PEARL;
    }

    private boolean isString(ItemStack item) {
        return item != null && item.getType() == Material.STRING;
    }
}