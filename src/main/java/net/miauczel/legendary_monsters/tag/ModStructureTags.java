package net.miauczel.legendary_monsters.tag;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface ModStructureTags {
    TagKey<Structure> FROSTBITTEN_TEMPLE_EYE_LOCATED = create("frostbitten_temple_eye_located");
    TagKey<Structure> ANCIENT_STRONGHOLD_EYE_LOCATED = create("ancient_stronghold_eye_located");
    TagKey<Structure> SOUL_FORTRESS_REMAINS_EYE_LOCATED = create("soul_fortress_remains_eye_located");

    TagKey<Structure> MOSSY_TEMPLE_EYE_LOCATED = create("mossy_temple_eye_located");
    TagKey<Structure> CLOUDY_TEMPLE_EYE_LOCATED = create("cloudy_temple_eye_located");
    TagKey<Structure> ANCIENT_TOWER_REMAINS_EYE_LOCATED = create("ancient_tower_remains_eye_located");
    TagKey<Structure> SHULKER_TOWER_EYE_LOCATED = create("shulker_tower_eye_located");

    TagKey<Structure> SKELETOSAURUS_NEST_EYE_LOCATED = create("skeletosaurus_nest_eye_located");
    TagKey<Structure> SPACE_STATION_EYE_LOCATED = create("space_station_eye_located");
    TagKey<Structure> ABANDONED_CRYPT_EYE_LOCATED = create("abandoned_crypt_eye_located");
    TagKey<Structure> LAVA_EATER_SPAWN_EYE_LOCATED = create("lava_eater_spawn_eye_located");
    TagKey<Structure> RUINED_PYRAMID_EYE_LOCATED = create("ruined_pyramid_eye_located");
    TagKey<Structure> COLLAPSED_KINGDOM_EYE_LOCATED = create("collapsed_kingdom_eye_located");

    private static TagKey<Structure> create(String pName) {
        return TagKey.create(Registries.STRUCTURE, new ResourceLocation(LegendaryMonsters.MOD_ID, pName));


    }
}
