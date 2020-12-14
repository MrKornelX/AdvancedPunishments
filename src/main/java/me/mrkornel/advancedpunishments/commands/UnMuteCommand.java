package me.mrkornel.advancedpunishments.commands;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnMuteCommand implements CommandExecutor {

    private AdvancedPunishments plugin;

    public UnMuteCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("punmute")) {
            if(!sender.hasPermission("advancedpunishments.unban")) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("NoPermission"));
            }
            try {

                String unMutedPlayer = args[0];
                if(Bukkit.getPlayer(unMutedPlayer).getDisplayName() == plugin.getConfig().get("MuteList")) {
                    plugin.getConfig().set("MuteList " + player.getDisplayName(), null);
                    plugin.getConfig().set(Bukkit.getPlayer(unMutedPlayer).getUniqueId().toString(), null);
                    plugin.getConfig().set(Bukkit.getPlayer(unMutedPlayer).getUniqueId().toString() + " MuteReason", null);
                    plugin.getConfig().set(Bukkit.getPlayer(unMutedPlayer).getUniqueId().toString() + " MuteTime", null);
                    plugin.saveConfig();
                } else if(Bukkit.getPlayer(unMutedPlayer).getDisplayName() != plugin.getConfig().get("BanList")) {
                    player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("DoesntMuted"));
                }
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + Bukkit.getPlayer(unMutedPlayer).getDisplayName() + " " + plugin.getConfig().get("SuccessfullyUnMuted"));
            } catch (NullPointerException e) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("DoesntMuted"));
            }
        }
        return true;
    }
}
