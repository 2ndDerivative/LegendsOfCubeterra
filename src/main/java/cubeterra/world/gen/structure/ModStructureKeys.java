package cubeterra.world.gen.structure;

import cubeterra.Entrypoint;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.structure.Structure;

public class ModStructureKeys {
    public static final RegistryKey<Structure> CURSED_DESERT_TEMPLE = of("cursed_desert_temple");

    private static RegistryKey<Structure> of(String id) {
        return RegistryKey.of(Registry.STRUCTURE_KEY, Entrypoint.identify(id));
    }
}
