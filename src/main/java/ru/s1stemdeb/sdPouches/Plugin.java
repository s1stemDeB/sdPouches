package ru.s1stemdeb.sdPouches;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private Injector injector;

    @Override
    public void onEnable() {

        injector = Guice.createInjector(new Module(this));
        injector.injectMembers(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
