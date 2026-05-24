package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;


import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlayerTornado extends Entity {


    public double xPower;
    public double yPower;
    public double zPower;
    private LivingEntity caster;
    private UUID casterUuid;
    private boolean leftOwner;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(PlayerTornado.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TRANSPARENCY  = SynchedEntityData.defineId(PlayerTornado.class, EntityDataSerializers.INT);

    public int maxLife = 20;
    public int lifetick = 0;
    public AnimationState idleAnimationState = new AnimationState();
    public PlayerTornado(EntityType<? extends PlayerTornado> type, Level level) {
        super(type, level);
    }

    public PlayerTornado(EntityType<? extends PlayerTornado> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, Level level,float Yrot) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public PlayerTornado(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage,float Yrot,float Xrot,float life) {
        this(ModEntities.PLAYER_TORNADO.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_,Yrot);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setYRot(Yrot);
        this.setXRot(Xrot);
        maxLife= (int) life;
    }

    public PlayerTornado(EntityType<? extends PlayerTornado> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.5D;
            this.yPower = p_36822_ / d0 * 0.5D;
            this.zPower = p_36823_ / d0 * 0.5D;
        }

    }



    protected void defineSynchedData() {
        this.entityData.define(DAMAGE,0f);
        this.entityData.define(TRANSPARENCY, 0);
    }

    public void setOwner(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public int getTransparency() {
        return this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, trans);
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }
    public void tick() {
        super.tick();
        if (tickCount > 100 && !hasHurt){
            discard();
        }
        if (this.getPassengers() instanceof Player player) {
            if (player.isShiftKeyDown()){
                player.setShiftKeyDown(false);}

        }
        if (this.level().isClientSide) {
            if (tickCount %2 == 0){
                double d0 = this.getX();
                double d1 = this.getY() + 2.0D;
                double d2 = this.getZ();
                //   this.level().addAlwaysVisibleParticle(ModParticles.LB.get(), d0, d1, d2, 0, 0, 0);
            }}
        if (!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }

        if (!this.level().isClientSide) {
            lifetick++;
            setTransparency(this.lifetick);
            if (this.lifetick >= maxLife) {
                this.discard();
            }
        }else{
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }

        HitResult raytraceresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (raytraceresult.getType() != HitResult.Type.MISS) {
            this.onHit(raytraceresult);
        }


        this.checkInsideBlocks();
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        float f = this.getInertia();
       // System.out.println("hasPasssss" + hasHurt);
        ;if (!hasHurt ) {
            this.setDeltaMovement(vec3.add(this.xPower, yPower, this.zPower).scale((double) f));
        }
        this.setPos(d0, d1, d2);

        BlockPos blockPos3 = blockPosition().atY((int) this.getY());
        BlockPos blockPos2 = blockPosition().atY((int) this.getY());
        BlockState blockState2 = level().getBlockState(blockPos2);
        BlockPos blockPos = blockPosition().below();
        BlockState blockState = level().getBlockState(blockPos);
        if (blockState.getBlock() instanceof FireBlock || blockState2.getBlock() instanceof FireBlock) {
            onFire = true;
           // System.out.println("The block is a FireBlock!");
            }
        if (this.getOwner() != null && !this.getOwner().isAlive()) {
            this.discard();
        } else {

            // this.updateMovement();
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(3), EntitySelector.NO_CREATIVE_OR_SPECTATOR)) {
            Vec3 diff = entity.position().subtract(position().add(0, 0, 0));
            diff = diff.normalize().scale(0.095);
            entity.setDeltaMovement(entity.getDeltaMovement().add(0, -2, 0).subtract(diff));
        }
        super.tick();


        if (!this.onFire) {
            if (level().isClientSide()) {
                float spawnPercent = 1.5F;
                float maxY = 1.5F * 1.5f * 1.65F;
                float y = 0.0F;
                float nY = 40.0F * spawnPercent;
                float dY = maxY / nY;
                double posX = this.getX();
                double posY = this.getY();
                double posZ = this.getZ();
                float a = 0.0F;
                float nA = 10.0F;

                for (float dA = 4.3982296F / nA; y < maxY; a += dA) {
                    float radius = y * 0.35F;
                    float cosA = Mth.cos(a) * radius;
                    float sinA = Mth.sin(a) * radius;

                    if ((int) (y / dY) % 2 == 0) {
                        this.level().addParticle(ModParticles.TORNADO.get(), posX + (double) cosA, posY + (double) y - (double) maxY * 0.08, posZ + (double) sinA, 0.0, 0.0, 0.0);
                    }

                    y += dY;
                }
            }
        }else{
            if (level().isClientSide()) {
                float spawnPercent = 1.5F;
                float maxY = 1.5F * spawnPercent * 1.65F;
                float y = 0.0F;
                float nY = 80.0F * spawnPercent;
                float dY = maxY / nY;
                double posX = this.getX();
                double posY = this.getY();
                double posZ = this.getZ();
                float a = 0.0F;
                float nA = 20.0F;

                for (float dA = 4.3982296F / nA; y < maxY; a += dA) {

                    float radius = y * 0.35F;
                    float cosA = Mth.cos(a) * radius;
                    float sinA = Mth.sin(a) * radius;
                    this.level().addParticle(ModParticles.TORNADO_FIRE.get(), posX + (double) cosA, posY + (double) y - (double) maxY * 0.08, posZ + (double) sinA, 0.0, 0.0, 0.0);
                    y += dY;
                }

            }
        }

    }

    public boolean AdjustedLife = false;

    boolean hasHurt = false;
    protected void onHitEntity(EntityHitResult p_37626_) {

        if (!this.level().isClientSide) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            if (entity1 instanceof LivingEntity livingentity) {
                //  entity.hurt(this.damageSources().indirectMagic(entity1, livingentity), this.getDamage());
                this.setDeltaMovement(0.0D, 0.0D, 0.0D);

                hasHurt = true;
                entity.startRiding(this,true);
                if (entity1 instanceof LivingEntity) {
                    //  this.doEnchantDamageEffects((LivingEntity) entity1, entity);
                }
            }

        }
    }

    protected void onHitBlock(BlockHitResult result) {

    }

    @Override
    public void removePassenger(Entity passenger) {
        if (passenger instanceof Player && passenger.isAlive()){
            return;
        }
        if (!passenger.isAlive()) {
            super.removePassenger(passenger);
        }

    }
    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)p_37260_);
            hasHurt = true;
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, p_37260_.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return canHit(p_36842_) && !p_36842_.noPhysics;
    }


    protected boolean canHit(Entity p_37250_) {
        if (!p_37250_.canBeHitByProjectile()) {
            return false;
        } else {
            Entity entity = this.getOwner();
            return entity == null || this.leftOwner || !entity.isPassengerOfSameVehicle(p_37250_);
        }
    }



    protected float getInertia() {
        return 0.85F;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.contains("power", 9)) {
            ListTag listtag = compound.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
        compound.put("power", this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));

    }
    private boolean checkLeftOwner() {
        Entity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.level().getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (p_234613_0_) -> {
                return !p_234613_0_.isSpectator() && p_234613_0_.isPickable();
            })) {
                if (entity1.getRootVehicle() == entity.getRootVehicle()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {

        return false;
    }
    @Override
    public boolean shouldRiderSit() {
        return false;
    }
    public boolean inWater() {
        return false;
    }
    public boolean onFire = false;
    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, 0, this.zPower), 0.0D);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
    }

}
/*
    private int lifeTime = 60;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(SoulStrike.class, EntityDataSerializers.FLOAT);

    public Tornado(@NotNull EntityType<Tornado> type, Level worldIn) {
        super(type, worldIn);
    }

    public Tornado(Level worldIn, double x, double y, double z,float yRot) {
        this(ModEntities.T.get(), worldIn);
        this.setYRot(yRot);
        this.setPos(x, y + 1.5, z);
    }

    public Tornado(Level worldIn, LivingEntity throwerIn) {
        this(ModEntities.T.get(), worldIn);
        this.setOwner(throwerIn);
        this.setDeltaMovement(0.1D, 0D, 0.1D);
    }


    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        Vec3 vector3d = (new Vec3(pX, 2, pZ)) // Ustaw pY na 0, aby uniknąć ruchu w osi Y
                .normalize()
                .add(this.random.nextGaussian() * 0.0075F * pInaccuracy,
                        0, // Usuń losową wartość w osi Y
                        this.random.nextGaussian() * 0.0075F * pInaccuracy)
                .scale(pVelocity);
        this.setDeltaMovement(vector3d);
        double d0 = vector3d.horizontalDistance();
        this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (180F / Math.PI)));
        this.setXRot(0); // Ustaw XRot na 0, aby uniknąć nachylenia w osi Y
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }


    @Override
    public void shootFromRotation(Entity pShooter, float pX, float pY, float pZ, float pVelocity, float pInaccuracy) {
        float f = -Mth.sin(pY * ((float) Math.PI / 180F)) * Mth.cos(pX * ((float) Math.PI / 180F));
        float f1 = -1.0F;// -MathHelper.sin((pX + pZ) * ((float)Math.PI / 180F));
        float f2 = Mth.cos(pY * ((float) Math.PI / 180F)) * Mth.cos(pX * ((float) Math.PI / 180F));
        this.shoot((double) f, (double) f1, (double) f2, pVelocity, pInaccuracy);
        Vec3 vector3d = pShooter.getDeltaMovement();
        this.setDeltaMovement(this.getDeltaMovement().add(vector3d.x, pShooter.onGround() ? 0.0D : vector3d.y, vector3d.z));
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return this.canHitEntity(pEntity);
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    private void positionOnGround(double x, double z, double minY, double maxY, float rotation, int delay) {

        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);

            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            Entity entity1 = this;
            this.setPos(x,blockpos.getY() +d0,z);
        }
    }
    @Override
    public void tick() {

        BlockPos currentPos = this.blockPosition();
        BlockPos forwardPos = currentPos.relative(this.getDirection()); // Pozycja przed encją
        BlockPos abovePos = forwardPos.above(); // Pozycja powyżej przeszkody
        BlockPos belowPos = currentPos.below(); // Pozycja pod encją

        BlockState forwardBlock = level().getBlockState(forwardPos);
        BlockState aboveBlock = level().getBlockState(abovePos);
        BlockState belowBlock = level().getBlockState(belowPos);

        // Jeśli przed nami jest blok, ale powyżej jest puste miejsce -> skaczemy o 1 blok w górę

        for (float f = 0; f <10;f++) {
            positionOnGround(this.getX(), this.getZ(),f );
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        BlockPos blockPos3 = blockPosition().atY((int) this.getY());
        BlockPos blockPos2 = blockPosition().atY((int) this.getY());
        BlockState blockState2 = level().getBlockState(blockPos2); // Use your world instance to get the block state
        BlockPos blockPos = blockPosition().below();
        BlockState blockState = level().getBlockState(blockPos); // Use your world instance to get the block state
        if (blockState.getBlock() instanceof FireBlock || blockState2.getBlock() instanceof FireBlock) {
            // The block at the position is a FireBlock
            onFire = true;
            System.out.println("The block is a FireBlock!");}
        if (this.getOwner() != null && !this.getOwner().isAlive()) {
            this.discard();
        } else {

            // this.updateMovement();
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
        onUpdateInAir();
        super.tick();

        if (!this.onFire) {
            if (level().isClientSide()) {
                float spawnPercent = 1.5F;
                float maxY = 1.5F * 1.5f * 1.65F;
                float y = 0.0F;
                float nY = 40.0F * spawnPercent; // Zmniejszona liczba warstw (wcześniej 80.0F)
                float dY = maxY / nY; // Większy krok wysokości
                double posX = this.getX();
                double posY = this.getY();
                double posZ = this.getZ();
                float a = 0.0F;
                float nA = 10.0F; // Mniejsza liczba punktów na okręgu (wcześniej 20.0F)

                for (float dA = 4.3982296F / nA; y < maxY; a += dA) {
                    float radius = y * 0.35F;
                    float cosA = Mth.cos(a) * radius;
                    float sinA = Mth.sin(a) * radius;

                    // Dodanie cząsteczki co drugi obrót (co zmniejsza liczbę renderowanych cząsteczek)
                    if ((int) (y / dY) % 2 == 0) {
                        this.level().addParticle(ModParticles.TORNADO.get(), posX + (double) cosA, posY + (double) y - (double) maxY * 0.08, posZ + (double) sinA, 0.0, 0.0, 0.0);
                    }

                    y += dY;
                }
            }
        }else{
            if (level().isClientSide()) {
                float spawnPercent = 1.5F;
                float maxY = 1.5F * spawnPercent * 1.65F;
                float y = 0.0F;
                float nY = 80.0F * spawnPercent;
                float dY = maxY / nY;
                double posX = this.getX();
                double posY = this.getY();
                double posZ = this.getZ();
                float a = 0.0F;
                float nA = 20.0F;

                for (float dA = 4.3982296F / nA; y < maxY; a += dA) {

                    float radius = y * 0.35F;
                    float cosA = Mth.cos(a) * radius;
                    float sinA = Mth.sin(a) * radius;
                    this.level().addParticle(ModParticles.TORNADO_FIRE.get(), posX + (double) cosA, posY + (double) y - (double) maxY * 0.08, posZ + (double) sinA, 0.0, 0.0, 0.0);
                    y += dY;
                }

            }
        }

        super.tick();
    }
    @Override
    public boolean shouldRiderSit() {
        return false;
    }
    public boolean inWater() {
        return false;
    }
    public boolean onFire = false;

    @Override
    protected boolean canHitEntity(Entity pTarget) {
        // Sprawdź, czy encja nie jest innym Tornado, GolemCloud, pasażerem, ani właścicielem
        if (!(pTarget instanceof Tornado) && !(pTarget instanceof Cloud_GolemEntity) && !pTarget.isPassenger()) {
            if (!AdjustedLife) {
                lifeTime = 140;
            }

            // Sprawdź, czy cel znajduje się w hitboxie encji (uwzględnij ruch w osi Y)
            if (pTarget.getBoundingBox().intersects(this.getBoundingBox())) {
                return true;
            }

            return false;
        }

        return super.canHitEntity(pTarget) && pTarget != this.getOwner();
    }


    public boolean isOnFire() {
        return false;
    }
    private void onUpdateInAir() {
        this.lifeTime -= 1;

        if (this.lifeTime <= 0) {
            this.discard();
        }
        BlockPos pos = BlockPos.containing(this.getX(), this.getY(), this.getZ());
        BlockState iblockstate = this.level().getBlockState(pos);
        Entity entity1 = this.getOwner();
        LivingEntity livingonwer = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
        List<LivingEntity> entities = new ArrayList<>(this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5, 4, 0.5),EntitySelector.NO_CREATIVE_OR_SPECTATOR));
        for (LivingEntity livingentity : entities) {
            if (this.getOwner() != null) {
                if (this.tickCount % 5 == 0) {
                    if (livingentity != this.getOwner()  && !this.getOwner().isAlliedTo(livingentity) && livingentity.isAlive()) {

                        livingentity.startRiding(this);
                        livingentity.setPos(this.getX(), this.getY()+3, this.getZ());
                        this.setDeltaMovement(0.0D, 0.0D, 0.0D);
                        if (this.onFire){
                            livingentity.setRemainingFireTicks(60);
                        }

                        if (!AdjustedLife){
                            if (livingonwer instanceof Mob){
                                if (((Mob) livingonwer).getTarget() !=null){
                                    int m = (int) (((Mob) livingonwer).getTarget().getMaxHealth()*0.07);
                                    if (livingentity instanceof Player player){

                                        if (player.isShiftKeyDown()) {
                                            player.setShiftKeyDown(false);
                                        }
                                        if (!livingentity.isBlocking()){

                                            if(livingentity.hurt(damageSources().mobProjectile(this, livingonwer), 15 +m)) {
                                            }
                                        }
                                    }else {
                                        if(livingentity.hurt(damageSources().mobProjectile(this, livingonwer), 15 +m)) {}}
                                }
                            }

                            AdjustedLife = true;
                        }
                        // if(livingentity.hurt(damageSources().mobProjectile(this, livingonwer), this.getDamage())) {
                        //   }


                    }
                }
            }
        }


    }



    public boolean AdjustedLife = false;
    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE,0f);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


}*/