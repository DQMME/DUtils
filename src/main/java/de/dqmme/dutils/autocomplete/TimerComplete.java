package de.dqmme.dutils.autocomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TimerComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            List<String> args1 = new ArrayList<>();
            args1.add("start");
            args1.add("resume");
            args1.add("pause");
            args1.add("stop");
            args1.add("reset");
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
