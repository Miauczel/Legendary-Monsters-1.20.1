package net.miauczel.legendary_monsters.item.custom;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.UUID;

public class GoldenHalbertItem extends AxeItem {
    public GoldenHalbertItem() {
        super(new Tier() {
            public int getUses() {
                return 250;
            }

            public float getSpeed() {
                return 6f;
            }

            public float getAttackDamageBonus() {
                return 0f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 14;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Items.GOLD_INGOT));
            }
        }, 7, -3.1f, new Properties().rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.golden_halberd1"));
        list.add(Component.translatable("item.legendary_monsters.golden_halberd2"));

    }

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND) return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 5.5 * ModConfig.MOB_CONFIG.GuardAxeDamageMultiplier.get();
        double speed = -3.1D * ModConfig.MOB_CONFIG.GuardAxeSpeedMultiplier.get();
        double range = 0.7D * ModConfig.MOB_CONFIG.GuardAxeRangeMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", range, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }
}
