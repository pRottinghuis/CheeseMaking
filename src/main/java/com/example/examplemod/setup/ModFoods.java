package com.example.examplemod.setup;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModFoods {

    public static final RegistryObject<Item> CHEESE_PIECE = Registration.ITEMS.register("cheese_piece", () ->
        new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build()).tab(CreativeModeTab.TAB_FOOD)));
    public static void register() {}
}
