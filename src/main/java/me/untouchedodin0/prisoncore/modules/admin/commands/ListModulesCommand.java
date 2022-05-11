package me.untouchedodin0.prisoncore.modules.admin.commands;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

@CommandAlias("listmodules")
public class ListModulesCommand {

    PrisonCore prisonCore = PrisonCore.getInstance();

    @Default
    public void listModules(Player player) {
        LinkedHashMap<String, Module> modules = prisonCore.getModules();
        for (Module module : modules.values()) {
            player.sendMessage(String.format("Name: %s", module.getName()));
            player.sendMessage(String.format("Description: %s", module.getDescription()));
            player.sendMessage(String.format("Version: %s", module.getVersion()));
            player.sendMessage(String.format("Author: %s", module.getAuthor()));
            player.sendMessage(String.format("Enabled: %s", module.isEnabled() ? "Yes" : "No"));
        }
    }
}
