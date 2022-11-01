package cubeterra.block;

import cubeterra.Entrypoint;
import cubeterra.fluid.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block SMOOTH_OBSIDIAN = register("smooth_obsidian", new Block(Block.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block CURSED_TEARS = register("cursed_tears", new FluidBlock(ModFluids.CURSED_TEARS, Block.Settings.copy(Blocks.WATER)));

    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, Entrypoint.identify(name), block);
    }
}
