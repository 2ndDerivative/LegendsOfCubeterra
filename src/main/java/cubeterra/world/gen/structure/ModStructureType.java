package cubeterra.world.gen.structure;

import com.mojang.serialization.Codec;
import cubeterra.Entrypoint;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public interface ModStructureType <S extends Structure>{
    StructureType<CursedPyramidStructure> CURSED_DESERT_TEMPLE = register("cursed_desert_pyramid", CursedPyramidStructure.CODEC);

    private static <S extends Structure> StructureType<S> register(String id, Codec<S> codec) {
        return Registry.register(Registry.STRUCTURE_TYPE, Entrypoint.identify(id), () -> codec);
    }

    static void initialize(){
        Entrypoint.MAINLOGGER.info("Initializing structure types");
    }
}
