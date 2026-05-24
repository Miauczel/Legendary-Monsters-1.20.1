package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.goal;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class StabGrabGoal extends Goal {
    protected final PossessedPaladinEntity entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    private final boolean canAllertedState;
    private final double allertedStateChance;

    public StabGrabGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance) {
        this.entity = entity;
        this.canAllertedState = canAllertedState;
        this.allertedStateChance = allertedStateChance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public StabGrabGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance, boolean interruptsAI) {
        this.entity = entity;
        this.canAllertedState = canAllertedState;
        this.allertedStateChance = allertedStateChance;
        if (interruptsAI) {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public boolean canUse() {
        return this.entity.getAttackState() == this.getattackstate;
    }

    public void start() {
        if (this.getattackstate != this.attackstate) {
            this.entity.setAttackState(this.attackstate);
        }

    }

    public boolean canBeAlerted() {
        return entity.getRandom().nextInt() * 100 < allertedStateChance && canAllertedState;
    }

    public void stop() {
        this.entity.setAttackState(entity.succedGrabbing ? 20 : entity.getPhase() >= 2 ? 33 : 21);
        entity.attackTicks = 0;
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.attackfinaltick > 0 ? this.entity.attackTicks <= this.attackfinaltick : this.canUse();
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
        return true;
    }
}
