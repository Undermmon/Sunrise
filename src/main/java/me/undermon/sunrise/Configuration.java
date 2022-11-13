/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.javatuples.Pair;

public class Configuration {
	
	private List<Pair<Material, Integer>> skylightEntries;
	private List<Pair<Material, Integer>> farmlandMoistureEntries;
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
		this.skylightEntries = this.parseMinimalSkylightEntries();
		this.farmlandMoistureEntries = this.parseMinimalFarmlandMoistureEntries();
	}

	/**
	 * Get list of entries with a minimal skylight level to grow.
	 *
	 * @return {@link List} of {@link Pair}, each representing an entry, where
	 * the first element is the {@link Material} this entry represents, and the
	 * second is an int as the minimal sky light level.
	 */
	public List<Pair<Material, Integer>> minimalSkylightEntries() {
		return new ArrayList<>(this.skylightEntries);
	}

	/**
	 * Get list of entries in which the farmland where the material is planted
	 * on needs a minimal moisture level to grow.
	 *
	 * @return {@link List} of {@link Pair} each representing an entry, where
	 * the first element is the {@link Material} this entry represents, and the
	 * second is an int as the minimal moisture level.
	 */
	public List<Pair<Material, Integer>> minimalFarmlandMoistureEntries() {
		return new ArrayList<>(this.farmlandMoistureEntries);
	}

	public boolean netherWartGrowsOnlyInNether() {
		return this.plugin.getConfig().getBoolean("nether_wart_only_grows_on_nether");
	}

	public boolean chorusPlantGrowsOnlyInEnd() {
		return this.plugin.getConfig().getBoolean("chorus_fruit_only_grows_on_end");
	}

	public boolean hardcoreBucket() {
		return this.plugin.getConfig().getBoolean("hardcore_bucket");
	}

	public boolean disableBonemal() {
		return this.plugin.getConfig().getBoolean("disable_bonemeal");
	}

	private List<Pair<Material, Integer>> parseMinimalSkylightEntries() {
		return this.parseLines(
			this.plugin.getConfig().getStringList("blocks_with_minimal_skylight_to_grow"));
	}

	private List<Pair<Material, Integer>> parseMinimalFarmlandMoistureEntries() {
		return this.parseLines(
			this.plugin.getConfig().getStringList("blocks_with_minimal_farmland_moisture_to_grow"));
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
