package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.goal;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class DoubleSlashSlamAttackGoal extends Goal {
    protected final PossessedPaladinEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;
    private final boolean canAllertedState;
    private final double allertedStateChance;

    public DoubleSlashSlamAttackGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, boolean canAllertedState, double allertedStateChance) {
        this.entity = entity;
        this.canAllertedState = canAllertedState;
        this.allertedStateChance = allertedStateChance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public DoubleSlashSlamAttackGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes, boolean canAllertedState, double allertedStateChance) {
        this.entity = entity;
        this.canAllertedState = canAllertedState;
        this.allertedStateChance = allertedStateChance;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public boolean canUse() {
        LivingEntity target = this.entity.getTarget();
        return target != null && target.isAlive()
                && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && entity.getAttackDelayTicks() <= 0;
    }

    public void start() {
        entity.shouldAttackMore = false;
        this.entity.setAttackState(this.attackstate);
    }

    public boolean canBeAlerted() {
        return entity.getRandom().nextInt() * 100 < allertedStateChance && canAllertedState;
    }

    public void stop() {
        entity.randomizeAttacks();
        this.entity.setAttackState((entity.targetIsNotNull() && entity.getPhase() >= 2 && entity.distanceTo(entity.target()) >= 6 || (entity.shouldAttackMore && entity.getPhase() >= 2) ? 8 : 7));
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.entity.attackTicks < this.attackMaxtick;
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }

    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}
