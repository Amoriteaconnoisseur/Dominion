package me.amori.dominion.panel;

import me.amori.dominion.ClanType;
import me.amori.dominion.DominionPlugin;
import me.amori.dominion.Utils;
import org.avaeriandev.utils.IconScript;
import org.bukkit.entity.Player;

public class ClanSelectScript implements IconScript {

    private final ClanType clan;

    public ClanSelectScript(ClanType clan) {
        this.clan = clan;
    }

    @Override
    public void run(Player plr) {
        DominionPlugin.setClan(plr, clan);
        plr.sendMessage(Utils.formatColor("&aSelected the " + clan.name().toLowerCase() + " clan!"));
        plr.closeInventory();
    }
}
