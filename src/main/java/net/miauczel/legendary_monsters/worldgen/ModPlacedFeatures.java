package net.miauczel.legendary_monsters.worldgen;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
public static final ResourceKey<PlacedFeature> ENDERSTONE_DEPOSITS_KEY = registerKey("enderstone_deposit_placed");
    public static final ResourceKey<PlacedFeature> ENDERITIUM_ORE_KEY = registerKey("enderitium_ore_placed");

public static void boostrap(BootstapContext<PlacedFeature> context){
    HolderGetter<ConfiguredFeature<?, ? >> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

register(context,ENDERSTONE_DEPOSITS_KEY,configuredFeatureHolderGetter.getOrThrow(ModConfiguredFeatures.ENDERSTONE_DEPOSIT_KEY)
        ,ModDepositPlacement.commonDepositPlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));

    register(context,ENDERITIUM_ORE_KEY,configuredFeatureHolderGetter.getOrThrow(ModConfiguredFeatures.ENDERITIUM_ORE_KEY)
            ,ModDepositPlacement.commonDepositPlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));


}


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(LegendaryMonsters.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
