package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
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

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static net.minecraft.util.datafix.fixes.ItemIdFix.getItem;

public class MossyHammerRightClicked {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, UUID ownerUUID) {
        if (entity == null || ownerUUID == null) return;

        Player owner = world.getPlayerByUUID(ownerUUID);
        if (owner == null) return;


        if (entity instanceof Player && entity instanceof ServerPlayer) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.MOSSY_HAMMER.get()) {
                {
                   // MossyHammerRightClickedEffect.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .collect(Collectors.toList());
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator) && !(entity == entityiterator) && !(entityiterator instanceof ItemEntity) && !(entityiterator instanceof ArmorStand)) {

                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 3, 3, 1);

                            // Sprawdź, czy entityiterator jest oswojonym bytem
                            if (entityiterator instanceof TamableAnimal tamableEntity && tamableEntity.isTame() && tamableEntity.getOwner() == owner) {
                                continue; // Pomiń ten byt, jeśli jest oswojony przez właściciela
                            }

                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 2, false, false));
                            }

                            DamageSource damageSource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), owner);
                            entityiterator.hurt(damageSource, 10);

                            entityiterator.setDeltaMovement(new Vec3(0.2, 0.5, 0));

                            if (((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).getBlock() == Blocks.STONE
                                    || (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).getBlock() == Blocks.MOSS_BLOCK
                                    || (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).getBlock() == Blocks.GRASS_BLOCK)
                                    && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.BONE_MEAL)) : false)) {
                                world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() + 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() - 1, entityiterator.getZ()), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() - 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY() - 1, entityiterator.getZ()), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                                if (entity instanceof Player _player) {
                                    ItemStack _stktoremove = new ItemStack(Items.BONE_MEAL);
                                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                                if (Math.random() < 0.5) {
                                    world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.GRASS.defaultBlockState(), 3);
                                    world.setBlock(BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY(), entityiterator.getZ()), Blocks.AZALEA.defaultBlockState(), 3);
                                }
                                if (Math.random() < 0.5) {
                                    world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.POPPY.defaultBlockState(), 3);
                                    world.setBlock(BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY(), entityiterator.getZ()), Blocks.GRASS.defaultBlockState(), 3);
                                }
                                if (Math.random() < 0.5) {
                                    world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.FLOWERING_AZALEA.defaultBlockState(), 3);
                                    world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ() + 1), Blocks.GRASS.defaultBlockState(), 3);
                                    if (world instanceof Level _level) {
                                        BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ());
                                        if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
                                            if (!_level.isClientSide())
                                                _level.levelEvent(2005, _bp, 0);
                                        }
                                    }
                                }
                            }
                            if (entity instanceof Player dplayer) {
                                ItemStack mainHandItem = dplayer.getMainHandItem();
                                if (!mainHandItem.isEmpty() && mainHandItem.getItem() == ModItems.MOSSY_HAMMER.get() && !dplayer.getCooldowns().isOnCooldown(mainHandItem.getItem())) {
                                    if (entity instanceof Player _player) {
                                        _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 30);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
       // MossyHammerRightClickedEffect.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
    }
}
