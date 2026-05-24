package net.miauczel.legendary_monsters.tag;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;

public interface ModEntityTags {
     TagKey<EntityType<?>> POSSESSED_ARMOR_TEAM = create("possessed_armor_team");

    TagKey<EntityType<?>> ANNIHILATION_TEAM = create("annihilation_team");

    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID, pName));


    }

}
