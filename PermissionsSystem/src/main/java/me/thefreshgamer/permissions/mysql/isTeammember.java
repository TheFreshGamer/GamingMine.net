package me.thefreshgamer.permissions.mysql;

import me.thefreshgamer.permissions.groups.groupen;

import java.util.UUID;

/**
 * Created by SpielKind on 21.10.2016.
 */
public class isTeammember {


    public static boolean isTeamMember(UUID uuid)
    {
        if ((PermissionsAPI.isInGroup(uuid, groupen.HeadAdmin) | PermissionsAPI.isInGroup(uuid, groupen.ADMIN) | PermissionsAPI.isInGroup(uuid, groupen.Dev) | PermissionsAPI.isInGroup(uuid, groupen.Srmod) | PermissionsAPI.isInGroup(uuid, groupen.Mod) | PermissionsAPI.isInGroup(uuid, groupen.Sup) | PermissionsAPI.isInGroup(uuid, groupen.Guide) || PermissionsAPI.isInGroup(uuid,groupen.Builder))) {
            return true;
        }
        return false;
    }

    public static String getPrefix(UUID uuid)
    {
        String pr = "§8";
        if (PermissionsAPI.isInGroup(uuid, groupen.HeadAdmin)) {
            pr = "HeadAdmin§8|§4";
        } else if (PermissionsAPI.isInGroup(uuid, groupen.ADMIN)) {
            pr = "§4Admin §8| §4";
        } else if ((PermissionsAPI.isInGroup(uuid, groupen.Dev))) {
            pr = "§bDev §8| §b";
        } else if ((PermissionsAPI.isInGroup(uuid, groupen.Srmod))) {
            pr = "§cSrmod §8| §c";
        } else if (PermissionsAPI.isInGroup(uuid, groupen.Mod)) {
            pr = "§cMod §8| §c";
        } else if (PermissionsAPI.isInGroup(uuid, groupen.Sup)) {
            pr = "§9Sup §8| §9";
        } else if (PermissionsAPI.isInGroup(uuid, groupen.Guide)) {
            pr = "§eGuide §8| §e";
        } else if(PermissionsAPI.isInGroup(uuid, groupen.Builder)) {
            pr = "§1Builder §8| §1";
        } else if(PermissionsAPI.isInGroup(uuid, groupen.Youtuber)) {
            pr = "§5";
        } else if(PermissionsAPI.isInGroup(uuid, groupen.PremiumPlus)) {
            pr = "§2";
        } else if(PermissionsAPI.isInGroup(uuid,groupen.Premium)) {
            pr = "§6";
        } else if(PermissionsAPI.isInGroup(uuid,groupen.NF)) {

        } else if(PermissionsAPI.isInGroup(uuid,groupen.Spieler)) {
            pr = "§8";
        }
        return pr;
    }
}

