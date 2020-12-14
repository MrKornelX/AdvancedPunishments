package me.mrkornel.advancedpunishments.commands;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class MuteCommand implements CommandExecutor {

    private AdvancedPunishments plugin;

    public MuteCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("pmute")) {
            if(!sender.hasPermission("advancedpunishments.mute")) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("NoPermission"));
            }

            String MutedPlayer = args[0];
            String MuteReason = args[1];
            String MuteTime = args[2];

            Date currentDate = new Date();
            Calendar MuteT = Calendar.getInstance();
            MuteT.setTime(currentDate);
            MuteT.add(Calendar.DATE, Integer.parseInt(MuteTime));
            Date date = MuteT.getTime();


            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(date);

            plugin.getConfig().addDefault("MuteList", Bukkit.getPlayer(MutedPlayer).getDisplayName());
            UUID playerID = Bukkit.getPlayer(MutedPlayer).getUniqueId();
            plugin.getConfig().addDefault(Bukkit.getPlayer(MutedPlayer).getUniqueId().toString(), playerID.toString());
            plugin.getConfig().addDefault(String.valueOf(Bukkit.getPlayer(MutedPlayer).getUniqueId()) + " MuteReason", MuteReason);
            plugin.getConfig().addDefault(String.valueOf(Bukkit.getPlayer(MutedPlayer).getUniqueId()) + " MuteTime", date1);
            plugin.saveConfig();

            player.sendMessage(ChatColor.GRAY + "(" + ChatColor.RED + "AdvancedPunishments" + ChatColor.GRAY + ") " + ChatColor.GRAY + "» " + Bukkit.getPlayer(MutedPlayer).getDisplayName() + plugin.getConfig().get("MuteMessage"));

        }

        return true;
    }
}
