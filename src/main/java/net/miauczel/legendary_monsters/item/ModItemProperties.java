package net.miauczel.legendary_monsters.item;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        makeShield(ModItems.SHARP_BATTLE_AXE.get());
        makeShield(ModItems.DINOSAUR_BONE_SHIELD.get());
        makeShield(ModItems.FROSTBITTEN_SHIELD.get());
        makeShield(ModItems.SHULKER_SHIELD.get());
        makeShield(ModItems.SPIKY_SHIELD.get());
        makeShield(ModItems.BUCKLER_OF_ANNIHILATION.get());
        makeSpear(ModItems.RESURRECTED_JAVELIN.get());
        makeChargingWeapon(ModItems.ATOM_SPLITTER.get());
        soulGreatSword(ModItems.SOUL_GREAT_SWORD.get());

        ItemProperties.register(ModItems.ATOM_SPLITTER.get(), new ResourceLocation(LegendaryMonsters.MOD_ID, "charging"),
                (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);

    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, new ResourceLocation("blocking"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    private static void makeSpear(Item item) {
        ItemProperties.register(item, new ResourceLocation("throwing"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    private static void soulGreatSword(Item item) {
        ItemProperties.register(item, new ResourceLocation(LegendaryMonsters.MOD_ID, "parrying"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !livingEntity.isShiftKeyDown() ? 1.0F : 0.0F;
        });
        ItemProperties.register(item, new ResourceLocation(LegendaryMonsters.MOD_ID, "summoning"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && livingEntity.isShiftKeyDown() ? 1.0F : 0.0F;
        });
    }

    private static void makeChargingWeapon(Item item) {
        System.out.println("ACTIVATED: " + item);

    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (itemstack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemstack ? 0.0F : (float) (itemstack.getUseDuration() -
                        livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}