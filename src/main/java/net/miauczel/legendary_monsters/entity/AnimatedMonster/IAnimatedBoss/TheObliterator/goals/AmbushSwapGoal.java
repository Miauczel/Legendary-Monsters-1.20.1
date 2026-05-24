package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class AmbushSwapGoal extends Goal {
    protected final TheObliteratorEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public AmbushSwapGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public AmbushSwapGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
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
        return target != null && target.isAlive()
                && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && entity.getAttackDelayTicks() <= 0;
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
        int tp1 = 32;
        int tp2 = 52;
        int tp3 = 74;
        int tp4 = 96;
        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }

        int attackTicks = entity.getAttackTicks();
        if (attackTicks == tp1 - 2) {
            entity.saveTeleportPos(entity, entity.isAlive(), -8, 0);
        }
        if (attackTicks == tp1) {
            // entity.setInvisible(true);
            entity.setInvulnerable(true);
            //  entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
            entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);
        }
        if (attackTicks == tp2 - 2) {
            entity.saveTeleportPos(entity.getTarget(), entity.targetIsNotNull(), 6, 0);
        }
        if (attackTicks == tp2) {

            //  entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
            if (entity.getTarget() != null) {
                entity.setInvulnerable(false);
                entity.teleportRandomly(entity, 10, 10);
                //  entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);

                entity.setNoGravity(false);
            }
        }
        if (attackTicks == tp3 - 2) {
            entity.saveTeleportPos(entity, entity.isAlive(), -8, 0);
        }
        if (attackTicks == 91) {
            //    entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
        if (attackTicks == tp3) {
            if (entity.getTarget() != null) {
                entity.getNavigation().stop();
                //  entity.  setInvisible(true);
                entity.setInvulnerable(true);
                //  entity. playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);


            }
        }
        if (attackTicks == tp4 - 2) {//Old 119, 121
            entity.saveTeleportPos(entity.target(), entity.targetIsNotNull(), -6, 0);
        }
        if (attackTicks == 100) {
            // entity. level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(),entity.getY() + 3 ,entity.getZ(),0,0,0);

        }
        if (attackTicks == tp4) {//Old 122
            // entity.setInvisible(true);
            entity.getNavigation().stop();
            // entity. playSound(SoundEvents.ENDERMAN_TELEPORT,2,1);

            if (entity.getTarget() != null) {
                entity.setInvulnerable(false);
                entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);
                entity.setNoGravity(false);
            }
        }
        if (attackTicks == 31) {

            //  entity. setInvisible(true);
        }
        if (attackTicks == 32) {
            if (entity.getTarget() != null) {
                int randomOffset = entity.getRandom().nextInt(3);
                int bonusClones = entity.getRandom().nextInt(2);
                int clonesAmount = 10 + bonusClones;
                for (int k = 0; k < clonesAmount; ++k) {
                    float angleOnCircle = k * (float) Math.PI * -2.0F / 8 + randomOffset + (-(float) Math.PI * 2F / 15F);
                    double spawnX = this.entity.getTarget().getX() + Math.cos(angleOnCircle) * 8.5D;
                    double spawnZ = this.entity.getTarget().getZ() + Math.sin(angleOnCircle) * 8.5D;

                    int standingOnY = Mth.floor(this.entity.getY());
                    float targetY = (float) (entity.target().getY() + (double) entity.target().getBbHeight() * 0.3333333333333333D);
                    double spawnY = standingOnY;
                    double headY = this.entity.getTarget().getY() + 1;


                    double dx = this.entity.getTarget().getX() - spawnX;
                    double dz = this.entity.getTarget().getZ() - spawnZ;

                    float yawRad = (float) Math.atan2(dz, dx);
                    this.entity.spawnDuplicateVersions(
                            spawnX, spawnZ,
                            spawnY, headY,
                            yawRad,
                            4,
                            (float) this.entity.getTarget().getX(),
                            (float) entity.getTarget().getY(),
                            (float) this.entity.getTarget().getZ()
                    );
                }
            }
        }
        if (attackTicks == tp3 + 2) {
            int totalPoints = 16;  // pełny okrąg (zielone+czerwone razem)
            double radius = 8.5;
            spawnRingWave(0, 2, totalPoints, radius);


        }
        if (attackTicks == tp3 + 18) {
            int totalPoints = 16;  // pełny okrąg (zielone+czerwone razem)
            double radius = 8.5;
            spawnRingWave(1, 2, totalPoints, radius);
        }
        if (attackTicks == 65) {
            //  entity. playSound(SoundEvents.ENDERMAN_TELEPORT,2,1);
            entity.setInvulnerable(false);
            entity.setNoGravity(false);
        }
        if (attackTicks == 92) {
            //entity.setInvisible(true);
        }
        if (attackTicks == tp3 + 2) {
            if (entity.getTarget() != null) {
                int randomOffset = entity.getRandom().nextInt(3);
                int bonusClones = entity.getRandom().nextInt(2);
                int clonesAmount = 7 + bonusClones;

                double Cx = this.entity.getTarget().getX();
                double Cz = this.entity.getTarget().getZ();
                double baseR = 8.5D;
                double scale = 1.25;
                double R = baseR * scale;

                double x1 = Cx + R;
                double z1 = Cz;
                double x2 = Cx + (R * -0.5);
                double z2 = Cz + (R * Math.sqrt(3) / 2.0);
                double x3 = Cx + (R * -0.5);
                double z3 = Cz - (R * Math.sqrt(3) / 2.0);


                double side = R * Math.sqrt(3);
                double perimeter = 3.0 * side;

                int standingOnY = Mth.floor(entity.getY());
                double spawnY = standingOnY;
                double headY = entity.getTarget().getY() + 1.0D;

                float destX = (float) Cx;
                float destY = (float) entity.getTarget().getY();
                float destZ = (float) Cz;

                for (int k = 0; k < clonesAmount; ++k) {
                    double d = ((double) k + randomOffset * 0.1) * (perimeter / clonesAmount);

                    int edgeIndex = (int) Math.floor(d / side);
                    if (edgeIndex >= 3) edgeIndex = 2;

                    double distAlongEdge = d - (edgeIndex * side);
                    double t = distAlongEdge / side;

                    double spawnX, spawnZ;
                    switch (edgeIndex) {
                        case 0:
                            spawnX = x1 + t * (x2 - x1);
                            spawnZ = z1 + t * (z2 - z1);
                            break;
                        case 1:
                            spawnX = x2 + t * (x3 - x2);
                            spawnZ = z2 + t * (z3 - z2);
                            break;
                        default:
                            spawnX = x3 + t * (x1 - x3);
                            spawnZ = z3 + t * (z1 - z3);
                            break;
                    }

                    double dx = Cx - spawnX;
                    double dz = Cz - spawnZ;
                    float yawRad = (float) Math.atan2(dz, dx);

                    //  entity.spawnDuplicateVersions(spawnX, spawnZ, spawnY, headY, yawRad, 4, destX, destY, destZ);
                }

            }
        }

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    private void spawnRingWave(int waveIndex, int wavesTotal, int totalPoints, double radius) {
        var target = entity.getTarget();
        if (target == null) return;

        double step = (Math.PI * 2.0) / totalPoints;

        int pointsThisWave = totalPoints / wavesTotal;

        double base = (-(Math.PI * 2.0) / 15.0);

        double waveOffset = waveIndex * step;

        for (int i = 0; i < pointsThisWave; i++) {
            double angle = base + waveOffset + i * (wavesTotal * step);

            double spawnX = target.getX() + Math.cos(angle) * radius;
            double spawnZ = target.getZ() + Math.sin(angle) * radius;

            double spawnY = Mth.floor(this.entity.getY());
            double headY = target.getY() + 1.0;

            double dx = target.getX() - spawnX;
            double dz = target.getZ() - spawnZ;

            float yawRad = (float) Math.atan2(dz, dx);

            this.entity.spawnDuplicateVersions(
                    spawnX, spawnZ,
                    spawnY, headY,
                    yawRad,
                    4,
                    (float) target.getX(),
                    (float) target.getY(),
                    (float) target.getZ()
            );
        }
    }

}
