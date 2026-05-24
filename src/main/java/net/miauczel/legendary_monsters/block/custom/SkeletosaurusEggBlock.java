package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SkeletosaurusEggBlock extends Block {
    public static final int MAX_HATCH_LEVEL = 2;
    public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
    private static final int REGULAR_HATCH_TIME_TICKS = 24000;//old 24000
    private static final int BOOSTED_HATCH_TIME_TICKS = 12000;//old 12000
    private static final int RANDOM_HATCH_OFFSET_TICKS = 300;//old 300
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 2.0D, 15.0D, 16.0D, 14.0D);

    public SkeletosaurusEggBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HATCH);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public int getHatchLevel(BlockState pState) {
        return pState.getValue(HATCH);
    }

    private boolean isReadyToHatch(BlockState pState) {
        return this.getHatchLevel(pState) == 2;
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!this.isReadyToHatch(pState)) {
            pLevel.playSound((Player)null, pPos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + pRandom.nextFloat() * 0.2F);
            pLevel.setBlock(pPos, pState.setValue(HATCH, Integer.valueOf(this.getHatchLevel(pState) + 1)), 2);
        } else {
            pLevel.playSound((Player)null, pPos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + pRandom.nextFloat() * 0.2F);
            pLevel.destroyBlock(pPos, false);
            SkeloraptorEntity skeloraptor = ModEntities.Skeleraptor.get().create(pLevel);
            if (skeloraptor != null) {
                Vec3 vec3 = pPos.getCenter();
                skeloraptor.setBaby(true);
                skeloraptor.moveTo(vec3.x(), vec3.y(), vec3.z(), Mth.wrapDegrees(pLevel.random.nextFloat() * 360.0F), 0.0F);
                pLevel.addFreshEntity(skeloraptor);
            }

        }
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        boolean flag = hatchBoost(pLevel, pPos);
        if (!pLevel.isClientSide() && flag) {
            pLevel.levelEvent(3009, pPos, 0);
        }

        int i = flag ? 12000 : 24000;
        int j = i / 3;
        pLevel.gameEvent(GameEvent.BLOCK_PLACE, pPos, GameEvent.Context.of(pState));
        pLevel.scheduleTick(pPos, this, j + pLevel.random.nextInt(30));
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.add(Component.translatable("block.legendary_monsters.skeletosaurus_egg1"));
        pTooltip.add(Component.translatable("block.legendary_monsters.skeletosaurus_egg2"));
        pTooltip.add(Component.translatable("block.legendary_monsters.skeletosaurus_egg3"));
        pTooltip.add(Component.translatable("block.legendary_monsters.skeletosaurus_egg4"));

    }

    public static boolean hatchBoost(BlockGetter pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).is(Blocks.SOUL_SAND);
    }
}
