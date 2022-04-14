package me.undermon.sunrise.listeners;

import org.bukkit.Material;
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
		int skylight = event.getNewState().getBlock().getLightFromSky();
		Material material = event.getNewState().getType();
				
		for (Pair<Material, Integer> pair : this.configuration.minimalSkylightEntries()) {
			if (pair.getValue0().equals(material)) {
				if (skylight < pair.getValue1()) {
					event.setCancelled(true);
				}
			}
		}
	}
}
