package me.untouchedodin0.prisoncore.events.rankup;

import me.clip.ezrankspro.events.RankupEvent;
import me.untouchedodin0.kotlin.mine.storage.MineStorage;
import me.untouchedodin0.prisoncore.PrisonCore;
import me.untouchedodin0.prisoncore.utils.Utils;
import me.untouchedodin0.privatemines.PrivateMines;
import me.untouchedodin0.privatemines.mine.Mine;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerRankupEvent implements Listener {

    PrisonCore prisonCore = PrisonCore.getInstance();

    @EventHandler
    public void onPlayerRankup(RankupEvent event) {
        Player player = event.getPlayer();
        String newRank = event.getNewRank();

        PrivateMines privateMines = PrivateMines.getPrivateMines();
        MineStorage mineStorage = privateMines.getMineStorage();

        if (mineStorage.hasMine(player.getUniqueId())) {
            int rank = Integer.parseInt(newRank);
            boolean shouldRankup = Utils.divisibleBy(rank, 4);

            player.sendMessage("You have ranked up to " + newRank);
            player.sendMessage("You are now rank " + rank);
            player.sendMessage("Is your mine gonna upgrade? " + shouldRankup);

            if (shouldRankup) {
                player.sendMessage("Your mine is gonna upgrade!");
                Mine mine = privateMines.getMineStorage().get(player.getUniqueId());
                if (mine != null) {
                    mine.upgrade();
                }
            }
        }
    }
}
