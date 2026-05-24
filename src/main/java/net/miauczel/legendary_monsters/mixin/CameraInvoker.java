package net.miauczel.legendary_monsters.mixin;

import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Camera.class)
public interface CameraInvoker {
    @Invoker("getMaxZoom")
    double legendaryMonsters$invokeGetMaxZoom(double wantedDistance);

    @Invoker("move")
    void legendaryMonsters$invokeMove(double x, double y, double z);
}