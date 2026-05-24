package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.FallingSoulBladeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulBladeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LMFallingBlockEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulPillarEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.ai.ITwoHitAttackGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.LMBossInfoServer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
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
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewPossessedPaladin extends IAnimatedBoss {
    public NewPossessedPaladin(EntityType entity, Level world) {
        super(entity, world);
    }

    private final LMBossInfoServer bossInfo = new LMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.RED, false, 2);
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public final int FAST_SWEEP_COOLDOWN = 0;
public final int PARRY_COOLDOWN = 80;
    public final int AGGRESIVE_PARRY_COOLDOWN = 120;
public final int POWERFUL_JUMP_SMASH_COOLDOWN = 300;
    public final int STAB_COOLDOWN = 140;
    public final int SLAM_COMBO_COOLDOWN = 0;
    public final int TRIPLE_COMBO_COOLDOWN = 40;
public final int BACKFLIP_COOLDOWN = 80;
    public final int JUMP_SMASH_COOLDOWN = 100;
    public int backflipCooldown = BACKFLIP_COOLDOWN;
    public int tripleComboCooldown = TRIPLE_COMBO_COOLDOWN;
    public int jumpSmashCooldown = JUMP_SMASH_COOLDOWN;

    public int parryCooldown = PARRY_COOLDOWN;
    public int AggresiveparryCooldown = AGGRESIVE_PARRY_COOLDOWN;
    public int slamComboCooldown = SLAM_COMBO_COOLDOWN;
    public final int REDUCED_DAMAGE_TICKS = 100;
    public int reducedDamageTicks = REDUCED_DAMAGE_TICKS;

    public int stabCooldown = STAB_COOLDOWN;

    public int fastSweepCooldown = STAB_COOLDOWN;


    public int powerfulJumpSmashCooldown = POWERFUL_JUMP_SMASH_COOLDOWN;

    public boolean stabSuccess = false;
    public boolean getStabSuccess(){
        return stabSuccess;
    }
    @Override
    public void tick() {
        // System.out.println("State: " +getAttackState());
        idleAnimationState.animateWhen(getAttackState() ==0,this.tickCount);
        if (tripleComboCooldown >0){
            tripleComboCooldown--;
        }
        if (jumpSmashCooldown>0){
            jumpSmashCooldown--;
        }
        if (slamComboCooldown>0){
            slamComboCooldown--;
        }
        if (backflipCooldown>0){
            backflipCooldown--;
        }
        if (AggresiveparryCooldown >0){
            AggresiveparryCooldown--;
        }
        if (AggresiveparryCooldown >0){
            AggresiveparryCooldown--;
        }
        if (parryCooldown >0){
            parryCooldown--;
        }
        if (stabCooldown >0){
            stabCooldown--;
        }
        if (powerfulJumpSmashCooldown >0){
            powerfulJumpSmashCooldown--;
        }
        if (fastSweepCooldown >0){
            fastSweepCooldown--;
        }
        if (!level().isClientSide) {
            if (reducedDamageTicks > 0) {
                reducedDamageTicks--;
            }
        }
        super.tick();
    }

    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
       // this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Cloud_GolemEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        //PARRY
        this.goalSelector.addGoal(0, new IStateGoal(this, 11, 11, 0, 73, 73) {
            @Override
            public void stop() {
                AggresiveparryCooldown = AGGRESIVE_PARRY_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 0, 55, 55) {
            @Override
            public void stop() {
                parryCooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 13, 13, 0, 55, 55) {
            @Override
            public void stop() {
                parryCooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        //TRIPLE_COMBO
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 77, 45, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.tripleComboCooldown <= 0
                        && target != null && getNextSlashComboType() == 1&& !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                tripleComboCooldown = TRIPLE_COMBO_COOLDOWN;
                super.stop();
            }
        });
        //DOUBLE COMBO
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 53, 53, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.tripleComboCooldown <= 0
                        && target != null&& getNextSlashComboType() == 2&& !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                tripleComboCooldown = TRIPLE_COMBO_COOLDOWN;
                super.stop();
            }
        });
        //DOUBLE COMBO ROLL
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 77, 77, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.tripleComboCooldown <= 0
                        && target != null && getNextSlashComboType() == 3&& !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                tripleComboCooldown = TRIPLE_COMBO_COOLDOWN;
                super.stop();
            }
        });



        //JUMP SMASH
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 42, 16, 8.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.jumpSmashCooldown <= 0
                        && target != null&& getNextJumpSlashType() == 1&& !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                jumpSmashCooldown = JUMP_SMASH_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this, 0, 9, 0, 78, 16,35,56,8) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.jumpSmashCooldown <= 0
                        && target != null&& getNextJumpSlashType() == 2 && !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                jumpSmashCooldown = JUMP_SMASH_COOLDOWN;
                super.stop();
            }
        });
        //BACKFLIP
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 32, 32, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.backflipCooldown <= 0
                        && target != null &&getNextBackFlipType() == 1;
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                backflipCooldown = BACKFLIP_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 8, 0, 47, 47, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.backflipCooldown <= 0
                        && target != null &&getNextBackFlipType() == 2;
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                backflipCooldown = BACKFLIP_COOLDOWN;
                super.stop();
            }
        });
        //SLAM COMBO
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this, 0, 10, 0, 109, 14,30,109, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 100.0F < 50.0F && NewPossessedPaladin.this.slamComboCooldown <= 0
                        && target != null && !isParrying();
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                slamComboCooldown = SLAM_COMBO_COOLDOWN;
                super.stop();
            }
        });
        //STAB SMASH SYSTEM
        
//POWERFUL JUMP SMASH
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 19, 20, 29, 29, 16F, 6) {

            public boolean canUse() {
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F && NewPossessedPaladin.this.powerfulJumpSmashCooldown <= 0
                        && NewPossessedPaladin.this.getTarget() != null;
            }
        });

        //jump idle
        this.goalSelector.addGoal(1, new IStateGoal(this, 20, 20, 21, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new IStateGoal(this, 21, 21, 0, 56, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
                powerfulJumpSmashCooldown = POWERFUL_JUMP_SMASH_COOLDOWN;
            }
        });
        //GRAB SYSTEM
        this.goalSelector.addGoal(1, new PossessedPaladinStabGoal(this, 0, 16, 17, 30, 20, 7F) {

            public boolean canUse() {
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && NewPossessedPaladin.this.getTarget() != null && stabCooldown <=0;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 18, 18, 0, 55, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void tick() {
                super.tick();
            }

            @Override
            public void stop() {
                super.stop();
                stabCooldown = STAB_COOLDOWN;

            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 17, 17, 0, 20, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                stabCooldown = STAB_COOLDOWN;
            }
        });
        //Fast Combo
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 22, 0, 45, 45, 5.0F) {

            public boolean canUse() {

                var target = NewPossessedPaladin.this.getTarget();
                return super.canUse() && NewPossessedPaladin.this.getRandom().nextFloat() * 40.0F < 32.0F && NewPossessedPaladin.this.fastSweepCooldown <= 0
                        && target != null ;
            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                fastSweepCooldown = FAST_SWEEP_COOLDOWN;
                super.stop();
            }
        });
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()

                .add(Attributes.MAX_HEALTH, 450D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 15D);
    }

    @Override
    public double baseHealth(){
        return 450;
    }

    @Override
    public boolean damageReductionSystem() {
        return false;
    }

    @Override
    public boolean damageAdaptationSystem() {
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }
    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());}
        UpdateWithAttack();
    }



    public int nextSlashComboType = 1;
    public int getNextSlashComboType(){
        return nextSlashComboType;
    }
    public int nextJumpSlashType = 1;
    public int getNextJumpSlashType(){
        return nextJumpSlashType;
    }
    public void getRandomJumpSlashType(int rolls){
        switch (random.nextInt(rolls)){
            case 0->{
                nextJumpSlashType = 1;
            }
            case 1->{
nextJumpSlashType = 2;
            }
        }
    }
    public int nextBackflipType = 1;
    public int getNextBackFlipType(){
        return nextBackflipType;
    }
    public void getRandomBackFlipType(int rolls){
        switch (random.nextInt(rolls)){
            case 0->{
                nextBackflipType= 1;
            }
            case 1->{
                nextBackflipType = 2;
            }
        }
    }
    public void getRandomSlashComboType(int rolls,int internalRolls){
        switch (random.nextInt(rolls)){
            case 0->{
                nextSlashComboType = 1;
            }
            case 1->{
                switch (random.nextInt(internalRolls)) {
                    case 0->{
                        nextSlashComboType = 2;
                    }
                    case 1->{
                        nextSlashComboType = 2;
                    }

                }

            }
        }
    }
    public void randomizeAttackPatterns(){
        getRandomSlashComboType(2,2);
        getRandomJumpSlashType(2);
        getRandomBackFlipType(2);
    }


    public AnimationState fastSweepBackflipAnimationState = new AnimationState();
    public AnimationState PowerfulJumpPreAnimationState = new AnimationState();
    public AnimationState PowerfulJumpFallAnimationState = new AnimationState();
    public AnimationState PowerfulJumpEndAnimationState = new AnimationState();

    public AnimationState stabAnimationState = new AnimationState();
    public AnimationState stabRunAnimationState = new AnimationState();
    public AnimationState stabPreRunAnimationState = new AnimationState();
    public AnimationState stabFailAnimationState = new AnimationState();
    public AnimationState stabSuccessAnimationState = new AnimationState();

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState blockNoHitupperAnimationState = new AnimationState();
    public AnimationState blockNoHitAnimationState = new AnimationState();
    public AnimationState blockHitPowerfulAnimationState = new AnimationState();
    public AnimationState slamComboQuadAnimationState = new AnimationState();
    public AnimationState doubleBackflipAnimationState = new AnimationState();
    public AnimationState backflipAnimationState = new AnimationState();

    public AnimationState doubleJumpSmashAnimationState = new AnimationState();
    public AnimationState jumpSmashAnimationState = new AnimationState();
    public AnimationState doubleComboBackFlipAnimationState = new AnimationState();
    public AnimationState doubleComboAnimationState = new AnimationState();
    public AnimationState tripleComboAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        }
        else if (input == "triple_combo") {
            return this.tripleComboAnimationState;
        }
        else if (input == "double_combo") {
            return this.doubleComboAnimationState;
        }
        else if (input == "double_combo_backflip") {
            return this.doubleComboBackFlipAnimationState;
        }
        else if (input == "jump_smash") {
            return this.jumpSmashAnimationState;
        }
        else if (input == "backflip") {
            return this.backflipAnimationState;
        }
        else if (input == "double_jump_smash") {
            return this.doubleJumpSmashAnimationState;
        }
        else if (input == "double_backflip") {
            return this.doubleBackflipAnimationState;
        }
        else if (input == "slam_combo_quad") {
            return this.slamComboQuadAnimationState;
        }
        else if (input == "block_hit_powerful") {
            return this.blockHitPowerfulAnimationState;
        }
        else if (input == "block_no_hit") {
            return this.blockNoHitAnimationState;
        }
        else if (input == "block_no_hit_upper") {
            return this.blockNoHitupperAnimationState;

        }

        else if (input == "stab_pre") {
            return this.stabPreRunAnimationState;
        }
        else if (input == "stab_success") {
            return this.stabSuccessAnimationState;
        }
        else if (input == "stab_fail") {
            return this.stabFailAnimationState;

        }
        else if (input == "powerful_jump_pre") {
            return this.PowerfulJumpPreAnimationState;
        }
        else if (input == "powerful_jump") {
            return this.PowerfulJumpFallAnimationState;
        }
        else if (input == "powerful_jump_end") {
            return this.PowerfulJumpEndAnimationState;

        }
        else if (input == "fast_sweep_backflip") {
            return this.fastSweepBackflipAnimationState;

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
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.tripleComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.doubleComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.doubleComboBackFlipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.jumpSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.backflipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.doubleBackflipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.doubleJumpSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.slamComboQuadAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.blockHitPowerfulAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.blockNoHitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.blockNoHitupperAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.stabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.stabRunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.stabPreRunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.stabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.stabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.PowerfulJumpPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.PowerfulJumpFallAnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.PowerfulJumpEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.fastSweepBackflipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.fastSweepBackflipAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public boolean isJumpAttacking(){
        return getAttackState() == 9 || getAttackState() == 7 && getAttackState() == 20;
    }
    public boolean canBeCollidedWith() {
        return isJumpAttacking();
    }
    @Override
    public int attackDelayTicksValue() {
        return 3;
    }

    public void stopAllAnimationStates() {
awakeAnimationState.stop();
sleepAnimationState.stop();
tripleComboAnimationState.stop();
        doubleComboAnimationState.stop();
        doubleComboBackFlipAnimationState.stop();
backflipAnimationState.stop();
        jumpSmashAnimationState.stop();
slamComboQuadAnimationState.stop();
      doubleBackflipAnimationState.stop();
        doubleJumpSmashAnimationState.stop();
        blockHitPowerfulAnimationState.stop();
        blockNoHitAnimationState.stop();

        blockNoHitupperAnimationState.stop();
stabPreRunAnimationState.stop();
        stabAnimationState.stop();
        stabSuccessAnimationState.stop();
       stabRunAnimationState.stop();
        stabFailAnimationState.stop();
fastSweepBackflipAnimationState.stop();
        PowerfulJumpPreAnimationState.stop();
        PowerfulJumpFallAnimationState.stop();
        PowerfulJumpEndAnimationState.stop();
    }
    public void BreakArmor(LivingEntity entity, boolean hurt, int brokenArmorPlusLevel) {
        MobEffect effect = ModEffects.BROKEN_ARMOR.get();
        MobEffectInstance current = entity.getEffect(effect);

        if (current == null) {
            entity.addEffect(new MobEffectInstance(effect, 100, brokenArmorPlusLevel));
        } else if (hurt) {
            int newAmp = current.getAmplifier() + brokenArmorPlusLevel;
            entity.addEffect(new MobEffectInstance(effect, 100, newAmp));
        }
    }
public double targetX;
    public double targetZ;
    public void UpdateWithAttack() {
        float swordSlamShake = 20;
        LivingEntity target = this.getTarget();
        //BASE COMBOS
        float baseComboFirstDashMult = 0.15f;
        float baseComboSecondDashMult = 0.25f;
        //Triple
        if (getAttackState() == 3) {
            if (attackTicks == 15) {
                calculatedDash(baseComboFirstDashMult);
            }
            if (attackTicks == 17) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 19) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }


            if (attackTicks == 31) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 33) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 35) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }
            if (attackTicks == 53) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

                calculatedDash(0.1f);
            }
            if (attackTicks == 54) {
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);

                spawnCircleParticle(3.5f,-1,15,true,2,1,1,1,1);
                spawnSoulPillar(2, 0);
                StraightLineAreaAttack(0.005f, 5, 120, 16, true);
                //  AreaAttack(5f,3,180,16,80,true);
            }
        }
//Double
        if (getAttackState() == 4) {
            if (attackTicks == 15) {
                calculatedDash(baseComboFirstDashMult);
            }
            if (attackTicks == 17) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 19) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }


            if (attackTicks == 31) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 33) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 35) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }
        }
        if (getAttackState() == 5) {
            if (attackTicks == 15) {
                calculatedDash(baseComboFirstDashMult);
            }
            if (attackTicks == 17) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }

            if (attackTicks == 19) {

                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }


            if (attackTicks == 31) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 33) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 35) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }
            if (attackTicks == 55) {
                float flipStrenght = -1.5f;

                float yaw = (float) Math.toRadians(this.getYRot() + 90);
                Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.2f, flipStrenght * Math.sin(yaw));
                this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
            }
        }

        //JUMP SMASH or DOUBLE JS
        if (getAttackState() == 6) {
            if (attackTicks == 6) {

                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getY() - this.getY();
                    double d2 = target.getZ() - this.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.3 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
                    this.setDeltaMovement(vec3);
                } else {

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.setDeltaMovement(vec3);
                }
            }
            if (attackTicks == 19) {
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);
                StraightLineAreaAttack(0.005f, 5, 120, 16, true);
                spawnSoulPillar(2, 0);
            }


        }
        if (getAttackState() == 9) {
            if (attackTicks == 6) {


                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getY() - this.getY();
                    double d2 = target.getZ() - this.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.3 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
                    this.setDeltaMovement(vec3);
                } else {

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.setDeltaMovement(vec3);
                }
            }
            if (attackTicks == 17) {
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);

                StraightLineAreaAttack(0.005f, 5, 120, 16, true);
                spawnSoulPillar(2, 0);


            }
            if (attackTicks == 47) {
                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getY() - this.getY();
                    double d2 = target.getZ() - this.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.3 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
                    this.setDeltaMovement(vec3);
                } else {

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.setDeltaMovement(vec3);
                }
            }
            if (attackTicks == 58) {
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);
                StraightLineAreaAttack(0.005f, 5, 120, 16, true);


                spawnSoulPillar(2, 0);
            }

        }
        //BACKFLIP

        if (getAttackState() == 7) {
            if (attackTicks == 8) {
                float flipStrenght = -1.5f;

                float yaw = (float) Math.toRadians(this.getYRot() + 90);
                Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.2f, flipStrenght * Math.sin(yaw));
                this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
            }
        }
        if (getAttackState() == 8) {
            if (attackTicks == 8) {
                float flipStrenght = -1.5f;

                float yaw = (float) Math.toRadians(this.getYRot() + 90);
                Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.2f, flipStrenght * Math.sin(yaw));
                this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
            }
            if (attackTicks == 28) {
                float flipStrenght = -1.5f;

                float yaw = (float) Math.toRadians(this.getYRot() + 90);
                Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.2f, flipStrenght * Math.sin(yaw));
                this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
            }
        }
        //SLAM COMBO
        if (getAttackState() == 10) {

            if (attackTicks == 20) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

                calculatedDash(0.1f);
            }
            if (attackTicks == 23) {
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);

                StraightLineAreaAttack(0.005f, 5, 120, 16, true);

                spawnSoulPillar(2, 0);
                // AreaAttack(5f,3,180,16,80,true);
            }
            if (attackTicks == 43) {
                calculatedDash(baseComboFirstDashMult);
            }
            if (attackTicks == 45) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 47) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }


            if (attackTicks == 60) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 62) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);

            }
            if (attackTicks == 64) {
                AreaAttack(3.5f, 3, 180, 14, 80, false, false,false,1);
            }


            if (attackTicks == 78) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 80) {
                playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);

            }
            if (attackTicks == 82) {
                AreaAttack(3.5f, 3, 360, 14, 80, false, false,false,1);
            }
        }
        if (getAttackState() == 11) {

            if (attackTicks == 37) {
                calculatedDash(baseComboSecondDashMult);
            }
            if (attackTicks == 37) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 2, 0.75f);
            }
            if (attackTicks == 41) {
                if (target !=null &&distanceTo(target) >6) {
                    AreaAttack(3.5f, 3, 180, 18, 100, true, true,false,1);
                }else {
                    AreaAttack(3.5f, 3, 180, 18, 100, true, true,false,1);
                }
            }
        }



        //POWERFUL JUMP SMASH
        if (getAttackState() == 19){
            if (attackTicks == 24){
              //  SpawnCircleParticle(1.5f,-0.25f,60,true,5,1,1,1f,1);
                double jumpStrenght = 0.8D;

                double jumpMult = 0.25D;
                if (target != null) {
                 //  this.setDeltaMovement((target.getX() - this.getX()) * jumpMult, jumpStrenght, (target.getZ() - this.getZ()) * jumpMult);
                } else {
                    //   this.setDeltaMovement(0, jumpStrenght, 0);
                }
                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getY() - this.getY();
                    double d2 = target.getZ() - this.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.7 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1D, 0.2D);
                    this.setDeltaMovement(vec3);
                } else {

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.setDeltaMovement(vec3);
                }
            }
        }
        if (getAttackState() == 20){
            if (onGround()){
                setAttackState(21);
            }
        }
        if (getAttackState() == 21){
           /** for (int i = 3, j = 2; i <= 8; i = i + 2, j++) {
             if (this.attackTicks == i) {
             SpawnDamagingBlocks(2, j, 4f, 2, 1, (float)1, 0.05F);
             }}**/
            if (attackTicks ==4){
                AreaAttack(5,4,180,18,140,false,false,false,1);
                playSound(SoundEvents.TOTEM_USE,1,0.75f);

                spawnCircleParticle(1.5f,-0.25f,60,true,5,0.25f,1,0.75f,1);
                Vec3 pos = new Vec3(getX(), getY(), getZ());
            //    StrikeBlades(7,1,false,15,2);
            //    StrikeBlades(7,1,false,15,2);
                //StrikeCircularBlades(7,6,15,false);
               // StrikeCircularBlades(17,15,15,false);
               // spawnHoneycombBlades(getX(), getZ(), 4, 1.8, 5f, false);
              strikeZigzagXBlades(12,1,false,15,4f,1,2f);

                //spawnHoneycombOutlineBlades(3, 2.0, 2, true, 6f);

                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
            }
            if (attackTicks ==31){

                float floor = (Mth.floor(this.getY())-1);
                if (target !=null) {
                    spawnBlades(target.getX(), target.getZ(), floor, target.getY(), yBodyRot, 4, true, 15);
                }
              //  spawnZigzagBlades(10,1,15,true);
                AreaAttack(5,4,180,18,140,false,false,false,1);
                playSound(SoundEvents.TOTEM_USE,1,0.75f);
                spawnCircleParticle(1.5f,0.5f,15,true,4,1,1,1,1);
                Vec3 pos = new Vec3(getX(), getY(), getZ());
               // StrikeBlades(15,1,true,15,3f);
               // StrikeCircularBlades(14,6,15,true);
              //  StrikeCircularBlades(30,10,15,true);
              //  spawnZigzagBlades(20,3,1,15,true);
                //spawnCrossBlades(true,15);
               // spawnHoneycombBlades(getX(), getZ(), 4, 1.8, 5f, true);
               // spawnHoneycombOutlineBlades(3, 2.0, 2, true, 6f);

                strikeZigzagXBlades(12,1,true,15,3f,2,2f);
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
            }
        }
        //STAB SMASH SYSTEM
        if (getAttackState() == 16) {
if (attackTicks ==20){
    if (target != null) {
        targetX = target.getX();
        targetZ = target.getZ();
    }
}
            if (attackTicks == 22) {
                if (target != null) {
                    this.setDeltaMovement((targetX - this.getX()) * 0.25f, 0, (targetZ - this.getZ()) * 0.25f);
                }
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(),1,1);
            }
            if (attackTicks == 26) {
                Grab(0.005f, 5, 120, 16);
            }

        }
        if (getAttackState() == 18) {
            if (attackTicks == 30) {
                playSound(SoundEvents.TOTEM_USE,1,1);

                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, swordSlamShake, 0.25f, 0, 20);
                spawnCircleParticle(1.5f,-0.25f,50,true,5,0.25f,1,0.75f,1);
                AreaAttack(6,4,360,14,120,false,false,true,2);
                //   Grab(0.005f, 5, 120, 16);
            }
            if (attackTicks >=30 && attackTicks <=35){
                Sphereparticle(ModParticles.GHOSTLY_SOUL.get(), 0.35f, 2.0f, 3);
            }
        }
//FAST SWEEP
        if (getAttackState() == 22) {
            if (attackTicks == 13) {
                calculatedDash(0.25f);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(),1,1);
            }
            if (attackTicks == 16) {
                AreaAttack(5,4,180,16,120,false,false,false,1);

            }
            if (attackTicks == 26) {
                float flipStrenght = -1.75f;
                float yaw = (float) Math.toRadians(this.getYRot() + 90);
                Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.2f, flipStrenght * Math.sin(yaw));
                this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
            }
        }

    }


    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int brokenShieldTicks, boolean canlaunch, boolean canStun, boolean isDamageGhostly,int brokenArmorAmplifier) {
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
                if (!isAlliedTo(entityHit)  &&!(entityHit instanceof NewPossessedPaladin)&& entityHit != this) {
if (getTarget() !=null) {

    float m = this.getTarget().getMaxHealth() * 0.03f;
    boolean flag = entityHit.hurt(isDamageGhostly ? ModDamageTypes.causeGhostlyDamage(this,this) :this.damageSources().mobAttack(this) , (float) ((damage * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get()) +m));

    BreakArmor(entityHit,flag,brokenArmorAmplifier);
    if (flag) {
if (canStun){
    if (entityHit == this.getTarget()){

        playSound(SoundEvents.ANVIL_PLACE,2,1f);
    }
    entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(),80,1));
}
//launch(entityHit,true,2,0.3f);
        if (canlaunch) {
            launch(entityHit, true);
        }
    }
}else {
    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));

    if (flag) {
//launch(entityHit,true,2,0.3f);
        if (canlaunch) {
            launch(entityHit, true);
        }
    }
}
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }
    private void StraightLineAreaAttack(float boxWidth,float range,int brokenShieldTicks,float damage,boolean launch){

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth,4,boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));

                BreakArmor(entityHit,flag,3);
                if (flag && launch){
//launch(entityHit,true,2,0.3f);
                    launch(entityHit,true);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }}

    private void Grab(float RangeXZ, float range, int brokenShieldTicks, float damage) {
        // tylko na serwerze
        if (this.level().isClientSide) return;

        boolean hitAny = false;
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox()
                .inflate(RangeXZ, 4, RangeXZ)
                .expandTowards(xRange, 0, zRange);

        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                hitAny = true;
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this),
                        (float)((damage * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())
                                + (this.getTarget() != null
                                ? this.getTarget().getMaxHealth() * 0.03f
                                : 0f)));
                BreakArmor(entityHit, flag, 1);

                boolean mounted = entityHit.startRiding(this, true);
                if (flag && mounted) {
                    succedGrabbing = true;
                } else {
                    succedGrabbing = false;
                }


                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }

                break;
            }
        }

        if (!hitAny) {

            succedGrabbing = false;

        }
    }
public boolean succedGrabbing;
    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float math = -0.25f;
        float vec = 1.5f;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        return new Vec3(getX() + vec * vecX + f * math,getY(),getZ() + vec * vecZ + f1 * math);
    }

    @Override
    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        if (!hasPassenger(passenger)) return;
        float offset = -0.25f;

        float startPos = 3.5f;
        float endPos   = 1.5f;
        float pos      = startPos;
        float cos      = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F));
        float sin      = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F));
        double theta   = Math.toRadians(this.yBodyRot + 90);
        double vecX    = Math.cos(theta), vecZ = Math.sin(theta);
        float baseY = (float)(this.getY() + 2f);

        if (this.getAttackState() == 18) {
            int tick      = this.attackTicks;
            int upTicks   = 23;
            int downTicks = 8;
            float maxExtraY = 2f;
            float extraY    = -2f;

            if (tick <= upTicks) {
                extraY = (tick / (float)upTicks) * maxExtraY;
            } else if (tick <= upTicks + downTicks) {
                float t2 = tick - upTicks;
                extraY = (1 - (t2 / (float)downTicks)) * maxExtraY * 2;
            }
            baseY += extraY;

            if (tick <= upTicks) {
                float t = tick / (float)upTicks;
                pos = Mth.lerp(t, startPos, endPos);
            } else {
                pos = endPos;
            }
        }
        double riderX = this.getX() + pos * vecX + cos * offset;
        double riderZ = this.getZ() + pos * vecZ + sin * offset;
        moveFunc.accept(passenger, riderX, baseY, riderZ);
if (getAttackState() == 18){
    if (attackTicks == 35){

        passenger.stopRiding();
    }
}
        if (getAttackState() == 0) {
            passenger.stopRiding();
        }
    }


    public double damageCap(){
        return 20;
    }
    public boolean isParrying(){
        return (getAttackState() == 11 && attackTicks <35) || (getAttackState() ==12 && attackTicks <45);
    }
    public boolean canParry(){
        return getAttackState() ==0&&getTarget() !=null&& !level().isClientSide && distanceTo(this.getTarget()) >6 && parryCooldown <=0;
    }
    public boolean canAggresiveParry(){
        return getAttackState() ==0  && AggresiveparryCooldown <=0&& !level().isClientSide && getTarget() !=null&& distanceTo(this.getTarget()) <6;
    }

    public boolean isStabbing(){
        return getAttackState() == 18;
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (isStabbing()){
            return false;
        }
        if (canAggresiveParry() && amount >1){
            setAttackState(11);
            playSound(SoundEvents.ANVIL_LAND,1,2);
        }else if (canParry() && amount >1){
if (random.nextInt() * 100 <50 && canParry()) {
    setAttackState(12);
}else{
    setAttackState(13);
}
            playSound(SoundEvents.ANVIL_LAND,1,2);
        }
        if (isParrying()){
            amount *=0.1f;
            if (tickCount %2 ==0 && !level().isClientSide) {
                playSound(SoundEvents.ANVIL_LAND, 1, 2);
            }
        }
        if((source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)|| !source.is(DamageTypes.MAGIC) )&& reducedDamageTicks >0) {
            amount *= 0.6f;
        }


        if (reducedDamageTicks <=0){
            reducedDamageTicks = REDUCED_DAMAGE_TICKS;
        }
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        } else {
            amount = (float) Math.min(damageCap(), amount);
        }
        return super.hurt(source, amount);
    }
    public void spawnSoulPillar(float vec,float offset){
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int standingOnY = Mth.floor(getY()) - 1;
        double headY = getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + getYRot()));


        for (int l = 0; l < 5; l++) {
            double d2 = 1.25D * (double) (l + 1);

            int j = 1 * l;
            if (this.spawnSoulPillars((getX() + vec * vecX + f * offset) + (double) Mth.cos(yawRadians) * d2, headY, (getZ() + vec * vecZ + f1 * offset) + (double) Mth.sin(yawRadians) * d2, standingOnY, yawRadians, j, level(), this));


        }
    }
    private boolean spawnSoulPillars(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
                if (!world.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
           world.addFreshEntity(new SoulPillarEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, this,20,5,false));
            return true;
        }
        return false;
    }
    public void StrikeCircularBlades(int amount,float radius,float damage,boolean falling){

        int standingOnY = Mth.floor(getY());
        for (int k = 0; k < amount; ++k) {
            float f2 = (float) k * (float) Math.PI * radius / amount + ((float) Math.PI * 2F / amount-1);
            this.spawnBlades(this.getX() + (double) Mth.cos(f2) * radius, this.getZ() + (double) Mth.sin(f2) * radius, standingOnY, this.getY() + 1, f2, 0,falling,damage);
        }
    }
    private void StrikeBlades(int rune, double time, boolean isFalling,float damage,float divider) {
        for(int i = 0; i < rune; ++i) {
            float throwAngle = (float)i * 3.1415927F / (float)(rune / divider);

            for(int k = 0; k < 8; ++k) {
                double d2 = 1.15 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnBlades(this.getX() + (double) Mth.cos(throwAngle) * 1.25 * d2, this.getZ() + (double)Mth.sin(throwAngle) * 1.25 * d2, this.getY(), this.getY() + 2.0, throwAngle, d3,isFalling,damage);
            }
        }

    }
    private void spawnBlades(double x, double z, double minY, double maxY, float rotation, int delay, boolean falling,float damage) {

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
            if (falling) {
                this.level().addFreshEntity(new FallingSoulBladeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, damage,false));
            }else {

                this.level().addFreshEntity(new SoulBladeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1,damage,false));
            }
        }
    }
    public void SpawnDamagingBlocks(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
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
                }
            }
        }
    }
    private void spawnCrossBlades(boolean falling,float damage) {
        LivingEntity target = this.getTarget();
        float f6 = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int standingOnY = Mth.floor(getY()) - 1;
        double headY = getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + getYRot()));
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;

            float f7 = (float) Mth.atan2( (getZ() -10 * vecZ + f1 * 1)-getZ(),(getX()-10 * vecX + f6 * 1)-getX());
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (0.5f);

            float fNeutral = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (0f);
            float f4 = Mth.cos(this.getYRot() * ((float) Math.PI / -180F)) * (-0.5F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (0.5f);
            float f5 = Mth.sin(this.getYRot() * ((float) Math.PI / -180F)) * (-0.5f);
            for(int l = 0; l < 10; ++l) {
                double d2 = 1.25D * (double)(l + 1);
                double d3 = -1.25D * (double)(l + 1);
                int j = (int) (1.25f * l);

                this.spawnBlades(this.getX() + fNeutral + (double)Mth.cos(f) * d2, this.getZ() + f3 + (double)Mth.sin(f) * d2, d0, yBodyRot, f, j,falling,damage);
                this.spawnBlades(this.getX() - fNeutral + (double) Mth.cos(f7) * d2, this.getZ() - f3 + (double) Mth.sin(f7) * d2, d0, yBodyRot, f7, j,falling,damage );

            }


        }

    }
    public void spawnZigzagBlades(int count, int offset,float vec, float damage, boolean falling) {
        LivingEntity target = this.getTarget();
        if (target == null) return;

        float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
        float perpX = -(float) Mth.sin(f);
        float perpZ =  (float) Mth.cos(f);
        double d0 = Math.min(target.getY(), this.getY());

        for (int l = 0; l < count; ++l) {
            double forward = 1.25D * (l + 1);
            double amplitude = vec;

            // ---- tutaj nowa logika ----
            // (l/offset)%2 == 0 -> w prawo, ==1 -> w lewo
            int group = (l / offset) % 2;
            double lateralOffset = amplitude * (group == 0 ? 1 : -1);
            // ----------------------------

            double xOffset = Mth.cos(f) * forward + perpX * lateralOffset;
            double zOffset = Mth.sin(f) * forward + perpZ * lateralOffset;

            int delay = (int)(1.25f * l);
            this.spawnBlades(
                    this.getX() + xOffset,
                    this.getZ() + zOffset,
                    d0,
                    yBodyRot,
                    f,
                    delay,
                    falling,
                    damage
            );
        }
    }
    /**
     * Strikes blades in an "X" with <rune> arms, spreading each line in a zigzag pattern.
     *
     * @param rune number of arms X
     * @param time delay factor
     * @param isFalling whether these are falling swords
     * @param damage damage
     * @param divider how wide to spread the arms (the larger the range, the flatter the shape)
     * @param offset how many swords in one lateral direction (before the sign change) — as in zigzag
     * @param amplitude how far they are laterally offset from a straight line
     */
    private void strikeZigzagXBlades(int rune, double time, boolean isFalling, float damage, float divider,
                                     int offset, double amplitude) {
        for (int i = 0; i < rune; i++) {
            float throwAngle = (float) i * (float)Math.PI / (rune / divider);

            float perpX = -(float) Mth.sin(throwAngle);
            float perpZ =  (float) Mth.cos(throwAngle);

            for (int k = 0; k < 8; k++) {
                double forward = 1.25 * (k + 1);

                int group = (k / offset) % 2;
                double lateral = amplitude * (group == 0 ? 1 : -1);

                double xOff = Mth.cos(throwAngle) * forward + perpX * lateral;
                double zOff = Mth.sin(throwAngle) * forward + perpZ * lateral;

                int delay = (int)(time * (k + 1));

                this.spawnBlades(
                        this.getX() + xOff,
                        this.getZ() + zOff,
                        this.getY(),
                        this.getY() + 2.0,
                        throwAngle,
                        delay,
                        isFalling,
                        damage
                );
            }
        }
    }
    /**
     * Spawns swords in a honeycomb outline,
     * repeating this pattern across a hex area within the radius.
     *
     * @param radius radius (in hexes) from the center (this.getX(), this.getZ())
     * @param hexSize size of a single hex (from center to vertex)
     * @param bladeSpacing distance between consecutive swords along each side
     * @param falling whether these should be falling swords
     * @param damage damage to the swords
     */
    public void spawnHoneycombOutlineBlades(int radius,
                                            double hexSize,
                                            double bladeSpacing,
                                            boolean falling,
                                            float damage) {
        double h = Math.sqrt(3.0) / 2.0 * hexSize;
        double centerX0 = this.getX();
        double centerZ0 = this.getZ();
        double minY     = this.getY();

        Set<BlockPos> used = new HashSet<>();

        for (int q = -radius; q <= radius; q++) {
            int r1 = Math.max(-radius, -q - radius);
            int r2 = Math.min(radius,  -q + radius);
            for (int r = r1; r <= r2; r++) {
                double cx = centerX0 + hexSize * 1.5 * q;
                double cz = centerZ0 + h       * (2 * r + q);

                for (int side = 0; side < 6; side++) {
                    double angle1 = Math.PI / 3 * side;
                    double angle2 = angle1 + Math.PI / 3;

                    double v1x = cx + hexSize * Math.cos(angle1);
                    double v1z = cz + hexSize * Math.sin(angle1);
                    double v2x = cx + hexSize * Math.cos(angle2);
                    double v2z = cz + hexSize * Math.sin(angle2);

                    double edgeLen = hexSize;
                    int steps = Math.max(1, (int)(edgeLen / bladeSpacing));

                    for (int s = 0; s <= steps; s++) {
                        double t = (double)s / steps;
                        double x = v1x + (v2x - v1x) * t;
                        double z = v1z + (v2z - v1z) * t;

                        BlockPos pos = new BlockPos(
                                Mth.floor(x),
                                Mth.floor(minY),
                                Mth.floor(z)
                        );
                        if (!used.add(pos)) continue;

                        float yaw = (float)Math.toDegrees(angle1 + Math.PI/2);
                        int delay = (int)(5 * side + 5 * t);

                        this.spawnBlades(
                                x, z,
                                minY, minY + 2.0,
                                yaw,
                                delay,
                                falling,
                                damage
                        );
                    }
                }
            }
        }
    }

    private void Sphereparticle(ParticleOptions particleType, float height, float vec, float size) {
        if (this.level().isClientSide) {
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


                            this.level().addParticle(particleType, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }}
    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return passenger instanceof LivingEntity && this.getPassengers().isEmpty();
    }

    static class PossessedPaladinStabGoal extends IAttackGoal{
        protected final NewPossessedPaladin entity;

        public PossessedPaladinStabGoal(NewPossessedPaladin entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
        }

        @Override
        public void start() {
            super.start();
            //System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());
        }

        @Override

        public void stop() {
          //  System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());

            if (entity.succedGrabbing) {
                if (!entity.level().isClientSide) {
                    entity.setAttackState(18);
                }
                entity.succedGrabbing = false;
            } else {
                super.stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }



    public void spawnZigzagBlades(int count, int offset, float damage, boolean falling) {
        LivingEntity target = this.getTarget();
        if (target == null) return;

        float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
        float perpX = -(float) Mth.sin(f);
        float perpZ =  (float) Mth.cos(f);
        double d0 = Math.min(target.getY(), this.getY());

        for (int l = 0; l < count; ++l) {
            double forward = 1.25D * (l + 1);
            double amplitude = 0.5D;
            int group = (l / offset) % 2;
            double lateralOffset = amplitude * (group == 0 ? 1 : -1);

            double xOffset = Mth.cos(f) * forward + perpX * lateralOffset;
            double zOffset = Mth.sin(f) * forward + perpZ * lateralOffset;

            int delay = (int)(1.25f * l);
            this.spawnBlades(
                    this.getX() + xOffset,
                    this.getZ() + zOffset,
                    d0,
                    yBodyRot,
                    f,
                    delay,
                    falling,
                    damage
            );
        }
    }
    private void spawnRandomSoulPillars(int amount,float random,int warmup, int minusdelay) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            for (int k = 0; k < amount; ++k) {
                this.spawnSoulPillarsForEveryCode(this.getX() + this.random.nextGaussian() * random, this.getZ() + this.random.nextGaussian() * random, d0, d1, f3, warmup);
            }
            for (int k = 0; k < amount; ++k) {
                this.spawnSoulPillarsForEveryCode(this.getX() + this.random.nextGaussian() * random, this.getZ() + this.random.nextGaussian() * random, d0, d1, f3, warmup- minusdelay);
            }


        }
    }
    private void spawnSoulPillarsForEveryCode(double pX, double pZ, double pMinY, double pMaxY, float pYRot, int pWarmupDelay) {
        BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
        boolean flag = false;
        double d0 = 0.0;

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
        } while(blockpos.getY() >= Mth.floor(pMinY) - 1);

        if (flag) {
            this.level().addFreshEntity(new SoulPillarEntity(this.level(), pX, (double)blockpos.getY() + d0, pZ, pYRot, pWarmupDelay, this,20,5,false));
        }

    }
}
