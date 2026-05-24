package net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity;

import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class IHurtingEntity extends IAnimatedEntity{

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(IHurtingEntity.class, EntityDataSerializers.FLOAT);
    public IHurtingEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final ControlledAnim controlledAnim = new ControlledAnim(disappearTicks());
    public int disappearTicks(){
        return 0;
    }
public void setDamage(float damage){
        entityData.set(DAMAGE,damage);
}
public float getDamage(){
        return entityData.get(DAMAGE);
}
    @Override
    protected void defineSynchedData() {
        entityData.define(DAMAGE,0F);
        super.defineSynchedData();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putFloat("dmg",entityData.get(DAMAGE));
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putFloat("dmg",entityData.get(DAMAGE));
        super.readAdditionalSaveData(pCompound);
    }

}
