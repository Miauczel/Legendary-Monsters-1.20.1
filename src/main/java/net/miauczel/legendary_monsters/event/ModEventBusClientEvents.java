package net.miauczel.legendary_monsters.event;
import net.miauczel.legendary_monsters.LegendaryMonsters;

import net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer.*;
import net.miauczel.legendary_monsters.entity.client.*;

import net.miauczel.legendary_monsters.entity.client.Model.*;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.EnderAnchorModel;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SomberTrapdoorModel;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SwingingAxeModel;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.TeleportMachineModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.ResurrectedJavelinItemModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.ShatteredGreatswordItemModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.TheTesseractItemModel;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class    ModEventBusClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        ItemProperties.register(
                ModItems.ATOM_SPLITTER.get(),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "atom_splitter_3d"),
                (stack, world, entity, seed) -> 0
        );
    }
    @SubscribeEvent
    public static void RegisterModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(ModModelLayers.SKELETOSAURUS_LAYER, SkeletosaurusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.OVERGROWN_COLOSSUS_LAYER, Overgrown_colossusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ENDERSENT_LAYER, EndersentModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WARPED_FUNGUSSUS_LAYER, Warped_FungussusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LAVA_EATER_LAYER, Lava_eaterModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FROSTBITTEN_GOLEM_LAYER, Frostbitten_GolemModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SHULKER_MIMIC_LAYER, Shulker_MimicModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHORUSLING_LAYER, ChoruslingModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WITHERED_ABOMINATION_LAYER, Withered_AbominationModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ANCIENT_GUARDIAN_LAYER, Ancient_GuardianModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.AMBUSHER_LAYER, AmbusherModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SPIKEBUG_LAYER, SpikebugModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CLOUD_GOLEM_LAYER, Cloud_GolemModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.THROWN_SPEAR_LAYER, SpearModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.LIVING_ARMOR_LAYER, LivingArmorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HAUNTED_GUARD_LAYER, HauntedGuardModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GOLDEN_HALBERT_LAYER, GoldenHalbertModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.POSESSED_PALADIN_LAYER, PosessedPaladinModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FLIVING_ARMOR_LAYER, FLivingArmorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FHAUNTED_GUARD_LAYER, FHauntedGuardModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MOSSY_GOLEM_LAYER, MossyGolemModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MINI_SKELETOSAURUS_LAYER, SkeloraptorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BIG_CANNON_LAYER, DuneSentinelModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BOMB_LAYER, BombModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.BOMBER_LAYER, BomberModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHORUS_BOMB_LAYER, ChorusBombModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.ICE_SPIKE, IceSpikeModel::createLayerDefinition);
        event.registerLayerDefinition(ModModelLayers.Cloud, CloudModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SHL, SoulHandModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.STRATLING_LAYER, StratlingModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.Small_cloud, SmallCloudModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LIGHTNING_STRIKE_LAYER, LightningStrikeModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HURRICANE_LAYER, HoveringHurricaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NEW_POSSESSED_PALADIN_LAYER, NewPossessedPaladinModel::createBodyLayer);
     event.registerLayerDefinition(ModModelLayers.THE_OBLITERATOR_LAYER, TheObliteratorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHORUS_ENERGY_BULLET_LAYER, ChorusEnergyBulletModel::createLayer);

        event.registerLayerDefinition(ModModelLayers.SOUL_BLADE_LAYER, SoulBladeUndergroundModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FALLING_SOUL_BLADE_LAYER, SoulBladeFallingModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BIG_SHULKER_BULLET_LAYER, BigShulkerBulletModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SMALL_POWER_BALL_LAYER, SmallPowerBallBombModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.THE_OBLITERATOR_CLONE_LAYER, TheObliteratorCloneModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.THE_OBLITERATOR_CLONE_ARMED_LAYER, TheObliteratorArmedCloneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.POWER_BALL_LAYER, PowerBallBombModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.OLD_SHULKER_MIMIC_LAYER, Shulker_MimicOldModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FLYING_ARMOR_LAYER, FlyingArmorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FLAME_ROCKET_LAYER, FlameRocketModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FLAME_DRIFTER_LAYER, FlameDrifterModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FLAMEBORN_GUARD_LAYER, FlamebornGuardModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.GRAVITY_BIG_SHULKER_BULLET_LAYER, GravityBigShulkerBulletModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.ANNIHILATION_PURSUER_LAYER, AnnihilationPursuerModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.ENDER_ANCHOR_LAYER, EnderAnchorModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.TESSERACT_LAYER, TheTesseractItemModel  ::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SHATTERED_GREATSWORD_LAYER, ShatteredGreatswordItemModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.RESURRECTED_JAVELIN_LAYER, ResurrectedJavelinItemModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.TELEPORT_MACHINE_LAYER, TeleportMachineModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SWINGING_AXE_LAYER, SwingingAxeModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SOMBER_TRAPDOOR_LAYER, SomberTrapdoorModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.WANDERING_EYE, WanderingEyeModel  ::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FLAMEBORN_WARRIOR_LAYER, FlamebornWarriorModel  ::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.PHANTOM_DAGGER, ThrownPhantomDaggerModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SOUL_SHIELD_LAYER, SoulShieldModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.BEHEADED_KNIGHT_LAYER, BeheadedKnightModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.RESURRECTED_KNIGHT_LAYER, ResurrectedKnightModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SOUL_JAVELIN_LAYER, SoulJavelinModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SOUL_TRIDENT_LAYER, SoulTridentModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FRACTURED_LAYER, FracturedModel::createBodyLayer);


        event.registerLayerDefinition(ModModelLayers.THROWN_RESURRECTED_JAVELIN_LAYER, ResurrectedJavelinModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.FRACTURED_APOSTLE_LAYER, FracturedApostleModel::createBodyLayer);

}
}




