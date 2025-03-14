package ru.s1stemdeb.sdPouches.config.adaopters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.lang.reflect.Type;

public class ComponentAdapter implements JsonDeserializer<Component> {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public Component deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            throw new JsonParseException("Expected a string for MiniMessage deserialization");
        }
        String miniMessageString = jsonElement.getAsString();
        return mm.deserialize(miniMessageString);
    }
}
