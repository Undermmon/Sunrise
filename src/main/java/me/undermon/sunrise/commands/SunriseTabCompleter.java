/* Copyright (c) 2022, Sunrise's Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */


package me.undermon.sunrise.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class SunriseTabCompleter implements TabCompleter {
	@Override
	public List<String> onTabComplete(CommandSender sender,Command command, String label, String[] args) {
		List<String> suggestions = new ArrayList<>();

		if (args.length > 0) {
			suggestions.add("reload");
		}
		
		return suggestions;
	}

}
