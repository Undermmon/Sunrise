/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.undermon.sunrise.commands.SunriseExecutor;
import me.undermon.sunrise.commands.SunriseTabCompleter;
import me.undermon.sunrise.listeners.BlockGrowMoisture;
import me.undermon.sunrise.listeners.BlockGrowthSkylight;
import me.undermon.sunrise.listeners.ChorusFlowerGrowth;
import me.undermon.sunrise.listeners.NetherWartGrowth;
import me.undermon.sunrise.listeners.PlayerBucketEmpty;

public class Main extends JavaPlugin {
	private Configuration configuration;

	@Override
	public void onEnable() {
		this.configuration = new Configuration(this);
				
		this.registerCommands();
		this.registerListeners();
		

	}
	
	@Override
	public void onDisable() {
	
	}
	
	private void registerCommands() {
		this.getCommand("sunrise").setExecutor(new SunriseExecutor(this.configuration));
		this.getCommand("sunrise").setTabCompleter(new SunriseTabCompleter());
	}
	
	private void registerListeners() {
		Listener[] listeners = {
				new ChorusFlowerGrowth(this.configuration),
				new NetherWartGrowth(this.configuration),
				new BlockGrowMoisture(this.configuration),
				new BlockGrowthSkylight(this.configuration),
				new PlayerBucketEmpty(this.configuration)
		};
		
		for (Listener listener : listeners) {
			this.getServer().getPluginManager().registerEvents(listener, this);
		}
	}
	
	
}
