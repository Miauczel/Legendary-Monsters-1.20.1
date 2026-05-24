package net.miauczel.legendary_monsters.block.custom.SoulCandle;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public abstract class AbstractSoulCandleBlock extends Block {
    public static final int LIGHT_PER_CANDLE = 3;
    public static final BooleanProperty LIT;

    protected AbstractSoulCandleBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState var1) {
        return null;
    }

    public static boolean isLit(BlockState pState) {
        return pState.hasProperty(LIT) && (pState.is(BlockTags.CANDLES) || pState.is(BlockTags.CANDLE_CAKES)) && (Boolean)pState.getValue(LIT);
    }

    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        if (!pLevel.isClientSide && pProjectile.isOnFire() && this.canBeLit(pState)) {
            setLit(pLevel, pState, pHit.getBlockPos(), true);
        }

    }

    protected boolean canBeLit(BlockState pState) {
        return !(Boolean)pState.getValue(LIT);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if ((Boolean)pState.getValue(LIT)) {
            this.getParticleOffsets(pState).forEach((p_220695_) -> addParticlesAndSound(pLevel, p_220695_.add((double)pPos.getX(), (double)pPos.getY(), (double)pPos.getZ()), pRandom));
        }
    }

    private static void addParticlesAndSound(Level pLevel, Vec3 pOffset, RandomSource pRandom) {
        float $$3 = pRandom.nextFloat();
        if ($$3 < 0.3F) {
            pLevel.addParticle(ParticleTypes.SMOKE, pOffset.x, pOffset.y, pOffset.z, (double)0.0F, (double)0.0F, (double)0.0F);
            if ($$3 < 0.17F) {
                pLevel.playLocalSound(pOffset.x + (double)0.5F, pOffset.y + (double)0.5F, pOffset.z + (double)0.5F, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.3F, false);
            }
        }

        pLevel.addParticle(ModParticles.SMALL_SOUL_FIRE_FLAME.get(), pOffset.x, pOffset.y, pOffset.z, (double)0.0F, (double)0.0F, (double)0.0F);
    }

    public static void extinguish(@Nullable Player pPlayer, BlockState pState, LevelAccessor pLevel, BlockPos pPos) {
        setLit(pLevel, pState, pPos, false);
        if (pState.getBlock() instanceof AbstractSoulCandleBlock abstractSoulCandleBlock) {
            abstractSoulCandleBlock.getParticleOffsets(pState).forEach((p_151926_) -> pLevel.addParticle(ParticleTypes.SMOKE, (double)pPos.getX() + p_151926_.x(), (double)pPos.getY() + p_151926_.y(), (double)pPos.getZ() + p_151926_.z(), (double)0.0F, (double)0.1F, (double)0.0F));
        }

        pLevel.playSound((Player)null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
        pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
    }

    private static void setLit(LevelAccessor pLevel, BlockState pState, BlockPos pPos, boolean pLit) {
        pLevel.setBlock(pPos, pState.setValue(LIT, pLit), 11);
    }

    static {
        LIT = BlockStateProperties.LIT;
    }
}
