package ru.s1stemdeb.sdPouches.config;

import org.bukkit.plugin.java.JavaPlugin;
import ru.s1stemdeb.sdPouches.Plugin;

public abstract class Configurable {

    public Plugin getPlugin() { return JavaPlugin.getPlugin(Plugin.class); }

    protected abstract String getName();

}
