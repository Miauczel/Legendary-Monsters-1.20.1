package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class JumpTeleportGoal extends Goal {
    protected final TheObliteratorEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;

    private final int attackseetickattack3;
    private final int attackseetickattack2;
    private final float attackrange;

    public JumpTeleportGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackseetick3 , float attackrange) {
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

    public JumpTeleportGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackseetick2, int attackseetick3, EnumSet<Flag> interruptFlagTypes) {
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
        int attackTicks = entity.getAttackTicks();

        if (attackTicks == 20) {
            if (target != null) {
                entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                entity.setDeltaMovement((target.getX() - entity.getX()) * 0.15D, 1.3D, (target.getZ() -entity.getZ()) * 0.15D);
            } else {
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0F, 1.3D, 0.0F));
            }
        }

        if (attackTicks == 48){
            entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
        if (attackTicks == 49) {
            if (target !=null) {
                float targetFloor = Mth.floor(target.getY());
                float y = targetFloor;
                //entity.teleport(entity.getX(), y, entity.getZ());
            }
        }

        if (attackTicks == 81){
            entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
            if (attackTicks == 82) {

                if (target != null) {
                    float f = Mth.cos(target.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -4f;
                    float offset = 0;


                    float targetFloor = Mth.floor(target.getY());
                    float y = targetFloor;
                    entity.teleport(target.getX() + vec * vecX + f * offset, y, target.getZ() + vec * vecZ + f1 * offset);
                }
            }
            /*
        if (attackTicks == 82) {

            if (target !=null) {
                float f = Mth.cos(target.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(target.yBodyRot * ((float) Math.PI / 180F));
                double theta = (target.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;

                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = -4f;
                float offset = 0;


                float targetFloor = Mth.floor(target.getY());
                float y = targetFloor;
                entity.teleport(target.getX() + vec * vecX + f * offset, y, target.getZ() + vec * vecZ + f1 * offset);
            }
        }
*/
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}