package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class ChorusBladeRightClicked {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        teleportRandomly(entity);
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 60);
            SoundEvent customAttackSound = SoundEvents.ENDERMAN_TELEPORT; // Użyj gettera do uzyskania dźwięku
            entity.level().playSound(null, entity.blockPosition(), customAttackSound, SoundSource.NEUTRAL, 1.0f, 1.0f);
        }
    }

    private static void teleportRandomly(Entity entity) {
        Vec3 entityPos = entity.position();
        double x, y, z;
        Level level = entity.level();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            x = entityPos.x() + (random.nextDouble() - 0.5) * 10.0;
            z = entityPos.z() + (random.nextDouble() - 0.5) * 10.0;
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
