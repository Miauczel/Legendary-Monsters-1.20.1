package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class BHSynergyStateGoal extends Goal {
    protected final IAnimatedMonster entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public BHSynergyStateGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public BHSynergyStateGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
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

    public void stop() {
        this.entity.setAttackState(this.attackendstate);
        this.entity.attackTicks = 0;
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.attackfinaltick > 0 ? this.entity.attackTicks <= this.attackfinaltick : this.canUse();
    }

    public void tick() {

        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < 30 || (entity.attackTicks > 60 && entity.attackTicks < 72) || (entity.attackTicks > 100 && entity.attackTicks < 135)) {
            if (target != null) {
                this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            }
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
