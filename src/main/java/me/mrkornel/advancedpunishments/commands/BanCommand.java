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


public class BanCommand implements CommandExecutor {

    private AdvancedPunishments plugin;

    public BanCommand(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("pban")) {
            if(!sender.hasPermission("advancedpunishments.ban")) {
                player.sendMessage(ChatColor.GRAY + "(" + ChatColor.RED + "AdvancedPunishments" + ChatColor.GRAY + ") " + ChatColor.GRAY + "» " + ChatColor.RED + "Reason: " + plugin.getConfig().get("NoPermission"));
            }

            try {
                String BannedPlayer = args[0];
                String Reason = args[1];
                String Time = args[2];


                Date currentDate = new Date();
                Calendar BanTime = Calendar.getInstance();
                BanTime.setTime(currentDate);
                BanTime.add(Calendar.DATE, Integer.parseInt(Time));
                Date date = BanTime.getTime();


                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = format1.format(date);


                String path = "Player" + Bukkit.getPlayer(BannedPlayer).getUniqueId() + "." + "Reason" + Reason + "." + "Time" + date1;
                String BanList = player.getPlayerListName();
                plugin.getConfig().addDefault("BanList", BanList);
                plugin.getConfig().addDefault(player.getUniqueId().toString(), player.getUniqueId().toString());
                plugin.getConfig().addDefault(player.getUniqueId().toString() + " Reason", Reason);
                plugin.getConfig().addDefault(player.getUniqueId().toString() + "Time", date1);
                plugin.saveConfig();
                Bukkit.getPlayer(BannedPlayer).kickPlayer(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("DefaultBanMessage") + " " + ChatColor.RED + "Reason: " + ChatColor.GRAY + Reason + ChatColor.RED + " Until: " + ChatColor.GRAY + date1);


            } catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage((String) plugin.getConfig().get("BanUsage"));
            }

        }
        return true;
    }
}
