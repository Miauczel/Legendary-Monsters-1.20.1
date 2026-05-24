package net.miauczel.legendary_monsters.block.custom.SoulCandle;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.function.ToIntFunction;

public class SoulCandleBlock extends AbstractSoulCandleBlock implements SimpleWaterloggedBlock {
    public static final int MIN_CANDLES = 1;
    public static final int MAX_CANDLES = 4;
    public static final IntegerProperty CANDLES;
    public static final BooleanProperty LIT;
    public static final BooleanProperty WATERLOGGED;
    public static final ToIntFunction<BlockState> LIGHT_EMISSION;
    private static final Int2ObjectMap PARTICLE_OFFSETS;
    private static final VoxelShape ONE_AABB;
    private static final VoxelShape TWO_AABB;
    private static final VoxelShape THREE_AABB;
    private static final VoxelShape FOUR_AABB;

    public SoulCandleBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((((this.stateDefinition.any()).setValue(CANDLES, 1)).setValue(LIT, false)).setValue(WATERLOGGED, false));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getAbilities().mayBuild && pPlayer.getItemInHand(pHand).isEmpty() && (Boolean)pState.getValue(LIT)) {
            extinguish(pPlayer, pState, pLevel, pPos);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        return !pUseContext.isSecondaryUseActive() && pUseContext.getItemInHand().getItem() == this.asItem() && (Integer)pState.getValue(CANDLES) < 4 ? true : super.canBeReplaced(pState, pUseContext);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState $$1 = pContext.getLevel().getBlockState(pContext.getClickedPos());
        if ($$1.is(this)) {
            return (BlockState)$$1.cycle(CANDLES);
        } else {
            FluidState $$2 = pContext.getLevel().getFluidState(pContext.getClickedPos());
            boolean $$3 = $$2.getType() == Fluids.WATER;
            return (BlockState)super.getStateForPlacement(pContext).setValue(WATERLOGGED, $$3);
        }
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    public FluidState getFluidState(BlockState pState) {
        return (Boolean)pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Integer)pState.getValue(CANDLES)) {
            case 1:
            default:
                return ONE_AABB;
            case 2:
                return TWO_AABB;
            case 3:
                return THREE_AABB;
            case 4:
                return FOUR_AABB;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{CANDLES, LIT, WATERLOGGED});
    }

    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        if (!(Boolean)pState.getValue(WATERLOGGED) && pFluidState.getType() == Fluids.WATER) {
            BlockState $$4 = (BlockState)pState.setValue(WATERLOGGED, true);
            if ((Boolean)pState.getValue(LIT)) {
                extinguish((Player)null, $$4, pLevel, pPos);
            } else {
                pLevel.setBlock(pPos, $$4, 3);
            }

            pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            return true;
        } else {
            return false;
        }
    }

    public static boolean canLight(BlockState pState) {
        return pState.is(BlockTags.CANDLES, (p_152810_) -> p_152810_.hasProperty(LIT) && p_152810_.hasProperty(WATERLOGGED)) && !(Boolean)pState.getValue(LIT) && !(Boolean)pState.getValue(WATERLOGGED);
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState pState) {
        return (Iterable)PARTICLE_OFFSETS.get((Integer)pState.getValue(CANDLES));
    }

    protected boolean canBeLit(BlockState pState) {
        return !(Boolean)pState.getValue(WATERLOGGED) && super.canBeLit(pState);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return Block.canSupportCenter(pLevel, pPos.below(), Direction.UP);
    }

    static {
        CANDLES = BlockStateProperties.CANDLES;
        LIT = AbstractSoulCandleBlock.LIT;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        LIGHT_EMISSION = (p_152848_) -> (Boolean)p_152848_.getValue(LIT) ? 3 * (Integer)p_152848_.getValue(CANDLES) : 0;
        PARTICLE_OFFSETS = Util.make(() -> {
            Int2ObjectMap<List<Vec3>> $$0 = new Int2ObjectOpenHashMap();
            $$0.defaultReturnValue(ImmutableList.of());
            $$0.put(1, ImmutableList.of(new Vec3((double)0.5F, (double)0.5F, (double)0.5F)));
            $$0.put(2, ImmutableList.of(new Vec3((double)0.375F, 0.44, (double)0.5F), new Vec3((double)0.625F, (double)0.5F, 0.44)));
            $$0.put(3, ImmutableList.of(new Vec3((double)0.5F, 0.313, (double)0.625F), new Vec3((double)0.375F, 0.44, (double)0.5F), new Vec3(0.56, (double)0.5F, 0.44)));
            $$0.put(4, ImmutableList.of(new Vec3(0.44, 0.313, 0.56), new Vec3((double)0.625F, 0.44, 0.56), new Vec3((double)0.375F, 0.44, (double)0.375F), new Vec3(0.56, (double)0.5F, (double)0.375F)));
            return Int2ObjectMaps.unmodifiable($$0);
        });
        ONE_AABB = Block.box((double)7.0F, (double)0.0F, (double)7.0F, (double)9.0F, (double)6.0F, (double)9.0F);
        TWO_AABB = Block.box((double)5.0F, (double)0.0F, (double)6.0F, (double)11.0F, (double)6.0F, (double)9.0F);
        THREE_AABB = Block.box((double)5.0F, (double)0.0F, (double)6.0F, (double)10.0F, (double)6.0F, (double)11.0F);
        FOUR_AABB = Block.box((double)5.0F, (double)0.0F, (double)5.0F, (double)11.0F, (double)6.0F, (double)10.0F);
    }
}
