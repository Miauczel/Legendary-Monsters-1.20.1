package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
@Mod.EventBusSubscriber
public class WitheredScytheDropGoldEventHandler {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        execute(null, world, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.WITHERED_SCYTHE.get()) {
            if (Math.random() < 0.05) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.GOLD_INGOT));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            } else if (Math.random() < 0.3) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.GOLD_NUGGET));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }else if (Math.random() < 0.005) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.GOLD_NUGGET));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);}
            }
        }
    }
}


