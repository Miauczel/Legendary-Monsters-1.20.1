package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.IAnimatedEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IAnimatedPathfinderMob extends PathfinderMob {
    public static final EntityDataAccessor<Integer> ANIMATIONSTATE = SynchedEntityData.defineId(IAnimatedEntity.class, EntityDataSerializers.INT);
    public IAnimatedPathfinderMob(EntityType<?> pEntityType, Level pLevel) {
        super((EntityType<? extends PathfinderMob>) pEntityType, pLevel);
    }
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {

        if (id <= 1){
            AnimationTicks = 0;

        }else {
            super.handleEntityEvent(id);
        }
    }

    public int AnimationTicks = 0;
    public int getAnimationState(){
        return entityData.get(ANIMATIONSTATE);
    }
    public void setAnimationState(int Animation){
        AnimationTicks = 0;
        entityData.set(ANIMATIONSTATE,Animation);
    }

    @Override
    public void tick() {
        super.tick();
        if (getAnimationState() >0){
            AnimationTicks++;
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(ANIMATIONSTATE,0);
    }


}
