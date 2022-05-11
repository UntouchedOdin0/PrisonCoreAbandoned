package me.untouchedodin0.prisoncore.modules.booster.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.untouchedodin0.prisoncore.PrisonCore;
import me.untouchedodin0.prisoncore.utils.builders.BoosterItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.Arrays;

@CommandAlias("givebooster")
public class GiveBoosterCommand extends BaseCommand {

    @Default
    public void giveBooster(Player player, String type, int time) {
        if (time < 1) {
            player.sendMessage(ChatColor.RED + "You must give a time greater than 0.");
        } else {
            PrisonCore.getInstance().getLogger().info(player.getName() + " has given " + type + " for " + time + " minutes.");

            switch (type.toUpperCase()) {
                case "TOKEN", "TOKENS", "ETOKEN", "ETOKENS" -> {
                    player.sendMessage("You have been given a token booster for " + time + " minutes.");
                    ItemStack booster = new BoosterItemBuilder()
                            .setMaterial(Material.MAGMA_CREAM)
                            .setDisplayName(ChatColor.GREEN + "Token Booster")
                            .setLore(Arrays.asList(ChatColor.GRAY + "This booster will give everyone a ",
                                                   ChatColor.GRAY + "Token booster for " + ChatColor.GOLD + time + ChatColor.GRAY + " minutes."))
                            .setType("TOKEN")
                            .setTime(time)
                            .build();
                    player.getInventory().addItem(booster);
                }
                case "MONEY", "MONEYBOSTER" -> {
                    player.sendMessage("You have been given a money booster for " + time + " minutes.");
                    ItemStack booster = new BoosterItemBuilder()
                            .setMaterial(Material.MAGMA_CREAM)
                            .setDisplayName(ChatColor.GREEN + "Money Booster")
                            .setLore(Arrays.asList(ChatColor.GRAY + "This booster will give everyone a ",
                                                   ChatColor.GRAY + "Money booster for " + ChatColor.GOLD + time + ChatColor.GRAY + " minutes."))
                            .setType("MONEY")
                            .setTime(time)
                            .build();
                    player.getInventory().addItem(booster);
                }
            }
        }
    }
}
