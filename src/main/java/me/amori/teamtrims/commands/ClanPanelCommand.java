package me.amori.teamtrims.commands;

import me.amori.teamtrims.ClanType;
import me.amori.teamtrims.TeamTrimsPlugin;
import me.amori.teamtrims.panel.ClanSelectionPanel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanPanelCommand implements CommandExecutor {

    // Format: /clan OR /clanpanel OR /clans

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player plr)){
            sender.sendMessage("You need to be a player to run this command.");
            return false;
        }

        ClanType clan = TeamTrimsPlugin.getClan(plr);
        if(clan != null && clan != ClanType.NEUTRAL){
            sender.sendMessage("You already selected " + clan.name().toLowerCase() + " clan");
            return false;
        }

        plr.openInventory(new ClanSelectionPanel().getPanel());
        return true;
    }
}
