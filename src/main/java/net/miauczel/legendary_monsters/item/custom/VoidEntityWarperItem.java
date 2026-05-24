package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.item.custom.CustomItemEvents.VoidEntityWarperPickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class VoidEntityWarperItem extends Item {




        public VoidEntityWarperItem() {
            super(new Properties().rarity(Rarity.EPIC));

        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
            InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
            ItemStack itemstack = ar.getObject();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
           VoidEntityWarperPickEvent.execute(world, x, y, z, entity);
            return ar;

        }
    /**@Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.literal("\u00A76special: \u00A76\u00A7l[ENTITY WARP PICK] \u00A76Lets you pick any"));
        list.add(Component.literal("\u00A76entity to teleport to you in 6 block range! \u00A76\u00A7l[RIGHT CLICK TO USE]"));

    }
    */
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.void_entity_warper1"));
        list.add(Component.translatable("item.legendary_monsters.void_entity_warper2"));

    }
    }


