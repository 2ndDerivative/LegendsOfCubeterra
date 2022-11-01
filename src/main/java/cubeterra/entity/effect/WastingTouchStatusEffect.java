package cubeterra.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class WastingTouchStatusEffect extends StatusEffect {
    public WastingTouchStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x052315);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.getWorld().isClient()){
            entity.getWorld().getEntitiesByClass(LivingEntity.class,
                    entity.getBoundingBox().expand(0.5), (e) -> e != entity)
                    .forEach((e) -> e.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 12000, 1)));
        }
    }
}
