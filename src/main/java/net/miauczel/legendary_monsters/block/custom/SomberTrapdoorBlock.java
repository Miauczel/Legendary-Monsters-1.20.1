package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.LightningParticle;
import net.miauczel.legendary_monsters.block.LMBlockStateProperties;
import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.SomberTrapdoorBlockEntity;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor.SomberTrapdoorPart;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class SomberTrapdoorBlock extends BaseEntityBlock {
    public SomberTrapdoorBlock(Properties pProperties) {
        super(pProperties
                .noOcclusion()
                .dynamicShape()
                .sound(SoundType.NETHERITE_BLOCK));

        this.registerDefaultState(getStateDefinition().any()
                .setValue(DIRECTION, Direction.NORTH)
                .setValue(IS_OPEN, false)
                .setValue(PART, SomberTrapdoorPart.MIDDLE)
                .setValue(IS_OPEN, false)
                .setValue(OCCUPIED, false)
                .setValue(LOCKS_UNLOCKED, 0));

    }

    private static final VoxelShape CLOSED = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public static final EnumProperty<SomberTrapdoorPart> PART;

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntity.SOMBER_TRAPDOOR.get(), SomberTrapdoorBlockEntity::commonTick);
    }

    public static final DirectionProperty DIRECTION = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;

    public static final IntegerProperty LOCKS_UNLOCKED = LMBlockStateProperties.LOCKS_UNLOCKED;
    public static final BooleanProperty IS_OPEN = BlockStateProperties.OPEN;


    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(DIRECTION, pRot.rotate(pState.getValue(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(DIRECTION)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{DIRECTION, PART, IS_OPEN, OCCUPIED, LOCKS_UNLOCKED});
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(DIRECTION, blockPlaceContext.getHorizontalDirection().getClockWise()).setValue(IS_OPEN, false);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SomberTrapdoorBlockEntity(pPos, pState);
    }
    @Override
    public net.minecraft.world.level.material.PushReaction getPistonPushReaction(net.minecraft.world.level.block.state.BlockState state) {
        return net.minecraft.world.level.material.PushReaction.BLOCK;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int openValue = 1;
        SomberTrapdoorPart part = pState.getValue(PART);
        ItemStack stack = pPlayer.getItemInHand(pHand);

        if (pLevel.getBlockEntity(pPos) instanceof SomberTrapdoorBlockEntity somberTrapdoorBlockEntity && stack.is(ModItems.SOMBER_KEY.get()) && part == SomberTrapdoorPart.MIDDLE
                && !somberTrapdoorBlockEntity.getBlockState().getValue(IS_OPEN) && somberTrapdoorBlockEntity.getBlockState().getValue(LOCKS_UNLOCKED) < openValue) {

            if (!pPlayer.getAbilities().instabuild) stack.shrink(1);

            pLevel.playLocalSound(pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.CHAIN_PLACE, SoundSource.BLOCKS, 1, 0.75f, false);

            int property = somberTrapdoorBlockEntity.getBlockState().getValue(SomberTrapdoorBlock.LOCKS_UNLOCKED);
            if (property < openValue) somberTrapdoorBlockEntity.setOpen(true, property + 1);

            Direction yRot = somberTrapdoorBlockEntity.getBlockState().getValue(SomberTrapdoorBlock.DIRECTION);
            boolean westAxis = yRot == Direction.EAST || yRot == Direction.WEST;

            switch (property) {

                case 0 -> {
                    createCircularLightningParticle(somberTrapdoorBlockEntity.getBlockState(), pPos, pLevel, 0.5f, 0.5f, 2, 0.35f);
                }
                case 1 -> {
                    createCircularLightningParticle(somberTrapdoorBlockEntity.getBlockState(), pPos, pLevel, westAxis ? -1 : -1, westAxis ? 1 : 0, 2, 0.25f);
                }
            }

            somberTrapdoorBlockEntity.unlock();

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    public Random random = new Random();

    public void createCircularLightningParticle(BlockState blockState, BlockPos pos, Level level, float vec, float offset, int part, float size) {
        for (int i = 0; i < 360; i++) {
            if (i % part == 0) {

                Direction yRot = blockState.getValue(SomberTrapdoorBlock.DIRECTION);
                boolean westAxis = yRot == Direction.EAST || yRot == Direction.WEST;
                int angle = westAxis ? 0 : 0;//90
                float f = Mth.cos(angle * ((float) Math.PI / 180F));
                float f1 = Mth.sin(angle * ((float) Math.PI / 180F));
                double theta = (angle) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(pos.getY());

                double d0 = (random.nextFloat() - 0.5F);
                double d1 = (random.nextFloat() - 0.5F);
                double d2 = (random.nextFloat() - 0.5F);
                double dist = 1F + random.nextFloat() * 0.2F;
                double d3 = d0 * dist;
                double d4 = d1 * dist;
                double d5 = d2 * dist;
                double pX = (pos.getX() + vec * vecX + f * offset);
                double pY = pos.getY() + 1;
                double pZ = (pos.getZ() + vec * vecZ + f1 * offset);

                level.addParticle(new LightningParticle.OrbData(226, 130, 16),
                        pX, pY, pZ, Mth.sin(i) * size, d4, Mth.cos(i) * size);
                spawnCircleParticle(level, pX, pos.getY() + 0.25f, pZ, 0, 0, 8, false, 20, 1, 0.5f, 0.1f, 0.75f, Circle.EnumRingBehavior.GROW, 20);
            }
        }
    }

    public void spawnCircleParticle(Level level, double x, double y, double z, float vec, float math, float size, boolean blockParticles, float blockParticleSize, float r, float g, float b, float a, Circle.EnumRingBehavior enumRingBehavior, int life) {
        if (level.isClientSide) {

            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {

                double DeltaMovementX = random.nextGaussian() * 0.07D;
                double DeltaMovementY = random.nextGaussian() * 0.07D;
                double DeltaMovementZ = random.nextGaussian() * 0.07D;
                float angle = (0.01745329251F * 1) + i1;
                double extraX = blockParticleSize * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = blockParticleSize * Mth.cos(angle);
                int hitX = Mth.floor(x);
                int hitY = Mth.floor(y);
                int hitZ = Mth.floor(z);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level.getBlockState(hit.below());

                if (block.getRenderShape() != RenderShape.INVISIBLE && blockParticles) {
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), x, y + extraY, z,
                            DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }

            level.addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, life, r, g, b, a, 1f * size,
                    false, enumRingBehavior), x, y + 1.25f, z, 0, 0, 0);

        }
    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            SomberTrapdoorPart part = pState.getValue(PART);
            if (part == SomberTrapdoorPart.MIDDLE) {
                BlockPos pos = pPos.relative(getNeighbourDirection(part, pState.getValue(DIRECTION)));

                BlockState block = pLevel.getBlockState(pos);
                if (block.is(this) && (block.getValue(PART) == SomberTrapdoorPart.UP)) {

                    BlockPos pos1 = pPos.offset(1, 0, 0);
                    BlockPos pos2 = pPos.offset(1, 0, 1);
                    BlockPos pos3 = pPos.offset(0, 0, 1);
                    BlockPos pos4 = pPos.offset(-1, 0, 0);
                    BlockPos pos5 = pPos.offset(-1, 0, 1);
                    BlockPos pos6 = pPos.offset(-1, 0, -1);
                    BlockPos pos7 = pPos.offset(0, 0, -1);

                    BlockPos pos8 = pPos.offset(1, 0, -1);
                    BlockPos[] finalpos = {pos, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8};
                    for (BlockPos blockPos : finalpos) {
                        pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                        pLevel.levelEvent(pPlayer, 2001, pos, Block.getId(block));
                    }
                }

                System.out.println("POS: " + block.getBlock());
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public static Direction getConnectedDirection(BlockState pState) {
        Direction $$1 = pState.getValue(DIRECTION);
        return pState.getValue(PART) == SomberTrapdoorPart.UP ? $$1.getOpposite() : $$1;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext
            pContext) {
        if (pState.getValue(IS_OPEN)) {
            return Shapes.empty();
        } else return CLOSED;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return Shapes.empty();
    }

    @javax.annotation.Nullable
    public static Direction getBedOrientation(BlockGetter pLevel, BlockPos pPos) {
        BlockState $$2 = pLevel.getBlockState(pPos);
        return $$2.getBlock() instanceof BedBlock ? (Direction) $$2.getValue(DIRECTION) : null;
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState pState) {
        SomberTrapdoorPart $$1 = pState.getValue(PART);
        return $$1 == SomberTrapdoorPart.UP ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    private static Direction getNeighbourDirection(SomberTrapdoorPart pPart, Direction pDirection) {
        return pPart == SomberTrapdoorPart.MIDDLE ? pDirection : pDirection.getOpposite();
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @javax.annotation.Nullable LivingEntity
            pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide) {
            BlockPos relativePos = pPos.relative(pState.getValue(DIRECTION));
            pLevel.setBlock(relativePos, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);

            BlockPos pos1 = pPos.offset(1, 0, 0);
            BlockPos pos2 = pPos.offset(1, 0, 1);
            BlockPos pos3 = pPos.offset(0, 0, 1);

            BlockPos pos8 = pPos.offset(1, 0, -1);
            BlockPos pos4 = pPos.offset(-1, 0, 0);
            BlockPos pos5 = pPos.offset(-1, 0, 1);
            BlockPos pos6 = pPos.offset(-1, 0, -1);
            BlockPos pos7 = pPos.offset(0, 0, -1);

            pLevel.setBlock(pos1, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos2, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos3, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos4, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos5, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos6, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos7, pState.setValue(PART, SomberTrapdoorPart.UP), 3);
            pLevel.setBlock(pos8, pState.setValue(PART, SomberTrapdoorPart.UP), 3);

            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }

    }

    public long getSeed(BlockState pState, BlockPos pPos) {
        BlockPos $$2 = pPos.relative(pState.getValue(DIRECTION), pState.getValue(PART) == SomberTrapdoorPart.UP ? 0 : 1);
        return Mth.getSeed($$2.getX(), pPos.getY(), $$2.getZ());
    }

    static {
        PART = LMBlockStateProperties.SOMBER_TRAPDOOR_PART;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.add(Component.translatable("block.legendary_monsters.somber_trapdoor1").withStyle(ChatFormatting.GRAY));
    }
}
