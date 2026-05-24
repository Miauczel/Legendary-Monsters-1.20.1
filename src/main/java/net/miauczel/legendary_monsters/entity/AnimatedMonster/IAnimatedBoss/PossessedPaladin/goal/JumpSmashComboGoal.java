package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.goal;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class JumpSmashComboGoal extends Goal {
    protected final PossessedPaladinEntity entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    private final boolean canAllertedState;
    private final double allertedStateChance;

    public JumpSmashComboGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance) {
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

    public JumpSmashComboGoal(PossessedPaladinEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance, boolean interruptsAI) {
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
        this.entity.setAttackState(canBeAlerted() ? 9 : attackendstate);
        entity.attackTicks = 0;
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.attackfinaltick > 0 ? this.entity.attackTicks <= this.attackfinaltick : this.canUse();
    }

    public void tick() {

        if (this.entity.attackTicks >= 25 && entity.attackTicks < 28 && entity.targetIsNotNull()) {
            entity.getLookControl().setLookAt(entity.target(), 30.0F, 30.0F);
            entity.lookAt(entity.target(), 30, 30);
            // this.entity.getLookControl().setLookAt(entity.lastTargetPos().x, entity.lastTargetPos().y, entity.lastTargetPos().z, 30.0F, 30.0F);
            //     entity.lookAt(EntityAnchorArgument.Anchor.EYES, entity.lastTargetPos());
        }  else if (entity.attackTicks >= 40 && entity.attackTicks <= 65 && entity.targetIsNotNull()) {
              entity.getLookControl().setLookAt(entity.target(), 30.0F, 30.0F);
              entity.lookAt(entity.target(), 30, 30);
            // this.entity.getLookControl().setLookAt(entity.lastTargetPos().x, entity.lastTargetPos().y, entity.lastTargetPos().z, 30.0F, 30.0F);
            //     entity.lookAt(EntityAnchorArgument.Anchor.EYES, entity.lastTargetPos());
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
