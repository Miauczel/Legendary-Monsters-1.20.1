package net.miauczel.legendary_monsters.entity.AnimatedMonster.PartEntity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.entity.PartEntity;

import javax.annotation.Nullable;

public class WitheredAbominationPartEntity extends PartEntity<Withered_AbominationEntity> {
    public final Withered_AbominationEntity parentMob;
    public final String name;
    private final EntityDimensions size;

    public WitheredAbominationPartEntity(Withered_AbominationEntity parentMob, String name, float width, float height) {
        super(parentMob);
        this.size = EntityDimensions.scalable(width, height);
        this.refreshDimensions();
        this.parentMob = parentMob;
        this.name = name;
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        return this.parentMob.getPickResult();
    }


    @Override
    public boolean is(Entity entity) {
        return this == entity || this.parentMob == entity;
    }



    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return this.size;
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }
}
