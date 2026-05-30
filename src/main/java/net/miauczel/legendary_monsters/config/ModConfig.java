package net.miauczel.legendary_monsters.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final MobConfig MOB_CONFIG;
    public static final ForgeConfigSpec MOB_CONFIG_SPEC;

    static {
        Pair<CommonConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();

        Pair<MobConfig, ForgeConfigSpec> additionalSpecPair = new ForgeConfigSpec.Builder().configure(MobConfig::new);
        MOB_CONFIG = additionalSpecPair.getLeft();
        MOB_CONFIG_SPEC = additionalSpecPair.getRight();
    }

    public static class CommonConfig {


        //effects
        public final ForgeConfigSpec.BooleanValue AllowOvergrownColosussStun;
        public final ForgeConfigSpec.BooleanValue AllowAncientGuardianStun;
        public final ForgeConfigSpec.BooleanValue AllowPosessedPaladinStun;
        public final ForgeConfigSpec.BooleanValue AllowFallingCloud;
        public final ForgeConfigSpec.BooleanValue AllowWitheredAbominationStun;

        //multipliers
        public final ForgeConfigSpec.DoubleValue DamageMultiplier;
        public final ForgeConfigSpec.DoubleValue HealthMultiplier;

        //mob settings

        public final ForgeConfigSpec.DoubleValue posessedPaladinDamage1;
        public final ForgeConfigSpec.DoubleValue hauntedGuardDamage;
        public final ForgeConfigSpec.DoubleValue hauntedKnightDamage;
        public final ForgeConfigSpec.DoubleValue AncientGuardianDamage;
        public final ForgeConfigSpec.DoubleValue AmbusherDamage;
        public final ForgeConfigSpec.DoubleValue SpikyWormDamage;
        public final ForgeConfigSpec.DoubleValue CloudGolemP2Damage;
        public final ForgeConfigSpec.DoubleValue OvergrownColosussDamage;
        public final ForgeConfigSpec.DoubleValue FrostbittenGolemDamage;
        public final ForgeConfigSpec.DoubleValue LavaEaterDamage;
        public final ForgeConfigSpec.DoubleValue ShulkerMimicDamage;
        public final ForgeConfigSpec.DoubleValue SkeletosaurusDamage;
        public final ForgeConfigSpec.DoubleValue WitheredAbominationDamage;
        public final ForgeConfigSpec.DoubleValue EndersentDamage;
        public final ForgeConfigSpec.DoubleValue ChoruslingDamage;
        public final ForgeConfigSpec.DoubleValue WarpedFungussusDamage;
        public final ForgeConfigSpec.DoubleValue MossyGolemDamage;

        public final ForgeConfigSpec.DoubleValue BlastCannonHealth;
        public final ForgeConfigSpec.DoubleValue HauntedGuardHealth;
        public final ForgeConfigSpec.DoubleValue HauntedKnightHealth;
        public final ForgeConfigSpec.DoubleValue posessedPaladinHealth;
        public final ForgeConfigSpec.DoubleValue AncientGuardianHealth;
        public final ForgeConfigSpec.DoubleValue AmbusherHealth;
        public final ForgeConfigSpec.DoubleValue SpikyWormHealth;
        public final ForgeConfigSpec.DoubleValue CloudGolemP1Health;
        public final ForgeConfigSpec.DoubleValue CloudGolemP2Health;
        public final ForgeConfigSpec.DoubleValue OvergrownColosussHealth;
        public final ForgeConfigSpec.DoubleValue FrostbittenGolemHealth;
        public final ForgeConfigSpec.DoubleValue LavaEaterHealth;
        public final ForgeConfigSpec.DoubleValue ShulkerMimicHealth;
        public final ForgeConfigSpec.DoubleValue SkeletosaurusHealth;
        public final ForgeConfigSpec.DoubleValue WitheredAbominationHealth;
        public final ForgeConfigSpec.DoubleValue EndersentHealth;
        public final ForgeConfigSpec.DoubleValue ChoruslingHealth;
        public final ForgeConfigSpec.DoubleValue WarpedFungussusHealth;
        public final ForgeConfigSpec.DoubleValue MossyGolemHealth;


        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("Mob Effects");

            builder.push("Overgrown Colosuss");
            AllowOvergrownColosussStun = builder
                    .comment("Enable/Disable mob stun (!Warning! Disabling this function may make this mob way easier to beat)")
                    .define("Allow Overgrown Colosuss stun", true);
            builder.pop();

            builder.push("Ancient Guardian");
            AllowAncientGuardianStun = builder
                    .comment("Enable/Disable mob stun (!Warning! Disabling this function may make this mob way easier to beat)")
                    .define("Allow Ancient Guardian stun", true);
            builder.pop();

            builder.push("Posessed Paladin");
            AllowPosessedPaladinStun = builder
                    .comment("Enable/Disable mob stun (!Warning! Disabling this function may make this mob way easier to beat)")
                    .define("Allow Posessed Paladin stun", true);
            builder.pop();

            builder.push("Cloud Golem's Falling Cloud");
            AllowFallingCloud = builder
                    .comment("Enable/Disable mob stun (!Warning! Disabling this function may make Cloud Golem mob way easier to beat)")
                    .define("Allow Cloud Golem's Falling Cloud Stun", true);
            builder.pop();

            AllowWitheredAbominationStun = builder
                    .comment("Enable/Disable mob stun (!Warning! Disabling this function may make this mob way easier to beat)")
                    .define("Allow Withered Abomination Stun", true);
            builder.pop();

            builder.push("Multipliers");
            DamageMultiplier = builder
                    .comment("Multiplies damage for every mob")
                    .defineInRange("Mob Damage Multiplier", 1.0, 1.0, 100.0);
            HealthMultiplier = builder
                    .comment("Multiplies health for every mob")
                    .defineInRange("Mob Health Multiplier", 1.0, 1.0, 100.0);
            builder.pop();

            builder.push("Mob Settings");
            //Posessed Paladin
            builder.push("Posessed Paladin Settings");
            posessedPaladinDamage1 = builder
                    .comment("Set the damage dealt by Posessed  Paladin")
                    .defineInRange("Posessed Paladin Damage", 16.0, 10.0, 100.0);
            posessedPaladinHealth = builder
                    .comment("Set the health of Posessed Paladin")
                    .defineInRange("Posessed Paladin Health", 170.0, 150.0, 1000.0);

            builder.pop();

            //Haunted Guard
            builder.push("Haunted Guard Settings");
            hauntedGuardDamage = builder
                    .comment("Set the damage dealt by Haunted Guard")
                    .defineInRange("Haunted Guard Damage", 11.0, 8.0, 100.0);
            HauntedGuardHealth = builder
                    .comment("Set the health of Haunted Guard")
                    .defineInRange("Haunted Guard Health", 35.0, 30.0, 1000.0);
            builder.pop();

            //Haunted Knight
            builder.push("Haunted Knight Settings");
            hauntedKnightDamage = builder
                    .comment("Set the damage dealt by Haunted Knight")
                    .defineInRange("Haunted Knight Damage", 11.0, 8.0, 100.0);
            HauntedKnightHealth = builder
                    .comment("Set the health of Haunted Knight")
                    .defineInRange("Haunted Knight Health", 37.0, 30.0, 1000.0);
            builder.pop();


            //Ancient Guardian
            builder.push("Ancient Guardian Settings");
            AncientGuardianDamage = builder
                    .comment("Set the damage dealt by Ancient Guardian")
                    .defineInRange("Ancient Guardian Damage", 20.0, 17.0, 100.0);
            AncientGuardianHealth = builder
                    .comment("Set the health of Ancient Guardian")
                    .defineInRange("Ancient Guardian Health", 170.0, 150.0, 1000.0);

            builder.pop();

            //Ambusher
            builder.push("Ambusher Settings");
            AmbusherDamage = builder
                    .comment("Set the damage dealt by Ambusher")
                    .defineInRange("Ambusher Damage", 8.0, 5.0, 100.0);
            AmbusherHealth = builder
                    .comment("Set the health of Ambusher")
                    .defineInRange("Ambusher Health", 50.0, 30.0, 1000.0);
            builder.pop();

            //Spiky Worm
            builder.push("Spiky Worm Settings");
            SpikyWormDamage = builder
                    .comment("Set the damage dealt by Spiky Worm")
                    .defineInRange("Spiky Worm Damage", 3.0, 1.0, 100.0);
            SpikyWormHealth = builder
                    .comment("Set the health of Spiky Worm")
                    .defineInRange("Spiky Worm Health", 15.0, 5.0, 1000.0);
            builder.pop();

            //Cloud Golem
            builder.push("Cloud Golem (Phase 1) Settings");
            CloudGolemP1Health = builder
                    .comment("Set the health of Cloud Golem (Phase 1)")
                    .defineInRange("Cloud Golem (Phase 1) Health", 100.0, 70.0, 1000.0);
            builder.pop();

            builder.push("Cloud Golem (Phase 2) Settings");
            CloudGolemP2Damage = builder
                    .comment("Set the damage dealt by Cloud Golem (Phase 2)")
                    .defineInRange("Cloud Golem (Phase 2) Damage", 15.0, 12.0, 100.0);
            CloudGolemP2Health = builder
                    .comment("Set the health of Cloud Golem (Phase 2)")
                    .defineInRange("Cloud Golem (Phase 2) Health", 100.0, 70.0, 1000.0);
            builder.pop();

            //Overgrown Colosuss
            builder.push("Overgrown Colosuss Settings");
            OvergrownColosussDamage = builder
                    .comment("Set the damage dealt by Overgrown Colosuss")
                    .defineInRange("Overgrown Colosuss Damage", 16.0, 12.0, 100.0);
            OvergrownColosussHealth = builder
                    .comment("Set the health of Overgrown Colosuss")
                    .defineInRange("Overgrown Colosuss Health", 170.0, 150.0, 1000.0);

            builder.pop();

            //Frostbitten Golem
            builder.push("Frostbitten Golem Settings");
            FrostbittenGolemDamage = builder
                    .comment("Set the damage dealt by Frostbitten Golem")
                    .defineInRange("Frostbitten Golem Damage", 16.0D, 11.0, 100.0);
            FrostbittenGolemHealth = builder
                    .comment("Set the health of Frostbitten Golem")
                    .defineInRange("Frostbitten Golem Health", 170.0, 150.0, 1000.0);

            builder.pop();

            //Lava Eater
            builder.push("Lava Eater Settings");
            LavaEaterDamage = builder
                    .comment("Set the damage dealt by Lava Eater")
                    .defineInRange("Lava Eater Damage", 12.0, 7.0, 100.0);
            LavaEaterHealth = builder
                    .comment("Set the health of Lava Eater")
                    .defineInRange("Lava Eater Health", 150.0, 120.0, 1000.0);
            builder.pop();

            //Shulker Mimic
            builder.push("Shulker Mimic Settings");
            ShulkerMimicDamage = builder
                    .comment("Set the damage dealt by Shulker Mimic")
                    .defineInRange("Shulker Mimic Damage", 12.0, 8.0, 100.0);
            ShulkerMimicHealth = builder
                    .comment("Set the health of Shulker Mimic")
                    .defineInRange("Shulker Mimic Health", 150.0, 120.0, 1000.0);
            builder.pop();

            //Skeletosaurus
            builder.push("Skeletosaurus Settings");
            SkeletosaurusDamage = builder
                    .comment("Set the damage dealt by Skeletosaurus")
                    .defineInRange("Skeletosaurus Damage", 13.0, 6.0, 100.0);
            SkeletosaurusHealth = builder
                    .comment("Set the health of Skeletosaurus")
                    .defineInRange("Skeletosaurus Health", 150.0, 120.0, 1000.0);
            builder.pop();

            //Withered Abomination
            builder.push("Withered Abomination Settings");
            WitheredAbominationDamage = builder
                    .comment("Set the damage dealt by Withered Abomination")
                    .defineInRange("Withered Abomination Damage", 15.5D, 12.0D, 100.0D);
            WitheredAbominationHealth = builder
                    .comment("Set the health of Withered Abomination")
                    .defineInRange("Withered Abomination Health", 190.0, 160.0, 1000.0);
            builder.pop();

            //Endersent
            builder.push("Endersent Settings");
            EndersentDamage = builder
                    .comment("Set the damage dealt by Endersent")
                    .defineInRange("Endersent Damage", 16, 12.0, 100.0);
            EndersentHealth = builder
                    .comment("Set the health of Endersent")
                    .defineInRange("Endersent Health", 200.0, 160.0, 1000.0);
            builder.pop();

            //Chorusling
            builder.push("Chorusling Settings");
            ChoruslingDamage = builder
                    .comment("Set the damage dealt by Chorusling")
                    .defineInRange("Chorusling Damage", 6, 5, 100.0);
            ChoruslingHealth = builder
                    .comment("Set the health of Chorusling")
                    .defineInRange("Chorusling Health", 70, 40, 1000.0);
            builder.pop();

            //Warped Fungussus
            builder.push("Warped Fungussus Settings");
            WarpedFungussusDamage = builder
                    .comment("Set the damage dealt by Warped Fungussus")
                    .defineInRange("Warped Fungussus Damage", 7, 5.0, 100.0);
            WarpedFungussusHealth = builder
                    .comment("Set the health of Warped Fungussus")
                    .defineInRange("Warped Fungussus Health", 100.0, 70.0, 1000.0);
            builder.pop();

            //Mossy Golem
            builder.push("Mossy Golem Settings");
            MossyGolemDamage = builder
                    .comment("Set the damage dealt by Mossy Golem")
                    .defineInRange("Mossy Golem Damage", 5, 3.0, 100.0);
            MossyGolemHealth = builder
                    .comment("Set the health of Mossy Golem")
                    .defineInRange("Mossy Golem Health", 25, 20, 1000.0);
            builder.pop();

            builder.push("Dune Sentinel Settings");
            BlastCannonHealth = builder
                    .comment("Set the health of Dune Sentinel")
                    .defineInRange("Dune Sentinel Health", 170, 120, 1000.0);
            builder.pop();
        }
    }

    public static class MobConfig {

        public final ForgeConfigSpec.BooleanValue canPlayBossMusic;

        public final ForgeConfigSpec.BooleanValue canSoulGreatSwordUseParry;


        public final ForgeConfigSpec.BooleanValue canBossesResetPhases;

        public final ForgeConfigSpec.BooleanValue canBossesTeleportBackToSpawn;

        public final ForgeConfigSpec.BooleanValue allowCustomBossBar;

        public final ForgeConfigSpec.BooleanValue allowFallingCloudParticles;

        public final ForgeConfigSpec.BooleanValue AllowBossNatureHeal;

        public final ForgeConfigSpec.BooleanValue AllowKnightSummonsInitiateAttack;

        public final ForgeConfigSpec.BooleanValue allowDuoBossRespawnTeammate;
        public final ForgeConfigSpec.DoubleValue CloudGolemDamageCap;
        public final ForgeConfigSpec.BooleanValue CloudGolemInvulnerabilityTime;
        public final ForgeConfigSpec.BooleanValue CloudGolemCanCharge2Times;
        public final ForgeConfigSpec.BooleanValue CloudGolemLosesConsciousness;

        public final ForgeConfigSpec.BooleanValue BossesCancelEating;

        public final ForgeConfigSpec.BooleanValue BossesReduceResistanceEffect;

        public final ForgeConfigSpec.BooleanValue allowCameraShake;

        public final ForgeConfigSpec.BooleanValue Duneprojectile;

        public final ForgeConfigSpec.BooleanValue Ambushprojectile;
        public final ForgeConfigSpec.BooleanValue Knightprojectile;
        public final ForgeConfigSpec.BooleanValue Guardprojectile;


        public final ForgeConfigSpec.BooleanValue Overgrownprojectile;
        public final ForgeConfigSpec.BooleanValue Cloudprojectile;
        public final ForgeConfigSpec.BooleanValue Ancientprojectile;
        public final ForgeConfigSpec.BooleanValue Lavaprojectile;
        public final ForgeConfigSpec.BooleanValue Frostbittenprojectile;
        public final ForgeConfigSpec.BooleanValue Shulkerprojectile;
        public final ForgeConfigSpec.BooleanValue Posessedprojectile;


        public final ForgeConfigSpec.DoubleValue ChoruslingDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue ChoruslingHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue BossMusicVolumeMultiplier;
        public final ForgeConfigSpec.DoubleValue StratlingDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue StratlingHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue EndersentDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue EndersentHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue SpikyBugDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue SpikyBugHealthMutliplier;
        public final ForgeConfigSpec.DoubleValue AmbusherDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue AmbusherHealthMutliplier;
        public final ForgeConfigSpec.DoubleValue AncientGuardianDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue AncientGuardianHealthMutliplier;
        public final ForgeConfigSpec.DoubleValue HauntedKnightHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue HauntedKnightDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue TamableKnightHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue TamableKnightDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue TamableGuardHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue TamableGuardDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue HauntedGuardHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue HauntedGuardDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue FracturedApostleDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue FracturedApostleHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue FracturedDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue FracturedHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue PossessedPaladinHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue PosessedPaladinDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue OvergrownColosussHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue OvergrownColosussDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue CloudGolemHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue CloudGolemDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue CGFallingCloudDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue FrostbittenGolemHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue FrostbittenGolemDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue DuneSentinelHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue DuneSentinelDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue MossyGolemHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue MossyGolemDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue BomberHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue BomberDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue SkeletosaurusHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue SkeletosaurusDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue LavaEaterHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue LavaEaterDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue WarpedFungussusHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue WarpedFungussusDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue WitheredAbominationHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue WitheredAbominationDamageMutliplier;
        public final ForgeConfigSpec.DoubleValue ShulkerMimicHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue ShulkerMimicDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue HoveringHurricaneHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue HoveringHurricaneDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue WanderingEyeHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue WanderingEyeDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue TheObliteratorHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue TheObliteratorDamageCap;
        public final ForgeConfigSpec.DoubleValue TheObliteratorDamageMutliplier;

        public final ForgeConfigSpec.IntValue MiniBossDamageCap;

        public final ForgeConfigSpec.IntValue TheObliteratorCloneBurstHPDamage;

        public final ForgeConfigSpec.IntValue TheObliteratorPortalHPDamage;


        public final ForgeConfigSpec.IntValue TheObliteratorPortalExplosionHPDamage;
        public final ForgeConfigSpec.IntValue TheObliteratorAdaptationFactorMultiplier;
        public final ForgeConfigSpec.BooleanValue TheObliteratorInvulnerabilityTime;


        public final ForgeConfigSpec.BooleanValue PossessedPaladinInvulnerabilityTime;

        public final ForgeConfigSpec.DoubleValue PossessedPaladinDamageCap;
        public final ForgeConfigSpec.IntValue TheObliteratorAntiAirborneDistance;
        public final ForgeConfigSpec.BooleanValue TheObliteratorAnnihilationEffect;

        public final ForgeConfigSpec.DoubleValue FlamebornGuardHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue FlamebornGuardDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue AnnihilationPursuerHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue AnnihilationPursuerDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue FlameDrifterHealthMultiplier;
        public final ForgeConfigSpec.DoubleValue FlameDrifterDamageMutliplier;

        public final ForgeConfigSpec.DoubleValue FKnightDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue FKnightHealthMutliplier;

        public final ForgeConfigSpec.DoubleValue FGuardDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue FGuardHealthMutliplier;


        public final ForgeConfigSpec.DoubleValue SkeloraptorDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue SkeloraptorHealthMutliplier;


        public final ForgeConfigSpec.DoubleValue BeheadedKnightDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue BeheadedKnightHealthMutliplier;

        public final ForgeConfigSpec.DoubleValue ResurrectedKnightDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue ResurrectedKnightHealthMutliplier;

        public final ForgeConfigSpec.BooleanValue AllowOvergrownColosussStun;
        public final ForgeConfigSpec.BooleanValue AllowAncientGuardianStun;
        public final ForgeConfigSpec.BooleanValue AllowWitheredAbominationStun;

        //Item
        public final ForgeConfigSpec.DoubleValue TheTesseractDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue TheTesseractAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue TheTesseractSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue TheTesseractRangeMultiplier;

        public final ForgeConfigSpec.DoubleValue SoulGreatSwordDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue SoulGreatSwordAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue SoulGreatSwordSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue SoulGreatSwordRangeMultiplier;

        public final ForgeConfigSpec.DoubleValue MonstrousAnchorDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue MonstrousAnchorAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue MonstrousAnchorSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue MonstrousAnchorRangeMultiplier;

        public final ForgeConfigSpec.DoubleValue MossyHammerDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue MossyHammerAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue MossyHammerSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue AxeOfLightningDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue AxeOfLightningBoltDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue AxeOfLightningSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue TheGreatFrostDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue TheGreatFrostAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue TheGreatFrostSpeedMultiplier;


        public final ForgeConfigSpec.DoubleValue DinosaurBoneClubDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue DinosaurBoneClubAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue DinosaurBoneClubSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue ChorusBladeDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue ChorusBladeSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue WitheredScytheDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue WitheredScytheAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue WitheredScytheSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue ResurrectedJavelinDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue ResurrectedJavelinRangeMultiplier;
        public final ForgeConfigSpec.DoubleValue ResurrectedJavelinSpeedMultiplier;


        public final ForgeConfigSpec.DoubleValue ShatteredGreatSwordDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue ShatteredGreatSwordRangeMultiplier;
        public final ForgeConfigSpec.DoubleValue ShatteredGreatSwordSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue KnightsSwordDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue KnightsSwordSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue GuardAxeDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue GuardAxeRangeMultiplier;
        public final ForgeConfigSpec.DoubleValue GuardAxeSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue SomberKeyDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue SomberKeySpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue AnchorHandleDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue AnchorHandleSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue SpikyShieldDamageMultiplier;

        public final ForgeConfigSpec.DoubleValue BucklerOfAnnihilationSlashDamageMultiplier;

        public final ForgeConfigSpec.DoubleValue BucklerOfAnnihilationProjectileDamageMultiplier;

        public final ForgeConfigSpec.DoubleValue FieryJawDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue FieryJawAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue FieryJawSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue WandOfCloudsDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue WandOfCloudsAbilityDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue WandOfCloudsSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue AtomSplitterDamageMultiplier;



        public MobConfig(ForgeConfigSpec.Builder builder) {
            builder.push("Item Settings");
            builder.push("General Item Settings");
            canSoulGreatSwordUseParry = builder
                    .comment("allow Soul Great Sword Parry Ability")
                    .define("Allow Soul Great Sword Parry Ability",true);
            builder.pop();

            builder.push("The Tesseract");
            TheTesseractDamageMultiplier = builder
                    .comment("The Tesseract Damage Multiplier")
                    .defineInRange("The Tesseract Damage multiplier", 1.0, 0.0, 1000.0);
            TheTesseractAbilityDamageMultiplier = builder
                    .comment("The Tesseract Ability Damage Multiplier")
                    .defineInRange("The Tesseract Ability Damage multiplier", 1.0, 0.0, 1000.0);
            TheTesseractSpeedMultiplier = builder
                    .comment("The Tesseract Speed Multiplier")
                    .defineInRange("The Tesseract Speed multiplier", 1.0, 0.0, 1000.0);
            TheTesseractRangeMultiplier = builder
                    .comment("The Tesseract Range Multiplier")
                    .defineInRange("The Tesseract Range multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Fiery Jaw");
            FieryJawDamageMultiplier = builder
                    .comment("Fiery Jaw Damage Multiplier")
                    .defineInRange("Fiery Jaw Damage multiplier", 1.0, 0.0, 1000.0);
            FieryJawAbilityDamageMultiplier = builder
                    .comment("Fiery Jaw Ability Damage Multiplier")
                    .defineInRange("Fiery Jaw Ability Damage multiplier", 1.0, 0.0, 1000.0);
            FieryJawSpeedMultiplier = builder
                    .comment("Fiery Jaw Speed Multiplier")
                    .defineInRange("Fiery Jaw Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Spiky Shield");
            SpikyShieldDamageMultiplier = builder
                    .comment("Spiky Shield Damage Multiplier")
                    .defineInRange("Spiky Shield Damage multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Buckler Of Annihilation");
            BucklerOfAnnihilationSlashDamageMultiplier = builder
                    .comment("Buckler Of Annihilation Slash Damage Multiplier")
                    .defineInRange("Buckler Of Annihilation Slash Damage multiplier", 1.0, 0.0, 1000.0);
            BucklerOfAnnihilationProjectileDamageMultiplier = builder
                    .comment("Buckler Of Annihilation Bomb Damage Multiplier")
                    .defineInRange("Buckler Of Annihilation Bomb Damage multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Knights Sword");
            KnightsSwordDamageMultiplier = builder
                    .comment("Knights Sword Damage Multiplier")
                    .defineInRange("Knights Sword Damage multiplier", 1.0, 0.0, 1000.0);
            KnightsSwordSpeedMultiplier = builder
                    .comment("Knights Sword Speed Multiplier")
                    .defineInRange("Knights Sword Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Guards Axe");
            GuardAxeDamageMultiplier = builder
                    .comment("Guards Axe Damage Multiplier")
                    .defineInRange("Guards Axe Damage multiplier", 1.0, 0.0, 1000.0);
            GuardAxeRangeMultiplier = builder
                    .comment("Guards Axe Range Multiplier")
                    .defineInRange("Guards Axe Range multiplier", 1.0, 0.0, 1000.0);
            GuardAxeSpeedMultiplier = builder
                    .comment("Guards Axe Speed Multiplier")
                    .defineInRange("Guards Axe Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Somber Key");
            SomberKeyDamageMultiplier = builder
                    .comment("Somber Key Damage Multiplier")
                    .defineInRange("Somber Key Damage multiplier", 1.0, 0.0, 1000.0);
            SomberKeySpeedMultiplier = builder
                    .comment("Somber Key Speed Multiplier")
                    .defineInRange("Somber Key Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Anchor Handle");
            AnchorHandleDamageMultiplier = builder
                    .comment("Anchor Handle Damage Multiplier")
                    .defineInRange("Anchor Handle Damage multiplier", 1.0, 0.0, 1000.0);
            AnchorHandleSpeedMultiplier = builder
                    .comment("Anchor Handle Speed Multiplier")
                    .defineInRange("Anchor Handle Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Monstrous Anchor");
            MonstrousAnchorDamageMultiplier = builder
                    .comment("Monstrous Anchor Damage Multiplier")
                    .defineInRange("Monstrous Anchor Damage multiplier", 1.0, 0.0, 1000.0);
            MonstrousAnchorAbilityDamageMultiplier = builder
                    .comment("Monstrous Anchor Ability Damage Multiplier")
                    .defineInRange("Monstrous Anchor Ability Damage multiplier", 1.0, 0.0, 1000.0);
            MonstrousAnchorSpeedMultiplier = builder
                    .comment("Monstrous Anchor Speed Multiplier")
                    .defineInRange("Monstrous Anchor Speed multiplier", 1.0, 0.0, 1000.0);
            MonstrousAnchorRangeMultiplier = builder
                    .comment("Monstrous Anchor Range Multiplier")
                    .defineInRange("Monstrous Anchor Range multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Resurrected Javelin");
            ResurrectedJavelinDamageMultiplier = builder
                    .comment("Resurrected Javelin Damage Multiplier")
                    .defineInRange("Resurrected Javelin Damage multiplier", 1.0, 0.0, 1000.0);
            ResurrectedJavelinSpeedMultiplier = builder
                    .comment("Resurrected Javelin Speed Multiplier")
                    .defineInRange("Resurrected Javelin Speed multiplier", 1.0, 0.0, 1000.0);
            ResurrectedJavelinRangeMultiplier = builder
                    .comment("Resurrected Javelin Range Multiplier")
                    .defineInRange("Resurrected Javelin Range multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Shattered Great Sword");
            ShatteredGreatSwordDamageMultiplier = builder
                    .comment("Shattered Great Sword Damage Multiplier")
                    .defineInRange("Resurrected Javelin Damage multiplier", 1.0, 0.0, 1000.0);
            ShatteredGreatSwordSpeedMultiplier = builder
                    .comment("Shattered Great Sword Speed Multiplier")
                    .defineInRange("Shattered Great Sword Speed multiplier", 1.0, 0.0, 1000.0);
            ShatteredGreatSwordRangeMultiplier = builder
                    .comment("Shattered Great Sword Range Multiplier")
                    .defineInRange("Shattered Great Sword Range multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Wand Of Clouds");
            WandOfCloudsDamageMultiplier = builder
                    .comment("Wand Of Clouds Damage Multiplier")
                    .defineInRange("Wand Of Clouds Damage multiplier", 1.0, 0.0, 1000.0);
            WandOfCloudsAbilityDamageMultiplier = builder
                    .comment("Wand Of Clouds Ability Damage Multiplier")
                    .defineInRange("Wand Of Clouds Ability Damage multiplier", 1.0, 0.0, 1000.0);
            WandOfCloudsSpeedMultiplier = builder
                    .comment("Wand Of Clouds Speed Multiplier")
                    .defineInRange("Wand Of Clouds Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Mossy Hammer");
            MossyHammerDamageMultiplier = builder
                    .comment("Mossy Hammer Multiplier")
                    .defineInRange("Mossy Hammer multiplier", 1.0, 0.0, 1000.0);
            MossyHammerAbilityDamageMultiplier = builder
                    .comment("Mossy Hammer Ability Damage Multiplier")
                    .defineInRange("Mossy Hammer Ability Damage multiplier", 1.0, 0.0, 1000.0);
            MossyHammerSpeedMultiplier = builder
                    .comment("Mossy Hammer Speed Multiplier")
                    .defineInRange("Mossy Hammer Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Chorus Blade");
            ChorusBladeDamageMultiplier = builder
                    .comment("Chorus Blade Multiplier")
                    .defineInRange("Chorus Blade multiplier", 1.0, 0.0, 1000.0);
            ChorusBladeSpeedMultiplier = builder
                    .comment("Chorus Blade Speed Multiplier")
                    .defineInRange("Chorus Blade Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Soul Great Sword");
            SoulGreatSwordDamageMultiplier = builder
                    .comment("Soul Great Sword Damage Multiplier")
                    .defineInRange("Soul Great Sword Damage multiplier", 1.0, 0.0, 1000.0);
            SoulGreatSwordAbilityDamageMultiplier = builder
                    .comment("Soul Great Sword Ability Damage Multiplier")
                    .defineInRange("Soul Great Sword Ability Damage multiplier", 1.0, 0.0, 1000.0);
            SoulGreatSwordSpeedMultiplier = builder
                    .comment("Soul Great Sword Speed Multiplier")
                    .defineInRange("Soul Great Sword Speed multiplier", 1.0, 0.0, 1000.0);
            SoulGreatSwordRangeMultiplier = builder
                    .comment("Soul Great Sword Range Multiplier")
                    .defineInRange("Soul Great Sword Range multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Dinosaur Bone Club");
            DinosaurBoneClubDamageMultiplier = builder
                    .comment("Dinosaur Bone Club Damage Multiplier")
                    .defineInRange("Dinosaur Bone Club Damage multiplier", 1.0, 0.0, 1000.0);
            DinosaurBoneClubAbilityDamageMultiplier = builder
                    .comment("Dinosaur Bone Club Ability Damage Multiplier")
                    .defineInRange("Dinosaur Bone Club Ability Damage multiplier", 1.0, 0.0, 1000.0);
            DinosaurBoneClubSpeedMultiplier = builder
                    .comment("Dinosaur Bone Club Speed Multiplier")
                    .defineInRange("Dinosaur Bone Club Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Axe Of Lightning");
            AxeOfLightningDamageMultiplier = builder
                    .comment("Axe Of Lightning Damage Multiplier")
                    .defineInRange("Axe Of Lightning Damage multiplier", 1.0, 0.0, 1000.0);
            AxeOfLightningBoltDamageMultiplier = builder
                    .comment("Axe Of Lightning Bolt Damage Multiplier")
                    .defineInRange("Axe Of Lightning Bolt Damage multiplier", 1.0, 0.0, 1000.0);
            AxeOfLightningSpeedMultiplier = builder
                    .comment("Axe Of Lightning Speed Multiplier")
                    .defineInRange("Axe Of Lightning Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("The Great Frost");
            TheGreatFrostDamageMultiplier = builder
                    .comment("The Great Frost Damage Multiplier")
                    .defineInRange("The Great Frost Damage multiplier", 1.0, 0.0, 1000.0);
            TheGreatFrostAbilityDamageMultiplier = builder
                    .comment("The Great Frost Ability Damage Multiplier")
                    .defineInRange("The Great Frost Ability Damage multiplier", 1.0, 0.0, 1000.0);
            TheGreatFrostSpeedMultiplier = builder
                    .comment("The Great Frost Speed Multiplier")
                    .defineInRange("The Great Frost Speed multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Withered Scythe");
            WitheredScytheDamageMultiplier = builder
                    .comment("Withered Scythe Damage Multiplier")
                    .defineInRange("Withered Scythe Damage multiplier", 1.0, 0.0, 1000.0);
            WitheredScytheAbilityDamageMultiplier = builder
                    .comment("Withered Scythe Ability Damage Multiplier")
                    .defineInRange("Withered Scythe Ability Damage multiplier", 1.0, 0.0, 1000.0);
            WitheredScytheSpeedMultiplier = builder
                    .comment("Withered Scythe Speed Multiplier")
                    .defineInRange("Withered Scythe Speed multiplier", 1.0, 0.0, 1000.0);

            builder.pop();

            builder.push("Atom Splitter");
            AtomSplitterDamageMultiplier = builder
                    .comment("Atom Splitter Damage Multiplier")
                    .defineInRange("Atom Splitter Damage multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.pop();
            builder.push("Mob Settings");

            builder.push("General Settings");
            allowCameraShake = builder
                    .comment("allow Camera Shake")
                    .define("Allow Camera Shake",true);
            MiniBossDamageCap = builder
                    .comment("MiniBoss DamageCap")
                    .defineInRange("MiniBoss DamageCap",21,0,1000);
           // canSoulGreatSwordUseParry = builder
                   // .comment("allow Soul Great Sword Parry Ability")
                   // .define("Allow Soul Great Sword Parry Ability",true);
            BossesCancelEating = builder
                    .comment("Allow Bosses cancel eating")
                    .define("Allow Bosses cancel eating",true);
            AllowKnightSummonsInitiateAttack = builder
                    .comment("Allow Knight Summons Initiate Attack")
                    .define("Allow Knight Summons Initiate Attack",true);
            BossesReduceResistanceEffect = builder
                    .comment("Allow Bosses to reduce player's resistance effect")
                    .define("Allow Bosses to reduce player's resistance effect",true);
            allowCustomBossBar= builder
                    .comment("allow custom bossbars")
                    .define("Allow Custom Boss Bars",true);
            canBossesResetPhases= builder
                    .comment("for example when boss heals up after killing all players the boss will go back to previous phase")
                    .define("Allow Boss phase reset",true);

            AllowBossNatureHeal= builder
                    .comment("allow bosses healing when out of combat")
                    .define("Allow Bosses Natural Healing",true);
            canPlayBossMusic= builder
                    .comment("allow boss music")
                    .define("Allow Boss Music",true);

            canBossesTeleportBackToSpawn= builder
                    .comment("if Boss has no target and is > 15 blocks away from the spawn he will teleport back to the spawn position. That applies to mini bosses too.")
                    .define("Allow Bosses and Mini Bosses teleport back to their spawn Position",true);

            BossMusicVolumeMultiplier = builder
                    .comment("Boss Music Volume Multiplier")
                    .defineInRange("Boss Music Volume Multiplier", 1.0, 0.0, 1000.0);
            allowFallingCloudParticles= builder
                    .comment("Allow Falling Cloud Particles")
                    .define("Allow Falling Cloud Particles",true);
            allowDuoBossRespawnTeammate= builder
                    .comment("Allow duo boss respawn teammate when it's dead and duo boss has no target")
                    .define("Allow duo boss respawn teammate",true);
            builder.pop();

            builder.push("Chorusling Settings");
            ChoruslingDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Chorusling")
                    .defineInRange("Chorusling Damage Multiplier", 1.0, 0.0, 1000.0);
            ChoruslingHealthMultiplier = builder
                    .comment("Multiplies health of Chorusling")
                    .defineInRange("Chorusling Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Endersent Settings");
            EndersentDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Endersent")
                    .defineInRange("Endersent Damage Multiplier", 1.0, 0.0, 1000.0);
            EndersentHealthMultiplier = builder
                    .comment("Multiplies health of Endersent")
                    .defineInRange("Endersent Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Spiky Worm Settings");
            SpikyBugDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Spiky Worm")
                    .defineInRange("Spiky Worm Damage Multiplier", 1.0, 0.0, 1000.0);
            SpikyBugHealthMutliplier = builder
                    .comment("Multiplies health of Spiky Worm")
                    .defineInRange("Spiky Worm Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Ambusher Settings");
            AmbusherDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Ambusher")
                    .defineInRange("Ambusher Damage Multiplier", 1.0, 0.0, 1000.0);
            AmbusherHealthMutliplier = builder
                    .comment("Multiplies health of Ambusher")
                    .defineInRange("Ambusher Health Multiplier", 1.0, 0.0, 1000.0);

            Ambushprojectile = builder
                    .comment("Enables/Disables Projectile Damage For Ambusher")
                    .define("Allow Ambusher Projectile Immunity", true);



            builder.pop();
            builder.push("Stratling Settings");
            StratlingDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Stratling")
                    .defineInRange("Stratling Damage Multiplier", 1.0, 0.0, 1000.0);
            StratlingHealthMultiplier = builder
                    .comment("Multiplies health of Stratling")
                    .defineInRange("Stratling Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Hovering Hurricane Settings");
            HoveringHurricaneDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Hovering Hurricane")
                    .defineInRange("Hovering Hurricane Damage Multiplier", 1.0, 0.0, 1000.0);
            HoveringHurricaneHealthMultiplier = builder
                    .comment("Multiplies health of Hovering Hurricane")
                    .defineInRange("Hovering Hurricane Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Ancient Guardian Settings");
            AncientGuardianDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Ancient Guardian")
                    .defineInRange("Ancient Guardian Damage Multiplier", 1.0, 0.0, 1000.0);
            AncientGuardianHealthMutliplier = builder
                    .comment("Multiplies health of Ancient Guardian")
                    .defineInRange("Ancient Guardian Health Multiplier", 1.0, 0.0, 1000.0);
            AllowAncientGuardianStun = builder
                    .comment("Enables/Disables Stun Ability for Ancient Guardian. §cNOTE: Disabling This may make the bossfight less fun.")
                    .define("Allow Ancient Guardian Stun Ability",true);
            Ancientprojectile = builder
                    .comment("Enables/Disables Projectile Damage for Ancient Guardian")
                    .define("Allow Ancient Guardian Projectile Immunity", true);
            builder.pop();

            builder.push("Haunted Knight Settings");
            HauntedKnightDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Haunted Knight")
                    .defineInRange("Haunted Knight Damage Multiplier", 1.0, 0.0, 1000.0);
            HauntedKnightHealthMultiplier = builder
                    .comment("Multiplies health of Haunted Knight")
                    .defineInRange("Haunted Knight Health Multiplier", 1.0, 0.0, 1000.0);

            Knightprojectile = builder
                    .comment("Enables/Disables Projectile Immunity For Haunted Knight")
                    .define("Allow Haunted Knight Projectile Immunity", true);


            builder.pop();
            builder.push("Tamable Knight Settings");
            TamableKnightDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Tamable Knight")
                    .defineInRange("Tamable Knight Damage Multiplier", 1.0, 0.0, 1000.0);
            TamableKnightHealthMultiplier = builder
                    .comment("Multiplies health of Tamable Knight")
                    .defineInRange("Tamable Knight Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Tamable Guard Settings");
            TamableGuardDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Tamable Guard")
                    .defineInRange("Tamable Guard Damage Multiplier", 1.0, 0.0, 1000.0);
            TamableGuardHealthMultiplier = builder
                    .comment("Multiplies health of Tamable Guard")
                    .defineInRange("Tamable Guard Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Fractured Apostle Settings");
            FracturedApostleDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Fractured Apostle")
                    .defineInRange("Fractured Apostle Damage Multiplier", 1.0, 0.0, 1000.0);
            FracturedApostleHealthMultiplier = builder
                    .comment("Multiplies health of Fractured Apostle")
                    .defineInRange("Fractured Apostle Health Multiplier", 1.0, 0.0, 1000.0);

            builder.pop();
            builder.push("Fractured Settings");
            FracturedDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Fractured")
                    .defineInRange("Fractured Damage Multiplier", 1.0, 0.0, 1000.0);
            FracturedHealthMultiplier = builder
                    .comment("Multiplies health of Fractured")
                    .defineInRange("Fractured Health Multiplier", 1.0, 0.0, 1000.0);

            builder.pop();
            builder.push("Haunted Guard Settings");
            HauntedGuardDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Haunted Guard")
                    .defineInRange("Haunted Guard Damage Multiplier", 1.0, 0.0, 1000.0);
            HauntedGuardHealthMultiplier = builder
                    .comment("Multiplies health of Haunted Guard")
                    .defineInRange("Haunted Guard Health Multiplier", 1.0, 0.0, 1000.0);

            Guardprojectile = builder
                    .comment("Enables/Disables Projectile Immunity For Haunted Guard")
                    .define("Allow Haunted Guard Projectile Immunity", true);

            builder.pop();
            builder.push("Posessed Paladin Settings");
            PosessedPaladinDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Posessed Paladin")
                    .defineInRange("Posessed Paladin Damage Multiplier", 1.0, 0.0, 1000.0);
            PossessedPaladinHealthMultiplier = builder
                    .comment("Multiplies health of Posessed Paladin.")
                    .defineInRange("Posessed Paladin Health Multiplier", 1.0, 0.0, 1000.0);

            PossessedPaladinDamageCap = builder
                    .comment("Damage Cap")
                    .defineInRange("Damage Cap", 21.0, 0.0, 1000.0);
            Posessedprojectile = builder
                    .comment("Enables/Disables Projectile Immunity for Posessed Paladin")
                    .define("Allow Posessed Paladin Projectile Immunity", true);
            PossessedPaladinInvulnerabilityTime = builder
                    .comment("Allow Possesed Paladin Invulnerability Time")
                    .define("Allow Possesed Paladin Invulnerability Time", true);

            builder.pop();
            builder.push("Beheaded Knight Settings");
            BeheadedKnightDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Beheaded Knight")
                    .defineInRange("Beheaded Knight Damage Multiplier", 1.0, 0.0, 1000.0);
            BeheadedKnightHealthMutliplier = builder
                    .comment("Multiplies health of Beheaded Knight")
                    .defineInRange("Beheaded Knight Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Resurrected Knight Settings");
            ResurrectedKnightDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Resurrected Knight")
                    .defineInRange("Resurrected Knight Damage Multiplier", 1.0, 0.0, 1000.0);
            ResurrectedKnightHealthMutliplier = builder
                    .comment("Multiplies health of Resurrected Knight")
                    .defineInRange("Resurrected Knight Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Overgrown Colosuss Settings");
            OvergrownColosussDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Overgrown Colosuss")
                    .defineInRange("Overgrown Colosuss Damage Multiplier", 1.0, 0.0, 1000.0);
            OvergrownColosussHealthMultiplier = builder
                    .comment("Multiplies health of Overgrown Colosuss")
                    .defineInRange("Overgrown Colosuss Health Multiplier", 1.0, 0.0, 1000.0);
            AllowOvergrownColosussStun = builder
                    .comment("Enables/Disables Stun Ability for Overgrown Colosuss. §cNOTE: Disabling This may make the bossfight less fun.")
                    .define("Allow Overgrown Colosuss Stun Ability",true);
            Overgrownprojectile = builder
                    .comment("Enables/Disables Projectile Immunity for Overgrown Colosuss")
                    .define("Allow Overgrown Colosuss Projectile Immunity", true);
            builder.pop();
            builder.push("Mossy Golem Settings");
            MossyGolemDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Mossy Golem")
                    .defineInRange("Mossy Golem Damage Multiplier", 1.0, 0.0, 1000.0);
            MossyGolemHealthMultiplier = builder
                    .comment("Multiplies health of Mossy Golem")
                    .defineInRange("Mossy Golem Health Multiplier", 1.0, 0.0, 1000.0);

            builder.pop();
            builder.push("Cloud Golem Settings");
            CloudGolemDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Cloud Golem")
                    .defineInRange("Cloud Golem Damage Multiplier", 1.0, 0.0, 1000.0);

            CloudGolemHealthMultiplier = builder
                    .comment("Multiplies health of Cloud Golem")
                    .defineInRange("Cloud Golem Health Multiplier", 1.0, 0.0, 1000.0);
            Cloudprojectile = builder
                    .comment("Enables Projectile Damage for Cloud Golem")
                    .define("Allow Cloud Golem Projectile Damage", false);

            CloudGolemLosesConsciousness = builder
                    .comment("Cloud Golem loses Consciousness after Laser Attack")
                    .define("Allow Cloud Golem Loses Consciousness", true);
            CloudGolemCanCharge2Times = builder
                    .comment("Cloud Golem can Charge once more after missing when he is low on HP")
                    .define("Allow Cloud Golem Charge once More", true);
            CloudGolemInvulnerabilityTime = builder
                    .comment("Enables/Disables Cloud Golem Invulnerability Time (this boss is not getting schredded in 0.5seconds by frame - ignore weapons)")
                    .define("Allow Cloud Golem Invulnerability Time", true);
            CloudGolemDamageCap = builder
                    .comment("Maximum damage that can be dealt to Cloud Golem")
                    .defineInRange("Cloud Golem Damage Cap", 18.0, 0.0, 1000.0);

            builder.pop();
            builder.push("Cloud Golem's Falling Cloud Settings");
            CGFallingCloudDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Falling Cloud")
                    .defineInRange("Falling Cloud Damage Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("Frostbitten Golem Settings");
            FrostbittenGolemDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Frostbitten Golem")
                    .defineInRange("Frostbitten Golem Damage Multiplier", 1.0, 0.0, 1000.0);
            FrostbittenGolemHealthMultiplier = builder
                    .comment("Multiplies health of Frostbitten Golem")
                    .defineInRange("Frostbitten Golem Health Multiplier", 1.0, 0.0, 1000.0);
            Frostbittenprojectile = builder
                    .comment("Enables/Disables Projectile Immunity for Frostbitten Golem")

                    .define("Allow Frostbitten Golem Projectile Immunity", true);
            builder.pop();
            builder.push("Dune Sentinel Settings");
            DuneSentinelDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Dune Sentinel")
                    .defineInRange("Dune Sentinel Damage Multiplier", 1.0, 0.0, 1000.0);
            DuneSentinelHealthMultiplier = builder
                    .comment("Multiplies health of Dune Sentinel")
                    .defineInRange("Dune Sentinel Health Multiplier", 1.0, 0.0, 1000.0);
            Duneprojectile = builder
                    .comment("Enables/Disables Projectile Immunity for Dune Sentinel")
                    .define("Allow Dune Sentinel Projectile Immunity", true);
            builder.pop();
            builder.push("Dune Sentinel Settings");
            BomberDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Bomber")
                    .defineInRange("Bomber Damage Multiplier", 1.0, 0.0, 1000.0);
            BomberHealthMultiplier = builder
                    .comment("Multiplies health of Bomber")
                    .defineInRange("Bomber Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Skeletosaurus Settings");
            SkeletosaurusDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Skeletosaurus")
                    .defineInRange("Skeletosaurus Damage Multiplier", 1.0, 0.0, 1000.0);
            SkeletosaurusHealthMultiplier = builder
                    .comment("Multiplies health of Skeletosaurus")
                    .defineInRange("Skeletosaurus Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Lava Eater Settings");
            LavaEaterDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Lava Eater")
                    .defineInRange("Lava Eater Damage Multiplier", 1.0, 0.0, 1000.0);
            LavaEaterHealthMultiplier = builder
                    .comment("Multiplies health of Lava Eater")
                    .defineInRange("Lava Eater Health Multiplier", 1.0, 0.0, 1000.0);
            Lavaprojectile = builder
                    .comment("Disables/Enables Projectile Immunity for Lava Eater")

                    .define("Allow Lava Eater Projectile Immunity", true);
            builder.pop();
            builder.push("Warped Fungussus Settings");
            WarpedFungussusDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Warped Fungussus")
                    .defineInRange("Warped Fungussus Damage Multiplier", 1.0, 0.0, 1000.0);
            WarpedFungussusHealthMultiplier = builder
                    .comment("Multiplies health of Warped Fungussus")
                    .defineInRange("Warped Fungussus Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Withered Abomination Settings");
            WitheredAbominationDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Withered Abomination")
                    .defineInRange("Withered Abomination Damage Multiplier", 1.0, 0.0, 1000.0);
            WitheredAbominationHealthMultiplier = builder
                    .comment("Multiplies health of Withered Abomination")
                    .defineInRange("Withered Abomination Health Multiplier", 1.0, 0.0, 1000.0);
            AllowWitheredAbominationStun = builder
                    .comment("Enables/Disables Stun Ability for Withered Abomination")
                    .define("Allow Withered Abomination Stun Ability",false);
            builder.pop();

            builder.push("Shulker Mimic Settings");
            ShulkerMimicDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Shulker Mimic")
                    .defineInRange("Shulker Mimic Damage Multiplier", 1.0, 0.0, 1000.0);
            ShulkerMimicHealthMultiplier = builder
                    .comment("Multiplies health of Shulker Mimic")
                    .defineInRange("Shulker Mimic Health Multiplier", 1.0, 0.0, 1000.0);
            Shulkerprojectile = builder
                    .comment("Enables/Disables Projectile immunity for Shulker Mimic")
                    .define("Allow Shulker Mimic Projectile Immunity", true);
            builder.pop();
            builder.push("Tamable Knight Settings");
            FKnightDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Knight")
                    .defineInRange("Knight Damage Multiplier", 1.0, 0.0, 100.0);
            FKnightHealthMutliplier = builder
                    .comment("Multiplies health of Knight")
                    .defineInRange("Knight Health Multiplier", 1.0, 0.0, 100.0);
            builder.pop();
            builder.push("Tamable Guard Settings");
            FGuardDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Guard")
                    .defineInRange("Guard Damage Multiplier", 1.0, 0.0, 1000.0);
            FGuardHealthMutliplier = builder
                    .comment("Multiplies health of Guard")
                    .defineInRange("Guard Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Skeloraptor Settings");
            SkeloraptorDamageMultiplier = builder
                    .comment("Multiplies damage dealt by Skeloraptor")
                    .defineInRange("Skeloraptor Damage Multiplier", 1.0, 0.0, 1000.0);
            SkeloraptorHealthMutliplier = builder
                    .comment("Multiplies health of Skeloraptor")
                    .defineInRange("Skeloraptor Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Flameborn Guard Settings");
            FlamebornGuardDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Flameborn Guard")
                    .defineInRange("The Flameborn Guard Damage Multiplier", 1.0, 0.0, 1000.0);
            FlamebornGuardHealthMultiplier = builder
                    .comment("Multiplies damage of Flameborn Guard")
                    .defineInRange("Flameborn Guard Damage Multiplier", 1.0, 0.0, 1000.0);
builder.pop();
            builder.push("Annihilation Pursuer Settings");
            AnnihilationPursuerDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Annihilation Pursuer")
                    .defineInRange("Annihilation Pursuer Damage Multiplier", 1.0, 0.0, 1000.0);
            AnnihilationPursuerHealthMultiplier = builder
                    .comment("Multiplies damage of Annihilation Pursuer")
                    .defineInRange("Annihilation Pursuer Damage Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();

            builder.push("The Obliterator Settings");
            TheObliteratorDamageMutliplier = builder
                    .comment("Multiplies damage dealt by The Obliterator")
                    .defineInRange("The Obliterator Damage Multiplier", 1.0, 0.0, 1000.0);
            TheObliteratorHealthMultiplier = builder
                    .comment("Multiplies Health of The Obliterator")
                    .defineInRange("The Obliterator Health Multiplier", 1.0, 0.0, 1000.0);
            TheObliteratorAdaptationFactorMultiplier = builder
                    .comment("The bigger it is the stronger the Damage Adaptation is")
                    .defineInRange("The Obliterator Damage Adaptation Multiplier", 1, 0, 1000);
            TheObliteratorDamageCap = builder
                    .comment("DamageCap")
                    .defineInRange("DamageCap", 20.0, 0.0, 1000.0);
            TheObliteratorInvulnerabilityTime = builder
                    .comment("ON/OFF Obliterator I Frame protection")
                    .define("The Obliterator Invulnerability Time",true);
            TheObliteratorAntiAirborneDistance = builder
                    .comment("Increases/Decreases Anti Cheese(Airborne Variation) distance which makes the Boss invulnerable when player has a high ground, default is -4 below the boss and 4 above. chaning the value will change both '-' and '+' values.")
                    .defineInRange("Protection against airborne cheese",4,0,1000);

            TheObliteratorAnnihilationEffect = builder
                    .comment("ON/OFF Annihilation effect that The Obliterator Inflicts after hitting you, it's a stacking debuff that reduces your attack speed.")
                    .define("The Obliterator Annihilation Debuff Effect",false);
            TheObliteratorCloneBurstHPDamage = builder
                    .comment("% Damage for Obliterator's clones(punching)")
                    .defineInRange("% Damage for Obliterator's clones(punching)",7,0,1000);
            TheObliteratorPortalHPDamage = builder
                    .comment("% Damage for Obliterator's portals")
                    .defineInRange("% Damage for Obliterator's portals",5,0,1000);

            TheObliteratorPortalExplosionHPDamage = builder
                    .comment("% Damage for Obliterator's portal Explosion")
                    .defineInRange("% Damage for Obliterator's portal Explosion",3,0,1000);

            builder.pop();
            builder.push("Flame Drifter Settings");
            FlameDrifterDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Flame Drifter")
                    .defineInRange("Flame Drifter Damage Multiplier", 1.0, 0.0, 1000.0);
            FlameDrifterHealthMultiplier = builder
                    .comment("Multiplies Health of Flame Drifter")
                    .defineInRange("Flame Drifter Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
            builder.push("Wandering Eye Settings");
            WanderingEyeDamageMutliplier = builder
                    .comment("Multiplies damage dealt by Wandering Eye")
                    .defineInRange("Wandering Eye Damage Multiplier", 1.0, 0.0, 1000.0);
            WanderingEyeHealthMultiplier = builder
                    .comment("Multiplies Health of Wandering Eye")
                    .defineInRange("Wandering Eye Health Multiplier", 1.0, 0.0, 1000.0);
            builder.pop();
        }
    }
}
