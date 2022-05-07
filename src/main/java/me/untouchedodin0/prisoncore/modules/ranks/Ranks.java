package me.untouchedodin0.prisoncore.modules.ranks;

import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;
import me.untouchedodin0.prisoncore.modules.ranks.config.RanksConfig;
import org.bukkit.Material;
import redempt.redlib.config.ConfigManager;

public class Ranks implements Module {

    PrisonCore prisonCore = PrisonCore.getInstance();
    boolean enabled = false;

    @Override
    public String getName() {
        return "Ranks";
    }

    @Override
    public String getDescription() {
        return "Ranks module";
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
        prisonCore.getLogger().info(String.format("%s v%s has been enabled!", getName(), getVersion()));
        enabled = true;
    }

    @Override
    public void onDisable() {
        prisonCore.getLogger().info(String.format("%s v%s has been disabled!", getName(), getVersion()));
        enabled = false;
    }

    @Override
    public void onReload() {

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void saveDefaultConfig() {
        ConfigManager configManager = ConfigManager
                .create(prisonCore, "ranks.yml")
                .addConverter(Material.class, Material::valueOf, Material::toString)
                .target(RanksConfig.class)
                .saveDefaults()
                .load();
    }
}
