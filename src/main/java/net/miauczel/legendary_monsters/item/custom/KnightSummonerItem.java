package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.IAnimatedTamableMob;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.List;
import java.util.function.Supplier;

public class KnightSummonerItem  extends Item {
    public KnightSummonerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getDamage(ItemStack stack) {
        return 1;
    }
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!(level instanceof ServerLevel serverLevel)) {
            return InteractionResult.SUCCESS;
        }

        ItemStack itemstack = pContext.getItemInHand();
        BlockPos blockpos = pContext.getClickedPos();
        Direction direction = pContext.getClickedFace();
        BlockState blockstate = level.getBlockState(blockpos);

        BlockPos spawnPos = blockstate.getCollisionShape(level, blockpos).isEmpty()
                ? blockpos
                : blockpos.relative(direction);

        EntityType<?> entitytype = ModEntities.Knights_Armor.get();

        Entity entity = entitytype.spawn(serverLevel, itemstack, pContext.getPlayer(), spawnPos,
                MobSpawnType.SPAWN_EGG, true,
                !blockpos.equals(spawnPos) && direction == Direction.UP);

        if (entity instanceof IAnimatedTamableMob ownable && pContext.getPlayer() != null) {
            Player entityPlayer = pContext.getPlayer();
            ownable.setOwnerUUID(entityPlayer.getUUID());
            ownable.setTame(true);
            ownable.tame(entityPlayer);
        }

        if (entity != null) {
            itemstack.shrink(1);
            level.gameEvent(pContext.getPlayer(), GameEvent.ENTITY_PLACE, spawnPos);
        }

        return InteractionResult.CONSUME;
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.knight_summoner1"));
        list.add(Component.translatable("item.legendary_monsters.knight_summoner2"));
        list.add(Component.translatable("item.legendary_monsters.knight_summoner3"));
        list.add(Component.translatable("item.legendary_monsters.knight_summoner4"));

        list.add(Component.translatable("item.legendary_monsters.knight_summoner5"));
    }
}
