package me.undermon.sunrise.util;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Farmland;

public class BlockUtil {
	
	public static int farmlandMoisture(Block  block) {
		Block blockBellow = block.getRelative(BlockFace.DOWN);

		if (blockBellow.getBlockData() instanceof Farmland) {
			Farmland farmland = (Farmland) blockBellow.getBlockData();

			System.out.println("MOISTURE BLOCK/LEVEL: " +  block.getType() + " / " + farmland.getMoisture());
			return farmland.getMoisture();
		} else {
			return 0;
		}
	}
	

}
