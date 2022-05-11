package me.untouchedodin0.prisoncore.utils;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static NamespacedKey TYPE_KEY = new NamespacedKey(PrisonCore.getInstance(), "type");
    public static NamespacedKey TIME_KEY = new NamespacedKey(PrisonCore.getInstance(), "time");

    public static boolean divisibleBy(int value, int divisible) {
        return value % divisible == 0;
    }

    public static String color(String displayName) {
        return ChatColor.translateAlternateColorCodes('&', displayName);
    }

    public static List<String> color(List<String> lore) {
        if (lore == null) {
            return Collections.emptyList();
        }
        return lore.stream().map(Utils::color).collect(Collectors.toList());
    }

    public static void startBooster(Player player, String type, int time) {
        switch (type) {
            case "TOKEN" -> {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.format("" + ChatColor.GOLD + ChatColor.BOLD + " %s "
                                                              + ChatColor.GRAY + "has started a " + ChatColor.GOLD
                                                              + ChatColor.BOLD + "TOKEN" + ChatColor.GRAY
                                                              + " booster for ", player.getName()));
                Bukkit.broadcastMessage(String.format("                             "
                                                              + ChatColor.GOLD + "%d " + ChatColor.GRAY + "minutes!", time));
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
            }
            case "MONEY" -> {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.format("" + ChatColor.GOLD + ChatColor.BOLD + " %s "
                                                              + ChatColor.GRAY + "has started a " + ChatColor.GOLD
                                                              + ChatColor.BOLD + "MONEY" + ChatColor.GRAY
                                                              + " booster for ", player.getName()));
                Bukkit.broadcastMessage(String.format("                             "
                                                              + ChatColor.GOLD + "%d " + ChatColor.GRAY + "minutes!", time));
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
            }
        }
    }
}
