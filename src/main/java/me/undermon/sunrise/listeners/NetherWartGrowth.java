/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import me.undermon.sunrise.Configuration;

public class NetherWartGrowth implements Listener {
    
    private Configuration configuration;

    public NetherWartGrowth(Configuration configuration) {
        this.configuration = configuration;
    }

    @EventHandler(ignoreCancelled = true)
    private void onBlockGrow(BlockGrowEvent event) {
        if (this.configuration.netherWartGrowsOnlyInNether()) {
            Block block = event.getBlock();

            if (block.getType() == Material.NETHER_WART) {
                if (!block.getWorld().equals(Bukkit.getWorld(NamespacedKey.minecraft("the_nether")))) {
                    event.setCancelled(true);
                }
            }

        }
    }

}
