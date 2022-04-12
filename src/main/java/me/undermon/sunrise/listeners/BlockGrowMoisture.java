package me.undermon.sunrise.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Farmland;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.javatuples.Pair;

import me.undermon.sunrise.Configuration;

public class BlockGrowMoisture implements Listener {
	private Configuration configuration;

	public BlockGrowMoisture(Configuration configuration) {
		this.configuration = configuration;

	}
	
	@EventHandler(ignoreCancelled = true)
	private void onBlockGrow(BlockGrowEvent event) {
		Block block = event.getBlock();
		
		for (Pair<Material, Integer> pair : this.configuration.wetFarmlandCrops()) {
			if (pair.getValue0().equals(block.getType())) {
				Block blockBellow = block.getRelative(BlockFace.DOWN);

				if (blockBellow.getBlockData() instanceof Farmland) {
					Farmland farmland = (Farmland) blockBellow.getBlockData();

					if (farmland.getMoisture() < pair.getValue1()) {
						event.setCancelled(true);
					}
				}
			}
		}

	}

}
