package net.miauczel.legendary_monsters.worldgen;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ENDERSTONE_DEPOSIT = registerKey("add_enderstone_deposit");
    public static final ResourceKey<BiomeModifier> ADD_ENDERITIUM_ORE = registerKey("add_enderitium_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ENDERSTONE_DEPOSIT,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENDERSTONE_DEPOSITS_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
                ));

        context.register(ADD_ENDERITIUM_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENDERITIUM_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(LegendaryMonsters.MOD_ID, name));
    }
}
