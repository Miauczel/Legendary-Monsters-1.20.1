package net.miauczel.legendary_monsters.client;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ModItemProperties implements IClientItemExtensions {
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return new ModBlockEntityWithoutLevelRenderer();
    }
}
