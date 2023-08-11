package ru.mercuryspigot.mercuryspigotlibrary;

import org.bukkit.plugin.java.JavaPlugin;
import ru.mercuryspigot.mercuryspigotlibrary.util.MServerInfo;

public class Mercury {

    private static boolean initialized = false;

    public static void init(JavaPlugin plugin) {
        if (initialized) return;

        MServerInfo.init(plugin);

        initialized = true;
    }
}
