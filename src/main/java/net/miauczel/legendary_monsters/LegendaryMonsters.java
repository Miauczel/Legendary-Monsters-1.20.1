package net.miauczel.legendary_monsters;

import net.miauczel.legendary_monsters.Message.*;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.block.ModBlockEntity;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.client.event.ClientEvent;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.ModEntities;

import net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer.*;


import net.miauczel.legendary_monsters.entity.client.Model.beamSpawner;
import net.miauczel.legendary_monsters.entity.client.Render.*;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.EnderAnchorRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor.SomberTrapdoorRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SwingingAxeRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.TeleportMachineRenderer;
import net.miauczel.legendary_monsters.item.ModCreativeModTabs;
import net.miauczel.legendary_monsters.item.ModItemProperties;
import net.miauczel.legendary_monsters.item.ModItems;


import net.miauczel.legendary_monsters.sound.ModSounds;

import net.miauczel.legendary_monsters.Message.MessageArmorKey;
import net.miauczel.legendary_monsters.Message.MessageUpdateBossBar;
import net.miauczel.legendary_monsters.util.structure.Processors.ModProcessors;
import net.miauczel.legendary_monsters.worldgen.Structure.ModStructures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.LogManager;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LegendaryMonsters.MOD_ID)
public class LegendaryMonsters {

    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    public static final SimpleChannel NETWORKWRAPPER;
    private static final String PROTOCOL_VERSION = Integer.toString(1);

    public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    private static int packetsRegistered;

    static {
        NetworkRegistry.ChannelBuilder channel = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("legendary_monsters", "main_channel"));
        String version = PROTOCOL_VERSION;
        version.getClass();
        channel = channel.clientAcceptedVersions(version::equals);
        version = PROTOCOL_VERSION;
        version.getClass();
        NETWORKWRAPPER = channel.serverAcceptedVersions(version::equals).networkProtocolVersion(() -> {
            return PROTOCOL_VERSION;
        }).simpleChannel();
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation("legendarymonsters", name.toLowerCase(Locale.ROOT));
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getMainHandItem().getItem() == ModItems.AXE_OF_LIGHTNING.get()) {
                DamageSource source = event.getSource();
                if (source != null && source.is(DamageTypes.LIGHTNING_BOLT)) {

                    event.setAmount(event.getAmount() * 0f);
                }
            }
        }

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            if (boots.getItem() == ModItems.ATMOSPHERIC_BOOTS.get()) {
                DamageSource source1 = event.getSource();
                if (source1 != null && source1.is(DamageTypes.FALL)) {
                    event.setAmount(event.getAmount() * 0.5f);
                }
            }
        }
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack boots = player.getItemBySlot(EquipmentSlot.HEAD);
            if (boots.getItem() == ModItems.BLASTPROOF_HELMET.get()) {
                DamageSource source1 = event.getSource();
                if (source1 != null && source1.is(DamageTypes.EXPLOSION) || source1.is(DamageTypes.PLAYER_EXPLOSION)) {
                    event.setAmount(event.getAmount() * 0.65f);
                }
            }
        }


    }


    public static final String MOD_ID = "legendary_monsters";
    public static DamageSource EXTRA_DAMAGE;

    public LegendaryMonsters() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setupMessages);

        MinecraftForge.EVENT_BUS.register(this);
        PROXY.init();

        modEventBus.addListener(this::addCreative);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModEffects.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModParticles.register(modEventBus);
        ModProcessors.register(modEventBus);
        ModBlockEntity.register(modEventBus);
        ModStructures.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, net.miauczel.legendary_monsters.config.ModConfig.MOB_CONFIG_SPEC);

    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.Skeletosaurus.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.Warped_Fungussus.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });

        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.Chorusling.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.Bomber.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.FLAMEBORN_GUARD.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.FLAMEBORN_WARRIOR.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    (type, level, reason, pos, random) -> {
                        return level.getBlockState(pos.below()).isValidSpawn(level, pos.below(), type)
                                && level.getBlockState(pos).isAir()
                                && level.getBlockState(pos.above()).isAir();
                    });

        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.WANDERING_EYE.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    (type, level, reason, pos, random) -> {
                        return level.getBlockState(pos.below()).isValidSpawn(level, pos.below(), type)
                                && level.getBlockState(pos).isAir()
                                && level.getBlockState(pos.above()).isAir();
                    });

        });

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            PROXY.clientInit();
            ModItemProperties.addCustomItemProperties();
            MinecraftForge.EVENT_BUS.register(ClientEvent.class);
            EntityRenderers.register(ModEntities.Skeletosaurus.get(), SkeletosaurusRenderer::new);
            EntityRenderers.register(ModEntities.Ancient_Guardian.get(), Ancient_GuardianRenderer::new);

            EntityRenderers.register(ModEntities.Overgrown_colossus.get(), Overgrown_colossusRenderer::new);
            EntityRenderers.register(ModEntities.Endersent.get(), EndersentRenderer::new);
            EntityRenderers.register(ModEntities.Warped_Fungussus.get(), Warped_FungussusRenderer::new);
            EntityRenderers.register(ModEntities.Lava_eater.get(), Lava_eaterRenderer::new);
            EntityRenderers.register(ModEntities.Frostbitten_Golem.get(), Frostbitten_GolemRenderer::new);

            //EntityRenderers.register(ModEntities.Shulker_Mimic.get(), Shulker_MimicRenderer::new);
            EntityRenderers.register(ModEntities.Shulker_Mimic.get(), Shulker_MimicRenderer::new);

            EntityRenderers.register(ModEntities.Chorusling.get(), ChoruslingRenderer::new);
            EntityRenderers.register(ModEntities.Withered_Abomination.get(), Withered_AbominationRenderer::new);
            EntityRenderers.register(ModEntities.Ambusher.get(), AmbusherRenderer::new);
            EntityRenderers.register(ModEntities.Spiky_bug.get(), SpikebugRenderer::new);
            EntityRenderers.register(ModEntities.CHORUS_BOMB.get(), ChorusBombRenderer::new);
            EntityRenderers.register(ModEntities.FALLING_CLOUD.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.FALLING_CLOUD_SMALL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SPEAR.get(), SpearRenderer::new);
            EntityRenderers.register(ModEntities.Cloud_golem.get(), Cloud_GolemRenderer::new);
            EntityRenderers.register(ModEntities.Haunted_Knight.get(), LivingArmorRenderer::new);
            EntityRenderers.register(ModEntities.Knights_Armor.get(), FLivingArmorRenderer::new);
            EntityRenderers.register(ModEntities.Guard.get(), FHauntedGuardRenderer::new);
            EntityRenderers.register(ModEntities.Haunted_Guard.get(), HauntedGuardRenderer::new);
            EntityRenderers.register(ModEntities.Posessed_Paladin.get(), PossessedPaladinRenderer::new);
            EntityRenderers.register(ModEntities.GOLDEN_HALBERT.get(), GoldenHalbertRenderer::new);

            EntityRenderers.register(ModEntities.CAMERA_SHAKE.get(), CameraShakeRenderer::new);
            EntityRenderers.register(ModEntities.Mossy_Golem.get(), MossyGolemRenderer::new);
            EntityRenderers.register(ModEntities.Skeleraptor.get(), SkeloraptorRenderer::new);
            ;
            EntityRenderers.register(ModEntities.BlastCannon.get(), DuneSentinelRenderer::new);
            EntityRenderers.register(ModEntities.Bomber.get(), BomberRenderer::new);
            EntityRenderers.register(ModEntities.BOMB.get(), BombRenderer::new);
            EntityRenderers.register(ModEntities.LM_FALLING_BLOCK.get(), LMFallingBlockRenderer::new);

            EntityRenderers.register(ModEntities.C.get(), CloudRender::new);
            EntityRenderers.register(ModEntities.ICE_SPIKE_ENTITY.get(), IceSpikeRenderer::new);
            EntityRenderers.register(ModEntities.SHOCKWAVE.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.POISONOUS_SHOCKWAVE.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.SHOCKWAVE_SPAWNER.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.POISONOUS_SHOCKWAVE_SPAWNER.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.FIRE.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.FIRE_B.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.ELectr.get(), beamSpawner::new);

            EntityRenderers.register(ModEntities.LightningBeam.get(), context -> new LightningBeamRenderer(context, 0.8f));

            EntityRenderers.register(ModEntities.Stratling.get(), StratlingRenderer::new);

            EntityRenderers.register(ModEntities.HoverinngHurricane.get(), HoveringHurricaneRenderer::new);
            EntityRenderers.register(ModEntities.TORNADO.get(), TornadoRender::new);
            EntityRenderers.register(ModEntities.S.get(), SoulHandRenderer::new);
            EntityRenderers.register(ModEntities.L.get(), context -> new LightningRenderer(context, 0.8f));


            EntityRenderers.register(ModEntities.ENERGY_BEAM.get(), EnergyBeamRender2d::new);
            EntityRenderers.register(ModEntities.SS.get(), soul::new);

            EntityRenderers.register(ModEntities.PLAYER_TORNADO.get(), PlayerTornadoRender::new);
            EntityRenderers.register(ModEntities.SMALL_CLOUD.get(), SmallCloudRender::new);
            EntityRenderers.register(ModEntities.THUNDER_CLOUD.get(), AngryCloudRender::new);


            EntityRenderers.register(ModEntities.CHORUS_BULLET.get(), ChorusEnergyBulletRenderer::new);

            EntityRenderers.register(ModEntities.CHORUS_BREATH.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_PILLAR.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_BLADE_UNDERGROUND.get(), SoulBladeRenderer::new);

            EntityRenderers.register(ModEntities.BIG_SHULKER_BULLET.get(), BigShulkerBulletRenderer::new);
            EntityRenderers.register(ModEntities.FALLING_SOUL_BLADE.get(), FallingSoulBladeRenderer::new);
            EntityRenderers.register(ModEntities.THE_OBLITERATOR.get(), TheObliteratorRenderer::new);

            EntityRenderers.register(ModEntities.ANNIHILATION_BOMB_ENTITY.get(), PowerBallBombRenderer::new);

            EntityRenderers.register(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), SmallPowerBallBombRenderer::new);

            EntityRenderers.register(ModEntities.THE_WARPED_ONE_DUPLICATE.get(), TheObliteratorCloneRenderer::new);

            EntityRenderers.register(ModEntities.THE_WARPED_ONE_DUPLICATE_ARMED.get(), TheObliteratorArmedCloneRenderer::new);

            EntityRenderers.register(ModEntities.GREEN_FLAME_STRIKE.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.ENERGY_DISC.get(), PlasmaBallRenderer::new);

            EntityRenderers.register(ModEntities.ENERGY_EXPLOSION.get(), NoRendererEntityRenderer::new);
            EntityRenderers.register(ModEntities.ENERGY_LASER.get(), NoRendererProjectileRenderer::new);

            EntityRenderers.register(ModEntities.TRACKING_BOMB.get(), TrackingEnergyBombRenderer::new);

            EntityRenderers.register(ModEntities.ANNIHILATION_BEAM.get(), AnnihilationBeamRenderer::new);

            EntityRenderers.register(ModEntities.ANNIHILATION_PORTAL.get(), AnnihilationPortalRenderer::new);

            EntityRenderers.register(ModEntities.FLYING_ARMOR.get(), FlyingArmorRenderer::new);
            EntityRenderers.register(ModEntities.FLAME_ROCKET.get(), FlameRocketRenderer::new);


            EntityRenderers.register(ModEntities.FLAMEBORN_GUARD.get(), FlamebornGuardRenderer::new);
            EntityRenderers.register(ModEntities.ANNIHILATION_GEYSER.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.FLAME_DRIFTER.get(), FlameDrifterRenderer::new);
            EntityRenderers.register(ModEntities.GROUND_ANNIHILATION_NUKE_STRIKE.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.GRAVITY_BIG_SHULKER_BULLET.get(), GravityBigShulkerBulletRenderer::new);

            EntityRenderers.register(ModEntities.ANNIHILATION_PURSUER.get(), AnnihilationPursuerRenderer::new);
            EntityRenderers.register(ModEntities.ENTITY_THROWN.get(), EntityThrownRenderer::new);

            EntityRenderers.register(ModEntities.BOTTLE_OF_ANNIHILATION.get(), ThrownItemRenderer::new);

            EntityRenderers.register(ModEntities.WANDERING_EYE.get(), WanderingEyeRenderer::new);

            EntityRenderers.register(ModEntities.FLAMEBORN_WARRIOR.get(), FlamebornWarriorRenderer::new);

            EntityRenderers.register(ModEntities.THROWN_PHANTOM_DAGGER.get(), ThrownPhantomDaggerRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_SHIELD.get(), SoulShieldRenderer::new);

            EntityRenderers.register(ModEntities.BEHEADED_KNIGHT.get(), BeheadedKnightRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_JAVELIN.get(), SoulJavelinRenderer::new);

            EntityRenderers.register(ModEntities.RESURRECTED_JAVELIN.get(), ResurrectedJavelinRenderer::new);

            EntityRenderers.register(ModEntities.THROWN_RESURRECTED_KNIGHT.get(), ThrownResurrectedKnightRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_PILLAR_EXPLOSION.get(), NoRendererEntityRenderer::new);

            EntityRenderers.register(ModEntities.RESURRECTED_KNIGHT.get(), ResurrectedKnightRenderer::new);

            EntityRenderers.register(ModEntities.SOUL_TRIDENT.get(), SoulTridentRenderer::new);

            EntityRenderers.register(ModEntities.FRACTURED_APOSTLE.get(), FracturedApostleRenderer::new);

            EntityRenderers.register(ModEntities.FRACTURED.get(), FracturedRenderer::new);


            BlockEntityRenderers.register(ModBlockEntity.ENDER_ANCHOR.get(), EnderAnchorRenderer::new);
            BlockEntityRenderers.register(ModBlockEntity.TELEPORT_MACHINE.get(), TeleportMachineRenderer::new);
            BlockEntityRenderers.register(ModBlockEntity.SWINGING_AXE.get(), SwingingAxeRenderer::new);
            BlockEntityRenderers.register(ModBlockEntity.SOMBER_TRAPDOOR.get(), SomberTrapdoorRenderer::new);

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMALL_SPIKE_TRAP_BLOCK.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIG_SPIKE_TRAP_BLOCK.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Block.byItem(ModItems.SOUL_GREAT_SWORD.get()), RenderType.translucent());

            {
            }
        }
    }
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static <MSG> void sendMSGToServer(MSG message) {
        NETWORKWRAPPER.sendToServer(message);
    }


    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }

    public static <MSG> void sendMSGToAll(MSG message) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendNonLocal(message, player);
        }
    }

    public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
        NETWORKWRAPPER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }

    private void setupMessages(final FMLCommonSetupEvent event) {
        NETWORKWRAPPER.registerMessage(packetsRegistered++, PlayBossMusicMessage.class, PlayBossMusicMessage::write, PlayBossMusicMessage::read, PlayBossMusicMessage.Handler::onMessage);
        NETWORKWRAPPER.registerMessage(packetsRegistered++, MessageUpdateBossBar.class, MessageUpdateBossBar::write, MessageUpdateBossBar::read, MessageUpdateBossBar::handle);
        NETWORKWRAPPER.registerMessage(packetsRegistered++, MessageArmorKey.class, MessageArmorKey::write, MessageArmorKey::read, MessageArmorKey::handle);
        NETWORKWRAPPER.registerMessage(packetsRegistered++, SkeloraptorTailAttackMessage.class, SkeloraptorTailAttackMessage::write, SkeloraptorTailAttackMessage::read, SkeloraptorTailAttackMessage.Handler::onMessage);
        NETWORKWRAPPER.registerMessage(packetsRegistered++, SkeloraptorRoarKeyMessage.class, SkeloraptorRoarKeyMessage::write, SkeloraptorRoarKeyMessage::read, SkeloraptorRoarKeyMessage.Handler::onMessage);

        NETWORKWRAPPER.registerMessage(packetsRegistered++, AnnihilatorChestplatePlaySoundMessage.class, AnnihilatorChestplatePlaySoundMessage::write, AnnihilatorChestplatePlaySoundMessage::read, AnnihilatorChestplatePlaySoundMessage.Handler::onMessage);

        NETWORKWRAPPER.registerMessage(packetsRegistered++, AnnihilatorHelmetAbilityMessage.class, AnnihilatorHelmetAbilityMessage::write, AnnihilatorHelmetAbilityMessage::read, AnnihilatorHelmetAbilityMessage.Handler::onMessage);


    }
}

