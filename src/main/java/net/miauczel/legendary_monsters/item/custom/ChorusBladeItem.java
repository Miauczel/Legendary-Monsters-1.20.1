package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class ChorusBladeItem extends SwordItem {
    public ChorusBladeItem() {
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
                return Ingredient.of(new ItemStack(ModItems.INFECTED_CHORUS_FRUIT.get()));
            }
        }, 6, -2.6f, new Properties().fireResistant().rarity(Rarity.EPIC));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        if(entity.isShiftKeyDown()) {
            entity.getCooldowns().addCooldown(this, 20);
            ChorusBladeRightClicked.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
        }else {
            entity.getCooldowns().addCooldown(this, 20);
      ChorusBladeRightClicked.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            }
        return ar;
    }



    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.chorus_blade1"));
        list.add(Component.translatable("item.legendary_monsters.chorus_blade2"));
    }

}
