package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class SpikyShieldItem extends ShieldItem {
    public SpikyShieldItem(){
        super(new Properties().durability(350));

    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ModBlocks.ANCIENT_DRIPSTONE_BLOCK.get()));
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.spiky_shield1"));
        list.add(Component.translatable("item.legendary_monsters.spiky_shield2"));
        list.add(Component.translatable("item.legendary_monsters.spiky_shield3"));
        list.add(Component.translatable("item.legendary_monsters.spiky_shield4"));
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
}
