package net.miauczel.legendary_monsters.entity.ai.goal;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class BigCannonShootGoal extends Goal {
    private final DuneSentinelEntity entity;
    private LivingEntity target;
    private int attackCooldown;
    private int animationCooldown;

    public BigCannonShootGoal(DuneSentinelEntity entity) {
        this.entity = entity;
        this.attackCooldown = 0;
        this.animationCooldown = 0;
    }

    @Override
    public boolean canUse() {
        this.target = this.entity.getTarget();
        return this.target != null && this.target.isAlive() && !entity.isAttacking();
    }

    @Override
    public void start() {
        this.entity.setShooting(true);
        this.attackCooldown = 0;
        this.animationCooldown = 0;
    }

    @Override
    public void stop() {
        this.entity.setShooting(false);
        this.attackCooldown = 0;
        this.animationCooldown = 0;
    }

    @Override
    public void tick() {
        if (this.target == null || !this.target.isAlive()) {
            return;
        }

        double distanceToTarget = this.entity.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());

        if (distanceToTarget < 900) {
            if (this.attackCooldown <= 0 && this.animationCooldown >= 2 && this.entity.canShoot()) {
                this.entity.performRangedAttack(this.target, 1.0f);

                this.attackCooldown = (int)17.5;
                this.animationCooldown = 0;
            } else {
                this.attackCooldown--;
                if (this.entity.isShooting()) {
                    this.animationCooldown++;
                }
            }
        }

        this.entity.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
    }
}