package net.miauczel.legendary_monsters.entity.AnimatedMonster.ai;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class ITwoHitAttackGoal extends Goal {
    protected final IAnimatedMonster entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;

    private final int attackseetickattack3;
    private final int attackseetickattack2;
    private final float attackrange;

    public ITwoHitAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick,int attackseetick2,int attackseetick3 ,float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
        attackseetickattack2 = attackseetick2;

        attackseetickattack3 = attackseetick3;

    }

    public ITwoHitAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackseetick2, int attackseetick3,EnumSet<Flag> interruptFlagTypes) {
        this.entity = entity;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;


        attackseetickattack3 = attackseetick3;
        attackseetickattack2 = attackseetick2;
        this.attackrange = attackrange;
    }

    public boolean canUse() {
        LivingEntity target = this.entity.getTarget();
        return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate
                && entity.getAttackDelayTicks() <=0;
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
        if (target != null &&
                ((entity.attackTicks < attackseetick) || (entity.attackTicks > attackseetickattack2 && entity.attackTicks < attackseetickattack3))) {
            entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            entity.lookAt(target, 30.0F, 30.0F);
        } else {
            entity.setYRot(entity.yRotO);
        }


    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}
