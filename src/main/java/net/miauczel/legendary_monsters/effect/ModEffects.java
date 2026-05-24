package net.miauczel.legendary_monsters.effect;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.effect.custom.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class ModEffects {

    public static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LegendaryMonsters.MOD_ID);
    public static final RegistryObject<MobEffect> SOUL_FRACTURE = MOB_EFFECTS.register("soul_fracture",
            () -> new SoulEater(MobEffectCategory.HARMFUL, 542834).addAttributeModifier(Attributes.MAX_HEALTH, "CB3F55D3-645C-4F38-A497-9C13A33DB5CF", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> CHORUSINFECTION = MOB_EFFECTS.register("chorus_infection",
            () -> new ChorusInfection(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new Freeze(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<MobEffect> UNBREAKABLE = MOB_EFFECTS.register("unbreakable",
            () -> new Unbreakable(MobEffectCategory.BENEFICIAL, 0x11ff00));

    public static final RegistryObject<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
            () -> new Bleeding(MobEffectCategory.HARMFUL, 11141120));

    public static final RegistryObject<MobEffect> low_attack_reach = MOB_EFFECTS.register("low_attack_reach", () -> new LowAttackReach(MobEffectCategory.HARMFUL,1));
    public static final RegistryObject<MobEffect> SOUL_RAGE = MOB_EFFECTS.register("soul_rage", () -> new Rage(MobEffectCategory.BENEFICIAL,11141120)
            .addAttributeModifier(Attributes.ARMOR, "91AEAA56-376B-4498-935B-2F7F68070635", (double)6F, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", (double)0.5F, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "91AEAA56-376B-4498-935B-2F7F68070635", (double)1F, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> BROKEN_ARMOR = MOB_EFFECTS.register("broken_armor", () -> new BrokenArmor(MobEffectCategory.HARMFUL,0)
            .addAttributeModifier(Attributes.ARMOR, "91AEAA56-376B-4498-935B-2F7F68070635", -2F, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> STUN = MOB_EFFECTS.register("stun", () -> new Stun(MobEffectCategory.HARMFUL,0)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", -1, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", -1, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> GRAVITY_PULL = MOB_EFFECTS.register("gravity_pull", () -> new FastFalling(MobEffectCategory.HARMFUL,0)
            .addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "CB3F55D3-645C-4F38-A497-9C13A33DB5CF", 0.05, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> PHARAONS_CURSE = MOB_EFFECTS.register("curse_of_desert", () -> new FastFalling(MobEffectCategory.HARMFUL,0));
    public static final RegistryObject<MobEffect> FEAR = MOB_EFFECTS.register("fear", () -> new FastFalling(MobEffectCategory.HARMFUL,11141120));

    public static final RegistryObject<MobEffect> ANNIHILATION = MOB_EFFECTS.register("annihilation", () -> new Annihilation(MobEffectCategory.HARMFUL,0)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "CB3F55D3-645C-4F38-A497-9C13A33DB5CF", -0.1, AttributeModifier.Operation.MULTIPLY_TOTAL));//-0.125



    //public static final RegistryObject<MobEffect> MOVEMENT_SPEED = register(1, "speed", (new MobEffect(MobEffectCategory.BENEFICIAL, 3402751)).addAttributeModifier(Attributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", (double)0.2F, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

