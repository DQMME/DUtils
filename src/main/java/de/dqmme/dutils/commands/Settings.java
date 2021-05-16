package de.dqmme.dutils.commands;

import de.dqmme.dutils.utils.Inventorys;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Settings implements CommandExecutor {
    private final Inventorys inventorys = new Inventorys();
    private final Messages messages = new Messages();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("dutils.settings")) {
                player.openInventory(inventorys.settingsHome());
            } else {
                player.sendMessage(messages.NO_PERM);
            }
        } else {
            sender.sendMessage(messages.NOT_A_PLAYER);
        }
        return false;
    }
}
