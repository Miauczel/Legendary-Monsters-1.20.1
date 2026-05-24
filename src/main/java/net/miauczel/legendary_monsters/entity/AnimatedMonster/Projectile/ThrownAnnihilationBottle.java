package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class ThrownAnnihilationBottle extends ThrowableItemProjectile implements ItemSupplier {
    public ThrownAnnihilationBottle(EntityType<? extends ThrownAnnihilationBottle> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownAnnihilationBottle(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.BOTTLE_OF_ANNIHILATION.get(), pShooter, pLevel);
    }

    public ThrownAnnihilationBottle(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.BOTTLE_OF_ANNIHILATION.get(), pX, pY, pZ, pLevel);
    }

    protected Item getDefaultItem() {
        return ModItems.BOTTLE_OF_ANNIHILATION.get();
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravity() {
        return 0.05F;
    }

    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            ItemStack itemstack = this.getItem();
            Potion potion = PotionUtils.getPotion(itemstack);
            List<MobEffectInstance> list = PotionUtils.getMobEffects(itemstack);
            boolean flag = potion == Potions.WATER && list.isEmpty();
            Direction direction = pResult.getDirection();
            BlockPos blockpos = pResult.getBlockPos();
            BlockPos blockpos1 = blockpos.relative(direction);
            if (flag) {
                this.dowseFire(blockpos1);
                this.dowseFire(blockpos1.relative(direction.getOpposite()));

                for(Direction direction1 : Direction.Plane.HORIZONTAL) {
                    this.dowseFire(blockpos1.relative(direction1));
                }
            }

        }
    }
    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);



        if (!this.level().isClientSide) {
            playSound(SoundEvents.SPLASH_POTION_BREAK,1,1);
            if (level() instanceof ServerLevel level) {
                level.sendParticles(ModParticles.ANNIHILATION_FLAME_STRIKE.get(), getX(), getY() + 2, getZ(), 1, 0, 0, 0, 0);
            }
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        entity.setSecondsOnFire(5);
        entity.hurt(ModDamageTypes.causeAnnihilationDamage(getOwner(), (LivingEntity) getOwner()),1);
        super.onHitEntity(pResult);
    }

    private void dowseFire(BlockPos pPos) {
        BlockState blockstate = this.level().getBlockState(pPos);
        if (blockstate.is(BlockTags.FIRE)) {
            this.level().removeBlock(pPos, false);
        } else if (AbstractCandleBlock.isLit(blockstate)) {
            AbstractCandleBlock.extinguish((Player)null, blockstate, this.level(), pPos);
        } else if (CampfireBlock.isLitCampfire(blockstate)) {
            this.level().levelEvent((Player)null, 1009, pPos, 0);
            CampfireBlock.dowse(this.getOwner(), this.level(), pPos, blockstate);
            this.level().setBlockAndUpdate(pPos, blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false)));
        }

    }

}
