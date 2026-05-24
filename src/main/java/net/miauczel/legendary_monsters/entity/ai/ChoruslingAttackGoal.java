package net.miauczel.legendary_monsters.entity.ai;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.ChoruslingEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;

public class ChoruslingAttackGoal extends MeleeAttackGoal {

    private final ChoruslingEntity entity;
    private int attackDelay = 16;
    private int ticksUntilNextAttack = 16;
    private boolean shouldCountTillNextAttack = false;
    private boolean hasPlayedAttackSound = false;

    public ChoruslingAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((ChoruslingEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 9;
        ticksUntilNextAttack = 9;
        hasPlayedAttackSound = false;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation() && !hasPlayedAttackSound) {
                SoundEvent customAttackSound = ModSounds.CHORUSLING_ATTACK.get();
                this.mob.level().playSound(null, this.mob.blockPosition(), customAttackSound, SoundSource.NEUTRAL, 1.0f, 1.0f);
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
        return pDistToEnemySqr <= 3.5 * 3.5;
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

        if (!this.mob.getTarget().isBlocking()) {
            this.mob.getTarget().addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 60, 0));
        }

        if (pEnemy instanceof Player player) {

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
