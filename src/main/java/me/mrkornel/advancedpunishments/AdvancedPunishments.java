package me.mrkornel.advancedpunishments;

import me.mrkornel.advancedpunishments.commands.*;
import me.mrkornel.advancedpunishments.events.MuteEvent;
import me.mrkornel.advancedpunishments.events.PlayerLoginEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedPunishments extends JavaPlugin {

    public String prefix = "&7(&4AdvancedPunishments&7)";
    public boolean isMuted;

    @Override
    public void onEnable() {
        getConfig().addDefault("NoPermission", "You dont have permission to do this!");
        getConfig().addDefault("DefaultKickMessage", "You are got kicked from the server! ");
        getConfig().addDefault("DefaultBanMessage", "You are banned from the server!");
        getConfig().addDefault("MuteMessage", " has been muted!");
        getConfig().addDefault("MutedMessage", "You are muted!");
        getConfig().addDefault("DoesntBanned", "This player doesn't banned from the server!");
        getConfig().addDefault("DoesntMuted", "This player doesn't muted!");
        getConfig().addDefault("UnBanUsage", "/puban <player>");
        getConfig().addDefault("SuccessfullyUnbanned", "Player successfully unbanned!");
        getConfig().addDefault("SuccessfullyUnMuted", "Player successfully unmuted!");
        getConfig().addDefault("BanUsage", "/pban <player> <reason> <time>");
        getConfig().addDefault("ReloadMessage", "Config successfully reloaded!");
        getServer().getPluginManager().registerEvents(new PlayerLoginEvent(this), this);
        getServer().getPluginManager().registerEvents(new MuteEvent(this), this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("pban").setExecutor(new BanCommand(this));
        getCommand("pkick").setExecutor(new KickCommand(this));
        getCommand("phelp").setExecutor(new HelpCommand(this));
        getCommand("puban").setExecutor(new UnBanCommand(this));
        getCommand("pmute").setExecutor(new MuteCommand(this));
        getCommand("punmute").setExecutor(new UnMuteCommand(this));
        getCommand("preload").setExecutor(this::onCommand);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("preload")) {
            if(!sender.hasPermission("advancedpunishments.reload")) {
                player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + getConfig().get("NoPermission"));
            }
            player.sendMessage(ChatColor.RED + "AdvancedPunishments " + ChatColor.GRAY + "» " + getConfig().get("ReloadMessage"));
            reloadConfig();
        }
        return true;
    }

    @Override
    public void onDisable() {

    }
}
