package com.spectrasonic.enderchest.Commands;

import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
        @NonNull CommandSender sender, 
        @NonNull Command command, 
        @NonNull String label, 
        @NonNull String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command.");
            return true;
        }

        if (!player.hasPermission("enderchest.use")) {
            player.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        player.openInventory(player.getEnderChest());
        return true;
    }
}