package me.untouchedodin0.prisoncore.utils.rank;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public enum RankMaterial {

    ONE(Material.IRON_SWORD),
    TWO(Material.DIAMOND),
    THREE(Material.GOLDEN_SWORD),
    FOUR(Material.IRON_AXE),
    FIVE(Material.DIAMOND_AXE),
    SIX(Material.GOLDEN_AXE),
    SEVEN(Material.IRON_HOE),
    EIGHT(Material.DIAMOND_HOE),
    NINE(Material.GOLDEN_HOE),
    TEN(Material.IRON_PICKAXE),
    ELEVEN(Material.DIAMOND_PICKAXE),
    TWELVE(Material.GOLDEN_PICKAXE),
    THIRTEEN(Material.IRON_SHOVEL),
    FOURTEEN(Material.DIAMOND_SHOVEL),
    FIFTEEN(Material.GOLDEN_SHOVEL);

    public final Material material;
    private static final Map<Material, RankMaterial> RANK_MATERIAL_MAP = new HashMap<>();

    static {
        for (RankMaterial rankMaterial : values()) {
            RANK_MATERIAL_MAP.put(rankMaterial.getMaterial(), rankMaterial);
        }
    }

    RankMaterial(Material material) {
        this.material = material;
    }

    private Material getMaterial() {
        return material;
    }

    public static Material getMaterial(RankMaterial rankMaterial) {
        return rankMaterial.getMaterial();
    }

    public static Map<Material, RankMaterial> getRankMaterialMap() {
        return RANK_MATERIAL_MAP;
    }
}