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
            meta.setDisplayName("§5EnderBag");
            meta.setCustomModelData(1000);
            meta.setLore(Arrays.asList(
                    "§7Right-click to open",
                    "§7your EnderBag"
            ));
            enderBag.setItemMeta(meta);
        }

        return enderBag;
    }
}