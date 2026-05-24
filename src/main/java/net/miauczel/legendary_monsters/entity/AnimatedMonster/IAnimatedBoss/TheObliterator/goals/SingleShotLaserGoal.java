package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SingleShotLaserGoal extends Goal {
    protected final TheObliteratorEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public SingleShotLaserGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public SingleShotLaserGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
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
        return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate
                && entity.getAttackDelayTicks() <=0;
    }

    public void start() {
        this.entity.setAttackState(this.attackstate);
    }

    public void stop() {

        switch (entity.getRandom().nextInt(entity.getPhase() >=2 ? 2 : 1)){
          case 0 ->  this.entity.setAttackState(entity.getRandom().nextInt() * 100 < 50 ? 45: 44);
            case 1 ->  this.entity.setAttackState(entity.quad_beam_cooldown <=0 ? 46 : entity.getRandom().nextInt() * 100 < 50 ? 45: 44);

        }


        this.entity.attackCooldown = 0;
    }

    public boolean canContinueToUse() {
        return this.entity.attackTicks < this.attackMaxtick;
    }

    public void tick() {
        int attackTicks = entity.getAttackTicks();
        LivingEntity target = this.entity.getTarget();
        if ((this.entity.attackTicks < this.attackseetick || entity.isTargetCheesing(-4,4)) && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 180.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        if (attackTicks == 6){
                float f = Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F));
                double theta = (entity.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = -8;
                float offset = 0;
                entity.teleport((entity.getX() + vec * vecX + f * offset), entity.getY(), (entity.getZ() + vec * vecZ + f1 * offset));


        }
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}

