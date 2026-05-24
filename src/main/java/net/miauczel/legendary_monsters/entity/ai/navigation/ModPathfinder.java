package net.miauczel.legendary_monsters.entity.ai.navigation;

import net.minecraft.world.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModPathfinder extends PathFinder {
    public ModPathfinder(NodeEvaluator processor, int maxVisitedNodes) {
        super(processor, maxVisitedNodes);
    }

    @Nullable
    public Path findPath(PathNavigationRegion region, Mob mob, Set<BlockPos> targetPositions, float maxRange, int accuracy, float searchDepthMultiplier) {
        Path path = super.findPath(region, mob, targetPositions, maxRange, accuracy, searchDepthMultiplier);
        return path == null ? null : new ModPathfinder.PatchedPath(path, mob.blockPosition(), false);
    }

    static class PatchedPath extends Path {
        public PatchedPath(Path original, BlockPos target, boolean reachesTarget) {
            super(copyPathPoints(original), target, reachesTarget);
        }

        public Vec3 getPosition(Entity entity, int index) {
            Node point = this.getNode(index);
            double x = (double)point.x + (double)Mth.clamp(entity.getBbWidth() + 1.0F, 0.0F, 1.0F) * 0.5;
            double y = (double)point.y;
            double z = (double)point.z + (double)Mth.clamp(entity.getBbWidth() + 1.0F, 0.0F, 1.0F) * 0.5;
            return new Vec3(x, y, z);
        }

        private static List<Node> copyPathPoints(Path original) {
            List<Node> points = new ArrayList<>();

            for (int i = 0; i < original.getNodeCount(); i++) {
                points.add(original.getNode(i));
            }

            return points;
        }
    }
}
