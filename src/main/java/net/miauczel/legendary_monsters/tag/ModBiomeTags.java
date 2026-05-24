package net.miauczel.legendary_monsters.tag;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public interface ModBiomeTags {
    TagKey<Biome> ANCIENT_STRONGHOLD_BIOMES = create("ancient_stronghold_biomes");
    TagKey<Biome> ANCIENT_TOWER_REMAINS_BIOMES = create("ancient_tower_remains_biomes");
    TagKey<Biome> SHULKER_TOWER_BIOMES = create("shulker_temple_biomes");
    TagKey<Biome> FROSTBITTEN_TEMPLE_BIOMES = create("frostbitten_temple_biomes");
    TagKey<Biome> SKELETOSAURUS_NEST_BIOMES = create("skeletosaurus_nest_biomes");
    TagKey<Biome> SOUL_FORTRESS_REMAINS_BIOMES = create("soul_fortress_remains_biomes");
    TagKey<Biome> MOSSY_TEMPLE_BIOMES = create("mossy_temple_biomes");
    TagKey<Biome> CLOUDY_TEMPLE_BIOMES = create("cloudy_temple_biomes");
    TagKey<Biome> LAVA_EATER_SPAWN_BIOMES = create("lava_eater_spawn_biomes");
    TagKey<Biome> COLLAPSED_KINGDOM_BIOMES = create("collapsed_kingdom_biomes");


    private static TagKey<Biome> create(String pName) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(LegendaryMonsters.MOD_ID, pName));


    }
}
