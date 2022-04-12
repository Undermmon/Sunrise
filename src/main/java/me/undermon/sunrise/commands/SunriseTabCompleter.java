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
