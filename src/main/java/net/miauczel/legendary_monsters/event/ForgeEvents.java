package net.miauczel.legendary_monsters.event;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.LightningParticle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulStrike;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.item.custom.SoulGreatSwordItem;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.BlockUtils;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.miauczel.legendary_monsters.util.ModSavedData;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

import static net.miauczel.legendary_monsters.util.MathUtils.PI;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ForgeEvents {

    @SubscribeEvent
    public static void onCheckSpawn(MobSpawnEvent.SpawnPlacementCheck event) {
        if (event.getEntityType() != ModEntities.FLAMEBORN_GUARD.get()) return;
        if (!(event.getLevel() instanceof net.minecraft.server.level.ServerLevel serverLevel)) return;

        if (!ModSavedData.get(serverLevel).isDefeatedObliterator()) {
            //  event.setResult(net.minecraftforge.eventbus.api.Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void ejectpassengers(EntityMountEvent event) {
        Entity mountedEntity = event.getEntityBeingMounted();
        Entity mounter = event.getEntityMounting();
        if (mounter instanceof IAnimatedMonster && (mountedEntity instanceof Boat || mountedEntity instanceof Minecart)) {
            event.setCanceled(true);
        }
    }

    public static void createSweep(LivingEntity livingEntity, float pos, float posOffset, float yHeight, double additionalY, boolean reverse, float scale, float rot, boolean small) {
        float f = Mth.cos(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        double theta = (livingEntity.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = pos;
        float offset = posOffset;
        double x = (livingEntity.getX() + vec * vecX + f * offset);
        double z = (livingEntity.getZ() + vec * vecZ + f1 * offset);
        double d0 = x;
        double d1 = livingEntity.getY() + livingEntity.getBbHeight() / 2 + additionalY;
        double d2 = z;
        float yaw = (float) Math.toRadians(-livingEntity.yBodyRot + (reverse ? rot : 180));
        double lookX = -Math.cos(yaw);
        double lookZ = -Math.sin(yaw);
        float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
        // livingEntity.level().addParticle(new SoulSweepParticle.SweepData(livingEntity.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);
        ParticleOptions particleOptions = new SoulSweepParticle.SweepData(livingEntity.getScale() * scale, yaw, pitch);
        ParticleUtils.sendParticlesToServer(livingEntity.level(), particleOptions, d0, d1, d2, 1, 0, 0, 0, 0);
        createCircularLightningParticle(livingEntity, 0, 1.5f, 0, 2, 1f);
    }

    public static Random random = new Random();

    public static void createCircularLightningParticle(LivingEntity livingEntity, float vec, float y, float offset, int part, float size) {

        float f = Mth.cos(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        double theta = (livingEntity.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int floor = Mth.floor(livingEntity.getY());

        double d0 = (random.nextFloat() - 0.5F) + livingEntity.getDeltaMovement().x;
        double d1 = (random.nextFloat() - 0.5F) + livingEntity.getDeltaMovement().y;
        double d2 = (random.nextFloat() - 0.5F) + livingEntity.getDeltaMovement().z;
        double dist = 1F + random.nextFloat() * 0.2F;
        double d3 = d0 * dist;
        double d4 = d1 * dist;
        double d5 = d2 * dist;

        ParticleUtils.sendParticlesToServer(livingEntity.level(), ModParticles.SOUL_EXPLOSION.get(),
                (livingEntity.getX() + vec * vecX + f * offset), livingEntity.getY() + y, (livingEntity.getZ() + vec * vecZ + f1 * offset), 1, 0, 0, 0, 0);

        ParticleUtils.sendParticlesToServer(livingEntity.level(), new Circle.RingData(0, 0, 20, 0.2f, 0.75f, 0.8f, 1, 10, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                (livingEntity.getX() + vec * vecX + f * offset), livingEntity.getY() + y, (livingEntity.getZ() + vec * vecZ + f1 * offset), 1, 0, 0, 0, 0);

        ParticleUtils.sendParticlesToServer(livingEntity.level(), new Circle.RingData(0, PI / 2f, 20, 0.2f, 0.75f, 0.8f, 1, 70, false, Circle.EnumRingBehavior.GROW),
                (livingEntity.getX() + vec * vecX + f * offset), livingEntity.getY() + 0.25f, (livingEntity.getZ() + vec * vecZ + f1 * offset), 1, 0, 0, 0, 0);

        ParticleUtils.sendParticlesToServer(livingEntity.level(), new LightningParticle.OrbData(64, 226, 237),
                (livingEntity.getX() + vec * vecX + f * offset), livingEntity.getY() + y, (livingEntity.getZ() + vec * vecZ + f1 * offset), 1,
                0, d4, 0, 0);


    }

    @SubscribeEvent
    public static void onEntityTeleport(EntityTeleportEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity livingEntity && (livingEntity.getVehicle() instanceof IAnimatedMonster || livingEntity.getVehicle() instanceof EntityThrownEntity)) {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public static void addDamage(LivingHurtEvent livingHurtEvent){
        if (!(livingHurtEvent.getEntity() instanceof IAnimatedBoss boss))return;
        boss.addDamage(livingHurtEvent.getAmount(),livingHurtEvent.getSource());
    }
    @SubscribeEvent
    public static void onLivingHurt(LivingAttackEvent event) {

        DamageSource damageSource = event.getSource();
        LivingEntity attackedEntity = event.getEntity();
        Entity attacker1 = damageSource.getDirectEntity();

        float sweepSize = 1f;
        float sweepRot = 20;
        float bigSweepHeight = 3;
        float bigSweepAdditionalY = 1;

        if (attackedEntity instanceof Player player) {
            ItemStack stack = player.getUseItem();
            AttributeInstance attributeInstance = player.getAttribute(Attributes.ATTACK_DAMAGE);
            assert attributeInstance != null;
            float attackAttributeValue = (float) attributeInstance.getValue();

            if (stack.is(ModItems.SOUL_GREAT_SWORD.get()) && player.isUsingItem() && !(damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || damageSource.is(DamageTypeTags.BYPASSES_ARMOR)) && !player.isShiftKeyDown()
                    && ModConfig.MOB_CONFIG.canSoulGreatSwordUseParry.get()) {


                if (player.getUseItem().getItem() instanceof SoulGreatSwordItem item) {
                    if (item.timeUsed > item.maxUseDuration()) return;
                    if (attacker1 instanceof LivingEntity parriedMob) {
                        boolean hurt = parriedMob.hurt(attacker1.damageSources().playerAttack(player), attackAttributeValue + MathUtils.percentValue(event.getAmount(), 30));

                        AABB aabb = new AABB(BlockUtils.blockPosVec3(parriedMob.position()));
                        for (LivingEntity listEntity : player.level().getEntitiesOfClass(LivingEntity.class, aabb.inflate(2, 2.5, 2))) {
                            if (listEntity == parriedMob || listEntity == player) continue;
                            if (listEntity instanceof TamableAnimal tamableAnimal && tamableAnimal.getOwner() == player)
                                continue;
                            if (listEntity != null)
                                listEntity.hurt(listEntity.damageSources().playerAttack(player), attackAttributeValue);
                        }
                        if (hurt) {
                            event.setCanceled(true);
                            item.parrySucced = true;

                            //  System.out.println("Cooldown: " + item.getCooldown() + " ITEM: " + player.getUseItem());
                            CameraShakeEntity.cameraShake(player.level(), player.position(), 10, 0.2f, 2, 2);
                            player.level().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.BLOCK.get(), SoundSource.PLAYERS, 2, 1f);
                            player.level().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SOUL_FLY.get(), SoundSource.PLAYERS, 2, 1f);
                            createSweep(player, 0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                            player.heal(MathUtils.percentValue(player.getMaxHealth(), 20));
                            float f = Mth.cos(player.yBodyRot * ((float) Math.PI / 180F));
                            float f1 = Mth.sin(player.yBodyRot * ((float) Math.PI / 180F));
                            double theta = (player.yBodyRot) * (Math.PI / 180);
                            theta += Math.PI / 2;
                            double vecX = Math.cos(theta);
                            double vecZ = Math.sin(theta);
                            float angle = 360.0F / 9;
                            for (int i = 0; i < 9; i++) {
                                SoulStrike peq = new SoulStrike(player.level(), player, false);
                                peq.setDamage((float) 9);
                                peq.shootFromRotation(player, 0, angle * i, 0.0F, 0.45F, 0.0F);
                                peq.setPos(player.getX() + 0 * vecX + f * 1.5, player.getY() + 0.3D, player.getZ() + 0 * vecZ + f1 * 1.5);
                                // player.level().addFreshEntity(peq);
                            }
                        }

                    }
                }

            }
        }
      /*  if (attackedEntity instanceof Player player) {
            if (damageSource.is(DamageTypes.GENERIC)){
                ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);
                if (itemStack.is(ModItems.ANNIHILATOR_BOOTS.get())) {
                    attackedEntity.setDeltaMovement(0,2,0);
                    EntityUtil.applyPlayerDeltaMovement(player);
                }
            }
        }*/
        if (attacker1 instanceof Player attacker) {
            if (damageSource.typeHolder().is(ModDamageTypes.ANNIHILATION)) return;

            if (attacker != null && attackedEntity != null) {
                if (attacker.fallDistance > 0.0f && attacker.getAttackStrengthScale(0.5f) >= 1) {
                    ItemStack itemStack = attacker.getItemBySlot(EquipmentSlot.LEGS);
                    if (itemStack.is(ModItems.ANNIHILATOR_LEGGINGS.get())) {
                        if (attacker.getRandom().nextInt() * 100 < 25) {
                            AttributeInstance attributeInstance = attacker.getAttribute(Attributes.ATTACK_DAMAGE);
                            if (attacker.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) && attributeInstance != null) {
                                float damage = (float) attributeInstance.getValue();
                                float uBox = 3;
                                BlockPos blockPos = BlockUtils.blockPosVec3(attacker.position());
                                AABB aabb = new AABB(blockPos).inflate(uBox);
                                List<LivingEntity> list = attacker.level().getEntitiesOfClass(LivingEntity.class, aabb);
                                for (LivingEntity entity : list) {

                                    if (entity != attacker && entity != attackedEntity)
                                        entity.hurt(new DamageSource(attackedEntity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                                .getHolderOrThrow(ModDamageTypes.ANNIHILATION), attacker), damage / 2);
                                }
                                Level level = attacker.level();
                                level.playSound(null, BlockUtils.blockPosVec3(attackedEntity.position()), ModSounds.ENERGY_EXPLOSION.get(), SoundSource.PLAYERS, 1, 1);
                                double d1 = attackedEntity.getX();
                                double d2 = attackedEntity.getY();
                                double d3 = attackedEntity.getZ();
                                ParticleOptions particleOptions2 = ModParticles.ANNIHILATION_FLAME_STRIKE.get();
                                ParticleOptions particleOptions = new Circle.RingData((float) 0, (float) (Math.PI / 2), 30, 0, 1, 0, 1, 100, false, Circle.EnumRingBehavior.GROW);
                                level.addParticle(particleOptions, d1, d2, d3, 0, 0, 0);

                                float multiplier = 3;
                                float size = 2;
                                float amountOfFlames = 7;
                                for (int k = 0; k < amountOfFlames; ++k) {
                                    float f3 = (float) k * (float) Math.PI * size / amountOfFlames + ((float) Math.PI * size / 10F);
                                    if (level instanceof ServerLevel level1)
                                        level1.sendParticles(particleOptions2, d1 + Mth.cos(f3) * multiplier, d2 + 2, d3 + Mth.sin(f3) * multiplier, 0, 0, 0, 0, 0);
                                    level.addParticle(particleOptions2, d1 + Mth.cos(f3) * multiplier, d2 + 2, d3 + Mth.sin(f3) * multiplier, 0, 0, 0);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}
