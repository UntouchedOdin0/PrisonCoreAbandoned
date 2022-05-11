package me.untouchedodin0.prisoncore.modules.booster;

import co.aikar.commands.PaperCommandManager;
import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;
import me.untouchedodin0.prisoncore.modules.booster.commands.BoosterCommand;
import me.untouchedodin0.prisoncore.modules.booster.commands.GiveBoosterCommand;
import me.untouchedodin0.prisoncore.modules.booster.listener.BoosterRedeemListener;
import me.untouchedodin0.prisoncore.modules.ranks.commands.RanksCommand;

public class Boosters implements Module {

    PrisonCore prisonCore = PrisonCore.getInstance();
    PaperCommandManager paperCommandManager;
    boolean enabled = false;

    @Override
    public String getName() {
        return "Boosters";
    }

    @Override
    public String getDescription() {
        return "Boosters module";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getAuthor() {
        return "UntouchedOdin0";
    }

    @Override
    public void onEnable() {
        prisonCore.getLogger().info(String.format("Module %s v%s has been enabled!", getName(), getVersion()));
        enabled = true;
        paperCommandManager = PrisonCore.getPaperCommandManager();
        prisonCore.getLogger().info(String.format("Registering commands for module %s v%s...", getName(), getVersion()));
        paperCommandManager.registerCommand(new BoosterCommand());
        paperCommandManager.registerCommand(new GiveBoosterCommand());
        prisonCore.getServer().getPluginManager().registerEvents(new BoosterRedeemListener(), prisonCore);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onReload() {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void saveDefaultConfig() {

    }
}
