package net.miauczel.legendary_monsters.entity.ai.navigation;

import java.util.Objects;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;

public class ModPathNavigation extends GroundPathNavigation {


    public ModPathNavigation(Mob mob, Level world) {
        super(mob, world);
    }

    @Override
    protected PathFinder createPathFinder(int maxVisitedNodes) {
        this.nodeEvaluator = new WalkNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        return new ModPathfinder(this.nodeEvaluator, maxVisitedNodes);
    }

    @Override
    protected void followThePath() {
        Path path = Objects.requireNonNull(this.path);
        Vec3 entityPos = this.getTempMobPos();
        int pathLength = path.getNodeCount();

        for (int i = path.getNextNodeIndex(); i < path.getNodeCount(); i++) {
            if ((double)path.getNode(i).y != Math.floor(entityPos.y)) {
                pathLength = i;
                break;
            }
        }


        Vec3 base = entityPos.add(-this.mob.getBbWidth() * 0.5F, 0.0, -this.mob.getBbWidth() * 0.5F);
        Vec3 max = base.add(this.mob.getBbWidth(), this.mob.getBbHeight(), this.mob.getBbWidth());
        if (this.tryShortcut(path, new Vec3(this.mob.getX(), this.mob.getY(), this.mob.getZ()), pathLength, base, max)
                && (this.isAt(path, 0.5F) || this.atElevationChange(path) && this.isAt(path, this.mob.getBbWidth() * 0.5F))) {
            path.setNextNodeIndex(path.getNextNodeIndex() + 1);
        }

    this.mob.moveTo(entityPos.x, entityPos.y, entityPos.z, this.mob.getYRot(), this.mob.getXRot());

    }

    private boolean isAt(Path path, float threshold) {
        Vec3 pathPos = path.getNextEntityPos(this.mob);
        return Math.abs(this.mob.getX() - pathPos.x) < threshold
                && Math.abs(this.mob.getZ() - pathPos.z) < threshold
                && Math.abs(this.mob.getY() - pathPos.y) < 1.0;
    }

    private boolean atElevationChange(Path path) {
        int curr = path.getNextNodeIndex();
        int end = Math.min(path.getNodeCount(), curr + Mth.ceil(this.mob.getBbWidth() * 0.5F) + 1);
        int currY = path.getNode(curr).y;

        for (int i = curr + 1; i < end; i++) {
            if (path.getNode(i).y != currY) {
                return true;
            }
        }

        return false;
    }

    private boolean tryShortcut(Path path, Vec3 entityPos, int pathLength, Vec3 base, Vec3 max) {
        int i = pathLength;

        while (--i > path.getNextNodeIndex()) {
            Vec3 vec = path.getEntityPosAtNode(this.mob, i).subtract(entityPos);
            if (this.sweep(vec, base, max)) {
                path.setNextNodeIndex(i);
                return false;
            }
        }

        return true;
    }

    private boolean sweep(Vec3 vec, Vec3 base, Vec3 max) {
        float t = 0.0F;
        float max_t = (float)vec.length();
        if (max_t < 1.0E-8F) {
            return true;
        } else {
            float[] tr = new float[3];
            int[] ldi = new int[3];
            int[] tri = new int[3];
            int[] step = new int[3];
            float[] tDelta = new float[3];
            float[] tNext = new float[3];
            float[] normed = new float[3];

            for (int i = 0; i < 3; i++) {
                float value = element(vec, i);
                boolean dir = value >= 0.0F;
                step[i] = dir ? 1 : -1;
                float lead = element(dir ? max : base, i);
                tr[i] = element(dir ? base : max, i);
                ldi[i] = leadEdgeToInt(lead, step[i]);
                tri[i] = trailEdgeToInt(tr[i], step[i]);
                normed[i] = value / max_t;
                tDelta[i] = Mth.abs(max_t / value);
                float dist = dir ? (float)(ldi[i] + 1) - lead : lead - (float)ldi[i];
                tNext[i] = tDelta[i] < Float.POSITIVE_INFINITY ? tDelta[i] * dist : Float.POSITIVE_INFINITY;
            }

            return true;
        }
    }


    protected boolean canUpdatePath(BlockPathTypes pathType) {
        if (pathType == BlockPathTypes.WATER) {
            return false;
        } else {
            return pathType != BlockPathTypes.LAVA && pathType != BlockPathTypes.OPEN;
        }
    }

    static int leadEdgeToInt(float coord, int step) {
        return Mth.floor(coord - (float)step * 1.0E-8F);
    }

    static int trailEdgeToInt(float coord, int step) {
        return Mth.floor(coord + (float)step * 1.0E-8F);
    }

    static float element(Vec3 v, int i) {
        switch (i) {
            case 0:
                return (float)v.x;
            case 1:
                return (float)v.y;
            case 2:
                return (float)v.z;
            default:
                return 0.0F;
        }
    }
}
