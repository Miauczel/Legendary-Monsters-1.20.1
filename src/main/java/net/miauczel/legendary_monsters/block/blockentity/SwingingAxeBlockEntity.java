package net.miauczel.legendary_monsters.block.blockentity;

import net.miauczel.legendary_monsters.Particle.custom.LightningParticle;
import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.custom.SwingingAxeBlock;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class SwingingAxeBlockEntity extends IBlockEntity {
    public SwingingAxeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.SWINGING_AXE.get(), pPos, pBlockState);
    }

    public AnimationState swing = new AnimationState();
    public int tickCount = 0;

    public void tick() {
        tickIK();
        if (isCircling()) {
            damageCircular(0.15f, 0.75, 0.25, 13);
        } else damageIK(isCircling() ? -1.25f : -0.5f, 0.25, 13);
        tickCount++;
    }

    public float prevHipX, prevHipY, prevKneeX, prevKneeY;
    public float hipX, hipY, kneeX, kneeY;
    public double prevIK_PX = getX();
    public double prevIK_PY = getY() - 3;
    public double prevIK_PZ = getZ();

    public boolean isSwingingOffset() {
        Direction yDir = getBlockState().getValue(SwingingAxeBlock.DIRECTION);
        return yDir == Direction.WEST || yDir == Direction.EAST;
    }

    public boolean isCircling() {
        return getBlockState().getValue(SwingingAxeBlock.CIRCULAR);
    }

    public void tickIK() {

        float yRot = 0;
        float f = Mth.cos(yRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yRot * ((float) Math.PI / 180F));
        double theta = (yRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float increment = (float) Math.sin(tickCount * 0.1) * 3;

        float Yincrement = (float) Math.sin(tickCount * 0.1);

        float vec = !isSwingingOffset() ? increment : 0;
        float offset = isSwingingOffset() ? increment : 0;
        double dx = getX() + vec * vecX + f * offset;
        double dz = getZ() + vec * vecZ + f1 * offset;
        double dy = isCircling() ? getY() - 3 : getY() - 3 + ((increment * increment) / 8);

        // double dy = getY() - 3;

       /* if (level() instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.FLAME, IK_Point().x, IK_Point().y, IK_Point().z, 1, 0, 0, 0, 0);
        }

        */


        prevIK_PX = dx;
        prevIK_PY = dy;
        prevIK_PZ = dz;

        float lerp = 0.15f;
        //setIK_Point(Mth.lerp(lerp, (float) IK_PX, (float)prevIK_PX), Mth.lerp(lerp, (float) IK_PY, (float) prevIK_PY), Mth.lerp(lerp, (float) IK_PZ, (float) prevIK_PZ));
        float r = 2.25f;
        double trigTick = tickCount * 0.25f;
        double cX = getX() + r * Math.sin(trigTick);
        double cZ = getZ() + r * Math.cos(trigTick);
        setIK_Point(isCircling() ? cX : dx, dy, isCircling() ? cZ : dz);
        // System.out.println("PX: " + IK_PX + " PY: " + IK_PY + " PZ: " + IK_PZ);
        if (tickCount % 30 == 0) {
            level().playSound(null, worldPosition, ModSounds.GENERIC_ARM_SWING.get(), SoundSource.BLOCKS, 1, 0.7f);
        }

        // level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
    }

    public void setIK_Point(double px, double py, double pz) {
        IK_PX = px;
        IK_PY = py;
        IK_PZ = pz;
    }

    public void damageCircular(double inflateXZ, double r, double inflateY, float damage) {
        float yRot = 0;
        float f = Mth.cos(yRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yRot * ((float) Math.PI / 180F));
        double theta = (yRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = isCircling() ? 0 : isSwingingOffset() ? -0.5f : 0;
        float offset = isCircling() ? 0 : !isSwingingOffset() ? -0.5f : 0;
        double dx = IK_Point().x + vec * vecX + f * offset;
        double dz = IK_Point().z + vec * vecZ + f1 * offset;

        double dy = getY() - 3;
        Vec3 hitPos = new Vec3(dx, dy, dz);


        double atan2 = Math.atan2(getZ() - hitPos.z, getX() - hitPos.x);
        double cos = r * Math.cos(atan2);
        double sin = r * Math.sin(atan2);
        AABB aabb = new AABB(
                hitPos.x - inflateXZ, hitPos.y - inflateY, hitPos.z - inflateXZ,
                hitPos.x + inflateXZ, hitPos.y + inflateY, hitPos.z + inflateXZ
        );
        /*
        //DEBUG PARTICLES
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.FLAME, hitPos.x, hitPos.y, hitPos.z, 1, 0, 0, 0, 0);

            for (int l = 0; l < MathUtils.distanceToVec(hitPos, worldPosition.getCenter()); ++l) {
                double d2 = 1.25D * (double) (l + 1);
                level.sendParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), hitPos.x + (double) Mth.cos((float) atan2) * d2, getY() - 2.5, hitPos.z + (double) Mth.sin((float) atan2) * d2,
                        1, 0, 0, 0, 0);
            }
        }
         */
        List<LivingEntity> entityList = level().getEntitiesOfClass(LivingEntity.class, aabb.inflate(inflateXZ, inflateY, inflateXZ).expandTowards(cos, 0, sin));
        for (LivingEntity entity : entityList) {
            if (entity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM)) continue;

            boolean hurt = entity.hurt(ModDamageTypes.causeCutDamage(level()), (damage));
            if (hurt) {
                createCircularLightningParticle(hitPos, 5, 2);
                level().playSound(null, worldPosition, ModSounds.WEAPON_IMPACT.get(), SoundSource.BLOCKS, 3, 1);

            }
        }

    }

    public void damageIK(double inflateXZ, double inflateY, float damage) {
        Vec3 hitPos = IK_Point();

        AABB aabb = new AABB(
                hitPos.x - inflateXZ, hitPos.y - inflateY, hitPos.z - inflateXZ,
                hitPos.x + inflateXZ, hitPos.y + inflateY, hitPos.z + inflateXZ
        );

        List<LivingEntity> entityList = level().getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entity : entityList) {
            if (entity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM)) continue;

            boolean hurt = entity.hurt(ModDamageTypes.causeCutDamage(level()), damage);
            if (hurt) {
                createCircularLightningParticle(hitPos, 5, 2);
                level().playSound(null, worldPosition, ModSounds.WEAPON_IMPACT.get(), SoundSource.BLOCKS, 3, 1);
            }
        }
    }

    Random random = new Random();

    public void createCircularLightningParticle(Vec3 vec3, int part, float size) {
        for (int i = 0; i < 360; i++) {
            if (i % part == 0) {
                double d0 = (random.nextFloat() - 0.5F);
                double d1 = (random.nextFloat() - 0.5F);
                double d2 = (random.nextFloat() - 0.5F);
                double dist = 1F + random.nextFloat() * 0.2F;
                double d3 = d0 * dist;
                double d4 = d1 * dist;
                double d5 = d2 * dist;
                if (level().isClientSide) {
                    this.level().addParticle(new LightningParticle.OrbData(240, 103, 21),

                            vec3.x, vec3.y, vec3.z, Mth.sin(i) * size, d4, Mth.cos(i) * size);
                }
            }
        }
    }

    public float chainPitchOld = 0;

    public float axePitchOld = 0;
    public double IK_PX_START = getX();
    public double IK_PY_START = getY() - 0.25;
    public double IK_PZ_START = getZ();

    public double IK_PX = getX();
    public double IK_PY = getY() - 3;
    public double IK_PZ = getZ();

    public Vec3 IK_START() {
        return new Vec3(IK_PX_START, IK_PY_START, IK_PZ_START);
    }

    public double distanceToPoint() {
        return IK_START().distanceTo(IK_Point());
    }

    public Vec3 IK_Point() {
        return new Vec3(IK_PX, IK_PY, IK_PZ);
    }

    public AnimationState getAnimationState(String string) {
        switch (string) {
            case "swing_left" -> {
                return swing;
            }
            default -> {
                return new AnimationState();
            }
        }
    }


    public static void commonTick(Level level, BlockPos pos, BlockState state, SwingingAxeBlockEntity entity) {
        entity.tick();
    }

    public BlockPos getPos() {
        return null;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("tick", tickCount);
        pTag.putFloat("pitch", chainPitchOld);
        pTag.putFloat("axe_pitch", axePitchOld);
        pTag.putDouble("px", IK_PX);
        pTag.putDouble("py", IK_PY);
        pTag.putDouble("pz", IK_PZ);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = super.getUpdateTag();
        compoundTag.putInt("tick", tickCount);
        compoundTag.putFloat("pitch", chainPitchOld);
        compoundTag.putFloat("axe_pitch", axePitchOld);
        compoundTag.putDouble("px", IK_PX);
        compoundTag.putDouble("py", IK_PY);
        compoundTag.putDouble("pz", IK_PZ);
        return compoundTag;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        tickCount = pTag.getInt("tick");
        chainPitchOld = pTag.getFloat("pitch");
        axePitchOld = pTag.getFloat("axe_pitch");
        IK_PX = pTag.getDouble("px");
        IK_PY = pTag.getDouble("py");
        IK_PZ = pTag.getDouble("pz");
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
        // tickCount = 0;
        //  setIK_Point(getX(), getY() - 3, getZ());
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