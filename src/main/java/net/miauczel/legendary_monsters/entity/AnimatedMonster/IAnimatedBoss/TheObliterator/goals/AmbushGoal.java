package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class AmbushGoal extends Goal {
    protected final TheObliteratorEntity entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public AmbushGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public AmbushGoal(TheObliteratorEntity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
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

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            this.entity.lookAt(target, 30.0F, 30.0F);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        int attackTicks = entity.getAttackTicks();
        if (attackTicks >= 57 && attackTicks <= 58) {
            entity.saveTeleportPos(entity.getTarget(), entity.targetIsNotNull(), 6, 0);
        }
        if (attackTicks == 57) {
            entity.getNavigation().stop();
            entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
            if (entity.getTarget() != null && !entity.level().isClientSide && (entity.level() instanceof ServerLevel)) {
                entity.setInvulnerable(false);
                if (entity.targetIsNotNull()) entity.teleportRandomly(entity.getTarget(), 10, 10);
            }

        }
        if (attackTicks >= 29 && attackTicks <= 30) {
            entity.saveTeleportPos(entity, entity.isAlive(), -8, 0);
        }
        if (attackTicks == 29) {
            entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);
        }
        if (attackTicks == 31 + 2) {
            int totalPoints = 16;
            double radius = 8.5;
            spawnRingWave(0, 2, totalPoints, radius);


        }
        if (entity.getPhase() >= 2) {
            if (attackTicks == 31 + 18) {
                int totalPoints = 16;
                double radius = 8.5;
              //  spawnRingWave(1, 2, totalPoints, radius);
            }
        }
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