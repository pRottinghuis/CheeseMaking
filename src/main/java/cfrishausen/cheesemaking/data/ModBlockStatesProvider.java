package cfrishausen.cheesemaking.data;

import cfrishausen.cheesemaking.CheeseMaking;
import cfrishausen.cheesemaking.registry.ModBlocks;
import cfrishausen.cheesemaking.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CheeseMaking.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //block models
        simpleBlock(ModBlocks.CHEESE_BLOCK.get());

        //block item models
        blockItemModel(ModBlocks.CHEESE_BLOCK);

        //item models\
        simpleItemModel(ModItems.CHEESE_CURD);
        simpleItemModel(ModItems.CHEESE_PIECE);
    }

    private void blockItemModel(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + block.getId().getPath())));
    }

    private void simpleItemModel(RegistryObject<Item> item) {
        itemModels().getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated"))).texture("layer0", modLoc("item/" + item.getId().getPath()));
    }
}
