package de.dqmme.dutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DUtils implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "permissions":
                    break;
            }
        }
        return false;
    }
}
