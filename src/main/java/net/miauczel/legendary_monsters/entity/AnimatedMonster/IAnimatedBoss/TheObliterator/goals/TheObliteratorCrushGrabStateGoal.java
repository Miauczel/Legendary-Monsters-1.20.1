package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;

public class TheObliteratorCrushGrabStateGoal extends IStateGoal {
    protected final TheObliteratorEntity entity;

    public TheObliteratorCrushGrabStateGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
       // System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());
    }

    @Override

    public void stop() {
      //  System.out.println("succedGrabbing = " + entity.succedGrabbing + ", startRiding ok = " + entity.getPassengers());

        if (entity.succedGrabbing) {
            if (!entity.level().isClientSide) {
                entity.setAttackState(entity.getAttackState() == 37 ? 40 : 50);
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
