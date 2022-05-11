package me.untouchedodin0.prisoncore.modules.booster.listener;

import me.untouchedodin0.prisoncore.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;

public class BoosterRedeemListener implements Listener {

    @EventHandler
    public void onRedeem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (event.getItem() != null) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.hasItemMeta()) {
                    ItemMeta itemMeta = item.getItemMeta();
                    CustomItemTagContainer customItemTagContainer;

                    if (itemMeta != null && itemMeta.hasDisplayName()) {
                        customItemTagContainer = itemMeta.getCustomTagContainer();

                        if (itemMeta.getDisplayName().equals(ChatColor.GREEN + "Token Booster")) {
                            if (customItemTagContainer.hasCustomTag(Utils.TYPE_KEY, ItemTagType.STRING) && customItemTagContainer.hasCustomTag(Utils.TIME_KEY, ItemTagType.INTEGER)) {
                                Integer timeInteger = customItemTagContainer.getCustomTag(Utils.TIME_KEY, ItemTagType.INTEGER);
                                if (timeInteger != null) {
                                    int time = timeInteger;
                                    player.sendMessage(ChatColor.GREEN + String.format("You have redeemed a Token booster for %s minutes.", time));
                                    player.getInventory().remove(item);
                                    Utils.startBooster(player, "TOKEN", time);
                                }
                            }
                        } else if (itemMeta.getDisplayName().equals(ChatColor.GREEN + "Money Booster")) {
                            if (customItemTagContainer.hasCustomTag(Utils.TYPE_KEY, ItemTagType.STRING) && customItemTagContainer.hasCustomTag(Utils.TIME_KEY, ItemTagType.INTEGER)) {
                                Integer timeInteger = customItemTagContainer.getCustomTag(Utils.TIME_KEY, ItemTagType.INTEGER);
                                if (timeInteger != null) {
                                    int time = timeInteger;
                                    player.sendMessage(ChatColor.GREEN + String.format("You have redeemed a Money booster for %s minutes.", time));
                                    player.getInventory().remove(item);
                                    Utils.startBooster(player, "MONEY", time);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
