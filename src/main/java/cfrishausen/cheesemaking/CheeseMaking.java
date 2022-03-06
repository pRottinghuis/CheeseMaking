package cfrishausen.cheesemaking;

import cfrishausen.cheesemaking.registry.ModBlocks;
import cfrishausen.cheesemaking.registry.ModItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CheeseMaking.MOD_ID)
public class CheeseMaking
{
    public static final String MOD_ID = "cheesemaking";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public CheeseMaking() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();

        addRegistries(mod);
    }

    private static void addRegistries(IEventBus mod) {
        ModBlocks.BLOCKS.register(mod);
        ModItems.ITEMS.register(mod);
    }
}
