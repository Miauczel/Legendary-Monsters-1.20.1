package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;

public class FireworkGrabGoal extends IAttackGoal {
    protected final Shulker_MimicEntity entity;

    public FireworkGrabGoal(Shulker_MimicEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
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
                entity.setAttackState(16);
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
