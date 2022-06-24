package cfrishausen.cheesemaking.registry;

import cfrishausen.cheesemaking.CheeseMaking;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CheeseMaking.MOD_ID);

    public static final RegistryObject<Block> CHEESE_BLOCK = BLOCKS.register("cheese_block", () -> new Block(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK)));

}
