package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ShulkerMimicPart extends PartEntity<Shulker_MimicEntity> {
    public final Shulker_MimicEntity parentMob;
    public final String name;
    private final EntityDimensions size;

    public ShulkerMimicPart(Shulker_MimicEntity pParentMob, String pName, float pWidth, float pHeight) {
        super(pParentMob);
        this.size = EntityDimensions.scalable(pWidth, pHeight);
        this.refreshDimensions();
        this.parentMob = pParentMob;
        this.name = pName;
    }

    protected void defineSynchedData() {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
    }

    /**
     * Returns {@code true} if other Entities should be prevented from moving through this Entity.
     */
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean isAttackable() {
        return super.isAttackable();
    }

    @Nullable
    public ItemStack getPickResult() {
        return this.parentMob.getPickResult();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean hurt(@NotNull DamageSource pSource, float pAmount) {
       // LivingEntity entity = (LivingEntity) pSource.getEntity();

        return !this.isInvulnerableTo(pSource) && parentMob.applyPartDamage(this,pSource, pAmount);
    }

    /**
     * Returns {@code true} if Entity argument is equal to this Entity
     */
    public boolean is(@NotNull Entity pEntity) {
        return this == pEntity || this.parentMob == pEntity;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    public EntityDimensions getDimensions(Pose pPose) {
        return this.size;
    }

    public boolean shouldBeSaved() {
        return false;
    }
}
