package me.amori.teamtrims.panel;

import me.amori.teamtrims.ClanType;
import me.amori.teamtrims.TeamTrimsPlugin;
import me.amori.teamtrims.Utils;
import org.avaeriandev.utils.IconScript;
import org.bukkit.entity.Player;

public class ClanSelectScript implements IconScript {

    private final ClanType clan;

    public ClanSelectScript(ClanType clan) {
        this.clan = clan;
    }

    @Override
    public void run(Player plr) {
        TeamTrimsPlugin.setClan(plr, clan);
        plr.sendMessage(Utils.formatColor("&aSelected the " + clan.name().toLowerCase() + " clan!"));
        plr.closeInventory();
    }
}
