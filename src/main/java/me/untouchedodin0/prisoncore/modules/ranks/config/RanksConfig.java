package me.untouchedodin0.prisoncore.modules.ranks.config;

import org.bukkit.Material;
import redempt.redlib.config.annotations.ConfigMappable;

import java.util.HashMap;
import java.util.Map;

@ConfigMappable
public class RanksConfig {

    public static double firstRankPrice = 0.0;
    public static double percentageIncrease = 0.0;

    public static Map<Material, Double> rankMaterials = new HashMap<>();
}
