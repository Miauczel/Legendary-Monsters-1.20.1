package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class GhostUppercutGoal extends Goal {
    protected final BeheadedKnightEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public GhostUppercutGoal(BeheadedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public GhostUppercutGoal(BeheadedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
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
        LivingEntity target = this.entity.getTarget();
        return target != null && target.isAlive()
                && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && entity.getAttackDelayTicks() <=0;
    }

    public void start() {
        this.entity.setAttackState(this.attackstate);
    }

    public void stop() {

        this.entity.setAttackState(this.attackendstate);
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.entity.attackTicks < this.attackMaxtick;
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (entity.attackTicks <19 || (entity.attackTicks >= 35 && entity.attackTicks < 45)){
      //  if (this.entity.attackTicks < 19 || (entity.attackTicks >= 40 && entity.attackTicks < attackseetick) ) {
            if (target !=null) entity.getLookControl().setLookAt(entity.target(), 30.0F, 30.0F);
            if (target !=null)  this.entity.lookAt(entity.target(), 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }

    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}

