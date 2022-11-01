package cubeterra.fluid;

import cubeterra.Entrypoint;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static FlowableFluid CURSED_TEARS = register("cursed_tears", new CursedTearsFluid.Still());
    public static FlowableFluid CURSED_TEARS_FLOWING = register("flowing_cursed_tears", new CursedTearsFluid.Flowing());

    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registry.FLUID, Entrypoint.identify(id), value);
    }
}
