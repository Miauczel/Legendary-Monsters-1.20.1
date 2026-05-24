package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class JumpGroundChargeGoal extends IAttackGoal {
    protected final TheObliteratorEntity entity;

    public JumpGroundChargeGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override

    public void stop() {

            super.stop();

    }

    @Override
    public void tick() {

        LivingEntity target = this.entity.getTarget();
        int attackTicks = entity.getAttackTicks();

        if (attackTicks == 20) {
            if (target != null) {
                entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                entity.setDeltaMovement((target.getX() - entity.getX()) * 0.15D, 1.3D, (target.getZ() -entity.getZ()) * 0.15D);
            } else {
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0F, 1.3D, 0.0F));
            }
        }

        if (attackTicks == 38){
            entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
        if (attackTicks == 40) {
            if (target != null) {
                float f = Mth.cos(target.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(target.yBodyRot * ((float) Math.PI / 180F));
                double theta = (target.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;

                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 5;
                float offset = 5;

                    float targetFloor = Mth.floor(target.getY());
                    float y = targetFloor;
                    entity.teleport(target.getX() + vec * vecX + f * offset, 10, target.getZ() + vec * vecZ + f1 * offset);

            }
        }
        if (attackTicks == 43){
            if (target !=null) {
                double distanceToTarget =
                        entity.distanceTo(target);
                float k = (float) (distanceToTarget * 0.02);
                if (distanceToTarget < 12) {
                    if (target instanceof Player) {
                        entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                        Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ())).normalize();
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 1.5D, -0.6 + k, vec3.z * 1.5D));
                    } else {

                        entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                        Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ())).normalize();
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 2D, vec3.y - (0.2 + k), vec3.z * 2D));

                    }
                } else {
                    if (target instanceof Player) {
                        entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                        Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ())).normalize();
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 2D, -0.6 + k, vec3.z * 2D));
                    } else {
                        entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                        Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ())).normalize();
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 2D, vec3.y - (0.2 + k), vec3.z * 2D));
                    }
                }
            }
        }
        super.tick();
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}