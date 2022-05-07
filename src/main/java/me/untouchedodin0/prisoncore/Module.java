package me.untouchedodin0.prisoncore;

public interface Module {

    String getName();
    String getDescription();
    String getVersion();
    String getAuthor();
    void onEnable();
    void onDisable();
    void onReload();
    boolean isEnabled();
    void saveDefaultConfig();
}
