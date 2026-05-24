package net.miauczel.legendary_monsters.entity.ai;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LMFallingBlockEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class BigCannonAttackGoal extends MeleeAttackGoal {

    private final DuneSentinelEntity entity;
    private int attackDelay = 16;
    private int ticksUntilNextAttack = 16;
    private boolean shouldCountTillNextAttack = false;
    private boolean hasPlayedAttackSound = false;
    public BigCannonAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((DuneSentinelEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 9;
        ticksUntilNextAttack = 9;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation() && !hasPlayedAttackSound) {
                SoundEvent customAttackSound = ModSounds.FATAL_MORTAR_ATTACK.get(); // Użyj gettera do uzyskania dźwięku
               this.mob.level().playSound(null, this.mob.blockPosition(), customAttackSound, SoundSource.NEUTRAL, 1.0f, 1.0f);
                entity.setAttacking(true);
                hasPlayedAttackSound = true;


            }


            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                hasPlayedAttackSound = false;
                performAttack(pEnemy);

            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 5;
            hasPlayedAttackSound = false;
        }

    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= 3.5 * 3.5;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    private void spawnFangsInPatterns(int count, double radius, double minY, double maxY, int delay) {
        for (int k = 0; k < count; k++) {
            float angle = (float) k * (float) Math.PI * 2.0F / (float) count;
            spawnFangs(this.mob.getX() + Mth.cos(angle) * radius, this.mob.getZ() + Mth.sin(angle) * radius, minY, maxY, angle, delay);
        }
    }

    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double yOffset = 0.0;

        do {
            BlockPos belowPos = blockpos.below();
            BlockState blockstate = this.mob.level().getBlockState(belowPos);
            if (blockstate.isFaceSturdy(this.mob.level(), belowPos, Direction.UP)) {
                if (!this.mob.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.mob.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.mob.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        yOffset = voxelshape.max(Direction.Axis.Y);
                    }
                }
                flag = true;
                break;
            }
            blockpos = blockpos.below();

        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            BlockPos pos = new BlockPos((int) this.mob.getX(), (int) this.mob.getY(), (int) this.mob.getZ());
            BlockState blockState = this.mob.level().getBlockState(pos);
            this.mob.level().addParticle(ParticleTypes.SWEEP_ATTACK, x, blockpos.getY() + yOffset , z , 0.0, 0.0, 0.0);
            LMFallingBlockEntity fallingBlockEntity = new LMFallingBlockEntity(
                    this.mob.level(), this.mob.getX() + 0.5, this.mob.getY() + 1.0, this.mob.getZ()+ 0.5, blockState, 10
            );
            fallingBlockEntity.setDeltaMovement(0.0, 0.2 + this.mob.getRandom().nextDouble() * 0.15, 0.0);
            this.mob.level().addFreshEntity(fallingBlockEntity);
            // this.level().addFreshEntity(new Void_Rune_Entity(this.level(), x, blockpos.getY() + yOffset, z, rotation, delay, owner));
        }
    }
    protected void performAttack(LivingEntity pEnemy) {

entity.performAreaAttack();
            this.resetAttackCooldown();
           // this.mob.swing(InteractionHand.MAIN_HAND);
           // this.mob.doHurtTarget(pEnemy);
        entity.attackTargets(pEnemy);
            entity.ResetShootCooldown();
            entity.ResetShootAnimCooldown();
            if (!pEnemy.onGround()) {
                //System.out.println("Player is not on ground");
                double knockbackRadius = 5.0;
                List<Entity> nearbyEntities = this.mob.level().getEntities(this.mob, this.mob.getBoundingBox().inflate(knockbackRadius), e -> e instanceof LivingEntity && e != this.mob);
                for (Entity target : nearbyEntities) {
                    double dx = target.getX() - this.mob.getX();
                    double dz = target.getZ() - this.mob.getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    double knockbackStrength = 0.5 + 0.25 * (knockbackRadius - distance);
                    target.push(dx / distance * knockbackStrength, 0.3, dz / distance * knockbackStrength);
                }
            } else {
               // System.out.println("Player is on ground");
                double knockbackRadius = 5.0;
                List<Entity> nearbyEntities = this.mob.level().getEntities(this.mob, this.mob.getBoundingBox().inflate(knockbackRadius), e -> e instanceof LivingEntity && e != this.mob);
                for (Entity target : nearbyEntities) {
                    double dx = target.getX() - this.mob.getX();
                    double dz = target.getZ() - this.mob.getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    double knockbackStrength = 1.0 + 0.5 * (knockbackRadius - distance);
                    target.push(dx / distance * knockbackStrength, 0.4, dz / distance * knockbackStrength);
                }
            }
            Level level = this.mob.level();


                    int standingOnY = Mth.floor(this.mob.getY());
                    spawnFangsInPatterns(6, 2.5, standingOnY, 1.0, 0);
                    spawnFangsInPatterns(11, 3.5, standingOnY, 1.0, 2);
                    spawnFangsInPatterns(14, 4.5, standingOnY, 1.0, 4);
                    spawnFangsInPatterns(19, 5.5, standingOnY, 1.0, 6);
                    spawnFangsInPatterns(26, 6.5, standingOnY, 1.0, 8);



            if (!this.mob.getTarget().isBlocking()) {


            }


            if (pEnemy instanceof Player) {
                Player player = (Player) pEnemy;

                if (player.isBlocking() && (player.getMainHandItem().getItem() instanceof ShieldItem || player.getOffhandItem().getItem() instanceof ShieldItem)) {
                    Item shieldItem = player.getMainHandItem().getItem() instanceof ShieldItem ?
                            player.getMainHandItem().getItem() :
                            player.getOffhandItem().getItem();

                    if (!player.getCooldowns().isOnCooldown(shieldItem)) {
                        player.getCooldowns().addCooldown(shieldItem, 40);

                        if (player.isBlocking()) {
                            player.stopUsingItem();
                        }
                    }
                }

            }

    }
    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

   @Override
    public void stop() {
       entity.setAttacking(false);
       entity.setShooting(false);
       super.stop();
       hasPlayedAttackSound = false;

    }


}