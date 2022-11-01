package cubeterra.entity.effect;

import cubeterra.Entrypoint;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect WASTING_TOUCH = register("wasting_touch", new WastingTouchStatusEffect());
    private static StatusEffect register(String id, StatusEffect entry) {
        return Registry.register(Registry.STATUS_EFFECT, Entrypoint.identify(id), entry);
    }
    public static void initialize(){
        //Entrypoint.MAINLOGGER.info("Status effects initialized.");
    }
}
