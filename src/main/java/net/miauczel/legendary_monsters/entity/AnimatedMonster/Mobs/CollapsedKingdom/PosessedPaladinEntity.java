package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.OldKnights.HauntedKnightEntityOld;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Lava_eaterEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveSpawner;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulStrike;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class PosessedPaladinEntity extends IAnimatedMiniBoss {
    public void resetAttackAnimationTick() {
        this.attackAnimationTick = 0;
    }

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    private int attackAnimationTick = 0;
    //  private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.NOTCHED_6);
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(PosessedPaladinEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(PosessedPaladinEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_SECOND_PHASE =
            SynchedEntityData.defineId(PosessedPaladinEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> Tr =
            SynchedEntityData.defineId(PosessedPaladinEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean isSecondPhase() {
        return entityData.get(IS_SECOND_PHASE);
    }

    public void setSecondPhase(boolean phase) {
        entityData.set(IS_SECOND_PHASE, phase);
    }

    public PosessedPaladinEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 100;

        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }

    public int AttackReady() {
        return attackAnimationTick = 5;
    }

    public boolean canStun() {
        return stunCooldown <= 0;
    }

    public boolean h() {
        return this.entityData.get(ATTACKING) == Boolean.TRUE;
    }

    public boolean k() {
        return this.tr == Boolean.TRUE;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    private static final int STUN_COOLDOWN_DURATION = 200;
    private int stunCooldown = 0;

    public void attackTargets(Entity entity1) {
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 14 * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get();

        //deal damage
        if (entity1 instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof Player || livingEntity instanceof ServerPlayer) {
                if (this.level().getDifficulty() == Difficulty.HARD) {
                    livingEntity.hurt(damageSource, (float) (damage - 5));

                } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    livingEntity.hurt(damageSource, (float) damage);

                } else if (this.level().getDifficulty() == Difficulty.EASY) {
                    livingEntity.hurt(damageSource, (float) (damage + 13));

                }
            }
        }
    }

    public PosessedPaladinEntity.Crackiness getCrackiness() {
        return PosessedPaladinEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<PosessedPaladinEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static PosessedPaladinEntity.Crackiness byFraction(float pFraction) {
            for (PosessedPaladinEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }


    private void sendActionBarMessageToPlayer(Player player, String message) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.literal(message)));
        }
    }

    private boolean hasPlayedHurtSound = false;

    public void resetSmashAnchorCooldown() {
        if (bigsmashCooldown <= 0) {
            this.bigsmashCooldown = SMASH_ANCHOR_COOLDOWN;
        }
    }

    public void resetSmash2Cooldown() {
        if (bigsmash2Cooldown <= 0) {
            this.bigsmash2Cooldown = SMASH_ANCHOR2_COOLDOWN;
        }
    }

    public void resetSmashCooldown() {
        if (smashCooldown <= 0) {
            this.smashCooldown = SMASH_COOLDOWN;
        }
    }

    public int gcool = 0;
    public boolean hasUsedSwordSmash = false;
    public int pcool = 0;

    @Override
    public void tick() {
        super.tick();

        PosessedPaladinEntity.Crackiness crackiness = this.getCrackiness();
        if ((getAttackState() == 0 && (crackiness == PosessedPaladinEntity.Crackiness.MEDIUM || crackiness == Crackiness.HIGH) && !isSecondPhase())) {
            setAttackState(15);
        }
        if (gcool > 0) {
            --gcool;
        }

        if (pcool > 0) {
            --pcool;
        }
        if (smashCooldown > 0) {
            --smashCooldown;
        }

        if (pcooldown > 0) {
            --pcooldown;
        }
        if (teleportCooldown > 0) {
            --teleportCooldown;
        }
        if (bigsmashCooldown > 0) {
            --bigsmashCooldown;
        }
        if (bigsmash2Cooldown > 0) {
            --bigsmash2Cooldown;
        }

        if (tcooldown > 0) {
            --tcooldown;
        }

        if (this.stunCooldown == 0 && this.getTarget() instanceof Player player) {

        }

        if (this.level().isClientSide()) {

        }
        if (this.getTarget() instanceof Player pPlayer && this.getTarget() != null) {
            if (stunCooldown == 0) {
            } else {
                this.entityData.set(TEXTURE_VARIANT, 0);
            }
        }

        if (stunCooldown > 0) {

            stunCooldown--;
        }
        if (crackiness == PosessedPaladinEntity.Crackiness.MEDIUM && hasPlayedHurtSound == false) {

            hasPlayedHurtSound = true;

        }

    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState slashAnimationState = new AnimationState();
    public AnimationState midSlashAnimationState = new AnimationState();
    public AnimationState comboAnimationState = new AnimationState();
    public AnimationState combo1AnimationState = new AnimationState();
    public AnimationState combo3AnimationState = new AnimationState();

    public AnimationState combo7AnimationState = new AnimationState();
    public AnimationState combo8AnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState runAnimationState = new AnimationState();
    public AnimationState dmgAnimationState = new AnimationState();
    public AnimationState postRunAnimationState = new AnimationState();

    public AnimationState c10AnimationState = new AnimationState();
    public AnimationState c9AnimationState = new AnimationState();
    public AnimationState prerununAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {

        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "slash") {
            return this.slashAnimationState;
        } else if (input == "midslash") {
            return this.midSlashAnimationState;
        } else if (input == "combo") {
            return this.comboAnimationState;
        } else if (input == "combo1") {
            return this.combo1AnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "combo3") {
            return this.combo3AnimationState;
        } else if (input == "combo8") {
            return this.combo8AnimationState;
        } else if (input == "combo7") {
            return this.combo7AnimationState;
        } else if (input == "run") {
            return this.runAnimationState;
        } else if (input == "damage") {
            return this.dmgAnimationState;
        } else if (input == "postrun") {
            return this.postRunAnimationState;
        } else if (input == "runpre") {
            return this.prerununAnimationState;
        } else if (input == "c9") {
            return this.c9AnimationState;
        } else if (input == "c10") {
            return this.c10AnimationState;
        } else {

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
                        this.slashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.midSlashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.comboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.combo1AnimationState.startIfStopped(this.tickCount);
                    }

                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.combo7AnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.combo8AnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.combo3AnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.postRunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.runAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.dmgAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.prerununAnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.c9AnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.c10AnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.comboAnimationState.stop();
        this.combo1AnimationState.stop();
        this.slashAnimationState.stop();
        this.midSlashAnimationState.stop();
        this.combo3AnimationState.stop();
        this.deathAnimationState.stop();

        this.c10AnimationState.stop();
        this.c9AnimationState.stop();
        this.combo7AnimationState.stop();
        this.combo8AnimationState.stop();
        this.prerununAnimationState.stop();

        this.postRunAnimationState.stop();
        this.runAnimationState.stop();
        this.dmgAnimationState.stop();
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0;
        }
        this.walkAnimation.update(f, 0.2f);
    }


    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(IS_SECOND_PHASE, false);
        this.entityData.define(ATTACKING, false);
        this.entityData.define(TEXTURE_VARIANT, 0);


    }

    public int attackLock = 0;
    private boolean tr = false;
    public int tcooldown = 160;

    public int pcooldown = 0;

    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Lava_eaterEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 43, 10, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 45.0F < 16.0F && PosessedPaladinEntity.this.bigsmashCooldown <= 0
                        && !(PosessedPaladinEntity.this.pcooldown <= 0)
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 6) && !(PosessedPaladinEntity.this.h())

                        && !(PosessedPaladinEntity.this.getAttackState() == 19) && PosessedPaladinEntity.this.attackLock == 0 && !(PosessedPaladinEntity.this.getAttackState() == 20)
                        ;
            }

            public void stop() {
                super.stop();
                resetSmashAnchorCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 40, 10, 5.5F) {
            public boolean canUse() {

                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 25.0F < 16.0F && PosessedPaladinEntity.this.bigsmash2Cooldown <= 0
                        && !(PosessedPaladinEntity.this.pcooldown <= 0)
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 9)
                        && PosessedPaladinEntity.this.attackLock == 0 && !PosessedPaladinEntity.this.h();
            }

            public void stop() {
                super.stop();
                resetSmash2Cooldown();

            }
        });
        //chargePrepare
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 9, 0, 83, 15, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && PosessedPaladinEntity.this.gcool <= 0
                        // && !(PosessedPaladinEntity.this.pcooldown <= 0)
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 20) && !(PosessedPaladinEntity.this.getAttackState() == 5) && PosessedPaladinEntity.this.attackLock == 0;
            }

            public void stop() {
                super.stop();
                if (PosessedPaladinEntity.this.h()) {
                    gcool = 120;
                } else {
                    gcool = 120;
                }

            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 19, 0, 69, 15, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 50.0F < 16.0F && PosessedPaladinEntity.this.pcooldown <= 0
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 9) && PosessedPaladinEntity.this.attackLock == 0 && !PosessedPaladinEntity.this.h();
            }

            public void stop() {
                super.stop();
                pcooldown = 60;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 22, 0, 77, 55, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 60.0F < 16.0F
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 9) && PosessedPaladinEntity.this.attackLock == 0 && PosessedPaladinEntity.this.h();
            }

            public void stop() {
                super.stop();
                //pcooldown= 30;

            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 20, 0, 89, 15, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 9) && PosessedPaladinEntity.this.attackLock == 0 && PosessedPaladinEntity.this.h() == true;
            }

            public void stop() {
                super.stop();
                pcooldown = 60;

            }
        });


        this.goalSelector.addGoal(0, new IStateGoal(this, 15, 15, 0, 55, 0) {
            @Override
            public void start() {
                setSecondPhase(true);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !isSecondPhase();
            }

            @Override
            public void stop() {
                hasUsedSwordSmash = true;
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 46, 15, 5.5F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && PosessedPaladinEntity.this.smashCooldown <= 0
                        && PosessedPaladinEntity.this.getTarget() != null && !(PosessedPaladinEntity.this.getAttackState() == 5) && !(PosessedPaladinEntity.this.getAttackState() == 19)

                        && !(PosessedPaladinEntity.this.getAttackState() == 20) && PosessedPaladinEntity.this.attackLock == 0 && !h() && !(PosessedPaladinEntity.this.pcooldown <= 0);
            }

            public void stop() {
                super.stop();
                resetSmashCooldown();

            }

        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 40, 75, 5.5F) {


            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.attackLock == 0 && !(PosessedPaladinEntity.this.getAttackState() == 9)
                        && PosessedPaladinEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && !(PosessedPaladinEntity.this.h());
            }
        });


        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 46, 30, 5.5F) {
            @Override
            public void start() {

                super.start();
            }

            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && PosessedPaladinEntity.this.teleportCooldown <= 0 && !(PosessedPaladinEntity.this.getAttackState() == 9) && PosessedPaladinEntity.this.attackLock == 0;
            }

            @Override
            public void stop() {
                super.stop();
                PosessedPaladinEntity.this.setInvulnerable(false);
                PosessedPaladinEntity.this.teleportCooldown = 60;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 16, 17, 20, 10, 15.0F, 2F) {
            public boolean canUse() {
                return super.canUse() && PosessedPaladinEntity.this.getRandom().nextFloat() * 100.0F < 9.0F && PosessedPaladinEntity.this.tcooldown <= 0 && PosessedPaladinEntity.this.attackLock == 0;
            }
        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 17, 17, 18, 30, 0) {
            public void tick() {
                if (this.entity.onGround()) {
                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * 0.017453292F;
                    Vec3 vector3d1 = (new Vec3((double) (-Mth.sin(f)), this.entity.getDeltaMovement().y, (double) Mth.cos(f))).scale(0.45).add(vector3d.scale(0.6));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }

            }
        });
        this.goalSelector.addGoal(0, new IAttackGoal(this, 17, 18, 0, 75, 40, 5.0F) {
            public void stop() {
                super.stop();
                PosessedPaladinEntity.this.tcooldown = 160;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 18, 18, 0, 75, 40) {
            public void stop() {
                super.stop();
                PosessedPaladinEntity.this.tcooldown = 160;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15) {
            public boolean canUse() {
                return super.canUse() && !(PosessedPaladinEntity.this.getAttackState() == 9);
            }
        });
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


                            this.level().addParticle(ParticleTypes.SCULK_SOUL, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        } else {
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


                            ParticleOptions type = ParticleTypes.FLAME;
                            this.level().addParticle(ParticleTypes.SOUL, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public void performAreaAttack() {
        double attackRadius = 4.0;
        double attackHeight = 3.0;
        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && !(entity == this.getTarget()) && !(entity instanceof HauntedGuardEntity) && !(entity instanceof HauntedKnightEntityOld)) {
                if (!(entity instanceof CameraShakeEntity)) {

                    this.doHurtTarget(livingEntity);
                }
            }
        }
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }

    @Override
    public boolean fireImmune() {
        if (this.getTextureVariant() == 1 || isAttacking()) {
            return true;
        } else return false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        updateWithAttack();
        if (this.entityData.get(TEXTURE_VARIANT) == 1) {


            Sphereparticle(0.35f, 2.0f, 3);
        }
        if (this.getAttackState() == 15) {
        }
        if (this.horizontalCollision && this.isInWall()) {

            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
        LivingEntity target = this.getTarget();

        if (target != null) {
            double targetX = target.getX() - this.getX();
            double targetY = target.getEyeY() - this.getEyeY();
            double targetZ = target.getZ() - this.getZ();
            double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

            // Oblicz kąt obrotu moba w kierunku celu
            float yaw = (float) (Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
            float pitch = (float) (-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

            // Obróć głowę moba w kierunku celu
            this.yHeadRot = this.yBodyRot = yaw;
            this.yBodyRot = pitch;

            // Zmień szybkość moba na 0.1
            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.1) {
                movementSpeedAttribute.setBaseValue(0.1);
            }
        } else {
            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.0) {
                movementSpeedAttribute.setBaseValue(0.0);
            }
        }
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 170/*ModConfig.COMMON.posessedPaladinHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.0F) // Domyślna szybkość 0.0
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .add(Attributes.ATTACK_DAMAGE, 16/*ModConfig.COMMON.posessedPaladinDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.OVERGROWN_COLOSSUS_DEATH.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }

    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {

        pStack.addTagElement("Enchantments", new ListTag());

        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);

        if (itemEntity != null) {
            itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        this.dragonDeathTime = 0;

        this.setAttackState(8);
        Vec3 entityPosition = this.position();
        CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.025F, 140, 20);


        ItemStack emerald = new ItemStack(Items.AIR, 1);

        emerald = this.getItemWithLootingEnchant(emerald, source.getEntity());
    }

    private ItemStack getItemWithLootingEnchant(ItemStack stack, Entity killer) {
        if (killer instanceof Player) {
            int lootingLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.MOB_LOOTING, (LivingEntity) killer);

            if (lootingLevel > 0) {
                stack.grow(lootingLevel);
            }
        }
        return stack;
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.PossessedPaladinHealthMultiplier.get());
        attackLock = 0;
        this.setPersistenceRequired();
    }


    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);

        seeing = true;
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);

        seeing = false;

    }

    private boolean seeing = false;

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Sleep", isSleep());

        compound.putBoolean("phase", this.isSecondPhase());
        compound.putInt("TextureVariant", this.getTextureVariant());
        compound.putInt("StunCooldown", this.stunCooldown);
        compound.putBoolean("Attacking", this.h());
        compound.putBoolean("Tr", this.k());
        compound.putInt("AttackLock", attackLock);

        compound.putBoolean("usedSmash", hasUsedSwordSmash);
    }


    private int teleportCooldown = 0;
    private int smashCooldown = 0;
    private final int SMASH_COOLDOWN = 160;
    public int bigsmashCooldown = 0;
    public final int SMASH_ANCHOR_COOLDOWN = 160;
    public final int SMASH_ANCHOR2_COOLDOWN = 100;
    public int bigsmash2Cooldown = 0;


    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        attackLock = compound.getInt("AttackLock");
        tr = compound.getBoolean("Tr");
        this.entityData.set(ATTACKING, compound.getBoolean("Attacking"));
        setSleep(compound.getBoolean("is_Sleep"));

        hasUsedSwordSmash = compound.getBoolean("usedSmash");

        this.stunCooldown = compound.getInt("StunCooldown");
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));
        this.entityData.set(IS_SECOND_PHASE, compound.getBoolean("phase"));
        if (this.getHealth() == this.getMaxHealth()) {
            //    updateAttributes();
        }
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        // if (this.getCrackiness() == PosessedPaladinEntity.Crackiness.MEDIUM && hasPlayerHurtSound) {
        //  this.playSound(SoundEvents.ANVIL_USE, 2.0F, 1.0F);
        // hasPlayerHurtSound = true;
        // }
        if (this.getAttackState() == 15 || this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (ModConfig.MOB_CONFIG.Posessedprojectile.get()) {
            // Jeżeli źródłem obrażeń jest strzała, mob nie otrzymuje obrażeń
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }


        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;

        return super.hurt(source, amount);
    }

    /*public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.PosessedPaladinHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 185D; // podstawowe zdrowie moba
        double baseAttackDamage = 14D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }*/
    public int dragonDeathTime;

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.dragonDeathTime >= 140 && this.dragonDeathTime <= 160) {
            float f = (this.random.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;


            this.playSound(SoundEvents.GENERIC_EXPLODE, 1, 0.5F);
            this.level().addParticle(ParticleTypes.EXPLOSION_EMITTER, this.getX() + (double) f, this.getY() + 2.0D + (double) f1, this.getZ() + (double) f2, 0.0D, 0.0D, 0.0D);
        }

        boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);
        int i = 500;

        if (this.level() instanceof ServerLevel) {
            if (this.dragonDeathTime > 150 && this.dragonDeathTime % 5 == 0 && flag) {
                int experience = Mth.floor((float) i * 0.08F);
                //ExperienceOrb.award/((ServerLevel) this.level(), this.position(), experience);
            }

            if (this.dragonDeathTime == 1 && !this.isSilent()) {
                //this.playSound(SoundEvents.ENDER_DRAGON_DEATH,1,2);
                //this.level().globalLevelEvent(1028, this.blockPosition(), 0);
            }
        }
        if (this.dragonDeathTime == 140) {
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 20, 20);
        }
        this.move(MoverType.SELF, new Vec3(0.0D, (double) 0.1F, 0.0D));
        if (this.dragonDeathTime == 160 && this.level() instanceof ServerLevel) {
            if (flag) {

                ItemStack diamond = new ItemStack(ModItems.CORRUPTED_SOUL.get(), 1);
                ItemStack emerald = new ItemStack(Items.AIR, 1);
                //  LGspawnatlocation(diamond);

                int experience = Mth.floor((float) i * 0.2F);
                // ExperienceOrb.award((ServerLevel) this.level(), this.position(), experience);
            }

            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    private void launchMini(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? 1.2F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.3 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, float knockback, boolean BNknockback, float Lstrenght, boolean launch) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof PosessedPaladinEntity) && !(entityHit instanceof HauntedGuardEntity) && !(entityHit instanceof HauntedKnightEntityOld) && entityHit != this) {
                    if (!stun) {
                    }
                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));

                    if (this.getAttackState() == 4 || this.getAttackState() == 3) {
                        if (this.attackTicks == 20) {
                            if (BNknockback && !entityHit.isBlocking()) {
                                double knockbackRadius = 5.0;

                                double dx = entityHit.getX() - this.getX();
                                double dz = entityHit.getZ() - this.getZ();
                                double distance = Math.sqrt(dx * dx + dz * dz);
                                double knockbackStrength = knockback + 0.5 * (knockbackRadius - distance); // Siła odrzucenia maleje z odległością
                                entityHit.push(dx / distance * knockbackStrength, 0.4, dz / distance * knockbackStrength);
                            }

                            Vec3 entityPosition = this.position();
                            CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                        }
                    }

                    PosessedPaladinEntity.Crackiness crackiness = this.getCrackiness();
                    if (!entityHit.isBlocking() && Math.random() > 0.5) {
                        if (h()) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 60, 0));
                        }
                    }
                    if (launch) {
                        if (this.getAttackState() == 6 || this.getAttackState() == 7) {
                            this.launch(entityHit, true);

                        }
                        if (this.getAttackState() == 4) {
                            this.launchMini(entityHit, true);
                        }
                        if (this.getAttackState() == 9) {
                            // this.launchMini(entityHit, true);
                            if (this.attackTicks == 60) {
                                if (!entityHit.isBlocking()) {
                                    MobEffectInstance brokenArmorEffect = entityHit.getEffect(ModEffects.BROKEN_ARMOR.get());
                                    if (brokenArmorEffect != null) {
                                        int currentLevel = brokenArmorEffect.getAmplifier();
                                        if (currentLevel < 6) {
                                            entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, currentLevel + 3));
                                        } else {

                                            entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 4));
                                        }
                                    } else {
                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 0));
                                        // }
                                    }

                                }
                            }
                        }
                        //entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));
                    }
                    if (!(this.getAttackState() == 9) || !(this.getAttackState() == 15)) {
                        // this.launchMini(entityHit, true);

                        if (Math.random() > 0.5f) {
                            if (!entityHit.isBlocking()) {
                                MobEffectInstance brokenArmorEffect = entityHit.getEffect(ModEffects.BROKEN_ARMOR.get());
                                if (brokenArmorEffect != null) {
                                    int currentLevel = brokenArmorEffect.getAmplifier();
                                    if (currentLevel < 6) {
                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, currentLevel + 1));
                                    } else {

                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 6));
                                    }
                                } else {
                                    entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 0));
                                    // }
                                }

                            }
                        }
                    }
                    if (this.getAttackState() == 9 || this.getAttackState() == 15) {
                        // this.launchMini(entityHit, true);
                        if ((this.attackTicks == 60) && this.getAttackState() == 9) {
                            if (!entityHit.isBlocking()) {
                                MobEffectInstance brokenArmorEffect = entityHit.getEffect(ModEffects.BROKEN_ARMOR.get());
                                if (brokenArmorEffect != null) {
                                    int currentLevel = brokenArmorEffect.getAmplifier();
                                    if (currentLevel < 6) {
                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, currentLevel + 3));
                                    } else {

                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 6));
                                    }
                                } else {
                                    entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 0));
                                    // }
                                }

                            }
                        }

                        if (this.getAttackState() == 15) {
                            if (!entityHit.isBlocking()) {
                                MobEffectInstance brokenArmorEffect = entityHit.getEffect(ModEffects.BROKEN_ARMOR.get());
                                if (brokenArmorEffect != null) {
                                    int currentLevel = brokenArmorEffect.getAmplifier();
                                    if (currentLevel < 6) {
                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, currentLevel + 3));
                                    } else {

                                        entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 6));
                                    }
                                } else {
                                    entityHit.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 0));
                                    // }
                                }

                            }
                        }
                    }
                    //entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));

                    //entityHit.knockback(knockback,1,1);
                    if (launch) {
                        launch(entityHit, true);
                    }
                    if (!entityHit.isBlocking()) {
                        // entityHit.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2), this);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    private void dash(float a1, float a2, float minD) {
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if (this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
        }
    }

    public void updateWithAttack() {

        if (this.getAttackState() == 15) {
            if (this.attackTicks == 30) {
                Sphereparticle(0.75f, 2.0f, 6);
                this.playSound(SoundEvents.TOTEM_USE, 2, 0.75f);

                spawnCircleParticle(1.5f, 0f, 15, true, 1.5f, 1f, 1f, 1f, 1);
                this.setAttacking(true);

                //   EarthQuakeSummon(0f, 15, 1.5f);
                this.entityData.set(TEXTURE_VARIANT, 1);
                tr = true;

                int standingOnY = Mth.floor(this.getY());
                //  this.spawnIceSpikesAdvanced(this.getX() , this.getZ(), standingOnY, this.getY(), 0,0);
                attackLock = 0;
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.05));
                    EarthQuakeSummon(0f, 15, 1.5f);
                    this.AreaAttack(6.5F, 5F, 360F, 20.0F + a, 100, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6.5F, 5F, 360F, 20.0F, 100, false, 0.5F, false, 0.25F, true);
                }
            }
            if (this.attackTicks == 40) {

                this.entityData.set(TEXTURE_VARIANT, 0);
            }


        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 10) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 12) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }

            if (this.attackTicks == 14) {


                this.AreaAttack(5.5f, 5F, 180F, 13.0F, 0, false, 0.5F, true, 0.25F, false);

            }
        }
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 10) {
                // dash(0.6f,0.3f,4);
            }
            if (this.attackTicks == 12) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 14) {


                this.AreaAttack(5.5F, 5F, 180F, 14.0F, 40, false, 0.5F, true, 0.25F, false);

            }
        }

        if (this.getAttackState() == 6) {
            if (this.attackTicks == 10) {
                // dash(0.6f,0.3f,4);
            }
            if (this.attackTicks == 12) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 14) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 21) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 26) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 32) {


                this.AreaAttack(5.5F, 5F, 180F, 12.0F, 20, false, 0.5F, true, 0.25F, false);

            }
        }

        if (this.getAttackState() == 5) {
            if (this.attackTicks == 4) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 8) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 11) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 18) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 23) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 25) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 40, false, 0.5F, true, 0.25F, false);

            }
        }


        if (this.getAttackState() == 21) {
            if (this.attackTicks == 10) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 12) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 16) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 0, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 27) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 28) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 31) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 39) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 41) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 44) {


                this.AreaAttack(5.5F, 5F, 360F, 14.0F, 20, false, 0.5F, true, 0.25F, false);

            }
        }

        if (this.getAttackState() == 22) {
            if (this.attackTicks == 15) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 17) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 19) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 0, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 30) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 32) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 34) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 49) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 50) {

                this.playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);
            }
            if (this.attackTicks == 53) {


                this.AreaAttack(5.5F, 5F, 360F, 14.0F, 20, false, 0.5F, true, 0.25F, false);

            }
        }

        if (this.getAttackState() == 19) {
            if (this.attackTicks == 4) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 8) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 11) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 0, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 18) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 23) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 25) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 39) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 43) {

                this.playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);
            }
            if (this.attackTicks == 47) {


                this.AreaAttack(5.5F, 5F, 360F, 14.0F, 20, false, 0.5F, true, 0.25F, false);

            }
        }

        if (this.getAttackState() == 20) {
            if (this.attackTicks == 4) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 8) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 11) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 0, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 18) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 23) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 25) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 20, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 39) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 43) {

                this.playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);
            }
            if (this.attackTicks == 47) {


                this.AreaAttack(5.5F, 5F, 360F, 14.0F, 40, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 73) {
                this.playSound(SoundEvents.TOTEM_USE, 2, 0.7f);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.02));
                    EarthQuakeSummon(0f, 15, 1.5f);
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F + a, 40, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F, 40, false, 0.5F, false, 0.25F, true);
                }
            }
        }


        if (this.getAttackState() == 9) {
            if (this.attackTicks == 8) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 13) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 14) {


                this.AreaAttack(5.5F, 5F, 180F, 12.0F, 40, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 23) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 25) {

                this.playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);
            }
            if (this.attackTicks == 30) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 40, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 35) {

                LivingEntity target = this.getTarget();

                if (target != null) {
                    double distanceToTarget =
                            this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                    if (distanceToTarget > 9 && this.h()) {
                        this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                        Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                        this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 0.9D, 1.0D, vec3.z * 0.9D));
                    }
                } else {
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.0D, 0.0F));

                }

                //     this.playSound(ModSounds.PP_SWING.get(),1,1);
            }
            if (this.attackTicks == 60) {
                this.playSound(SoundEvents.TOTEM_USE, 2, 0.7f);

                spawnCircleParticle(1.5f, 0f, 15, true, 1.5f, 1f, 1f, 1f, 1);
                int standingOnY = Mth.floor(this.getY());
                this.spawnIceSpikesAdvanced(this.getX(), this.getZ(), standingOnY, this.getY(), 0, 0);

                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.02));
                    EarthQuakeSummon(0f, 15, 1.5f);
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F + a, 40, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F, 40, false, 0.5F, false, 0.25F, true);
                }
            }
            if (this.attackTicks == 64) {

            }
        }
        if (this.getAttackState() == 18) {
            if (this.attackTicks == 5) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 8) {

                this.playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
            }
            if (this.attackTicks == 10) {


                this.AreaAttack(5.5F, 5F, 180F, 12.0F, 40, false, 0.5F, true, 0.25F, false);

            }
            if (this.attackTicks == 19) {
                dash(0.9f, 0.6f, 4);
            }
            if (this.attackTicks == 22
            ) {

                this.playSound(ModSounds.WEAPON_SPIN.get(), 1, 1);
            }
            if (this.attackTicks == 25) {


                this.AreaAttack(5.5F, 5F, 180F, 13.0F, 40, false, 0.5F, true, 0.25F, false);

            }

            if (this.attackTicks == 20) {

                //     this.playSound(ModSounds.PP_SWING.get(),1,1);
            }
            if (this.attackTicks == 57) {
                this.playSound(SoundEvents.TOTEM_USE, 2, 0.7f);

                spawnCircleParticle(1.5f, 0f, 15, true, 1.5f, 1f, 1f, 1f, 1);
                int standingOnY = Mth.floor(this.getY());
                this.spawnIceSpikesAdvanced(this.getX(), this.getZ(), standingOnY, this.getY(), 0, 0);
                if (h()) {
                    //   StrikeFire(10,0.5);
                    // EarthQuakeSummon(0f, 15, 1.5f);
                }
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.02));
                    //  EarthQuakeSummon(0f, 15, 1.5f);
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F + a, 40, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6.5F, 5F, 360F, 17.0F, 40, false, 0.5F, false, 0.25F, true);
                }
            }

            if (this.attackTicks == 64) {

            }
        }

    }

    private void spawnIceSpikesAdvanced(double x, double z, double minY, double maxY, float rotation, int delay) {

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
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            Entity entity1 = this;
            this.level().addFreshEntity(new ShockwaveSpawner(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, false));
        }
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private void EarthQuakeSummon(float vec, int quake, float math) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = 360.0F / quake;
        for (int i = 0; i < quake; i++) {
            SoulStrike peq = new SoulStrike(this.level(), this, false);
            peq.setDamage((float) 9);
            peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.45F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * math, this.getY() + 0.3D, getZ() + vec * vecZ + f1 * math);
            this.level().addFreshEntity(peq);

        }
    }

}



