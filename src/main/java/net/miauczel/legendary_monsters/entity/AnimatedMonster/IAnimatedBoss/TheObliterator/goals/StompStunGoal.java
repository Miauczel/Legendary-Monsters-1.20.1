package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class StompStunGoal extends Goal{
    protected final TheObliteratorEntity entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public StompStunGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public StompStunGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
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
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        int attackTicks = entity.getAttackTicks();
        if (attackTicks == 15) {
            if (entity.targetIsNotNull()) {
                float f = Mth.cos(entity.target().yHeadRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(entity.target().yHeadRot * ((float) Math.PI / 180F));
                double theta = (entity.target().yHeadRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                switch (entity.getRandom().nextInt(2)) {
                    case 0 -> {
                        float vec = 1;
                        float offset = 4;
                        entity.teleport((entity.target().getX() + vec * vecX + f * offset), entity.target().getY(), (entity.target().getZ() + vec * vecZ + f1 * offset));
                    }
                    case 1 -> {
                        float vec = 1;
                        float offset = -4;
                        entity.teleport((entity.target().getX() + vec * vecX + f * offset), entity.target().getY(), (entity.target().getZ() + vec * vecZ + f1 * offset));
                    }
                    /*case 2 ->{
                        float vec = -3;
                        float offset = 0;
                        teleport((target().getX() + vec * vecX + f * offset),target().getY(),(target().getZ() + vec * vecZ + f1 * offset));
                    }*/
                }

                // teleportRandomly(target(),5,10);

            }
        }
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
