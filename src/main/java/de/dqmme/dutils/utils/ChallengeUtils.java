package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChallengeUtils {
    public void setRandomItem(boolean randomItem) {
        if(randomItem) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eRandom-Item Challenge §agestartet.", "§7Die §eRandom-Item Challenge §7ist §agestartet§7. §a§lViel Glück!", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eRandom-Item Challenge §cdeaktiviert.", "§7Die §eRandom-Item Challenge §7wurde §cgestoppt§7.", 5, 60, 5);
            }
        }

        DUtils.getPlugin(DUtils.class).challengesConf.set("Random-Item", randomItem);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).challengesConf, DUtils.getPlugin(DUtils.class).challenges);
    }

    public boolean getRandomItem() {
        return DUtils.getPlugin(DUtils.class).challengesConf.getBoolean("Random-Item");
    }

    public void setInvSync(boolean invSync) {
        if(invSync) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eInventory-Sync Challenge §agestartet.", "§7Die §eInventory-Sync Challenge §7ist §agestartet§7. §a§lViel Glück!", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eInventory-Sync Challenge §cdeaktiviert.", "§7Die §eInventory-Sync Challenge §7wurde §cgestoppt§7.", 5, 60, 5);
            }
        }

        DUtils.getPlugin(DUtils.class).challengesConf.set("Inv-Sync", invSync);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).challengesConf, DUtils.getPlugin(DUtils.class).challenges);
    }

    public boolean getInvSync() {
        return DUtils.getPlugin(DUtils.class).challengesConf.getBoolean("Inv-Sync");
    }

    public void setRandomEffect(boolean randomEffect) {
        if(randomEffect) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eRandom-Effect Challenge §agestartet.", "§7Die §eRandom-Effect Challenge §7ist §agestartet§7. §a§lViel Glück!", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eRandom-Effect Challenge §cdeaktiviert.", "§7Die §eRandom-Effect Challenge §7wurde §cgestoppt§7.", 5, 60, 5);
            }
        }

        DUtils.getPlugin(DUtils.class).challengesConf.set("Random-Effect", randomEffect);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).challengesConf, DUtils.getPlugin(DUtils.class).challenges);
    }

    public boolean getRandomEffect() {
        return DUtils.getPlugin(DUtils.class).challengesConf.getBoolean("Random-Effect");
    }
}
