package net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class ILookingTamableMobStateGoal extends Goal{
    protected final IAnimatedTamableMob entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public ILookingTamableMobStateGoal(IAnimatedTamableMob entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;

        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public ILookingTamableMobStateGoal(IAnimatedTamableMob entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) {

            this.setFlags(EnumSet.of( Flag.MOVE));
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
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
