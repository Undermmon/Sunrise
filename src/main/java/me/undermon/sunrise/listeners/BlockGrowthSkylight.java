package me.undermon.sunrise.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.javatuples.Pair;

import me.undermon.sunrise.Configuration;

public class BlockGrowthSkylight implements Listener {
	public BlockGrowthSkylight(Configuration configuration) {
		this.configuration = configuration;
	}

	private Configuration configuration;

	@EventHandler(ignoreCancelled = true)
	private void onBlockGrow(BlockGrowEvent event) {
		Block block = event.getBlock();
		
		for (Pair<Material, Integer> pair : this.configuration.minimalSkylightEntries()) {
			if (pair.getValue0().equals(block.getType())) {
				if (block.getLightFromSky() < pair.getValue1()) {
					event.setCancelled(true);
				}
			}
		}
	}
}
