package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;

public class SingleSlashFromGoal extends IAttackGoal {
    protected final AnnihilationPursuerEntity entity;

    public SingleSlashFromGoal(AnnihilationPursuerEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void tick() {


        super.tick();
    }

    @Override

    public void stop() {
        if (entity.hasHit && entity.shield_stun_cooldown <=0) {
            if (!entity.level().isClientSide) {
                entity.setAttackState(9);
            }
            entity.hasHit = false;
        } else {
            super.stop();
        }
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}
