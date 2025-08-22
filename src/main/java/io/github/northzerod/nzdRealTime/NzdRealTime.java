package io.github.northzerod.nzdRealTime;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class NzdRealTime extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new GameRuleListener(), this);

        changeRuleOnce();
        new TimeSyncer().runTaskTimer(this, 0, 20);

        this.getLogger().info("插件 NzdRealTime 已启用");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("插件 NzdRealTime 已禁用");
    }

    public static JavaPlugin getInstance() {
        return (JavaPlugin) Bukkit.getPluginManager().getPlugin("NzdRealTime");
    }

    public void changeRuleOnce() {
        for (World world : Bukkit.getWorlds()) {
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        }
    }
}
