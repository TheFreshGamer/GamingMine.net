package me.thefreshgamer.permissions.mysql;

import me.thefreshgamer.permissions.groups.groupen;
import me.thefreshgamer.permissions.utils.UUIDFetcher;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class PermissionsAPI {

    public static void createTables() {
        try {
            PreparedStatement ps2 = MySQL.getStatement("CREATE TABLE IF NOT EXISTS Permissions (Spielername VARCHAR(100), UUID VARCHAR(100), Gruppe TEXT(100))");
            ps2.executeUpdate();
            ps2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void register(String name, UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getStatement("INSERT INTO Permissions (Spielername, UUID, Gruppe) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, uuid.toString());
            ps.setString(3, groupen.Spieler.getName());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setRang(UUID uuid, String group) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE Permissions SET Gruppe = ? WHERE UUID = ?");
            ps.setString(1, group);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getGroup(ProxiedPlayer p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM Permissions WHERE UUID = ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            String rang = rs.getString("Gruppe");
            rs.close();
            ps.close();
            return rang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Spieler";
    }

    public static String getGroup(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM Permissions WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            String rang = rs.getString("Gruppe");
            rs.close();
            ps.close();
            return rang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Spieler";
    }

    public static boolean isInGroup(ProxiedPlayer p, groupen group) {
        if (getGroup(p).equalsIgnoreCase(group.getName())) {
            return true;
        }
        return false;
    }

    public static void setName(UUID uuid, String name) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE Permissions SET Spielername= ? WHERE UUID = '" + uuid + "'");
            ps.setString(1, name);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean userExists(UUID uuid) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT " + "UUID" + " FROM " + "Permissions" + " WHERE " + "UUID" + "=?");
            ps.setString(1, uuid.toString());

            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next())
                if (rs != null)
                    return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static boolean isInGroup(UUID uuid, groupen group)
    {
        if (getGroup(uuid).equalsIgnoreCase(group.getName())) {
            return true;
        }
        return false;
    }

}

