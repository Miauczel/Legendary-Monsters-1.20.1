package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class VoidEntityWarperPickEvent {
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
        double Scaling = 0;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.VOID_ENTITY_WARPER.get()) {
            for (int index0 = 0; index0 < 15; index0++) {
                if (!world
                        .getBlockState(new BlockPos(
                                entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
                                entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
                                entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
                        .canOcclude()) {
                    Scaling = Scaling + 0.4;
                } else {
                    break;
                }
                {
                    final Vec3 _center = new Vec3(
                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            {
                                Entity _ent = entityiterator;
                                _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                            }
                            if (entity instanceof Player _player)
                                _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 60);
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 2, 2);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 2, 2, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

