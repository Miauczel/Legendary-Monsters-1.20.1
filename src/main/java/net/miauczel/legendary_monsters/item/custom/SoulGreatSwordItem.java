package net.miauczel.legendary_monsters.item.custom;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBeamEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownPhantomDaggerEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.custom.Capability.IParry;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.BlockUtils;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static net.miauczel.legendary_monsters.util.MathUtils.PI;

public class SoulGreatSwordItem extends SwordItem implements IParry {


    public SoulGreatSwordItem() {
        super(new Tier() {
            public int getUses() {
                return 2350;
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
                return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
            }
        }, 7, -3.1f, new Properties().rarity(Rarity.EPIC));

    }

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND) return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 12D * ModConfig.MOB_CONFIG.TheTesseractDamageMultiplier.get();
        double speed = -2.8D * ModConfig.MOB_CONFIG.TheTesseractSpeedMultiplier.get();
        double range = 1D * ModConfig.MOB_CONFIG.TheTesseractRangeMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", range, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, -1);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.soul_great_sword1").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("item.legendary_monsters.soul_great_sword2").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("item.legendary_monsters.soul_great_sword3").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("item.legendary_monsters.soul_great_sword4").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("item.legendary_monsters.soul_great_sword5").withStyle(ChatFormatting.GRAY));
    }


    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public int maxUseDuration() {
        return 3;
    }

    public int timeUsed = 0;

    public int getCooldown() {
        return 70;
    }

    public boolean parrySucced = false;


    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (entity instanceof Player player) {
            if (timeUsed % 5 == 0 && entity.isShiftKeyDown()) {
                int ucap = 5;
                float v = 0.075f;
                float endY = 1.5f;
                attractParticles(player, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 5, endY, v);
                attractParticles(player, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 3, endY, v);
                attractParticles(player, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 2, endY, v);
            }
        }
        if (level.isClientSide) return;
        if (timeUsed == 16) {
            level.playSound(null, entity.getOnPos(), ModSounds.OMINOUS_WIND_UP.get(), SoundSource.PLAYERS, 1, 1);
        }
        timeUsed++;

        if (entity instanceof Player player) {
            if (player.isShiftKeyDown()) calculateEndPos(player);

            if (timeUsed >= maxUseDuration() && !player.isShiftKeyDown() && ModConfig.MOB_CONFIG.canSoulGreatSwordUseParry.get()) {
                int cooldown = parrySucced ? getCooldown() : 20;
                player.getCooldowns().addCooldown(stack.getItem(), cooldown);
                parrySucced = false;
                timeUsed = 0;
                player.stopUsingItem();
            }
        }

        super.onUseTick(level, entity, stack, remainingUseDuration);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.consume(itemstack);
    }

    public void addShootParticles(Player player, double multiplier, float size, int amountOfParticles, double particleAdditionalY) {
        for (int k = 0; k < amountOfParticles; ++k) {
            float f3 = (float) k * (float) Math.PI * size / amountOfParticles + ((float) Math.PI * size / 10F);
            ParticleUtils.sendParticlesToServer(player.level(), ModParticles.SOUL_SHOOT.get(), player.getX() + Mth.cos(f3) * multiplier, player.getY() + particleAdditionalY, player.getZ() + Mth.sin(f3) * multiplier,
                    1, 0, 0, 0, 0);
        }
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level level, LivingEntity pLivingEntity, int pTimeCharged) {
        if (level.isClientSide) return;
        int cooldown = parrySucced ? getCooldown() : 20;
        if (pLivingEntity instanceof Player player) {
            if (player.isShiftKeyDown()) {
                if (timeUsed >= 20) {
                    player.getCooldowns().addCooldown(pStack.getItem(), 120);
                    spreadDaggers(player, 6);
                    CameraShakeEntity.cameraShake(level, player.position(), 10, 0.1f, 5, 5);
                    level.playSound(null, BlockUtils.blockPosVec3(player.position()), SoundEvents.WITHER_SHOOT, SoundSource.PLAYERS, 1, 1);
                    ParticleUtils.sendParticlesToServer(player.level(), new Circle.RingData(0, PI / 2f, 20, 0.2f, 0.75f, 0.8f, 1, 70, false, Circle.EnumRingBehavior.GROW),
                            (player.getX()), player.getY() + 0.25f, (player.getZ()), 1, 0, 0, 0, 0);
                    addShootParticles(player, 1.5, 2, 6, 1);

                }
            } else if (ModConfig.MOB_CONFIG.canSoulGreatSwordUseParry.get())
                player.getCooldowns().addCooldown(pStack.getItem(), cooldown);
        }
        timeUsed = 0;
        parrySucced = false;

        super.releaseUsing(pStack, level, pLivingEntity, pTimeCharged);
    }

    private void calculateEndPos(Player player) {
        double yawValue = ((player.yHeadRot + 90));
        double pitchValue = (-player.getXRot());

        double yawRad = Math.toRadians(yawValue);
        double pitchRad = Math.toRadians(pitchValue);
        float r = 15;
        endPosX = player.getX() + r * Math.cos(yawRad) * Math.cos(pitchRad);
        endPosZ = player.getZ() + r * Math.sin(yawRad) * Math.cos(pitchRad);
        endPosY = player.getY() + r * Math.sin(pitchRad);
        //System.out.println("X: " + endPosX + " Y: " + endPosY + " Z: " + endPosZ);
    }

    public void spreadDaggers(Player player, int count) {
        for (int i = 0; i < count; i++) {
            if (player != null) {
                float throwAngle = i * Mth.PI / (count / 2);

                double sx = player.getX() + (Mth.cos(throwAngle) * 1);
                double sy = player.getY() + (player.getBbHeight() * 0.2D);
                double sz = player.getZ() + (Mth.sin(throwAngle) * 1);

                double vx = Mth.cos(throwAngle);
                double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                double vz = Mth.sin(throwAngle);
                double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                ThrownPhantomDaggerEntity projectile = new ThrownPhantomDaggerEntity(ModEntities.THROWN_PHANTOM_DAGGER.get(), player.level());
                List<LivingEntity> hit = raytraceEntities(player, player.level(), new Vec3(player.getX(), player.getY(), player.getZ()), new Vec3(endPosX, endPosY, endPosZ), true).entities;
                for (LivingEntity entityHit : hit) {
                    if (entityHit == player) continue;
                    projectile.setReturnEntity(entityHit);
                }
                projectile.setOwner(player);
                projectile.setDamage(8);
                projectile.setReturnTick(10);
                projectile.moveTo(sx, sy, sz, i * 11.25F, player.getXRot());
                float speed = 0.7F;
                projectile.shoot(vx, 0, vz, speed, 1.0F);
                player.level().addFreshEntity(projectile);
            }
        }
    }

    public double collidePosX, collidePosY, collidePosZ;
    public double endPosX, endPosY, endPosZ;
    public Direction blockSide = null;

    public AnnihilationBeamEntity.LaserbeamHitResult raytraceEntities(Player player, Level world, Vec3 from, Vec3 to, boolean ignoreBlockWithoutBoundingBox) {
        AnnihilationBeamEntity.LaserbeamHitResult result = new AnnihilationBeamEntity.LaserbeamHitResult();
        result.setBlockHit(world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)));
        if (result.getBlockHit() != null) {
            Vec3 hitVec = result.getBlockHit().getLocation();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.getBlockHit().getDirection();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        float inflate = 1;
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(player.getX(), collidePosX),
                Math.min(player.getY(), collidePosY), Math.min(player.getZ(), collidePosZ), Math.max(player.getX(), collidePosX), Math.max(player.getY(), collidePosY), Math.max(player.getZ(), collidePosZ))
                .inflate(inflate, inflate, inflate));
        for (LivingEntity entity : entities) {
            if (entity == player) continue;
            if (entity instanceof TamableAnimal tamableAnimal && tamableAnimal.getOwner() == player) continue;

            float pad = entity.getPickRadius() + 0.5f;
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }


    Random random = new Random();

    Random random1 = new Random();

    public void attractParticles(Player player, ParticleOptions particleOptions, int cap, int reps, float vec, float offset, float startY, float endY, float velocity) {
        float yBodyRot = player.yBodyRot;
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        int rX = random1.nextInt(-cap, cap);
        int rZ = random1.nextInt(-cap, cap);

        float f2 = (this.random.nextFloat() - 0F) * 0.5F;
        double d1 = player.getX() + rX;
        double d2 = player.getY() + startY + f2;

        double d3 = player.getZ() + rZ;
        Vec3 vec3 = new Vec3(d1, d2, d3);
        Vec3 vec4 = new Vec3(player.getX() + vec * vecX + f * offset, player.position().y + endY, player.getZ() + vec * vecZ + f1 * offset);
        Vec3 vf = vec4.subtract(vec3);
        Vec3 v = vf.scale(velocity);
        for (int i = 0; i <= reps; i++) {
            // ParticleUtils.sendParticlesToServer(player.level(),particleOptions,d1,d2,d3,1,0,0,0,v.length());
            player.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);

        }
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }


}
