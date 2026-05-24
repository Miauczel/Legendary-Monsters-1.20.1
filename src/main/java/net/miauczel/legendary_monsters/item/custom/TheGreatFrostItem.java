package net.miauczel.legendary_monsters.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.IceSpikeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;

public class TheGreatFrostItem extends SwordItem implements IForgeItem {
    public TheGreatFrostItem() {

        super(new Tier()  {
            public int getUses() {
                return 750;
            }

            public float getSpeed() {
                return 6f;
            }

            public float getAttackDamageBonus() {
                return 0f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 14;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Items.IRON_INGOT));
            }
        }, 6, -2.6f, new Properties().rarity(Rarity.EPIC));

        //  ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        // builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Tool modifier2", 1.0D, AttributeModifier.Operation.ADDITION));

        // this.defaultModifiers = builder.build();

    }
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (pEquipmentSlot != EquipmentSlot.MAINHAND)return super.getDefaultAttributeModifiers(pEquipmentSlot);

        double damage = 6 * ModConfig.MOB_CONFIG.TheGreatFrostDamageMultiplier.get();
        double speed = -2.6D * ModConfig.MOB_CONFIG.TheGreatFrostSpeedMultiplier.get();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", speed, AttributeModifier.Operation.ADDITION));

        return builder.build();
    }
    /**public final Multimap<Attribute, AttributeModifier> defaultModifiers;
     @Override
     public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
     return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
     }
     */
    /**@Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
    super.appendHoverText(itemstack, world, list, flag);
    list.add(Component.literal("\u00A76SPECIAL ABILITY: \u00A76\u00A7l[FREEZE] \u00A76 There is 50% chance for giving the freeze"));
    list.add(Component.literal("\u00A76 effect to your enemy. \u00A76\u00A7l[ATTACK TO USE]"));
    }
     */
    private void spawnIceSpikesAdvanced(double x, double z, double minY, double maxY, float rotation, int delay, Player player) {

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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) player;
            player.level().addFreshEntity(new IceSpikeEntity(player.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1));
        }
    }
    private void createSpellEntity(double pX, double pZ, double pMinY, double pMaxY, float pYRot, int pWarmupDelay,Player player) {
        BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
        boolean flag = false;
        double d0 = 0.0;

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
        } while(blockpos.getY() >= Mth.floor(pMinY) - 1);

        if (flag) {
            player.level().addFreshEntity(new IceSpikeEntity(player.level(), pX, (double)blockpos.getY() + d0, pZ, pYRot, pWarmupDelay, player));
        }

    }
    private boolean spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, Player player) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
                if (!world.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.addFreshEntity(new IceSpikeEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, player));
            return true;
        }
        return false;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        int standingOnY = Mth.floor(player.getY()) - 1;
        double headY = player.getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + player.getYRot()));
        boolean hasSucceeded = false;

        for (int l = 0; l < 5; l++) {
            double d2 = 1.25D * (double) (l + 1);
            if (this.spawnFangs(player.getX() + (double) Mth.cos(yawRadians) * d2, headY, player.getZ() + (double) Mth.sin(yawRadians) * d2, standingOnY, yawRadians, l, world, player))
                hasSucceeded = true;

        }


        ItemStack stack = player.getItemInHand(hand);
        if (hasSucceeded) {
            player.getCooldowns().addCooldown(this, 50);
            return InteractionResultHolder.success(stack);
        }

        return InteractionResultHolder.pass(stack);
    }
    @Override
    public InteractionResult useOn( UseOnContext context) {
        Level world = context.getLevel();

        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        ItemStack itemstack = player.getItemInHand(hand);
        BlockPos blockPos = context.getClickedPos();
        if (!world.isClientSide && !player.getCooldowns().isOnCooldown(this)) {
            int standingOnY = Mth.floor(player.getY());// Sprawdzamy, czy kod wykonuje się po stronie serwera
            if (player.isShiftKeyDown()) { // Sprawdzamy, czy gracz trzyma klawisz Shift
                for (int k = 0; k < 1.5; ++k) {
                    float f3 = (float) k * (float) Math.PI * 2.0F / 1.5F + ((float) Math.PI * 2F / 2.5F);
                    this.spawnIceSpikesAdvanced(player.getX() + (double) Mth.cos(f3) * 1.5D, player.getZ() + (double) Mth.sin(f3) * 1.5D, standingOnY, player.getY() + 1, f3, 0, player);
                }
                for (int k = 0; k < 6; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnIceSpikesAdvanced(player.getX() + (double) Mth.cos(f2) * 2.5D, player.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, player.getY() + 1, f2, 2, player);
                }
                for (int k = 0; k < 11; ++k) {
                    float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnIceSpikesAdvanced(player.getX() + (double) Mth.cos(f3) * 3.5D, player.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, player.getY() + 1, f3, 3, player);
                }

                player.getCooldowns().addCooldown(this, 80);

                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
            // Jeśli nie spełniono warunków, zwracamy PASS, aby kontynuować standardowe przetwarzanie akcji
            return InteractionResult.FAIL;
        }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.great_frost1"));
        list.add(Component.translatable("item.legendary_monsters.great_frost2"));
    }
}


