package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

import static net.minecraft.Util.getRandom;

public class ChorusInfectionHurt {

    public static void execute(LevelAccessor world, Entity entity) {
         Random random = new Random();
        if (entity == null)
            return;
        if (random.nextFloat() < 0.05f) {
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 3);
            teleportRandomly(entity);
        }

    }
    private static void teleportRandomly(Entity entity) {
        Vec3 entityPos = entity.position();
        double x, y, z;
        Level level = entity.level();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            x = entityPos.x() + (random.nextDouble() - 0.5) * 4.0;
            z = entityPos.z() + (random.nextDouble() - 0.5) * 4.0;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1,  iz)).isAir()) {
                entity.teleportTo(x, y, z);
                return;
            }
        }
    }
}


