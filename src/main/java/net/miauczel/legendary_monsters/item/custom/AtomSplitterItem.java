package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.client.ModBlockEntityWithoutLevelRenderer;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBeamEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AtomSplitterItem extends Item {
    public AtomSplitterItem(Properties pProperties) {
        super(pProperties.durability(4));
    }//x - 1 = cap


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!isUsable(itemstack)) {
            ItemStack itemStack = ModItems.BOTTLE_OF_ANNIHILATION.get().getDefaultInstance();

            if (player.getInventory().contains(itemStack) || player.getAbilities().instabuild) {
                if (!player.level().isClientSide) {
                    itemstack.setDamageValue(0);
                    player.getInventory().setChanged();
                }
                if (!player.getAbilities().instabuild) {
                    for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                        ItemStack s = player.getInventory().getItem(i);
                        if (s.is(ModItems.BOTTLE_OF_ANNIHILATION.get()) && s.getCount() >= 2) {
                            s.shrink(2);
                            break;
                        }
                    }
                }

                if (!player.getCooldowns().isOnCooldown(this)) {
                    player.getCooldowns().addCooldown(this, 10);
                }
                //itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                return InteractionResultHolder.consume(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }

        player.startUsingItem(hand);

        if (!player.getCooldowns().isOnCooldown(this)) {
            if (isUsable(itemstack)) {

            }
        }
        return InteractionResultHolder.consume(itemstack);

    }

    @Override
    public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
        consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                // singleton / instancja z ModClient
                return ModBlockEntityWithoutLevelRenderer.INSTANCE;
            }
        });
    }

    public boolean isUsable(ItemStack itemStack) {
        return itemStack.getDamageValue() < itemStack.getMaxDamage() - 1;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        int useDuration = this.getUseDuration(pStack) - pRemainingUseDuration;
        //Avoid sound spam
        if (useDuration == 3) pLivingEntity.playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1.5f);
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (isUsable(stack)) {
            if (entityLiving instanceof Player player) {
                int useDuration = this.getUseDuration(stack) - timeLeft;

                if (useDuration > 20) {
                    stack.hurtAndBreak(1, entityLiving, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    if (!player.getCooldowns().isOnCooldown(this)) {
                        player.getCooldowns().addCooldown(this, 30);
                    }
                    if (!player.isShiftKeyDown()) {
                        entityLiving.playSound(ModSounds.ANNIHILATION_LASER_SINGLE_SHOOT.get(), 3, 1);

                        Vec3 entityPosition = entityLiving.position();
                        CameraShakeEntity.cameraShake(entityLiving.level(), entityPosition, 30.0F, 0.10F, 5, 5);
                        AnnihilationBeamEntity energyBeamEntity = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entityLiving.level(), entityLiving, entityLiving.getX(),
                                entityLiving.getY() + 1f, entityLiving.getZ(),
                                (float) ((entityLiving.yHeadRot + 90) * Math.PI / 180), (float) (-entityLiving.getXRot() * Math.PI / 180),
                                10, (float) (16 * ModConfig.MOB_CONFIG.AtomSplitterDamageMultiplier.get()), 0, 1, false, 0, 0, 0, false, 30);
                        energyBeamEntity.setRadius(30);
                        entityLiving.level().addFreshEntity(energyBeamEntity);

                    } else {

                        entityLiving.playSound(ModSounds.THE_WARPED_ONE_SHOOT.get(), 3, 1);
                        shootAnnihilationBomb(player, 1, player.getX(), player.getY() + 1, player.getZ());
                    }
                }

            }
        }
    }

    public void shootAnnihilationBomb(Player player, float velocity, double x, double y, double z) {


        AnnihilationBombEntity chorusBomb = new AnnihilationBombEntity(ModEntities.ANNIHILATION_BOMB_ENTITY.get(), player.level(), player, 10, 16, false);

        chorusBomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 1, 1.0F);
        chorusBomb.setPosRaw(x, y, z);


        chorusBomb.setOwner(player);
        //chorusBomb.setPos(x, y, z);
        player.level().addFreshEntity(chorusBomb);


    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.atom_splitter1"));
        list.add(Component.translatable("item.legendary_monsters.atom_splitter2"));
        list.add(Component.translatable("item.legendary_monsters.atom_splitter3"));

    }

}
