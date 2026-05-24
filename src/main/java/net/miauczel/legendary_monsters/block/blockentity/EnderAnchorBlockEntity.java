package net.miauczel.legendary_monsters.block.blockentity;

import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EnderAnchorBlockEntity extends BlockEntity {

    public EnderAnchorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.ENDER_ANCHOR.get(),pPos, pBlockState);
    }




    public boolean shouldRenderFace(Direction pFace) {
        return pFace.getAxis() == Direction.Axis.Y;
    }
}