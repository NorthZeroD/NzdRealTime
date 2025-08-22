package io.github.northzerod.nzdRealTime;

import io.papermc.paper.event.world.WorldGameRuleChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class GameRuleListener implements Listener {
    @EventHandler
    public void onWorldGameRuleChange(WorldGameRuleChangeEvent event) {
        if (event.getGameRule() == GameRule.DO_DAYLIGHT_CYCLE && event.getValue().equals("true")) {

            Bukkit.getScheduler().runTask(NzdRealTime.getInstance(), () -> {
                event.getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);

                if (event.getCommandSender() != null) {
                    event.getCommandSender().sendPlainMessage("要将规则 doDaylightCycle 更改为 true，请先禁用 NzdRealTime 插件。已重新设置 doDaylightCycle 为 false。");
                }
            });
        }
    }
}
