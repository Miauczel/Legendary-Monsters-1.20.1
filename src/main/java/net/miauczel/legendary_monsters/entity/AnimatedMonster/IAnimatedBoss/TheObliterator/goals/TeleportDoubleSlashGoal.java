package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class TeleportDoubleSlashGoal extends IAttackGoal {
    protected final TheObliteratorEntity entity;

    public TeleportDoubleSlashGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
        int attackTicks = entity.getAttackTicks();
        LivingEntity target = entity.getTarget();
        if (attackTicks == 14){
           entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
        if (attackTicks == 9){
            entity.level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 , entity.getZ(),0,0,0);
        }
        /*
        if (attackTicks == 10){
            if (target !=null) {
                float f  = Mth.cos(target.yBodyRot * ((float)Math.PI / 180F));
                float f1 = Mth.sin(target.yBodyRot * ((float)Math.PI / 180F));
                double theta = (target.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;

                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec   = -3;
                float offset = 0;


                entity.teleportTo(
                        target.getX() + vec * vecX + f  * offset,
                        target.getY(),
                        target.getZ() + vec * vecZ + f1 * offset
                );
            }
        }*/
    }
    public boolean requiresUpdateEveryTick() {
        return false;
    }
}