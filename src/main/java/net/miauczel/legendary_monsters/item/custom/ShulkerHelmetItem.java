package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShulkerHelmetItem extends ArmorItem {
    private static final MobEffectInstance MOSSY_ARMOR_EFFECT =
            new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1, false, false, true);

    public ShulkerHelmetItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Player player = event.player;
            if (!player.level().isClientSide()) {
                ItemStack headItemStack = player.getInventory().armor.get(EquipmentSlot.HEAD.getIndex());
                if (!headItemStack.isEmpty() && headItemStack.getItem() instanceof ShulkerHelmetItem) {
                    removeLevitationEffect(player);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player && !event.getEntity().level().isClientSide()) {
            Player player = (Player) event.getEntity();
            ItemStack headItemStack = player.getInventory().armor.get(EquipmentSlot.HEAD.getIndex());
            if (!headItemStack.isEmpty() && headItemStack.getItem() instanceof ShulkerHelmetItem) {
                removeLevitationEffect(player);
            }
        }
    }

    private static void removeLevitationEffect(Player player) {
        if (player.hasEffect(MobEffects.LEVITATION)) {
            player.removeEffect(MobEffects.LEVITATION);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.shulker_helmet1"));
    }
}
