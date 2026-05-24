package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.CloudEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SmallCloudEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WandOfCloudsRightClickEvent {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getTarget(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        execute(null, world, entity, sourceentity);
    }

    private static void spawnFallingCloud2(LevelAccessor world, Entity entity, Entity owner, double y) {
        if (!(entity instanceof ItemFrame) && !(entity instanceof GlowItemFrame) && !(entity instanceof Painting) && !(entity instanceof ArmorStand)) {
            BlockPos spawnPos = BlockPos.containing(entity.getX(), entity.getY() + 5, entity.getZ());
            if (world instanceof ServerLevel serverWorld) {
                BlockPos validSpawnPos = spawnPos;
                if (!serverWorld.isEmptyBlock(spawnPos)) {
                    validSpawnPos = findClosestEmptyBlockY(serverWorld, spawnPos, 5);
                    if (validSpawnPos == null) {
                        return;
                    }
                }

                double xRadius = 2;
                double zRadius = 2;
                int entityAmount = 3;
                for (int i = 0; i < entityAmount; i++) {
                    double angle = ((Math.PI * 2) / entityAmount) * i;
                    double spawnX = validSpawnPos.getX() + 0.5 + Math.cos(angle) * xRadius;
                    double spawnZ = validSpawnPos.getZ() + 0.5 + Math.sin(angle) * zRadius;
                    BlockPos entitySpawnPos = BlockPos.containing(spawnX, validSpawnPos.getY(), spawnZ);
                    Entity entityToSpawn = ModEntities.SMALL_CLOUD.get().spawn(serverWorld, entitySpawnPos, MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn instanceof SmallCloudEntity fallingCloud) {
                        fallingCloud.setOwner(owner);
                        fallingCloud.setDamage((int) (6 * ModConfig.MOB_CONFIG.WandOfCloudsAbilityDamageMultiplier.get()));
                        serverWorld.addFreshEntity(entityToSpawn);
                    }
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0, 0, 0);
                    }
                }
            }
        }
    }

    private static void spawnFallingCloud3(LevelAccessor world, Entity entity, Entity owner, Entity sourceentity, double y) {
        if (!(entity instanceof ItemFrame) && !(entity instanceof GlowItemFrame) && !(entity instanceof Painting) && !(entity instanceof ArmorStand)) {
            BlockPos spawnPos = BlockPos.containing(entity.getX(), entity.getY() + 5, entity.getZ());
            if (world instanceof ServerLevel serverWorld) {
                if (serverWorld.isEmptyBlock(spawnPos)) {
                    Entity entityToSpawn = ModEntities.C.get().spawn(serverWorld, spawnPos, MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn instanceof CloudEntity fallingCloud) {
                        fallingCloud.setOwner(owner);

                        fallingCloud.setDamage((int) (15 * ModConfig.MOB_CONFIG.WandOfCloudsAbilityDamageMultiplier.get()));
                        serverWorld.addFreshEntity(entityToSpawn);
                    }
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0, 0, 0);
                    }
                } else {
                    BlockPos lowerSpawnPos = findClosestEmptyBlockY(serverWorld, spawnPos, 5);
                    if (lowerSpawnPos != null) {
                        Entity entityToSpawn = ModEntities.C.get().spawn(serverWorld, lowerSpawnPos, MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn instanceof CloudEntity fallingCloud) {
                            fallingCloud.setOwner(owner);
                            serverWorld.addFreshEntity(entityToSpawn);
                        }
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0, 0, 0);
                        }
                    }
                }
            }
        }
    }

    private static BlockPos findClosestEmptyBlockY(ServerLevel world, BlockPos centerPos, int radius) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int y = centerPos.getY(); y >= 0; y--) {
            mutablePos.set(centerPos.getX(), y, centerPos.getZ());
            if (world.isEmptyBlock(mutablePos)) {
                return mutablePos.immutable();
            }
        }
        return null;
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;

        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.WAND_OF_CLOUDS.get()) {
            if (sourceentity instanceof Player p_1) {
                if (!p_1.getCooldowns().isOnCooldown(p_1.getMainHandItem().getItem())) {
                    if (world instanceof ServerLevel _level) {
                        spawnFallingCloud3(_level, entity, sourceentity, sourceentity, entity.getY());
                        LegendaryMonsters.queueServerWork(10, () -> {

                            spawnFallingCloud2(_level, entity, sourceentity, entity.getY());

                        });
                    }
                    if (sourceentity instanceof Player _player) {
                        _player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 80);
                    }
                }
            }
        }
    }
}
