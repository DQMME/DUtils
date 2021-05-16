package de.dqmme.dutils.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventorys {
    public Inventory settingsHome() {
        Inventory inventory = Bukkit.createInventory(null, 27, "§6Einstellungen §7- §6Home");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .build();

        ItemStack dragonHead = new ItemBuilder(Material.DRAGON_HEAD)
                .setDisplayname("§cChallenges")
                .build();

        ItemStack book = new ItemBuilder(Material.WRITABLE_BOOK)
                .setDisplayname("§aGamerules")
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        inventory.setItem(12, dragonHead);
        inventory.setItem(14, book);

        return inventory;
    }

    public Inventory settingsChallenges() {
        Inventory inventory = Bukkit.createInventory(null, 27, "");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        return inventory;
    }

    public Inventory settingsGamerules() {
        Inventory inventory = Bukkit.createInventory(null, 27, "§6Home §7- §6Gamerules");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .build();

        ItemStack difficulty = new ItemBuilder(Material.IRON_SWORD)
                .setDisplayname("§aSchwierigkeit")
                .build();

        ItemStack pvp = new ItemBuilder(Material.DIAMOND_SWORD)
                .setDisplayname("§aPvP")
                .build();

        ItemStack damageMessages = new ItemBuilder(Material.REDSTONE_LAMP)
                .setDisplayname("§aSchadensnachrichten")
                .build();

        ItemStack soup = new ItemBuilder(Material.MUSHROOM_STEW)
                .setDisplayname("§aSuppenheilung")
                .build();

        ItemStack splitHealth = new ItemBuilder(Material.REDSTONE)
                .setDisplayname("§aGeteilte Leben")
                .build();

        ItemStack uhc = new ItemBuilder(Material.GOLDEN_APPLE)
                .setDisplayname("§aUltra-Hardcore")
                .build();

        ItemStack uuhc = new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE)
                .setDisplayname("§aUltra-Ultra-Hardcore")
                .build();

        ItemStack health = new ItemBuilder(Material.REDSTONE)
                .setDisplayname("§aMaximale Leben")
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        inventory.setItem(10, difficulty);
        inventory.setItem(11, pvp);
        inventory.setItem(12, damageMessages);
        inventory.setItem(13, soup);
        inventory.setItem(14, splitHealth);
        inventory.setItem(15, uhc);
        inventory.setItem(16, uuhc);
        inventory.setItem(19, health);

        return inventory;
    }
}
