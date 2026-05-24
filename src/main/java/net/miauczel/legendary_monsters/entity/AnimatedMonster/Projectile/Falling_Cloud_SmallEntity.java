package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class Falling_Cloud_SmallEntity extends AbstractArrow implements ItemSupplier {

    public Falling_Cloud_SmallEntity(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.FALLING_CLOUD_SMALL.get(), world);
    }

    public Falling_Cloud_SmallEntity(EntityType<? extends Falling_Cloud_SmallEntity> type, Level world) {
        super(type, world);
    }

    public Falling_Cloud_SmallEntity(EntityType<? extends Falling_Cloud_SmallEntity> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public Falling_Cloud_SmallEntity(EntityType<? extends Falling_Cloud_SmallEntity> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }


    public Falling_Cloud_SmallEntity(Level world) {
        super(ModEntities.FALLING_CLOUD_SMALL.get(), world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(ModItems.FALLING_CLOUD_SMALL_PROJECTILE.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.FALLING_CLOUD_SMALL_PROJECTILE.get());
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        //super.doPostHurtEffects(entity);

    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        BlockPos blockPos = blockHitResult.getBlockPos();
        Vec3 entityPosition = this.position();
        CameraShakeEntity.cameraShake(this.level(), entityPosition, 5.0F, 0.1F, 0, 10);

    }
    @Override
    public void onHitEntity(EntityHitResult entityHitResult) {
    //   super.onHitEntity(entityHitResult);
        this.discard();
        BlockPos blockPos = entityHitResult.getEntity().blockPosition();
        Vec3 entityPosition = this.position();
        CameraShakeEntity.cameraShake(this.level(), entityPosition, 5.0F, 0.1F, 0, 10);

    }


    @Override
    public void tick() {
        super.tick();
        if (this.inGround)
            this.discard();
    }

    public static Falling_Cloud_SmallEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        Falling_Cloud_SmallEntity entityarrow = new Falling_Cloud_SmallEntity(ModEntities.FALLING_CLOUD_SMALL.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(true);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), net.minecraftforge.registries.ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static Falling_Cloud_SmallEntity shoot(LivingEntity entity, LivingEntity target) {
        Falling_Cloud_SmallEntity entityarrow = new Falling_Cloud_SmallEntity(ModEntities.FALLING_CLOUD_SMALL.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5);
        entityarrow.setKnockback(1);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), net.minecraftforge.registries.ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.PLAYERS, 1,
                1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}
