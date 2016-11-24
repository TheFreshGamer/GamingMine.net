package me.thefreshgamer.permissions.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.thefreshgamer.permissions.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


/**
 * Created by SpielKind on 21.10.2016.
 */
public class UUIDFetcher {


    private final String NAME_URL = "https://api.mojang.com/users/profiles/minecraft/%s";
    private Map<String, UUID> cache = new HashMap<String, UUID>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void getUUID(final String name, final Consumer<UUID> action){
        if(cache.containsKey(name)){
            action.accept(cache.get(name));
        }else {
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    action.accept(getUUID(name));

                }
            });
        }
    }

    public UUID getUUID(String name) {
        name = name.toLowerCase();
        if (cache.containsKey(name)) {
            return cache.get(name);
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(String.format(NAME_URL, name)).openConnection();
            connection.setReadTimeout(5000);
            JsonObject json = (JsonObject) new JsonParser().parse(new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine());
            UUID id = Main.m.uuidTypeAdapter.fromString(json.get("id").getAsString());
            cache.put(name, id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
