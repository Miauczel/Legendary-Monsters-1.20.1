package net.miauczel.legendary_monsters.block.blockentity;

import jdk.jfr.Category;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.MovingTrailParticle;
import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class TeleportMachineBlockEntity extends IBlockEntity {

    public TeleportMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.TELEPORT_MACHINE.get(), pPos, pBlockState);
    }

    public boolean active = false;
    public int tickCount;
    public int activeTicks = 0;
/*
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putBoolean("a", active);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        active = pTag.getBoolean("a");
        super.load(pTag);
    }
*/
    public Random random = new Random();

    public boolean shouldRenderFace(Direction pFace) {
        return pFace.getAxis() == Direction.Axis.Y;
    }

    private void Sphereparticle(ParticleOptions particleType, float y, float vec, float size) {
        if (level != null) {
            if (this.level.isClientSide) {
                if (this.tickCount % 2 == 0) {
                    double d0 = getX();
                    double d1 = getY() + y;
                    double d2 = getZ();
                    double theta = (0.5) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    for (float i = -size; i <= size; ++i) {
                        for (float j = -size; j <= size; ++j) {
                            for (float k = -size; k <= size; ++k) {
                                double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                                double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                                double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                                double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;


                                this.level.addParticle(particleType, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                                if (i != -size && i != size && j != -size && j != size) {
                                    k += size * 2 - 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Vec3 vec3 = worldPosition.getCenter();

    public double getX() {
        return vec3.x;
    }

    public double getY() {
        return vec3.y;
    }

    public double getZ() {
        return vec3.z;
    }

    public Level level() {
        return level != null ? level : null;
    }
    public boolean canSendMessage = true;
    public void tick() {
        tickCount++;
        AABB aabb = new AABB(worldPosition).inflate(1.75);

        for (Player entity : level().getEntitiesOfClass(Player.class, aabb)) {
            // if (!entity.getInventory().contains(ModItems.EYE_CRYSTAL.get().getDefaultInstance()))
            if (canSendMessage) sendBasicHotbarMessage("legendary_monsters.message.teleport_machine", entity);
        }
        AABB aabb1 = new AABB(worldPosition).inflate(20);

        for (TheObliteratorEntity entity : level().getEntitiesOfClass(TheObliteratorEntity.class, aabb1)) {
            canSendMessage = entity == null;
        }
        if (!active && activeTicks != 0) activeTicks = 0;
        if (active) {

            activeTicks++;
            Random random = new Random();
            int boomTick = 70;
            if (tickCount % 15 == 0 && activeTicks < boomTick - 15) {
                ParticleOptions particleOptions = new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK);
                if (level != null && level.isClientSide) {
                    level.addParticle(particleOptions, getX(), getY() + 0.25f, getZ(), 0, 0, 0);
                }
            }
            if (activeTicks < boomTick - 20)
                CameraShakeEntity.cameraShake(level(), worldPosition.getCenter(), 10, 0.05f, 1, 0);

            if (activeTicks < boomTick - 15) {
//                CameraShakeEntity.cameraShake(level(),worldPosition.getCenter(),10,0.02f,1,0);
                for (int k = 0; k < 3; k++) {
                    float d1 = Mth.sqrt(k);
                    float ran = 0.4f;
                    float r = 0 / 255F;
                    float g = 195 / 255F + random.nextFloat() * ran;
                    float b = 0 / 255F;
                    if (level != null && level.isClientSide) level.addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.2f, 0.1f),
                            getBlockPos().getX() + 0.5, getBlockPos().getY() + 0.75, getBlockPos().getZ() + 0.5, Mth.sin(k), 0, d1 * 0.01f);
                }
            }
            if (activeTicks == boomTick - 3) {

                CameraShakeEntity.cameraShake(level(), worldPosition.getCenter(), 10, 0.1f, 5, 10);
                level().playLocalSound(getX(), getY(), getZ(), SoundEvents.TOTEM_USE, SoundSource.BLOCKS, 1, 1, false);

            }
            if (activeTicks > boomTick - 3 && activeTicks < boomTick) {
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.75f, 0f, 1);
            }
            if (activeTicks == boomTick) {
                TheObliteratorEntity obliteratorEntity = new TheObliteratorEntity(ModEntities.THE_OBLITERATOR.get(), level());
                BlockPos pos = new BlockPos((int) getX(), (int) (getY() + 1), (int) getZ());
                obliteratorEntity.setBossBarVisible(false);
                obliteratorEntity.setSpawnBlockPos(pos);
                obliteratorEntity.setPosRaw(getX(), getY() + 1, getZ());
                obliteratorEntity.setAttackState(1);
                level().addFreshEntity(obliteratorEntity);
                active = false;
            }

        }
    }

    public void sendBasicHotbarMessage(String message, Player player) {
        net.minecraft.network.chat.Component messageComponent =
                Component.translatable(message);
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, TeleportMachineBlockEntity entity) {
        entity.tick();

    }

    public BlockPos getPos() {
        return null;
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
        super.handleUpdateTag(tag);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public AABB getRenderBoundingBox() {
        return super.getRenderBoundingBox();
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