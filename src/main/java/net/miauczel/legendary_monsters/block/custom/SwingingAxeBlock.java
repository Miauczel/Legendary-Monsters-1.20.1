package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.block.LMBlockStateProperties;
import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.SwingingAxeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class SwingingAxeBlock extends BaseEntityBlock {
    public SwingingAxeBlock(Properties pProperties) {
        super(pProperties.noCollission());
        this.registerDefaultState(getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(CIRCULAR,false));
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntity.SWINGING_AXE.get(), SwingingAxeBlockEntity::commonTick);
    }

    public static final DirectionProperty DIRECTION = HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty CIRCULAR = LMBlockStateProperties.AXE_CIRCLING;


    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(DIRECTION, pRot.rotate(pState.getValue(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(DIRECTION)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DIRECTION,CIRCULAR);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(DIRECTION, blockPlaceContext.getHorizontalDirection().getClockWise()).setValue(CIRCULAR,false);
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SwingingAxeBlockEntity(pPos, pState);
    }
}
