package ru.s1stemdeb.sdPouches.gui.items;

import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Getter @Setter
public class Item {

    private Material material;
    private Component name;
    private List<Component> lore;
    private int custommodeldata;

    public ItemStack buildItemStack() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(name);
        meta.lore(lore);
        meta.setCustomModelData(custommodeldata);

        item.setItemMeta(meta);
        return item;
    }

}
