package net.miauczel.legendary_monsters.entity.ai;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Warped_FungussusEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Warped_FungussusAttackGoal extends MeleeAttackGoal {

    private final Warped_FungussusEntity entity;
    private int attackDelay = 15;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountTillNextAttack = false;

    public Warped_FungussusAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((Warped_FungussusEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 15;
        ticksUntilNextAttack = 15;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);

            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 5;

        }

    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= 3 * 6.0;
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
        if (entity.getRandom().nextFloat() < 0.5f) {
            teleportRandomly();
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

    private void teleportRandomly() {
        Vec3 entityPos = this.mob.position();
        double x, y, z;
        Level level = this.mob.level();

        for (int i = 0; i < 10; i++) {
            x = entityPos.x() + (this.mob.getRandom().nextDouble() - 0.5) * 10.0;
            z = entityPos.z() + (this.mob.getRandom().nextDouble() - 0.5) * 10.0;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1,  iz)).isAir()) {
                this.mob.teleportTo(x, y, z);
                return;
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

    }
}