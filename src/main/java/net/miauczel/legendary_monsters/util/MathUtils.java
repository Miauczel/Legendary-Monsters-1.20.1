package net.miauczel.legendary_monsters.util;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

public class MathUtils {
    public static final float TAU = 6.2831855F;
    public static final float PI = 3.1415927F;

    public MathUtils() {
    }

    public static float entityBasedHpDamage(LivingEntity entity, float precentage) {
        return (float) (entity.getMaxHealth() * (precentage * 0.01));
    }


    public static float percentValue(float value, float percentage) {
        return (float) (value * (percentage * 0.01));
    }

    public static int toTicks(float seconds) {
        return (int) (seconds * 20);
    }

    public static float toPercent(float precentage) {
        return (float) (precentage * 0.01);
    }

    public static Vec3 rotateYaw(Vec3 vec, double angleDeg) {
        double rad = Math.toRadians(angleDeg);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double x = vec.x * cos - vec.z * sin;
        double z = vec.x * sin + vec.z * cos;
        return new Vec3(x, vec.y, z);
    }

    public static float distanceToVec(Vec3 startPos, Vec3 endPos) {

        float f = (float) (startPos.x - endPos.x);
        float f1 = (float) (startPos.y - endPos.y);
        float f2 = (float) ((float) (startPos.z) - endPos.z);
        return Mth.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static double linearTransformd(double x, double domainMin, double domainMax, double rangeMin, double rangeMax) {
        x = x < domainMin ? domainMin : (x > domainMax ? domainMax : x);
        return (rangeMax - rangeMin) * (x - domainMin) / (domainMax - domainMin) + rangeMin;
    }

    public static double fit(double pct, double lbound, double hbound, double start, double end) {
        double npct = (pct - lbound) / (hbound - lbound);
        npct = Math.max(Math.min(1.0, npct), 0.0);
        return start + npct * (end - start);
    }

    public static Quaternionf quatFromRotationXYZ(float x, float y, float z, boolean degrees) {
        if (degrees) {
            x *= 0.017453292F;
            y *= 0.017453292F;
            z *= 0.017453292F;
        }

        return (new Quaternionf()).rotationXYZ(x, y, z);
    }

    public static float wrapRad(float angle) {
        while (angle >= Math.PI) angle -= MathUtils.TAU;
        while (angle < -Math.PI) angle += MathUtils.TAU;
        return angle;
    }

    public static float lerpRad(float t, float from, float to) {
        return from + wrapRad(to - from) * t;
    }

    public static float radAngle(float angle) {
        return angle * PI / 180;
    }
}
