package net.miauczel.legendary_monsters.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.swing.plaf.multi.MultiToolBarUI;
import java.util.List;

public class EntitywarperItem extends Item {




        public EntitywarperItem() {
            super(new Item.Properties().rarity(Rarity.RARE));

        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
            InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
            ItemStack itemstack = ar.getObject();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            EntityWarperRightClicked.execute(world, x, y, z, entity);
            return ar;
        }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.entity_warper1"));
        list.add(Component.translatable("item.legendary_monsters.entity_warper2"));

    }
    }


