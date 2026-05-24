package net.miauczel.legendary_monsters.datagen;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

        public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                                   CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_275343_, p_275729_, p_275322_, LegendaryMonsters.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            this.tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(ModItems.MOSSY_CHESTPLATE.get())
                    .add(ModItems.ATMOSPHERIC_BOOTS.get())
                    .add(ModItems.FIERY_BOOTS.get())
                    .add(ModItems.BLASTPROOF_HELMET.get())
                    .add(ModItems.CHORUS_MASK.get())
                    .add(ModItems.ANNIHILATOR_HELMET.get())
                    .add(ModItems.ANNIHILATOR_CHESTPLATE.get())
                    .add(ModItems.ANNIHILATOR_LEGGINGS.get())
                    .add(ModItems.ANNIHILATOR_BOOTS.get());

this.tag(ItemTags.TRIM_TEMPLATES).add(ModItems.ENDERITIUM_UPGRADE_TEMPLATE.get());
this.tag(ItemTags.MUSIC_DISCS)
        .add(ModItems.MUSIC_DISC_CLOUD_GOLEM.get())
        .add(ModItems.MUSIC_DISC_OBLITERATOR.get());
        }
    }

