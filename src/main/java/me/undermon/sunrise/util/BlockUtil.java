/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package me.undermon.sunrise.util;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Farmland;

public class BlockUtil {

    public static int farmlandMoisture(Block block) {
        Block blockBellow = block.getRelative(BlockFace.DOWN);

        if (blockBellow.getBlockData() instanceof Farmland) {
            Farmland farmland = (Farmland) blockBellow.getBlockData();

            return farmland.getMoisture();
        } else {
            return 0;
        }
    }

}
