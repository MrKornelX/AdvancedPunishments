package me.mrkornel.advancedpunishments.events;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static java.lang.Integer.*;

public class PlayerLoginEvent implements Listener {

    private AdvancedPunishments plugin;

    public PlayerLoginEvent(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(player.getDisplayName().equals(plugin.getConfig().get("BanList"))) {

            Date currentDate = new Date();
            Calendar BanTime = Calendar.getInstance();
            BanTime.setTime(currentDate);
            Date date = BanTime.getTime();


            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(date);

            int CurrentDate1 = Integer.parseInt(date1);
            UUID playerID = player.getUniqueId();
            int BanT = Integer.parseInt(player.getUniqueId().toString() + " BanTime");

            if(BanT > CurrentDate1) {
                player.kickPlayer(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + (String) plugin.getConfig().get("DefaultBanMessage") + ChatColor.RED + " Reason: " + ChatColor.GRAY + plugin.getConfig().get("Reason") + ChatColor.RED + " Until: " + ChatColor.GRAY + plugin.getConfig().get("Time"));
            } else {

            }

        }
    }
}
