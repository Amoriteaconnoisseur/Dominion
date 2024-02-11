package me.amori.dominion.commands;

import me.amori.dominion.ClanType;
import me.amori.dominion.DominionPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanSetCommand implements CommandExecutor {

    // Format: /setclan <player> <clan type>

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Only allow admins (op players/console) to access this command
        if(!sender.isOp()) {
            sender.sendMessage("No permissions.");
            return false;
        }

        // Require player to be online
        Player plr = Bukkit.getPlayer(args[0]);
        if(!plr.isOnline()) {
            sender.sendMessage("Player " + args[0] + " is not online!");
            return false;
        }

        // Get clan type from args
        ClanType clanType = ClanType.fromString(args[1]);
        if(clanType == null) {
            sender.sendMessage("Clan " + args[1] + " not recognized!");
            return false;
        }

        // Prevent reassigning player to same clan
        if(clanType == DominionPlugin.getClan(plr)) {
            sender.sendMessage("Player " + args[0] + " is already part of " + args[1] + "!");
            return false;
        }

        // Update clan for player
        DominionPlugin.setClan(plr, clanType);
        sender.sendMessage("Clan updated for " + args[0] + " successfully!");
        return true;
    }
}
