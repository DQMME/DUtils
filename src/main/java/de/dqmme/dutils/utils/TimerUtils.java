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
        time = getTime();
        bukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§l" + shortInteger(time)));
                }
                time++;
            }
        };
        bukkitRunnable.runTaskTimer(DUtils.getPlugin(DUtils.class), 0, 20);
    }

    public void stopTimer() {
        DUtils.getPlugin(DUtils.class).timerConf.set("Time", time);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
        bukkitRunnable.cancel();
    }

    public void setTime(int time) {
       DUtils.getPlugin(DUtils.class).timerConf.set("Time", time);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).timerConf, DUtils.getPlugin(DUtils.class).timer);
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
