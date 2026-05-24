package net.miauczel.legendary_monsters.event;


import net.miauczel.legendary_monsters.LegendaryMonsters;
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
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void RegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.Skeletosaurus.get(), SkeletosaurusEntity.createAttributes().build());
        event.put(ModEntities.Posessed_Paladin.get(), PossessedPaladinEntity.createAttributes().build());
        event.put(ModEntities.Overgrown_colossus.get(), Overgrown_colossusEntity.createAttributes().build());
        event.put(ModEntities.Endersent.get(), EndersentEntity.createAttributes().build());
        event.put(ModEntities.Warped_Fungussus.get(), Warped_FungussusEntity.createAttributes().build());
        event.put(ModEntities.Lava_eater.get(), Lava_eaterEntity.createAttributes().build());
        event.put(ModEntities.Frostbitten_Golem.get(), Frostbitten_GolemEntity.createAttributes().build());
        event.put(ModEntities.Shulker_Mimic.get(), Shulker_MimicEntity.createAttributes().build());
        event.put(ModEntities.Chorusling.get(), ChoruslingEntity.createAttributes().build());
        event.put(ModEntities.Withered_Abomination.get(), Withered_AbominationEntity.createAttributes().build());
        event.put(ModEntities.Ancient_Guardian.get(), Ancient_GuardianEntity.createAttributes().build());
        event.put(ModEntities.Ambusher.get(), AmbusherEntity.createAttributes().build());
        event.put(ModEntities.Spiky_bug.get(), SpikebugEntity.createAttributes().build());
        event.put(ModEntities.Cloud_golem.get(), Cloud_GolemEntity.createAttributes().build());
        event.put(ModEntities.Haunted_Knight.get(), HauntedKnightEntity.createAttributes().build());
        event.put(ModEntities.Haunted_Guard.get(), HauntedGuardEntity.createAttributes().build());
        event.put(ModEntities.Knights_Armor.get(), FLivingArmorEntity.createAttributes().build());
        event.put(ModEntities.Guard.get(), FHauntedGuardEntity.createAttributes().build());
        event.put(ModEntities.Skeleraptor.get(), SkeloraptorEntity.createAttributes().build());
        event.put(ModEntities.Mossy_Golem.get(), MossyGolemEntity.createAttributes().build());
        event.put(ModEntities.BlastCannon.get(), DuneSentinelEntity.createAttributes().build());
        event.put(ModEntities.Bomber.get(), BomberEntity.createAttributes().build());
        event.put(ModEntities.Stratling.get(), StratlingEntity.createAttributes().build());

        event.put(ModEntities.FLAMEBORN_GUARD.get(), FlamebornGuardEntity.createAttributes().build());
     event.put(ModEntities.THE_OBLITERATOR.get(), TheObliteratorEntity.createAttributes().build());
        event.put(ModEntities.HoverinngHurricane.get(), HoveringHurricaneEntity.createAttributes().build());

        event.put(ModEntities.FLAME_DRIFTER.get(), FlameDrifterEntity.createAttributes().build());

        event.put(ModEntities.ANNIHILATION_PURSUER.get(), AnnihilationPursuerEntity.createAttributes().build());

        event.put(ModEntities.WANDERING_EYE.get(), WanderingEyeEntity.createAttributes().build());

        event.put(ModEntities.FLAMEBORN_WARRIOR.get(), FlamebornWarriorEntity.createAttributes().build());

        event.put(ModEntities.BEHEADED_KNIGHT.get(), BeheadedKnightEntity.createAttributes().build());

        event.put(ModEntities.RESURRECTED_KNIGHT.get(), ResurrectedKnightEntity.createAttributes().build());

        event.put(ModEntities.FRACTURED_APOSTLE.get(), FracturedApostleEntity.createAttributes().build());

        event.put(ModEntities.FRACTURED.get(), FracturedEntity.createAttributes().build());
    }

}



