/*
 * Copyright (C) 2020  Kikisito (Kyllian)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.kikisito.goldenheads.listeners;

import com.github.kikisito.goldenheads.GoldenHead;
import com.github.kikisito.goldenheads.Logger;
import com.github.kikisito.goldenheads.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    private Logger logger;
    private Main plugin;

    public BlockPlaceListener(Main plugin, Logger logger){
        this.plugin = plugin;
        this.logger = logger;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        logger.debug("Detected block place event.");
        if(GoldenHead.isGoldenHead(plugin, e.getItemInHand())){
            logger.debug("Block place event cancelled.");
            e.setCancelled(true);
        }
    }
}
