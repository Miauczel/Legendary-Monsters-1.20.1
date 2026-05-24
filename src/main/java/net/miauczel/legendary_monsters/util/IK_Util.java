package net.miauczel.legendary_monsters.util;

import net.miauczel.legendary_monsters.block.blockentity.SwingingAxeBlockEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

import static java.lang.Math.*;

public class IK_Util {
    // 2 Bone IK
    public static void solve2BoneIK(ModelPart hipBone, ModelPart kneeBone, Vec3 hipPos, Vec3 endPos,
                                    float hipLength, float kneeLength,
                                    float addHipXRot, float addKneeXRot,
                                    float addHipYRot, float addKneeYRot,
                                    boolean swapAxes) {
        Vec3 dif = endPos.subtract(hipPos);
        double b = hipPos.distanceTo(endPos);
        double a = kneeLength;
        double c = hipLength;

        double swappedAxis = swapAxes ? PI / 2 : 0;
        double theta = Mth.atan2(dif.z, dif.x) + swappedAxis;

        double phiAcosTop = pow(b, 2) + pow(c, 2) - pow(a, 2);
        double phiAcosBottom = 2 * b * c;
        double phiDif = Mth.clamp(phiAcosTop / phiAcosBottom, -1, 1);
        double phi = acos(phiDif);

        double atanBottom = sqrt(pow(dif.x, 2) + pow(dif.z, 2));
        double atan = Mth.atan2(dif.y, atanBottom);

        hipBone.yRot = (float) (addHipYRot + theta);

        float targetPitch = (float) (addHipXRot + phi + atan);
        hipBone.xRot = Mth.clamp(targetPitch, -1.57f, 1.57f);

        double gammaAcosTop = pow(a, 2) + pow(c, 2) - pow(b, 2);
        double gammaAcosBottom = 2 * a * c;
        double gammaDif = Mth.clamp(gammaAcosTop / gammaAcosBottom, -1, 1);
        double gammaAcos = acos(gammaDif);
        double gamma = PI - gammaAcos;

        kneeBone.yRot = (float) (addKneeYRot + theta);
        kneeBone.xRot = addKneeXRot + (float) gamma;
    }
}
