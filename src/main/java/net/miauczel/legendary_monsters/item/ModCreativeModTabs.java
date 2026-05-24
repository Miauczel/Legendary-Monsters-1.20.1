package net.miauczel.legendary_monsters.item;

import net.miauczel.legendary_monsters.LegendaryMonsters;


import net.miauczel.legendary_monsters.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LegendaryMonstersMod = CREATIVE_MODE_TABS.register("legendary_monsterstab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DINOSAUR_BONE_SHIELD.get()))
                    .title(Component.translatable("creativetab.legendary_monsters"))
                    .displayItems((pParameters, pOutput) -> {
                        //Blocks

                        pOutput.accept(ModBlocks.INDESTRUCTIBLE_BLOCK.get());
                        pOutput.accept(ModBlocks.SWINGING_AXE.get());
                        pOutput.accept(ModBlocks.SOMBER_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SMALL_SPIKE_TRAP_BLOCK.get());
                        pOutput.accept(ModBlocks.BIG_SPIKE_TRAP_BLOCK.get());
                        pOutput.accept(ModBlocks.SOUL_CANDLE.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CHISELED_ANCIENT_DRIPSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_TILES.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_TILE_STAIRS.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_TILE_SLAB.get());
                        pOutput.accept(ModBlocks.ANCIENT_DRIPSTONE_TILE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_DIORITE_PILLAR.get());
                        pOutput.accept(ModBlocks.CHISELED_DIORITE.get());

                        pOutput.accept(ModBlocks.ENDERITIUM_ORE.get());
                        pOutput.accept(ModBlocks.ENDERITIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.ENDERSTONE.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_WALL.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_PILLAR.get());
                        pOutput.accept(ModBlocks.CHISELED_ENDERSTONE_PILLAR.get());

                        pOutput.accept(ModBlocks.COBBLED_ENDERSTONE.get());
                        pOutput.accept(ModBlocks.COBBLED_ENDERSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.COBBLED_ENDERSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.COBBLED_ENDERSTONE_WALL.get());

                        pOutput.accept(ModBlocks.ENDERSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CHISELED_ENDERSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.ENDERSTONE_BRICK_WALL.get());

                        pOutput.accept(ModBlocks.SMOOTH_ENDERSTONE.get());
                        pOutput.accept(ModBlocks.SMOOTH_ENDERSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.SMOOTH_ENDERSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.SMOOTH_ENDERSTONE_WALL.get());
                        pOutput.accept(ModBlocks.ANNIHILATION_LANTERN.get());
                        pOutput.accept(ModBlocks.ENDER_ANCHOR.get());
                        pOutput.accept(ModBlocks.TELEPORT_MACHINE.get());



                       // Items
                        pOutput.accept(ModItems.CHORUS_CRYSTAL.get());
                        pOutput.accept(ModItems.INFECTED_CHORUS_FRUIT.get());
                        pOutput.accept(ModItems.LARGE_SHULKER_SHELL.get());
                        pOutput.accept(ModItems.WARPED_MUSHROOM_CAP_PART.get());
                        pOutput.accept(ModItems.ENTITY_WARPER.get());
                        pOutput.accept(ModItems.VOID_ENTITY_WARPER.get());
                        pOutput.accept(ModItems.DINOSAUR_BONE.get());
                        pOutput.accept(ModBlocks.SKELETOSAURUS_EGG.get());
                        pOutput.accept(ModItems.WITHERED_BONE.get());
                        pOutput.accept(ModItems.WITHERED_HORN.get());
                        pOutput.accept(ModItems.LAVA_EATERS_SKIN.get());
                        pOutput.accept(ModItems.PRIMAL_ICE_SHARD.get());
                        pOutput.accept(ModItems.FROZEN_RUNE.get());

              //          pOutput.accept(ModItems.BOTTLED_LIGHTNING.get());
                        pOutput.accept(ModItems.AIR_RUNE.get());
                        pOutput.accept(ModItems.CLOUD_ROD.get());

                  //      pOutput.accept(ModItems.CLOUD_BREAD.get());

                  //      pOutput.accept(ModItems.DARK_CLOUD_BREAD.get());
                        pOutput.accept(ModItems.NATURE_CRYSTAL.get());

                        pOutput.accept(ModItems.LIVING_STONE.get());
                    //    pOutput.accept(ModItems.BRONZITE_INGOT.get());
                        pOutput.accept(ModItems.ANCIENT_SPIKE.get());
                        pOutput.accept(ModItems.CHISELED_ANCIENT_DRIPTONE_SHARD.get());
                        pOutput.accept(ModItems.MOLTEN_METAL_INGOT.get());
                        pOutput.accept(ModItems.KNIGHTS_SWORD_BLADE_HALF.get());
                        pOutput.accept(ModItems.LONG_STICK_HALF.get());

                        pOutput.accept(ModItems.SOMBER_KEY_RING.get());
                        pOutput.accept(ModItems.SOMBER_KEY_BLADE.get());
                        pOutput.accept(ModItems.SOMBER_KEY.get());
                        pOutput.accept(ModItems.METAL_DEBRIS.get());
                        pOutput.accept(ModItems.CORRUPTED_SOUL.get());
                        pOutput.accept(ModItems.KNIGHT_SUMMONER.get());
                        pOutput.accept(ModItems.DEACTIVATED_KNIGHT_SUMMONER.get());
                        pOutput.accept(ModItems.GUARD_SUMMONER.get());
                        pOutput.accept(ModItems.DEACTIVATED_GUARD_SUMMONER.get());
                        pOutput.accept(ModItems.ANCIENT_SANDSTONE_SHARD.get());
                        pOutput.accept(ModItems.CRYSTAL_OF_SANDSTORM.get());
                       // pOutput.accept(ModItems.RAW_ENDIRITIUM.get());
                        pOutput.accept(ModItems.ENDIRITIUM_GEM.get());
                        pOutput.accept(ModItems.ENDERITIUM_INGOT.get());

                        pOutput.accept(ModItems.ENDERITIUM_UPGRADE_TEMPLATE.get());
                        pOutput.accept(ModItems.ANNIHILATOR_UPGRADE_TEMPLATE.get());
                        pOutput.accept(ModItems.BOTTLE_OF_ANNIHILATION.get());
                        pOutput.accept(ModItems.EYE_CRYSTAL.get());
                        pOutput.accept(ModItems.PORTAL_SHARD.get());
//TOOL SETS
                        pOutput.accept(ModItems.ENDIRITIUM_SWORD.get());
                        pOutput.accept(ModItems.ENDIRITIUM_AXE.get());
                        pOutput.accept(ModItems.ENDIRITIUM_PICKAXE.get());
                        pOutput.accept(ModItems.ENDIRITIUM_SHOVEL.get());
                        pOutput.accept(ModItems.ENDIRITIUM_HOE.get());
                        //Weapons
                        pOutput.accept(ModItems.CHORUS_BLADE.get());
                        pOutput.accept(ModItems.DINOSAUR_BONE_CLUB.get());
                        pOutput.accept(ModItems.FIERY_JAW.get());
                        pOutput.accept(ModItems.WITHERED_SCYTHE.get());
                        pOutput.accept(ModItems.THE_GREAT_FROST.get());
                        pOutput.accept(ModItems.WAND_OF_CLOUDS.get());
                        pOutput.accept(ModItems.AXE_OF_LIGHTNING.get());
                        pOutput.accept(ModItems.MOSSY_HAMMER.get());

                     //   pOutput.accept(ModItems.BRONZITE_SWORD.get());
                      //  pOutput.accept(ModItems.BRONZITE_AXE.get());
                        pOutput.accept(ModItems.ANCHOR_HANDLE.get());
                        pOutput.accept(ModItems.MONSTROUS_ANCHOR.get());
                        pOutput.accept(ModItems.KNIGHTS_SWORD.get());
                        pOutput.accept(ModItems.GOLDEN_HALBERT.get());
                        pOutput.accept(ModItems.RESURRECTED_JAVELIN.get());
                        pOutput.accept(ModItems.SHATTERED_GREATSWORD.get());
                        pOutput.accept(ModItems.SOUL_GREAT_SWORD.get());
                        pOutput.accept(ModItems.HAND_CANNON.get());
                        pOutput.accept(ModItems.CHORUS_CANNON.get());
                        pOutput.accept(ModItems.ATOM_SPLITTER.get());
                        pOutput.accept(ModItems.TESSERACT.get());


                        //Armors
                        pOutput.accept(ModItems.CHORUS_MASK.get());
                        pOutput.accept(ModItems.SHULKER_HELMET.get());
                        pOutput.accept(ModItems.BLASTPROOF_HELMET.get());
                        pOutput.accept(ModItems.FIERY_BOOTS.get());
                        pOutput.accept(ModItems.ATMOSPHERIC_BOOTS.get());
                        pOutput.accept(ModItems.FIERY_BOOTS.get());
                        pOutput.accept(ModItems.WITHERED_RIBCAGE.get());
                        pOutput.accept(ModItems.MOSSY_CHESTPLATE.get());

                        pOutput.accept(ModItems.ANNIHILATOR_HELMET.get());
                        pOutput.accept(ModItems.ANNIHILATOR_CHESTPLATE.get());
                        pOutput.accept(ModItems.ANNIHILATOR_LEGGINGS.get());
                        pOutput.accept(ModItems.ANNIHILATOR_BOOTS.get());



                        //Shields
                        pOutput.accept(ModItems.SHULKER_SHIELD.get());
                        pOutput.accept(ModItems.DINOSAUR_BONE_SHIELD.get());
                        pOutput.accept(ModItems.FROSTBITTEN_SHIELD.get());
                        pOutput.accept(ModItems.SPIKY_SHIELD.get());
                        pOutput.accept(ModItems.BUCKLER_OF_ANNIHILATION.get());
                        //Eyes
                        pOutput.accept(ModItems.EYE_OF_CHORUS.get());
                        pOutput.accept(ModItems.EYE_OF_SHULKER.get());
                        pOutput.accept(ModItems.EYE_OF_BONES.get());
                        pOutput.accept(ModItems.EYE_OF_SOUL.get());
                        pOutput.accept(ModItems.EYE_OF_MAGMA.get());
                        pOutput.accept(ModItems.EYE_OF_FROST.get());
                        pOutput.accept(ModItems.EYE_OF_AIR.get());
                        pOutput.accept(ModItems.EYE_OF_MOSS.get());
                        pOutput.accept(ModItems.EYE_OF_MANY_RIBS.get());
                        pOutput.accept(ModItems.EYE_OF_GHOST.get());
                        pOutput.accept(ModItems.EYE_OF_SANDSTORM.get());
                        pOutput.accept(ModItems.EYE_OF_ANNIHILATION.get());

                        //Discs
                        pOutput.accept(ModItems.MUSIC_DISC_CLOUD_GOLEM.get());
                        pOutput.accept(ModItems.MUSIC_DISC_OBLITERATOR.get());
                        pOutput.accept(ModItems.MUSIC_DISC_POSSESSED_PALADIN.get());
                        //Eggs
                        pOutput.accept(ModItems.ENDERSENT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CHORUSLING_SPAWN_EGG.get());

                        pOutput.accept(ModItems.SHULKER_MIMIC_SPAWN_EGG.get());
                        pOutput.accept(ModItems.WARPED_FUNGUSSUS_SPAWN_EGG.get());

                        pOutput.accept(ModItems.SKELETOSAURUS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SKELORAPTOR_SPAWN_EGG.get());

                        pOutput.accept(ModItems.WITHERED_ABOMINATION_SPAWN_EGG.get());
                        pOutput.accept(ModItems.LAVA_EATER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FROSTBITTEN_GOLEM_SPAWN_EGG.get());

                        pOutput.accept(ModItems.STRATLING_SPAWN_EGG.get());
                        pOutput.accept(ModItems.HOVERING_HURRICANE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CLOUD_GOLEM_SPAWN_EGG.get());

                        pOutput.accept(ModItems.MOSSY_GOLEM_SPAWN_EGG.get());
                        pOutput.accept(ModItems.OVERGROWN_COLOSSUS_SPAWN_EGG.get());

                        pOutput.accept(ModItems.SPIKE_BUG_SPAWN_EGG.get());
                        pOutput.accept(ModItems.AMBUSHER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ANCIENT_GUARDIAN_SPAWN_EGG.get());

                        pOutput.accept(ModItems.HAUNTED_KNIGHT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.HAUNTED_GUARD_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FRACTURED_APOSTLE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FRACTURED_SPAWN_EGG.get());
                        pOutput.accept(ModItems.RESURRECTED_KNIGHT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BEHEADED_KNIGHT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.POSESSED_PALADIN_SPAWN_EGG.get());

                        pOutput.accept(ModItems.BOMBER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.DUNE_SENTINEL_SPAWN_EGG.get());

                        pOutput.accept(ModItems.WANDERING_EYE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FLAME_DRIFTER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FLAMEBORN_WARRIOR_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FLAMEBORN_GUARD_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ANNIHILATION_PURSUER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.THE_OBLITERATOR_SPAWN_EGG.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
