package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.MovingTrailParticle;
import net.miauczel.legendary_monsters.client.ModBlockEntityWithoutLevelRenderer;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationPortalEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.UUID;

public class TheTesseractItem extends SwordItem {


    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    public TheTesseractItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot != EquipmentSlot.MAINHAND) {
            return super.getDefaultAttributeModifiers(slot);
        }

        double damage = 14D * ModConfig.MOB_CONFIG.TheTesseractDamageMultiplier.get();
        double speed = -2.8D * ModConfig.MOB_CONFIG.TheTesseractSpeedMultiplier.get();
        double range = 1D * ModConfig.MOB_CONFIG.TheTesseractRangeMultiplier.get();

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION)
        );

        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION)
        );

        builder.put(
                ForgeMod.ENTITY_REACH.get(),
                new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", range, AttributeModifier.Operation.ADDITION)
        );

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
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    public float maxChargeTick() {
        return 30;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {

        int useDuration = this.getUseDuration(pStack) - pRemainingUseDuration;
        if (useDuration == maxChargeTick()) pLivingEntity.playSound(ModSounds.ULTIMATE_FLAME_IMPACT.get(), 1, 1);
        CameraShakeEntity.cameraShake(pLivingEntity.level(), pLivingEntity.position(), 5, 0.025f, 1, 1);

        for (int k = 0; k < 3; k++) {
            float d1 = Mth.sqrt(k);
            float ran = 0.4f;
            float r = 0 / 255F;
            float g = 195 / 255F + pLivingEntity.getRandom().nextFloat() * ran;
            float b = 0 / 255F;
            if (pLevel.isClientSide)
                pLivingEntity.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.2f, 0.1f), pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), Mth.sin(k), 0, d1 * 0.01f);
        }

        if (useDuration % 15 == 0) {
            ParticleOptions particleOptions = new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK);
            //  level.sendParticles(particleOptions,pLivingEntity.getX(),  pLivingEntity.getY(),  pLivingEntity.getZ(),1,0,0,0,0);
            if (pLevel.isClientSide)
                pLevel.addParticle(particleOptions, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), 0, 0, 0);
            //pLivingEntity.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK),
            //       pLivingEntity.getX(),  pLivingEntity.getY(),  pLivingEntity.getZ(), 0, 0, 0);

        }
        for (int k = 0; k < 5; ++k) {
            float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
            float multiplier = 4f;

            // RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, consumer, poseStack, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            double dx = pLivingEntity.getX() + Mth.cos(f3) * multiplier;
            double dy = pLivingEntity.getY();
            double dz = pLivingEntity.getZ() + Mth.sin(f3) * multiplier;
            BlockPos blockPos = new BlockPos((int) dx, (int) ((int) dy), (int) dz);
            Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            //System.out.println("Pos: "+ blockPos);
            AABB aabb = new AABB(blockPos);
            for (Entity e : pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5))) {
                if (e instanceof LivingEntity livingentity && e != pLivingEntity) {
                    if (e instanceof Player && ((Player) e).getAbilities().invulnerable) continue;
                    //System.out.println("EXECUTING FOR..: " + pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5)));
                    // System.out.println("test");

                    Vec3 diff = livingentity.position().subtract(vec3.add(0, 0, 0));
                    diff = diff.normalize().scale(0.1);
                    livingentity.setDeltaMovement(livingentity.getDeltaMovement().subtract(diff));

                    EntityUtil.applyPlayerDeltaMovement(livingentity);

                }
            }
        }
        for (int k = 0; k < 5; ++k) {
            float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
            float multiplier = 7.5f;

            // RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, consumer, poseStack, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            double dx = pLivingEntity.getX() + Mth.cos(f3) * multiplier;
            double dy = pLivingEntity.getY();
            double dz = pLivingEntity.getZ() + Mth.sin(f3) * multiplier;
            BlockPos blockPos = new BlockPos((int) dx, (int) ((int) dy), (int) dz);
            Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            //System.out.println("Pos: "+ blockPos);
            AABB aabb = new AABB(blockPos);
            for (Entity e : pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5))) {
                if (e instanceof LivingEntity livingentity && e != pLivingEntity) {
                    if (e instanceof Player && ((Player) e).getAbilities().invulnerable) continue;
                    //System.out.println("EXECUTING FOR..: " + pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5)));
                    // System.out.println("test");

                    Vec3 diff = livingentity.position().subtract(vec3.add(0, 0, 0));
                    diff = diff.normalize().scale(0.1);
                    livingentity.setDeltaMovement(livingentity.getDeltaMovement().subtract(diff));

                    EntityUtil.applyPlayerDeltaMovement(livingentity);

                }
            }
        }
        double dx = pLivingEntity.getX();
        double dy = pLivingEntity.getY();
        double dz = pLivingEntity.getZ();
        BlockPos blockPos = new BlockPos((int) dx, (int) ((int) dy), (int) dz);
        Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        //System.out.println("Pos: "+ blockPos);
        AABB aabb = new AABB(blockPos);
        for (Entity e : pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5))) {
            if (e instanceof LivingEntity livingentity && e != pLivingEntity) {
                if (e instanceof Player && ((Player) e).getAbilities().invulnerable) continue;
                //System.out.println("EXECUTING FOR..: " + pLivingEntity.level().getEntities(pLivingEntity, aabb.inflate(1.5)));
                // System.out.println("test");

                Vec3 diff = livingentity.position().subtract(vec3.add(0, 0, 0));
                diff = diff.normalize().scale(0.1);
                livingentity.setDeltaMovement(livingentity.getDeltaMovement().subtract(diff));

                EntityUtil.applyPlayerDeltaMovement(livingentity);

            }
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    public int cooldown() {
        return MathUtils.toTicks(7.5f);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, -1);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(3);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {

        int useDuration = this.getUseDuration(pStack) - pTimeCharged;
        if (useDuration >= maxChargeTick()) {
            pLivingEntity.playSound(ModSounds.FLAME_BURST.get(), 1, 1);
            if (pLivingEntity instanceof Player player && !player.getCooldowns().isOnCooldown(this)) {
                int uniformWarmup = -15;

                //   CameraShakeEntity.cameraShake(pLivingEntity.level(),pLivingEntity.position(),5,0.15f,15,5);
                int lifeTick = 50;
                doPortalEffect(player, 7.5f, 2, 5, uniformWarmup, 2, lifeTick, 8);
                doPortalEffect(player, 4, 2, 5, uniformWarmup, 2, lifeTick, 8);
                AnnihilationPortalEntity annihilationPortalEntity = new AnnihilationPortalEntity(player.level(), player.getX(), player.getY(), player.getZ(), (float) 0, uniformWarmup, (LivingEntity) player,
                        lifeTick, (float) (12.5f * ModConfig.MOB_CONFIG.TheTesseractAbilityDamageMultiplier.get()), true, 4);
                player.level().addFreshEntity(annihilationPortalEntity);
                ParticleOptions particleOptions = new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK);

                //  level.sendParticles(particleOptions,pLivingEntity.getX(),  pLivingEntity.getY(),  pLivingEntity.getZ(),1,0,0,0,0);
                if (player.level().isClientSide)
                    player.level().addParticle(particleOptions, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), 0, 0, 0);
                player.getCooldowns().addCooldown(this, cooldown());
            }
        }
        // super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
    }

    public void doPortalEffect(Player player, double multiplier, float size, int amountOfPortals, int warmup, float scale, int life, float damage) {

        for (int k = 0; k < amountOfPortals; ++k) {
            float f3 = (float) k * (float) Math.PI * size / amountOfPortals + ((float) Math.PI * size / 10F);
            createAnnihilationPortal(player, player.getX() + Mth.cos(f3) * multiplier, player.getZ() + Mth.sin(f3) * multiplier, player.getY() - 5, player.getY() + 5, life, warmup, scale, (float) (damage * ModConfig.MOB_CONFIG.TheTesseractAbilityDamageMultiplier.get()));
        }
    }

    private void createAnnihilationPortal(Player player, double pX, double pZ, double pMinY, double pMaxY, int life, int pWarmupDelay, float scale, float damage) {
        BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
        boolean flag = false;
        double d0 = 0.0;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = player.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(player.level(), blockpos1, Direction.UP)) {
                if (!player.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = player.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(player.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(pMinY) - 1);

        if (flag) {
            player.level().addFreshEntity(new AnnihilationPortalEntity(player.level(), pX, (double) blockpos.getY() + d0, pZ, 0, pWarmupDelay, player, life, damage, true, scale));
        }

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);


        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.the_tesseract1"));
        list.add(Component.translatable("item.legendary_monsters.the_tesseract2"));

    }
}
