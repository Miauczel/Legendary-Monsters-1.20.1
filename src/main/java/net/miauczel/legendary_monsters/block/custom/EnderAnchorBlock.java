package net.miauczel.legendary_monsters.block.custom;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.block.blockentity.EnderAnchorBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class EnderAnchorBlock extends BaseEntityBlock {
    public EnderAnchorBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(CHARGES, Integer.valueOf(0)));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.add(Component.translatable("block.legendary_monsters.ender_anchor1").withStyle(ChatFormatting.GRAY));
    }

    public static final int MIN_CHARGES = 0;
    public static final int MAX_CHARGES = 4;

    public static final IntegerProperty CHARGES = BlockStateProperties.RESPAWN_ANCHOR_CHARGES;
public static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    public RenderShape getRenderShape(BlockState blockState){
        return RenderShape.MODEL;
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EnderAnchorBlockEntity(pPos,pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CHARGES);
    }
    private static final ImmutableList<Vec3i> RESPAWN_HORIZONTAL_OFFSETS = ImmutableList.of(new Vec3i(0, 0, -1), new Vec3i(-1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(1, 0, 0), new Vec3i(-1, 0, -1), new Vec3i(1, 0, -1), new Vec3i(-1, 0, 1), new Vec3i(1, 0, 1));
    private static final ImmutableList<Vec3i> RESPAWN_OFFSETS = (new ImmutableList.Builder<Vec3i>()).addAll(RESPAWN_HORIZONTAL_OFFSETS).addAll(RESPAWN_HORIZONTAL_OFFSETS.stream().map(Vec3i::below).iterator()).addAll(RESPAWN_HORIZONTAL_OFFSETS.stream().map(Vec3i::above).iterator()).add(new Vec3i(0, 1, 0)).build();

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (pHand == InteractionHand.MAIN_HAND && !isRespawnFuel(itemstack) && isRespawnFuel(pPlayer.getItemInHand(InteractionHand.OFF_HAND))) {
            return InteractionResult.PASS;
        } else if (isRespawnFuel(itemstack) && canBeCharged(pState)) {
            charge(pPlayer, pLevel, pPos, pState);
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else if (pState.getValue(CHARGES) == 0) {
            return InteractionResult.PASS;
        } else if (!canSetSpawn(pLevel)) {
            if (!pLevel.isClientSide) {
                this.explode(pState, pLevel, pPos);
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            if (!pLevel.isClientSide) {
                ServerPlayer serverplayer = (ServerPlayer)pPlayer;
                if (serverplayer.getRespawnDimension() != pLevel.dimension() || !pPos.equals(serverplayer.getRespawnPosition())) {
                    serverplayer.setRespawnPosition(pLevel.dimension(), pPos, 0.0F, false, true);
                    pLevel.playSound((Player)null, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }

            return InteractionResult.CONSUME;
        }
    }
    private static boolean isRespawnFuel(ItemStack pStack) {
        return pStack.is(ModBlocks.ANNIHILATION_LANTERN.get().asItem());
    }

    private static boolean canBeCharged(BlockState pState) {
        return pState.getValue(CHARGES) < 4;
    }

    private static boolean isWaterThatWouldFlow(BlockPos pPos, Level pLevel) {
        FluidState fluidstate = pLevel.getFluidState(pPos);
        if (!fluidstate.is(FluidTags.WATER)) {
            return false;
        } else if (fluidstate.isSource()) {
            return true;
        } else {
            float f = (float)fluidstate.getAmount();
            if (f < 2.0F) {
                return false;
            } else {
                FluidState fluidstate1 = pLevel.getFluidState(pPos.below());
                return !fluidstate1.is(FluidTags.WATER);
            }
        }
    }

    private void explode(BlockState pState, Level pLevel, final BlockPos pPos2) {
        pLevel.removeBlock(pPos2, false);
        boolean flag = Direction.Plane.HORIZONTAL.stream().map(pPos2::relative).anyMatch((p_55854_) -> {
            return isWaterThatWouldFlow(p_55854_, pLevel);
        });
        final boolean flag1 = flag || pLevel.getFluidState(pPos2.above()).is(FluidTags.WATER);
        ExplosionDamageCalculator explosiondamagecalculator = new ExplosionDamageCalculator() {
            public Optional<Float> getBlockExplosionResistance(Explosion p_55904_, BlockGetter p_55905_, BlockPos p_55906_, BlockState p_55907_, FluidState p_55908_) {
                return p_55906_.equals(pPos2) && flag1 ? Optional.of(Blocks.WATER.getExplosionResistance()) : super.getBlockExplosionResistance(p_55904_, p_55905_, p_55906_, p_55907_, p_55908_);
            }
        };
        Vec3 vec3 = pPos2.getCenter();
        pLevel.explode((Entity)null, pLevel.damageSources().badRespawnPointExplosion(vec3), explosiondamagecalculator, vec3, 5.0F, true, Level.ExplosionInteraction.BLOCK);
    }

    public static boolean canSetSpawn(Level pLevel) {
        return pLevel.dimension() == Level.END;
    }
    public  void charge(@javax.annotation.Nullable Entity pEntity, Level pLevel, BlockPos pPos, BlockState pState) {
       BlockState blockstate = pState.setValue(CHARGES, Integer.valueOf(pState.getValue(CHARGES) + 1));
       state = Integer.valueOf(pState.getValue(CHARGES) + 1);
       System.out.println("STATE: "+state);
        pLevel.setBlock(pPos, blockstate, 3);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
        pLevel.playSound((Player)null, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
     */
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(CHARGES) != 0) {
            if (pRandom.nextInt(100) == 0) {
                pLevel.playSound((Player)null, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            double d0 = (double)pPos.getX() + 0.5D + (0.5D - pRandom.nextDouble());
            double d1 = (double)pPos.getY() + 1.0D;
            double d2 = (double)pPos.getZ() + 0.5D + (0.5D - pRandom.nextDouble());
            double d3 = (double)pRandom.nextFloat() * 0.04D;

            pLevel.addParticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), d0, d1, d2, 0.0D, d3, 0.0D);
        }
    }



    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    @Deprecated
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
    }

    public static int getScaledChargeLevel(BlockState pState, int pScale) {
        return Mth.floor((float)(pState.getValue(CHARGES)) / 4.0F * (float)pScale);
    }
    public  int state = 0;
    public int getCharges() {

            return state;

    }
    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    @Deprecated
    public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return getScaledChargeLevel(pBlockState, 15);
    }

    public static Optional<Vec3> findStandUpPosition(EntityType<?> pEntityType, CollisionGetter pLevel, BlockPos pPos) {
        Optional<Vec3> optional = findStandUpPosition(pEntityType, pLevel, pPos, true);
        return optional.isPresent() ? optional : findStandUpPosition(pEntityType, pLevel, pPos, false);
    }

    private static Optional<Vec3> findStandUpPosition(EntityType<?> pEntityType, CollisionGetter pLevel, BlockPos pPos, boolean pSimulate) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(Vec3i vec3i : RESPAWN_OFFSETS) {
            blockpos$mutableblockpos.set(pPos).move(vec3i);
            Vec3 vec3 = DismountHelper.findSafeDismountLocation(pEntityType, pLevel, blockpos$mutableblockpos, pSimulate);
            if (vec3 != null) {
                return Optional.of(vec3);
            }
        }

        return Optional.empty();
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

}
