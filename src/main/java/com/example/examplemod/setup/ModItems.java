package com.example.examplemod.setup;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> CHEESE_CURD = Registration.ITEMS.register("cheese_curd", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static void register() {}

}
