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
 * Created by SpielKind on 16.11.2016.
 */
public class ranginfo_command extends Command{


    public ranginfo_command() {
        super("ranginfo");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if(args.length == 1) {
            ProxiedPlayer spielername = ProxyServer.getInstance().getPlayer(args[0]);
            if(PermissionsAPI.isInGroup(p, groupen.HeadAdmin)) {
            if(PermissionsAPI.userExists(Main.m.uuidFetcher.getUUID(spielername.getName()))) {
                p.sendMessage(new TextComponent(Main.pr+" §c Der Spieler  §a"+spielername.getName()+" §chat den Rang "+PermissionsAPI.getGroup(spielername)));

            } else {
                p.sendMessage(new TextComponent(Main.pr+" §cDer Spieler exestiert nicht in der Datenbank"));
            }
        } else {
            p.sendMessage(new TextComponent(Main.pr+" §cDu hast keine rechte auf den Command"));
            }

    } else {
        p.sendMessage(new TextComponent(Main.pr+" §c/ranginfo <name>"));
        }
}
}