package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.block.LMBlockStateProperties;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallSpikeTrapBlock extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty POWERED_ON_STEP = LMBlockStateProperties.POWER_ON_STEP;
    protected static final VoxelShape SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F);


    public SmallSpikeTrapBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(getStateDefinition().any().setValue(POWERED, false).setValue(POWERED_ON_STEP, false));

    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(POWERED, false);
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(POWERED) && !pLevel.hasNeighborSignal(pPos)) {
            pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
        }

    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            boolean powered = pState.getValue(POWERED);
            if (powered != pLevel.hasNeighborSignal(pPos)) {
                if (powered) {
                    pLevel.scheduleTick(pPos, this, 0);
                } else {
                    pLevel.playSound(null, pPos, ModSounds.DAGGER_THROW.get(), SoundSource.BLOCKS);
                    pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
                }
            }

        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return super.hasAnalogOutputSignal(pState);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        pLevel.scheduleTick(pCurrentPos, this, 20);
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pState.getValue(POWERED) && pEntity instanceof LivingEntity) {
            if (!pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM)) pEntity.hurt(ModDamageTypes.causeImpaleDamage(pLevel), 8.0F);
        }
        if (canActivateWhenStepOn(pEntity, pState)) {
            pLevel.playSound(null, pPos, ModSounds.DAGGER_THROW.get(), SoundSource.BLOCKS);
            pLevel.setBlock(pPos, pState.setValue(POWERED, true), 2);
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public boolean canActivateWhenStepOn(Entity pEntity, BlockState pState) {
        return pState.getValue(POWERED_ON_STEP) && pEntity instanceof LivingEntity livingEntity
                && !livingEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) && !(pEntity instanceof Player player && player.getAbilities().instabuild) && !isPowered(pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POWERED, POWERED_ON_STEP);
    }

    public boolean isPowered(BlockState blockState) {
        return blockState.getValue(POWERED);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(POWERED, false);
    }

}
