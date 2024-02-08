package me.amori.dominion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class DominionPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getLogger().log(Level.INFO, "Dominion plugin enabled!");
    }

    @Override
    public void onDisable() {

    }
}