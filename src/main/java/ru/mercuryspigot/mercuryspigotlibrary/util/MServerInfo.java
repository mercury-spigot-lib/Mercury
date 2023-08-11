package ru.mercuryspigot.mercuryspigotlibrary.util;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public class MServerInfo {

    private static JavaPlugin plugin;

    private static boolean initialized = false;

    public static void init(JavaPlugin plugin) {
        if (initialized) return;
        MServerInfo.plugin = plugin;
        startTpsTimer();
        startUptime();
        initialized = true;
    }

    // Uptime

    private static long startTime;

    private static void startUptime() {
        startTime = System.currentTimeMillis();
    }

    public static long getUptimeMillis() {
        return System.currentTimeMillis() - startTime;
    }

    public static long getUptimeSeconds() {
        return getUptimeMillis() / 1000;
    }

    public static long getUptime() {
        return getUptimeMillis();
    }

    // End Uptime

    // TPS

    private static TPSTimer tpsTimer;

    private static void startTpsTimer() {
        tpsTimer = new TPSTimer();
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(
                plugin, tpsTimer, 100L, 50L
        );
    }

    public static double getTPS() {
        return tpsTimer.get();
    }

    public static String getTPSString() {
        return String.format("%.1f", tpsTimer.get());
    }

    private static class TPSTimer implements Runnable {
        private transient long last;
        private final LinkedList<Double> history;

        TPSTimer() {
            this.last = System.nanoTime();
            (this.history = new LinkedList<>()).add(20.0);
        }

        @Override
        public void run() {
            final long startTime = System.nanoTime();
            long timeSpent = (startTime - this.last) / 1000L;
            if (timeSpent == 0L) {
                timeSpent = 1L;
            }
            if (this.history.size() > 6) {
                this.history.remove();
            }
            final double tps = 5.0E7 / timeSpent;
            if (tps <= 21.0) {
                this.history.add(tps);
            }
            this.last = startTime;
        }

        public double get() {
            double avg = 0.0;
            for (final Double f : this.history) {
                if (f != null) {
                    avg += f;
                }
            }
            return avg / this.history.size();
        }
    }

    // End TPS

}
