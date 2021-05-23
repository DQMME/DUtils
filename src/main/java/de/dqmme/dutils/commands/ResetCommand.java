package de.dqmme.dutils.commands;

import de.dqmme.dutils.utils.ConfigUtils;
import de.dqmme.dutils.utils.Inventorys;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    private final Inventorys inventorys = new Inventorys();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("dutils.reset") || sender.hasPermission("dutils.*")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.openInventory(inventorys.reset());
            }
        }
        return false;
    }
}
