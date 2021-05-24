package de.dqmme.dutils.commands;

import de.dqmme.dutils.utils.Inventorys;
import de.dqmme.dutils.utils.Messages;
import de.dqmme.dutils.utils.TimerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {
    private final Messages messages = new Messages();
    private final TimerUtils timerUtils = new TimerUtils();
    private final Inventorys inventorys = new Inventorys();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("dutils.timer") || sender.hasPermission("dutils.*")) {
            if(args.length == 1) {
                switch (args[0].toLowerCase()) {
                    case "start":
                    case "resume":
                        timerUtils.startTimer();
                        sender.sendMessage(messages.TIMER_STARTED);
                        break;
                    case "pause":
                    case "stop":
                        timerUtils.stopTimer();
                        sender.sendMessage(messages.TIMER_PAUSED);
                        break;
                    case "reset":
                        timerUtils.resetTimer();
                        sender.sendMessage(messages.TIMER_RESETTED);
                        break;
                }
            } else {
                if(sender instanceof Player) {
                    Player player = (Player) sender;

                    player.openInventory(inventorys.timer());
                } else {
                    sender.sendMessage(messages.PREFIX + "§7Die Konsole kann kein Inventar öffnen. Verwende für den Timer einfach §e/timer <resume/pause/reset>§7.");
                }
            }
        }
        return false;
    }
}
