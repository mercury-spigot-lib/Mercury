package ru.mercuryspigot.mercuryspigotlibrary;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MJavaPlugin extends JavaPlugin {

    protected static MJavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static MJavaPlugin getInstance() {
        return instance;
    }

    public static Server getBukkitServer() {
        return instance.getServer();
    }

    public static FileConfiguration getCfg() {
        return instance.getConfig();
    }

    public static void reloadCfg() {
        instance.reloadConfig();
    }

    public static Object getCfgItem(String path) {
        return getCfg().get(path);
    }

    public static Object getCfgItem(String path, Object def) {
        return getCfg().get(path, def);
    }

    public static String getCfgString(String path) {
        return getCfg().getString(path);
    }

    public static String getCfgString(String path, String def) {
        return getCfg().getString(path, def);
    }

    public static String getCfgStringColored(String path) {
        return ChatColor.translateAlternateColorCodes('&', getCfg().getString(path));
    }

    public static String getCfgStringColored(String path, String def) {
        return ChatColor.translateAlternateColorCodes('&', getCfg().getString(path, def));
    }

    public static String getCfgStringColored(String path, char altColorChar) {
        return ChatColor.translateAlternateColorCodes(altColorChar, getCfg().getString(path));
    }

    public static String getCfgStringColored(String path, String def, char altColorChar) {
        return ChatColor.translateAlternateColorCodes(altColorChar, getCfg().getString(path, def));
    }

    public static int getCfgInt(String path) {
        return getCfg().getInt(path);
    }

    public static int getCfgInt(String path, int def) {
        return getCfg().getInt(path, def);
    }

    public static long getCfgLong(String path) {
        return getCfg().getLong(path);
    }

    public static long getCfgLong(String path, long def) {
        return getCfg().getLong(path, def);
    }

    public static double getCfgDouble(String path) {
        return getCfg().getDouble(path);
    }

    public static double getCfgDouble(String path, double def) {
        return getCfg().getDouble(path, def);
    }

    public static boolean getCfgBoolean(String path) {
        return getCfg().getBoolean(path);
    }

    public static boolean getCfgBoolean(String path, boolean def) {
        return getCfg().getBoolean(path, def);
    }

    public static ItemStack getCfgItemStack(String path) {
        return getCfg().getItemStack(path);
    }

    public static ItemStack getCfgItemStack(String path, ItemStack def) {
        return getCfg().getItemStack(path, def.clone());
    }

    public static Vector getCfgVector(String path) {
        return getCfg().getVector(path);
    }

    public static Vector getCfgVector(String path, Vector def) {
        return getCfg().getVector(path, def.clone());
    }

    public static Color getCfgColor(String path) {
        return getCfg().getColor(path);
    }

    public static Color getCfgColor(String path, Color def) {
        return getCfg().getColor(path, def);
    }

    public static List<?> getCfgList(String path) {
        return getCfg().getList(path);
    }

    public static List<?> getCfgList(String path, List<?> def) {
        return getCfg().getList(path, def);
    }

    public static List<String> getCfgStringList(String path) {
        return getCfg().getStringList(path);
    }

    public static List<String> getCfgStringList(String path, List<String> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getStringList(path);
    }

    public static List<Integer> getCfgIntegerList(String path) {
        return getCfg().getIntegerList(path);
    }

    public static List<Integer> getCfgIntegerList(String path, List<Integer> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getIntegerList(path);
    }

    public static List<Long> getCfgLongList(String path) {
        return getCfg().getLongList(path);
    }

    public static List<Long> getCfgLongList(String path, List<Long> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getLongList(path);
    }

    public static List<Double> getCfgDoubleList(String path) {
        return getCfg().getDoubleList(path);
    }

    public static List<Double> getCfgDoubleList(String path, List<Double> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getDoubleList(path);
    }

    public static List<Boolean> getCfgBooleanList(String path) {
        return getCfg().getBooleanList(path);
    }

    public static List<Boolean> getCfgBooleanList(String path, List<Boolean> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getBooleanList(path);
    }

    public static List<Byte> getCfgByteList(String path) {
        return getCfg().getByteList(path);
    }

    public static List<Byte> getCfgByteList(String path, List<Byte> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getByteList(path);
    }

    public static List<Character> getCfgCharacterList(String path) {
        return getCfg().getCharacterList(path);
    }

    public static List<Character> getCfgCharaterList(String path, List<Character> def) {
        if (getCfgList(path) == null) {
            return new ArrayList<>(def);
        }
        return getCfg().getCharacterList(path);
    }

    public static Set<String> getCfgKeys() {
        return getCfg().getKeys(false);
    }

    public static Set<String> getCfgKeys(boolean deep) {
        return getCfg().getKeys(deep);
    }

    public static Map<String, Object> getCfgValues() {
        return getCfg().getValues(false);
    }

    public static Map<String, Object> getCfgValues(boolean deep) {
        return getCfg().getValues(deep);
    }
}
