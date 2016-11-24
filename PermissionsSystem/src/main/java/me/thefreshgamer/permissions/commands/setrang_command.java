package me.thefreshgamer.permissions.commands;


import me.thefreshgamer.permissions.Main;
import me.thefreshgamer.permissions.groups.groupen;
import me.thefreshgamer.permissions.mysql.PermissionsAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class setrang_command extends Command {


    public setrang_command() {
        super("rang");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 2) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            String name = args[0];
            String spielername = "TheFreshGamer";
            String kickrang = args[1];
            ProxiedPlayer torang = ProxyServer.getInstance().getPlayer(args[0]);
            if (PermissionsAPI.isInGroup(p, groupen.HeadAdmin)) {
                if (!PermissionsAPI.isInGroup(p, groupen.valueOf(kickrang))) {
                    PermissionsAPI.setRang(Main.m.uuidFetcher.getUUID(name), kickrang);
                    p.sendMessage(new TextComponent(Main.pr + " §cDu hast dem Spieler §a" + name + " §cden rang §a" + kickrang + "§cgegeben"));
                    torang.disconnect(new TextComponent("§aDu hast einen neuen Rang erhalten!\n" + "\n" + "§eRang: §e" + kickrang));


                } else {
                    sender.sendMessage(new TextComponent(Main.pr + " §cDer Spieler ist bereits in der Gruppe "+ kickrang));
                }

            } else {
                sender.sendMessage(new TextComponent(Main.pr + " §cDu hast keine rechte für den Command"));
            }
        } else {
            sender.sendMessage(new TextComponent(Main.pr+ " §c/rang <name> <grund>"));
        }
    }
}