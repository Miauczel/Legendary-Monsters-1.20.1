package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.PlayerTornado;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class HeartOfTornadoItem extends BowItem {
    public HeartOfTornadoItem() {
        super(new Properties().durability(-1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        entity.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, entity.getItemInHand(hand));
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.CHISELED_SANDSTONE));
    }
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 72000;
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.heartoftornado1"));


    }
    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
        int useDuration = this.getUseDuration(itemstack) - timeLeft;
        if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity && useDuration > 15) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();

            double theta = (entity.yHeadRot) * (Math.PI / 180);

            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            int numberOfSkulls = 1;
            int numberOfSkulls2 = 3;
            float angleStep = 30.0f;

            float angleStep2 = 40.0f;
            for (int i = 0; i < numberOfSkulls; i++) {
                float angle = entity.yHeadRot + (i - (numberOfSkulls / 2)) * angleStep;

                float rad = (float) Math.toRadians(angle);
                double dx = -Math.sin(rad);
                double dz = Math.cos(rad);
                    PlayerTornado witherskull = new PlayerTornado(entity, dx, 0, dz, entity.level(), (float) 7, angle,entity.getXRot(), 60);
                    double spawnX = entity.getX() + vecX * 1;
                    double spawnY = entity.getY(0.15D);
                    double spawnZ = entity.getZ() + vecZ * 1;
                    witherskull.setPos(spawnX, spawnY, spawnZ);
                    entity.level().addFreshEntity(witherskull);



            if (entityLiving instanceof Player player) {
                player.getCooldowns().addCooldown(this, 130);

                entity.level().playSound(null, entity.blockPosition(), SoundEvents.WITHER_SHOOT, SoundSource.PLAYERS, 2.0F, 1.0F);


            }
        }
    }
}
}


