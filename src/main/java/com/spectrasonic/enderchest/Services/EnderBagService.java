package com.spectrasonic.enderchest.Services;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EnderBagService {

    public static ItemStack createEnderBag() {
        ItemStack enderBag = new ItemStack(Material.PAPER);
        ItemMeta meta = enderBag.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(translateColorCodes("&5&lEnderBag"));
            meta.setCustomModelData(1000);
            meta.setLore(Arrays.asList(
                    translateColorCodes("&7Right-click to open"),
                    translateColorCodes("&7your EnderBag")
            ));
            enderBag.setItemMeta(meta);
        }

        return enderBag;
    }

    // Método para traducir los códigos de color de & a §
    private static String translateColorCodes(String text) {
        return text.replace('&', '§');
    }
}