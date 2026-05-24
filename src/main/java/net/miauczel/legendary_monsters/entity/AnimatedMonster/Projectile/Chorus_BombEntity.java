package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;

public class Chorus_BombEntity extends ThrowableProjectile {

    public Chorus_BombEntity(EntityType<Chorus_BombEntity> type, Level world) {
        super(type, world);
    }

    public Chorus_BombEntity(EntityType<Chorus_BombEntity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
        this.setOwner(thrower);
    }

    @Override
    protected void defineSynchedData() {
    }
    public void performAreaAttack() {
        double attackRadius = 3.5;
        double attackHeight = 3.5;

        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this) {
                if (!(entity instanceof CameraShakeEntity)) {
                    if (this.getOwner() instanceof LivingEntity owner && !(entity instanceof DuneSentinelEntity)) {
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 80, 0));

                        this.doEnchantDamageEffects(owner,entity);
                    }
                }
            }
        }
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!this.level().isClientSide) {
            Entity entity = result.getEntity();
            if (this.getOwner() instanceof LivingEntity owner && !(entity instanceof DuneSentinelEntity)) {
                boolean flag = entity.hurt(this.damageSources().thrown(this, owner), 8.0F);
                if(entity instanceof LivingEntity livingEntity) {
                    performAreaAttack();
                    if(!(entity == this.getOwner())) {
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 80, 0));
                    }
                }
            } else {

                if (!(entity instanceof DuneSentinelEntity)) {
                    performAreaAttack();    
                    entity.hurt(this.damageSources().thrown(this, null), 8.0F);
                    if(entity instanceof LivingEntity livingEntity && !(entity == this.getOwner())) {

                        livingEntity.addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 80, 0));
                    }

                }

            }

        }

    }



    @Override
    public void onHit(HitResult result) {
        if(this.getOwner() instanceof Player || this.getOwner() instanceof ServerPlayer) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, Level.ExplosionInteraction.NONE);
        }else{
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.NONE);
        }
        super.onHit(result);
        this.performAreaAttack();
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1, 1);
        CameraShakeEntity.cameraShake(this.level(), this.position(), 40.0F, 0.3F, 0, 20);
        this.discard();

    }






    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            Vec3 vec3 = this.getDeltaMovement();
            this.level().addParticle(ParticleTypes.END_ROD, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            BlockState sandState = Blocks.CHORUS_FLOWER.defaultBlockState();
            this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, sandState), this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            this.level().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected float getGravity() {
        return 0.03F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}


