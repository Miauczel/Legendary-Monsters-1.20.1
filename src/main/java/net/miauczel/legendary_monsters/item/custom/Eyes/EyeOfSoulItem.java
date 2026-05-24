package net.miauczel.legendary_monsters.item.custom.Eyes;

import net.miauczel.legendary_monsters.tag.ModStructureTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class EyeOfSoulItem extends Item {
    public EyeOfSoulItem(Properties pProperties) {
        super(pProperties);
    }

    /**
     * Called when this item is used when targeting a Block
     */
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.is(Blocks.END_PORTAL_FRAME) && !(Boolean)state.getValue(EndPortalFrameBlock.HAS_EYE)) {
            if (world.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                /** BlockState newState = (BlockState)state.setValue(EndPortalFrameBlock.HAS_EYE, true);
                Block.pushEntitiesUp(state, newState, world, pos);
                world.setBlock(pos, newState, 2);
                world.updateNeighbourForOutputSignal(pos, Blocks.END_PORTAL_FRAME);
                pContext.getItemInHand().shrink(1);
                 */
                world.levelEvent(1503, pos, 0);
                BlockPattern.BlockPatternMatch portalShape = EndPortalFrameBlock.getOrCreatePortalShape().find(world, pos);
                if (portalShape != null) {
                    BlockPos portalPos = portalShape.getFrontTopLeft().offset(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            world.setBlock(portalPos.offset(i, 0, j), Blocks.END_PORTAL.defaultBlockState(), 2);
                        }
                    }

                    world.globalLevelEvent(1038, portalPos.offset(1, 0, 1), 0);
                }

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE);
        if (hitResult.getType() == HitResult.Type.BLOCK && world.getBlockState(hitResult.getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
            return InteractionResultHolder.pass(stack);
        } else {
            player.startUsingItem(hand);
            if (world instanceof ServerLevel) {
                ServerLevel serverWorld = (ServerLevel)world;
                BlockPos eyePos = serverWorld.findNearestMapStructure(ModStructureTags.SOUL_FORTRESS_REMAINS_EYE_LOCATED, player.blockPosition(), 100, false);
                if (eyePos != null) {
                    EyeOfEnder eyeOfEnder = new EyeOfEnder(serverWorld, player.getX(), player.getY(0.5), player.getZ());
                    eyeOfEnder.setItem(stack);
                    eyeOfEnder.signalTo(eyePos);
                    world.gameEvent(GameEvent.PROJECTILE_SHOOT, eyeOfEnder.position(), GameEvent.Context.of(player));
                    world.addFreshEntity(eyeOfEnder);
                    if (player instanceof ServerPlayer) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayer)player, eyePos);
                    }

                    world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                    world.levelEvent((Player)null, 1003, player.blockPosition(), 0);
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.swing(hand, true);
                    return InteractionResultHolder.success(stack);
                }
            }

            return InteractionResultHolder.consume(stack);
        }
    }
}
