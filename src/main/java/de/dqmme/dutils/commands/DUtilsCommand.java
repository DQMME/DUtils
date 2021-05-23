package de.dqmme.dutils.commands;

import de.dqmme.dutils.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DUtilsCommand implements CommandExecutor {
    private final Messages messages = new Messages();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "permissions":
                    sender.sendMessage(messages.PERMISSIONS);
                    break;
                case "bugs":
                    sender.sendMessage(messages.BUGS);
                    break;
            }
        }
        return false;
    }
}
