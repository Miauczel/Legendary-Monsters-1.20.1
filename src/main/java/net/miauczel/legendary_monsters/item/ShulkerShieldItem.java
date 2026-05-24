package net.miauczel.legendary_monsters.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class ShulkerShieldItem extends ShieldItem {
    public ShulkerShieldItem(){
        super(new Properties().durability(450));
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.SHULKER_SHELL));
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.shulker_shield1"));
        list.add(Component.translatable("item.legendary_monsters.shulker_shield2"));
    }
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
}
