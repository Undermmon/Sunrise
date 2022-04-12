package me.undermon.sunrise;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.javatuples.Pair;

public class Configuration {
	private List<Pair<Material, Integer>> openSkyMaterials;
	private List<Pair<Material, Integer>> wetFarmlandMaterials;
	private Plugin plugin;

	public Configuration(Plugin plugin) {
		this.plugin = plugin;
		
		this.plugin.saveDefaultConfig();
		this.reload();
	}
	
	/*
	 * Reloads the configuration file.
	 */
	public void reload() {
		this.plugin.reloadConfig();
		this.openSkyMaterials = this.parseOpenSkyMaterials();
		this.wetFarmlandMaterials = this.parseWetFarmlandMaterials();

	}
	
	/**
	 * Get list of materials that should n
	 * 
	 * @return {@link List} of {@link Pair}, where the first element is the
	 * {@link Material}, and the second is an int as the minimal sky
	 * light level
	 */
	public List<Pair<Material, Integer>> openSkyCrops() {
		return new ArrayList<>(this.openSkyMaterials);
	}

	/**
	 * @return {@link List} of {@link Pair}, where the first element is the
	 * {@link Material}, and the second is an int as the minimal moisture level
	 */
	public List<Pair<Material, Integer>> wetFarmlandCrops() {
		return new ArrayList<>(this.wetFarmlandMaterials);
	}

	public boolean netherWartGrowsOnlyInNether() {
		return this.plugin.getConfig().getBoolean("nether_wart_only_grows_on_nether");
	}

	public boolean chorusPlantGrowsOnlyInEnd() {
		return this.plugin.getConfig().getBoolean("chorus_fruit_only_grows_on_end");
	}

	private List<Pair<Material, Integer>> parseOpenSkyMaterials() {
		return this.parseLines(
				this.plugin.getConfig().getStringList("blocks_that_need_sky_light"));
	}
	
	private List<Pair<Material, Integer>> parseWetFarmlandMaterials() {
		return this.parseLines(
				this.plugin.getConfig().getStringList("crops_that_need_moist_farmland"));
	}
	
	private List<Pair<Material, Integer>> parseLines(List<String> lines) {
		List<Pair<Material, Integer>> pairList = new ArrayList<>();
		
		for (String line : lines) {
			String[] args = line.split(" ");
			
			Material material = Material.valueOf(args[0].toUpperCase());
			int integer = Integer.valueOf(args[1]);
			
			pairList.add(new Pair<>(material, integer));
		}

		return pairList;
	}
}
