        package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

        import net.miauczel.legendary_monsters.Particle.ModParticles;
        import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
        import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
        import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
        import net.miauczel.legendary_monsters.sound.ModSounds;
        import net.minecraft.nbt.CompoundTag;
        import net.minecraft.network.protocol.Packet;
        import net.minecraft.network.protocol.game.ClientGamePacketListener;
        import net.minecraft.network.syncher.EntityDataAccessor;
        import net.minecraft.network.syncher.EntityDataSerializers;
        import net.minecraft.network.syncher.SynchedEntityData;
        import net.minecraft.server.level.ServerLevel;
        import net.minecraft.world.entity.Entity;
        import net.minecraft.world.entity.EntityType;
        import net.minecraft.world.entity.LivingEntity;
        import net.minecraft.world.entity.Mob;
        import net.minecraft.world.entity.projectile.ThrowableProjectile;
        import net.minecraft.world.level.Level;
        import net.minecraft.world.phys.EntityHitResult;
        import net.minecraft.world.phys.HitResult;
        import net.minecraftforge.api.distmarker.Dist;
        import net.minecraftforge.api.distmarker.OnlyIn;
        import net.minecraftforge.network.NetworkHooks;

        public class FlyingArmorEntity extends ThrowableProjectile {
public ControlledAnim controlledAnim = new ControlledAnim(5);
                public FlyingArmorEntity(EntityType<FlyingArmorEntity> type, Level world) {
                    super(type, world);
                }

            public FlyingArmorEntity(EntityType<FlyingArmorEntity> type, Level world, LivingEntity thrower,float damage,int texture) {
                super(type, thrower, world);
                this.setOwner(thrower);


                    setDamage(damage);
                    setTimer(timer);
                    setTexture(texture);

                }
            @Override
            protected float getGravity() {
                return 0.03F;
            }

            public int timer = 40;
                public void setTimer(int time){
                    timer = time;
                }
                public int getTimer(){
                    return timer;
                }
                public boolean isFired = false;
                public boolean getIsFired(){
                    return isFired;
                }
                public void setFired(boolean fired){
                    isFired = fired;
                }
            private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(FlyingArmorEntity.class, EntityDataSerializers.FLOAT);

            private static final EntityDataAccessor<Integer> TEXTURE = SynchedEntityData.defineId(FlyingArmorEntity.class, EntityDataSerializers.INT);
            @Override
            protected void defineSynchedData() {
                this.entityData.define(DAMAGE,0f);
                this.entityData.define(TEXTURE,0);
            }
            public float getTexture(){
                return entityData.get(TEXTURE);
            }
            public void setTexture(int texture){
                entityData.set(TEXTURE,texture);

            }
            public float getDamage(){
                return entityData.get(DAMAGE);
            }
            public void setDamage(float damage){
                entityData.set(DAMAGE,damage);

            }


            @Override
            protected void onHitEntity(EntityHitResult result) {
                super.onHitEntity(result);
                if (level().isClientSide) return;

                Entity target = result.getEntity();
                Entity owner = this.getOwner();

                // jeśli trafiamy w właściciela, ignorujemy
                if (owner != null && target == owner) {
                    return;
                }

                if (owner instanceof LivingEntity livingOwner) {
                    target.hurt(ModDamageTypes.causeAnnihilationDamage(livingOwner, livingOwner), 12.0F);
                }
            }



            @Override
            public void onHit(HitResult result) {
                super.onHit(result);

                    if (!level().isClientSide && level() instanceof ServerLevel server) {

                        double d0 = this.getX();
                        double d1 = this.getY() + 2.0D;
                        double d2 = this.getZ();
                        server.sendParticles(ModParticles.ANNIHILATION_EXPLOSION.get(), d0, d1, d2, 1, 0, 0, 0, 0);

                        this.discard();
                    }
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), this.getSoundSource(), 0.1F, 1F, false);
              //  CameraShakeEntity.cameraShake(this.level(), this.position(), 40.0F, 0.3F, 0, 20);


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

                    if (timer > 0){
                        --timer;
                    }
                    if (timer == timer/2){
                        controlledAnim.increaseTimer();
                    }
                    if (timer <= 0){

                        setFired(true);

                    }

                   if (getIsFired()){
                        Entity entity = this.getOwner();
                        if (entity instanceof Mob && ((Mob) entity).getTarget() != null) {
                            LivingEntity target = ((Mob) entity).getTarget();
                            if(target == null){
                                this.discard();
                            }

                            float speed = 0.25F;

                            double dx = target.getX() - this.getX();
                            double dy = target.getY() + target.getBbHeight() * 0.5F - this.getY();
                            double dz = target.getZ() - this.getZ();

                            double d = Math.sqrt(dx * dx + dy * dy + dz * dz);

                            dx /= d;
                            dy /= d;
                            dz /= d;
                            this.xPower = dx * speed;
                            this.yPower = dy * speed;
                            this.zPower = dz * speed;
                        }
                    }


                    if (tickCount % 5 ==0) {
                      //  this.level().addParticle(ModParticles.BIG_GREEN_FLAME.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                    }
                    if (this.level().isClientSide){

                        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
                        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
                        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
                        float ran = 0.4f;
                        float r = 0/255F ;
                        float g = 195/255F + random.nextFloat() * ran;
                        float b = 0/255F  ;
                        this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b,0.2F,0.5f,this.getId())),  dx, dy, dz, 0, 0, 0);

                    }
                }

            public double xPower;
            public double yPower;
            public double zPower;
            @OnlyIn(Dist.CLIENT)
            public void handleEntityEvent(byte id) {
                super.handleEntityEvent(id);
                if (id == 1){



                }
                }
                @Override
                public Packet<ClientGamePacketListener> getAddEntityPacket() {
                    return NetworkHooks.getEntitySpawningPacket(this);
                }
            }

