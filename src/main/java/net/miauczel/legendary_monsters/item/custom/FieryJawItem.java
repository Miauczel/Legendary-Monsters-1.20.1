package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FireBreath;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;
import java.util.UUID;

public class FieryJawItem extends AxeItem implements IForgeItem {
    public FieryJawItem() {

        super(new Tier()  {
            public int getUses() {
                return 750;
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
                return Ingredient.of(new ItemStack(ModItems.LAVA_EATERS_SKIN.get()));
            }
        }, 5, -3f, new Properties().fireResistant().rarity(Rarity.EPIC));
    }
    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND)return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 5 * ModConfig.MOB_CONFIG.FieryJawDamageMultiplier.get();
        double speed = -3D * ModConfig.MOB_CONFIG.FieryJawSpeedMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        Vec3 mouthPos = new Vec3(0, 1.75f, 0);
        entity.getCooldowns().addCooldown(this, 200);
        FireBreath breath = new FireBreath(ModEntities.FIRE_B.get(), entity.level(), (float) (7.5f*ModConfig.MOB_CONFIG.FieryJawAbilityDamageMultiplier.get())
                ,entity);
        breath.absMoveTo(mouthPos.x, mouthPos.y, mouthPos.z,entity.yHeadRot, entity.getXRot());
        entity.level().addFreshEntity(breath);
        FieryJawRightClicked.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
        return ar;
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.fiery_jaw1"));
        list.add(Component.translatable("item.legendary_monsters.fiery_jaw2"));
    }
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.DIGGER || enchantment == Enchantments.MENDING;
    }
}



