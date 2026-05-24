package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FireColumnEntity;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.Message.MessageArmorKey;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FieryBootsItem extends ArmorItem implements KeybindArmor {


    public FieryBootsItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private int g;

    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        int standingOnY = Mth.floor(player.getY());
        if (player != null && !player.getCooldowns().isOnCooldown(this)) {
            this.spawnShockwaves(player.getX(), player.getZ(), standingOnY, player.getY(), 0, 0, player);

            g = 300;

            player.getCooldowns().addCooldown((Item) ModItems.FIERY_BOOTS
                    .get(), 500);
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player living) {
            if (living.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.FIERY_BOOTS.get() && level.isClientSide && LegendaryMonsters.PROXY.getClientSidePlayer() == entity && LegendaryMonsters.PROXY.isKeyDown(7)) {
                LegendaryMonsters.sendMSGToServer(new MessageArmorKey(EquipmentSlot.FEET.ordinal(), living.getId(), 7));
                this.onKeyPacket(living, stack, 7);
            }
        }
        if (g > 0) {
            --g;
            if (entity instanceof Player player) {
                int standingOnY = Mth.floor(player.getY());
                if (player.tickCount % 5 == 0) {

                    this.spawnShockwaves(player.getX(), player.getZ(), standingOnY, player.getY(), 0, 0, player);
                }
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
            player.level().addFreshEntity(new FireColumnEntity(player.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1));
        }

    }


    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.fiery_boots1"));
    }
}
