package me.mrkornel.advancedpunishments.commands;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnBanCommand implements CommandExecutor {


    private AdvancedPunishments plugin;

    public UnBanCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("puban")) {
            if(!sender.hasPermission("advancedpunishments.unban")) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("NoPermission"));
            }
            try {

                String unbannedPlayer = args[0];
                if(Bukkit.getPlayer(unbannedPlayer).getDisplayName() == plugin.getConfig().get("BanList")) {
                    plugin.getConfig().set(Bukkit.getPlayer(unbannedPlayer).getUniqueId().toString(), null);
                    plugin.getConfig().set(Bukkit.getPlayer(unbannedPlayer).getUniqueId() + "Reason", null);
                    plugin.getConfig().set(Bukkit.getPlayer(unbannedPlayer).getUniqueId() + "Time", null);
                } else if(Bukkit.getPlayer(unbannedPlayer).getDisplayName() != plugin.getConfig().get("BanList")) {
                    player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("DoesntBanned"));
                }
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + Bukkit.getPlayer(unbannedPlayer).getDisplayName() + " " + plugin.getConfig().get("SuccessfullyUnbanned"));
            } catch (NullPointerException e) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("DoesntBanned"));
            }
        }
        return true;
    }
}
