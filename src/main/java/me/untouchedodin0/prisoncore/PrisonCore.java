package me.untouchedodin0.prisoncore;

import co.aikar.commands.PaperCommandManager;
import me.untouchedodin0.prisoncore.config.Config;
import me.untouchedodin0.prisoncore.events.rankup.PlayerRankupEvent;
import me.untouchedodin0.prisoncore.modules.booster.Boosters;
import me.untouchedodin0.prisoncore.modules.ranks.Ranks;
import me.untouchedodin0.prisoncore.modules.ranks.config.RanksConfig;
import me.untouchedodin0.prisoncore.utils.rank.RankMaterial;
import me.untouchedodin0.prisoncore.utils.Utils;
import me.untouchedodin0.privatemines.PrivateMines;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.config.ConfigManager;

import java.util.LinkedHashMap;

public class PrisonCore extends JavaPlugin {

    public static PrisonCore prisonCore;
    public static PrivateMines privateMines;

    public static PaperCommandManager paperCommandManager;

    private final LinkedHashMap<String, Module> modules = new LinkedHashMap<>();

    @Override
    public void onEnable() {
        getLogger().info(String.format("PrisonCore v%s has been enabled!", getDescription().getVersion()));
        prisonCore = this;
        privateMines = PrivateMines.getPrivateMines();
        paperCommandManager = new PaperCommandManager(this);

        // Load modules
        loadModule(new Ranks());
        loadModule(new Boosters());

        // Save default configs for the modules
        saveDefaultConfig();
        saveDefaultConfigs();
        getServer().getPluginManager().registerEvents(new PlayerRankupEvent(), this);

        ConfigManager configManager = ConfigManager.create(this).addConverter(Material.class, Material::valueOf, Material::toString).target(Config.class).load();

        prisonCore.getLogger().info("" + RankMaterial.getRankMaterialMap());
        prisonCore.getLogger().info("" + RanksConfig.percentageIncrease);
        prisonCore.getLogger().info("" + RanksConfig.rankMaterials);
    }

    @Override
    public void onDisable() {
        for (Module module : modules.values()) {
            prisonCore.getLogger().info(String.format("Disabling module %s", module.getName()));
            unloadModule(module);
        }
        getLogger().info(String.format("PrisonCore v%s has been disabled!", getDescription().getVersion()));
    }

    public static PrisonCore getInstance() {
        return prisonCore;
    }

    public static PrivateMines getPrivateMines() {
        return privateMines;
    }

    public static PaperCommandManager getPaperCommandManager() {
        return paperCommandManager;
    }

    private void loadModule(Module module) {
        prisonCore.getLogger().info(String.format("Loading module %s v%s",
                                                  module.getName(),
                                                  module.getVersion()));
        module.onEnable();
        modules.put(module.getName(), module);
    }

    private void unloadModule(Module module) {
        module.onDisable();
        modules.remove(module.getName());
    }

    public LinkedHashMap<String, Module> getModules() {
        return modules;
    }

    public void saveDefaultConfigs() {
        for (Module module : modules.values()) {
            prisonCore.getLogger().info(String.format("Saving default config for module %s", module.getName()));
            module.saveDefaultConfig();
        }
    }
}
