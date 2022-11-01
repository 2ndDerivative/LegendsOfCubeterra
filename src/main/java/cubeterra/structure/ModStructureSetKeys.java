package cubeterra.structure;

import cubeterra.Entrypoint;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public interface ModStructureSetKeys {
    RegistryKey<StructureSet> CURSED_PYRAMIDS = of("cursed_desert_pyramids");

    private static RegistryKey<StructureSet> of(String id) {
        return RegistryKey.of(Registry.STRUCTURE_SET_KEY, Entrypoint.identify(id));
    }
}
