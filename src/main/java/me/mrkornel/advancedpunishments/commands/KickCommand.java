package me.mrkornel.advancedpunishments.commands;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

    private AdvancedPunishments plugin;
    public KickCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("pkick")) {
            if(!sender.hasPermission("advancedpunishments.kick")) {
                player.sendMessage(ChatColor.GRAY + "(" + ChatColor.RED + "AdvancedPunishments" + ChatColor.GRAY + ") " + ChatColor.GRAY + "» " + plugin.getConfig().get("NoPermission"));
            }

            try {
                String KickedPlayer = args[0];
                String Message = args[1];
                Bukkit.getPlayer(KickedPlayer).kickPlayer(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "»" + " " + plugin.getConfig().get("DefaultKickMessage") + ChatColor.RED + "Reason: " + ChatColor.GRAY + Message);
            } catch (ArrayIndexOutOfBoundsException e) {
            }

        }
        return true;
    }
}
