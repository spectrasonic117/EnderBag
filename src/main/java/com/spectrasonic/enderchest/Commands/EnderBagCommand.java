package com.spectrasonic.enderchest.Commands;

import com.spectrasonic.enderchest.Services.EnderBagService;
import com.spectrasonic.enderchest.Utils.MessageUtils;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnderBagCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(
            @NonNull CommandSender sender,
            @NonNull Command command,
            @NonNull String label,
            @NonNull String[] args
    ) {
        if (!sender.hasPermission("enderchest.admin")) {
            sender.sendMessage("§cYou don't have permission to use this command.");
            return true;
        }

        if (args.length != 2 || !args[0].equalsIgnoreCase("give")) {
            sender.sendMessage("§cUsage: /enderbag give <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("§cPlayer not found.");
            return true;
        }

        target.getInventory().addItem(EnderBagService.createEnderBag());
        target.sendMessage("§aYou received an EnderBag!");
        sender.sendMessage("§aGave EnderBag to " + target.getName());

        return true;
    }

    @Override
    public List<String> onTabComplete(
            @NonNull CommandSender sender,
            @NonNull Command command,
            @NonNull String alias,
            @NonNull String[] args
    ) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("give");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }

        return completions;
    }
}