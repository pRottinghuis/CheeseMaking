package cfrishausen.cheesemaking.data;

import cfrishausen.cheesemaking.CheeseMaking;
import cfrishausen.cheesemaking.registry.ModBlocks;
import cfrishausen.cheesemaking.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        createCheeseBlockRecipe(ModBlocks.CHEESE_BLOCK, ModItems.CHEESE_PIECE, consumer);
        createCheeseCurdRecipe(ModItems.CHEESE_CURD, Items.MILK_BUCKET, consumer);
        createCheesePieceRecipes(ModItems.CHEESE_PIECE, ModItems.CHEESE_CURD, ModItems.CHEESE_BLOCK, consumer);
    }

    public static void createCheeseBlockRecipe(RegistryObject<Block> block, RegistryObject<Item> piece, Consumer<FinishedRecipe> subConsumer){
        ShapedRecipeBuilder.shaped(block.get().asItem(), 1)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', piece.get())
                .unlockedBy("has_item", has(piece.get()))
                .save(subConsumer);
    }

    public static void createCheeseCurdRecipe(RegistryObject<Item> curd, Item milk, Consumer<FinishedRecipe> subConsumer) {
        ShapedRecipeBuilder.shaped(curd.get(), 1)
                .pattern("xx")
                .pattern("xx")
                .define('x', milk)
                .unlockedBy("has_item", has(milk))
                .save(subConsumer);
    }

    public static void createCheesePieceRecipes(RegistryObject<Item> piece, RegistryObject<Item> curd, RegistryObject<Item> block, Consumer<FinishedRecipe> subConsumer)
    {
        ShapedRecipeBuilder.shaped(piece.get(), 1)
                .pattern("xx")
                .define('x', curd.get())
                .unlockedBy("has_item", has(curd.get()))
                .save(subConsumer);

        ShapelessRecipeBuilder.shapeless(piece.get(), 9)
                .requires(block.get(), 1)
                .unlockedBy("has_item", has(block.get()))
                .save(subConsumer, new ResourceLocation(CheeseMaking.MOD_ID, "piece_from_block"));
    }
}
