package net.miauczel.legendary_monsters.entity.ai;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Old.OldShulkerMimic;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;

public class Shulker_MimicAttackGoal extends MeleeAttackGoal {

    private final OldShulkerMimic entity;
    private int attackDelay = 12;
    private int ticksUntilNextAttack = 12;
    private boolean shouldCountTillNextAttack = false;
    private boolean hasPlayedAttackSound = false;
    public Shulker_MimicAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((OldShulkerMimic) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 12;
        ticksUntilNextAttack = 12;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation() && !hasPlayedAttackSound) {
                this.mob.level().playSound(null, this.mob.blockPosition(), SoundEvents.EVOKER_FANGS_ATTACK, SoundSource.NEUTRAL, 1.0f, 1.0f);
                entity.setAttacking(true);
                hasPlayedAttackSound = true;


            }


            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                hasPlayedAttackSound = false;
                performAttack(pEnemy);

            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 5;
            hasPlayedAttackSound = false;
        }

    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= 4 * 6.0;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        if(pEnemy instanceof Player || pEnemy instanceof ServerPlayer) {
            entity.attackTargets(pEnemy);
        } else{
            this.mob.doHurtTarget(pEnemy);
        }
        entity.performAreaAttack();
        if (this.mob.getTarget() != null) {
            // Set the target on fire for 5 seconds (adjust the duration as needed)
            if (!this.mob.getTarget().isBlocking()) {
                if (entity.getRandom().nextFloat() < 0.75f) {
                    if(entity.getCrackiness() == Shulker_MimicEntity.Crackiness.MEDIUM) {
                        this.mob.getTarget().addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 60, 4));
                        this.mob.getTarget().addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 3));
                    }else {
                        this.mob.getTarget().addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 2));
                    }
                    if(entity.getCrackiness() == Shulker_MimicEntity.Crackiness.HIGH) {
                        this.mob.getTarget().addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 60, 5));
                        this.mob.getTarget().addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 10));
                    }else {
                        this.mob.getTarget().addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 2));
                    }

                }
            }
        }
        if (pEnemy instanceof Player) {
            Player player = (Player) pEnemy;

            if (player.isBlocking() && (player.getMainHandItem().getItem() instanceof ShieldItem || player.getOffhandItem().getItem() instanceof ShieldItem)) {
                Item shieldItem = player.getMainHandItem().getItem() instanceof ShieldItem ?
                        player.getMainHandItem().getItem() :
                        player.getOffhandItem().getItem();

                if (!player.getCooldowns().isOnCooldown(shieldItem)) {
                    player.getCooldowns().addCooldown(shieldItem, 40);

                    if (player.isBlocking()) {
                        player.stopUsingItem();
                    }
                }
            }

        }
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
        hasPlayedAttackSound = false;

    }
}