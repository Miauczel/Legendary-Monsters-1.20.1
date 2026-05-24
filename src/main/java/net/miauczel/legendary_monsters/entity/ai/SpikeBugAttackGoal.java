package net.miauczel.legendary_monsters.entity.ai;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.SpikebugEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SpikeBugAttackGoal extends MeleeAttackGoal {

    private final SpikebugEntity entity;
    private int attackDelay = 8;
    private int ticksUntilNextAttack = 8;
    private boolean shouldCountTillNextAttack = false;
    private boolean hasPlayedAttackSound = false;
    public SpikeBugAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((SpikebugEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 8;
        ticksUntilNextAttack = 8;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation() && !hasPlayedAttackSound) {


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
        return pDistToEnemySqr <= 3.5 * 2.5;
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
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
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