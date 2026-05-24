package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling;

import net.miauczel.legendary_monsters.config.ModConfig;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.ai.ChoruslingAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;
public class ChoruslingEntity extends AbstractChorusling {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(ChoruslingEntity.class, EntityDataSerializers.BOOLEAN);

    public ChoruslingEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();
        if (DeathAnimationState.isStarted()) {
            DeathAnimationTimeout--;
            if (DeathAnimationTimeout <= 0) {
                DeathAnimationState.stop();
            }
        }
       // updateAttributes();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {

            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }
    private void setupAnimationStates() {
        if(DeathAnimationTimeout >= 60) {
            if (this.dragonDeathTime > 0 && !DeathAnimationState.isStarted()) {
                DeathAnimationState.start(this.tickCount);
                --this.DeathAnimationTimeout;
                stopAllOtherAnimations();

            }
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }

            if (this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationTimeout = (int) 17.5;
                attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }

            if (!this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationState.stop();
            }
        }
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
        this.entityData.define(ATTACKING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ChoruslingAttackGoal(this, 3D, true));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, entity -> entity instanceof Player));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractFlameborn.class, true));
    }
    public boolean doHurtTarget(Entity pEntity) {
        float f = (float) ((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * ModConfig.MOB_CONFIG.ChoruslingDamageMultiplier.get());
        float f1 = (float)this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (pEntity instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity)pEntity).getMobType());
            f1 += (float)EnchantmentHelper.getKnockbackBonus(this);
        }

        int i = EnchantmentHelper.getFireAspect(this);
        if (i > 0) {
            pEntity.setSecondsOnFire(i * 4);
        }

        boolean flag = pEntity.hurt(this.damageSources().mobAttack(this), f);
        if (flag) {
            if (f1 > 0.0F && pEntity instanceof LivingEntity) {
                ((LivingEntity)pEntity).knockback((double)(f1 * 0.5F), (double) Mth.sin(this.getYRot() * ((float)Math.PI / 180F)), (double)(-Mth.cos(this.getYRot() * ((float)Math.PI / 180F))));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
            }

            if (pEntity instanceof Player) {
                Player player = (Player)pEntity;
                this.maybeDisableShield(player, this.getMainHandItem(), player.isUsingItem() ? player.getUseItem() : ItemStack.EMPTY);
            }

            this.doEnchantDamageEffects(this, pEntity);
            this.setLastHurtMob(pEntity);
        }

        return flag;
    }
    private void maybeDisableShield(Player pPlayer, ItemStack pMobItemStack, ItemStack pPlayerItemStack) {
        if (!pMobItemStack.isEmpty() && !pPlayerItemStack.isEmpty() && pMobItemStack.getItem() instanceof AxeItem && pPlayerItemStack.is(Items.SHIELD)) {
            float f = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
            if (this.random.nextFloat() < f) {
                pPlayer.getCooldowns().addCooldown(Items.SHIELD, 100);
                this.level().broadcastEntityEvent(pPlayer, (byte)30);
            }
        }

    }
    @Override
    public void aiStep() {
        super.aiStep();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 70D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5F)
                .add(Attributes.FOLLOW_RANGE, 14D)
                .add(Attributes.ARMOR, 6D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 5D);
    }

    public void attackTargets(Entity entity1){
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 5D * ModConfig.MOB_CONFIG.ChoruslingDamageMultiplier.get();


        //deal damage
        if(entity1 instanceof LivingEntity livingEntity ) {

            if(this.level().getDifficulty() == Difficulty.HARD) {
                livingEntity.hurt(damageSource, (float) (damage));

            } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                livingEntity.hurt(damageSource, (float) damage);

            } else if (this.level().getDifficulty() == Difficulty.EASY) {
                livingEntity.hurt(damageSource, (float) (damage + 3));

            }
        }
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
           // updateAttributes();
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.ChoruslingHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.ChoruslingDamageMultiplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 40D; // podstawowe zdrowie moba
        double baseAttackDamage = 5D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }
*/
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CHORUSLING_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CHORUSLING_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CHORUSLING_DEATH.get();
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
        dragonDeathTime = 0;
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.ChoruslingHealthMultiplier.get());
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE)) return false;
        if (source.getDirectEntity() instanceof AbstractArrow) return false;
        if (source.is(DamageTypes.FALL)) return false;
        if (source.is(DamageTypes.TRIDENT)) return false;

        return super.hurt(source, amount);
    }
    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;
    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;

        boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);


        if (this.level() instanceof ServerLevel) {


            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);

            }
        }

        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
    private void stopAllOtherAnimations() {
        attackAnimationState.stop();
    }
}