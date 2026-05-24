package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.client.ModBlockEntityWithoutLevelRenderer;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownResurrectedJavelin;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.UUID;

public class ResurrectedJavelinItem extends Item implements Vanishable {


    public ResurrectedJavelinItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pProperties.defaultDurability(1250));
        resetUseTime();
    }

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND)return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 9 * ModConfig.MOB_CONFIG.ResurrectedJavelinDamageMultiplier.get();
        double speed = -2.7D * ModConfig.MOB_CONFIG.ResurrectedJavelinSpeedMultiplier.get();
        double range = 1.35D * ModConfig.MOB_CONFIG.ResurrectedJavelinRangeMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", range, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }


    @Override
    public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
        consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ModBlockEntityWithoutLevelRenderer.INSTANCE;
            }
        });
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.shattered_greatsword1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

    }

    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public int useDuration = 0;

    public int getDurationOfUse() {
        return useDuration;
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player $$4) {
            int $$5 = this.getUseDuration(pStack) - pTimeLeft;
            resetUseTime();
            if ($$5 >= 10) {
                int $$6 = EnchantmentHelper.getRiptide(pStack);
                if ($$6 <= 0 || $$4.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(1, $$4, (p_43388_) -> p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                        if ($$6 == 0) {
                            ThrownResurrectedJavelin $$7 = new ThrownResurrectedJavelin(pLevel, $$4, pStack);
                            $$7.shootFromRotation($$4, $$4.getXRot(), $$4.getYRot(), 0.0F, 2.5F + (float) $$6 * 0.5F, 1.0F);
                            if ($$4.getAbilities().instabuild) {
                                $$7.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity($$7);
                            pLevel.playSound((Player) null, $$7, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                            if (!$$4.getAbilities().instabuild) {
                                $$4.getInventory().removeItem(pStack);
                            }
                        }
                    }

                    $$4.awardStat(Stats.ITEM_USED.get(this));
                    if ($$6 > 0) {
                        float $$8 = $$4.getYRot();
                        float $$9 = $$4.getXRot();
                        float $$10 = -Mth.sin($$8 * ((float) Math.PI / 180F)) * Mth.cos($$9 * ((float) Math.PI / 180F));
                        float $$11 = -Mth.sin($$9 * ((float) Math.PI / 180F));
                        float $$12 = Mth.cos($$8 * ((float) Math.PI / 180F)) * Mth.cos($$9 * ((float) Math.PI / 180F));
                        float $$13 = Mth.sqrt($$10 * $$10 + $$11 * $$11 + $$12 * $$12);
                        float $$14 = 3.0F * ((1.0F + (float) $$6) / 4.0F);
                        $$10 *= $$14 / $$13;
                        $$11 *= $$14 / $$13;
                        $$12 *= $$14 / $$13;
                        $$4.push((double) $$10, (double) $$11, (double) $$12);
                        $$4.startAutoSpinAttack(20);
                        if ($$4.onGround()) {
                            float $$15 = 1.1999999F;
                            $$4.move(MoverType.SELF, new Vec3((double) 0.0F, (double) 1.1999999F, (double) 0.0F));
                        }

                        SoundEvent $$16;
                        if ($$6 >= 3) {
                            $$16 = SoundEvents.TRIDENT_RIPTIDE_3;
                        } else if ($$6 == 2) {
                            $$16 = SoundEvents.TRIDENT_RIPTIDE_2;
                        } else {
                            $$16 = SoundEvents.TRIDENT_RIPTIDE_1;
                        }
                        pLevel.playSound((Player) null, $$4, $$16, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    int defaultUseTime = 0;

    public void resetUseTime() {
        useDuration = 0;
        defaultUseTime = 0;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        Player player = (Player) pEntity;

        if (!pIsSelected && getDurationOfUse() > 0 && pStack == player.getItemInHand(InteractionHand.MAIN_HAND)) resetUseTime();
        System.out.println("Is_Selected: " + pIsSelected);
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        defaultUseTime++;
        useDuration = this.getUseDuration(itemstack) - defaultUseTime;
        return InteractionResultHolder.consume(itemstack);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43414_) -> p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if ((double) pState.getDestroySpeed(pLevel, pPos) != (double) 0.0F) {
            pStack.hurtAndBreak(2, pEntityLiving, (p_43385_) -> p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.TRIDENT;
    }

    public int getEnchantmentValue() {
        return 1;
    }
}
