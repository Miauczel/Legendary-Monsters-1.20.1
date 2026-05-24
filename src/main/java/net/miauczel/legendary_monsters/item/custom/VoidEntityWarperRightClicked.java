package net.miauczel.legendary_monsters.item.custom;


import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VoidEntityWarperRightClicked {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player && entity instanceof ServerPlayer) {
                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ENDER_EYE
                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.VOID_ENTITY_WARPER.get()) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .collect(Collectors.toList());
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator) && !(entity == entityiterator) && !(entityiterator instanceof ItemEntity) && !(entityiterator instanceof ArmorStand)) {
                            {
                                Entity _ent = entityiterator;
                                _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                            }

                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(ParticleTypes.END_ROD, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 3, 3, 1);
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }

                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.VOID_ENTITY_WARPER.get()) {
                                if (entity instanceof Player _player)
                                    _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 140);
                                {
                                  //  ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                   // if (_ist.hurt(1, RandomSource.create(), null)) {
                                    //    _ist.shrink(1);
                                    //    _ist.setDamageValue(0);
                                   // }
                                }
                            }
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.VOID_ENTITY_WARPER.get()) {
                                if (entity instanceof Player _player)
                                    _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 140);
                                {
                                    ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
                                    if (_ist.hurt(1, RandomSource.create(), null)) {
                                        _ist.shrink(1);
                                        _ist.setDamageValue(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


