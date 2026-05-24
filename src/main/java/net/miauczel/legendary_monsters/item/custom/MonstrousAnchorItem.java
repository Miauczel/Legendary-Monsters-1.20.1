package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;
import java.util.UUID;

public class MonstrousAnchorItem extends SwordItem implements IForgeItem {

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND) return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 13D * ModConfig.MOB_CONFIG.MonstrousAnchorDamageMultiplier.get();
        double speed = -3.35D * ModConfig.MOB_CONFIG.MonstrousAnchorSpeedMultiplier.get();
        double range = 0.75D * ModConfig.MOB_CONFIG.MonstrousAnchorRangeMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", range, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }

    public MonstrousAnchorItem() {

        super(new Tier() {
            public int getUses() {
                return 1100;
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
                return Ingredient.of(new ItemStack(Blocks.IRON_BLOCK));
            }
        }, 14, -3.5f, new Properties().fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.m_anchor1"));
        list.add(Component.translatable("item.legendary_monsters.m_anchor2"));
        list.add(Component.translatable("item.legendary_monsters.m_anchor3"));

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        double dashRadius = 3;
        AABB areaOfEffect = pTarget.getBoundingBox().inflate(dashRadius);
        List<LivingEntity> entities = pTarget.level().getEntitiesOfClass(LivingEntity.class, areaOfEffect);

        for (LivingEntity target : entities) {
            if (target != pAttacker && target != null) {
                if (pAttacker instanceof Player player) {
                    if (player.getAttackStrengthScale(0.5F) >= 1.0F && player.fallDistance == 0) {
                        DamageSource damageSource = new DamageSource(pAttacker.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), pAttacker);
                        target.hurt(damageSource, (float) (6 * ModConfig.MOB_CONFIG.MonstrousAnchorAbilityDamageMultiplier.get()));
                    }
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {

            int useDuration = this.getUseDuration(stack) - timeLeft;

            Level level = player.level();
            BlockPos blockPos = player.getOnPos();
            Vec3 vec3 = blockPos.getCenter();

            if (useDuration >= 15) {
                CameraShakeEntity.cameraShake(player.level(), player.position(), 10.0F, 0.3F, 0, 15);
                if (!player.getCooldowns().isOnCooldown(this)) {
                    for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(3))) {
                        if (entity == player) continue;
                        if (entity instanceof Player player1 && player1.getAbilities().invulnerable) continue;
                        if (entity instanceof TamableAnimal animal && animal.isTame() && animal.getOwner() == player)
                            continue;

                        entity.push(0, 0.6f, 0);
                        entity.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 60, 0));
                    }
                    if (level.isClientSide) {
                        level.addParticle(new Circle.RingData((float) 0, (float) (Math.PI / 2), 30, 1, 1, 1, 1, 50, false, Circle.EnumRingBehavior.GROW)
                                , vec3.x, player.getY(), vec3.z, 0, 0, 0);

                        for (int i = 0; i < 360; i++) {
                            if (i % 2 == 0) {
                                double d1 = player.getRandom().nextGaussian() * 0.25f;
                                double d2 = player.getRandom().nextGaussian() * 0.25f;
                                double d3 = player.getRandom().nextGaussian() * 0.25f;
                                double angle = (Math.toRadians(-player.getYRot() + 180)) + i;
                                double x = Mth.sin((float) (Math.PI * angle));
                                double z = Mth.cos((float) (Math.PI * angle));
                                level.addParticle(ModParticles.LM_COSY_SMOKE.get(), vec3.x + x, vec3.y + 1, vec3.z + z, d1, d2, d3);
                            }
                        }
                    }

                    player.playSound(SoundEvents.IRON_GOLEM_REPAIR, 1, 1);
                    player.getCooldowns().addCooldown(this, 100);
                }
            }
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }
}


