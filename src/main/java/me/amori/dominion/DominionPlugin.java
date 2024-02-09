package me.amori.dominion;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class DominionPlugin extends JavaPlugin {

    public static DominionPlugin INSTANCE;

    public static NamespacedKey CLAN_KEY;

    public static void setClan(Player plr, ClanType clan) {
        PersistentDataContainer dataContainer = plr.getPersistentDataContainer();
        dataContainer.set(CLAN_KEY, PersistentDataType.STRING, clan.name());
    }

    // Returns the player's clan if set, otherwise null
    public static ClanType getClan(Player plr) {
        PersistentDataContainer dataContainer = plr.getPersistentDataContainer();
        String rawClan = dataContainer.get(CLAN_KEY, PersistentDataType.STRING);
        return rawClan != null ? ClanType.valueOf(rawClan) : null;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        CLAN_KEY = new NamespacedKey(this, "clan");

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PotionEffectListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemPickupListener(), this);
        this.getLogger().log(Level.INFO, "Dominion plugin enabled!");

    }

    @Override
    public void onDisable() {


        // Set null after plugin is disabled completely
        INSTANCE = null;
    }
}