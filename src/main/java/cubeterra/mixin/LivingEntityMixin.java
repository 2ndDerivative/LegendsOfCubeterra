package cubeterra.mixin;

import cubeterra.access.EntityMixinHelper;
import cubeterra.entity.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public boolean isTouchingCursedTears() {
        return ((EntityMixinHelper)this).cubeterra$isTouchingTears();
    }
    @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;tickStatusEffects()V"))
    @SuppressWarnings("all")
    public void tearsCheck(CallbackInfo info) {
        if (this.isAlive() && this.isTouchingCursedTears()) {
            if(!this.hasStatusEffect(ModStatusEffects.WASTING_TOUCH) && ((Object)this) instanceof ServerPlayerEntity player){
                player.sendMessage(Text.translatable("message.cubeterra.cursed_by_tears"));
            }
            this.addStatusEffect(new StatusEffectInstance(ModStatusEffects.WASTING_TOUCH, 2400, 0));
        }
    }
}
