package com.spectrasonic.enderchest.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.spectrasonic.enderchest.Utils.MessageUtils;

public class EnderChestInteractionListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || 
             event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
            mainHandItem.getType() == Material.PAPER &&
            mainHandItem.hasItemMeta() &&
            mainHandItem.getItemMeta().hasCustomModelData() &&
            mainHandItem.getItemMeta().getCustomModelData() == 1000
        ) {
            if (!player.hasPermission("enderchest.use")) {
				MessageUtils.sendMessage(player, "&cYou do not have permission to open EnderChest.");
                return;
            }

            player.openInventory(player.getEnderChest());
            event.setCancelled(true); // Prevent further interaction
        }
    }
}