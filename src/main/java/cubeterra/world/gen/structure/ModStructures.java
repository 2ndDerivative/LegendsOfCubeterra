package cubeterra.world.gen.structure;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.StructureSpawns;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.structure.Structure;

import java.util.Map;

public class ModStructures {
    private static Structure.Config createConfig(TagKey<Biome> biomeTag, Map<SpawnGroup, StructureSpawns> spawns, GenerationStep.Feature featureStep, StructureTerrainAdaptation terrainAdaptation) {
        return new Structure.Config(getOrCreateBiomeTag(biomeTag), spawns, featureStep, terrainAdaptation);
    }

    private static RegistryEntryList<Biome> getOrCreateBiomeTag(TagKey<Biome> key) {
        return BuiltinRegistries.BIOME.getOrCreateEntryList(key);
    }

    private static Structure.Config createConfig(TagKey<Biome> biomeTag, StructureTerrainAdaptation terrainAdaptation) {
        return createConfig(biomeTag, Map.of(), GenerationStep.Feature.SURFACE_STRUCTURES, terrainAdaptation);
    }

    public static RegistryEntry<Structure> CURSED_DESERT_PYRAMID = register(ModStructureKeys.CURSED_DESERT_TEMPLE, new CursedPyramidStructure(createConfig(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE, StructureTerrainAdaptation.NONE)));

    private static RegistryEntry<Structure> register(RegistryKey<Structure> key, Structure structure) {
        return BuiltinRegistries.add(BuiltinRegistries.STRUCTURE, key, structure);
    }
    /*public static void initialize() {
        Entrypoint.MAINLOGGER.info("Initializing structures");
    }*/
}
