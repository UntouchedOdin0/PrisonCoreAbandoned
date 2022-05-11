package me.untouchedodin0.prisoncore.modules.ranks.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.untouchedodin0.prisoncore.utils.rank.RankMaterial;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import redempt.redlib.inventorygui.InventoryGUI;

import java.util.concurrent.atomic.AtomicInteger;

@CommandAlias("ranks")
public class RanksCommand extends BaseCommand {
    @Default
    public void ranks(Player player) {
        InventoryGUI inventoryGUI = new InventoryGUI(9, "Ranks");
        inventoryGUI.open(player);
        Material material = RankMaterial.getMaterial(RankMaterial.ONE);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int newInt;
        player.sendMessage("int: " + atomicInteger.get());
        for (int i = 0; i < 100; i++) {
            newInt = atomicInteger.addAndGet(4);
            player.sendMessage("newInt: " + newInt);
        }
    }
}
