package net.miauczel.legendary_monsters.sound;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds extends SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<SoundEvent> ENDERSENT_ATTACK = registerSoundEvents("endersent_attack");
    public static final RegistryObject<SoundEvent> ENDERSENT_AMBIENT = registerSoundEvents("endersent_ambient");
    public static final RegistryObject<SoundEvent> ENDERSENT_DEATH = registerSoundEvents("endersent_death");

    public static final RegistryObject<SoundEvent> ENDERSENT_HURT1 = registerSoundEvents("endersent_hurt1");

    public static final RegistryObject<SoundEvent> ENDERSENT_HURT2 = registerSoundEvents("endersent_hurt2");

    public static final RegistryObject<SoundEvent> OVERGROWN_COLOSSUS_HURT = registerSoundEvents("overgrown_colossus_hurt");

    public static final RegistryObject<SoundEvent> OVERGROWN_COLOSSUS_DEATH = registerSoundEvents("overgrown_colossus_death");
    public static final RegistryObject<SoundEvent> SKELETOSAURUS_HURT1 = registerSoundEvents("skeletosaurus_hurt1");
    public static final RegistryObject<SoundEvent> SKELETOSAURUS_HURT2 = registerSoundEvents("skeletosaurus_hurt2");
    public static final RegistryObject<SoundEvent> SKELETOSAURUS_HURT3 = registerSoundEvents("skeletosaurus_hurt3");
    public static final RegistryObject<SoundEvent> SKELETOSAURUS_DEATH = registerSoundEvents("skeletosaurus_death");

    public static final RegistryObject<SoundEvent> CHORUSLING_DEATH = registerSoundEvents("chorusling_death");
    public static final RegistryObject<SoundEvent> CHORUSLING_HURT = registerSoundEvents("chorusling_hurt");

    public static final RegistryObject<SoundEvent> CHORUSLING_AMBIENT = registerSoundEvents("chorusling_ambient");
    public static final RegistryObject<SoundEvent> CHORUSLING_ATTACK = registerSoundEvents("chorusling_attack");
    public static final RegistryObject<SoundEvent> WITHERED_ABOMINATION_HURT = registerSoundEvents("withered_abomination_hurt");
    public static final RegistryObject<SoundEvent> WITHERED_ABOMINATION_DEATH = registerSoundEvents("withered_abomination_death");

    public static final RegistryObject<SoundEvent> ANCIENT_GUARDIAN_HURT = registerSoundEvents("ancient_guardian_hurt");

    public static final RegistryObject<SoundEvent> ANCIENT_GUARDIAN_DEATH = registerSoundEvents("ancient_guardian_death");
    public static final RegistryObject<SoundEvent> LIVING_ARMOR_HURT = registerSoundEvents("living_armor_hurt");
    public static final RegistryObject<SoundEvent> WEAPON_SPIN = registerSoundEvents("posessed_paladin_spin");
    public static final RegistryObject<SoundEvent> GENERIC_ARM_SWING = registerSoundEvents("posessed_paladin_swing");
    public static final RegistryObject<SoundEvent> POSESSED_PALADIN_ATTACK = registerSoundEvents("posessed_paladin_attack");
    public static final RegistryObject<SoundEvent> POSESSED_PALADIN_ATTACK2 = registerSoundEvents("posessed_paladin_attack2");
    public static final RegistryObject<SoundEvent> POSESSED_PALADIN_ATTACK3 = registerSoundEvents("posessed_paladin_attack3");
    public static final RegistryObject<SoundEvent> MOSSY_GOLEM_SWING = registerSoundEvents("mossy_golem_swing");
    public static final RegistryObject<SoundEvent> MOSSY_GOLEM_ATTACK = registerSoundEvents("mossy_golem_attack");
    public static final RegistryObject<SoundEvent> STEP_SOUND = registerSoundEvents("step_sound");
    public static final RegistryObject<SoundEvent> STEP_SOUND2 = registerSoundEvents("step_sound_2");
    public static final RegistryObject<SoundEvent> STEP_SOUND3 = registerSoundEvents("step_sound_3");
    public static final RegistryObject<SoundEvent> STEP_SOUND4 = registerSoundEvents("step_sound_4");
    public static final RegistryObject<SoundEvent> CANNON_SHOOT_1 = registerSoundEvents("cannon_shoot_1");
    public static final RegistryObject<SoundEvent> CANNON_SHOOT_2 = registerSoundEvents("cannon_shoot_2");
    public static final RegistryObject<SoundEvent> CANNON_SHOOT_3 = registerSoundEvents("cannon_shoot_3");
    public static final RegistryObject<SoundEvent> FATAL_MORTAR_ATTACK = registerSoundEvents("fatal_mortar_attack");
    public static final RegistryObject<SoundEvent> DUNE_SENTINEL_HURT = registerSoundEvents("dune_sentinel_hurt");
    public static final RegistryObject<SoundEvent> DUNE_SENTINEL_DEATH = registerSoundEvents("dune_sentinel_death");
    public static final RegistryObject<SoundEvent> WITHERED_ABOMINATION_DASH = registerSoundEvents("withered_abomination_dash");
    public static final RegistryObject<SoundEvent> WITHERED_ABOMINATION_DASH2 = registerSoundEvents("withered_abomination_dash2");
    public static final RegistryObject<SoundEvent> ANCHOR_SLAM = registerSoundEvents("anchor_slam");
    public static final RegistryObject<SoundEvent> ANCHOR_SWING1 = registerSoundEvents("anchor_swing1");
    public static final RegistryObject<SoundEvent> ANCHOR_SWING2 = registerSoundEvents("anchor_swing2");
    public static final RegistryObject<SoundEvent> ANCHOR_HIT = registerSoundEvents("anchor_hit");
    public static final RegistryObject<SoundEvent> ICE_SPIKE_EMERGE = registerSoundEvents("ice_spike_emerge");
    public static final RegistryObject<SoundEvent> ANCIENT_GUARDIAN_ROAR = registerSoundEvents("ancient_guardian_roar");
    public static final RegistryObject<SoundEvent> POSSESSED_PALADIN_SWING = registerSoundEvents("pp_swing");

    public static final RegistryObject<SoundEvent> BEAM_CHARGE = registerSoundEvents("beam_charge");

    public static final RegistryObject<SoundEvent> BEAM_GO = registerSoundEvents("beam_go");

    public static final RegistryObject<SoundEvent> CGH = registerSoundEvents("cloud_golem_hurt");
    public static final RegistryObject<SoundEvent> BEAM_LOOP = registerSoundEvents("beam_loop");

    public static final RegistryObject<SoundEvent> CGA = registerSoundEvents("cloud_golem_ambient");

    public static final RegistryObject<SoundEvent> CGD = registerSoundEvents("cloud_golem_death");

    public static final RegistryObject<SoundEvent> LS = registerSoundEvents("lightning_strike");

    public static final RegistryObject<SoundEvent> GROUND_IMPACT = registerSoundEvents("ground_impact");
    public static final RegistryObject<SoundEvent> ENDERSENT_TP_HIT = registerSoundEvents("endersent_tp_hit");
    public static final RegistryObject<SoundEvent> CLOUD_GOLEM_MUSIC = registerSoundEvents("cloud_golem_music");

    public static final RegistryObject<SoundEvent> CLOUD_GOLEM_MUSIC_STEREO = registerSoundEvents("cloud_golem_music_stereo");
    public static final RegistryObject<SoundEvent> THE_WARPED_ONE_ROAR = registerSoundEvents("the_warped_one_roar");

    public static final RegistryObject<SoundEvent> POWERFUL_SWORD_IMPACT = registerSoundEvents("powerful_sword_impact");

    public static final RegistryObject<SoundEvent> POWERFUL_SWORD_IMPACT2 = registerSoundEvents("powerful_sword_impact2");

    public static final RegistryObject<SoundEvent> SOUL_FLY = registerSoundEvents("soul_fly");

    public static final RegistryObject<SoundEvent> WEAPON_IMPACT = registerSoundEvents("weapon_impact");
    public static final RegistryObject<SoundEvent> THE_WARPED_ONE_SHOOT = registerSoundEvents("the_warped_one_shoot");

    public static final RegistryObject<SoundEvent> THE_WARPED_ONE_HURT = registerSoundEvents("the_warped_one_hurt");

    public static final RegistryObject<SoundEvent> DIMENSIONAL_BOMB_EXPLODE = registerSoundEvents("dimensional_bomb_explode");
    public static final RegistryObject<SoundEvent> DIMENSIONAL_BOMB_EXPLODE_SMALL = registerSoundEvents("dimensional_bomb_explosion2");

    public static final RegistryObject<SoundEvent> DIMENSIONAL_SHOOT_CHARGE = registerSoundEvents("dimensional_shoot_charge");

    public static final RegistryObject<SoundEvent> ENERGY_EXPLOSION = registerSoundEvents("energy_explosion");

    public static final RegistryObject<SoundEvent> HEAVY_SWING = registerSoundEvents("heavy_swing");
    public static final RegistryObject<SoundEvent> THE_OBLITERATOR_STUN = registerSoundEvents("the_warped_one_stun");

    public static final RegistryObject<SoundEvent> HUGE_ENERGY_EXPLOSION = registerSoundEvents("huge_energy_explosion");

    public static final RegistryObject<SoundEvent> THE_WARPED_ONE_HURT2 = registerSoundEvents("the_warped_one_hurt2");

    public static final RegistryObject<SoundEvent> ANNIHILATION_LASER_SINGLE_SHOOT = registerSoundEvents("single_annihilation_laser_shoot");

    public static final RegistryObject<SoundEvent> ANNIHILATION_LASER_CHARGE = registerSoundEvents("annihilation_laser_charge");
    public static final RegistryObject<SoundEvent> QUAD_ANNIHILATION_LASER_SHOOT = registerSoundEvents("quad_laser_shoot");
    public static final RegistryObject<SoundEvent> OBLITERATOR_ARM_SHOOT = registerSoundEvents("obliterator_arm_shoot");
    public static final RegistryObject<SoundEvent> OMINOUS_EXPLOSION = registerSoundEvents("ominous_explosion");

    public static final RegistryObject<SoundEvent> FLAME_BURST = registerSoundEvents("flame_burst");

    public static final RegistryObject<SoundEvent> BLOCK = registerSoundEvents("block");

    public static final RegistryObject<SoundEvent> ULTIMATE_FLAME_IMPACT = registerSoundEvents("ultimate_flame_impact");
    public static final RegistryObject<SoundEvent> ULTIMATE_FLAME_BIG_IMPACT = registerSoundEvents("ultimate_flame_big_impact");
    public static final RegistryObject<SoundEvent> FLAME_DRIFTER_CHARGE_SHOOT = registerSoundEvents("flame_drifter_charge_shoot");

    public static final RegistryObject<SoundEvent> THE_OBLITERATOR_SHORT_ROAR = registerSoundEvents("the_obliterator_short_roar");

    public static final RegistryObject<SoundEvent> STAB_HIT = registerSoundEvents("stab_hit");
    public static final RegistryObject<SoundEvent> POSSESSED_PALADIN_STAB = registerSoundEvents("pp_stab");

    public static final RegistryObject<SoundEvent> HEAVY_STAB = registerSoundEvents("heavy_stab");

    public static final RegistryObject<SoundEvent> SOUL_SHIELD_SMASH = registerSoundEvents("soul_shield_smash");

    public static final RegistryObject<SoundEvent> OBLITERATOR_STEREO = registerSoundEvents("obliterator_stereo");
    public static final RegistryObject<SoundEvent> OBLITERATOR_MONO = registerSoundEvents("obliterator_mono");

    public static final RegistryObject<SoundEvent> DAGGER_THROW = registerSoundEvents("dagger_throw");

    public static final RegistryObject<SoundEvent> POSSESSED_PALADIN_ROLL = registerSoundEvents("possessed_paladin_roll");

    public static final RegistryObject<SoundEvent> OMINOUS_WIND_UP = registerSoundEvents("ominous_windup");

    public static final RegistryObject<SoundEvent> SPEAR_STAB = registerSoundEvents("spear_stab");

    public static final RegistryObject<SoundEvent> WANDERING_EYE_HURT = registerSoundEvents("wandering_eye_hurt");

    public static final RegistryObject<SoundEvent> WANDERING_EYE_AMBIENT = registerSoundEvents("wandering_eye_ambient");

    public static final RegistryObject<SoundEvent> POSSESSED_PALADIN_MONO = registerSoundEvents("possessed_paladin_mono");

    public static final RegistryObject<SoundEvent> POSSESSED_PALADIN_STEREO = registerSoundEvents("possessed_paladin_stereo");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LegendaryMonsters.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}

