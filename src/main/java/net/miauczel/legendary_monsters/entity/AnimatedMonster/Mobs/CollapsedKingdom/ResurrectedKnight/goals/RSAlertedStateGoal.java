package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.ResurrectedKnightEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class RSAlertedStateGoal extends Goal {
    protected final ResurrectedKnightEntity entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    private final boolean canAllertedState;
    private final double allertedStateChance;

    public RSAlertedStateGoal(ResurrectedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance) {
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

    public RSAlertedStateGoal(ResurrectedKnightEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean canAllertedState, double allertedStateChance, boolean interruptsAI) {
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
        if (entity.getRandom().nextInt() * 100 < 50)
            velocity *= -1;
        if (this.getattackstate != this.attackstate) {
            this.entity.setAttackState(this.attackstate);
        }

    }

    public boolean canBeAlerted() {
        return entity.getRandom().nextInt() * 100 < allertedStateChance && canAllertedState;
    }

    public void stop() {
        this.entity.setAttackState(attackendstate);
        entity.attackTicks = 0;
        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.attackfinaltick > 0 ? this.entity.attackTicks <= this.attackfinaltick + entity.getRandom().nextInt(-7, 10) : this.canUse();
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        if (target != null) {
            //if (entity.attackTicks == attackfinaltick *0.5f)  velocity *=-1;

            float n = 180;
            float p = (float) Math.toDegrees(n * (n - 3)) / 2;

            float r = 8;
            double angle = Math.toRadians(-entity.yBodyRot + 90);
            double sin = Mth.sin((float) angle) * r;
            double cos = Mth.cos((float) angle) * r;

            //entity.getNavigation().moveTo(target.getX() + sin, entity.getY(), target.getZ() + cos, 4);

            Vec3 pos = new Vec3(target.getX() + sin, entity.getY(), target.getZ() + cos);
            Vec3 posSub = pos.subtract(entity.position());

            float flippedV = velocity;
            Vec3 finalPos = posSub.normalize().scale(flippedV);
            entity.setDeltaMovement(finalPos);
        }
    }

    public float velocity = 0.15f;

    public float flipValue(float f, int chance) {
        return entity.getRandom().nextInt() * 100 < chance ? f * -1 : f;

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
