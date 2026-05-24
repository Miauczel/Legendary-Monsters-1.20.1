package net.miauczel.legendary_monsters.item;

import net.miauczel.legendary_monsters.LegendaryMonsters;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "legendary_monsters", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShieldEventHandler {
    @SubscribeEvent
    public static ResourceLocation onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack mainHandStack = player.getMainHandItem();
            ItemStack offhandStack = player.getOffhandItem();

            if (player.isUsingItem() && (isDinosaurBoneShield(mainHandStack) || isDinosaurBoneShield(offhandStack))) {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "models/item/dinosaur_bone_club_blocking.json")  ;
            }
        }
        return null;
    }

    private static boolean isDinosaurBoneShield(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == null;
    }
}