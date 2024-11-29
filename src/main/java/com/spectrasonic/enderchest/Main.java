package com.spectrasonic.enderchest;

import com.spectrasonic.enderchest.Commands.EnderChestCommand;
import com.spectrasonic.enderchest.Commands.EnderBagCommand;
import com.spectrasonic.enderchest.Listeners.EnderBagCraftListener;
import com.spectrasonic.enderchest.Listeners.EnderChestInteractionListener;
import com.spectrasonic.enderchest.Manager.RecipeManager;
import com.spectrasonic.enderchest.Utils.MessageUtils;

import lombok.Getter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Getter
    private static Main instance;

	@Getter
	private RecipeManager recipeManager;

    @Override
    public void onEnable() {
		instance = this;
		recipeManager = new RecipeManager(this);
		MessageUtils.sendStartupMessage(this);
		recipeManager.registerCustomRecipes();
		registerCommands();
		registerListeners();
    }

    @Override
	public void onDisable() {
		if (recipeManager != null) {
			recipeManager.unregisterCustomRecipes();
		}
		MessageUtils.sendShutdownMessage(this);
	}
	
	public void registerCommands() {
		try {
			PluginCommand enderChestCmd = getCommand("enderchest");
			if (enderChestCmd != null) {
				enderChestCmd.setExecutor(new EnderChestCommand());
			}

			PluginCommand enderBagCmd = getCommand("enderbag");
			if (enderBagCmd != null) {
				EnderBagCommand enderBagCommand = new EnderBagCommand();
				enderBagCmd.setExecutor(enderBagCommand);
				enderBagCmd.setTabCompleter(enderBagCommand);
			}
		} catch (Exception e) {
			getLogger().severe("Error registering commands: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(
				new EnderChestInteractionListener(),
				this
		);
		getServer().getPluginManager().registerEvents(
				new EnderBagCraftListener(),
				this
		);
	}

}