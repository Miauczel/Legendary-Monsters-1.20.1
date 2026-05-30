package net.miauczel.legendary_monsters.damagetype;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> ENERGY_BEAM = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"laser"));
    public static final ResourceKey<DamageType> CLOUDS = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"clouds"));

    public static final ResourceKey<DamageType> GHOST = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"ghost"));
    public static final ResourceKey<DamageType> ANNIHILATION = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"void"));

    public static final ResourceKey<DamageType> GRAVITY = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"gravity"));

    public static final ResourceKey<DamageType> CUT = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"cut"));

    public static final ResourceKey<DamageType> IMPALE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LegendaryMonsters.MOD_ID,"impale"));

    public static DamageSource causeEnergyBeamDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(ENERGY_BEAM), attacker, caster); }

    public static DamageSource causeGravityDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(GRAVITY), attacker, caster); }

    public static DamageSource causeGhostlyDamage(Entity attacker,LivingEntity caster) {
        if (caster != null) {
            return new DamageSource(caster.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(GHOST), caster, caster);
        }else {
            return new DamageSource(caster.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(GHOST));
        }
    }

    public static DamageSource causeAnnihilationDamage(Entity attacker, LivingEntity caster) {
            return new DamageSource(caster.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(ANNIHILATION), caster, caster);

    }

    public static DamageSource causeCutDamage(Level level) {
        return new DamageSource(level.registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(CUT)); }
    public static DamageSource causeImpaleDamage(Level level) {
        return new DamageSource(level.registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(IMPALE)); }

    public static DamageSource causeCloudDamage(Entity attacker, LivingEntity caster) {
        if (attacker == null) {
            return new DamageSource(caster.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(CLOUDS), caster, caster);
        }
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(CLOUDS), attacker, caster);
    }
}
