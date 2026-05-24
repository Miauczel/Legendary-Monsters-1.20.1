package net.miauczel.legendary_monsters.worldgen.Structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface ModBuiltInStructures {

    ResourceKey<Structure> SHULKER_TOWER = createKey("shulker_tower");
    private static ResourceKey<Structure> createKey(String pName) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(pName));
    }
}
