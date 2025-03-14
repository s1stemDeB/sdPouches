package ru.s1stemdeb.sdPouches.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.kyori.adventure.text.Component;
import ru.s1stemdeb.sdPouches.Plugin;
import ru.s1stemdeb.sdPouches.config.adaopters.ComponentAdapter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Singleton
public class ConfigLoader {

    @Inject private Plugin plugin;

    public <T extends Configurable> void save(T clazz) {
        Gson g = Gson();
        String json = g.toJson(clazz);

        File file = new File(plugin.getDataFolder(), clazz.getName() + ".json");

        try {
            Path path = file.toPath();
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.write(path, List.of(json),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            plugin.getLogger().severe(e.getMessage());
        }
    }

    public <T extends Configurable> T load(String name, Class<T> clazz) {
        Gson g = Gson();
        File cfg = new File(plugin.getDataFolder(), name + ".json");

        try {
            byte[] bytes = Files.readAllBytes(cfg.toPath());
            return g.fromJson(new String(bytes, StandardCharsets.UTF_8), clazz);
        } catch (IOException e) {
            plugin.getLogger().severe(e.getMessage());
            return null;
        }
    }

    public Gson Gson() {
        return new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
                .registerTypeAdapter(Component.class, new ComponentAdapter())
                .create();
    }

}
