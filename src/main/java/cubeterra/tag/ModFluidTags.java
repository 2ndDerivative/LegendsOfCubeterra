package cubeterra.tag;

import cubeterra.Entrypoint;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class ModFluidTags {
    public static final TagKey<Fluid> CURSED_TEARS = of("cursed_tears");

    private static TagKey<Fluid> of(String id) {
        return TagKey.of(Registry.FLUID_KEY, Entrypoint.identify(id));
    }
}
