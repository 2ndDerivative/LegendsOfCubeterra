package cubeterra.mixin;

import cubeterra.access.EntityMixinHelper;
import cubeterra.tag.ModFluidTags;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityMixinHelper {
    protected boolean cubeterra$touchingCursedTears;

    public boolean cubeterra$isTouchingTears(){
        return cubeterra$touchingCursedTears;
    }

    @Shadow
    public boolean updateMovementInFluid(TagKey<Fluid> fluidTag, double height) {return false;}
    @Shadow
    protected boolean firstUpdate;
    @Shadow
    protected void onSwimmingStart() {}
    @Shadow
    public void onLanding(){}
    @Shadow
    public void extinguish(){}

    void cubeterra$checkCursedTearState() {
        if (this.updateMovementInFluid(ModFluidTags.CURSED_TEARS, 0.014)) {
            if (!this.cubeterra$touchingCursedTears && !this.firstUpdate) {
                this.onSwimmingStart();
            }

            this.onLanding();
            this.cubeterra$touchingCursedTears = true;
            this.extinguish();
        } else {
            this.cubeterra$touchingCursedTears = false;
        }
    }
    @Inject(method="updateWaterState", at=@At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;checkWaterState()V"))
    public void cursedTearCheck(CallbackInfoReturnable<Boolean> cir) {
        this.cubeterra$checkCursedTearState();
    }
}
