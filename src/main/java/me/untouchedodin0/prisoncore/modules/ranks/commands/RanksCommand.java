package me.untouchedodin0.prisoncore.modules.ranks.commands;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.untouchedodin0.prisoncore.utils.rank.RankMaterial;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import redempt.redlib.inventorygui.InventoryGUI;

@CommandAlias("ranks")
public class RanksCommand {

    @Default
    public void ranks(Player player) {
        InventoryGUI inventoryGUI = new InventoryGUI(9, "Ranks");
        inventoryGUI.open(player);
        Material material = RankMaterial.getMaterial(RankMaterial.ONE);
    }
}
