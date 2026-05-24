package net.miauczel.legendary_monsters.item.custom;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class VoidSwordItem extends SwordItem {
    public VoidSwordItem() {
        super(new Tier() {
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
                return Ingredient.of(new ItemStack(Blocks.BLACKSTONE_WALL));
            }
        }, 5, -3f, new Item.Properties());
    }
}


