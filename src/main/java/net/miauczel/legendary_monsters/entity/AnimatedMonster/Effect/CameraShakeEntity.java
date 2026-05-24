package net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class CameraShakeEntity extends Entity {
    private static final EntityDataAccessor<Float> RADIUS;
    private static final EntityDataAccessor<Float> STRENGHT;
    private static final EntityDataAccessor<Integer> LASTSFORTICKS;
    private static final EntityDataAccessor<Integer> FADE_DURATION_IN_TICKS;

    public CameraShakeEntity(EntityType<?> type, Level world) {
        super(type, world);
    }

    public CameraShakeEntity(Level world, Vec3 position, float radius, float strenght, int duration, int fadeDuration) {
        super((EntityType) ModEntities.CAMERA_SHAKE.get(), world);
        this.setRadius(radius);
        this.setStrenght(strenght);
        this.setDuration(duration);
        this.setFadeDuration(fadeDuration);
        this.setPos(position.x, position.y, position.z);
    }

    @OnlyIn(Dist.CLIENT)
    public float getShakeAmount(Player player, float delta) {
        float ticksDelta = (float) this.tickCount + delta;
        float timeFrac = 1.0F - (ticksDelta - (float) this.getDuration()) / ((float) this.getFadeDuration() + 1.0F);
        float baseAmount = ticksDelta < (float) this.getDuration() ? this.getStrenght() : timeFrac * timeFrac * this.getStrenght();
        Vec3 playerPos = player.getPosition(delta);
        float distFrac = (float) (1.0 - Mth.clamp(this.position().distanceTo(playerPos) / (double) this.getRadius(), 0.0, 1.0));
        return baseAmount * distFrac * distFrac;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > this.getDuration() + this.getFadeDuration()) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(RADIUS, 10.0F);
        this.entityData.define(STRENGHT, 1.0F);
        this.entityData.define(LASTSFORTICKS, 0);
        this.entityData.define(FADE_DURATION_IN_TICKS, 5);
    }

    public float getRadius() {
        return this.entityData.get(RADIUS);
    }

    public void setRadius(float radius) {
        this.entityData.set(RADIUS, radius);
    }

    public float getStrenght() {
        return this.entityData.get(STRENGHT);
    }

    public void setStrenght(float strenght) {
        this.entityData.set(STRENGHT, strenght);
    }

    public int getDuration() {
        return this.entityData.get(LASTSFORTICKS);
    }

    public void setDuration(int duration) {
        this.entityData.set(LASTSFORTICKS, duration);
    }

    public int getFadeDuration() {
        return this.entityData.get(FADE_DURATION_IN_TICKS);
    }

    public void setFadeDuration(int fadeDuration) {
        this.entityData.set(FADE_DURATION_IN_TICKS, fadeDuration);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setRadius(compound.getFloat("radius"));
        this.setStrenght(compound.getFloat("strenght"));
        this.setDuration(compound.getInt("duration"));
        this.setFadeDuration(compound.getInt("fade_duration"));
        this.tickCount = compound.getInt("ticks_existed");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("radius", this.getRadius());
        compound.putFloat("strenght", this.getStrenght());
        compound.putInt("duration", this.getDuration());
        compound.putInt("fade_duration", this.getFadeDuration());
        compound.putInt("ticks_existed", this.tickCount);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static void cameraShake(Level world, Vec3 position, float radius, float strenght, int duration, int fadeDuration) {
        if (!world.isClientSide) {
            if (ModConfig.MOB_CONFIG.allowCameraShake.get()) {
                CameraShakeEntity cameraShake = new CameraShakeEntity(world, position, radius, strenght, duration, fadeDuration);
                world.addFreshEntity(cameraShake);
            }
        }
    }

    static {
        RADIUS = SynchedEntityData.defineId(CameraShakeEntity.class, EntityDataSerializers.FLOAT);
        STRENGHT = SynchedEntityData.defineId(CameraShakeEntity.class, EntityDataSerializers.FLOAT);
        LASTSFORTICKS = SynchedEntityData.defineId(CameraShakeEntity.class, EntityDataSerializers.INT);
        FADE_DURATION_IN_TICKS = SynchedEntityData.defineId(CameraShakeEntity.class, EntityDataSerializers.INT);
    }
}
