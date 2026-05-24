package net.miauczel.legendary_monsters.item;


import net.miauczel.legendary_monsters.LegendaryMonsters;

import net.miauczel.legendary_monsters.tag.ModTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;
public class ModToolTiers {
    public static final Tier DINOSAUR_BONE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 700, 0.5f, 2f, 25,
                    ModTags.Blocks.NEEDS_DINOSAUR_BONE_TOOL, () -> Ingredient.of(ModItems.DINOSAUR_BONE.get())),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "dinosaur_bone"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1100, 0.5f, 2f, 25,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_GEM.get())),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "void"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier BRONZITE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 450, 6.5f, 2f, 14,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ModItems.VOID_GEM.get())),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "bronzite"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier Lightning = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3000, 10f, 2f, 25,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_GEM.get())),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "lightning"), List.of(Tiers.NETHERITE), List.of());

   public static final Tier ENDIRITIUM = TierSortingRegistry.registerTier(
           new ForgeTier(3, 2100, 9f, 3.5f, 15,
                   Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ModItems.ENDERITIUM_INGOT.get())),
           new ResourceLocation(LegendaryMonsters.MOD_ID, "enderitium"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier TESSERACT = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2100, 9f, 6f, 15,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ModItems.EYE_CRYSTAL.get())),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "tesseract"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier SHATTERED_GREATSWORD = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1500, 9f, 6f, 15,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "shattered_greatsword"), List.of(Tiers.NETHERITE), List.of());
}