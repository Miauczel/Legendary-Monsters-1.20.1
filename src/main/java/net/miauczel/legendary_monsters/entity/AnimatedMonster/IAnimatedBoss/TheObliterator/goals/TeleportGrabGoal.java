package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;

public class TeleportGrabGoal extends IAttackGoal {
    protected final TheObliteratorEntity entity;

    public TeleportGrabGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
      //  System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());
    }

    @Override
    public void tick() {

        int attackTicks = entity.getAttackTicks();

        super.tick();
    }

    @Override

    public void stop() {
       // System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());

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
