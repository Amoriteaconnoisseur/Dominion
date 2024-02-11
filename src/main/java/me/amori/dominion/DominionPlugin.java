package me.amori.dominion;

import me.amori.dominion.commands.ClanPanelCommand;
import me.amori.dominion.commands.ClanSetCommand;
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
        ClanType oldClan = getClan(plr);

        // Update clan
        PersistentDataContainer dataContainer = plr.getPersistentDataContainer();
        dataContainer.set(CLAN_KEY, PersistentDataType.STRING, clan.name());

        // Update potion effect
        if(oldClan != null && oldClan.hasPotionEffect()) {
            plr.removePotionEffect(oldClan.getPotionEffect().getType());
        }

        if(clan.hasPotionEffect()) {
            plr.addPotionEffect(clan.getPotionEffect());
        }
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

        // Register commands
        getCommand("setclan").setExecutor(new ClanSetCommand());
        getCommand("clan").setExecutor(new ClanPanelCommand());

        // Register listeners
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