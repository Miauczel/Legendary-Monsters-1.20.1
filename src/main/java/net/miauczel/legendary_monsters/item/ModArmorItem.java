package net.miauczel.legendary_monsters.item;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModArmorItem extends ArmorItem {

    private static final MobEffectInstance MOSSY_ARMOR_EFFECT =
            new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1, false, false, true);

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Player player = event.player;
            if (!player.level().isClientSide()) {
                if (hasMossyChestplate(player)) {
                   // System.out.println("Mossy chestplate detected!");
                    addMossyArmorEffect(player);
                }
            }
        }
    }

    private static boolean hasMossyChestplate(Player player) {
        ItemStack chestplateStack = player.getInventory().getArmor(2);

        if (!chestplateStack.isEmpty() && chestplateStack.getItem() instanceof ModArmorItem &&
                ((ModArmorItem) chestplateStack.getItem()).getMaterial() == ModArmorMaterials.MOSSY) {
          //  System.out.println("Chestplate is mossy!");
            return true;
        }

        return false;
    }

    private static void addMossyArmorEffect(Player player) {
        boolean hasPlayerEffect = player.hasEffect(MOSSY_ARMOR_EFFECT.getEffect());

        if (!hasPlayerEffect) {
          //  System.out.println("Adding mossy armor effect!");
            player.addEffect(new MobEffectInstance(MOSSY_ARMOR_EFFECT));
        }
    }
}
