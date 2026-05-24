package net.miauczel.legendary_monsters.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class IBlockEntity extends BlockEntity {
    public IBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public Level level() {
        return level != null ? level : null;
    }
    public Vec3 getCenter = worldPosition.getCenter();

    public double getX() {
        return getCenter.x;
    }

    public double getY() {
        return getCenter.y;
    }

    public double getZ() {
        return getCenter.z;
    }

}
