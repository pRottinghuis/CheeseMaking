package cfrishausen.cheesemaking.data;

import cfrishausen.cheesemaking.CheeseMaking;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CheeseMaking.MOD_ID)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var dataGen = event.getGenerator();
        var helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            // Models, assets, etc.
            dataGen.addProvider(true, new ModBlockStatesProvider(dataGen, helper));
            dataGen.addProvider(true, new ModLanguageProvider(dataGen));

        }
        if (event.includeServer()) {
            // Loot tables, recipes, tags, etc.
            dataGen.addProvider(true, new ModLootTableProvider(dataGen));
            dataGen.addProvider(true, new ModRecipeProvider(dataGen));
        }
    }
}
