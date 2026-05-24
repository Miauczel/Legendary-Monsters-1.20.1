package net.miauczel.legendary_monsters.worldgen.Structure;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.tag.ModBiomeTags;
import net.miauczel.legendary_monsters.worldgen.Structure.Custom.CollapsedKingdom;
import net.miauczel.legendary_monsters.worldgen.Structure.Custom.LMJigsawStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.EndCityStructure;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {
    public static void bootstrap(BootstapContext<Structure> pContext){
        HolderGetter<Biome> holdergetter = pContext.lookup(Registries.BIOME);
        pContext.register(ModBuiltInStructures.SHULKER_TOWER, new EndCityStructure(StructureUtils.structure(holdergetter.getOrThrow(ModBiomeTags.SHULKER_TOWER_BIOMES), TerrainAdjustment.NONE)));
    }
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE_DEF_REG = DeferredRegister.create(Registries.STRUCTURE_TYPE, LegendaryMonsters.MOD_ID);
    public static final RegistryObject<StructureType<LMJigsawStructure>> LM_JIGSAW = STRUCTURE_TYPE_DEF_REG.register("lm_jigsaw", () -> () ->
            LMJigsawStructure.CODEC);
    public static final RegistryObject<StructureType<CollapsedKingdom>> COLLAPSED_KINGDOM = STRUCTURE_TYPE_DEF_REG.register("cp_kingdom", () -> () ->
            CollapsedKingdom.CODEC);

    public static void register(IEventBus eventBus) {
        STRUCTURE_TYPE_DEF_REG.register(eventBus);
    }
}
