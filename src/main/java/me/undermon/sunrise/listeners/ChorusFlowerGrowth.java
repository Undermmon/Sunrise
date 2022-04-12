package me.undermon.sunrise.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

import me.undermon.sunrise.Configuration;

public class ChorusFlowerGrowth implements Listener {
	private Configuration configuration;

	public ChorusFlowerGrowth(Configuration configuration) {
		this.configuration = configuration;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockSpread(BlockSpreadEvent event) {
		Block block = event.getSource();
		
		if (this.configuration.chorusPlantGrowsOnlyInEnd()) {
			if (block.getType() == Material.CHORUS_FLOWER) {
				if (!block.getWorld().getName().endsWith("_the_end")) {
					event.setCancelled(true);
				} 
			}
			
		}
	}

}
