package net.miauczel.legendary_monsters.entity.ai.goal;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.BomberEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class BomberSwellGoal extends Goal {
    private final BomberEntity bomber;
    @Nullable
    private LivingEntity target;

    public BomberSwellGoal(BomberEntity pBomber) {
        this.bomber = pBomber;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        LivingEntity livingentity = this.bomber.getTarget();
        return this.bomber.getSwellDir() > 0 || livingentity != null && this.bomber.distanceToSqr(livingentity) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.bomber.getNavigation().stop();
        this.target = this.bomber.getTarget();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        if (this.target == null) {
            this.bomber.setSwellDir(-1);
        } else if (this.bomber.distanceToSqr(this.target) > 49.0D) {
            this.bomber.setSwellDir(-1);
        } else if (!this.bomber.getSensing().hasLineOfSight(this.target)) {
            this.bomber.setSwellDir(-1);
        } else {
            this.bomber.setSwellDir(1);
        }
    }
}

