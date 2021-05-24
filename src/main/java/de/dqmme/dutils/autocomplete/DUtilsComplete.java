package de.dqmme.dutils.autocomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class DUtilsComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            List<String> args1 = new ArrayList<>();
            args1.add("permissions");
            args1.add("bugs");
            args1.add("reset");
            args1.add("source");
            return args1;
        }
        if(args.length > 1) {
            List<String> args2 = new ArrayList<>();
            args2.add("");
            return args2;
        }
        return null;
    }
}
