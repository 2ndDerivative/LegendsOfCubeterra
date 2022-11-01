package cubeterra.item;

import cubeterra.Entrypoint;
import cubeterra.block.ModBlocks;
import cubeterra.fluid.ModFluids;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item SMOOTH_OBSIDIAN = register("smooth_obsidian", ModBlocks.SMOOTH_OBSIDIAN,new FabricItemSettings());
    public static final Item CURSED_TEARS_BUCKET = register("cursed_tears_bucket", new BucketItem(ModFluids.CURSED_TEARS, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    private static Item register(String id, Block block, Item.Settings settings) {
        return register(id, new BlockItem(block, settings));
    }
    private static Item register(String name, Item item) {
        return Registry.register(net.minecraft.util.registry.Registry.ITEM, Entrypoint.identify(name), item);
    }
    public static void initialize(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((content)->content.addBefore(Blocks.NETHERRACK, SMOOTH_OBSIDIAN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content)->content.addAfter(Items.LAVA_BUCKET, CURSED_TEARS_BUCKET));
    }
}
