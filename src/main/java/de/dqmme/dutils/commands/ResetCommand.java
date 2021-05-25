package de.dqmme.dutils.commands;

import de.dqmme.dutils.utils.ConfigUtils;
import de.dqmme.dutils.utils.Inventorys;
import de.dqmme.dutils.utils.TimerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    private final Inventorys inventorys = new Inventorys();
    private final ConfigUtils configUtils = new ConfigUtils();
    private final TimerUtils timerUtils = new TimerUtils();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("dutils.reset") || sender.hasPermission("dutils.*")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.openInventory(inventorys.reset());
            } else {
                configUtils.setReset(true);
                timerUtils.startTimer();
                timerUtils.stopTimer();
                timerUtils.resetTimer();
                timerUtils.setPaused();
                timerUtils.saveTime();
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer("§8§l§m              §r§8[§6DUtils §7- §6Reset§8]§m§l              " +
                            "\n" +
                            "§e§l" + "Die Kosole" + " §7hat einen Welten-Reset veranlasst." +
                            "\n" +
                            "§7Der Server sollte in §ec.a. 1 Minute §7wieder erreichbar sein." +
                            "\n" +
                            "§8§m§l                                           ");
                }
                Bukkit.getServer().spigot().restart();
            }
        }
        return false;
    }
}
