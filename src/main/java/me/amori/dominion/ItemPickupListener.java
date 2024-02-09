package me.amori.dominion;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.PrepareInventoryResultEvent;

public class ItemPickupListener implements Listener {

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event){

        // Don't handle if entity is not a player
        if(!(event.getEntity() instanceof Player plr)) {
            return;
        }

        ClanType clanType = DominionPlugin.getClan(plr);

        Material itemType = event.getItem().getItemStack().getType();
        String itemTypeName = itemType.name().toLowerCase();
        if(itemTypeName.contains("chestplate") || itemTypeName.contains("helmet")) {


        }
    }

}
