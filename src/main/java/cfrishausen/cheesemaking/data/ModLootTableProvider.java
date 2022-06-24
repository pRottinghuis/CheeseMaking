package cfrishausen.cheesemaking.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ModLootTableProvider extends LootTableProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final Logger LOGGER = LogManager.getLogger();

    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    public static Map<ResourceLocation, LootTable> tables = new HashMap<>();
    protected final DataGenerator generator;

    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }
/*
    @Override
    public void run(CachedOutput p_236269_) {
        super.run(p_236269_);
    }

    private void writeTables(HashCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                DataProvider.save(GSON, cache, LootTables.serialize(lootTable), path);
            } catch (IOException e) {
                LOGGER.error("Couldn't write loot table {}", path, (Object) e);
            }
        });
        lootTables.forEach(blockBuilderMap -> {
            for (Map.Entry<Block, LootTable.Builder> entry : blockBuilderMap.entrySet()) {
                tables.put(entry.getKey().getLootTable(), entry.getValue().build());
            }
        });
    }*/
}

