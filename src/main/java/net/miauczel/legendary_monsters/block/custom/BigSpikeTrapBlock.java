package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.block.LMBlockStateProperties;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BigSpikeTrapBlock extends Block {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final BooleanProperty POWERED_ON_STEP = LMBlockStateProperties.POWER_ON_STEP;

    public BigSpikeTrapBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(HALF, DoubleBlockHalf.LOWER).setValue(POWERED, false).setValue(POWERED_ON_STEP, false));
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (pFacing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (pFacing == Direction.UP) || pFacingState.is(this) && pFacingState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext) ? super.getStateForPlacement(pContext) : null;
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(blockpos, copyWaterloggedFrom(pLevel, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        if (pState.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(pState, pLevel, pPos);
        } else {
            BlockState blockstate = pLevel.getBlockState(pPos.below());
            if (pState.getBlock() != this) {
                return super.canSurvive(pState, pLevel, pPos);
            } else {
                return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
            }
        }
    }

    public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(pPos, copyWaterloggedFrom(pLevel, pPos, pState.setValue(HALF, DoubleBlockHalf.LOWER)), pFlags);
        pLevel.setBlock(blockpos, copyWaterloggedFrom(pLevel, blockpos, pState.setValue(HALF, DoubleBlockHalf.UPPER)), pFlags);
    }

    public static BlockState copyWaterloggedFrom(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return pState.hasProperty(BlockStateProperties.WATERLOGGED) ? pState.setValue(BlockStateProperties.WATERLOGGED, pLevel.isWaterAt(pPos)) : pState;
    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide) {
            if (pPlayer.isCreative()) {
                preventCreativeDropFromBottomPart(pLevel, pPos, pState, pPlayer);
            } else {
                dropResources(pState, pLevel, pPos, null, pPlayer, pPlayer.getMainHandItem());
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
        super.playerDestroy(pLevel, pPlayer, pPos, Blocks.AIR.defaultBlockState(), pTe, pStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        DoubleBlockHalf doubleblockhalf = (DoubleBlockHalf) pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{HALF, POWERED, POWERED_ON_STEP});
    }

    public long getSeed(BlockState pState, BlockPos pPos) {
        return Mth.getSeed(pPos.getX(), pPos.below(pState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pPos.getZ());
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    }

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;


    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(POWERED, false);
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (pState.getValue(POWERED) && !pLevel.hasNeighborSignal(pPos)) {
            pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
            if (doubleblockhalf == DoubleBlockHalf.LOWER) {
                pLevel.setBlock(pPos.relative(Direction.UP), pState.cycle(POWERED).setValue(HALF, DoubleBlockHalf.UPPER), 2);
            }
        }

    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {

        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (!pLevel.isClientSide) {
            boolean powered = pState.getValue(POWERED);
            if (powered != pLevel.hasNeighborSignal(pPos)) {
                if (powered) {
                    pLevel.scheduleTick(pPos, this, 0);
                } else {
                    pLevel.playSound(null, pPos, ModSounds.DAGGER_THROW.get(), SoundSource.BLOCKS);
                    pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
                    if (doubleblockhalf == DoubleBlockHalf.LOWER)
                        pLevel.setBlock(pPos.relative(Direction.UP), pState.cycle(POWERED).setValue(HALF, DoubleBlockHalf.UPPER), 2);
                }
            }

        }
    }

    protected static final VoxelShape CONE_LOWER = Block.box(4.0F, 0.0F, 4.0F, 12.0F, 14.0F, 12.0F);
    protected static final VoxelShape CONE_UPPER = Block.box(4.0F, -2.0F, 4.0F, 12.0F, 12.0F, 12.0F);

    protected static final VoxelShape BASE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F);
    protected static final VoxelShape SHAPE = Shapes.or(CONE_LOWER, BASE);

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        return doubleblockhalf == DoubleBlockHalf.LOWER ? isPowered(state) ? SHAPE : BASE : isPowered(state) ? CONE_UPPER : Shapes.empty();
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pState.getValue(POWERED) && pEntity instanceof LivingEntity) {
            if (!pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM))
                pEntity.hurt(ModDamageTypes.causeImpaleDamage(pLevel), 12.0F);
        }
        if (canActivateWhenStepOn(pEntity, pState)) {
            pLevel.playSound(null, pPos, ModSounds.DAGGER_THROW.get(), SoundSource.BLOCKS);
            pLevel.setBlock(pPos.relative(Direction.UP), pState.cycle(POWERED).setValue(HALF, DoubleBlockHalf.UPPER), 2);
            pLevel.setBlock(pPos, pState.setValue(POWERED, true), 2);
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public boolean canActivateWhenStepOn(Entity pEntity, BlockState pState) {
        return pState.getValue(POWERED_ON_STEP) && pEntity instanceof LivingEntity livingEntity
                && !livingEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) && !(pEntity instanceof Player player && player.getAbilities().instabuild) && !isPowered(pState);
    }

    public boolean isPowered(BlockState blockState) {
        return blockState.getValue(POWERED);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        return doubleblockhalf == DoubleBlockHalf.LOWER ? isPowered(pState) ? SHAPE : BASE : isPowered(pState) ? CONE_UPPER : Shapes.empty();
    }
}
