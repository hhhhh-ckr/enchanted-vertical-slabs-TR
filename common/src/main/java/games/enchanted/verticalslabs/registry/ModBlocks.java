package games.enchanted.verticalslabs.registry;

import games.enchanted.verticalslabs.util.BlockAndItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static games.enchanted.verticalslabs.registry.RegistryHelpers.registerVerticalSlab;

public class ModBlocks {
    public static final BlockBehaviour.Properties OAK_WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB);

    public static final BlockAndItem BLOCK = registerVerticalSlab("vertical_oak_slab",OAK_WOOD);

    public static void register(){};
}
