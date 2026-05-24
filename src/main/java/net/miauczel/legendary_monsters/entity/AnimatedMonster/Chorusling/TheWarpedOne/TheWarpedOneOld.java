package net.miauczel.legendary_monsters.entity.AnimatedMonster.Chorusling.TheWarpedOne;


import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ChorusBreathEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LMFallingBlockEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.ai.ITwoHitAttackGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ChorusEnergyBulletEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.LMBossInfoServer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumSet;
import java.util.List;

public class TheWarpedOneOld extends IAnimatedBoss {
    public TheWarpedOneOld(EntityType entity, Level world) {
        super(entity, world);
        setMaxUpStep(1.5f);
    }

    private final LMBossInfoServer bossInfo = new LMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, false, 3);

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }
    public final int TELEPORT_FALL_COOLDOWN = 120;
    public int teleportfallcooldown = 0;

    public final int TELEPORT_UPPERCUT_COOLDOWN = 120;
    public int teleportUppercutCooldown = 0;
    @Override
    public void tick() {
        System.out.println("Animation:" + getAttackState());

        System.out.println("isSuccess:" + upperCutSuccess);
        if (teleportfallcooldown >0){
            teleportfallcooldown--;
        }
        if (teleportUppercutCooldown >0){
            teleportUppercutCooldown--;
        }
        //  System.out.println("SpinSmashType: " + getSpinSmashType());
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
        super.tick();
        if (!this.level().isClientSide()) {  // Upewnij się, że jesteśmy po stronie serwera
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }

    @Override
    public void aiStep() {
        for (int i = 0; i < 0.5; ++i) {
            if (level().isClientSide) {
                this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
            }
        }
        UpdateWithAttack();
        super.aiStep();
    }
    private void SpawnDamagingBlocks(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne,int brokenShieldTicks) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            LMFallingBlockEntity fallingBlockEntity = new LMFallingBlockEntity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(level().damageSources().mobAttack(this), 11 * damage + Math.min(11 * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {

                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                    if (entity instanceof Player && entity.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entity, brokenShieldTicks);
                    }
                }
            }
        }
    }
    private void SpawnDamagingBlocksCalculatedPos(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne,int brokenShieldTicks,float x,float z) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = x + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = z + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            LMFallingBlockEntity fallingBlockEntity = new LMFallingBlockEntity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(level().damageSources().mobAttack(this), 11 * damage + Math.min(11 * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {

                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                    if (entity instanceof Player && entity.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entity, brokenShieldTicks);
                    }
                }
            }
        }
    }

    public boolean upperCutSuccess = false;
    public void randomizeAllAttackTypes(){
        getRandomRoarAttackAnimation(2);
        getRandomSpinSmashAnimation(2);
    }
    public int getNextSpinSmashType(){
        return nextSpinSmashType;
    }
    public int getNextRoarAttackType(){
        return nextRoarAttackType;
    }

    public int nextSpinSmashType = 1;
    public int nextRoarAttackType = 1;

    public void getRandomSpinSmashAnimation(int rolls){
        switch (random.nextInt(rolls)){
            case 0->{
                nextSpinSmashType = 1;
            }
            case 1->{
                nextSpinSmashType = 2;
            }
        }
    }
    public void getRandomRoarAttackAnimation(int rolls){
        switch (random.nextInt(rolls)){
            case 0->{
                nextRoarAttackType = 1;
            }
            case 1->{
                hasStartedSecondTeleportSmash = false;
                nextRoarAttackType = 2;
            }
        }
    }



    public boolean hasStartedSecondTeleportSmash = false;

    public boolean getHasStartedSecondTeleportSmash(){
        return hasStartedSecondTeleportSmash;
    }
    private void teleportRandomly() {

        Vec3 entityPos = this.position();
        double x, y, z;
        Level level = this.level();

        for (int i = 0; i < 10; i++) { // Próba znalezienia wolnego miejsca do teleportacji przez 10 iteracji
            x = entityPos.x() + (this.getRandom().nextDouble() - 0.5) * 14.0; // Losowa pozycja X w zasięgu 10 bloków
            z = entityPos.z() + (this.getRandom().nextDouble() - 0.5) * 14.0; // Losowa pozycja Z w zasięgu 10 bloków
            y = entityPos.y(); // Pozostaw Y bez zmian

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1,  iz)).isAir()) {
                this.teleportTo(x, y, z);
                return; // Jeśli znaleziono wolne miejsce, teleportuj się i wyjdź z pętli
            }
        }
    }
    private void launch(LivingEntity entity, boolean huge, float launchMultiplier, float yPower) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? launchMultiplier : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? yPower : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }
    public void executeCalculatedDash(float Multiplier){
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((target.getX() - this.getX()) * Multiplier, 0, (target.getZ() - this.getZ()) * Multiplier);
        }
    }
    private void spawnEnergyBullets(double x, double z, double minY, double maxY, float rotation, int delay) {

        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);

            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this;
            this.level().addFreshEntity(new ChorusEnergyBulletEntity(level(),this,x,blockpos.getY() + d0,z,getYRot()));
        }
    }
    private float dashDestX;
    private float dashDestY;
    private float dashDestZ;
    public boolean cantBeDamaged(){
        return (getAttackState() == 13 && (attackTicks >=39 && attackTicks <=52));
    }
    public void UpdateWithAttack(){
        LivingEntity target = this.getTarget();




        if (getAttackState() == 3){
            for (int i = 41, j = 2; i <= 42; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 1.5f;
                    float offset = 0.5f;
                    SpawnDamagingBlocksCalculatedPos(2F, j, 4f, 2, 1, (float)1, 0.05F,100, (float) (getX() + vec * vecX + f * offset),
                            (float) (getZ() + vec * vecZ + f1 * offset));

                }
            }
            if (attackTicks == 22){
                if (target !=null) {
                    float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 10;
                    float offset = 10;

                    ChorusEnergyBulletEntity witherskull = new ChorusEnergyBulletEntity(this.level(), this,
                            getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset,getYRot());
                    witherskull.setOwner(this);

                    witherskull.setDangerous(true);
                    Vec3 vec3 = new Vec3(target.getX() - getX(),0,target.getZ() - getZ());
                    witherskull.setDeltaMovement(vec3);
                    witherskull.setPosRaw(getX() + vec * vecX + f * offset,getY() + 3,getZ() + vec * vecZ + f1 * offset);
                    // this.level().addFreshEntity(witherskull);
                }
                playSound(ModSounds.WEAPON_SPIN.get(),1,0.7f);
                //  CalculateDash(0.5f,4,8);

                executeCalculatedDash(0.25f);
                // dash(2f,2f,4);
            }
            if (attackTicks == 24){

                AreaAttack(4,3,180,16,100,false,false);
            }
            if (attackTicks == 38){
                executeCalculatedDash(0.15f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
                //  dash(1.5f,1.5f,3);
            }
            if (attackTicks == 41){
                spawnCircleParticle(4.5f,0,21,true,2,1,1,1,1);
                this.playSound(ModSounds.GROUND_IMPACT.get(),1,1);
                AreaAttack(4,3,180,16,100,false,true);

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
            }
        }

        if (getAttackState() == 4){
            for (int i = 41, j = 2; i <= 42; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 1.5f;
                    float offset = -0.5f;
                    SpawnDamagingBlocksCalculatedPos(2F, j, 4f, 2, 1, (float)1, 0.05F,100, (float) (getX() + vec * vecX + f * offset),
                            (float) (getZ() + vec * vecZ + f1 * offset));

                }
            }
            if (attackTicks == 22){

                Vec3 mouthPos = new Vec3(0, 1, 0);
                mouthPos = mouthPos.yRot((float) Math.toRadians(-getYRot() - 90));
                mouthPos = mouthPos.add(position());
                mouthPos = mouthPos.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                ChorusBreathEntity breath = new ChorusBreathEntity(ModEntities.CHORUS_BREATH.get(), this.level(), (float) 11,
                        this,false,true,false,false
                );
                breath.absMoveTo(mouthPos.x, mouthPos.y, mouthPos.z,this.yHeadRot, this.getXRot());
                level().addFreshEntity(breath);

                //Breath2
                Vec3 mouthPos2 = new Vec3(0, 1, 0);
                mouthPos2 = mouthPos2.yRot((float) Math.toRadians(-getYRot() - 90));
                mouthPos2 = mouthPos2.add(position());
                mouthPos2 = mouthPos2.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                ChorusBreathEntity breath2 = new ChorusBreathEntity(ModEntities.CHORUS_BREATH.get(), this.level(), (float) 11,
                        this,true,false,false,false
                );

                breath2.absMoveTo(mouthPos2.x, mouthPos2.y, mouthPos2.z,this.yHeadRot, this.getXRot());
                level().addFreshEntity(breath2);
                //Breath3
                Vec3 mouthPos3 = new Vec3(0, 1, 0);
                mouthPos3 = mouthPos3.yRot((float) Math.toRadians(-getYRot() - 90));
                mouthPos3 = mouthPos3.add(position());
                mouthPos3 = mouthPos3.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                ChorusBreathEntity breath3 = new ChorusBreathEntity(ModEntities.CHORUS_BREATH.get(), this.level(), (float) 11,
                        this,false,false,true,false
                );

                breath2.absMoveTo(mouthPos3.x, mouthPos3.y, mouthPos3.z,this.yHeadRot, this.getXRot());
                level().addFreshEntity(breath3);
                //Breath4
                Vec3 mouthPos4 = new Vec3(0, 1, 0);
                mouthPos4 = mouthPos4.yRot((float) Math.toRadians(-getYRot() - 90));
                mouthPos4 = mouthPos4.add(position());
                mouthPos4= mouthPos4.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                ChorusBreathEntity breath4 = new ChorusBreathEntity(ModEntities.CHORUS_BREATH.get(), this.level(), (float) 11,
                        this,false,false,true,false
                );

                breath2.absMoveTo(mouthPos4.x, mouthPos4.y, mouthPos4.z,this.yHeadRot, this.getXRot());
                level().addFreshEntity(breath4);
                Vec3 mouthPos5 = new Vec3(0, 1, 0);
                mouthPos5 = mouthPos5.yRot((float) Math.toRadians(-getYRot() - 90));
                mouthPos5 = mouthPos5.add(position());
                mouthPos5= mouthPos5.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                ChorusBreathEntity breath5 = new ChorusBreathEntity(ModEntities.CHORUS_BREATH.get(), this.level(), (float) 11,
                        this,false,false,false,true
                );

                breath5.absMoveTo(mouthPos5.x, mouthPos5.y, mouthPos5.z,this.yHeadRot, this.getXRot());
                level().addFreshEntity(breath5);
                playSound(ModSounds.WEAPON_SPIN.get(),3,0.7f);
                executeCalculatedDash(0.25f);
            }
            if (attackTicks == 24){


                AreaAttack(4,3,180,16,100,false,false);
            }
            if (attackTicks == 38){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
                //dash(1.5f,1.5f,3);
                executeCalculatedDash(0.15f);
            }
            if (attackTicks == 41){

                spawnCircleParticle(4.5f,0,21,true,2,1,1,1,1);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                this.playSound(ModSounds.GROUND_IMPACT.get(),1,1);
                AreaAttack(4,3,180,16,100,false,true);


            }
        }
        if (getAttackState() == 5){
            float yaw = (float) Math.toRadians(-getYRot());

            float g = (float) Math.toRadians(-getYRot() + 180);
            float pitch = (float) Math.toRadians(-getXRot());
            float spread = 0.25f;
            float speed = 0.56f;
            float xComp = (float) (Math.sin(yaw) * Math.cos(pitch));
            float yComp = (float) (Math.sin(pitch));
            float zComp = (float) (Math.cos(yaw) * Math.cos(pitch));
            if (level().isClientSide) {

                Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
                boolean overrideLimiter = camera.getPosition().distanceToSqr(getX(), getY(), getZ()) < 64 * 64;
//if (tickCount % 8 ==0)  level().addAlwaysVisibleParticle(new Circle.RingData(g,0, 40, 1f, 1f, 1f, 1f, 110f * spread, false, Circle.EnumRingBehavior.GROW), overrideLimiter, getX(), getY(), getZ(), 0.5f * xComp, 0.5f * yComp, 0.5f * zComp);

            }
            if (attackTicks ==74){


            }
            if (attackTicks ==20){
                playSound(ModSounds.THE_WARPED_ONE_ROAR.get(),2,1f);

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 30, 0);
            }

            if (attackTicks>20 && attackTicks<30){

            }
            if (attackTicks >20 && attackTicks <30) {
                List<LivingEntity> entities = getEntityLivingBaseNearby(10, 3, 10, 10);
                for (LivingEntity entity : entities) {
                    if (entity == this) continue;
                    double angle = (getAngleBetweenEntities(this, entity) +90) * Math.PI / 180;
                    double distance = distanceTo(entity) - 2f;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(Math.min(1 / (distance * distance), 1) * -1 * Math.cos(angle),
                            0, Math.min(1 / (distance * distance), 1)
                                    * -1 * Math.sin(angle)));
                }
            }
            if (attackTicks >= 55 && attackTicks <=70){
                runAway();
            }
            if (attackTicks == 75){

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(),this.getY() + 3 , this.getZ(),0,0,0);
            }
            if (attackTicks ==76){
                setInvisible(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT,2,0.5f);
                setNoGravity(true);
                if (target !=null){
                    setPos(target.getX(),target.getY() + 10,target.getZ());
                }else {
                    setPos(getX(),getY() + 10,getZ());
                }

            }
        }
        // Z UpdateWithAttack() – skasować lub zakomentować:
        if (getAttackState() == 6){
            setInvisible(false);
        }
        if (getAttackState() == 6 && onGround()) {
            if (getNextRoarAttackType()==2 && !hasStartedSecondTeleportSmash && getAttackState()!=8) {
                setAttackState(8);
            } else
                setAttackState(7);

        }



        if (getAttackState() == 7){
            for (int i = 3, j = 2; i <= 14; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    SpawnDamagingBlocks(2, j, 4f, 2, 1, (float)1, 0.05F,100);
                }
            }
            if (attackTicks == 3){
                this.playSound(ModSounds.GROUND_IMPACT.get(),1,1);
                AreaAttack(4,3,180,16,100,false,true);

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
        }
        if (getAttackState() == 8){
            for (int i = 3, j = 2; i <= 14; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    SpawnDamagingBlocks(2, j, 4f, 2, 1, (float)1, 0.05F,100);
                }
            }
            if (attackTicks == 3){
                this.playSound(ModSounds.GROUND_IMPACT.get(),1,1);
                AreaAttack(4,3,180,16,100,false,true);

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
            if (attackTicks == 21){

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(),this.getY() + 3 , this.getZ(),0,0,0);
            }
            if (attackTicks == 22) {
                setInvisible(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT,2,0.5f);
                if (target != null) {
                    setPos(target.getX(), target.getY() + 10, target.getZ());
                } else {
                    setPos(getX(), getY() + 10, getZ());
                }
            }

        }
        if (getAttackState() == 10){
            if (attackTicks == 20){
                executeCalculatedDash(0.5f);
            }
            if (attackTicks == 26){
                AreaAttack(5,4,360,18,100,false,false);
            }
        }

        if (getAttackState() == 12){
            if (attackTicks == 6){

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(),this.getY()+ 3 , this.getZ(),0,0,0);
            }
            if (attackTicks == 7){
                playSound(SoundEvents.ENDERMAN_TELEPORT,2,0.5f);
                if (target != null){
                    float f = Mth.cos(target.yBodyRot * ((float)Math.PI / 180F)) ;
                    float f1 = Mth.sin(target.yBodyRot * ((float)Math.PI / 180F)) ;
                    double theta = (target.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -2;
                    float offset = 0;

                    setPos(target.getX() + vec * vecX + f * offset,target.getY(),target.getZ() + vec * vecZ + f1 * offset);
                }
            }
            if (attackTicks == 12){
                AreaAttack(5,4,360,18,100,false,false);
            }
        }
        if (getAttackState() == 13) {
            // Kiedy attackTicks == 15, zapamiętujemy sobie pozycję celu.
            if (attackTicks == 8 && target != null) {
                dashDestX = (float) target.getX();
                dashDestZ = (float) target.getZ();
                dashDestY = (float) target.getY();
            }

            // Kiedy dojdziemy do 20, korzystamy z zapamiętanych współrzędnych.
            if (attackTicks == 20) {
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
                setInvisible(false);
                if (target != null) {
                    this.setDeltaMovement(
                            (dashDestX - this.getX()) * 0.35F,
                            0,
                            (dashDestZ - this.getZ()) * 0.35F
                    );
                }
            }

            if (attackTicks == 26) {
                Uppercut(0.75f,3,100,18);
                //    AreaAttack(5, 4, 180, 18, 100, true);
            }
            if (attackTicks == 39){
                playSound(SoundEvents.ENDERMAN_TELEPORT,2,0.5f);
            }
            if (attackTicks == 38){

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(),this.getY() + 3 , this.getZ(),0,0,0);
            }
            if (attackTicks >= 39 && attackTicks<=52) {
                setInvisible(true);
                if (target != null) {
                    float f  = Mth.cos(target.yBodyRot * ((float)Math.PI / 180F));
                    float f1 = Mth.sin(target.yBodyRot * ((float)Math.PI / 180F));
                    double theta = (target.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec   = -2;
                    float offset = 0;

                    teleportTo(
                            target.getX() + vec * vecX + f  * offset,
                            target.getY(),
                            target.getZ() + vec * vecZ + f1 * offset
                    );
                }
            }

            if (attackTicks == 52) {
                setInvisible(false);
            }

            if (attackTicks == 62) {
                this.playSound(ModSounds.GROUND_IMPACT.get(), 1, 1);
                AreaAttack(4, 4, 180, 18, 120, false,true);
            }

            // Spawning damaging blocks
            for (int i = 62, j = 2; i <= 64; i += 2, j++) {
                if (this.attackTicks == i) {
                    SpawnDamagingBlocks(2, j, 4f, 2, 1, 1f, 0.03F, 100);
                }
            }
        }

    }
    private void runAway() {
        if (!level().isClientSide){
            if (this.onGround()) {
                Vec3 randomShake = new Vec3(random.nextFloat() - 0.5F, 0, random.nextFloat() - 0.5F).scale(0.1F);
                this.setDeltaMovement(this.getDeltaMovement().multiply(2F, 1, 2F).add(randomShake));
            }
            if (this.getNavigation().isDone()) {
                Vec3 vec = LandRandomPos.getPosAway(this, 15, 7, this.position());
                if (vec != null) {
                    this.getNavigation().moveTo(vec.x, vec.y, vec.z, 2D);
                }
            }

        }
    }
    private void Uppercut(float RangeXZ,float range,int brokenShieldTicks,float damage){

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(RangeXZ,4,RangeXZ).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
                if (flag){
//launch(entityHit,true,2,0.3f);

                    launch(entityHit,true,2,0.5f);
                    playSound(SoundEvents.ANVIL_PLACE, 1, 1f);
                    entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(),80,1));


                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }}
    private void AreaAttack(float range, float height, float arc, float damage,int brokenShieldTicks,boolean canStun,boolean canlaunch) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit)  &&!(entityHit instanceof TheWarpedOneOld )&& entityHit != this) {


                    boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
                    if (flag) {
//launch(entityHit,true,2,0.3f);
                        if (canlaunch){
                            launch(entityHit, true, 2, 0.5f);
                        }
                        if(!canStun) {
                            playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 0.5f);
                        }
                        if (getAttackState() == 13 && canStun){

                            playSound(SoundEvents.ANVIL_PLACE, 1, 1f);
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(),80,1));
                        }

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,  450)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 60D)
                .add(Attributes.ARMOR, 14D)
                .add(Attributes.MOVEMENT_SPEED, 0.12F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 6);
    }
    public double damageCap(){
        return ModConfig.MOB_CONFIG.CloudGolemDamageCap.get();
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (cantBeDamaged()) {
            return false;
        }
        if (source.is(DamageTypes.FALL)) {
            return false;
        }
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        } else {
            amount = (float) Math.min(damageCap(), amount);
        }
        return super.hurt(source, amount);
    }

    @Override

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));



        ///SPIN SMASHES
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this,
                0, 3, 0, 83, 30,32,40, 6F){
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneOld .this.getRandom().nextFloat() * 40.0F < 16.0F
                        && TheWarpedOneOld .this.getTarget() != null && getNextSpinSmashType() == 1;

            }});
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this, 0, 4, 0, 83,
                30,32,40, 6F){
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneOld .this.getRandom().nextFloat() * 40.0F < 16.0F
                        && TheWarpedOneOld .this.getTarget() != null && getNextSpinSmashType() == 2;

            }});




        ///TELEPORT LAND / ROAR
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 6, 92, 54, 8) {
            @Override
            public void stop() {
                setNoGravity(false);
                setInvulnerable(false);
                setDeltaMovement(0,-0.1f,0);
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneOld .this.getRandom().nextFloat() * 40.0F < 16.0F && TheWarpedOneOld .this.teleportfallcooldown <= 0
                        && TheWarpedOneOld .this.getTarget() != null;
            }
        });

        //teleport idle
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 7, 100, 100){
            @Override
            public boolean canUse() {
                return super.canUse() && getNextRoarAttackType() == 1;
            }
        });
        // FOR TELEPORT LAND 2 TIMES
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 8, 100, 100){
            @Override
            public void start() {
                hasStartedSecondTeleportSmash = false;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && (getNextRoarAttackType() == 2 &&!getHasStartedSecondTeleportSmash());
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 7, 100, 100){
            @Override
            public boolean canUse() {
                return super.canUse() && (getNextRoarAttackType() == 2 && getHasStartedSecondTeleportSmash());
            }


        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 8, 8, 6, 24, 100){
            @Override
            public void start() {
                hasStartedSecondTeleportSmash = true;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && getNextRoarAttackType() == 2;
            }
        });

        //teleport smash End
        this.goalSelector.addGoal(0, new IStateGoal(this, 7, 7, 0, 40, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse() ;
            }

            @Override
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                TheWarpedOneOld .this.teleportfallcooldown = TELEPORT_FALL_COOLDOWN;
            }
        });




///UPPERCUT TELEPORT
       /* this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 13, 0, 92,92, 8) {
            @Override
            public void stop() {
                teleportUppercutCooldown = TELEPORT_UPPERCUT_COOLDOWN;
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && TheWarpedOneEntity.this.teleportUppercutCooldown <= 0
                        && TheWarpedOneEntity.this.getTarget() != null;
            }});*/
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this, 0, 13, 0, 92,14,40, 100, 8F) {
            @Override
            public void stop() {
                teleportUppercutCooldown = TELEPORT_UPPERCUT_COOLDOWN;
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneOld .this.getRandom().nextFloat() * 40.0F < 16.0F && TheWarpedOneOld .this.teleportUppercutCooldown <= 0
                        && TheWarpedOneOld .this.getTarget() != null;
            }
        });
        /*this.goalSelector.addGoal(1, new TheWarpedOneTeleportUppercutGoal(this, 0, 10, 11, 40, 54, 8, 5) {
            @Override
            public void stop() {
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheWarpedOneEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && TheWarpedOneEntity.this.teleportUppercutCooldown <= 0
                        && TheWarpedOneEntity.this.getTarget() != null;
            }
        });
        this.goalSelector.addGoal(1, new TheWarpedOneTpUppercutStateGoal(this, 10, 10, 11, 40, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse() ;
            }

            @Override
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();

            }
        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 11, 11, 0, 40, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse() ;
            }

            @Override
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                TheWarpedOneEntity.this.teleportUppercutCooldown = TELEPORT_UPPERCUT_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 12, 12, 0, 40, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse() ;
            }

            @Override
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                TheWarpedOneEntity.this.teleportUppercutCooldown = TELEPORT_UPPERCUT_COOLDOWN;
            }
      });
 */

    }
    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState spinSmashComboAnimationState = new AnimationState();
    public AnimationState leftspinSmashAnimationState = new AnimationState();

    public AnimationState roarAnimationState = new AnimationState();
    public AnimationState fallAnimationState = new AnimationState();
    public AnimationState landAnimationState = new AnimationState();
    public AnimationState teleportlandAnimationState = new AnimationState();

    public AnimationState teleportUppercutPreAnimationState = new AnimationState();
    public AnimationState teleportUppercutFailAnimationState = new AnimationState();
    public AnimationState teleportUppercutSuccessAnimationState = new AnimationState();
    public AnimationState teleportUppercutWholeAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "spinsmash") {
            return this.spinSmashComboAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "leftspinsmash") {
            return this.leftspinSmashAnimationState;
        }
        if (input == "roar") {
            return this.roarAnimationState;
        }
        if (input == "fall") {
            return this.fallAnimationState;
        }
        if (input == "land") {
            return this.landAnimationState;
        }
        if (input == "teleportland") {
            return this.teleportlandAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "uppercutpre") {
            return this.teleportUppercutPreAnimationState;
        }
        if (input == "uppercutfail") {
            return this.teleportUppercutFailAnimationState;
        }
        if (input == "uppercutsuccess") {
            return this.teleportUppercutFailAnimationState;
        }
        if (input == "teleportuppercut") {
            return this.teleportUppercutWholeAnimationState;
        }
        else {
            return new AnimationState();
        }
    }


    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }
    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {

                    case 0 -> {
                        this.stopAllAnimationStates();

                    }
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.spinSmashComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.leftspinSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.roarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.fallAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.landAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.teleportlandAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.teleportUppercutPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.teleportUppercutFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.teleportUppercutSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.teleportUppercutWholeAnimationState.startIfStopped(this.tickCount);
                    }





                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.spinSmashComboAnimationState.stop();

        this.leftspinSmashAnimationState.stop();
        this.sleepAnimationState.stop();

        this.deathAnimationState.stop();
        this.roarAnimationState.stop();

        this.fallAnimationState.stop();
        this.landAnimationState.stop();
        this.teleportlandAnimationState.stop();

        this.teleportUppercutWholeAnimationState.stop();
        this.teleportUppercutPreAnimationState.stop();
        this.teleportUppercutFailAnimationState.stop();
        this.teleportUppercutSuccessAnimationState.stop();
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        return false;
    }

    @Override
    public boolean damageReductionSystem() {
        return false;
    }

    @Override
    public boolean damageAdaptationSystem() {
        return false;
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        setAttackState(9);
        warpedOneDeathTime = 0;
    }
    public int warpedOneDeathTime;
    @Override
    protected void tickDeath() {
        ++this.warpedOneDeathTime;
        if (this.warpedOneDeathTime == 40 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }

    }
    private void Sphereparticle(float height, float vec, float size) {
        if (!this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;
                            System.out.println("Adding particle at: " + d0 + ", " + d1 + ", " + d2);

                            this.level().addParticle(ModParticles.TORNADO_FIRE.get(), d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }
    static class TheWarpedOneTpUppercutStateGoal extends IStateGoal {
        protected final TheWarpedOneOld  entity;
        public TheWarpedOneTpUppercutStateGoal(TheWarpedOneOld  entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
        }

        public void stop() {
            if (entity.upperCutSuccess){
                entity.setAttackState(12);
                entity.upperCutSuccess = false;

            }else {
                super.stop();
            }
            this.entity.attackTicks = 0;
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && !entity.upperCutSuccess;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
    static class TheWarpedOneTeleportUppercutGoal extends IAttackGoalMin {
        protected final TheWarpedOneOld  entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private final float attackrangemin;

        public TheWarpedOneTeleportUppercutGoal(TheWarpedOneOld  entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick,float attackrange,float attackrangemin) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick,attackrange,attackrangemin);
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.attackrangemin = attackrangemin ;
        }



        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.entity.distanceTo(target) >attackrangemin;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {
            if (entity.upperCutSuccess){
                entity.setAttackState(12);
            }else {

                this.entity.setAttackState(this.attackendstate);
            }
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return this.entity.attackTicks < this.attackMaxtick;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


}
