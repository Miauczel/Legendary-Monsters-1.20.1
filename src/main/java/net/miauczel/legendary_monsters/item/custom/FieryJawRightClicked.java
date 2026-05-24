package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class FieryJawRightClicked {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double R2 = 0;
        double R1 = 0;
        double particleRadius = 0;
        double particleAmount = 0;
        double fireHeight = 0;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.FIERY_JAW.get()) {
            if (entity instanceof Player _player)
                _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
            loop = 1;
            particleAmount = 128;
            xRadius = 3;
            zRadius = 3;
            while (loop < particleAmount) {
                world.addParticle(ParticleTypes.FLAME, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
                loop = loop + 1;
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.NEUTRAL, 2, 2);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.NEUTRAL, 2, 2, false);
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2, 2);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2, 2, false);
                }
            }
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entity == entityiterator) && !(entityiterator instanceof GlowItemFrame) && !(entityiterator instanceof ArmorStand) && !(entityiterator instanceof ItemFrame) && !(entityiterator instanceof ItemEntity)) {
                        entityiterator.setSecondsOnFire(4);
                        entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1), 0, (entity.getLookAngle().z * 1)));
                        R1 = Math.random();
                        R2 = Math.random();



                    }
                }
            }
        }
    }

}
