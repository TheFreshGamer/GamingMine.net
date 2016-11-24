package me.thefreshgamer.permissions.listeners;

import me.thefreshgamer.permissions.Main;
import me.thefreshgamer.permissions.mysql.PermissionsAPI;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class login_listener implements Listener{


    @EventHandler
    public void onPreLogin(LoginEvent e) {
        System.out.println("Geht");
       if(!PermissionsAPI.userExists(Main.m.uuidFetcher.getUUID(e.getConnection().getName()))){
            PermissionsAPI.register(e.getConnection().getName(),Main.m.uuidFetcher.getUUID(e.getConnection().getName()));
        }
           }
           }
