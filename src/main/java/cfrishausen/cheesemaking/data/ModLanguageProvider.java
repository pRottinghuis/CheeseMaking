package cfrishausen.cheesemaking.data;

import cfrishausen.cheesemaking.CheeseMaking;
import cfrishausen.cheesemaking.registry.ModBlocks;
import cfrishausen.cheesemaking.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen) {
        super(gen, CheeseMaking.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.CHEESE_CURD, "Cheese Curd");
        addItem(ModItems.CHEESE_PIECE, "Cheese Piece");
        addBlock(ModBlocks.CHEESE_BLOCK, "Cheese Block");
    }
}
