package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.item.custom.CustomItemEvents.SharpSaiHandHeldTick;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class SharpSaiItem extends SwordItem {
    public SharpSaiItem() {
        super(new Tier()  {
            public int getUses() {
                return 250;
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
        }, 5, -2f, new Properties().rarity(Rarity.COMMON));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        return ar;
    }



    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
       list.add(Component.literal("\u00A76SPECIAL ABILITY: \u00A76\u00A7l[SHARP BLADE]\u00A76Chance to add bleeding "));
       list.add(Component.literal("\u00A76effect to your enemies."));
        list.add(Component.literal("§2§l[WARNING]:§2 when you are holding this weapon, "));
        list.add(Component.literal("§2your attack range is being lowered by 1"));
    }
    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected)
            SharpSaiHandHeldTick.execute(entity);
    }

}
