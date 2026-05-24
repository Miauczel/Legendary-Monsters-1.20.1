package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.ResurrectedKnightEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class BHGrabAndThrowGoal extends Goal {
    protected final BeheadedKnightEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public BHGrabAndThrowGoal(BeheadedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public BHGrabAndThrowGoal(BeheadedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
        this.entity = entity;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public boolean canUse() {
        ResurrectedKnightEntity target = entity.synchronisedDuoKnight();
        return target != null && target.isAlive()
                && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && entity.getAttackDelayTicks() <=0;
    }

    public void start() {
        this.entity.setAttackState(this.attackstate);
    }

    public void stop() {
            this.entity.setAttackState(entity.grab ? 12 : 13);
            this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.entity.attackTicks < this.attackMaxtick;
    }

    public void tick() {
        ResurrectedKnightEntity target = entity.synchronisedDuoKnight();
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

