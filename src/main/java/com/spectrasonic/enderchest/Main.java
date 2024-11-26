package com.spectrasonic.enderchest;

import com.spectrasonic.enderchest.Commands.EnderChestCommand;
import com.spectrasonic.enderchest.Commands.EnderBagCommand;
import com.spectrasonic.enderchest.Listeners.EnderChestInteractionListener;
import com.spectrasonic.enderchest.Utils.MessageUtils;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
		instance = this;
		MessageUtils.sendStartupMessage(this);
		registerCommands();
		registerListeners();
    }

    @Override
	public void onDisable() {
		MessageUtils.sendShutdownMessage(this);
	}
	
	public void registerCommands() {
		getCommand("enderchest").setExecutor(new EnderChestCommand());
		getCommand("enderbag").setExecutor(new EnderBagCommand());
	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new EnderChestInteractionListener(), this);
	}

}