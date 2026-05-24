package net.miauczel.legendary_monsters.block;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.custom.*;
import net.miauczel.legendary_monsters.block.custom.SoulCandle.SoulCandleBlock;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BRICKS = registerBlock("ancient_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_ANCIENT_DRIPSTONE_BRICKS = registerBlock("chiseled_ancient_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BRICK_PILLAR = registerBlock("ancient_dripstone_brick_pillar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BLOCK = registerBlock("ancient_dripstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_TILES = registerBlock("ancient_dripstone_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BRICK_WALL = registerBlock("ancient_dripstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BRICK_SLAB = registerBlock("ancient_dripstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BRICK_STAIRS = registerBlock("ancient_dripstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ANCIENT_DRIPSTONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_TILE_SLAB = registerBlock("ancient_dripstone_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_TILE_STAIRS = registerBlock("ancient_dripstone_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.ANCIENT_DRIPSTONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final RegistryObject<Block> SKELETOSAURUS_EGG = registerBlock("skeletosaurus_egg",
            () -> new SkeletosaurusEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.5F).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_TILE_WALL = registerBlock("ancient_dripstone_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CLOUD_BLOCK = registerBlock("cloud_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.WOOL)
                    .strength(1f)));

    public static final RegistryObject<Block> CLOUD_BRICKS = registerBlock("cloud_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.WOOL)
                    .strength(1f)));

    public static final RegistryObject<Block> POLISHED_DIORITE_PILLAR = registerBlock("polished_diorite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE).sound(SoundType.STONE)
                    .strength(1f)));

    public static final RegistryObject<Block> CHISELED_DIORITE = registerBlock("chiseled_diorite",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE).sound(SoundType.STONE)
                    .strength(1f)));


    public static float enderstoneBlockStrenght = 2.5f;
    public static final RegistryObject<Block> ENDERITIUM_BLOCK = registerBlock("enderitium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)
                    .strength(50)));

    public static final RegistryObject<Block> ENDERSTONE_BRICKS = registerBlock("enderstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDERSTONE_BRICK_STAIRS = registerBlock("enderstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ENDERSTONE_BRICKS.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                            .strength(enderstoneBlockStrenght))));

    public static final RegistryObject<Block> ENDERSTONE_BRICK_SLAB = registerBlock("enderstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDERSTONE_BRICK_WALL = registerBlock("enderstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> CHISELED_ENDERSTONE_BRICKS = registerBlock("chiseled_enderstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> CHISELED_ENDERSTONE_PILLAR = registerBlock("chiseled_enderstone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDERSTONE_PILLAR = registerBlock("enderstone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));
    public static final RegistryObject<Block> ENDERITIUM_ORE = registerBlock("enderitium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));
    public static final RegistryObject<Block> ENDERSTONE = registerBlock("enderstone",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));
    public static final RegistryObject<Block> COBBLED_ENDERSTONE = registerBlock("cobbled_enderstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> SMOOTH_ENDERSTONE = registerBlock("smooth_enderstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));


    public static final RegistryObject<Block> SMOOTH_ENDERSTONE_STAIRS = registerBlock("smooth_enderstone_stairs",
            () -> new StairBlock(() -> ModBlocks.ENDERSTONE_BRICKS.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                            .strength(enderstoneBlockStrenght))));

    public static final RegistryObject<Block> SMOOTH_ENDERSTONE_SLAB = registerBlock("smooth_enderstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> SMOOTH_ENDERSTONE_WALL = registerBlock("smooth_enderstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> COBBLED_ENDERSTONE_STAIRS = registerBlock("cobbled_enderstone_stairs",
            () -> new StairBlock(() -> ModBlocks.ENDERSTONE_BRICKS.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                            .strength(enderstoneBlockStrenght))));

    public static final RegistryObject<Block> COBBLED_ENDERSTONE_SLAB = registerBlock("cobbled_enderstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> COBBLED_ENDERSTONE_WALL = registerBlock("cobbled_enderstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDERSTONE_STAIRS = registerBlock("enderstone_stairs",
            () -> new StairBlock(() -> ModBlocks.ENDERSTONE_BRICKS.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                            .strength(enderstoneBlockStrenght))));

    public static final RegistryObject<Block> ENDERSTONE_SLAB = registerBlock("enderstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDERSTONE_WALL = registerBlock("enderstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));
    public static final RegistryObject<Block> ANNIHILATION_LANTERN = registerBlock("annihilation_lantern",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN).sound(SoundType.STONE)
                    .strength(enderstoneBlockStrenght)));

    public static final RegistryObject<Block> ENDER_ANCHOR = registerBlock("ender_anchor",
            () -> new EnderAnchorBlock(BlockBehaviour.Properties.copy(Blocks.RESPAWN_ANCHOR).noOcclusion().sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> TELEPORT_MACHINE = registerBlock("teleport_machine",
            () -> new TeleportMachineBlock(BlockBehaviour.Properties.copy(Blocks.END_PORTAL_FRAME).noOcclusion().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> SWINGING_AXE = registerBlock("swinging_axe",
            () -> new SwingingAxeBlock(BlockBehaviour.Properties.copy(Blocks.END_PORTAL_FRAME).noOcclusion().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> SOMBER_TRAPDOOR = registerBlock("somber_trapdoor",
            () -> new SomberTrapdoorBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> INDESTRUCTIBLE_BLOCK = registerBlock("indestructible_block",
            () -> new IndestructibleBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SMALL_SPIKE_TRAP_BLOCK = registerBlock("small_spike_trap_block",
            () -> new SmallSpikeTrapBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BIG_SPIKE_TRAP_BLOCK = registerBlock("big_spike_trap_block",
            () -> new BigSpikeTrapBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_CANDLE = registerBlock("soul_candle",
            () -> new SoulCandleBlock(BlockBehaviour.Properties.copy(Blocks.CANDLE).sound(SoundType.CANDLE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
