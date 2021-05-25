package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerUtils {
    public int time;
    public BukkitRunnable bukkitRunnable;

    public void startTimer() {
        if(!isRunning()) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§aTimer gestartet.", "§7Der §eTimer §7wurde §agestartet.", 5, 60, 5);
            }

            time = getTime();
            bukkitRunnable = new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§l" + shortInteger(time)));
                    }
                    setRunning();
                    time++;
                }
            };
            bukkitRunnable.runTaskTimer(DUtils.getPlugin(DUtils.class), 0, 20);
        }
    }


    public void stopTimer() {
        setPaused();

        for(Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle("§cTimer gestoppt.", "§7Der §eTimer §7wurde §cgestoppt.", 5, 60, 5);
        }
        DUtils.getPlugin(DUtils.class).timerConf.set("Time", time);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
        bukkitRunnable.cancel();
    }

    public void resetTimer() {
       DUtils.getPlugin(DUtils.class).timerConf.set("Time", 0);
       DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
       time = 0;
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle("§eTimer zurückgesetzt.", "§7Der §eTimer §7wurde §ezurückgesetzt.", 5, 60, 5);
        }
    }

    public int getTime() {
        if(DUtils.getPlugin(DUtils.class).timerConf.get("Time") == null) {
            return 0;
        } else {
            return DUtils.getPlugin(DUtils.class).timerConf.getInt("Time");
        }
    }

    public void saveTime() {
        DUtils.getPlugin(DUtils.class).timerConf.set("Time", time);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
    }

    public void setPaused() {
        DUtils.getPlugin(DUtils.class).timerConf.set("Timer-Running", false);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
    }

    public void setRunning() {
        DUtils.getPlugin(DUtils.class).timerConf.set("Timer-Running", true);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
    }

    public boolean isRunning() {
        return DUtils.getPlugin(DUtils.class).timerConf.getBoolean("Timer-Running");
    }

    public String shortInteger(int duration) {
        String string = "";
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if (duration / 60 / 60 / 24 >= 1) {
            duration -= duration / 60 / 60 / 24 * 60 * 60 * 24;
        }
        if (duration / 60 / 60 >= 1) {
            hours = duration / 60 / 60;
            duration -= duration / 60 / 60 * 60 * 60;
        }
        if (duration / 60 >= 1) {
            minutes = duration / 60;
            duration -= duration / 60 * 60;
        }
        if (duration >= 1)
            seconds = duration;
        if (hours == 0) {
            string = "";
        } else if(hours == 1) {
            string = string + hours + " Stunde ";
        } else {
            string = string + hours + " Stunden ";
        }
        if (minutes == 0) {
            string = "";
        } else if(minutes == 1) {
            string = string + minutes + " Minute ";
        } else {
            string = string + minutes + " Minuten ";
        }
        if (seconds == 0) {
            string = "";
        } else if(seconds == 1) {
            string = string + seconds + " Sekunde";
        } else {
            string = string + seconds + " Sekunden";
        }
        return string;
    }
}
