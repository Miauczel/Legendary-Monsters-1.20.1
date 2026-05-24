package net.miauczel.legendary_monsters.entity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedApostleEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.HauntedGuardEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.HauntedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.ResurrectedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.AmbusherEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.Ancient_GuardianEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.SpikebugEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.ChoruslingEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.HoveringHurricaneEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.StratlingEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.FHauntedGuardEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.FLivingArmorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.BomberEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.FlameDrifter.FlameDrifterEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornGuardEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornWarriorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.WanderingEyeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.*;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ChorusEnergyBulletEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.ThrownResurrectedKnightEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.miauczel.legendary_monsters.LegendaryMonsters.MOD_ID;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);
    public static final RegistryObject<EntityType<SkeletosaurusEntity>> Skeletosaurus =
            ENTITY_TYPES.register("skeletosaurus", () -> EntityType.Builder.of(SkeletosaurusEntity::new, MobCategory.MONSTER)
                    .sized(3f,3.5f).build("skeletosaurus"));

    public static final RegistryObject<EntityType<Overgrown_colossusEntity>> Overgrown_colossus =
            ENTITY_TYPES.register("overgrown_colossus", () -> EntityType.Builder.of(Overgrown_colossusEntity::new, MobCategory.MONSTER)
                    .sized(2f,2.6f).build("overgrown_colossus"));

    public static final RegistryObject<EntityType<EndersentEntity>> Endersent =
            ENTITY_TYPES.register("endersent", () -> EntityType.Builder.of(EndersentEntity::new, MobCategory.MONSTER)
                    .sized(1f,6f).build("endersent"));

    public static final RegistryObject<EntityType<Warped_FungussusEntity>> Warped_Fungussus =
            ENTITY_TYPES.register("warped_fungussus", () -> EntityType.Builder.of(Warped_FungussusEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("warped_fungussus"));

    public static final RegistryObject<EntityType<Lava_eaterEntity>> Lava_eater =
            ENTITY_TYPES.register("lava_eater", () -> EntityType.Builder.of(Lava_eaterEntity::new, MobCategory.MONSTER)
                    .sized(2f,1.75f).build("lava_eater"));

    public static final RegistryObject<EntityType<Frostbitten_GolemEntity>> Frostbitten_Golem =
            ENTITY_TYPES.register("frostbitten_golem", () -> EntityType.Builder.of(Frostbitten_GolemEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,2.5f).build("frostbitten_golem")); //old width: 1f, old height: 1.5f


    public static final RegistryObject<EntityType<Shulker_MimicEntity>> Shulker_Mimic =
            ENTITY_TYPES.register("shulker_mimic", () -> EntityType.Builder.of(Shulker_MimicEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.5f,2.5f).build("shulker_mimic"));



    //Old Mimic
   /* public static final RegistryObject<EntityType<OldShulkerMimic>> OLDShulker_Mimic =
            ENTITY_TYPES.register("shulker_mimic", () -> EntityType.Builder.of(OldShulkerMimic::new, MobCategory.MONSTER)
                    .sized(2f,2.5f).build("shulker_mimic"));

*/


    public static final RegistryObject<EntityType<ChoruslingEntity>> Chorusling =
            ENTITY_TYPES.register("chorusling", () -> EntityType.Builder.of(ChoruslingEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("chorusling"));

    public static final RegistryObject<EntityType<Withered_AbominationEntity>> Withered_Abomination =
            ENTITY_TYPES.register("withered_abomination", () -> EntityType.Builder.of(Withered_AbominationEntity::new, MobCategory.MONSTER)
                    .sized(3,2.5f).build("withered_abomination"));
    public static final RegistryObject<EntityType<Chorus_BombEntity>> CHORUS_BOMB = ENTITY_TYPES.register("chorus_bomb",
            () -> EntityType.Builder.<Chorus_BombEntity>of(Chorus_BombEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "chorus_bomb"));
 // Add the entity ID as an argument to the build method

    public static final RegistryObject<EntityType<Falling_CloudEntity>> FALLING_CLOUD = ENTITY_TYPES.register("falling_cloud",
            () -> EntityType.Builder.<Falling_CloudEntity>of(Falling_CloudEntity::new, MobCategory.MISC)
                    .setCustomClientFactory(Falling_CloudEntity::new)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .sized(1.5f, 1.5f)
                    .build("falling_cloud")); // Add the entity ID as an argument to the build method


    public static final RegistryObject<EntityType<Falling_Cloud_SmallEntity>> FALLING_CLOUD_SMALL = ENTITY_TYPES.register("falling_cloud_small",
            () -> EntityType.Builder.<Falling_Cloud_SmallEntity>of(Falling_Cloud_SmallEntity::new, MobCategory.MISC)
                    .setCustomClientFactory(Falling_Cloud_SmallEntity::new)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .sized(1.5f, 1.5f)
                    .build("falling_cloud_small")); // Add the entity ID as an argument to the build method




    public static final RegistryObject<EntityType<Ancient_GuardianEntity>> Ancient_Guardian =
            ENTITY_TYPES.register("ancient_guardian", () -> EntityType.Builder.of(Ancient_GuardianEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,2.25f).build("ancient_guardian"));

    public static final RegistryObject<EntityType<AmbusherEntity>> Ambusher =
            ENTITY_TYPES.register("ambusher", () -> EntityType.Builder.of(AmbusherEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,1.5f).build("ambusher"));

    public static final RegistryObject<EntityType<SpikebugEntity>> Spiky_bug =
            ENTITY_TYPES.register("spiky_bug", () -> EntityType.Builder.of(SpikebugEntity::new, MobCategory.MONSTER)
                    .sized(0.7f,0.5f).build("spiky_bug"));

    public static final RegistryObject<EntityType<Cloud_GolemEntity>> Cloud_golem =
            ENTITY_TYPES.register("cloud_golem", () -> EntityType.Builder.of(Cloud_GolemEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,2.5f).build("cloud_golem")); //old width: 1f, old height: 1.5f

    public static final RegistryObject<EntityType<HauntedKnightEntity>> Haunted_Knight =
            ENTITY_TYPES.register("haunted_knight", () -> EntityType.Builder.of(HauntedKnightEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("haunted_knight")); //old width: 1f, old height: 1.5f
    public static final RegistryObject<EntityType<HauntedGuardEntity>> Haunted_Guard =
            ENTITY_TYPES.register("haunted_guard", () -> EntityType.Builder.of(HauntedGuardEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("haunted_guard")); //old width: 1f, old height: 1.5f

    public static final RegistryObject<EntityType<PossessedPaladinEntity>> Posessed_Paladin =
            ENTITY_TYPES.register("posessed_paladin", () -> EntityType.Builder.of(PossessedPaladinEntity::new, MobCategory.MONSTER)
                    .sized(1f,3f).build("posessed_paladin")); //old width: 1f, old height: 1.5f


    public static final RegistryObject<EntityType<ThrownHalbert>> SPEAR = ENTITY_TYPES.register("spear",
            () -> EntityType.Builder.<ThrownHalbert>of(ThrownHalbert::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "spear"));
    public static final RegistryObject<EntityType<ThrownGoldenHalbert>> GOLDEN_HALBERT = ENTITY_TYPES.register("golden_halbert",
            () -> EntityType.Builder.<ThrownGoldenHalbert>of(ThrownGoldenHalbert::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "golden_halbert"));


    public static final RegistryObject<EntityType<FLivingArmorEntity>> Knights_Armor =
            ENTITY_TYPES.register("knights_armor", () -> EntityType.Builder.of(FLivingArmorEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("knights_armor")); //old width: 1f, old height: 1.5f


    public static final RegistryObject<EntityType<FHauntedGuardEntity>> Guard =
            ENTITY_TYPES.register("guard", () -> EntityType.Builder.of(FHauntedGuardEntity::new, MobCategory.MONSTER)
                    .sized(1f,2.5f).build("guard")); //old width: 1f, old height: 1.5f

    //public static final EntityType<CameraShakeEntity> CAMERA_SHAKE = null;

    public static final RegistryObject<EntityType<CameraShakeEntity>> CAMERA_SHAKE = ENTITY_TYPES.register("camera_shake",
            () -> EntityType.Builder.<CameraShakeEntity>of(CameraShakeEntity::new, MobCategory.MISC)
                    .sized(1F, 1F)
                    .build(new ResourceLocation(MOD_ID, "camera_shake").toString()));

    public static final RegistryObject<EntityType<MossyGolemEntity>> Mossy_Golem =
            ENTITY_TYPES.register("mossy_golem", () -> EntityType.Builder.of(MossyGolemEntity::new, MobCategory.MONSTER)
                    .sized(1f,1.2f).build("mossy_golem")); //old width: 1f, old height: 1.5f
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
    public static final RegistryObject<EntityType<SkeloraptorEntity>> Skeleraptor =
            ENTITY_TYPES.register("skeloraptor", () -> EntityType.Builder.of(SkeloraptorEntity::new, MobCategory.CREATURE)
                    .sized(1.25f,2.6f).build("skeloraptor"));
    public static final RegistryObject<EntityType<DuneSentinelEntity>> BlastCannon =
            ENTITY_TYPES.register("dune_sentinel", () -> EntityType.Builder.of(DuneSentinelEntity::new, MobCategory.CREATURE)
                    .sized(1.25f,4f).build("dune_sentinel"));
    public static final RegistryObject<EntityType<BomberEntity>> Bomber =
            ENTITY_TYPES.register("bomber", () -> EntityType.Builder.of(BomberEntity::new, MobCategory.MONSTER)
                    .sized(0.5f,1f).build("bomber"));

    public static final RegistryObject<EntityType<BombEntity>> BOMB = ENTITY_TYPES.register("bomb",
            () -> EntityType.Builder.<BombEntity>of(BombEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "bomb"));
    public static final RegistryObject<EntityType<LMFallingBlockEntity>> LM_FALLING_BLOCK = ENTITY_TYPES.register(
            "lm_falling_block",
            () -> EntityType.Builder.<LMFallingBlockEntity>of(LMFallingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98F, 0.98F)
                    .clientTrackingRange(10)
                    .updateInterval(20)
                    .build("lm_falling_block")
    );
    public static final RegistryObject<EntityType<IceSpikeEntity>> ICE_SPIKE_ENTITY = ENTITY_TYPES.register("ice_spike", () -> EntityType.Builder.<IceSpikeEntity>of(IceSpikeEntity::new, MobCategory.MISC)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":ice_spike"));


    public static final RegistryObject<EntityType<ShockwaveEntity>> SHOCKWAVE = ENTITY_TYPES.register("shockwave", () -> EntityType.Builder.<ShockwaveEntity>of(ShockwaveEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":shockwave"));


    public static final RegistryObject<EntityType<PoisonousShockwave>> POISONOUS_SHOCKWAVE = ENTITY_TYPES.register("poison_shockwave", () -> EntityType.Builder.<PoisonousShockwave>of(PoisonousShockwave::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":poison_shockwave"));

    public static final RegistryObject<EntityType<ShockwaveSpawner>> SHOCKWAVE_SPAWNER = ENTITY_TYPES.register("shockwave_spawner", () -> EntityType.Builder.<ShockwaveSpawner>of(ShockwaveSpawner::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":shockwave_spawner"));

    public static final RegistryObject<EntityType<PoisonousShockwaveSpawner>> POISONOUS_SHOCKWAVE_SPAWNER = ENTITY_TYPES.register("poison_shockwave_spawner", () -> EntityType.Builder.<PoisonousShockwaveSpawner>of(PoisonousShockwaveSpawner::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":poison_shockwave_spawner"));

    public static final RegistryObject<EntityType<FireColumnEntity>> FIRE = ENTITY_TYPES.register("fire_pillar", () -> EntityType.Builder.<FireColumnEntity>of(FireColumnEntity::new, MobCategory.MISC)
            .sized(0.75F, 0.5F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":fire_pillar"));
    public static final RegistryObject<EntityType<FireBreath>> FIRE_B = ENTITY_TYPES.register("fire_breath", () -> EntityType.Builder.<FireBreath>of(FireBreath
                    ::new, MobCategory.MISC)
            .sized(0.75F, 0.5F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":fire_breath"));

    public static final RegistryObject<EntityType<SoulStrike>> SS= ENTITY_TYPES.register("soul_strike", () -> EntityType.Builder.<SoulStrike>of(SoulStrike::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":soul_strike"));

    public static final RegistryObject<EntityType<EnergyBeamEntity>> ENERGY_BEAM = ENTITY_TYPES.register("energy_beam", () -> EntityType.Builder.<EnergyBeamEntity>of(EnergyBeamEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":energy_beam"));
    public static final RegistryObject<EntityType<LightningBeamEntity>> LightningBeam= ENTITY_TYPES.register("lightning_beam", () -> EntityType.Builder.<LightningBeamEntity>of(LightningBeamEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":lightning_beam"));

    public static final RegistryObject<EntityType<ElectricityEntity>> ELectr= ENTITY_TYPES.register("electric_burst", () -> EntityType.Builder.<ElectricityEntity>of(ElectricityEntity::new, MobCategory.MISC)
            .sized(1F, 4F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":electric_burst"));

    public static final RegistryObject<EntityType<CloudEntity>> C = ENTITY_TYPES.register("cloud",
            () -> EntityType.Builder.<CloudEntity>of(CloudEntity::new, MobCategory.MISC)
                    .sized(1F, 1F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "cloud"));

    public static final RegistryObject<EntityType<LightningBoltEntity>> L = ENTITY_TYPES.register("lightning_strike", () -> EntityType.Builder.<LightningBoltEntity>of(LightningBoltEntity::
                    new, MobCategory.MISC)
            .sized(1F, 4F)
                .clientTrackingRange(6)
                .updateInterval(2)
                .fireImmune()
                .build(MOD_ID + ":lightning_strike"))
    ;

    public static final RegistryObject<EntityType<SoulHandEntity>> S= ENTITY_TYPES.register("soul_arm", () -> EntityType.Builder.<SoulHandEntity>
            of(SoulHandEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":soul_arm"));
    public static final RegistryObject<EntityType<Tornado>> TORNADO = ENTITY_TYPES.register("tornado", () -> EntityType.Builder.<Tornado>
                    of(Tornado::new, MobCategory.MISC)
            .sized(1.5F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":Tornado"));
    public static final RegistryObject<EntityType<ThunderCloud>> THUNDER_CLOUD = ENTITY_TYPES.register("thunder_cloud", () -> EntityType.Builder.<ThunderCloud>
                    of(ThunderCloud::new, MobCategory.MISC)
            .sized(1.5F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":thunder_cloud"));
    public static final RegistryObject<EntityType<PlayerTornado>> PLAYER_TORNADO= ENTITY_TYPES.register("player_tornado", () -> EntityType.Builder.<PlayerTornado>
                    of(PlayerTornado::new, MobCategory.MISC)
            .sized(1.5F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":player_tornado"));
    public static final RegistryObject<EntityType<SmallCloudEntity>> SMALL_CLOUD= ENTITY_TYPES.register("small_cloud", () -> EntityType.Builder.<SmallCloudEntity>
                    of(SmallCloudEntity::new, MobCategory.MISC)
            .sized(1.5F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":small_cloud"));


    public static final RegistryObject<EntityType<StratlingEntity>> Stratling =
            ENTITY_TYPES.register("stratling", () -> EntityType.Builder.of(StratlingEntity::new, MobCategory.MONSTER)
                    .sized(1f,2f).build("stratling"));
    public static final RegistryObject<EntityType<HoveringHurricaneEntity>> HoverinngHurricane =
            ENTITY_TYPES.register("hovering_hurricane", () -> EntityType.Builder.of(HoveringHurricaneEntity::new, MobCategory.MONSTER)
                    .sized(1f,2f).build("hovering_hurricane"));

    public static final RegistryObject<EntityType<ChorusEnergyBulletEntity>> CHORUS_BULLET= ENTITY_TYPES.register("chorus_energy_bullet", () -> EntityType.Builder.<ChorusEnergyBulletEntity>
                    of(ChorusEnergyBulletEntity::new, MobCategory.MISC)
            .sized(1.5F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":chorus_energy_bullet"));
    public static final RegistryObject<EntityType<ChorusBreathEntity>> CHORUS_BREATH= ENTITY_TYPES.register("chorus_breath", () -> EntityType.Builder.<ChorusBreathEntity>
                    of(ChorusBreathEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":chorus_breath"));

    public static final RegistryObject<EntityType<SoulPillarEntity>> SOUL_PILLAR = ENTITY_TYPES.register("soul_pillar", () -> EntityType.Builder.<SoulPillarEntity>of(SoulPillarEntity::new, MobCategory.MISC)
            .sized(1F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":soul_pillar"));
    public static final RegistryObject<EntityType<SoulPillarExplosionEntity>> SOUL_PILLAR_EXPLOSION = ENTITY_TYPES.register("soul_pillar_explosion", () -> EntityType.Builder.<SoulPillarExplosionEntity>of(SoulPillarExplosionEntity::new, MobCategory.MISC)
            .sized(1F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":soul_pillar_explosion"));
    public static final RegistryObject<EntityType<SoulBladeEntity>> SOUL_BLADE_UNDERGROUND = ENTITY_TYPES.register("underground_soul_blade", () -> EntityType.Builder.
                    <SoulBladeEntity>of(SoulBladeEntity::new, MobCategory.MISC)
            .sized(1F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":underground_soul_blade"));
    public static final RegistryObject<EntityType<FallingSoulBladeEntity>> FALLING_SOUL_BLADE = ENTITY_TYPES.register("falling_soul_blade", () -> EntityType.Builder.
                    <FallingSoulBladeEntity>of(FallingSoulBladeEntity::new, MobCategory.MISC)
            .sized(1F, 3F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":falling_soul_blade"));
    public static final RegistryObject<EntityType<BigShulkerBulletEntity>> BIG_SHULKER_BULLET = ENTITY_TYPES.register("big_shulker_bullet", () -> EntityType.Builder.
                    <BigShulkerBulletEntity>of(BigShulkerBulletEntity::new, MobCategory.MISC)
            .sized(1F, 1F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":big_shulker_bullet"));


   public static final RegistryObject<EntityType<TheObliteratorEntity>> THE_OBLITERATOR =
     ENTITY_TYPES.register("the_obliterator", () -> EntityType.Builder.of(TheObliteratorEntity::new, MobCategory.MONSTER)
             .fireImmune().sized(3f,5f).build("the_obliterator"));


    public static final RegistryObject<EntityType<AnnihilationBombEntity>> ANNIHILATION_BOMB_ENTITY = ENTITY_TYPES.register("dimensional_bomb", () -> EntityType.Builder.
                    <AnnihilationBombEntity>of(AnnihilationBombEntity::new, MobCategory.MISC)
            .sized(2F, 2F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":dimensional_bomb"));
    public static final RegistryObject<EntityType<SmallAnnihilationBombEntity>> SMALL_ANNIHILATION_BOMB_ENTITY = ENTITY_TYPES.register("small_dimensional_bomb", () -> EntityType.Builder.
                    <SmallAnnihilationBombEntity>of(SmallAnnihilationBombEntity::new, MobCategory.MISC)
            .sized(0.5F, 0.5F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":small_dimensional_bomb"));
  public static final RegistryObject<EntityType<TheObliteratorCloneEntity>> THE_WARPED_ONE_DUPLICATE = ENTITY_TYPES.register("the_warped_one_duplicate", () -> EntityType.Builder.
                    <TheObliteratorCloneEntity>of(TheObliteratorCloneEntity::new, MobCategory.MISC)
            .sized(2F, 2.5F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":the_warped_one_duplicate"));
    public static final RegistryObject<EntityType<TheObliteratorCloneWithArmsEntity>> THE_WARPED_ONE_DUPLICATE_ARMED = ENTITY_TYPES.register("the_warped_one_duplicate_armed", () -> EntityType.Builder.
                    <TheObliteratorCloneWithArmsEntity>of(TheObliteratorCloneWithArmsEntity::new, MobCategory.MISC)
            .sized(2F, 2.5F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":the_warped_one_duplicate_armed"));
    public static final RegistryObject<EntityType<AnnihilationFlameStrike>> GREEN_FLAME_STRIKE = ENTITY_TYPES.register("green_flame_strike", () -> EntityType.Builder.
                    <AnnihilationFlameStrike>of(AnnihilationFlameStrike::new, MobCategory.MISC)
            .sized(1F, 2)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":green_flame_strike"));
    public static final RegistryObject<EntityType<PlasmaOrbEntity>> ENERGY_DISC = ENTITY_TYPES.register("energy_disc", () -> EntityType.Builder.
                    <PlasmaOrbEntity>of(PlasmaOrbEntity::new, MobCategory.MISC)
            .sized(2F, 2)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":energy_disc"));
    public static final RegistryObject<EntityType<AnnihilationExplosionEntity>> ENERGY_EXPLOSION = ENTITY_TYPES.register("energy_explosion", () -> EntityType.Builder.
                    <AnnihilationExplosionEntity>of(AnnihilationExplosionEntity::new, MobCategory.MISC)
            .sized(2.25F, 3)//2.25 Old Golden number
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":energy_explosion"));
    public static final RegistryObject<EntityType<LaserBulletEntity>> ENERGY_LASER = ENTITY_TYPES.register("energy_laser", () -> EntityType.Builder.
                    <LaserBulletEntity>of(LaserBulletEntity::new, MobCategory.MISC)
            .sized(0.5F, 0.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":energy_laser"));
    public static final RegistryObject<EntityType<TrackingBombEntity>> TRACKING_BOMB = ENTITY_TYPES.register("tracking_bomb", () -> EntityType.Builder.
                    <TrackingBombEntity>of(TrackingBombEntity::new, MobCategory.MISC)
            .sized(1, 1)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":tracking_bomb"));
    public static final RegistryObject<EntityType<AnnihilationBeamEntity>> ANNIHILATION_BEAM = ENTITY_TYPES.register("annihilation_beam", () -> EntityType.Builder.
                    <AnnihilationBeamEntity>of(AnnihilationBeamEntity::new, MobCategory.MISC)
            .sized(1, 1)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":annihilation_beam"));
    public static final RegistryObject<EntityType<AnnihilationPortalEntity>> ANNIHILATION_PORTAL = ENTITY_TYPES.register("annihilation_portal", () -> EntityType.Builder.
                    <AnnihilationPortalEntity>of(AnnihilationPortalEntity::new, MobCategory.MISC)
            .sized(2, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":annihilation_portal"));
    public static final RegistryObject<EntityType<FlyingArmorEntity>> FLYING_ARMOR = ENTITY_TYPES.register("flying_armor", () -> EntityType.Builder.
                    <FlyingArmorEntity>of(FlyingArmorEntity::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":flying_armor"));
    public static final RegistryObject<EntityType<FlameRocketEntity>> FLAME_ROCKET = ENTITY_TYPES.register("flame_rocket", () -> EntityType.Builder.
                    <FlameRocketEntity>of(FlameRocketEntity::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":flame_rocket"));
    public static final RegistryObject<EntityType<AnnihilationGeyserEntity>> ANNIHILATION_GEYSER = ENTITY_TYPES.register("annihilation_geyser", () -> EntityType.Builder.
                    <AnnihilationGeyserEntity>of(AnnihilationGeyserEntity::new, MobCategory.MISC)
            .sized(2.5f, 3f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":annihilation_geyser"));
    public static final RegistryObject<EntityType<AnnihilationGroundNukeStrikeEntity>> GROUND_ANNIHILATION_NUKE_STRIKE = ENTITY_TYPES.register("annihilation_ground_nuke_strike", () -> EntityType.Builder.
                    <AnnihilationGroundNukeStrikeEntity>of(AnnihilationGroundNukeStrikeEntity::new, MobCategory.MISC)
            .sized(3.5f, 3f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":annihilation_ground_nuke_strike"));

    public static final RegistryObject<EntityType<FlamebornGuardEntity>> FLAMEBORN_GUARD =
            ENTITY_TYPES.register("flameborn_guard", () -> EntityType.Builder.of(FlamebornGuardEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1f,3f).build("flameborn_guard"));

    public static final RegistryObject<EntityType<FlamebornWarriorEntity>> FLAMEBORN_WARRIOR =
            ENTITY_TYPES.register("flameborn_warrior", () -> EntityType.Builder.of(FlamebornWarriorEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1f,3f).build("flameborn_warrior"));
    public static final RegistryObject<EntityType<FlameDrifterEntity>> FLAME_DRIFTER =
            ENTITY_TYPES.register("flame_drifter", () -> EntityType.Builder.of(FlameDrifterEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.5f,1.5f).build("flame_drifter"));

    public static final RegistryObject<EntityType<AnnihilationPursuerEntity>> ANNIHILATION_PURSUER =
            ENTITY_TYPES.register("annihilation_pursuer", () -> EntityType.Builder.of(AnnihilationPursuerEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.5f,5f).build("annihilation_pursuer"));

    public static final RegistryObject<EntityType<WanderingEyeEntity>> WANDERING_EYE =
            ENTITY_TYPES.register("wandering_eye", () -> EntityType.Builder.of(WanderingEyeEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1f,1.75f).build("wandering_eye"));


    public static final RegistryObject<EntityType<GravityBigShulkerEntity>> GRAVITY_BIG_SHULKER_BULLET = ENTITY_TYPES.register("gravity_big_shulker_bullet", () -> EntityType.Builder.
                    <GravityBigShulkerEntity>of(GravityBigShulkerEntity::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":gravity_big_shulker_bullet"));

    public static final RegistryObject<EntityType<EntityThrownEntity>> ENTITY_THROWN = ENTITY_TYPES.register("thrown_entity", () -> EntityType.Builder.
                    <EntityThrownEntity>of(EntityThrownEntity::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":thrown_entity"));
    public static final RegistryObject<EntityType<ThrownResurrectedKnightEntity>> THROWN_RESURRECTED_KNIGHT = ENTITY_TYPES.register("thrown_resurrected_knight", () -> EntityType.Builder.
                    <ThrownResurrectedKnightEntity>of(ThrownResurrectedKnightEntity::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":thrown_resurrected_knight"));
    public static final RegistryObject<EntityType<ThrownAnnihilationBottle>> BOTTLE_OF_ANNIHILATION = ENTITY_TYPES.register("thrown_annihilation_bottle", () -> EntityType.Builder.
                    <ThrownAnnihilationBottle>of(ThrownAnnihilationBottle::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":thrown_annihilation_bottle"));

    public static final RegistryObject<EntityType<ThrownPhantomDaggerEntity>> THROWN_PHANTOM_DAGGER = ENTITY_TYPES.register("thrown_phantom_dagger", () -> EntityType.Builder.
                    <ThrownPhantomDaggerEntity>of(ThrownPhantomDaggerEntity::new, MobCategory.MISC)
            .sized(0.75f, 0.75f)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":thrown_phantom_dagger"));
    public static final RegistryObject<EntityType<SoulShieldEntity>> SOUL_SHIELD = ENTITY_TYPES.register("soul_shield", () -> EntityType.Builder.
                    <SoulShieldEntity>of(SoulShieldEntity::new, MobCategory.MISC)
            .sized(1.75F, 2.75F)
            .clientTrackingRange(6)
            .updateInterval(2)
            .fireImmune()
            .build(MOD_ID + ":soul_shield"));
    public static final RegistryObject<EntityType<BeheadedKnightEntity>> BEHEADED_KNIGHT =
            ENTITY_TYPES.register("beheaded_knight", () -> EntityType.Builder.of(BeheadedKnightEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.5f,4f).build("beheaded_knight"));
    public static final RegistryObject<EntityType<SoulJavelinEntity>> SOUL_JAVELIN = ENTITY_TYPES.register("soul_javelin",
            () -> EntityType.Builder.<SoulJavelinEntity>of(SoulJavelinEntity::new, MobCategory.MISC)
                    .sized(1F, 1F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "soul_javelin"));
    public static final RegistryObject<EntityType<SoulTridentEntity>> SOUL_TRIDENT = ENTITY_TYPES.register("soul_trident",
            () -> EntityType.Builder.<SoulTridentEntity>of(SoulTridentEntity::new, MobCategory.MISC)
                    .sized(1F, 1F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build( "soul_trident"));

    public static final RegistryObject<EntityType<ResurrectedKnightEntity>> RESURRECTED_KNIGHT =
            ENTITY_TYPES.register("resurrected_knight", () -> EntityType.Builder.of(ResurrectedKnightEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.25f,3f).build("resurrected_knight"));


    public static final RegistryObject<EntityType<FracturedApostleEntity>> FRACTURED_APOSTLE =
            ENTITY_TYPES.register("fractured_apostle", () -> EntityType.Builder.of(FracturedApostleEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1.25f,2f).build("fractured_apostle"));

    public static final RegistryObject<EntityType<FracturedEntity>> FRACTURED =
            ENTITY_TYPES.register("fractured", () -> EntityType.Builder.of(FracturedEntity::new, MobCategory.MONSTER).fireImmune()
                    .sized(1f,2f).build("fractured"));

    public static final RegistryObject<EntityType<ThrownResurrectedJavelin>> RESURRECTED_JAVELIN =
            ENTITY_TYPES.register("resurrected_javelin", () -> EntityType.Builder.<ThrownResurrectedJavelin>of(ThrownResurrectedJavelin::new, MobCategory.MONSTER).fireImmune()
                    .sized(1f,1f).build("resurrected_javelin"));
}





