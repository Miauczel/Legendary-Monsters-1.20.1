package net.miauczel.legendary_monsters.block.blockentity;

import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.custom.SomberTrapdoorBlock;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor.SomberTrapdoorPart;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class SomberTrapdoorBlockEntity extends IBlockEntity {
    public SomberTrapdoorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.SOMBER_TRAPDOOR.get(), pPos, pBlockState);
    }

    public AnimationState open = new AnimationState();

    public AnimationState idle = new AnimationState();
    public int tickCount = 0;
    public int animationTicks;

    public boolean canSendMessage = true;

    public void sendBasicHotbarMessage(String message, Player player) {
        net.minecraft.network.chat.Component messageComponent =
                Component.translatable(message).withStyle(ChatFormatting.GOLD);
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

    }

    public void tick() {
        tickCount++;
        AABB aabb = new AABB(worldPosition).inflate(1.75);

        for (Player entity : level().getEntitiesOfClass(Player.class, aabb)) {
            // if (!entity.getInventory().contains(ModItems.EYE_CRYSTAL.get().getDefaultInstance()))
            sendBasicHotbarMessage("legendary_monsters.message.somber_trapdoor", entity);
        }

        if (open.isStarted()) {
            animationTicks++;
        }
        if (getBlockState().getValue(SomberTrapdoorBlock.IS_OPEN) && !idle.isStarted() && !open.isStarted()) {
            idle.start(tickCount);
        }
        tickAnimation();
    }

    public void tickAnimation() {
        if (animationTicks == MathUtils.toTicks(1.17f)) setOpen(false, 2);
        if (animationTicks == MathUtils.toTicks(1.67f)) {
            open.stop();
            idle.startIfStopped(tickCount);
        }
    }

    public AnimationState getAnimationState(String string) {
        switch (string) {
            case "open" -> {
                return open;
            }
            case "idle" -> {
                return idle;
            }
            default -> {
                return new AnimationState();
            }
        }
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.open.start(this.tickCount);
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }

    public void setOpen(boolean removeLocks, int lock) {
        if (getBlockState().getValue(SomberTrapdoorBlock.PART) != SomberTrapdoorPart.MIDDLE) return;

        BlockPos center = worldPosition;

        BlockState middleState = getBlockState()
                .setValue(SomberTrapdoorBlock.IS_OPEN, !removeLocks)
                .setValue(SomberTrapdoorBlock.LOCKS_UNLOCKED, lock)
                .setValue(SomberTrapdoorBlock.PART, SomberTrapdoorPart.MIDDLE);

        BlockState sideState = getBlockState()
                .setValue(SomberTrapdoorBlock.IS_OPEN, !removeLocks)
                .setValue(SomberTrapdoorBlock.LOCKS_UNLOCKED, lock)
                .setValue(SomberTrapdoorBlock.PART, SomberTrapdoorPart.UP);

        BlockPos[] blockpos = {
                center.offset(1, 0, 0),
                center.offset(1, 0, 1),
                center.offset(0, 0, 1),
                center.offset(-1, 0, 1),
                center.offset(-1, 0, 0),
                center.offset(-1, 0, -1),
                center.offset(0, 0, -1),
                center.offset(1, 0, -1)
        };

        for (BlockPos blockPos : blockpos) {
            level.setBlock(blockPos, sideState, 3);
        }

        level.setBlock(center, middleState, 3);
    }


    public void unlock() {
        int property = getBlockState().getValue(SomberTrapdoorBlock.LOCKS_UNLOCKED);
        System.out.println("Value: " + property);
        if (getBlockState().getValue(SomberTrapdoorBlock.LOCKS_UNLOCKED) >= 1) open.start(tickCount);


    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, SomberTrapdoorBlockEntity entity) {
        entity.tick();
    }

    public BlockPos getPos() {
        return null;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("tick", tickCount);

        pTag.putInt("animationTick", animationTicks);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = super.getUpdateTag();
        compoundTag.putInt("tick", tickCount);
        compoundTag.putInt("animationTick", animationTicks);
        return compoundTag;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        tickCount = pTag.getInt("tick");
        animationTicks = pTag.getInt("animationTick");
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        return super.serializeNBT();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {

        if (tag.getId() <= 0) {
            tickCount = 0;
        } else {
            super.handleUpdateTag(tag);
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @OnlyIn(Dist.CLIENT)
    public AABB getRenderBoundingBox() {
        AABB bounds = super.getRenderBoundingBox();

        bounds = bounds.inflate(1.0 ,1.5,2.0);


        return bounds;
    }

    @Override
    public void requestModelDataUpdate() {
        super.requestModelDataUpdate();
    }

    @Override
    public @NotNull ModelData getModelData() {
        return super.getModelData();
    }

    @Override
    public boolean hasCustomOutlineRendering(Player player) {
        return super.hasCustomOutlineRendering(player);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        return super.getCapability(cap);
    }

}