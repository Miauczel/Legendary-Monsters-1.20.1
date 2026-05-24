        package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

        import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
        import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
        import net.minecraft.core.particles.BlockParticleOption;
        import net.minecraft.core.particles.ParticleTypes;
        import net.minecraft.nbt.CompoundTag;
        import net.minecraft.network.protocol.Packet;
        import net.minecraft.network.protocol.game.ClientGamePacketListener;
        import net.minecraft.server.level.ServerPlayer;
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

        public class BombEntity extends ThrowableProjectile {

                public BombEntity(EntityType<BombEntity> type, Level world) {
                    super(type, world);
                }

                public BombEntity(EntityType<BombEntity> type, Level world, LivingEntity thrower) {
                    super(type, thrower, world);
                    this.setOwner(thrower);
                }

                @Override
                protected void defineSynchedData() {
                }



                @Override
                protected void onHitEntity(EntityHitResult result) {
                    super.onHitEntity(result);

                    if (!this.level().isClientSide) {
                        Entity entity = result.getEntity();
                        if (this.getOwner() instanceof LivingEntity owner && !(entity instanceof DuneSentinelEntity)) {
                            boolean flag = entity.hurt(this.damageSources().thrown(this, owner), 8.0F);

                            if (flag) {

                                //Blaze
                                  //  owner.heal(5.0F);
                            }
                        } else {
                            if (!(entity instanceof DuneSentinelEntity)) {
                                entity.hurt(this.damageSources().thrown(this, null), 8.0F);



                            }

                        }

                    }

                }



            @Override
            public void onHit(HitResult result) {
                super.onHit(result);
                if(this.getOwner() instanceof Player || this.getOwner() instanceof ServerPlayer) {
                    this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, Level.ExplosionInteraction.NONE);
                }else{
                    this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.NONE);
                }
               // this.playSound(SoundEvents.GENERIC_EXPLODE, 1, 1);
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
                        this.level().addParticle(ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
                        BlockState sandState = Blocks.SAND.defaultBlockState();
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


