package net.miauczel.legendary_monsters.event;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticleFactiories {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.BEAM.get(),
                LightningBeam.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.TORNADO.get(),
                Tornado.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.TORNADO_FIRE.get(),
                Tornado.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.RING.get(),
                Circle.RingFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.LB.get(),
                LightningBolt.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.FLAME.get(),
                Flame.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.FLAME_STATIC.get(),
                Flame_Static.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.CHORUS_SMOKE.get(),
                ChorusSmoke.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.TELEPORT_EFFECT.get(),
                BlackHole.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOULSTRIKE.get(),
                SoulStrike.Factory::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.SOULSTRIKE_RED.get(),
                SoulStrike.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.GHOSTLY_SOUL.get(),
                GhostlySoul.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.GHOSTLY_SOUL_RED.get(),
                GhostlySoul.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.DIMENSIONAL_BOMB_EXPLOSION.get(),
                DimensionalBombExplosion.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ANNIHILATION_FLAME_STRIKE.get(),
                AnnihilationFlame.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ANNIHILATION_SWEEP_PARTICLE.get(),
                AnnihilationSweepParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_SWEEP.get(),
                SoulSweepParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.KNIGHTS_SWEEP.get(),
                KnightSweepParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_SWEEP_RED.get(),
                SoulSweepRedParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.GIANT_ANNIHILATION_SWEEP_PARTICLE.get(),
                GiantAnnihilationSweepParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.BIG_ANNIHILATION_SWEEP.get(),
                BigAnnihilationSweepParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.BIG_ANNIHILATION_FLAME.get(),
                BigFlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.BIG_ORANGE_FLAME.get(),
                BigFlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SMALL_ANNIHILATION_FLAME.get(),
                SmallGreenFlame.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.RED_SOUL_FLAME.get(),
                SmallGreenFlame.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ANNIHILATION_EXPLOSION.get(),
                AnnihilationExplosion.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.DIMENSIONAL_EXPLOSION.get(),
                DimensionalExplosion.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ANNIHILATION_GEYSER.get(),
                AnnihilationGeyser.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ANNIHILATION_NUKE.get(),
                AnnihilatedNuke.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.LM_COSY_SMOKE.get(),
                ModCampfireSmoke.CosyProvider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.GROUND_ANNIHILATION_NUKE.get(),
                GroundAnnihilatedNuke.Factory::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.SHULKER_EXPLOSION.get(),
                ShulkerExplosion.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.PURPLE_SHULKER_EXPLOSION.get(),
                PurpleShulkerExplosion.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ROAR.get(),
                Roar.RoarFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SHULKER_WIND.get(),
                ShulkerWindParticle.Provider::new);
        event.registerSpecial(ModParticles.POWER_BOMB_TRAIL.get(), new AnnihilationBombTrail.OrbFactory());

        event.registerSpecial(ModParticles.PHANTOM_DAGGER_TRAIL.get(), new PhantomDaggerTrail.OrbFactory());
        event.registerSpecial(ModParticles.AIR_TRAIL.get(), new AirTrailParticle.OrbFactory());

        Minecraft.getInstance().particleEngine.register(ModParticles.SHULKER_CONFETTI.get(),
                ShulkerConfettiParticle.Provider::new);
        event.registerSpecial(ModParticles.MOVING_TRAIL.get(), new MovingTrailParticle.OrbFactory());
        event.registerSpecial(ModParticles.TEST_TRAIL.get(), new TestTrail.OrbFactory());
        event.registerSpecial(ModParticles.LASER_BULLET_TRAIL.get(), new LaserBulletTrail.OrbFactory());
        event.registerSpecial(ModParticles.LIGHTNING.get(), new LightningParticle.OrbFactory());

        Minecraft.getInstance().particleEngine.register(ModParticles.GROUNDSOUL.get(),
                GroundSoulParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_PILLAR_EXPLOSION.get(),
                SoulPillarExplosion.Factory::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.BEHEADED_KNIGHT_SWEEP.get(),
                BeheadedKnightSweepParticle.Provider::new);


        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_EXPLOSION.get(),
                SoulExplosion.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_EXPLOSION_RED.get(),
                SoulExplosion.Provider::new);


        Minecraft.getInstance().particleEngine.register(ModParticles.GROUNDSOUL_RED.get(),
                GroundSoulParticle.Factory::new);


        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_SIGIL.get(),
                SoulSigil.RingFactory::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_SHOOT.get(),
                SoulShoot.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.SOUL_SHOOT_RED.get(),
                SoulShoot.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.DUST_FALLING.get(), new DustFallingParticle.DustPillarProvider());

        Minecraft.getInstance().particleEngine.register(ModParticles.SMALL_SOUL_FIRE_FLAME.get(),
                SmallGreenFlame.SmallFlameProvider::new);


    }
}
