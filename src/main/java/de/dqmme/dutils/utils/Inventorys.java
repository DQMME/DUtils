package de.dqmme.dutils.utils;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode;

public class Inventorys {
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final ChallengeUtils challengeUtils = new ChallengeUtils();

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
        String isRandomItem;
        if(challengeUtils.getRandomItem()) {
            isRandomItem = "§7Aktuell: §aaktiviert";
        } else {
            isRandomItem = "§7Aktuell: §cdeaktiviert";
        }

        String randomItemFirst;
        if(challengeUtils.getRandomItem()) {
            randomItemFirst = "§cdeaktivieren";
        } else {
            randomItemFirst = "§aaktivieren";
        }

        Inventory inventory = Bukkit.createInventory(null, 27, "§6Settings §7- §6Challenges");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .addLore("§7Kehre zurück auf die letzte Seite.")
                .build();

        ItemStack randomItem = new ItemBuilder(Material.COMMAND_BLOCK)
                .setDisplayname("§aRandom-Item")
                .addLore("§aBeschreibung:")
                .addLore("§7Erhalte alle 10 Sekunden ein zufälliges §aItem.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + randomItemFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore(isRandomItem)
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        inventory.setItem(10, randomItem);

        return inventory;
    }

    public Inventory settingsGamerules() {
        String difficultyFirst;
        String difficultySecond;
        if(gameruleUtils.getDifficulty().equals(Difficulty.PEACEFUL)) {
            difficultyFirst = "§7Linksklick: §eEASY";
            difficultySecond = "§7Rechtsklick: §eHARD";
        } else if(gameruleUtils.getDifficulty().equals(Difficulty.EASY)) {
            difficultyFirst = "§7Linksklick: §eNORMAL";
            difficultySecond = "§7Rechtsklick: §ePEACEFUL";
        } else if(gameruleUtils.getDifficulty().equals(Difficulty.NORMAL)) {
            difficultyFirst = "§7Linksklick: §eHARD";
            difficultySecond = "§7Rechtsklick: §eEASY";
        } else if(gameruleUtils.getDifficulty().equals(Difficulty.HARD)) {
            difficultyFirst = "§7Linksklick: §ePEACEFUL";
            difficultySecond = "§7Rechtsklick: §eNORMAL";
        } else {
            difficultyFirst = "§cFEHLER";
            difficultySecond = "§cFEHLER";
        }

        String isPvP;
        if(gameruleUtils.getPvP()) {
            isPvP = "§aaktiviert";
        } else {
            isPvP = "§cdeaktiviert";
        }

        String pvpFirst;
        if(gameruleUtils.getPvP()) {
            pvpFirst = "§cdeaktivieren";
        } else {
            pvpFirst = "§aaktivieren";
        }

        String isDamageMessages;
        if(gameruleUtils.getDamageMessages()) {
            isDamageMessages = "§aaktiviert";
        } else {
            isDamageMessages = "§cdeaktiviert";
        }

        String damageMessagesFirst;
        if(gameruleUtils.getDamageMessages()) {
            damageMessagesFirst = "§cdeaktivieren";
        } else {
            damageMessagesFirst = "§aaktivieren";
        }

        String isSoup;
        if(gameruleUtils.getSoup()) {
            isSoup = "§aaktiviert";
        } else {
            isSoup = "§cdeaktiviert";
        }

        String soupFirst;
        if(gameruleUtils.getSoup()) {
            soupFirst = "§cdeaktivieren";
        } else {
            soupFirst = "§aaktivieren";
        }

        String isSplitHealth;
        if(gameruleUtils.getSplitHealth()) {
            isSplitHealth = "§aaktiviert";
        } else {
            isSplitHealth = "§cdeaktiviert";
        }

        String splitHealthFirst;
        if(gameruleUtils.getSplitHealth()) {
            splitHealthFirst = "§cdeaktivieren";
        } else {
            splitHealthFirst = "§aaktivieren";
        }

        String isUHC;
        if(gameruleUtils.getUHC()) {
            isUHC = "§cdeaktiviert";
        } else {
            isUHC = "§aaktiviert";
        }

        String uhcFirst;
        if(gameruleUtils.getUHC()) {
            uhcFirst = "§aaktivieren";
        } else
            uhcFirst = "§cdeaktivieren";

        String isUUHC;
        if(gameruleUtils.getUUHC()) {
            isUUHC = "§aaktiviert";
        } else {
            isUUHC = "§cdeaktiviert";
        }

        String uuhcFirst;
        if(gameruleUtils.getUUHC()) {
            uuhcFirst = "§cdeaktivieren";
        } else {
            uuhcFirst = "§aaktivieren";
        }

        int maxHealthHPLeft;
        int maxHealthHeartsLeft;
        int maxHealthHPRight = gameruleUtils.getMaxHealth() - 2;
        int maxHealthHeartsRight = (gameruleUtils.getMaxHealth() - 2) / 2;
        if(gameruleUtils.getMaxHealth() == 48) {
            maxHealthHeartsLeft = 24;
            maxHealthHPLeft = 48;
        } else {
            maxHealthHeartsLeft = (gameruleUtils.getMaxHealth() + 2) / 2;
            maxHealthHPLeft = gameruleUtils.getMaxHealth() + 2;
        }

        int maxHealthHP = gameruleUtils.getMaxHealth();
        int maxHealthHearts = gameruleUtils.getMaxHealth() / 2;

        Inventory inventory = Bukkit.createInventory(null, 36, "§6Settings §7- §6Gamerules");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .addLore("§7Kehre zurück auf die letzte Seite.")
                .build();

        ItemStack difficulty = new ItemBuilder(Material.IRON_SWORD)
                .setDisplayname("§aSchwierigkeit")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §aSchwierigkeit §7um.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore(difficultyFirst)
                .addLore(difficultySecond)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: §e" + gameruleUtils.getDifficulty().toString())
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .build();

        ItemStack pvp = new ItemBuilder(Material.DIAMOND_SWORD)
                .setDisplayname("§aPvP")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte das §aPvP §7zwischen Spielern ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + pvpFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isPvP)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .build();

        ItemStack damageMessages = new ItemBuilder(Material.REDSTONE_LAMP)
                .setDisplayname("§aSchadensnachrichten")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §aSchadensnachrichten §7ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + damageMessagesFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isDamageMessages)
                .build();

        ItemStack soup = new ItemBuilder(Material.MUSHROOM_STEW)
                .setDisplayname("§aSuppenheilung")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §aSuppenheilung §7ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + soupFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isSoup)
                .build();

        ItemStack splitHealth = new ItemBuilder(Material.REDSTONE)
                .setDisplayname("§aGeteilte Leben")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §ageteilten Leben §7ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + splitHealthFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isSplitHealth)
                .build();

        ItemStack uhc = new ItemBuilder(Material.GOLDEN_APPLE)
                .setDisplayname("§aUltra-Hardcore")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §anatürliche Regeneration §7ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + uhcFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isUHC)
                .build();

        ItemStack uuhc = new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE)
                .setDisplayname("§aUltra-Ultra-Hardcore")
                .addLore("§aBeschreibung:")
                .addLore("§7Schalte die §akomplette Regeneration §7ein/aus.")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Links/Rechtsklick: " + uuhcFirst)
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: " + isUUHC)
                .build();

        ItemStack health = new ItemBuilder(Material.REDSTONE)
                .setDisplayname("§aMaximale Leben")
                .addLore("§aBeschreibung:")
                .addLore("§7Setze die §amaximalen Leben §7hoch/runter.")
                .addLore("§7§lMaximal: §c§l48 HP §7§l/ §c§l24 Herzen")
                .addLore("")
                .addLore("§aFunktion:")
                .addLore("§7Linksklick: §c" + maxHealthHPLeft + " HP§7/ §c" + maxHealthHeartsLeft + " Herzen")
                .addLore("§7Rechtsklick: §c" + maxHealthHPRight + " HP§7/ §c" + maxHealthHeartsRight + " Herzen")
                .addLore("")
                .addLore("§aStatus:")
                .addLore("§7Aktuell: §c" + maxHealthHP + " HP§7/ §c" + maxHealthHearts + " Herzen")
                .build();

        for(int i = 0; i <= 35; i++) {
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

    public Inventory reset() {
        Inventory inventory = Bukkit.createInventory(null, 27, "§6DUtils §7- §6Reset");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .build();

        ItemStack accept = new ItemBuilder(Material.GREEN_CONCRETE)
                .setDisplayname("§aWelten resetten")
                .addLore("§7Setze alle Welten zurück und starte den Server neu.")
                .build();

        ItemStack decline = new ItemBuilder(Material.RED_CONCRETE)
                .setDisplayname("§cAbbrechen")
                .addLore("§7Setze die Welten nicht zurück.")
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        inventory.setItem(12, decline);
        inventory.setItem(14, accept);

        return inventory;
    }

    public Inventory timer() {
        Inventory inventory = Bukkit.createInventory(null, 27, "§6DUtils §7- §6Timer");

        ItemStack blackGlass = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayname("§c")
                .build();

        ItemStack stop = new ItemBuilder(Material.RED_CONCRETE)
                .setDisplayname("§cTimer stoppen")
                .addLore("§cStoppe §7den Timer.")
                .build();

        ItemStack start = new ItemBuilder(Material.GREEN_CONCRETE)
                .setDisplayname("§aTimer starten")
                .addLore("§aStarte §7den Timer.")
                .build();

        ItemStack reset = new ItemBuilder(Material.YELLOW_CONCRETE)
                .setDisplayname("§eTimer zurücksetzen")
                .addLore("§eSetze §7den Timer zurück.")
                .build();

        for(int i = 0; i <= 26; i++) {
            inventory.setItem(i, blackGlass);
        }

        inventory.setItem(11, stop);
        inventory.setItem(13, start);
        inventory.setItem(15, reset);

        return inventory;
    }
}
