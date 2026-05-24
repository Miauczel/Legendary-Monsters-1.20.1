package net.miauczel.legendary_monsters.entity;


import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.StratlingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID)
public class OpenContainerEvent {

    @SubscribeEvent
    public static void onContainerOpen(PlayerContainerEvent.Open event) {
        Player player = event.getEntity();
        if (player.level().isClientSide) {
            return;
        }

        AbstractContainerMenu container = event.getContainer();
        if (!(container.getClass().getSimpleName().equals("ChestMenu"))) {
            return;
        }

        List<StratlingEntity> nearbyEntities = player.level().getEntitiesOfClass(
                StratlingEntity.class,
                player.getBoundingBox().inflate(10.0D)
        );

        for (StratlingEntity entity : nearbyEntities) {

            entity.setTarget(player);
        }
    }
}