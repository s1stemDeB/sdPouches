package ru.s1stemdeb.sdPouches;

import com.google.inject.AbstractModule;
import ru.s1stemdeb.sdPouches.config.ConfigLoader;

public class Module extends AbstractModule {

    private Plugin plugin;

    public Module(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(ConfigLoader.class).toInstance(new ConfigLoader());
    }
}
