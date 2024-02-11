package me.amori.dominion;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;

public class PotionEffectListener implements Listener {

    @EventHandler
    public void onPotionEffect(EntityPotionEffectEvent event) {

        // Don't handle if entity is not a player
        if(!(event.getEntity() instanceof Player plr)) {
            return;
        }

        ClanType clanType = DominionPlugin.getClan(plr);
        // Don't handle if clan doesn't have a potion effect
        if(!clanType.hasPotionEffect()) {
            return;
        }

        // Only handle if potion effect is being removed
        if(event.getAction() != EntityPotionEffectEvent.Action.ADDED) {
            if(event.getOldEffect().equals(clanType.getPotionEffect())) {
                event.setCancelled(true);
            }
        }
    }
}
