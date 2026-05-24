package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.minecraft.util.Mth;

public class CloseTeleportGrabGoal extends IAttackGoalMin {
    protected final TheObliteratorEntity entity;

    public CloseTeleportGrabGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float attackrangemin) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange,attackrangemin);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
     //   System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());
    }

    @Override
    public void tick() {

        int attackTicks = entity.getAttackTicks();
        if (entity.succedGrabbing){
            if (attackTicks >= 36 && attackTicks<=39) {
                entity.setInvisible(true);
                if (entity.targetIsNotNull()) {
                    float f  = Mth.cos(entity.target().yBodyRot * ((float)Math.PI / 180F));
                    float f1 = Mth.sin(entity.target().yBodyRot * ((float)Math.PI / 180F));
                    double theta = (entity.target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec   = +2;
                    float offset = 0;

                    entity.teleportTo(
                            entity.target().getX() + vec * vecX + f  * offset,
                            entity.target().getY() +1,
                            entity.target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }}
        super.tick();
    }

    @Override

    public void stop() {
      //  System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());

        if (entity.succedGrabbing) {
            if (!entity.level().isClientSide) {
                entity.setAttackState(18);
            }
            entity.succedGrabbing = false;
        } else {
            super.stop();
        }
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}