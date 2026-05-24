package net.miauczel.legendary_monsters.block.custom;

import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.TeleportMachineBlockEntity;
import net.miauczel.legendary_monsters.client.ModBlockEntityWithoutLevelRenderer;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TeleportMachineBlock extends BaseEntityBlock {
    public TeleportMachineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.getBlockEntity(pPos) instanceof TeleportMachineBlockEntity teleportMachineBlockEntity && pPlayer.getItemInHand(pHand).is(ModItems.EYE_CRYSTAL.get()) && !teleportMachineBlockEntity.active) {
            //  pPlayer.getMainHandItem().hurtAndBreak(1,pPlayer,player -> player.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            if (!pPlayer.getAbilities().instabuild) pPlayer.getMainHandItem().shrink(1);
            pLevel.playLocalSound(pPlayer.getX(),pPlayer.getY(),pPlayer.getZ(), SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS,1,1,false);
            teleportMachineBlockEntity.active = true;
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntity.TELEPORT_MACHINE.get(), TeleportMachineBlockEntity::commonTick);
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TeleportMachineBlockEntity(pPos, pState);
    }
}
