package me.mrkornel.advancedpunishments.events;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class MuteEvent implements Listener {

    private AdvancedPunishments plugin;

    public MuteEvent(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if(plugin.getConfig().get("MuteList").equals(player.getDisplayName())) {
            Date currentDate = new Date();
            Calendar MuteT = Calendar.getInstance();
            MuteT.setTime(currentDate);
            Date date = MuteT.getTime();


            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(date);

            int CurrentDate1 = Integer.parseInt(date1);
            UUID playerID = player.getUniqueId();
            int MuteTime = Integer.parseInt(player.getUniqueId().toString() + " MuteTime");
            if(MuteTime > CurrentDate1) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("MutedMessage") + " " + ChatColor.RED + "Reason: " + ChatColor.GRAY + plugin.getConfig().get(player.getUniqueId() + " MuteReason") + " " + ChatColor.RED + "Until: " + ChatColor.GRAY + plugin.getConfig().get(player.getUniqueId() + " MuteTime"));
            } else {
                e.setCancelled(false);
            }
        }
    }

}
