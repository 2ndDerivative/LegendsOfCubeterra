package cubeterra.structure;

import cubeterra.Entrypoint;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;

public interface ModStructurePieceType {
    StructurePieceType CURSED_DESERT_TEMPLE = register(CursedDesertTempleGenerator::new, "cursed_desert_temple");

    private static StructurePieceType register(StructurePieceType structurePieceType, String name) {
        return Registry.register(Registry.STRUCTURE_PIECE, Entrypoint.identify(name), structurePieceType);
    }
    static void initialize(){
        Entrypoint.MAINLOGGER.info("Initializing structure piece types");
    }
}
