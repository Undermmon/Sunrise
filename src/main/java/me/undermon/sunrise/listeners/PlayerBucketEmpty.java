/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

import me.undermon.sunrise.Configuration;

public class PlayerBucketEmpty implements Listener {
	Configuration configuration;

	public PlayerBucketEmpty(Configuration configuration) {
		this.configuration = configuration;
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerEmptyBucket(PlayerBucketEmptyEvent event) {
		if (this.configuration.hardcoreBucket() && event.getBucket() == Material.WATER_BUCKET) {
			event.setCancelled(true);
			event.getPlayer().getInventory().setItem(event.getHand(), new ItemStack(Material.BUCKET));
		}
	}
}
