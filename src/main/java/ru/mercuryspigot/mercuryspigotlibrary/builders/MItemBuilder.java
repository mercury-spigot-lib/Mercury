package ru.mercuryspigot.mercuryspigotlibrary.builders;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ru.mercuryspigot.mercuryspigotlibrary.util.MChatUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MItemBuilder {

    private MItemBuilder() {}

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public static MItemBuilder open(ItemStack itemStack) {
        MItemBuilder MItemBuilder = new MItemBuilder();

        MItemBuilder.itemStack = itemStack.clone();
        MItemBuilder.itemMeta = itemStack.getItemMeta();

        return MItemBuilder;
    }

    public MItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    public MItemBuilder(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public MItemBuilder(Block block, int amount) {
        itemStack = new ItemStack(block.getType(), amount);
        itemMeta = itemStack.getItemMeta();
    }

    public MItemBuilder(Block block) {
        itemStack = new ItemStack(block.getType());
        itemMeta = itemStack.getItemMeta();
    }

    public MItemBuilder displayName(String value) {
        itemMeta.setDisplayName(value);

        return this;
    }

    public MItemBuilder setLore(List<String> lore) {

        itemMeta.setLore(MChatUtil.format(lore));

        return this;
    }

    public MItemBuilder setLore(String[] lore) {

        itemMeta.setLore(Arrays.asList(MChatUtil.format(lore)));

        return this;
    }

    public MItemBuilder setLore(String lore) {

        itemMeta.setLore(Collections.singletonList(MChatUtil.format(lore)));

        return this;
    }

    public MItemBuilder setLore(List<String> lore, Map<String, String> placeholdersMap) {

        itemMeta.setLore(MChatUtil.applyPlaceholders(lore, placeholdersMap));

        return this;
    }

    public MItemBuilder setLore(String[] lore, Map<String, String> placeholdersMap) {

        itemMeta.setLore(Arrays.asList(MChatUtil.applyPlaceholders(lore, placeholdersMap)));

        return this;
    }

    public MItemBuilder setLore(String lore, Map<String, String> placeholdersMap) {

        itemMeta.setLore(Collections.singletonList(MChatUtil.applyPlaceholders(lore, placeholdersMap)));

        return this;
    }

    public MItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        itemMeta.addEnchant(enchantment, lvl, true);
        return this;
    }

    public MItemBuilder removeEnchantment(Enchantment enchantment) {
        itemMeta.removeEnchant(enchantment);
        return this;
    }

    @Deprecated
    public MItemBuilder addEnchantment(String enchantment, int lvl) {
        itemMeta.addEnchant(Enchantment.getByName(enchantment), lvl, true);
        return this;
    }

    @Deprecated
    public MItemBuilder removeEnchantment(String enchantment) {
        itemMeta.removeEnchant(Enchantment.getByName(enchantment));
        return this;
    }

    public MItemBuilder setUnbreakable(boolean b) {
        itemMeta.setUnbreakable(b);
        return this;
    }

    public MItemBuilder addItemFlags(ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public MItemBuilder removeItemFlags(ItemFlag... itemFlags) {
        itemMeta.removeItemFlags(itemFlags);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
