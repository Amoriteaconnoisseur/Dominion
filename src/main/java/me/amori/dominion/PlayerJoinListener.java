package me.amori.dominion;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        // Defining the Steps to assist
        Player plr = e.getPlayer();
        NamespacedKey key = new NamespacedKey(DominionPlugin.INSTANCE, "clan");
        PersistentDataContainer dataContainer = plr.getPersistentDataContainer();

        // If the player does not have an auto assigned clan it will run the following below
        ClanType clanType;
        if(!dataContainer.has(key, PersistentDataType.STRING)) {
            // Selecting the random clan type for the player
            ClanType[] clanTypes = ClanType.values();
            Random random = new Random();
            int selected = random.nextInt(clanTypes.length);
            clanType = clanTypes[selected];

            // Saving the Clan Type to the player
            dataContainer.set(key, PersistentDataType.STRING, clanType.name());

            // Notifies the player of their randomly assigned clan type
            plr.sendMessage("You are apart of the " + clanType.name() + " Clan");
        } else {
            clanType = ClanType.valueOf(dataContainer.get(key, PersistentDataType.STRING));
            plr.sendMessage("You are already apart of the " + clanType.name() + " clan! :)");
        }

        if(clanType.hasPotionEffect()) {
            plr.addPotionEffect(clanType.getPotionEffect());
        }
    }
}
