package net.miauczel.legendary_monsters.Particle;

import com.mojang.serialization.Codec;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.custom.*;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<SimpleParticleType> WARNING =
            PARTICLE_TYPES.register("warning", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> BEAM =
            PARTICLE_TYPES.register("beam", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> TORNADO =
            PARTICLE_TYPES.register("tornado", () -> new SimpleParticleType(true));


    public static final RegistryObject<SimpleParticleType> SMALL_SOUL_FIRE_FLAME =
            PARTICLE_TYPES.register("small_soul_fire_flame", () -> new SimpleParticleType(true));


    public static final RegistryObject<SimpleParticleType> FLAME =
            PARTICLE_TYPES.register("flame", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> FLAME_STATIC =
            PARTICLE_TYPES.register("flame_static", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> CHORUS_SMOKE =
            PARTICLE_TYPES.register("chorus_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LB =
            PARTICLE_TYPES.register("bolt", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> TELEPORT_EFFECT =
            PARTICLE_TYPES.register("black_hole", () -> new SimpleParticleType(true));
    public static final RegistryObject<ParticleType<Circle.RingData>> RING = PARTICLE_TYPES.register("circle", () -> new ParticleType<Circle.RingData>(false, Circle.RingData.DESERIALIZER) {
        @Override
        public Codec<Circle.RingData> codec() {
            return Circle.RingData.CODEC(RING.get());
        }
    });
    public static final RegistryObject<ParticleType<SoulSigil.RingData>> SOUL_SIGIL = PARTICLE_TYPES.register("soul_sigil", () -> new ParticleType<SoulSigil.RingData>(false, SoulSigil.RingData.DESERIALIZER) {
        @Override
        public Codec<SoulSigil.RingData> codec() {
            return SoulSigil.RingData.CODEC(SOUL_SIGIL.get());
        }
    });
    public static final RegistryObject<SimpleParticleType> SOULSTRIKE =
            PARTICLE_TYPES.register("soul_strike", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOULSTRIKE_RED =
            PARTICLE_TYPES.register("soul_strike_red", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> TORNADO_FIRE =
            PARTICLE_TYPES.register("tornado_fire", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> GHOSTLY_SOUL=
            PARTICLE_TYPES.register("ghostly_soul", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> GHOSTLY_SOUL_RED=
            PARTICLE_TYPES.register("ghostly_soul_red", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> DIMENSIONAL_BOMB_EXPLOSION=
            PARTICLE_TYPES.register("dimensional_bomb", () -> new SimpleParticleType(true));
    public static final RegistryObject<ParticleType<AnnihilationBombTrail.OrbData>> POWER_BOMB_TRAIL = PARTICLE_TYPES.register("power_bomb_trail", () -> new ParticleType<AnnihilationBombTrail.OrbData>(false, AnnihilationBombTrail.OrbData.DESERIALIZER) {
        @Override
        public Codec<AnnihilationBombTrail.OrbData> codec() {
            return AnnihilationBombTrail.OrbData.CODEC(POWER_BOMB_TRAIL.get());
        }
    });
    public static final RegistryObject<ParticleType<PhantomDaggerTrail.OrbData>> PHANTOM_DAGGER_TRAIL = PARTICLE_TYPES.register("phantom_dagger_trail", () -> new ParticleType<>(false, PhantomDaggerTrail.OrbData.DESERIALIZER) {
        @Override
        public Codec<PhantomDaggerTrail.OrbData> codec() {
            return PhantomDaggerTrail.OrbData.CODEC(PHANTOM_DAGGER_TRAIL.get());
        }
    });
    public static final RegistryObject<ParticleType<AirTrailParticle.OrbData>> AIR_TRAIL = PARTICLE_TYPES.register("air_trail", () -> new ParticleType<>(false, AirTrailParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<AirTrailParticle.OrbData> codec() {
            return AirTrailParticle.OrbData.CODEC(AIR_TRAIL.get());
        }
    });
    public static final RegistryObject<ParticleType<LaserBulletTrail.OrbData>> LASER_BULLET_TRAIL = PARTICLE_TYPES.register("laser_bullet_trail", () -> new ParticleType<LaserBulletTrail.OrbData>(false, LaserBulletTrail.OrbData.DESERIALIZER) {
        @Override
        public Codec<LaserBulletTrail.OrbData> codec() {
            return LaserBulletTrail.OrbData.CODEC(LASER_BULLET_TRAIL.get());
        }
    });
    public static final RegistryObject<ParticleType<LightningParticle.OrbData>> LIGHTNING = PARTICLE_TYPES.register("lightning", () -> new ParticleType<LightningParticle.OrbData>(false, LightningParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<LightningParticle.OrbData> codec() {
            return LightningParticle.OrbData.CODEC(LIGHTNING.get());
        }
    });

    public static final RegistryObject<SimpleParticleType> ANNIHILATION_FLAME_STRIKE =
            PARTICLE_TYPES.register("green_fire_strike", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ANNIHILATION_GEYSER=
            PARTICLE_TYPES.register("annihilation_geyser", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> DIMENSIONAL_EXPLOSION=
            PARTICLE_TYPES.register("dimensional_explosion", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ANNIHILATION_EXPLOSION=
            PARTICLE_TYPES.register("annihilation_explosion", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> BIG_ANNIHILATION_FLAME =
            PARTICLE_TYPES.register("big_green_flame", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> BIG_ORANGE_FLAME=
            PARTICLE_TYPES.register("big_orange_flame", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> LM_COSY_SMOKE=
            PARTICLE_TYPES.register("lm_cosy_smoke", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_ANNIHILATION_FLAME =
            PARTICLE_TYPES.register("small_green_flame", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> RED_SOUL_FLAME =
            PARTICLE_TYPES.register("red_soul_flame", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SHULKER_EXPLOSION=
            PARTICLE_TYPES.register("shulker_explosion", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PURPLE_SHULKER_EXPLOSION =
            PARTICLE_TYPES.register("purple_shulker_explosion", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> GROUNDSOUL =
            PARTICLE_TYPES.register("ground_soul", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> GROUNDSOUL_RED =
            PARTICLE_TYPES.register("ground_soul_red", () -> new SimpleParticleType(true));

    public static final RegistryObject<ParticleType<BlockParticleOption>> DUST_FALLING =
            PARTICLE_TYPES.register("dust_falling", () -> new ParticleType<>(false,BlockParticleOption.DESERIALIZER) {
                @Override
                public Codec<BlockParticleOption> codec() {
                    return BlockParticleOption.codec(ModParticles.DUST_FALLING.get());
                }
            });

    public static final RegistryObject<ParticleType<AnnihilationSweepParticle.SweepData>> ANNIHILATION_SWEEP_PARTICLE = PARTICLE_TYPES.register("green_sweep", () ->
            new ParticleType<>(false, AnnihilationSweepParticle.SweepData.DESERIALIZER) {
        @Override
        public Codec<AnnihilationSweepParticle.SweepData> codec() {
            return AnnihilationSweepParticle.SweepData.CODEC(ANNIHILATION_SWEEP_PARTICLE.get());
        }
    });
    public static final RegistryObject<ParticleType<SoulSweepParticle.SweepData>> SOUL_SWEEP = PARTICLE_TYPES.register("soul_sweep", () ->
            new ParticleType<>(false, SoulSweepParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<SoulSweepParticle.SweepData> codec() {
                    return SoulSweepParticle.SweepData.CODEC(SOUL_SWEEP.get());
                }
            });
    public static final RegistryObject<ParticleType<KnightSweepParticle.SweepData>> KNIGHTS_SWEEP = PARTICLE_TYPES.register("knight_sweep", () ->
            new ParticleType<>(false, KnightSweepParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<KnightSweepParticle.SweepData> codec() {
                    return KnightSweepParticle.SweepData.CODEC(KNIGHTS_SWEEP.get());
                }
            });
    public static final RegistryObject<ParticleType<SoulSweepRedParticle.SweepData>> SOUL_SWEEP_RED = PARTICLE_TYPES.register("soul_sweep_red", () ->
            new ParticleType<>(false, SoulSweepRedParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<SoulSweepRedParticle.SweepData> codec() {
                    return SoulSweepRedParticle.SweepData.CODEC(SOUL_SWEEP_RED.get());
                }
            });
    public static final RegistryObject<ParticleType<GiantAnnihilationSweepParticle.SweepData>> GIANT_ANNIHILATION_SWEEP_PARTICLE = PARTICLE_TYPES.register("giant_annihilation_sweep", () ->
            new ParticleType<>(false, GiantAnnihilationSweepParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<GiantAnnihilationSweepParticle.SweepData> codec() {
                    return GiantAnnihilationSweepParticle.SweepData.CODEC(GIANT_ANNIHILATION_SWEEP_PARTICLE.get());
                }
            });

    public static final RegistryObject<ParticleType<MovingTrailParticle.TrailData>> MOVING_TRAIL =
            PARTICLE_TYPES.register("moving_trail", () -> new ParticleType<>
                    (false, MovingTrailParticle.TrailData.DESERIALIZER) {
        @Override
        public Codec<MovingTrailParticle.TrailData> codec() {
            return MovingTrailParticle.TrailData.CODEC(MOVING_TRAIL.get());
        }
    });
    public static final RegistryObject<ParticleType<BigAnnihilationSweepParticle.SweepData>> BIG_ANNIHILATION_SWEEP = PARTICLE_TYPES.register("big_annihilation_sweep", () ->
            new ParticleType<>(false, BigAnnihilationSweepParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<BigAnnihilationSweepParticle.SweepData> codec() {
                    return BigAnnihilationSweepParticle.SweepData.CODEC(BIG_ANNIHILATION_SWEEP.get());
                }
            });
    public static final RegistryObject<ParticleType<BeheadedKnightSweepParticle.SweepData>> BEHEADED_KNIGHT_SWEEP = PARTICLE_TYPES.register("beheaded_knight_sweep", () ->
            new ParticleType<>(false, BeheadedKnightSweepParticle.SweepData.DESERIALIZER) {
                @Override
                public Codec<BeheadedKnightSweepParticle.SweepData> codec() {
                    return BeheadedKnightSweepParticle.SweepData.CODEC(BEHEADED_KNIGHT_SWEEP.get());
                }
            });

    public static final RegistryObject<ParticleType<Roar.RoarData>> ROAR = PARTICLE_TYPES.register("roar", () -> new ParticleType<>(false, Roar.RoarData.DESERIALIZER) {
        @Override
        public Codec<Roar.RoarData> codec() {
            return Roar.RoarData.CODEC(ROAR.get());
        }
    });
    public static final RegistryObject<SimpleParticleType> ANNIHILATION_NUKE=
            PARTICLE_TYPES.register("annihilation_nuke", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOUL_EXPLOSION=
            PARTICLE_TYPES.register("soul_explosion", () -> new SimpleParticleType(true));


    public static final RegistryObject<SimpleParticleType> SOUL_PILLAR_EXPLOSION=
            PARTICLE_TYPES.register("soul_pillar_explosion", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOUL_EXPLOSION_RED=
            PARTICLE_TYPES.register("soul_explosion_red", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> GROUND_ANNIHILATION_NUKE=
            PARTICLE_TYPES.register("ground_annihilation_nuke", () -> new SimpleParticleType(true));
    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static final RegistryObject<SimpleParticleType> SHULKER_WIND=
            PARTICLE_TYPES.register("shulker_wind", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SHULKER_CONFETTI =
            PARTICLE_TYPES.register("shulker_confetti", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOUL_SHOOT =
            PARTICLE_TYPES.register("soul_shoot", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOUL_SHOOT_RED =
            PARTICLE_TYPES.register("soul_shoot_red", () -> new SimpleParticleType(true));

    public static final RegistryObject<ParticleType<TestTrail.TrailData>> TEST_TRAIL =
            PARTICLE_TYPES.register("test_trail", () -> new ParticleType<>
                    (false, TestTrail.TrailData.DESERIALIZER) {
                @Override
                public Codec<TestTrail.TrailData> codec() {
                    return TestTrail.TrailData.CODEC(TEST_TRAIL.get());
                }
            });

}
