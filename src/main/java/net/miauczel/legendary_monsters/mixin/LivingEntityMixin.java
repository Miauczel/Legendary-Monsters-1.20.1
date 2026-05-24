package net.miauczel.legendary_monsters.mixin;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Shadow
    public abstract boolean hasEffect(MobEffect p_21024_);

    @Inject(
            method = "canAttack(Lnet/minecraft/world/entity/LivingEntity;)Z",
            remap = true,
            at = @At("HEAD"),
            cancellable = true
    )
    public void canAttack(LivingEntity p_21171_, CallbackInfoReturnable<Boolean> booleanCallbackInfoReturnable) {
        if (this.hasEffect(ModEffects.STUN.get())) {
            booleanCallbackInfoReturnable.setReturnValue(false);
        }
    }
}



