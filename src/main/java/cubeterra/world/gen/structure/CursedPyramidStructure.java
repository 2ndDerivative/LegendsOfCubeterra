package cubeterra.world.gen.structure;

import com.mojang.serialization.Codec;
import cubeterra.structure.CursedDesertTempleGenerator;
import net.minecraft.world.gen.structure.BasicTempleStructure;
import net.minecraft.world.gen.structure.StructureType;

public class CursedPyramidStructure extends BasicTempleStructure {
    public static final Codec<CursedPyramidStructure> CODEC = createCodec(CursedPyramidStructure::new);

    public CursedPyramidStructure(Config config) {
        super(CursedDesertTempleGenerator::new, 21, 21, config);
    }

    public StructureType<?> getType() {
        return ModStructureType.CURSED_DESERT_TEMPLE;
    }
}
