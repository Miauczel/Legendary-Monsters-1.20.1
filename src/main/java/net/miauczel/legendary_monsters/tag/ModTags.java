package net.miauczel.legendary_monsters.tag;


import net.miauczel.legendary_monsters.LegendaryMonsters;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_DINOSAUR_BONE_TOOL = tag("needs_dinosaur_bone_tool");
        public static final TagKey<Block> NEEDS_VOID_TOOL = tag("needs_dinosaur_bone_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LegendaryMonsters.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(LegendaryMonsters.MOD_ID, name));
        }
    }
}
