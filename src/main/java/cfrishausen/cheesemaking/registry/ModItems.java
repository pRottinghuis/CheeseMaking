package cfrishausen.cheesemaking.registry;

import cfrishausen.cheesemaking.CheeseMaking;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CheeseMaking.MOD_ID);

    // Items
    public static final RegistryObject<Item> CHEESE_CURD = ITEMS.register("cheese_curd", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    // Foods
    public static final RegistryObject<Item> CHEESE_PIECE = ITEMS.register("cheese_piece", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build()).tab(CreativeModeTab.TAB_FOOD)));

    //Block Items
    public static final RegistryObject<Item> CHEESE_BLOCK = registerBlockItem(ModBlocks.CHEESE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Used to make block items
    public static RegistryObject<Item> registerBlockItem(RegistryObject<? extends Block> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
