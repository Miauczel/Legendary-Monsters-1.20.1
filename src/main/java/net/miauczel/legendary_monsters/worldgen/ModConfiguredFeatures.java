package net.miauczel.legendary_monsters.worldgen;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERSTONE_DEPOSIT_KEY = registerKey("enderstone_deposit");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERITIUM_ORE_KEY = registerKey("enderitium_ore");

    public static void boostrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        RuleTest endStoneReplaceAble = new BlockMatchTest(Blocks.END_STONE);

        RuleTest endStoneReplaceAble1 = new BlockMatchTest(Blocks.END_STONE);
        List<OreConfiguration.TargetBlockState> enderstone_deposits = List.of(OreConfiguration.target(endStoneReplaceAble, ModBlocks.ENDERSTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> enderitium_ores = List.of(OreConfiguration.target(endStoneReplaceAble1, ModBlocks.ENDERITIUM_ORE.get().defaultBlockState()));

        register(context,ENDERSTONE_DEPOSIT_KEY,Feature.ORE, new OreConfiguration(enderstone_deposits,9));

        register(context,ENDERITIUM_ORE_KEY,Feature.ORE, new OreConfiguration(enderitium_ores,9));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(LegendaryMonsters.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
