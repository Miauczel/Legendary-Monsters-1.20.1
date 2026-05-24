package net.miauczel.legendary_monsters.datagen;


import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.EnderAnchorModel;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LegendaryMonsters.MOD_ID, exFileHelper);
    }

    private EnderAnchorModel model;
    @Override
    protected void registerStatesAndModels() {

simpleBlock(ModBlocks.ENDER_ANCHOR.get(), new ModelFile.UncheckedModelFile(modLoc("block/ender_anchor_0")) {
});

        simpleBlock(ModBlocks.TELEPORT_MACHINE.get(), new ModelFile.UncheckedModelFile(modLoc("block/ender_anchor_0")) {
        });
//Dripstone Bricks blocks
       stairsBlock(((StairBlock) ModBlocks.ANCIENT_DRIPSTONE_BRICK_STAIRS.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.ANCIENT_DRIPSTONE_BRICK_SLAB.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.ANCIENT_DRIPSTONE_BRICK_WALL.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get()));
//Dripstone Tiles blocks

        stairsBlock(((StairBlock) ModBlocks.ANCIENT_DRIPSTONE_TILE_STAIRS.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_TILES.get()));
        slabBlock(((SlabBlock) ModBlocks.ANCIENT_DRIPSTONE_TILE_SLAB.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_TILES.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_TILES.get()));
        wallBlock(((WallBlock) ModBlocks.ANCIENT_DRIPSTONE_TILE_WALL.get()), blockTexture(ModBlocks.ANCIENT_DRIPSTONE_TILES.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
