package com.rice.hypoxia.register;

import com.rice.hypoxia.common.item.TestItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.rice.hypoxia.Hypoxia.ID;

public class ModItems {

    private static final List<Item> item_list = new ArrayList<>();
    public static final Item TEST_ITEM = registerItem(() -> new TestItem(new FabricItemSettings()), "test_item");


    private static <T extends Item> T registerItem(Supplier<T> supplier, String name) {

        T item = supplier.get();
        item_list.add(item);
        return Registry.register(Registries.ITEM, new Identifier(ID, name), item);
    }

    public static void registerItems(ItemGroup itemGroup) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content->{
            item_list.forEach(item-> content.add(item));
        });
    }

}
