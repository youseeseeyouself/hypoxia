package com.rice.hypoxia;

import com.rice.hypoxia.register.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Hypoxia implements ModInitializer {

    public static final String ID= "hypoxia";
    public static final String NAME = "Hypoxia";
    private static final ItemGroup ITEM_GROUP = FabricItemGroup
            .builder(new Identifier(ID,"item_group"))
            .icon(()->new ItemStack(Items.APPLE))
            .build();

    @Override
    public void onInitialize() {
        ModItems.registerItems(ITEM_GROUP);
    }
}
