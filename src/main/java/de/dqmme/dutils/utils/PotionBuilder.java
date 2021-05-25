package de.dqmme.dutils.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;

public class PotionBuilder {
    private PotionMeta potionMeta;
    private ItemStack itemStack;
    public PotionBuilder(Material mat){
        itemStack = new ItemStack(mat);
        potionMeta = (PotionMeta) itemStack.getItemMeta();
    }
    public PotionBuilder setDisplayname(String s){
        potionMeta.setDisplayName(s);
        return this;
    }
    public PotionBuilder setLocalizedName(String s){
        potionMeta.setLocalizedName(s);
        return this;
    }
    public PotionBuilder setLore(String... s){
        potionMeta.setLore(Arrays.asList(s));
        return this;
    }
    public PotionBuilder addLore(String s){
        ArrayList<String> lore = (ArrayList<String>) potionMeta.getLore();
        if (lore == null)
            lore = new ArrayList<>();
        lore.add(s);
        potionMeta.setLore(lore);
        return this;
    }
    public PotionBuilder setUnbreakable(boolean s){
        potionMeta.setUnbreakable(s);
        return this;
    }
    public PotionBuilder addItemFlags(ItemFlag... s){
        potionMeta.addItemFlags(s);
        return this;
    }

    public PotionBuilder setPotionType(PotionType type) {
        potionMeta.setBasePotionData(new PotionData(type));
        return this;
    }

    @Override
    public String toString() {
        return "ItemBuilder{" +
                "itemMeta=" + potionMeta +
                ", itemStack=" + itemStack +
                '}';
    }
    public ItemStack build(){
        itemStack.setItemMeta(potionMeta);
        return itemStack;
    }
    public PotionBuilder enchant(Enchantment en , int level){
        itemStack.addUnsafeEnchantment(en , level);
        return this;
    }
}