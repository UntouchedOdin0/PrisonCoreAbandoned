package me.untouchedodin0.prisoncore.utils.builders;

import me.untouchedodin0.prisoncore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;

import java.util.List;

public class BoosterItemBuilder {

    private Material material;
    private String displayName;
    private List<String> lore;
    private String type;
    private int time;

    public BoosterItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public BoosterItemBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public BoosterItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public BoosterItemBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public BoosterItemBuilder setTime(int time) {
        this.time = time;
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(Utils.color(displayName));
            meta.setLore(Utils.color(lore));
            meta.getCustomTagContainer().setCustomTag(Utils.TYPE_KEY, ItemTagType.STRING, type);
            meta.getCustomTagContainer().setCustomTag(Utils.TIME_KEY, ItemTagType.INTEGER, time);
        }
        item.setItemMeta(meta);
        return item;
    }
}
