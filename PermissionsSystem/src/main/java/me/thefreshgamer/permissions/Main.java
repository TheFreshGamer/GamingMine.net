package me.thefreshgamer.permissions;

import me.thefreshgamer.permissions.commands.ranginfo_command;
import me.thefreshgamer.permissions.commands.setrang_command;
import me.thefreshgamer.permissions.listeners.login_listener;
import me.thefreshgamer.permissions.mysql.MySQL;
import me.thefreshgamer.permissions.mysql.PermissionsAPI;
import me.thefreshgamer.permissions.mysql.isTeammember;
import me.thefreshgamer.permissions.utils.UUIDFetcher;
import me.thefreshgamer.permissions.utils.UUIDType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class Main extends Plugin {

    public static Main m;
    public UUIDType uuidTypeAdapter;
    public UUIDFetcher uuidFetcher;
    public isTeammember isTeammember;

    public static String pr = "§8[§aServer§8] ";


    @Override
    public void onEnable() {
        init();
        m = this;
        uuidTypeAdapter = new UUIDType();
        uuidFetcher = new UUIDFetcher();
        isTeammember = new isTeammember();
        MySQL.connect();
        PermissionsAPI.createTables();
        sendPermissions();

    }


    @Override
    public void onDisable() {
        MySQL.close();

    }


    private void init() {
        PluginManager pm = getProxy().getPluginManager();
        pm.registerCommand(this,new setrang_command());
        pm.registerListener(this,new login_listener());
        pm.registerCommand(this,new ranginfo_command());
    }


    private void sendPermissions() {
        ProxyServer.getInstance().getConsole().sendMessage("▒█▄░▒█ ░█▀▀█ ▀▀█▀▀ ▒█░▒█ ▒█▀▀█ ▒█▀▀█ ▒█▀▀▀ ▒█▀▀█ ▒█▀▄▀█ ");
        ProxyServer.getInstance().getConsole().sendMessage("▒█▒█▒█ ▒█▄▄█ ░▒█░░ ▒█░▒█ ▒█▄▄▀ ▒█▄▄█ ▒█▀▀▀ ▒█▄▄▀ ▒█▒█▒█ ");
        ProxyServer.getInstance().getConsole().sendMessage("▒█░░▀█ ▒█░▒█ ░▒█░░ ░▀▄▄▀ ▒█░▒█ ▒█░░░ ▒█▄▄▄ ▒█░▒█ ▒█░░▒█ ");

    }

}
