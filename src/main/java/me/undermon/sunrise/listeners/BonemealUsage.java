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
