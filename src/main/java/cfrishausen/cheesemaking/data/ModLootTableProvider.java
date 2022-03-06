package cfrishausen.cheesemaking.data;

import cfrishausen.cheesemaking.CheeseMaking;
import cfrishausen.cheesemaking.registry.ModBlocks;
import cfrishausen.cheesemaking.registry.ModItems;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Map;

public class ModLootTableProvider extends LootTableProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final Logger LOGGER = LogManager.getLogger();
    private final DataGenerator generator;

    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }

    @Override
    public void run(HashCache cache) {
        createSelfDrop(ModBlocks.CHEESE_BLOCK, cache);
    }

    public void createSelfDrop(RegistryObject<? extends Block> block, HashCache cache) {
        Path outputFolder = generator.getOutputFolder();
        LootTable table = new LootTable.Builder().withPool(new LootPool.Builder().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block.get())).when(ExplosionCondition.survivesExplosion())).setParamSet(LootContextParamSets.BLOCK).build();
        Path path = outputFolder.resolve("data/cheesemaking/loot_tables/blocks/" + block.getId().getPath() + ".json");
        try {
            DataProvider.save(GSON, cache, LootTables.serialize(table), path);
        } catch (Exception e) {
            LOGGER.error("Couldn't write loot table {}", path, e);
        }
    }
}
