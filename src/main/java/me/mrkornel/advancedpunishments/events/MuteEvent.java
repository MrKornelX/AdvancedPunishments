package me.mrkornel.advancedpunishments.events;

import me.mrkornel.advancedpunishments.AdvancedPunishments;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteEvent implements Listener {

    private AdvancedPunishments plugin;

    public MuteEvent(AdvancedPunishments plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if(plugin.getConfig().get("MuteList").equals(player.getDisplayName())) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + plugin.getConfig().get("MutedMessage") + " " + ChatColor.RED + "Reason: " + ChatColor.GRAY + plugin.getConfig().get(player.getUniqueId() + " MuteReason") + " " + ChatColor.RED + "Until: " + ChatColor.GRAY + plugin.getConfig().get(player.getUniqueId() + " MuteTime"));
        }
    }

}
