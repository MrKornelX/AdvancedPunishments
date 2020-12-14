package me.mrkornel.advancedpunishments.commands;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    private AdvancedPunishments plugin;

    public HelpCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("phelp")) {
            if(!sender.hasPermission("advancedpunishments.help")) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("NoPermission"));
            }

            player.sendMessage(ChatColor.GRAY + "━━━━━━ " + ChatColor.RED + "AdvancedPunishments Help" + ChatColor.GRAY + " ━━━━━━");
            player.sendMessage("");
            player.sendMessage("");
            player.sendMessage(ChatColor.RED + "Version: " + ChatColor.GRAY + "1.0");
            player.sendMessage(ChatColor.RED + "Author: " + ChatColor.GRAY + "MrKornel");
            player.sendMessage("");
            player.sendMessage("");
            player.sendMessage(ChatColor.GRAY + "━━━━━━ " + ChatColor.RED + "Command List" + ChatColor.GRAY + " ━━━━━━");
            player.sendMessage(ChatColor.RED + "/pkick" + ChatColor.GRAY + " » " + "Kicks player. " + ChatColor.RED + " Usage: " + ChatColor.GRAY + "/pkick <player> <reason>");
            player.sendMessage(ChatColor.RED + "/pban" + ChatColor.GRAY + " » " + "Banning player. " + ChatColor.RED + "Usage: " + ChatColor.GRAY + "/pban <player> <reason> <time>");
            player.sendMessage(ChatColor.RED + "/puban" + ChatColor.GRAY + " » " + "Banning player. " + ChatColor.RED + "Usage: " + ChatColor.GRAY + "/puban <player>");
            player.sendMessage("");
            player.sendMessage("");
            player.sendMessage(ChatColor.GRAY + "━━━━━━ " + ChatColor.RED + "AdvancedPunishments Help" + ChatColor.GRAY + " ━━━━━━");
        }
        return true;
    }
}
