package me.undermon.sunrise.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.undermon.sunrise.Configuration;

public class SunriseExecutor implements CommandExecutor {
	private Configuration configuration;

	public SunriseExecutor(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 1 && args[0].equals("reload")) {
			this.configuration.reload();
			sender.sendMessage("Sunrise configuration reload");
			
			return true;
		} else {
			return false;
		}
		
	}

}
