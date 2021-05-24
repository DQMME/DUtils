package de.dqmme.dutils.autocomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ResetComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length > 0) {
            List<String> args1 = new ArrayList<>();
            args1.add("");
            return args1;
        }
        return null;
    }
}
