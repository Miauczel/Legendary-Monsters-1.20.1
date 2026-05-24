package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.LegendaryMonsters;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;



import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class TheEndersentRightclickedProcedure {
    private static void launch(LivingEntity livingEntity, LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - livingEntity.getX();
        double deltaZ = entity.getZ() - livingEntity.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? 2.0F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.5 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player && entity instanceof ServerPlayer) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.CHORUS_BLADE.get()
                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.CHORUS_BLADE.get()) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(16/ 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .collect(Collectors.toList());
                    for (LivingEntity entityiterator : _entfound) {
                        if (!(entity == entityiterator) && !(entity == entityiterator) && !(entityiterator instanceof ArmorStand)) {
                            {
                                Entity _ent = entity;
                                double angle = Math.toRadians(entityiterator.getYRot());
                                double offsetX = -Math.sin(angle) -2.0;
                                double offsetZ = Math.cos(angle) - 2.0;

                                double targetX = entityiterator.getX() + offsetX;
                                double targetY = entityiterator.getY();
                                double targetZ = entityiterator.getZ() + offsetZ;

                                _ent.teleportTo(targetX, targetY, targetZ);
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport(targetX, targetY, targetZ, _ent.getYRot(), _ent.getXRot());
                            }
                            {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 3, 3, 1);
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                DamageSource damageSource = new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity);
                                entityiterator.hurt(damageSource, 8);
launch((LivingEntity) entity, (LivingEntity) entityiterator, true);
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.CHORUS_BLADE.get()) {
                                if (entity instanceof Player _player)
                                    _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 80);
                            }
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.CHORUS_BLADE.get()) {
                                if (entity instanceof Player _player)
                                    _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 80);
                            }
                        }
                    }
                }
            }
        }
    }
}}
