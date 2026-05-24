package net.miauczel.legendary_monsters.item.custom.customArmor;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    MOSSY("mossy", 26, new int[]{ 5, 8, 5, 4 }, 25,
            SoundEvents.IRON_GOLEM_REPAIR, 2f, 0.5f, () -> Ingredient.of(Items.IRON_INGOT)),
    BLASTPROOF("bomber", 26, new int[]{ 3, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0.1f, () -> Ingredient.of(Items.IRON_INGOT)),
    BURNT("fiery", 26, new int[]{ 5, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_LEATHER, 2f, 0f, () -> Ingredient.of(ModItems.LAVA_EATERS_SKIN.get())),
    SHULKER("shulker", 26, new int[]{ (int)3.5, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_LEATHER, 2f, 0f, () -> Ingredient.of(Items.SHULKER_SHELL)),
    WITHER("wither", 26, new int[]{ 5, 7, 5, 4 }, 25,
            SoundEvents.BONE_BLOCK_BREAK, 2f, 0.1f, () -> Ingredient.of(Blocks.BONE_BLOCK)),
    CLOUDY("cloudy", 2, new int[]{ 6, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_LEATHER, 4f, 0f, () -> Ingredient.of(ModItems.CLOUD_ROD.get())),
    CHORUS("chorus", 22, new int[]{ (int)3.5, 7, 5, 4 }, 25,
    SoundEvents.ARMOR_EQUIP_LEATHER, 1f, 0f, () -> Ingredient.of(Items.CHORUS_FRUIT)),
    DINOSAUR_BONE("dinosaur_bone", 26, new int[]{ (int)3.5, 7, 5, 4 }, 25,
    SoundEvents.BONE_BLOCK_BREAK, 2f, 0.2f, () -> Ingredient.of(Blocks.BONE_BLOCK)),
    ANNIHILATOR("annihilator", 40, new int[]{ (int)6, 12, 8, 5 }, 35,
    SoundEvents.ARMOR_EQUIP_NETHERITE, 4f, 0.2f, () -> Ingredient.of(ModItems.ENDERITIUM_INGOT.get()));




    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return LegendaryMonsters.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
