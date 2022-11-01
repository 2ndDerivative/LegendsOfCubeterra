package cubeterra.structure;

import cubeterra.world.gen.structure.ModStructures;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.structure.Structure;

public interface ModStructureSets {
    RegistryEntry<StructureSet> CURSED_PYRAMIDS = register(ModStructureSetKeys.CURSED_PYRAMIDS, ModStructures.CURSED_DESERT_PYRAMID, new RandomSpreadStructurePlacement(50, 10,SpreadType.LINEAR, 14356617));

    static RegistryEntry<StructureSet> register(RegistryKey<StructureSet> key, StructureSet structureSet) {
        return BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_SET, key, structureSet);
    }

    static RegistryEntry<StructureSet> register(RegistryKey<StructureSet> key, RegistryEntry<Structure> structure, StructurePlacement placement) {
        return register(key, new StructureSet(structure, placement));
    }

    static void initialize() {}
}
