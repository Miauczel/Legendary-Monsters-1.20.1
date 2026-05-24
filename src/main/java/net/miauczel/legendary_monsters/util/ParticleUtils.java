package net.miauczel.legendary_monsters.util;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ParticleUtils {

    public static void controlledSmashParticles(LivingEntity entity, float vec, float offset, float additionalY, float power, float r) {
        Level level = entity.level();
        float f = Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F));
        double theta = (entity.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        Vec3 vec3 = new Vec3(entity.getX() + vec * vecX + f * offset, entity.getOnPos().getY(), entity.getZ() + vec * vecZ + f1 * offset);
        BlockPos pos = BlockUtils.blockPosVec3(vec3);
        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticles.DUST_FALLING.get(), level.getBlockState(pos));

        for (int i = 0; i < (power / 0.01) / 3f; ++i) {
            double d0 = vec3.x + level.getRandom().nextGaussian() / (double) 2.0F;
            double d1 = vec3.y + 1 + additionalY;
            double d2 = vec3.z + level.getRandom().nextGaussian() / (double) 2.0F;
            double d3 = level.getRandom().nextGaussian() * (double) 0.2F;
            double d4 = level.getRandom().nextGaussian() * (double) 0.2F;
            double d5 = level.getRandom().nextGaussian() * (double) 0.2F;
            level.addParticle(blockparticleoption, d0, d1, d2, d3, d4, d5);
        }

        for (int j = 0; j < (power / 0.02) / 1.5f; ++j) {
            double d6 = vec3.x + (double) r * Math.cos(j) + level.getRandom().nextGaussian() / (double) 2.0F;
            double d7 = vec3.y + 1 + additionalY;
            double d8 = vec3.z + (double) r * Math.sin(j) + level.getRandom().nextGaussian() / (double) 2.0F;
            double d9 = level.getRandom().nextGaussian() * (double) 0.05F;
            double d10 = level.getRandom().nextGaussian() * (double) 0.05F;
            double d11 = level.getRandom().nextGaussian() * (double) 0.05F;
            level.addParticle(blockparticleoption, d6, d7, d8, d9, d10, d11);
        }

    }

    public static void smashParticles(Entity entity, float additionalY, float power, float r, boolean strict) {
        Level level = entity.level();
        Vec3 vec3 = new Vec3(entity.getX(), entity.getOnPos().getY(), entity.getZ());
        BlockPos pos = BlockUtils.blockPosVec3(vec3);
        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticles.DUST_FALLING.get(), level.getBlockState(pos));

        for (int i = 0; i < (!strict ? (power / 0.01) / 3f : power); ++i) {
            double d0 = vec3.x + level.getRandom().nextGaussian() / (double) 2.0F;
            double d1 = vec3.y + 1 + additionalY;
            double d2 = vec3.z + level.getRandom().nextGaussian() / (double) 2.0F;
            double d3 = level.getRandom().nextGaussian() * (double) 0.2F;
            double d4 = level.getRandom().nextGaussian() * (double) 0.2F;
            double d5 = level.getRandom().nextGaussian() * (double) 0.2F;
            level.addParticle(blockparticleoption, d0, d1, d2, d3, d4, d5);
        }

        for (int j = 0; j < (!strict ? (power / 0.02) / 1.5f : power) ; ++j) {
            double d6 = vec3.x + (double) r * Math.cos(j) + level.getRandom().nextGaussian() / (double) 2.0F;
            double d7 = vec3.y + 1 + additionalY;
            double d8 = vec3.z + (double) r * Math.sin(j) + level.getRandom().nextGaussian() / (double) 2.0F;
            double d9 = level.getRandom().nextGaussian() * (double) 0.05F;
            double d10 = level.getRandom().nextGaussian() * (double) 0.05F;
            double d11 = level.getRandom().nextGaussian() * (double) 0.05F;
            level.addParticle(blockparticleoption, d6, d7, d8, d9, d10, d11);
        }
    }

    public static void sendParticlesToServer(Level level, ParticleOptions particleOptions, double x, double y, double z, int count, double xO, double yO, double zO, double speed) {
     //   if (!(level instanceof ServerLevel serverLevel)) return;

     //   serverLevel.sendParticles(particleOptions, x, y, z, count, xO, yO, zO, speed);
        level.addParticle(particleOptions,x,y,z,0,0,0);
    }


}
