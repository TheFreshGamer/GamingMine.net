package me.thefreshgamer.permissions.mysql;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class MySQL {

    public static String host = "";
    public static String port = "";
    public static String database = "";
    public static String username = "";
    public static String password = "";

    public static Connection conn;

    public static PreparedStatement getStatement(String sql) {
        System.out.println(conn);
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§cMySQL connected"));
    }


    public static List<String> getAllPlayers() {
        List<String> list = new ArrayList();
        PreparedStatement ps = getStatement("SELECT * FROM Permissions");
        try {
           ResultSet rs = ps.executeQuery();
            while (rs.next())  {
                list.add(rs.getString("Spielername"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean isOnline(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM OnlinePlayers WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            boolean online = rs.next();
            rs.close();
            ps.close();
            return online;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }



}

