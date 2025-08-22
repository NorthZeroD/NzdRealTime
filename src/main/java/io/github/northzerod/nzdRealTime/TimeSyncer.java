package io.github.northzerod.nzdRealTime;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;

public final class TimeSyncer extends BukkitRunnable{
    @Override
    public void run() {
        final LocalTime time = LocalTime.now();
        final int hour = time.getHour();
        final int minute = time.getMinute();
        final int second = time.getSecond();

        int offset = 0;
        final float gameTick = ((hour + 18) % 24 * 1000) + (5 / 18f * ((minute + offset) * 60 + second));

        for (World world : Bukkit.getWorlds()) {
            world.setTime((long) gameTick);
        }
    }
}
