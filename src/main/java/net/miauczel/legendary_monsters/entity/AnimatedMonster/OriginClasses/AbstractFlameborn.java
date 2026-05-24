package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public abstract class AbstractFlameborn extends IAnimatedMob {
    public AbstractFlameborn(EntityType entity, Level world) {
        super(entity, world);
    }

    @Override
    public void tick() {
        if (!level().isClientSide) {
           // System.out.println("Fall Distance: " + fallDistance);
            if (this.fallDistance > 10) {
                //System.out.println("Falling: " + "true");
                teleportRandomly(targetIsNotNull() ? target() : this, targetIsNotNull() ? 10 : 25, 15);
            }
        }
        super.tick();
    }

    public void teleportRandomly(LivingEntity entity, float range, float iteractions) {

        Vec3 entityPos = entity.position();
        double x, y, z;
        Level level = this.level();

        for (int i = 0; i < iteractions; i++) {
            x = entityPos.x() + (this.getRandom().nextDouble() - 0.5) * range;
            z = entityPos.z() + (this.getRandom().nextDouble() - 0.5) * range;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1, iz)).isAir()) {
                this.teleport(x, y, z);
                return;
            }
        }
    }

    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + 3, getZ(), 1, 0, 0, 0, 0);
        }

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {

            EntityTeleportEvent.EnderEntity event = ForgeEventFactory.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.teleportBoolean(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
                    this.playSound(SoundEvents.SHULKER_TELEPORT, 4.0F, 1.0F);
                }
            }

            return flag2;

        } else {
            return false;
        }

    }

    public boolean teleportBoolean(double x, double y, double z, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = y;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(x, y, z);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }


            if (flag1) {
                this.teleportTo(x, d3, z);
                // EntityUtil.applyServerTeleport(this);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {

            this.teleportTo(d0, d1, d2);
            // EntityUtil.applyServerTeleport(this);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte) 46);
            }
            this.getNavigation().stop();

            return true;
        }
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        super.registerGoals();
    }
}
