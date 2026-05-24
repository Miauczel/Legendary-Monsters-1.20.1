package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import java.util.List;
import java.util.UUID;


public class WitheredScytheItem extends Item {

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    public WitheredScytheItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND) return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 9 * ModConfig.MOB_CONFIG.WitheredScytheDamageMultiplier.get();
        double speed = -2.8D * ModConfig.MOB_CONFIG.WitheredScytheSpeedMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }

    public float dashBaseDamage() {
        return (float) (10 * ModConfig.MOB_CONFIG.WitheredScytheAbilityDamageMultiplier.get());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;

    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if ((double) pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
            pStack.hurtAndBreak(2, pEntityLiving, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);


        if (!player.getCooldowns().isOnCooldown(this)) {
            initialYRot = player.getYRot();
            initialXRot = player.getXRot();
            aTime = 20;

        }
        return InteractionResultHolder.consume(itemstack);
    }


    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.withered_scythe1"));
        list.add(Component.translatable("item.legendary_monsters.withered_scythe2"));
    }

    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.DIGGER || enchantment == Enchantments.MENDING;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (pEntity instanceof Player player) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == this) {
                g = this.getUseDuration(this.getDefaultInstance());
            }
        }


    }


    public int getEnchantmentValue() {
        return 1;
    }


    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            if (!player.getCooldowns().isOnCooldown(this)) {
                player.getCooldowns().addCooldown(this, 120);
            }


        }

        initialYRot = null;
        initialXRot = null;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.TOOT_HORN;
    }

    private Float initialYRot = null;
    private Float initialXRot = null;
    public boolean hasStartedOnGround = false;
    private int aTime = 30;

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player && aTime > 0 && initialYRot != null && initialXRot != null) {
            player.setYRot(initialYRot);
            player.setXRot(initialXRot);
        }

        if (aTime > 0) {
            --aTime;
        }
        if (aTime == 2) {
            if (pLivingEntity.onGround()) {
                hasStartedOnGround = true;
            }

        }
        if (aTime <= 0) {
            if (pLivingEntity instanceof Player player) {
                if (!player.getCooldowns().isOnCooldown(this)) {

                    hasStartedOnGround = false;
                    player.getCooldowns().addCooldown(this, 75);
                }


            }


        }
        if (!(aTime == 0)) {
            if (pLivingEntity instanceof Player player) {

                int i = this.getUseDuration(pStack) - pRemainingUseDuration;
                int t = Mth.clamp(i, 1, 4);
                float f7 = pLivingEntity.getYRot();
                float f = pLivingEntity.getXRot();
                float f1 = -Mth.sin(f7 * 0.017453292F) * Mth.cos(f * 0.017453292F);
                float f2 = -Mth.sin(f * 0.017453292F);
                float f3 = Mth.cos(f7 * 0.017453292F) * Mth.cos(f * 0.017453292F);
                float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 0.4F * ((float) t / 6.0F);
                f1 *= f5 / f4;
                f3 *= f5 / f4;
                if (hasStartedOnGround) {
                    pLivingEntity.push((double) f1, 0.0, (double) f3);
                } else {
                    if (pLivingEntity.onGround()) {

                        pLivingEntity.push((double) f1, 0.0, (double) f3);
                    }
                }
                if (pLivingEntity.onGround()) {
                    float f6 = 1.1999999F;
                    pLivingEntity.move(MoverType.SELF, new Vec3(0.0, (double) 0, 0.0));
                }
                double dashRadius = 1.25;
                AABB areaOfEffect = pLivingEntity.getBoundingBox().inflate(dashRadius);
                List<LivingEntity> entities = pLevel.getEntitiesOfClass(LivingEntity.class, areaOfEffect);

                for (LivingEntity target : entities) {
                    if (target != pLivingEntity && target != null && !(target instanceof TamableAnimal animal && animal.getOwner() == animal.getOwner())) {

                        DamageSource damageSource = new DamageSource(player.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), player);
                        target.hurt(damageSource, dashBaseDamage());
                        launch(player, target, false);
                        target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1), player);
                    }
                }
            }
        }
    }

    private void launch(LivingEntity pl, LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - pl.getX();
        double deltaZ = entity.getZ() - pl.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? 1.0F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.5 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    private int g;

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction)
                || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction);
    }
}








