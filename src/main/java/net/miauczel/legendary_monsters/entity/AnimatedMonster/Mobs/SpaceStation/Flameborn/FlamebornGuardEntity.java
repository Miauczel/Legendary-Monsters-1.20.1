package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.BigAnnihilationSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationFlameStrike;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class FlamebornGuardEntity extends AbstractFlameborn {
    public FlamebornGuardEntity(EntityType entity, Level world) {
        super(entity, world);

        this.setPersistenceRequired();
        xpReward = 5;
    }
    public final int BLOCK_COOLDOWN = 60;
    public int block_cooldown = BLOCK_COOLDOWN;
    @Override
public void tick(){
        if (level().isClientSide) {
            if (isDuringTeleportation() && !isInvisible()) {
                setInvisible(true);
            } else if (!isDuringTeleportation() && isInvisible()) {
                setInvisible(false);
            }
        }
        if (block_cooldown >0)block_cooldown--;
        this.idleAnimationState.animateWhen(getAttackState() == 0,this.tickCount);
        super.tick();
}
public boolean isDuringTeleportation(){
        return getAttackState() ==4 && (attackTicks >9 && attackTicks <15);
}
    @Override
    public void aiStep() {
        updateWithAttack();
        super.aiStep();
    }

    public void updateWithAttack(){
        float sweepSize = 1.25f;
        float sweepRot = 0;
        float uRange = 3.25f;
if (getAttackState() ==2){
    if (attackTicks == 13){
        this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1.25f);
        calculatedDash(0.2f);
    }
    if (attackTicks == 14){
        createSweep(0,0,3,true,sweepSize,sweepRot);
    }
    if (attackTicks == 16){
        SideAreaAttack(uRange,3,180,0,0,12,30,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
    }
}
        if (getAttackState() ==3){
            for (int i = 35; i <=39; i =i+2) {
                if (attackTicks ==i){
                    int d = i - 34;
                    flameRadagonShockwave(0.25f,d,1.5f,2,0,0);
                }
            }
            if (attackTicks == 13){
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1.25f);
                calculatedDash(0.2f);
            }
            if (attackTicks == 14){
                createSweep(0,0,3,true,sweepSize,sweepRot);
            }
            if (attackTicks == 16){
                SideAreaAttack(uRange,3,180,0,0,12,30,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
            }
            if (attackTicks == 25 || attackTicks == 27){
                playSound(SoundEvents.ENDERMAN_TELEPORT,1,1);
            }
            if (attackTicks == 37){
               StraightLineAreaAttack(0.025f,4,80,14,false);
               playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,1,1);

               spawnCircleParticle(2,0,20,true,0.5f,0,1,0,1);
            }
        }
        if (getAttackState() ==5){
            if (attackTicks == 15){
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1.25f);
                calculatedDash(0.2f);
            }
            if (attackTicks == 16){
                createSweep(0,0,3,false,sweepSize,sweepRot);
            }
            if (attackTicks == 18){
                SideAreaAttack(uRange,3,180,0,0,12,30,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
            }
            if (attackTicks == 28){
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1.25f);
                calculatedDash(0.2f);
            }
            if (attackTicks == 29){
                createSweep(0,0,3,true,sweepSize,sweepRot);
            }
            if (attackTicks == 31){
                SideAreaAttack(uRange,3,180,0,0,12,30,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
            }
        }

    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 40, 35, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && FlamebornGuardEntity.this.getRandom().nextFloat() * 100.0F < 20.0F
                        && FlamebornGuardEntity.this.getTarget() != null && getNextSweepType() == 1;
            }});
       /* this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 56, 34, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && FlamebornGuardEntity.this.getRandom().nextFloat() * 100.0F < 12.0F
                        && FlamebornGuardEntity.this.getTarget() != null&& getNextSweepType() == 2;
            }});*/
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 60, 50, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && FlamebornGuardEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && FlamebornGuardEntity.this.getTarget() != null;
            }});
        this.goalSelector.addGoal(0, new FlamebornGuardBlockGoal(this, 4, 4, 0, 26, 26) {
            public void start() {
                super.start();
            }
            @Override
            public void stop() {
                super.stop();
randomizeAttacks();
                block_cooldown = BLOCK_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 0, 60, 0){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            });
    }
    public int SweepType = 1;
public void randomizeAttacks(){
    randomizeNextSweepType(2);
}
    public int getNextSweepType(){
        return SweepType;
    }
    public void randomizeNextSweepType(int rolls){
        switch (random.nextInt(rolls)){
            case 0 -> SweepType = 1;

            case 1 -> SweepType = 2;
        }
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,  60)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 8D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState SweepAnimationState = new AnimationState();
    public AnimationState SweepSlamAnimationState = new AnimationState();

    public AnimationState DoubleSweepAnimationState = new AnimationState();

    public AnimationState BlockAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
        if (input == "sweep_slam") {
            return this.SweepSlamAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "sweep") {
            return this.SweepAnimationState;
        }
        else if (input == "block") {
            return this.BlockAnimationState;
        }
        else if (input == "double_sweep") {
            return this.DoubleSweepAnimationState;
        }
        else if (input == "death") {
            return this.deathAnimationState;
        }
        else {
            return new AnimationState();
        }
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.SweepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.SweepSlamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.BlockAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.DoubleSweepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }
    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.SweepAnimationState.stop();
        this.SweepSlamAnimationState.stop();
        this.deathAnimationState.stop();
        BlockAnimationState.stop();
        DoubleSweepAnimationState.stop();
    }

    @Override
    public void onAddedToWorld() {
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.FlamebornGuardHealthMultiplier.get());
        super.onAddedToWorld();
    }

    @Override
    public int attackDelayTicksValue() {
        return block_cooldown <=0 ? 3:0 ;
    }

    public void SideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            int brokenShieldTicks,
            boolean canStun,
            boolean canlaunch,
            SoundEvent soundEvent,
            float pitch
    ) {
        double theta = Math.toRadians(this.yBodyRot) + Math.PI/2;
        double forwardX = Math.cos(theta) * forwardOffset;
        double forwardZ = Math.sin(theta) * forwardOffset;

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            double dx = entityHit.getX() - (this.getX() + forwardX);
            double dz = entityHit.getZ() - (this.getZ() + forwardZ);

            float entityHitAngle = (float)((Math.toDegrees(Math.atan2(dz, dx)) - 90) % 360);
            if (entityHitAngle < 0) entityHitAngle += 360;

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityAttackingAngle < 0) entityAttackingAngle += 360;

            float entityHitDistance = (float)Math.sqrt(dx*dx + dz*dz);

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            if (entityHitDistance <= range
                    && (entityRelativeAngle <= arc/2 && entityRelativeAngle >= -arc/2
                    || entityRelativeAngle >= 360-arc/2 || entityRelativeAngle <= -360+arc/2)) {
                if (!isAlliedTo(entityHit)  &&!(entityHit instanceof TheObliteratorEntity)&& entityHit != this) {


                    boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FlamebornGuardDamageMutliplier.get())));
                    if (flag) {
                        playSound(soundEvent, 1, pitch);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }



    private void StraightLineAreaAttack(float boxWidth, float range, int brokenShieldTicks, float damage, boolean launch){

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth,3.5f,boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FlamebornGuardDamageMutliplier.get())));

                if (flag && launch){
                    launch(entityHit,true);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }}
    public boolean canBlock(){
        return getAttackState() ==0  && block_cooldown <=0&& !level().isClientSide && getTarget() !=null;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if ((getAttackState() == 3 && attackTicks >=25 && attackTicks <=27) || (getAttackState() == 4 && attackTicks <15)){
            return false;
        }
        if (source.is(DamageTypeTags.IS_PROJECTILE)) {
            playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
            teleportRandomly(this,8,10);
            return false;
        }
        if (source.is(DamageTypes.FALL))return false;
        amount *= 0.75f;
        if (canBlock() && amount >1){
            setAttackState(4);
            playSound(ModSounds.BLOCK.get(),1,1.25f);
            return false;
        }
        return super.hurt(source, amount);
    }
    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level){
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(),getY()+3,getZ(),1,0,0,0,0);
        }
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while(blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {
            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.teleportBoolean(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                this.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));

                if (!this.isSilent()) {

                    // this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0F, 1.0F);
                }
            }
            return flag2;
        } else {
            return false;
        }
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(6);
        stopAllAnimationStates();

    }

    public boolean teleportBoolean(double x, double y, double z, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = y;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(x, y, z);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while(!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }


            if (flag1) {
                this.teleportTo(x, d3, z);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            this.teleportTo(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte)46);
            }
            this.getNavigation().stop();

            return true;
        }
    }
    public void createSweep(float pos, float posOffset,float yHeight,boolean reverse,float scale,float rot) {
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = pos;
        float offset = posOffset;
        double x = (getX() + vec * vecX + f * offset);
        double z = (getZ() + vec * vecZ + f1 * offset);
        if (this.level().isClientSide) {
            double d0 =  x;
            double d1 = this.getY() + this.getBbHeight() / 2 + 0.4;
            double d2 = z;
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? rot : 180));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) *(float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ)) ;
            this.level().addParticle(new BigAnnihilationSweepParticle.SweepData(this.getScale() * scale, yaw , pitch), d0, d1, d2, 0, 0, 0);

        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }
    private void flameRadagonShockwave(float spreadarc, int distance, float vec, int delay,float pos,float offset) {
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta1 = (yBodyRot) * (Math.PI / 180);
        theta1 += Math.PI / 2;
        double vecX = Math.cos(theta1);
        double vecZ = Math.sin(theta1);
        int floor = Mth.floor(getY());
        double x = (getX() + pos * vecX + f * offset);
        double z = (getZ() + pos * vecZ + f1 * offset);
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = x + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = z + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnFlames(hitX + 0.5D, hitZ + 0.5D, this.getY() -5, this.getY() + 3, (float) theta, delay,7);
        }
    }

    private void spawnFlames(double x, double z, double minY, double maxY, float rotation, int delay,float damage) {

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

            this.level().addFreshEntity(new AnnihilationFlameStrike(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, 20,5));


        }
    }
public int deathTime;
    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 60){
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
