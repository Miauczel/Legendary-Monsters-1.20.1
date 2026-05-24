package net.miauczel.legendary_monsters.block.custom;

import net.minecraft.world.level.block.Block;

public class IndestructibleBlock extends Block {
    public IndestructibleBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public net.minecraft.world.level.material.PushReaction getPistonPushReaction(net.minecraft.world.level.block.state.BlockState state) {
        return net.minecraft.world.level.material.PushReaction.BLOCK;
    }
}
