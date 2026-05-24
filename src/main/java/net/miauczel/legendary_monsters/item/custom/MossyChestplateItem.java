package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.PoisonousShockwaveSpawner;
import net.miauczel.legendary_monsters.item.ModArmorItem;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
import net.miauczel.legendary_monsters.Message.MessageArmorKey;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MossyChestplateItem extends ArmorItem implements KeybindArmor {


    private static final MobEffectInstance MOSSY_ARMOR_EFFECT =
            new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1, false, false, true);

    public MossyChestplateItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {

    }

    private int g;

    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        int standingOnY = Mth.floor(player.getY());
        if (player != null && !player.getCooldowns().isOnCooldown(this)) {
            this.spawnShockwaves(player.getX(), player.getZ(), standingOnY, player.getY(), 0, 0, player);


            player.getCooldowns().addCooldown((Item) ModItems.MOSSY_CHESTPLATE.get(), 240);
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player living) {
            if (living.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.MOSSY_CHESTPLATE.get() && level.isClientSide && LegendaryMonsters.PROXY.getClientSidePlayer() == entity && LegendaryMonsters.PROXY.isKeyDown(4)) {
                LegendaryMonsters.sendMSGToServer(new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), living.getId(), 4));
                this.onKeyPacket(living, stack, 4);
            }
        }
    }

    private void spawnShockwaves(double x, double z, double minY, double maxY, float rotation, int delay, Player player) {
        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = player.level().getBlockState(blockpos1);

            if (blockstate.isFaceSturdy(player.level(), blockpos1, Direction.UP)) {
                if (!player.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = player.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(player.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) player;
            player.level().addFreshEntity(new PoisonousShockwaveSpawner(player.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, false));
        }

    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Player player = event.player;
            if (!player.level().isClientSide()) {
                ItemStack chestplateItemStack = player.getInventory().armor.get(EquipmentSlot.CHEST.getIndex());
                if (!chestplateItemStack.isEmpty() && chestplateItemStack.getItem() instanceof MossyChestplateItem) {
                    if (hasMossyChestplate(player)) {
                        addMossyArmorEffect(player);
                    } else {
                        removePoisonEffect(player);
                    }
                }
            }

        }
    }

    @SubscribeEvent

    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player && !event.getEntity().level().isClientSide()) {
            Player player = (Player) event.getEntity();
            if (hasMossyChestplate(player)) {
                removePoisonEffect(player);
            }
        }
    }

    private static boolean hasMossyChestplate(Player player) {
        ItemStack chestplateStack = player.getInventory().armor.get(2); // 2 represents the chestplate slot

        return !chestplateStack.isEmpty() && chestplateStack.getItem() instanceof ModArmorItem &&
                ((ModArmorItem) chestplateStack.getItem()).getMaterial() == ModArmorMaterials.MOSSY;
    }

    private static void addMossyArmorEffect(Player player) {
        boolean hasPlayerEffect = player.hasEffect(MOSSY_ARMOR_EFFECT.getEffect());

        if (!hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(MOSSY_ARMOR_EFFECT));
        }
    }

    private static void removePoisonEffect(Player player) {
        MobEffectInstance poisonEffect = new MobEffectInstance(MobEffects.POISON);
        if (player.hasEffect(poisonEffect.getEffect())) {
            player.removeEffect(poisonEffect.getEffect());
        }
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.mossy_chestplate1"));
        list.add(Component.translatable("item.legendary_monsters.mossy_chestplate2"));
    }
}
