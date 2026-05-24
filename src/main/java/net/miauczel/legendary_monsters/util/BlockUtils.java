package net.miauczel.legendary_monsters.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class BlockUtils {
    public static BlockPos blockPosVec3(Vec3 vec3){
        return new BlockPos((int) vec3.x, (int) vec3.y, (int) vec3.z);
    }
}
