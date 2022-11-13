/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFertilizeEvent;

import me.undermon.sunrise.Configuration;

public class BonemealUsage implements Listener {

    private Configuration configuration;

    public BonemealUsage (Configuration configuration) {
        this.configuration = configuration;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBonemealUsage(BlockFertilizeEvent event) {
        if (this.configuration.disableBonemal()) {
            event.setCancelled(true);
        }
    }
}
