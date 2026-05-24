package net.miauczel.legendary_monsters.mixin;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(
            method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void lmHurt(DamageSource source, float amount, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> cir) {
        // UWAGA: w mixinie do Player możesz zrzutować this
        Player self = (Player)(Object)this;

        if (self.hasEffect(ModEffects.UNBREAKABLE.get())) {
            cir.setReturnValue(false); // blokuje obrażenia
        }
    }
}




