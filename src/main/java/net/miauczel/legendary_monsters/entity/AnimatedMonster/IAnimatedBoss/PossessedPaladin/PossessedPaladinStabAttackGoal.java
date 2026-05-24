package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class PossessedPaladinStabAttackGoal extends Goal {
    protected final NewPossessedPaladin entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public PossessedPaladinStabAttackGoal(NewPossessedPaladin entity, int getattackstate, int attackstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public PossessedPaladinStabAttackGoal(NewPossessedPaladin entity, int getattackstate, int attackstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
        this.entity = entity;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
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
        if (entity.succedGrabbing){
            entity.setAttackState(18);
        }else {
            entity.setAttackState(17);
        }
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

